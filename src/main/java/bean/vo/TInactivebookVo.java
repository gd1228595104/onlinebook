package bean.vo;

import bean.TBook;
import bean.TExchangebook;
import bean.TInactivebook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-06 09:46
 */
public class TInactivebookVo extends TInactivebook{
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
