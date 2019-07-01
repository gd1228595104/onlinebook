package service.serviceImpl;

import api.Response;
import com.alibaba.fastjson.JSON;
import mapper.THobbiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.HobbiesService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class HobbiesServiceImpl implements HobbiesService {

    @Autowired
    private THobbiesMapper thobbiesMapper;
    @Autowired
    private HttpSession httpSession;


    /**
     *描述：选择兴趣标签
     *参数：List<String> hobbies
     *返回类型：json
     */
    @Override
    public String chooseHobbies(List<String> hobbies){
        //从session中取出sid
        Long sid = (Long) httpSession.getAttribute("sid");
        //将兴趣标签组合成字符串
        String hobby = getHobbies(hobbies);
        thobbiesMapper.chooseHobbies(sid,hobby);
        //选择完兴趣标签之后清空session
        httpSession.removeAttribute("sid");
        return JSON.toJSONString(new Response("兴趣标签选择完成",1));
    }


    /**
     *描述：修改兴趣标签
     *参数：List<String> hobbies
     *返回类型：json
     */
    @Override
    public String changeHobbies(List<String> hobbies){
        //从session中取出学生的学号
        Long sid = (Long) httpSession.getAttribute("sid");
        //先删除原来学生的兴趣标签，再插入新的
        thobbiesMapper.deleteHobbies(sid);
        String hobby = getHobbies(hobbies);
        thobbiesMapper.chooseHobbies(sid,hobby);
        return JSON.toJSONString(new Response("兴趣标签修改完成",1));
    }


    public String getHobbies(List<String> hobbies){
        String hobby = hobbies.get(0);
        if(hobbies.size()>1) {
            for (int i = 1; i < hobbies.size(); i++) {
                hobby = hobby + "," + hobbies.get(i);
            }
        }
        return hobby;
    }
}
