package mapper;


import bean.THopebook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface THopebookMapper {
    //发布希望书籍
    int insertHopeBookList(List<THopebook> list);
    //查看自己发布的希望书籍
    List<THopebook> findHopeBook(Long sid);

}