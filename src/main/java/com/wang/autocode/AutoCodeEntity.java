package com.wang.autocode;

import com.wang.tools.DbUtil;
import com.wang.tools.FreeMarkerUtils;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoCodeEntity {
    private String schema;
    private String tableName;
    private List<FieldObject> list;

    public List<FieldObject> getList() {
        return list;
    }

    public void setList(List<FieldObject> list) {
        this.list = list;
    }

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
    public AutoCodeEntity(String schema, String tableName) {
        this.schema = schema;
        this.tableName = tableName;
    }

    public static void main(String[] args) throws SQLException {
       AutoCodeEntity a2=new AutoCodeEntity("test1","boy");
        try {
            a2.getMeteData();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            a2.template();
    }
/**
 * 操作步骤
 * 1.连接数据库，获取数据库表的元数据
 * 2.将接收到的数据处理成实体类模板的格式，然后放入FieldObject中
 * 3.使用模板类，将数据填充到模板中的相应位置，完成替换
 * 4.运行程序查看结果，新建类测试通用性
 */

    /**
     *1.连接数据库，获取数据库表的元数据
     *2.将接收到的数据处理成实体类模板的格式，然后放入FieldObject中
     * @return 返回的是FieldObject类型的list
     * @throws SQLException
     */
    public void getMeteData() throws SQLException {
        Connection con = DbUtil.getCon();//获取数据库连接
        DatabaseMetaData metaData = con.getMetaData();
        ResultSet columns = metaData.getColumns(null, schema, tableName, null);
        //如果不加表名，为空串""的话，他会查询该数据下的所有表的列
        list=new ArrayList<FieldObject>();
        while (columns.next())
        {
            Object column_name= columns.getObject("COLUMN_NAME");//不能有多余的空格
            Object type_name = columns.getObject("TYPE_NAME");
            Object remarks = columns.getObject("REMARKS");
            System.out.println("column_name_="+column_name+" : type_name="+type_name+" : remarks="+remarks);
            String fieldName = getFieldName(column_name+"");
            FieldObject field=new FieldObject(fieldName,type_name+"",remarks+"");
            list.add(field);
        }

    }

    /**
     * 将数据库中表的字段变成java里实体成员变量的
     * 格式：id，familyAddress（第一个字母小写第二个及以后的首字母大写）
     * @param name 数据库里的列名
     * @return 实体类的成员变量名
     */
    public String getFieldName(String name){
        String temp="";
        String[] s = name.split("_");
        if (s.length==1){
            temp=s[0];
        }
        else {
            temp=s[0];
            for (int i=1;i<s.length;i++){
                temp=temp+s[i].substring(0,1).toUpperCase()+s[i].substring(1);
            }
        }
        return  temp;
    }
    //3.使用模板类，将数据填充到模板中的相应位置，完成替换
    public void template() throws SQLException {
        getMeteData();
        //编写一个模板,利用生成一个类
        String packageName = "com.wang.entity";
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
        //map
        Map<String,Object> data=new HashMap<>();
        data.put("packageName",packageName);
        data.put("className",className);
        data.put("fields",list);
        FreeMarkerUtils.print2File("entity.ftl",data,path+className+".java");
    }
}
