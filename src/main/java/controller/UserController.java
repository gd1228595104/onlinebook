package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.io.UnsupportedEncodingException;

/**
 * 描述：后台管理用户查询模块
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-07 17:36
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *描述：查看用户信息，根据选择的条件以及输入的内容查找
     *参数：String condition,String context,int currPage
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/12 22:00
    */
    @RequestMapping(value = "/FindUser",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindUser(String condition,String context,Integer currPage,Integer pageSize){
        return userService.findUser(condition, context, currPage,pageSize);
    }
    
    /**
     *描述：在查询用户信息时根据选择的条件返回可选择的条件列表
     *参数：String condition
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/12 22:01
    */
    @RequestMapping(value = "/FindResult",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String FindResult(String condition){
        return userService.findResult(condition);
    }

}
