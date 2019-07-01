package bean;

public class TPoints {

    private Integer pid;

    private Long sid;

    private String pointchange;

    private String changetime;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getPointchange() {
        return pointchange;
    }

    public void setPointchange(String pointchange) {
        this.pointchange = pointchange == null ? null : pointchange.trim();
    }

    public String getChangetime() {
        return changetime;
    }

    public void setChangetime(String changetime) {
        this.changetime = changetime == null ? null : changetime.trim();
    }
}