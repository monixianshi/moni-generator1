package com.xy.cli.command;

import cn.hutool.core.util.ReferenceUtil;
import cn.hutool.core.util.ReflectUtil;
import com.xy.model.MainTemplateConfig;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * @program: moni-generator-basic
 * @description: 获取用户需要输入的字段信息
 * @author: xieyu
 * @create: 2024-05-05 15:00
 **/
@Command(name = "config", description = "获取用户需要输入的字段信息：", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {
    @Override
    public void run() {
        //利用hutool反射工具动态获取文件参数信息
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名：" + field.getName());
            System.out.println("字段类型：" + field.getType());
            System.out.println("______________________");
        }
    }
}
