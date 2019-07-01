package service.serviceImpl;

import api.Response;
import bean.TCheck;
import com.alibaba.fastjson.JSON;
import mapper.TCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.StuCheckService;
import util.FileUploadUtil;

@Service
public class StuCheckServiceImpl implements StuCheckService {

    @Autowired
    private TCheckMapper tcheckMapper;

    @Override
    public String stuCheck(TCheck tCheck,MultipartFile file) {
        //获取图片的存储路径
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        String filename = fileUploadUtil.fileUpload(file);
        tCheck.setcPhoto(filename);
        tCheck.setcStatus("未审核");
        tcheckMapper.insertTCheck(tCheck);
        return JSON.toJSONString(new Response("提交申请审核成功",1));
    }

}
