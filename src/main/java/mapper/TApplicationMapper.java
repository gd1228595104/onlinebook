package mapper;


import bean.TApplication;

import java.util.List;

public interface TApplicationMapper {
    /**
     *描述：问题信息列表展示
     *参数：Integer cId
     *返回类型：List<TApplication>
     *创建者：ice
     *创建时间：2019/03/07 9:53
    */
    List<TApplication> findProblemList();

    /**
     *描述：审核投诉问题
     *参数：Integer aid
     *返回类型：int
     *创建者：ice
     *创建时间：2019/03/07 10:56
    */
    int updatePassProblem(Integer aid);

    /**
     *描述：向管理员投诉其他用户
     *参数：TApplication
     *返回类型：int
     *创建者：ice
     *创建时间：2019/03/14 8:50
    */
    int insertComplaint(TApplication tApplication);
}