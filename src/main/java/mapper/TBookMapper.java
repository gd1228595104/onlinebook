package mapper;


import bean.TBook;
import bean.TBookclass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBookMapper {
    List<TBook> searchBar(@Param("bookname")String bookname);
    //List<TBookclass> getBookTypes();
    List<TBook> navigationBar(String classname);

    List<TBook> findBookbyCid(int cid);
}