package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.HobbiesService;

import java.util.List;

@RestController
public class HobbiesController {

    @Autowired
    private HobbiesService hobbiesService;


    /**
     *描述：选择兴趣标签
     *参数：List<String> hobbies
     *返回类型：java.lang.String
     */
    @RequestMapping(value="/chooseHobbies",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String ChooseHobbies(List<String> hobbies){
        return hobbiesService.chooseHobbies(hobbies);
    }


    /**
     *描述：修改兴趣标签，先删除，再重新插入
     *参数：List<String> hobbies
     *返回类型：java.lang.String
     */
    @RequestMapping(value = "/changeHobbies",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String ChangeHobbies(List<String> hobbies){
        return hobbiesService.changeHobbies(hobbies);
    }

}
