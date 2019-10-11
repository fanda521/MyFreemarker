package com.wang.tools;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FreeMarkerUtils {

    static  Configuration cfg = null;
    static {
        //初始化模板引擎
        cfg = new Configuration(Configuration.VERSION_2_3_29);
        //指定模板文件存放的地方
        cfg.setClassLoaderForTemplateLoading(FreeMarkerUtils.class.getClassLoader(), "templates");
        //设置字符编码集
        cfg.setDefaultEncoding("UTF-8");
        //设置异常的处理方式
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    // 可以获取模板 对象
   public static Template getTemplate(String templateName){
       try {
           return  cfg.getTemplate(templateName);
       } catch (Exception e){
           e.printStackTrace();
       }
        return null;
   }

    //提供模板文件文件，输出到控制台
    public static void printConsole(String templateName, Map dataModel){
        Template template = getTemplate(templateName);
        try {
            template.process(dataModel, new PrintWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //提供模板文件名称，输出到文件中
    public static void print2File(String templateName, Map dataModel,String destFile){
        Template template = getTemplate(templateName);
        try {
            template.process(dataModel, new FileWriter(new File(destFile)));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
