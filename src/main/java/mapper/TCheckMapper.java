package mapper;


import bean.TCheck;
import bean.TStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCheckMapper {

    /**
     *描述：激活失败审核信息的详情展示
     *参数：Integer cId
     *返回类型：TCheck
     *创建者：ice
     *创建时间：2019/03/06 16:15
    */
    TCheck findAcvationFailInfo(Long cId);

    /**
     *描述：通过激活信息失败的审核
     *参数：Integer cId
     *返回类型：int
     *创建者：ice
     *创建时间：2019/03/07 9:54
    */
    int updatePassAcvaFailInfo(Long cId);

    /**
     *描述：不通过激活失败信息的审核，同时给出审核不通过理由
     *参数：Integer cId，String cReason
     *返回类型：int
     *创建者：ice
     *创建时间：2019/03/07 10:06
    */
    int updateRefuseAcvaFailInfo(@Param("cId") Long cId,@Param("cReason") String cReason);

    /**
     *描述：激活失败信息的未审核列表
     *参数：无
     *返回类型：List<TCheck>
     *创建者：ice
     *创建时间：2019/03/07 10:27
    */
    List<TCheck> findUnreviewedAcvaFailList();

    /**
     *描述：激活失败信息的已审核列表
     *参数：无
     *返回类型：List<TCheck>
     *创建者：ice
     *创建时间：2019/03/07 10:27
     */
    List<TCheck> findReviewedAcvaFailList();

    List<TCheck> findAcvationFailList();

    /**
     *描述：查看申请审核
     *参数：Integer cSid
     *返回类型：List
     */
    List<TStudent> viewStuCheck(String cIdcard);

    //提交申请
    int insertTCheck(TCheck tCheck);
}