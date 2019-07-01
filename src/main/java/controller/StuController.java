package controller;

import bean.TStudent;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import service.StuService;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
//这里用了@SessionAttributes，可以直接把model中的tStudent(也就key)放入其中
//这样保证了session中存在tStudent这个对象
//@SessionAttributes("tStudent")
public class StuController {

    @Autowired
    @Qualifier("stuService")
    private StuService stuService;

    /**
     *描述：学生登录
     *参数：Long sid,String password
     */
    @RequestMapping(value = "/stulogin")
    public String Login(long sid, String password){
        TStudent tStudent=stuService.login(sid,password);
        return JSON.toJSONString(tStudent);
    }
    @RequestMapping(value = "/stulogin2")
    public boolean Login2(long sid,String password){
        boolean flag = stuService.login2(sid,password);
        return flag;
    }
    /**
     * 获取学生登录用户名信息
     */
    @RequestMapping(value = "getLoginInfo",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String getLoginInfo(){
       return stuService.getLoginInfo();
    }

    /**
     * 注册功能
     * @param tStudent
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public int register(TStudent tStudent) throws UnsupportedEncodingException {
//        System.out.println("---------------1213213123");
//        System.out.println("old-->"+tStudent);
//        tStudent.setName(new String(tStudent.getName().getBytes("ISO-8859-1"),"UTF-8"));
//        tStudent.setDepartment(new String(tStudent.getDepartment().getBytes("ISO-8859-1"),"UTF-8"));
//        tStudent.setMajor(new String(tStudent.getMajor().getBytes("ISO-8859-1"),"UTF-8"));
//        tStudent.setSex(new String(tStudent.getSex().getBytes("ISO-8859-1"),"UTF-8"));
//        System.out.println("**********************");
//        System.out.println(tStudent);
        return stuService.checkStuInfo(tStudent);
    }

    @RequestMapping(value = "resetPwd",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String resetPwd(Long sid,String oldPwd,String newpwd){
        return stuService.resetPwd(sid,oldPwd,newpwd);
    }
    @RequestMapping(value = "exitLogin",method = RequestMethod.POST)
    public void exitLogin(){
        stuService.exitLogin();
    }
    @RequestMapping(value = "getAll",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String selectAll(int currPage,int pageSize){
        return stuService.selectAllStu(currPage,pageSize);
    }
}
