package mapper.mapperVo;

import bean.vo.TInactivebookVo;
import bean.vo.TinaBookClassVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-23 22:36
 */
public interface TInactivebookVoMapper {
   List<TInactivebookVo> findBookByAuthor(@Param("author") String author);

   List<TinaBookClassVo> findInaBookInfo(@Param("bookid")Integer bookid);

   List<TInactivebookVo> findAllInaBook();
}
