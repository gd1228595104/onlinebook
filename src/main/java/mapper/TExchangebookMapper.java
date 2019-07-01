package mapper;


import bean.TExchangebook;
import bean.vo.TExchangebookVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TExchangebookMapper {
   /**
    *描述：将书籍交换记录在交换表中
    *参数：TExchangebook
    *返回类型：int
    *创建者：ice
    *创建时间：2019/03/17 19:48
   */
   int insertTExchangebook(TExchangebook tExchangebook);

   /**
    *描述：删除交换表中的记录
    *参数：Integer eid
    *返回类型：int
    *创建者：ice
    *创建时间：2019/03/23 14:51
    */
   int deleteTExchangeBook(Integer eid);

   /**
    *描述：确认还书，设置还书日期并修改书籍状态
    *参数：Integer bookid
    *返回类型：int
    *创建者：ice
    *创建时间：2019/03/23 15:49
   */
   int updateTExchangeSureLend(@Param("bookid") Integer bookid, @Param("stoptime") String stoptime);

   //修改书籍状态为未还，并记录开始借书时间
   int updateTExchangeHadLend(@Param("bookid")Integer bookid);

   //延长借书日期
   int updateBorrowTime(@Param("bookid") Integer bookid,@Param("stoptime") String stoptime);

   //借入者确认还书
   int updatereturnExcBook(@Param("eid")Integer eid);

   //查看借过某本书籍的人的情况
   List<TExchangebook> findHaveBorrowthisBook(@Param("bookid") Integer bookid);

}