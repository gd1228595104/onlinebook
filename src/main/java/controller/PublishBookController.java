package controller;

import bean.TBook;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.PublishBookService;

import java.util.List;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-14 20:37
 */
@RestController
public class PublishBookController {

    @Autowired
    private PublishBookService publishBookService;

    /**
     *描述：发布闲置书籍
     *参数：Integer cid,String bookname,MultipartFile file
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/14 20:38
    */
    @RequestMapping(value = "/PublishInaBook",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ModelAndView PublishInaBook(Integer cid, String bookName1, MultipartFile file){
        publishBookService.publishInaBook(cid, bookName1, file);
        ModelAndView mv = new ModelAndView("release.html");
        return mv;
    }

    /**
     *描述：在发布闲置书籍时不清楚书籍分类的提供提示的辅助模块
     *参数：
     *返回类型：
     *创建者：ice
     *创建时间：2019/03/14 21:52
    */
    @RequestMapping(value = "/PromptBookClass",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String PromptBookClass(String bookname,String author,String publisher){
        return publishBookService.promptBookClass(bookname, author, publisher);
    }

    /**
     *描述：查看自己发布的闲置书籍
     *参数：无
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/16 16:35
    */
    @RequestMapping(value = "/FindPublishedInaBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindPublishedInaBook(Integer currPage, Integer pageSize){
        return publishBookService.findPublishedInaBook(currPage, pageSize);
    }

    /**
     *描述：发布希望书籍
     *参数：List<TBook> bookList
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/16 19:56
    */
    @RequestMapping(value = "/PublishHopeBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String PublishHopeBook(String booklist){
        List<TBook> bookList = JSON.parseArray(booklist,TBook.class);
        return publishBookService.publishHopeBook(bookList);
    }

    /**
     *描述：查看自己发布的希望书籍
     *参数：无
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/16 22:04
    */
    @RequestMapping(value = "/FindPublishedHopeBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindPublishedHopeBook(Integer currPage,Integer pageSize){return publishBookService.findHopeBook(currPage,pageSize);}

    /**
     *获取书籍的所有种类，显示到下拉框中
     * @return String
     * @Author Dawn
     */
    @RequestMapping(value = "getAllBookClass",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String getAllBookClass(int param){
        return publishBookService.getAllbookClass(param);
    }

    /**
     * 获取书籍信息
     * @param cid
     * @param currPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "getBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String getBook(int cid,int currPage,int pageSize){
        return publishBookService.getBookByCid(cid,currPage,pageSize);
    }
}
