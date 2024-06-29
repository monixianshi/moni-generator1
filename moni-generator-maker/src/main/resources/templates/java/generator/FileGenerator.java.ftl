package ${basePackage}.generator;

import ${basePackage}.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @program: moni-generator
 * @description: 动静结合生成代码
 **/

public class FileGenerator {
    public static void doGenerator(Object model) throws TemplateException, IOException {
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        String inputPath;
        String outputPath;
<#list fileConfig.files as fileInfo>
        //获取输入路径
        inputPath = new File(inputPath,"${fileInfo.inputPath}").getAbsolutePath();
        //获取输出路径
        outputPath = new File(outputPath,"${fileInfo.outputPath}").getAbsolutePath();
    <#if fileInfo.generateType == "static">
        //静态生成
        StaticFileGenerator.copyFilesByHutool(inputPath,outputPath);
    <#else>
        //动态生成
        DynamicFileGenerator.doGenerator(dynamicInputPath,dynamicOutputPath,model);
    </#if>
</#list>

    }
}
