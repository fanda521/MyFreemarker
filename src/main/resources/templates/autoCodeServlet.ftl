    package ${packageName};

    import com.wang.dao.${className}Dao;
    import com.wang.entity.${className};
    import com.wang.tools.MyServlet;

    import javax.servlet.ServletRequest;
    import javax.servlet.ServletResponse;
    import javax.servlet.annotation.WebServlet;
    import java.sql.SQLException;

    @WebServlet(name = "${className}Servlet",urlPatterns = "/${className}Servlet")
    public class ${className}Servlet extends MyServlet {
        <#list list as var>
        private  ${var.typeName} ${var.columnName};
        </#list>
    @Override
        public void executeService(ServletRequest req, ServletResponse res) {
        <#list list as var>
        System.out.println("${var.columnName}="+${var.columnName});
        </#list>
            ${className} ${className?uncap_first}=null;
            if(${list[0].columnName}==0){
                <#assign param="" >
                <#list list as var>
                    <#if var?is_first>
                       <#assign param=param+"null,">
                    <#elseif  var?is_last>
                        <#assign param=param+var.columnName>
                    <#else >
                        <#assign param=param+var.columnName+",">
                    </#if>
                </#list>
                ${className?uncap_first}=new ${className}(${param} );
            }
            else {
                <#assign param2="" >
                <#list list as var>
                    <#if var?is_last>
                        <#assign param2=param2+var.columnName>
                    <#else >
                        <#assign param2=param2+var.columnName+",">
                    </#if>
                </#list>
                ${className?uncap_first}=new ${className}( ${param2});
            }

            ${className}Dao ${className?uncap_first}Dao=new ${className}Dao("${schema}","${tableName}");
            try {
            ${className?uncap_first}Dao.save(${className?uncap_first});
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
