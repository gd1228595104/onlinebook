package service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HobbiesService {

    //选择兴趣标签
    String chooseHobbies(List<String> hobbies);
    String changeHobbies(List<String> hobbies);
}
