package service;

import bean.TStudent;
import org.springframework.stereotype.Service;

@Service
public interface StuService {

    /**
     * 登录
     */
    TStudent login(long sid,String password);
    boolean login2(long sid,String password);
    /**
     * 获取学生信息
     */
    String getLoginInfo();
    /**
     * 修改用户密码
     * @param newpwd 输入的没加密的新密码
     * @return
     */
    String resetPwd(Long sid,String oldPwd,String newpwd);

    /**
     * 退出登录
     */
    void exitLogin();

    /**
     * 查看申请审核
     */
//    String viewStuCheck();

    /**
     * 校验学生信息
     */
    int checkStuInfo(TStudent tStudent);

   String selectAllStu(int currPage,int pageSize);

}
