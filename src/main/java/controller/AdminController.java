package controller;

import bean.TStudent;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AdminService;

import java.io.UnsupportedEncodingException;

/**
 * 描述：后台管理员模块
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-06 15:50
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     *描述：后台管理员激活失败审核管理列表显示
     *参数：无
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/06 16:03
     */
    @RequestMapping(value = "/AcvationFailList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String AcvationFailList(Integer currPage,Integer pageSize){
        return adminService.acvationFailList(currPage,pageSize);
    }

    /**
     *描述：激活失败审核信息的详情
     *参数：Integer cId
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/06 16:21
    */
    @RequestMapping(value = "/AcvationFailInfo",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String AcvationFailInfo(Long checkId){
        return adminService.acvationFailInfo(checkId);
    }

    /**
     *描述：通过激活失败信息的审核
     *参数：Integer cId
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/06 16:23
    */
    @RequestMapping(value = "/PassAcvationFailInfo",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String PassAcvationFailInfo(Long cId, TStudent tStudent,String msg,int id){
        return adminService.passAcvationFailInfo(cId,tStudent,msg,id);
    }

    /**
     *描述：不通过激活失败信息的审核，同时给出审核不通过理由
     *参数：Integer cId，String cReason
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/07 9:51
    */
    @RequestMapping(value = "/RefuseAcvationFailInfo",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String RefuseAcvationFailInfo(Long cId,String cReason){
//        try {
//            cReason = new String(cReason.getBytes("ISO-8859-1"),"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        return adminService.refuseAcvationFailInfo(cId,cReason);
    }

    /**
     *描述：激活失败信息未审核列表展示
     *参数：无
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/07 10:22
    */
    @RequestMapping(value = "/UnreviewedAcvaFailList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String UnreviewedAcvaFailList(Integer currPage,Integer pageSize){
        return adminService.unreviewAcvaFailList(currPage,pageSize);
    }

    /**
     *描述：激活失败信息已审核列表
     *参数：无
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/07 10:23
    */
    @RequestMapping(value = "/ReviewedAcvaFailList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String ReviewedAcvaFailList(Integer currPage,Integer pageSize){
        return adminService.reviewedAcvaFailList(currPage,pageSize);
    }

    /**
     *描述：其他问题的信息展示
     *参数：无
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/07 10:42
    */
    @RequestMapping(value = "/ProblemList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String ProblemList(Integer currPage,Integer pageSize){
        return adminService.problemList(currPage,pageSize);
    }

    /**
     *描述：投诉问题的审核
     *参数：Integer aid
     *返回类型：java.lang.String
     *创建者：ice
     *创建时间：2019/03/07 10:54
    */
    @RequestMapping(value = "/CheckProblem",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String CheckProblem(Integer aid){return adminService.checkProblem(aid);}

    @RequestMapping(value = "/adminlogin",method = RequestMethod.GET)
    public String amdinLogin(String admin, String adminpwd){
        return adminService.login(admin,adminpwd);
    }
    @RequestMapping(value = "checkLogin",method = RequestMethod.GET)
    public String checkLogin(){
        return adminService.checkLogin();
    }
}