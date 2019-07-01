package service;

import bean.TBook;
import bean.vo.TInactivebookVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface PublishBookService {
   String publishInaBook(Integer cid,String bookname,MultipartFile file);
   String promptBookClass(String bookname,String author,String publisher);
   String findPublishedInaBook(Integer currPage,Integer pageSize);
   String publishHopeBook(List<TBook> bookList);
   String findHopeBook(Integer currPage,Integer pageSize);

   /**
    * 获取所有书籍的种类
    * @return
    */
   String getAllbookClass(int param);

   String getBookByCid(int cid,int currPage,int pageSize);
}
