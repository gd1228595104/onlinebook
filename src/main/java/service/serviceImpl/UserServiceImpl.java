package service.serviceImpl;

import api.Response;
import bean.TStudent;
import com.alibaba.fastjson.JSON;
import mapper.TStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import util.PageUtil;

import java.util.List;

import static util.PageUtil.Page;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-07 17:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TStudentMapper tStudentMapper;

    @Override
    public String findUser(String condition, String context, Integer currPage,Integer pageSize) {
        List<TStudent> list = null;
        if("学号".equals(condition)){
            //根据学号查询用户，查询出来的结果唯一，不用进行分页
            long sid = Long.valueOf(context);
            return JSON.toJSONString(tStudentMapper.findUserBySid(sid));
        }
        if("姓名".equals(condition)){
            //根据姓名查询用户，查询结果可能不唯一，需进行分页
            list = tStudentMapper.findUserByName(context);
            return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
        }
        if("院系".equals(condition)){
            //根据院系查询用户，查询结果需进行分页
            list = tStudentMapper.findUserByDepartment(context);
            return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
        }
        if("专业".equals(condition)){
            //根据专业查询用户，查询结果需进行分页
            list = tStudentMapper.findUserByMajor(context);
            return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
        }
        else {
            return JSON.toJSONString(new Response("对不起，你的查询没有结果！",1));
        }
    }

    @Override
    public String findResult(String condition) {
        List<TStudent> list = null;
        if("院系".equals(condition)){
            list = tStudentMapper.findResultByDepart();
            return JSON.toJSONString(new Response(list,list.size()));}
        if("专业".equals(condition)){
            list = tStudentMapper.findResultByMajor();
            return JSON.toJSONString(new Response(list,list.size()));}
        else{return JSON.toJSONString(new Response("",0));}
    }
}
