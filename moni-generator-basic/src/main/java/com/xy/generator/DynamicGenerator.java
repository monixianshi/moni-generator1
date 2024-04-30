package com.xy.generator;

import com.xy.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: moni-generator
 * @description: 动态文件生成器，使用FreeMarker实现
 * @author: xieyu
 * @create: 2024-04-30 11:16
 **/

public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {

        //获取项目根目录
        //获取输入路径
        // File.separator：根据不同的操作系统获取路径分隔符
        String projrctPath = System.getProperty("user.dir") + File.separator + "moni-generator-basic";
        String inputPath = projrctPath +File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projrctPath+File.separator +"MainTemplate.java";

        //定义数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("xy");
        mainTemplateConfig.setOutputText("结果：");
        mainTemplateConfig.setLoop(true);

       doGenerator(inputPath,outputPath,mainTemplateConfig);

    }

    /**
     *
     * @param inputpath
     * @param outputpath
     * @param model
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerator(String inputpath,String outputpath,Object model) throws IOException, TemplateException {

        // new 出configuration对象,参数为FreeMarker版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        //指定模板文件所在的路径
        File TemplateFile = new File(inputpath).getParentFile();
        configuration.setDirectoryForTemplateLoading(TemplateFile);
        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        //解决数据地区敏感格式带来的问题如2024在freemaker中为2,023
        configuration.setNumberFormat("0.#####");
        //创建模板对象,加载指定模板
        String templateName = new File(inputpath).getName();
        Template template = configuration.getTemplate(templateName);

        //定义数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("xy");
        mainTemplateConfig.setOutputText("结果：");
        mainTemplateConfig.setLoop(true);

        //指定生成文件

        Writer out = new FileWriter(outputpath);
        //调用模板生成文件
        template.process(mainTemplateConfig, out);
        //生成文件后别忘了关闭哦
        out.close();

    }
}
