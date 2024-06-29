package com.xy.maker.generator.file;

import com.xy.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @program: moni-generator
 * @description: 动静结合生成代码
 * @author: xieyu
 * @create: 2024-05-01 09:31
 **/

public class FileGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //定义数据模型
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("xy");
        dataModel.setOutputText("计算：");
        dataModel.setLoop(false);
        doGenerator(dataModel);

    }

    public static void doGenerator(Object model) throws TemplateException, IOException {



        //静态生成
        //获取项目根目录
        String projectPath = System.getProperty("user.dir");
        //获取项目根路径
        File parentFile = new File(projectPath).getParentFile();
        //获取输入路径
        // File.separator：根据不同的操作系统获取路径分隔符
        String inputPath = new File(parentFile,"moni-generator-demo-project/acm-template").getAbsolutePath();
        //获取输出路径
        String outputPath = projectPath;
        //复制
        /*copyFilesByHutool(inputPath, outputPath);*/
        StaticFileGenerator.copyFilesByHutool(inputPath,outputPath);


        //动态生成
        String dynamicInputPath = projectPath +File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath+File.separator +"acm-template/src/com/xy/acm/MainTemplate.java";

        DynamicFileGenerator.doGenerator(dynamicInputPath,dynamicOutputPath,model);
    }
}
