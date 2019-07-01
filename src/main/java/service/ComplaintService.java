package service;

import org.springframework.stereotype.Service;

@Service
public interface ComplaintService {
    String complaintOtherUser(Long sid,Long asid,String content);
}
