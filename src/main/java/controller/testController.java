package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.HobbiesService;
import service.testService;
import util.FileUploadUtil;

import java.util.ArrayList;
import java.util.List;


@Controller
public class testController {
    @Autowired
    private testService testService;
    @Autowired
    private HobbiesService hobbiesService;

    @RequestMapping(value = "/test",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    private String test(){
        System.out.println("HelloWorld!");
        return testService.findAllStu();
    }

    //图片上传
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    private String upload(MultipartFile file){
        //存储在数据库中的路径
        FileUploadUtil fileUpload = new FileUploadUtil();
        String sqlpath = fileUpload.fileUpload(file);
        System.out.println("***************"+sqlpath);
        return "success";
    }
    @RequestMapping(value = "tt")
    public String test1(){
        return "index.html";
    }

    @RequestMapping(value = "testHobbies",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String testHobbies(){
        List<String> hobbies = new ArrayList<>();
        hobbies.add("文学");
        String json = hobbiesService.changeHobbies(hobbies);
        System.out.println("***************"+json);
        return "error";
    }
}
