package bean;

import java.util.Date;

public class TAnnouncement {
    private Integer nid;

    private String announcement;

    private Date annotime;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement == null ? null : announcement.trim();
    }

    public Date getAnnotime() {
        return annotime;
    }

    public void setAnnotime(Date annotime) {
        this.annotime = annotime;
    }
}