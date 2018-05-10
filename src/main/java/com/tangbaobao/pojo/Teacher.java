package com.tangbaobao.pojo;

import java.util.Date;
import java.util.List;

/**
 * 教师表
 *
 * @author 唐学俊
 * @create 2018/02/20
 * `teacherId` varchar(50) NOT NULL,
 * `taskId` varchar(50) DEFAULT NULL,
 * `teacherNo` varchar(15) DEFAULT NULL,
 * `teacherName` varchar(50) DEFAULT NULL,
 * `teaceherPassword` varchar(15) DEFAULT NULL,
 * `reg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 * `teacher_statue` varchar(15) DEFAULT NULL,
 **/

public class Teacher {
    private String teacherId;
    private String teacherNo;
    private String teacherName;
    private String teacherPassword;
    private String teacher_statue;
    private Date reg_time;
    private String teacherImg;
    private String teacherSex;

    /**
     * 外键引用
     * 多对多关系
     */
    private List<Course> teacherCourse;

    /*
     *外键引用
     */
    private Profession profession;

    public String getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(String teacherImg) {
        this.teacherImg = teacherImg;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacher_statue() {
        return teacher_statue;
    }

    public void setTeacher_statue(String teacher_statue) {
        this.teacher_statue = teacher_statue;
    }

    public Date getReg_time() {
        return reg_time;
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    public List<Course> getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(List<Course> teacherCourse) {
        this.teacherCourse = teacherCourse;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacher_statue='" + teacher_statue + '\'' +
                ", reg_time=" + reg_time +
                ", teacherImg='" + teacherImg + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherCourse=" + teacherCourse +
                ", profession=" + profession +
                '}';
    }
}
