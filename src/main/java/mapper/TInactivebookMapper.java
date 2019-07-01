package mapper;


import bean.TInactivebook;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TInactivebookMapper {

    //发布闲置书籍
    int insertTinactivebook(TInactivebook tInactivebook);
    //提示书籍分类
    List<Map<String,String>> findBookclass(@Param("bookname") String bookname, @Param("author") String author, @Param("publisher") String publisher);
    //查看自己发布的闲置书籍
    List<TInactivebook> findPublishedInaBook(Long loanerId);
    //将闲置书籍状态修改为待借
    int updateBookStatusForWait(Integer bookid);
    //将闲置书籍状态修改为已借
    int updateBookStatusLended(Integer bookid);
    //将书籍状态修改为可借
    int updateBookStatusCanLend(Integer bookid);

    //根据书名模糊查询书籍
    List<TInactivebook> findTInactivebook(@Param("context") String context);
}