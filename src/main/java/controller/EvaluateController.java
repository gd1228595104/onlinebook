package controller;

import bean.TEvaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.EvaluateService;


@RestController
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    /**
     *描述：评价功能
     *参数：[tEvaluate]
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/02/15 11:25
     */
    @RequestMapping(value = "/Evaluate",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String Evaluate(TEvaluate tEvaluate){
        return evaluateService.evaluate(tEvaluate);
    }

    /**
     *描述：用户查看自己对别人的评价
     *参数：evaluatorId，从session中取出
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/02/16 16:43
    */
    @RequestMapping(value = "/FindEvaluation",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindEvaluation(){
        return evaluateService.findEvaluation();
    }

    /**
     *描述：查看别人对自己的评价
     *参数：beevaluatorId,直接从session中取出即可
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/02/16 17:08
    */
    @RequestMapping(value = "/FindBeEvaluation",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindBeEvaluation(){
        return evaluateService.findBeEvaluation();
    }

    /**
     *描述：删除对别人的评价
     *参数：Integer evaid
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/02/16 22:35
    */
    @RequestMapping(value = "/DeleteEvaluation",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String  DeleteEvaluation(Integer evaid){
        return evaluateService.deleteTEvaluation(evaid);
    }

    /**
     *描述：修改自己对别人的评价
     *参数：Integer evaid,String evaluation,Integer evaluatescore
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/05 8:12
    */
    @RequestMapping(value = "/ChangeEvaluation",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String ChangeEvaluation(Integer evaid,String evaluation,Integer evaluatescore){
        return evaluateService.changeEvaluation(evaid, evaluation, evaluatescore);
    }
}
