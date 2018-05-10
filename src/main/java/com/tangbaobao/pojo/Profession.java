package com.tangbaobao.pojo;

/**
 * @author 唐学俊
 * @create 2018/02/20
 * `professionId` int(11) NOT NULL AUTO_INCREMENT,
 * `collegeId` int(11) DEFAULT NULL,
 * `professionName` varchar(15) CO
 **/

public class Profession {
    private String professionId;
    private String professionName;

    /**
     * 外键引用
     */
    private College college;


    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "professionId='" + professionId + '\'' +
                ", professionName='" + professionName + '\'' +
                ", college=" + college +
                '}';
    }
}
