package service;

import org.springframework.stereotype.Service;

@Service
public interface AnnoService {
    String publishAnnouncement(String announcement);
    String annoList(Integer currPage,Integer pageSize);
    String deleteAnnouncement(Integer nid);
    String annoInfo();
}
