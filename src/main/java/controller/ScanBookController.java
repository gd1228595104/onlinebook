package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ScanBookService;

@RestController
public class ScanBookController {

    @Autowired
    private ScanBookService scanBookService;

    /**
     *描述：根据书名/作者从搜索框中查找书籍
     *参数：String condition,Sring context
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/23 21:23
    */
    @RequestMapping(value = "/SearchBar",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String SearchBar(String condition,String context,Integer currPage,Integer pageSize) {
        return scanBookService.searchBar(condition,context,currPage,pageSize);
    }

   /**
    *描述：跳转到书籍详情页面
    *参数：Integer bookid
    *返回类型：String
    *创建者：ice
    *创建时间：2019/04/18 21:14
   */
   @RequestMapping(value = "/FindInaBookInfo",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindInaBookInfo(Integer bookid){
       return scanBookService.findInaBookInfo(bookid);
   }

   /**
    *描述：显示首页全部闲置书籍
    *参数：Integer currPage,Integer pageSize
    *返回类型：
    *创建者：ice
    *创建时间：2019/04/18 21:24
   */
   @RequestMapping(value = "/FindAllInaBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindAllInaBook(Integer currPage,Integer pageSize){
       return scanBookService.findAllInaBook(currPage, pageSize);
   }

   /**
    *描述：查看借过改本书籍的人
    *参数：Integer bookid
    *返回类型：String
    *创建者：ice
    *创建时间：2019/04/18 21:50
   */
   @RequestMapping(value = "/FindHaveBorrowthisBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
   public String FindHaveBorrowthisBook(Integer bookid){
       return scanBookService.findHaveBorrowthisBook(bookid);
   }
}
