package service.serviceImpl;

import api.Response;
import bean.TAnnouncement;
import com.alibaba.fastjson.JSON;
import mapper.TAnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AnnoService;
import java.util.List;
import static util.PageUtil.Page;
/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-03-14 09:13
 */
@Service
public class AnnoServiceImpl implements AnnoService {

    @Autowired
    private TAnnouncementMapper tAnnouncementMapper;

    @Override
    public String publishAnnouncement(String announcement) {
        tAnnouncementMapper.insertAnnoucement(announcement);
        return JSON.toJSONString(new Response("发布公告成功",1));
    }

    @Override
    public String annoList(Integer currPage,Integer pageSize) {
        List<TAnnouncement> list = tAnnouncementMapper.findAnnoList();
        return JSON.toJSONString(new Response(Page(currPage,pageSize,list),list.size()));
    }

    @Override
    public String deleteAnnouncement(Integer nid) {
        tAnnouncementMapper.deleteAnnocement(nid);
        return JSON.toJSONString(new Response("删除成功",1));
    }

    @Override
    public String annoInfo() {
        return JSON.toJSONString(new Response(tAnnouncementMapper.findAnnoInfo(),1));
    }
}
