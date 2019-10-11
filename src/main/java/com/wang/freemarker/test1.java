package com.wang.freemarker;

import com.wang.tools.FreeMarkerUtils;
import freemarker.template.Template;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        Map data=new HashMap();
        data.put("num",20);
        data.put("float",23.786);
        data.put("num2",-34.98);
        /*Template template = FreeMarkerUtils.getTemplate("freemarker.ftl");
        template.setDateFormat("yyyy:MM:dd");
        Map settings = template.getSettings();
        for (Object key:settings.keySet())
        {
            System.out.println("key="+key+" : value="+settings.get(key));
        }
        Set<String> settingNames = template.getSettingNames(true);
        Iterator<String> iterator = settingNames.iterator();
        while (iterator.hasNext())
        {
            System.out.println("name="+iterator.next()+" : value=");
        }*/
        System.out.println("--------------------------------------------------------------------------------");
        FreeMarkerUtils.printConsole("freemarker.ftl",data);
    }
}
