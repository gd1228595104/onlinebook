package service;

import bean.TAdmin;
import bean.TStudent;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    String acvationFailList(Integer currPage,Integer pageSize);
    String acvationFailInfo(Long cId);
    String passAcvationFailInfo(Long cId, TStudent tStudent,String msg, int id);
    String refuseAcvationFailInfo(Long cId,String cReason);
    String unreviewAcvaFailList(Integer currPage,Integer pageSize);
    String reviewedAcvaFailList(Integer currPage,Integer pageSize);
    String problemList(Integer currPage,Integer pageSize);
    String checkProblem(Integer aid);

    String login(String admin, String adminpwd);
    public String checkLogin();
    //检验管理员登录
    //TAdmin checkLogin(String admin,String adminpwd);


}
