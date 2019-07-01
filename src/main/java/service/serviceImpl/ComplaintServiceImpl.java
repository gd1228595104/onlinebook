package service.serviceImpl;

import api.Response;
import bean.TApplication;
import com.alibaba.fastjson.JSON;
import mapper.TApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ComplaintService;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-14 08:48
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private TApplicationMapper tApplicationMapper;

    /**
     *描述：向管理员投诉其他用户
     *参数：Integer sid
     *返回类型：String
     *创建者：ice
     *创建时间：2019/03/14 8:48
    */
    @Override
    public String complaintOtherUser(Long sid,Long asid,String content) {
//        Long sid = httpSession.getAttribute("sid");
        TApplication tApplication = new TApplication();
        tApplication.setSid(sid);
        tApplication.setAsid(asid);
        tApplication.setContent(content);
        tApplication.setAstatus("未审核");
        tApplicationMapper.insertComplaint(tApplication);
        return JSON.toJSONString(new Response("投诉成功",1));
    }
}
