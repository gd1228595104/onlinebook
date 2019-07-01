package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.AnnoService;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-14 09:08
 */
@RestController
public class AnnouncementController {

    @Autowired
    private AnnoService annoService;
    /**
     *描述：发布公告
     *参数：String announcement
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/14 9:08
    */
    @RequestMapping(value = "/PublishAnnouncement",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String PublishAnnouncement(String announcement){
        return annoService.publishAnnouncement(announcement);}
    
    /**
     *描述：后台查看公告列表
     *参数：无
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/14 9:14
    */
    @RequestMapping(value = "/AnnoList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String AnnoList(Integer currPage,Integer pageSize){
        return annoService.annoList(currPage,pageSize);
    }

    /**
     *描述：后台删除公告
     *参数：Integer nid
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/14 9:15
    */
    @RequestMapping(value = "/DeleteAnnouncement",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String DeleteAnnouncement(Integer nid){
        return annoService.deleteAnnouncement(nid);}
    
    /**
     *描述：首页显示公告，取最新6条
     *参数：无
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/14 9:17
    */
    @RequestMapping(value = "/AnnoInfo",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String AnnoInfo(){return annoService.annoInfo();}
}

