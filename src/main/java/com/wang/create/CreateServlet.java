package com.wang.create;

import com.wang.autocode.FieldObject;
import com.wang.tools.FieldsType;
import com.wang.tools.FreeMarkerUtils;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateServlet {

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
    public CreateServlet(String schema, String tableName) {
        this.schema = schema;
        this.tableName = tableName;
    }
    public static void main(String[] args) {
        CreateServlet t=new CreateServlet("test1","boy");
        try {
            t.template();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void template() throws SQLException {
        Map<String,Object> data=new HashMap<>();
        FieldsType ft=new FieldsType(schema,tableName);
        ft.getMeteData();
        List<FieldObject> list = ft.getList();
        String packageName = "com.wang.servlet";
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
        data.put("list",list);
        data.put("schema",schema);
        data.put("tableName",tableName);

        FreeMarkerUtils.print2File("autoCodeServlet.ftl",data,path+className+"Servlet.java");
    }
}
