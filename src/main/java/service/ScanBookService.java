package service;


import org.springframework.stereotype.Service;

@Service
public interface ScanBookService {
    //从搜索框中查找书籍
    String searchBar(String condition,String context,Integer currPage,Integer pageSize);
    //跳转到书籍详情页面
    String findInaBookInfo(Integer bookid);
    //首页显示所有书籍
    String findAllInaBook(Integer currPage,Integer pageSize);
    //查看结果某本书籍的人的信息
    String findHaveBorrowthisBook(Integer bookid);
}
