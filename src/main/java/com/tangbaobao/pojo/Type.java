package com.tangbaobao.pojo;

/**
 * 作业类型表
 *
 * @author 唐学俊
 * @create 2018/02/20
 * `typeId` varchar(50) NOT NULL,
 * `typeName` varchar(15) DEFAULT NULL,
 * PRIMARY KEY (`typeId`)
 **/

public class Type {
    private String typeId;
    private String typeName;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
