package com.tangbaobao.pojo;

/**
 * @author 唐学俊
 * @create 2018/02/20
 * `collegeId` int(11) NOT NULL AUTO_INCREMENT,
 * `schoolId` int(11) DEFAULT NULL,
 * `collegeName` varchar(15) COLLA
 **/

public class College {
    private int collegeId;
    private String collegeName;
    /**
     * 外键引用
     */
    private School school;

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                ", school=" + school +
                '}';
    }
}

