package com.tangbaobao.pojo;

/**
 * @author 唐学俊
 * @create 2018/02/20
 * <p>
 * `schoolId` int(11) NOT NULL AUTO_INCREMENT,
 * `schoolName` varchar(15) COLLATE utf8_bin DEFAULT NULL,
 * PRIMARY KEY (`schoolId`)
 **/

public class School {
    private String schoolId;
    private String schoolName;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId='" + schoolId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
