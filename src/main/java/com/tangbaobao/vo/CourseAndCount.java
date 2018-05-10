package com.tangbaobao.vo;

import com.tangbaobao.pojo.Course;

/**
 * @author 唐学俊
 * @create 2018/04/17
 **/

public class CourseAndCount {
   private Course courseName;
   private int count;

    public Course getCourse() {
        return courseName;
    }

    public void setCourse(Course course) {
        this.courseName = course;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CourseAndCount{" +
                "course=" + courseName +
                ", count=" + count +
                '}';
    }
}
