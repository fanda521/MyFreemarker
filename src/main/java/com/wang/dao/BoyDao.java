    package com.wang.dao;

    import com.wang.entity.Boy;
    import com.wang.tools.DbUtil;
    import java.lang.reflect.Field;
    import java.sql.*;

    public class BoyDao {
    private String schema;
    private String tableName;
    private Connection con=null;

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

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    /**
    *
    * @param schema  数据库名
    * @param tableName 表名
    */
    public BoyDao(String schema, String tableName) {
        this.schema = schema;
        this.tableName = tableName;
        con=DbUtil.getCon();
    }
    /**
    * 添加操作
    */
    public void save(Boy obj) throws SQLException {
    //拼凑sql语句
    String sql=createSql();
    System.out.println("sql="+sql);
    //执行数据库的操作
    execuSql(sql,obj);
    }
        public void execuSql(String sql,Boy obj) {

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            //1.获取对象的所有属性
            Class clazz = obj.getClass();
            Field[] Fields = clazz.getDeclaredFields();
            int i=1;
        for (Field field:Fields)
        {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            preparedStatement.setObject(i,value);
            i++;
        }
        boolean execute = preparedStatement.execute();
        System.out.println("执行情况："+execute);
        } catch (SecurityException e) {
        e.printStackTrace();
        } catch (SQLException e) {
        e.printStackTrace();
        } catch (IllegalAccessException e) {
        e.printStackTrace();
        }
    }

    public String createSql() throws SQLException {
        StringBuffer result=new StringBuffer("INSERT INTO "+tableName+"(");
        StringBuffer params=new StringBuffer(" (");

        con = DbUtil.getCon();//获取数据库连接
        DatabaseMetaData metaData = con.getMetaData();
        ResultSet columns = metaData.getColumns(null, schema, tableName, null);
        //如果不加表名，为空串""的话，他会查询该数据下的所有表的列
        while (columns.next())
        {
            Object column_name= columns.getObject("COLUMN_NAME");//不能有多余的空格
            System.out.println("column_name_="+column_name);
            params.append("?,");
            result.append(" "+column_name+",");
        }
        result.deleteCharAt(result.lastIndexOf(","));
        params.deleteCharAt(params.lastIndexOf(","));
        params.append(")");
        result.append(") VALUES").append(params);
        return  result.toString();
    }



    /**
    *查询操作
    * @param id 查询的ID
    * @return 返回的单个对象
    * @throws SQLException
    */
    public  Boy select(int id) throws SQLException {
        Boy boy=new Boy();
        //拼凑查询单个记录的sql语句
        String sql=createSelectSql();
        System.out.println("sql="+sql);
        //执行语句
        boy=execuSelectSql(sql,id);
        return boy;
    }


    /**
    *
    * @param sql 执行单条查询的语句
    * @return 返回一条记录，该记录封装在boy对象中
    */
    private Boy execuSelectSql(String sql,int id) throws SQLException
    {
        PreparedStatement pstatm = con.prepareStatement(sql);
        pstatm.setObject(1,id);
        ResultSet rs = pstatm.executeQuery();
        Boy boy=new Boy();
        Class clazz = Boy.class;
        Field[] Fields = clazz.getDeclaredFields();
        while (rs.next())
        {
            for (int i=0;i<Fields.length ;i++)
            {
                Object object = rs.getObject(i+1);
                Fields[i].setAccessible(true);
                try {
                    Fields[i].set(boy,object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        con.close();
        DbUtil.closeThreadLocal();
        return boy;
    }

    /**
    *
    * @return 查询单条记录的sql语句
    */
    private String createSelectSql()
    {
        //select * from boy where id=1;
        String sql="";
        sql="select * from boy where id=?";
        return sql;
    }


}



