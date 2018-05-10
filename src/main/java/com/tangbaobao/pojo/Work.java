package com.tangbaobao.pojo;

import java.util.Date;

/**
 * 作业提交表
 *
 * @author 唐学俊
 * @create 2018/04/16
 * `workId` int(11) NOT NULL AUTO_INCREMENT,
 * `studentNo` int(11) NOT NULL,
 * `taskId` int(11) NOT NULL,
 * `workTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 * `workStatue` varchar(15) COLLAT
 **/

public class Work {
    private int workId;
    private Date workTime;
    private String workStatue;
    private String fileName;
    private String filePath;
    private String otherMessage;

    /**
     * 外键
     */
    private Student student;
    private Task task;


    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public String getWorkStatue() {
        return workStatue;
    }

    public void setWorkStatue(String workStatue) {
        this.workStatue = workStatue;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getOtherMessage() {
        return otherMessage;
    }

    public void setOtherMessage(String otherMessage) {
        this.otherMessage = otherMessage;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workId=" + workId +
                ", workTime=" + workTime +
                ", workStatue='" + workStatue + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", otherMessage='" + otherMessage + '\'' +
                ", student=" + student +
                ", task=" + task +
                '}';
    }
}
