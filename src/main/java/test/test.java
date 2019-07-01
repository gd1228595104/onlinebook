//package test;
//
//
//import bean.TEvaluate;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import service.AdminService;
//import service.EvaluateService;
//import service.testService;
//
//@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner类
//@ContextConfiguration(locations = { "classpath:spring-mvc.xml","classpath:spring-mybatis.xml" })
//@WebAppConfiguration("src/main/resources")
//public class test {
//    @Autowired
//    private testService testService;
//    @Autowired
//    private AdminService adminService;
//
//    //评价功能模块测试
//    @Test
//    public void test1(){
//        //测试评价功能
////        TEvaluate tEvaluate = new TEvaluate();
////        tEvaluate.setBeevaluatorId(Long.valueOf("16124120201"));
////        tEvaluate.setBeevaluatorName("罗琳月");
////        tEvaluate.setEvaluatorId(Long.valueOf("16124120204"));
////        tEvaluate.setEvaluatorName("汪晓彤");
////        tEvaluate.setEvaluation("为人诚信");
////        tEvaluate.setEvaluatescore(90);
////        String json = evaluateService.evaluate(tEvaluate);
//
////        //查看自己对别人的评价
////        String json = evaluateService.findEvaluation();
//
////        //查看别人对自己的评价
////        String json = evaluateService.findBeEvaluation();
//
//        //删除对别人的评价
////        Integer evaid = 2;
////        String json = evaluateService.deleteTEvaluation(evaid);
//
//        //修改对别人的评价
////        Integer evaid = 4;
////        String evaluation = "jajaj";
////        Integer evaluatescore  = 95;
////        String json = evaluateService.changeEvaluation(evaid,evaluation,evaluatescore);
//
////        System.out.println("*******************"+json);
//    }
//
//    //管理员模块测试
//    @Test
//    public void test2(){
//        //激活失败列表
//        String json = adminService.acvationFailList(1);
//
//        //激活失败列表的详情
////        String json = adminService.acvationFailInfo(3);
//
//        //通过激活失败信息的审核
////        String json = adminService.passAcvationFailInfo(1);
//
//        //不通过激活失败信息的审核
////        String json = adminService.refuseAcvationFailInfo(1,"性别错误");
//
//        //激活失败信息的未审核列表
////        String json = adminService.unreviewAcvaFailList();
//
//        //激活失败信息的未审核列表
////        String json = adminService.reviewedAcvaFailList();
//
//        //投诉问题列表展示
////        String json = adminService.problemList();
//
//        //审核其他问题
////        String json = adminService.checkProblem(1);
//        System.out.println("*******************"+json);
//    }
//
//}
