package service.serviceImpl;

import api.Response;
import bean.TBook;
import bean.TBookclass;
import bean.THopebook;
import bean.TInactivebook;
import bean.vo.TInactivebookVo;
import com.alibaba.fastjson.JSON;
import mapper.TBookMapper;
import mapper.TBookclassMapper;
import mapper.THopebookMapper;
import mapper.TInactivebookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.PublishBookService;
import util.FileUploadUtil;
import util.PageUtil;

import javax.servlet.http.HttpSession;

import static util.PageUtil.Page;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-14 20:40
 */
@Service
public class PublishBookServiceImpl implements PublishBookService {

    @Autowired
    private TInactivebookMapper tInactivebookMapper;
    @Autowired
    private THopebookMapper tHopebookMapper;
    @Autowired
    private TBookclassMapper tBookclassMapper;
    @Autowired
    private TBookMapper tBookMapper;
    @Autowired
    private HttpSession httpSession;

    @Override
    public String publishInaBook(Integer cid,String bookname,MultipartFile file) {
       //从session中取出学号以及姓名
       Long loaner_id = (Long) httpSession.getAttribute("sid");
       String loaner_name = (String) httpSession.getAttribute("name");
        //bookid第一位为书籍分类，接下来的7位为随机数字，总共8位
        Integer bookid = cid*1000000 + (int)((Math.random()*9+1)*1000000);
        TInactivebook tInactivebook = new TInactivebook();
        //获取图片的存储路径
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        String filename = fileUploadUtil.fileUpload(file);
        tInactivebook.setBookid(bookid);
        tInactivebook.setInactivebookname(bookname);
        tInactivebook.setLoanerId(loaner_id);
        tInactivebook.setLoanerName(loaner_name);
        tInactivebook.setStatus("可借");
        tInactivebook.setPhoto(filename);
        tInactivebookMapper.insertTinactivebook(tInactivebook);
        return JSON.toJSONString(new Response("发布闲置书籍成功！",1));
    }

    @Override
    public String promptBookClass(String bookname, String author, String publisher) {
        return JSON.toJSONString(new Response(tInactivebookMapper.findBookclass(bookname, author, publisher),1));
    }

    @Override
    public String findPublishedInaBook(Integer currPage,Integer pageSize) {
        Long loaderId = (Long) httpSession.getAttribute("sid");
        List<TInactivebook> list = tInactivebookMapper.findPublishedInaBook(loaderId);
        return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
    }

    @Override
    public String publishHopeBook(List<TBook> bookList) {
        Long sid = (Long) httpSession.getAttribute("sid");
        List<THopebook> hopebookList = new ArrayList<>();
        for (TBook book:bookList) {
            THopebook tHopebook = new THopebook();
            tHopebook.setHopeid(book.getCid()*10000000 + (int)((Math.random()*9+1)*1000000));
            tHopebook.setSid(sid);
            tHopebook.setHopebookname(book.getBookname());
            tHopebook.setAuthor(book.getAuthor());
            hopebookList.add(tHopebook);
        }
        tHopebookMapper.insertHopeBookList(hopebookList);
        return JSON.toJSONString(new Response("发布希望书籍成功",1));
    }

    @Override
    public String findHopeBook(Integer currPage,Integer pageSize) {
       Long sid = (Long) httpSession.getAttribute("sid");;
       List<THopebook> list = tHopebookMapper.findHopeBook(sid);
        return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
    }

    @Override
    public String getAllbookClass(int param) {
        List<TBookclass> list = tBookclassMapper.getBookTypes(param);
        return JSON.toJSONString(new Response(list,list.size()));
    }

    @Override
    public String getBookByCid(int cid,int currPage,int pageSize) {
        List<TBook> list = tBookMapper.findBookbyCid(cid);
        return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
    }
}
