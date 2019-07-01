package bean;

public class TInactivebook {
    private Integer bookid;

    private String inactivebookname;

    private Long loanerId;

    private String loanerName;

    private String status;

    private String photo;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getInactivebookname() {
        return inactivebookname;
    }

    public void setInactivebookname(String inactivebookname) {
        this.inactivebookname = inactivebookname == null ? null : inactivebookname.trim();
    }

    public Long getLoanerId() {
        return loanerId;
    }

    public void setLoanerId(Long loanerId) {
        this.loanerId = loanerId;
    }

    public String getLoanerName() {
        return loanerName;
    }

    public void setLoanerName(String loanerName) {
        this.loanerName = loanerName == null ? null : loanerName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
}