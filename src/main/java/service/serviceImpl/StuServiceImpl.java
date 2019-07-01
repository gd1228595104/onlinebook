package service.serviceImpl;

import api.Response;
import bean.TStudent;
import com.alibaba.fastjson.JSON;
import mapper.TCheckMapper;
import mapper.TStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StuService;
import util.PageUtil;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service("stuService")
public class StuServiceImpl implements StuService {

    @Autowired
    private TStudentMapper tStudentMapper;
    @Autowired
    private TCheckMapper tCheckMapper;
    @Autowired
    private HttpSession httpSession;



     /**
     *描述：修改密码
     *参数：Long sid,String oldpwd,String newpwd
     *返回类型：String
     */
    @Override
    public String resetPwd(Long sid,String oldPwd,String newpwd){
        return JSON.toJSONString(new Response(tStudentMapper.resetPwd(sid,oldPwd,newpwd),200));
    }

    /**
     * 退出登录
     */
    @Override
    public void exitLogin(){
        httpSession.removeAttribute("sid");
        httpSession.removeAttribute("name");
    }
    /**
     *描述：查看申请审核
     *参数：cSid,从session中取出
     *返回类型：java.lang.String
     */


    public String viewStuCheck() {
        String cIdcard = "16124120209";
        return JSON.toJSONString(tCheckMapper.viewStuCheck(cIdcard));
    }

    /**
     *描述：检验学生信息
     *参数：TStudent tStudent
     *返回类型：void
     */
    @Override
    public int checkStuInfo(TStudent tStudent){
        return tStudentMapper.checkStuInfo(tStudent);
    }

    /**
     * 学生登录
     * @param sid
     * @param password
     * @return
     */
    @Override
    public TStudent login(long sid, String password) {
          TStudent tStudent = tStudentMapper.findWithLoginAndPdw(sid, password);
            if (tStudent != null && tStudent.getSid() == sid && tStudent.getPassword().equals(password)) {
                httpSession.setAttribute("sid", tStudent.getSid());
                httpSession.setAttribute("name", tStudent.getName());
                return tStudent;
            }
            return null;
    }

    /**
     * 用于异步请求验证密码登录名
     * @param sid
     * @param password
     * @return
     */
    @Override
    public boolean login2(long sid, String password){
        TStudent tStudent = tStudentMapper.findWithLoginAndPdw(sid,password);
        if (tStudent != null && tStudent.getSid() == sid && tStudent.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    @Override
    public String getLoginInfo(){
        String username = (String) httpSession.getAttribute("name");
        String stu_id = String.valueOf(httpSession.getAttribute("sid"));
        if(username != null && !"".equals(username)) {
            TStudent tStudent = new TStudent();
            tStudent.setName(username);
            tStudent.setSid(Long.valueOf(stu_id));
            return JSON.toJSONString(tStudent);
        }
        return "null";
    }

    @Override
    public String selectAllStu(int currPage,int pageSize) {
        List<TStudent> list = tStudentMapper.selectAll();
        return JSON.toJSONString(new Response(PageUtil.Page(currPage,pageSize,list),list.size()));
    }
}
