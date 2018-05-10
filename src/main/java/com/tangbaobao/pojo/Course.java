package com.tangbaobao.pojo;

/**
 * 课程表
 *
 * @author 唐学俊
 * @create 2018/02/20
 * `couseId` varchar(50) NOT NULL,
 * `taskId` varchar(50) DEFAULT NULL,
 * `couseName` varchar(15) DEFAULT NULL,
 **/

public class Course {
    private int courseId;
    private String courseName;


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }



    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
