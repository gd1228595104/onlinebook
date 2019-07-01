package mapper.mapperVo;

import java.util.List;
import bean.vo.TExchangebookVo;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-18 20:13
 */
public interface TExchangebookVoMapper {
    /**
     *描述：查看待借入的书籍
     *参数：Long borrowerId
     *返回类型：List<TExchangebookVo>
     *创建者：ice
     *创建时间：2019/03/18 19:51
     */
    List<TExchangebookVo> findBorrowBook(Long borrowerId);

    /**
     *描述：查看自己待借出的书籍
     *参数：Long loanerId
     *返回类型：List<TExchangebookVo>
     *创建者：ice
     *创建时间：2019/03/19 10:42
    */
    List<TExchangebookVo> findLendBook(Long loanerId);

    /**
     *描述：查看自己已借入的书籍
     *参数：Long borrowerId
     *返回类型：List<TExchangebookVo>
     *创建者：ice
     *创建时间：2019/03/19 10:43
    */
    List<TExchangebookVo> findBorrowedBook(Long borrowerId);

    /**
     *描述：查看自己已借出的书籍
     *参数：Long loanerId
     *返回类型：List<TExchangebookVo>
     *创建者：ice
     *创建时间：2019/03/19 14:50
    */
    List<TExchangebookVo> findLendedBook(Long loanerId);
}
