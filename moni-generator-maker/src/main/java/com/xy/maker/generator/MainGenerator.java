package com.xy.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.xy.maker.generator.file.DynamicFileGenerator;
import com.xy.maker.generator.file.FileGenerator;
import com.xy.maker.meta.Meta;
import com.xy.maker.meta.MetaManager;
import com.xy.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @program: moni-generator-maker
 * @description: 测试生成器
 * @author: xieyu
 **/

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //获取JSON转化后的对象
        Meta meta = MetaManager.getMetaObject();
        System.out.println(meta);

        //输出路径
        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator + "generated";
        if (!FileUtil.exist(outputPath)) {
            FileUtil.mkdir(outputPath);
        }

        //读取resources目录
        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcePath = classPathResource.getAbsolutePath();

        //JAVA 包的路径
        //com.xy
        String outputBasePackage = meta.getBasePackage();
        //com/xy
        String outputBasePackagePath = StrUtil.join("/", StrUtil.split(outputBasePackage, "."));
        // generated/src/main/java/com/xy
        String outputBaseJavaPackagePath = outputPath + File.separator + "src/main/java/" + outputBasePackagePath;

        //文件输入路径
        String inputFilePath;
        //文件生成路径
        String outputFiletPath;

        //生成model/DataModel.java
        inputFilePath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
        outputFiletPath = outputBaseJavaPackagePath + File.separator + "model/DataModel.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFiletPath,meta);

        //生成cli/commandExecutor.java
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/commandExecutor.java.ftl";
        outputFiletPath = outputBaseJavaPackagePath + File.separator + "cli/commandExecutor.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFiletPath,meta);

        //生成cli/command/ConfigCommand.java
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
        outputFiletPath = outputBaseJavaPackagePath + File.separator + "cli/command/ConfigCommand.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFiletPath,meta);

        //生成cli/command/GenerateCommand.java
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
        outputFiletPath = outputBaseJavaPackagePath + File.separator + "cli/command/GenerateCommand.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFiletPath,meta);

        //生成cli/command/ListCommand.java
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
        outputFiletPath = outputBaseJavaPackagePath + File.separator + "cli/command/ListCommand.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFiletPath,meta);

        //生成Main.java
        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
        outputFiletPath = outputBaseJavaPackagePath + File.separator + "Main.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFiletPath,meta);

        //生成generator/DynamicGenerator.java
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/DynamicGenerator.java.ftl";
        outputFiletPath = outputBaseJavaPackagePath + File.separator + "generator/DynamicGenerator.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFiletPath,meta);

        //生成generator/FileGenerator.java
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/FileGenerator.java.ftl";
        outputFiletPath = outputBaseJavaPackagePath + File.separator + "generator/FileGenerator.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFiletPath,meta);

        //生成generator/StaticGenerator.java
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/StaticGenerator.java.ftl";
        outputFiletPath = outputBaseJavaPackagePath + File.separator + "generator/StaticGenerator.java";
        DynamicFileGenerator.doGenerator(inputFilePath,outputFiletPath,meta);
    }
}
