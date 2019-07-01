package mapper;


import bean.TAnnouncement;

import java.util.List;

public interface TAnnouncementMapper {

    //发布公告
    int insertAnnoucement(String announcement);

    //后台查看公告列表
    List<TAnnouncement> findAnnoList();

    //删除公告
    int deleteAnnocement(Integer nid);

    //首页显示公告，取最新五条
    List<TAnnouncement> findAnnoInfo();
}