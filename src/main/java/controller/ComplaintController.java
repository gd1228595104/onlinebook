package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ComplaintService;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-14 08:45
 */
@RestController
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    /**
     *描述：向管理员投诉其他用户
     *参数：Long asid,String content
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/14 9:07
    */
    @RequestMapping(value = "/ComplaintOtherUser",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String ComplaintOtherUser(Long sid,Long asid,String content){
        return complaintService.complaintOtherUser(sid, asid,content);
    }
}
