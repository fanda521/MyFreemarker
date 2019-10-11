package com.wang.create;

import com.wang.autocode.FieldObject;
import com.wang.tools.FieldsType;
import com.wang.tools.FreeMarkerUtils;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateJsp {

    private String schema;
    private String tableName;



    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     *
     * @param schema  数据库名
     * @param tableName 表名
     */
    public CreateJsp(String schema, String tableName) {
        this.schema = schema;
        this.tableName = tableName;
    }

    public static void main(String[] args) {
        CreateJsp cj=new CreateJsp("test1","course");
        try {
            cj.template();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public   void   template() throws SQLException {
        FieldsType ft=new FieldsType(schema,tableName);
        ft.getMeteData();
        List<FieldObject>  list= ft.getList();
        String path =   "src/main/webapp/" ;
        File filepath = new File(path);
        if(!filepath.exists()){
            filepath.mkdirs();
        }
        //类名称
        String className = "";//auto code
        String[] names = tableName.split("_");
        for (String s : names){
            className = className + s.substring(0, 1).toUpperCase()+ s.substring(1);
        }
        Map<String,Object> data=new HashMap<>();
        data.put("tableName",tableName);
        data.put("list",list);
        FreeMarkerUtils.print2File("autoCodeJsp.ftl",data,path+className+".jsp");

    }

}
