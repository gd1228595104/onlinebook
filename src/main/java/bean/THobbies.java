package bean;

public class THobbies {
    private Long sid;

    private String hobbies;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies == null ? null : hobbies.trim();
    }
}