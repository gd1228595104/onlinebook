package bean;

public class TBookclass {
    private Integer cid;

    private String classname;

    private Integer fcid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getFcid() {
        return fcid;
    }

    public void setFcid(Integer fcid) {
        this.fcid = fcid;
    }
}