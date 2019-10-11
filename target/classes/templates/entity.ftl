package ${packageName};

    public class ${className?cap_first} {

    <#list fields as field>
     //${field.remarks}
     private ${field.typeName} ${field.columnName};
    </#list>

    public ${className?cap_first}(){

    }


    public  ${className?cap_first}(<#compress >
    <#list fields as field>
        <#compress>
            <#if field_index==fields?size-1>
                ${field.typeName} ${field.columnName}
            <#else>
                ${field.typeName} ${field.columnName},
            </#if>
        </#compress>
    </#list> )</#compress>
    {
<#list fields as field>
    <#compress >this.${field.columnName} = ${field.columnName};</#compress>
</#list>
    }



    <#list fields as field>
    public ${field.typeName} get${field.columnName?cap_first}() {
        return ${field.columnName};
    }

    public void set${field.columnName?cap_first}(${field.typeName} ${field.columnName}) {
        this.${field.columnName} = ${field.columnName};
    }

    </#list>


    @Override
    public String toString() {
    return "${className}{" +
    <#list fields as field>
        "${field.columnName}= " + ${field.columnName} +"  "+
    </#list>
    "}";
    }
}
