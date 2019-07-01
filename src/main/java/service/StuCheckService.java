package service;

import bean.TCheck;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface StuCheckService {

    String stuCheck(TCheck tCheck,MultipartFile file);
}
