package mapper;


import bean.TBookclass;

import java.util.List;

public interface TBookclassMapper {

    List<TBookclass> getBookTypes(int param);

    //图书分类显示
    List<TBookclass> bookclass();

}