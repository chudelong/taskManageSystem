package com.tangbaobao.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/02/20
 * `taskId` int(11) NOT NULL AUTO_INCREMENT,
 * `typeId` int(11) DEFAULT NULL,
 * `courseId` int(11) DEFAULT NULL,
 * `taskName` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * `taskTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 * `taskDeac` varchar(255) COLLATE utf8_bin DEFAULT NULL,
 * `deadLine` timestamp NULL DEFAULT NULL,
 **/

public class Task {
    private int taskId;
    private String taskName;
    private Date taskTime;
    private String taskDesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadLine;

    /**
     * 外键引用
     */
    private Type type;
    private Course course;
    private List<Work> workList;


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Work> getWorkList() {
        return workList;
    }

    public void setWorkList(List<Work> workList) {
        this.workList = workList;
    }
}
