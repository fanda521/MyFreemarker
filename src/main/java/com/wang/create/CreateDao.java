package com.wang.create;

import com.wang.tools.FreeMarkerUtils;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class CreateDao {
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
    public CreateDao(String schema, String tableName) {
        this.schema = schema;
        this.tableName = tableName;
    }
    public static void main(String[] args) {
        CreateDao cd=new CreateDao("test1","course");
        cd.template();

    }

    public void template() {
        Map<String,Object> data=new HashMap<>();

        String packageName = "com.wang.dao";
        //生产的类存放的路径
        String path =   "src/main/java/" + packageName.replaceAll("\\.", "/") + "/";
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
        data.put("packageName",packageName);
        data.put("className",className);
        FreeMarkerUtils.print2File("autoCodeDao.ftl",data,path+className+"Dao.java");
    }
}
