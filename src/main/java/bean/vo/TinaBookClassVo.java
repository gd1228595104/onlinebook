package bean.vo;

import bean.TBook;
import bean.TBookclass;
import bean.TInactivebook;
import bean.TStudent;

import java.util.List;

/**
 * 描述：
 * 返回类型：java.lang.String
 * 创建者：ice
 * 创建时间：2019-04-18 20:13
 */
public class TinaBookClassVo extends TInactivebook{

    private String author;

    private String publisher;

    private String classname;
    private String department;

    private String major;

    private String grade;

    private String classnumber;

    private Long phone;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(String classnumber) {
        this.classnumber = classnumber;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
