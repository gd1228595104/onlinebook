package service.serviceImpl;

import bean.TStudent;
import com.alibaba.fastjson.JSON;
import mapper.TStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.testService;

import java.util.List;
@Service
public class testServiceImpl implements testService {
    @Autowired
    private TStudentMapper tStudentMapper;

    @Override
    public String findAllStu() {
        List<TStudent> tStudents = tStudentMapper.findAllStu();
        return JSON.toJSONString(tStudents);
    }
}
