package bean;

public class THopebook {
    private Integer hopeid;

    private Long sid;

    private String hopebookname;

    private String author;

    public Integer getHopeid() {
        return hopeid;
    }

    public void setHopeid(Integer hopeid) {
        this.hopeid = hopeid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getHopebookname() {
        return hopebookname;
    }

    public void setHopebookname(String hopebookname) {
        this.hopebookname = hopebookname == null ? null : hopebookname.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }
}