package service.serviceImpl;


import api.Response;
import bean.TEvaluate;
import com.alibaba.fastjson.JSON;
import mapper.TEvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.EvaluateService;
import javax.servlet.http.HttpSession;


@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private TEvaluateMapper tEvaluateMapper;
    @Autowired
    private HttpSession httpSession;

    /**
     *描述：评价功能
     *参数：[TEvaluate]
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/02/15 11:28
    */
    @Override
    public String evaluate(TEvaluate tEvaluate) {
        tEvaluateMapper.insertTEvaluate(tEvaluate);
        return JSON.toJSONString(new Response("评价成功",1));
    }

    /**
     *描述：用户查看自己对别人的评价
     *参数：evaluatorId,从session中取出
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/02/16 16:45
    */
    @Override
    public String findEvaluation() {
          Long evaluateId = (Long) httpSession.getAttribute("sid");
        return JSON.toJSONString(new Response(tEvaluateMapper.selectTEvaluateToOther(evaluateId),1));
    }

    /**
     *描述：查看别人对自己的评价
     *参数：beevaluatorId,从session中取出
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/02/16 17:05
    */
    @Override
    public String findBeEvaluation() {
        Long beevaluateId = (Long) httpSession.getAttribute("sid");
        return JSON.toJSONString(new Response(tEvaluateMapper.selectTEvaluateToOwn(beevaluateId),1));
    }

    /**
     *描述：删除对别人的评价
     *参数：Integer evaid
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/02/16 22:32
    */
    @Override
    public String deleteTEvaluation(Integer evaid) {
        tEvaluateMapper.deleteTEvaluation(evaid);
        return JSON.toJSONString(new Response("删除成功",1));
    }

    /**
     *描述：修改自己对别人的评价
     *参数：Integer evaid, String evaluation, Integer evaluatescore
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/05 8:30
    */
    @Override
    public String changeEvaluation(Integer evaid, String evaluation, Integer evaluatescore) {
        tEvaluateMapper.updateTEvaluation(evaid,evaluation,evaluatescore);
        return JSON.toJSONString(new Response("修改成功",1));
    }

}
