package service.serviceImpl;

import api.Response;
import bean.TExchangebook;
import bean.TInactivebook;
import bean.vo.TInactivebookVo;
import com.alibaba.fastjson.JSON;
import mapper.TExchangebookMapper;
import mapper.TInactivebookMapper;
import mapper.mapperVo.TInactivebookVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ScanBookService;

import java.util.List;
import static util.PageUtil.Page;

@Service
public class ScanBookServiceImpl implements ScanBookService {

    @Autowired
    private TInactivebookVoMapper tInactivebookVoMapper;
    @Autowired
    private TInactivebookMapper tInactivebookMapper;
    @Autowired
    private TExchangebookMapper tExchangebookMapper;

    @Override
    public String searchBar(String condition,String context,Integer currPage,Integer pageSize) {
        if("书名".equals(condition)){
            List<TInactivebook> list = tInactivebookMapper.findTInactivebook(context);
            return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
        }
        if("作者".equals(condition)){
            List<TInactivebookVo> list = tInactivebookVoMapper.findBookByAuthor(context);
            return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
        }else {
            return JSON.toJSONString(new Response("对不起，找不到该书籍",0));
        }
    }

    @Override
    public String findInaBookInfo(Integer bookid) {
        return JSON.toJSONString(new Response(tInactivebookVoMapper.findInaBookInfo(bookid),1));
    }

    @Override
    public String findAllInaBook(Integer currPage, Integer pageSize) {
        List<TInactivebookVo> list = tInactivebookVoMapper.findAllInaBook();
        return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
    }

    @Override
    public String findHaveBorrowthisBook(Integer bookid) {
        List<TExchangebook> list = tExchangebookMapper.findHaveBorrowthisBook(bookid);
        return JSON.toJSONString(new Response(list,list.size()));
    }
}
