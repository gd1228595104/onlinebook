package controller;

import bean.TCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.StuCheckService;

@RestController
public class StuCheckController {

    @Autowired
    private StuCheckService stuCheckService;

    
    /**
     *描述：数据库可能输错学生信息，提供功能供学生申请审核
     *参数：TCheck
     *返回类型：String
     *创建者：ice
     *创建时间：2019/04/02 21:13
    */
    @RequestMapping(value = "/StuCheck",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String StuCheck(TCheck tCheck, MultipartFile file){
        return stuCheckService.stuCheck(tCheck, file);
    }
}
