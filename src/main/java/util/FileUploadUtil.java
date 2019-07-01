package util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 描述：用于图片上传
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-06 09:37
 */
public class FileUploadUtil {

    public String fileUpload(MultipartFile file){
        //保存在本地的路径
        String localPath  = "D:\\File\\";
        //保存到数据库路径
        String sqlPath = null;
        //图片的存储路径
        String sqlpath  = null;
        if(!file.isEmpty()){
            //生成uuid作为图片名称
            String uuid = UUID.randomUUID().toString().replaceAll("-",".");
            //获取文件类型
            String contentType = file.getContentType();
            //获取文件的后缀名称
            String suffixname = contentType.substring(contentType.indexOf("/")+1);
            //得到文件名称
            String filename = uuid + "." + suffixname;
            //存储到数据库中的存储路径
            sqlpath = "/img/"+ filename;
            try {
                //文件保存路径
                file.transferTo(new File(localPath+filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlpath;
    }
}
