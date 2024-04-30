package com.xy.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @program: moni-generator
 * @description:静态文件生成器
 * @author: xieyu
 * @create: 2024-04-29 16:51
 **/

public class StaticGenerator {
    public static void main(String[] args) {
        //获取项目根目录
        String projectPath = System.getProperty("user.dir");
        //获取输入路径
        // File.separator：根据不同的操作系统获取路径分隔符
        String inputPath = projectPath + File.separator + "moni-generator-demo-project" + File.separator + "acm-template";
        //获取输出路径
        String outputPath = projectPath;
        //复制
        /*copyFilesByHutool(inputPath, outputPath);*/
        copyFilesByRecursive(inputPath,outputPath);
    }

    /**
     * 使用Hutool根据类将一个目录完整复制到另外一个目录下
     *
     * @param inputpath  输入目录地址
     * @param outputPath 输出目录地址
     */
    public static void copyFilesByHutool(String inputpath, String outputPath) {
        //false表示不覆盖目录
        FileUtil.copy(inputpath, outputPath, false);
    }


    /**
     * 递归拷贝文件（递归实现，会将输入目录完整拷贝到输出目录下)
     *
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFileByRecursive(inputFile, outputFile);
        } catch (Exception e) {
            System.err.println("文件复制失败");
            e.printStackTrace();
        }
    }

    /**
     * 18
     * 文件A =>目录 B，则文件A放在目录B下
     * 文件A=>文件B，则文件A覆盖文件B
     * 目录A=>目录B，则目录A放在目录B下
     * 核心思路:先创建目录，然后遍历目录内的文件，依次复制
     *
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    public static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutPutFile = new File(outputFile, inputFile.getName());//如果是目录，首先创建目标目录
            if (!destOutPutFile.exists()) {
                destOutPutFile.mkdirs();
            }
            //获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();//无子文件，直接结束
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                //递归拷贝下一层文件
                copyFileByRecursive(file, destOutPutFile);
            }
        } else {
            //是文件，直接复制到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }

    }
}
