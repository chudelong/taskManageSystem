package com.tangbaobao.vo;

/**
 * @author 唐学俊
 * @create 2018/04/21
 **/

public class FileName {
    private String taskName;
    private String  courseName;
    private String studentName;
    private String studentNo;
    private String className;
    private String professionName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public String toString() {
        return "FileName{" +
                "taskName='" + taskName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentNo='" + studentNo + '\'' +
                '}';
    }
}
