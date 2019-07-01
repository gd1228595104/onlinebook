package service;

import org.springframework.stereotype.Service;

@Service
public interface BorrowService {
    /**
     *描述：申请借书，需判断积分是否足够
     *参数：Integer bookid
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/17 17:14
    */
    String requestingBook(Integer bookid);

    /**
     *描述：查看自己待借入的书籍
     *参数：Integer currPage，Integer pageSize
     *返回类型：json
     *创建者：ice
     *创建时间：2019/03/18 21:47
    */
   String findBorrowBook(Integer currPage,Integer pageSize);

   /**
    *描述：查看自己待借出的书籍
    *参数：Integer currPage,Integer pageSize
    *返回类型：json
    *创建者：ice
    *创建时间：2019/03/18 21:48
   */
   String findLendBook(Integer currPage,Integer pageSzie);

   /**
    *描述：查看自己已借入的书籍
    *参数：Integer currPage，Integer pageSize
    *返回类型：json
    *创建者：ice
    *创建时间：2019/03/19 10:44
   */
   String BorrowedBook(Integer currPage,Integer pageSize);

   /**
    *描述：查看自己已借出的书籍
    *参数：Integer currPage,Integer pageSize
    *返回类型：json
    *创建者：ice
    *创建时间：2019/03/19 14:51
   */
   String lendedBook(Integer currPage,Integer pageSize);

   /**
    *描述：不同意借出书籍
    *参数：Integer eid,Integer bookid
    *返回类型：
    *创建者：ice
    *创建时间：2019/03/23 14:46
   */
   String disagreedLend(Integer eid,Integer bookid);
   
   /**
    *描述：确认借书，设置还书日期，系统自动倒计时，并将e的书籍状态修改为待确定
    *参数：Integer bookid,String stoptime
    *返回类型：String
    *创建者：ice
    *创建时间：2019/03/23 15:42
   */
   String sureLend(Integer bookid,String stoptime);

   /**
    *描述：确认借入，修改书籍状态，积分加减（e改为未还，i改为已借）
    *参数：Integer bookid,,Long sid
    *返回类型：String
    *创建者：ice
    *创建时间：2019/03/23 16:01
   */
   String sureBorrow(Integer bookid,Long sid);

   /**
    *描述：延长借书日期
    *参数：Integer bookid
    *返回类型：String
    *创建者：ice
    *创建时间：2019/03/23 19:47
   */
   String lengthenTime(Integer bookid,String stoptime);
   
   /**
    *描述：借入者确认还书，将交换表书籍状态改为已还
    *参数：Integer eid
    *返回类型：String
    *创建者：ice
    *创建时间：2019/03/23 20:44
   */
   String returnExcBook(Integer eid);

   /**
    *描述：借出者确认还书，将闲置书籍状态修改为可借
    *参数：Integer bookid
    *返回类型：String
    *创建者：ice
    *创建时间：2019/03/23 21:17
   */
   String returnInaBook(Integer bookid);
}
