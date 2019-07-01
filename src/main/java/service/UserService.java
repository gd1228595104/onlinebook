package service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String findUser(String condition,String context,Integer currPage,Integer pageSize);
    String findResult(String condition);
}
