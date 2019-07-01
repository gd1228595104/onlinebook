package service.serviceImpl;

import api.Response;
import bean.TAdmin;
import bean.TApplication;
import bean.TCheck;
import bean.TStudent;
import com.alibaba.fastjson.JSON;
import mapper.TAdminMapper;
import mapper.TApplicationMapper;
import mapper.TCheckMapper;
import mapper.TStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AdminService;

import javax.servlet.http.HttpSession;

import static util.PageUtil.Page;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 描述：管理员模块
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-06 15:59
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TAdminMapper tAdminMapper;
    @Autowired
    private TCheckMapper tCheckMapper;
    @Autowired
    private TApplicationMapper tApplicationMapper;
    @Autowired
    private HttpSession httpSession;

//    /**
//     *描述：管理员登录
//     *参数：String admin, String adminpwd
//     */
//    @Override
//    public TAdmin login(String admin, String adminpwd){
//        return tAdminMapper.findWithLoginAndPdw(admin,adminpwd);
//    }

    /*
     * 检验管理员登录业务
     *
     */
    public String login(String admin, String adminpwd) {
        TAdmin tAdmin = tAdminMapper.findByUsername(admin);
        if(tAdmin != null && tAdmin.getAdminpwd().equals(adminpwd)){
            httpSession.setAttribute("name",tAdmin.getAdmin());
            return JSON.toJSONString(tAdmin);
        }
        return "null";
    }

    /**
     * 检测是否有登录 true为登录  false未登录
     * @return
     */
    public String checkLogin(){
        String adminuser = (String) httpSession.getAttribute("name");
        if(adminuser == null || "".equals(adminuser)){
            return JSON.toJSONString(new Response("未登录",1));
        }
        return JSON.toJSONString(new Response(adminuser,1));
    }


    /**
     *描述：后台管理员模块的激活失败审核列表显示
     *参数：无
     *返回类型：json
     *创建者：ice
     *创建时间：2019/03/06 16:00
    */
    @Override
    public String acvationFailList(Integer currPage,Integer pageSize) {
        List<TCheck> tCheckList = tCheckMapper.findAcvationFailList();
        return JSON.toJSONString(new Response(Page(currPage,pageSize,tCheckList),tCheckList.size()));
    }

    /**
     *描述：激活失败审核信息的详情
     *参数：Integer cId
     *返回类型：json
     *创建者：ice
     *创建时间：2019/03/06 16:19
    */
    @Override
    public String acvationFailInfo(Long cId) {
        return JSON.toJSONString(new Response(tCheckMapper.findAcvationFailInfo(cId),1));
    }

    /**
     *描述：通过激活失败的信息审核
     *参数：Integer cId String msg(不通过时的信息)   int id(标志符，1标识通过，0标识不通过)
     *返回类型：json
     *创建者：ice
     *创建时间：2019/03/07 10:00
    */
    @Transactional
    @Override
    public String passAcvationFailInfo(Long cId, TStudent tStudent, String msg, int id) {
        if(id == 1) {
            tCheckMapper.updatePassAcvaFailInfo(cId);
            tStudent = change(tStudent);
            int i = tAdminMapper.updateStuInfo(tStudent);
            return JSON.toJSONString(new Response("审核通过操作成功", i));
        }else{
            tCheckMapper.updateRefuseAcvaFailInfo(cId,msg);
            return JSON.toJSONString(new Response("操作完成",1));
        }
    }
    private TStudent change(TStudent tStudent) {
//        try {
//            tStudent.setName(new String(tStudent.getName().getBytes("ISO-8859-1"),"UTF-8"));
//            tStudent.setDepartment(new String(tStudent.getDepartment().getBytes("ISO-8859-1"),"UTF-8"));
//            tStudent.setMajor(new String(tStudent.getMajor().getBytes("ISO-8859-1"),"UTF-8"));
//            tStudent.setSex(new String(tStudent.getSex().getBytes("ISO-8859-1"),"UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        return tStudent;
    }
    /**
     *描述：不通过激活失败信息的申请审核
     *参数：Integer cId, String cReason
     *返回类型：json
     *创建者：ice
     *创建时间：2019/03/07 10:29
    */
    @Override
    public String refuseAcvationFailInfo(Long cId, String cReason) {
        tCheckMapper.updateRefuseAcvaFailInfo(cId,cReason);
        return JSON.toJSONString(new Response("审核不通过操作成功",1));
    }

    /**
     *描述：激活失败信息未审核的列表
     *参数：无
     *返回类型：json
     *创建者：ice
     *创建时间：2019/03/07 10:30
    */
    @Override
    public String unreviewAcvaFailList(Integer currPage,Integer pageSize) {
        List<TCheck> tCheckList = tCheckMapper.findUnreviewedAcvaFailList();
        return JSON.toJSONString(new Response(Page(currPage,pageSize,tCheckList),tCheckList.size()));
    }

    @Override
    public String reviewedAcvaFailList(Integer currPage,Integer pageSize) {
        List<TCheck> tCheckList = tCheckMapper.findReviewedAcvaFailList();
        return JSON.toJSONString(new Response(Page(currPage,pageSize,tCheckList),tCheckList.size()));
    }

    @Override
    public String problemList(Integer currPage,Integer pageSize) {
        List<TApplication> tApplicationList = tApplicationMapper.findProblemList();
        return JSON.toJSONString(new Response(Page(currPage,pageSize,tApplicationList),tApplicationList.size()));
    }


    @Override
    public String checkProblem(Integer aid) {
        tApplicationMapper.updatePassProblem(aid);
        return JSON.toJSONString(new Response("已审核",1));
    }

}
