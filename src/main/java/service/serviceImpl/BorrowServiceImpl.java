package service.serviceImpl;

import api.Response;
import bean.TExchangebook;
import bean.TPoints;
import bean.vo.TExchangebookVo;
import com.alibaba.fastjson.JSON;
import mapper.TExchangebookMapper;
import mapper.TInactivebookMapper;
import mapper.TPointsMapper;
import mapper.TStudentMapper;
import mapper.mapperVo.TExchangebookVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BorrowService;

import javax.servlet.http.HttpSession;
import java.util.List;
import static util.PageUtil.Page;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private TStudentMapper tStudentMapper;
    @Autowired
    private TInactivebookMapper tInactivebookMapper;
    @Autowired
    private TExchangebookMapper tExchangebookMapper;
    @Autowired
    private TExchangebookVoMapper tExchangebookVoMapper;
    @Autowired
    private TPointsMapper tPointsMapper;
    @Autowired
    private HttpSession httpSession;

    @Override
    public String requestingBook(Integer bookid) {
        //先判断积分是否足够
        Long sid = (Long) httpSession.getAttribute("sid");
        String name = (String) httpSession.getAttribute("name");
        int points = tStudentMapper.selectPoints(sid);
        if(points<5){
            return JSON.toJSONString("积分不足，不能够申请");
        }else {
            //积分足够，将书籍状态修改为待借，并将此以邮箱形式发给借书人
            tInactivebookMapper.updateBookStatusForWait(bookid);
            //发送邮箱功能

            //将交换书籍记录在交换表
            TExchangebook tExchangebook = new TExchangebook();
            tExchangebook.setBookid(bookid);
            tExchangebook.setBorrowerId(sid);
            tExchangebook.setBorrowerName(name);
            tExchangebook.setStatus("待通过");
            tExchangebookMapper.insertTExchangebook(tExchangebook);
            return JSON.toJSONString(new Response("申请成功！",1));
        }
    }

    @Override
    public String findBorrowBook(Integer currPage,Integer pageSize) {
        Long sid = (Long) httpSession.getAttribute("sid");
        List<TExchangebookVo> list = tExchangebookVoMapper.findBorrowBook(sid);
        return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
    }

    @Override
    public String findLendBook(Integer currPage, Integer pageSzie) {
        Long sid = (Long) httpSession.getAttribute("sid");
        List<TExchangebookVo> list = tExchangebookVoMapper.findLendBook(sid);
        return JSON.toJSONString(new Response(Page(currPage,pageSzie,list),list.size()));
    }

    @Override
    public String BorrowedBook(Integer currPage, Integer pageSize) {
        Long sid = (Long) httpSession.getAttribute("sid");
        List<TExchangebookVo> list = tExchangebookVoMapper.findBorrowedBook(sid);
        return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
    }

    @Override
    public String lendedBook(Integer currPage, Integer pageSize) {
        Long sid = (Long) httpSession.getAttribute("sid");
        List<TExchangebookVo> list = tExchangebookVoMapper.findLendedBook(sid);
        return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
    }

    @Override
    public String disagreedLend(Integer eid, Integer bookid) {
        //删除书籍交换表中的记录
        tExchangebookMapper.deleteTExchangeBook(eid);
        //修改闲置书籍中图书的状态，将状态从待借修改回可借
        tInactivebookMapper.updateBookStatusCanLend(bookid);
        return JSON.toJSONString(new Response("不同意借出书籍",1));
    }

    @Override
    public String sureLend(Integer bookid,String stoptime) {
        //确认借书，设置还书日期，并将书籍状态修改为待确定
        tExchangebookMapper.updateTExchangeSureLend(bookid,stoptime);
        return JSON.toJSONString(new Response("确认借书成功",1));
    }

    @Override
    public String sureBorrow(Integer bookid,Long sid) {
        //获取借入者的学号
        Long sid1 = (Long) httpSession.getAttribute("sid");
        //确认借书书籍，修改i的书籍状态为已借
         tInactivebookMapper.updateBookStatusLended(bookid);
        //e的书籍状态为未还，并记录开始借书时间
        tExchangebookMapper.updateTExchangeHadLend(bookid);
        //借出者的积分加5分，并记录到积分变换表
        tStudentMapper.updateAddPoints(sid);
        tPointsMapper.insertAddTPoints(sid);
        //借入者积分减5分，并记录到积分变换表
        tStudentMapper.updateReducePoints(sid1);
        tPointsMapper.insertReduceTPoints(sid1);
        return JSON.toJSONString(new Response("借书成功",1));
    }

    @Override
    public String lengthenTime(Integer bookid,String stoptime) {
        tExchangebookMapper.updateBorrowTime(bookid, stoptime);
        return JSON.toJSONString(new Response("修改还书时间成功",1));
    }

    @Override
    public String returnExcBook(Integer eid) {
        tExchangebookMapper.updatereturnExcBook(eid);
        return JSON.toJSONString(new Response("确认还书成功",1));
    }

    @Override
    public String returnInaBook(Integer bookid) {
        tInactivebookMapper.updateBookStatusCanLend(bookid);
        return JSON.toJSONString(new Response("确认对方还书成功",1));
    }


}
