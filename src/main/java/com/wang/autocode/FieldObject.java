package com.wang.autocode;

public class FieldObject {
    //name varchar(20) comment "姓名",
    private String columnName;//列名
    private String typeName;//列的类型名
    private String remarks;//列的注解

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTypeName() {
        switch (typeName)
        {
            case "INT" :
                typeName=FieldTypeEnum.INT.getValue();
                break;
            case "VARCHAR" :
                typeName=FieldTypeEnum.VARCHAR.getValue();
                break;
            case "DOUBLE" :
                typeName=FieldTypeEnum.DOUBLE.getValue();
                break;
            case "FLOAT" :
                typeName=FieldTypeEnum.FLOAT.getValue();
                break;
            case "TIMESTAMP" :
                typeName=FieldTypeEnum.TIMESTAMP.getValue();
                break;
            default:
                break;
        }
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public FieldObject(String columnName, String typeName, String remarks) {
        this.columnName = columnName;
        this.typeName = typeName;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "FieldObject{" +
                "columnName='" + columnName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
