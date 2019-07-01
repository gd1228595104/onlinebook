package bean;

public class TCheck {
    private Integer cId;

    private Long cSid;

    private String cName;

    private String cSex;

    private String cDepartment;

    private String cMajor;

    private String cGrade;

    private String cClass;

    private String cIdcard;

    private String cEmail;

    private String cPhoto;

    private String cStatus;

    private String cReason;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Long getcSid() {
        return cSid;
    }

    public void setcSid(Long cSid) {
        this.cSid = cSid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    public String getcDepartment() {
        return cDepartment;
    }

    public void setcDepartment(String cDepartment) {
        this.cDepartment = cDepartment == null ? null : cDepartment.trim();
    }

    public String getcMajor() {
        return cMajor;
    }

    public void setcMajor(String cMajor) {
        this.cMajor = cMajor == null ? null : cMajor.trim();
    }

    public String getcGrade() {
        return cGrade;
    }

    public void setcGrade(String cGrade) {
        this.cGrade = cGrade == null ? null : cGrade.trim();
    }

    public String getcClass() {
        return cClass;
    }

    public void setcClass(String cClass) {
        this.cClass = cClass == null ? null : cClass.trim();
    }

    public String getcIdcard() {
        return cIdcard;
    }

    public void setcIdcard(String cIdcard) {
        this.cIdcard = cIdcard == null ? null : cIdcard.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus == null ? null : cStatus.trim();
    }

    public String getcReason() {
        return cReason;
    }

    public void setcReason(String cReason) {
        this.cReason = cReason == null ? null : cReason.trim();
    }
}