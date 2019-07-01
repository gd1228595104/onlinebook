package mapper;

import bean.TStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TStudentMapper {
    List<TStudent> findAllStu();
    /**
     *描述：后台用户管理中根据学号查询用户
     *参数：Integre sid
     *返回类型：TStudent
     *创建者：ice
     *创建时间：2019/03/07 17:20
    */
    TStudent findUserBySid(long sid);

    /**
     *描述：后台用户管理根据姓名查询用户
     *参数：String name
     *返回类型：List<TStudent>
     *创建者：ice
     *创建时间：2019/03/08 10:15
    */
    List<TStudent> findUserByName(String name);

    /**
     *描述：后台用户管理根据院系查询用户
     *参数：String department
     *返回类型：List<TStudent>
     *创建者：ice
     *创建时间：2019/03/08 10:18
    */
    List<TStudent> findUserByDepartment(String department);

    /**
     *描述：后台用户管理根据专业查询用户
     *参数：String major
     *返回类型：List<TStudent>
     *创建者：ice
     *创建时间：2019/03/08 10:21
    */
    List<TStudent> findUserByMajor(String major);

    /**
     *描述：校验登录的学号和密码
     *参数：Long sid,String password
     *返回类型：TStudent
     */
    TStudent findWithLoginAndPdw(@Param("sid") long sid, @Param("password") String password);

    /**
     *描述：修改密码
     *参数：Long sid,String password
     *返回类型：java.lang.String
     */
    int resetPwd(@Param("sid") Long sid,@Param("password") String password,@Param("newPwd")String newPwd);

    /**
     *描述：校验学生信息
     *参数：[TStudent]
     *返回类型：void
     */
    int checkStuInfo(TStudent tStudent);

    /**
     * 查找学生账号和密码
     * @param sid 登录用户名
     * @return
     */
    TStudent findByUsername(Long sid);



    /**
     *描述：后台根据选择院系返回可选择的选项
     *参数：无
     *返回类型：List<TStudent>
     *创建者：ice
     *创建时间：2019/03/14 8:35
    */
    List<TStudent> findResultByDepart();

    /**
     *描述：后台根据选择专业返回可选择的选项
     *参数：无
     *返回类型：List<TStudent>
     *创建者：ice
     *创建时间：2019/03/14 8:38
    */
    List<TStudent> findResultByMajor();

    /**
     *描述：查询积分
     *参数：Long sid
     *返回类型：int
     *创建者：ice
     *创建时间：2019/03/17 16:33
    */
    int selectPoints(Long sid);

    //借出书籍后，学生积分加5分
    int updateAddPoints(Long sid);

    //借入书籍后，积分减5分
    int updateReducePoints(Long sid);

    List<TStudent> selectAll();
}