package ian.com.rxjavademo.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentBean implements Serializable {
    private String name;
    private int stuNumber;
    private List<String> courses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
