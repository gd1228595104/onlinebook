package bean;

public class TApplication {
    private Integer aid;

    private Long sid;

    private Long asid;

    private String content;

    private String astatus;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getAsid() {
        return asid;
    }

    public void setAsid(Long asid) {
        this.asid = asid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAstatus() {
        return astatus;
    }

    public void setAstatus(String astatus) {
        this.astatus = astatus == null ? null : astatus.trim();
    }
}