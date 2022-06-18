package com.gymSQL.pojo;

public class course {
    private Integer id;
    private String course_name;
    private String course_price;
    private String taught;
    private String teach_time;
    private String teach_space;
    private String course_state;

    public course() {
    }

    public course(Integer id, String course_name, String course_price, String taught,
                  String teach_time, String teach_space, String course_state) {
        this.id = id;
        this.course_name = course_name;
        this.course_price = course_price;
        this.taught = taught;
        this.teach_time = teach_time;
        this.teach_space = teach_space;
        this.course_state = course_state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_price() {
        return course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public String getTaught() {
        return taught;
    }

    public void setTaught(String taught) {
        this.taught = taught;
    }

    public String getTeach_time() {
        return teach_time;
    }

    public void setTeach_time(String teach_time) {
        this.teach_time = teach_time;
    }

    public String getTeach_space() {
        return teach_space;
    }

    public void setTeach_space(String teach_space) {
        this.teach_space = teach_space;
    }

    public String getCourse_state() {
        return course_state;
    }

    public void setCourse_state(String course_state) {
        this.course_state = course_state;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", course_price='" + course_price + '\'' +
                ", taught='" + taught + '\'' +
                ", teach_time='" + teach_time + '\'' +
                ", teach_space='" + teach_space + '\'' +
                ", course_state='" + course_state + '\'' +
                '}';
    }
}
