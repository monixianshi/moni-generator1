package com.xy.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.xy.generator.MainGenerator;

import com.xy.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @program: moni-generator-basic
 * @description: 生成代码
 * @author: xieyu
 * @create: 2024-05-05 14:59
 **/

@Command(name = "generate", description = "生成代码：", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {
    /**
     * 是否循环
     */
    @Option(names = {"-l", "--loop"}, description = "是否循环:", arity = "0..1", interactive = true,echo = true)
    private boolean loop;
    /**
     * 作者（填充值）
     */
    @Option(names = {"-a", "--author"}, description = "作者:", arity = "0..1", interactive = true,echo = true)
    private String author = "xy";
    /**
     * 输出信息
     */
    @Option(names = {"-o", "--outputText"}, description = "输出信息:", arity = "0..1", interactive = true,echo = true)
    private String outputText = "计算结果：";

    @Override
    public Integer call() throws Exception {
        //创建一个参数模板
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();

        //将值复制到代码生成器
        BeanUtil.copyProperties(this, mainTemplateConfig);
        //执行代码生成器
        MainGenerator.doGenerator(mainTemplateConfig);
        return 0;
    }
}
