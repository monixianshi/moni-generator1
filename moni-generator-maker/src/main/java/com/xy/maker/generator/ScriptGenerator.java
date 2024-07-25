package com.xy.maker.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * @program: moni-generator-maker
 * @description: 生成运行jar包的脚本文件
 * @author: xieyu
 * @create: 2024-07-25 14:39
 **/

public class ScriptGenerator {

    public static void doGenerator(String outputPath,String jarPath){
        StringBuilder sb = new StringBuilder();
        //运行jar包
        sb.append("#!/bin/bash").append("\n");
        sb.append(String.format("java -jar %s \"$@\"",jarPath));
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8),outputPath);

        //添加可执行权限
        try {
            Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
            Files.setPosixFilePermissions(Paths.get(outputPath),permissions);
        } catch (Exception e) {
        }
        //windows脚本
        sb = new StringBuilder();
        //运行jar包
        sb.append("@echo off").append("\n");
        sb.append(String.format("java -jar %s %%*",jarPath));
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8),outputPath + ".bat");

    }
}
