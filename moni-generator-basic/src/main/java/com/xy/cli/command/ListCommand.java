package com.xy.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

/**
 * @program: moni-generator-basic
 * @description: 遍历所有文件
 * @author: xieyu
 * @create: 2024-05-05 15:00
 **/
@CommandLine.Command(name = "list", description = "遍历所有文件：", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    @Override
    public void run() {
        //获取项目路径
        String projectPah = System.getProperty("user.dir");
        //获取根项目路径
        File parentFile = new File(projectPah).getParentFile();
        //获取parentFile下模板文件路径
        String inputPath = new File(parentFile, "moni-generator-demo-project/acm-template").getAbsolutePath();
        //循环输出文件目录
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
