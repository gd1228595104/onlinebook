package mapper;


import bean.TEvaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TEvaluateMapper {
    /**
     *描述：评价功能
     *参数：[TEvaluate]
     *返回类型：int
     *创建者：ice
     *创建时间：2019/02/16 16:46
    */
    int insertTEvaluate(TEvaluate tEvaluate);

    /**
     *描述：查看自己对别人的评价
     *参数：Long evaluatorId
     *返回类型：List
     *创建者：ice
     *创建时间：2019/02/16 16:48
    */
    List<TEvaluate> selectTEvaluateToOther(Long evaluatorId);

    /**
     *描述：查看别人对自己的评价
     *参数：Long beevaluatorId
     *返回类型：List
     *创建者：ice
     *创建时间：2019/02/16 16:48
     */
    List<TEvaluate> selectTEvaluateToOwn(Long beevaluatorId);

    /**
     *描述：删除对别人的评价
     *参数：Integer evaid,评价表编号
     *返回类型：int
     *创建者：ice
     *创建时间：2019/02/16 22:31
    */
    int deleteTEvaluation(Integer evaid);

    /**
     *描述：修改自己对别人的评价
     *参数：Integer evaid, String evaluation, Integer evaluatescore
     *返回类型：int
     *创建者：ice
     *创建时间：2019/03/05 8:31
    */
    int updateTEvaluation(@Param("evaid") Integer evaid, @Param("evaluation") String evaluation, @Param("evaluatescore") Integer evaluatescore);


}