package ${basePackage}.cli.command;

import cn.hutool.core.bean.BeanUtil;
import ${basePackage}.generator.file.FileGenerator;

import ${basePackage}.model.DataModel;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @program: moni-generator-basic
 * @description: 生成代码
 **/

@Command(name = "generate", description = "生成代码：", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {
 <#list modelConfig.models as modelInfo>
     /**
     * ${modelInfo.description}
     */
     @Option(names = {<#if modelInfo.abbr??>"-${modelInfo.abbr}",</#if>"--${modelInfo.fieldName}"}, description = "<#if modelInfo.description??>${modelInfo.description},</#if>", arity = "0..1", interactive = true,echo = true)
     private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??>=${modelInfo.defaultValue?c}</#if>;
 </#list>
    @Override
    public Integer call() throws Exception {
        //创建一个参数模板
        DataModel dataModel = new DataModel();

        //将值复制到代码生成器
        BeanUtil.copyProperties(this, dataModel);
        //执行代码生成器
        FileGenerator.doGenerator(dataModel);
        return 0;
    }
}
