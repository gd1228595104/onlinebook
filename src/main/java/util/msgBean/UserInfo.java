package util.msgBean;

import java.util.List;

public class UserInfo {
    private int userid;
    private String name;
    private List<Message> megs;
    public UserInfo(int userid,String name){
        this.userid = userid;
        this.name = name;
    }
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMegs() {
        return megs;
    }

    public void setMegs(List<Message> megs) {
        this.megs = megs;
    }
}
