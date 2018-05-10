package com.tangbaobao.pojo;

/**
 * @author 唐学俊
 * @create 2018/02/20
 * `classId` int(11) NOT NULL AUTO_INCREMENT,
 * `professionId` int(11) DEFAULT NULL,
 * `className` varchar(15) COLLATE
 **/

public class Sclass {
    private String classId;
    private String className;
    /**
     * 外键引用
     */
    private Profession profession;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Sclass{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", profession=" + profession +
                '}';
    }
}
