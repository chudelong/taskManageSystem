package com.tangbaobao.pojo;

import java.util.Date;

/**
 * 学生表
 * @author 唐学俊
 * @create 2018/02/20
 * `studentId` int(11) NOT NULL AUTO_INCREMENT,
 * `classId` int(11) DEFAULT NULL,
 * `studentNo` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * `studentName` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * `studentSex` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * `studentGrade` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * `studentPassword` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * `studentImg` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * `reg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 * `studentStatue` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * `studentDesc` varchar(255) COLL
 **/

public class Student {
    private int studentId;
    private String studentNo;
    private String studentName;
    private String studentSex;
    private String studentGrade;
    private String studentPassword;
    private String studentImg;
    private Date reg_time;
    private String studentStatue;
    private String studentDesc;
    private String studentEmail;

    /**
     * 外键引用
     */
    private Sclass sclass;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentImg() {
        return studentImg;
    }

    public void setStudentImg(String studentImg) {
        this.studentImg = studentImg;
    }

    public Date getReg_time() {
        return reg_time;
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    public String getStudentStatue() {
        return studentStatue;
    }

    public void setStudentStatue(String studentStatue) {
        this.studentStatue = studentStatue;
    }

    public String getStudentDesc() {
        return studentDesc;
    }

    public void setStudentDesc(String studentDesc) {
        this.studentDesc = studentDesc;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Sclass getSclass() {
        return sclass;
    }

    public void setSclass(Sclass sclass) {
        this.sclass = sclass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentGrade='" + studentGrade + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentImg='" + studentImg + '\'' +
                ", reg_time=" + reg_time +
                ", studentStatue='" + studentStatue + '\'' +
                ", studentDesc='" + studentDesc + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", sclass=" + sclass +
                '}';
    }
}
