package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.BorrowService;

@RestController
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    /**
     *描述：申请借书功能，首先判断积分是否足够，足够则申请成功并将发送邮箱提醒借书人
     *参数：Integer bookid
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/17 16:50
    */
    @RequestMapping(value = "/RequestingBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String RequestingBook(Integer bookid){
        return borrowService.requestingBook(bookid);
    }

    /**
     *描述：查看自己待借入的书籍
     *参数：Integer currPage,Integer pageSize
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/18 21:57
    */
    @RequestMapping(value = "/FindBorrowBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindBorrowBook(Integer currPage,Integer pageSize){
        return borrowService.findBorrowBook(currPage,pageSize);
    }

    /**
     *描述：查看自己待借出的书籍
     *参数：Integer currPage,Integer pageSize
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/18 21:59
    */
    @RequestMapping(value = "/FindLendBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindLendBook(Integer currPage,Integer pageSize){
        return borrowService.findLendBook(currPage,pageSize);
    }

    /**
     *描述：查看自己已借入的书籍
     *参数：Integer currPage，Integer pageSize
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/19 10:47
    */
    @RequestMapping(value = "/BorrowedBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String BorrowedBook(Integer currPage,Integer pageSize){
        return borrowService.BorrowedBook(currPage,pageSize);
    }

    /**
     *描述：查看自己已借出的书籍
     *参数：Integer currPage，Integer pageSize
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/19 14:54
    */
    @RequestMapping(value = "/LendedBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String LendedBook(Integer currPage,Integer  pageSize){
        return borrowService.lendedBook(currPage,pageSize);
    }

    /**
     *描述：不同意借出书籍(删除交换记录,将书籍状态从待借改回可借)
     *参数：Integer eid,Integer bookid
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/23 14:43
    */
    @RequestMapping(value = "/DisagreedLend",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String DisagreedLend(Integer eid,Integer bookid){
        return borrowService.disagreedLend(eid, bookid);
    }

    /**
     *描述：确认借书，设置还书日期，系统自动倒计时，（e改为待确定）
     *参数：Integer bookid,String stoptime
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/23 15:34
    */
     @RequestMapping(value = "/SureLend",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String SureLend(Integer bookid,String stoptime){
         return borrowService.sureLend(bookid, stoptime);
     }

     /**
      *描述：确认借入，修改书籍状态，积分加减（e改为未还，i改为已借）
      *参数：Integer bookid,Long sid
      *返回类型：String
      *创建者：ice
      *创建时间：2019/03/23 15:56
     */
     @RequestMapping(value = "/SureBorrow",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String SureBorrow(Integer bookid,Long sid){
         return borrowService.sureBorrow(bookid, sid);
     }

     /**
      *描述：延长借书日期
      *参数：Integer bookid
      *返回类型：String
      *创建者：ice
      *创建时间：2019/03/23 19:46
     */
     @RequestMapping(value = "/LengthenTime",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String LengthenTime(Integer bookid,String stoptime){
         return borrowService.lengthenTime(bookid, stoptime);
     }

     /**
      *描述：借入者确认还书
      *参数：Integer eid
      *返回类型：String
      *创建者：ice
      *创建时间：2019/03/23 20:24
     */
     @RequestMapping(value = "/ReturnExcBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String ReturnExcBook(Integer eid){
         return borrowService.returnExcBook(eid);
     }

     /**
      *描述：借出者确认还书
      *参数：Integer bookid
      *返回类型：String
      *创建者：ice
      *创建时间：2019/03/23 21:16
     */
     @RequestMapping(value = "/ReturnInaBook",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String ReturnInaBook(Integer bookid){
         return borrowService.returnInaBook(bookid);
     }
}
