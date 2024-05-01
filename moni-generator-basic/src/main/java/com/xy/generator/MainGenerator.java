package com.xy.generator;

import com.xy.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @program: moni-generator
 * @description: 动静结合生成代码
 * @author: xieyu
 * @create: 2024-05-01 09:31
 **/

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //静态生成
        //获取项目根目录
        String projectPath = System.getProperty("user.dir");
        //获取输入路径
        // File.separator：根据不同的操作系统获取路径分隔符
        String inputPath = projectPath + File.separator + "moni-generator-demo-project" + File.separator + "acm-template";
        //获取输出路径
        String outputPath = projectPath;
        //复制
        /*copyFilesByHutool(inputPath, outputPath);*/
        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);


        //动态生成
        String dynamicProjrctPath = System.getProperty("user.dir") + File.separator + "moni-generator-basic";
        String dynamicInputPath = dynamicProjrctPath +File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath+File.separator +"acm-template/src/com/xy/acm/MainTemplate.java";

        //定义数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("xy");
        mainTemplateConfig.setOutputText("计算：");
        mainTemplateConfig.setLoop(false);

        DynamicGenerator.doGenerator(dynamicInputPath,dynamicOutputPath,mainTemplateConfig);
    }
}
