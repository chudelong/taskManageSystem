package com.tangbaobao.vo;

import java.util.Date;

/**
 * @author 唐学俊
 * @create 2018/04/30
 **/

public class SubmitTaskInfo {
    private String workId;
    private String workStatue;
    private String taskName;
    private String studentName;
    private String courseName;
    private String typeName;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getWorkStatue() {
        return workStatue;
    }

    public void setWorkStatue(String workStatue) {
        this.workStatue = workStatue;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    private Date workTime;

}
