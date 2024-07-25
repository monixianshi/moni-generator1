package com.xy.maker.generator;

import java.io.*;

/**
 * @program: moni-generator-maker
 * @description:
 * @author: xieyu
 * @create: 2024-06-30 14:37
 **/

public class JarGenerator {
    public static void doGenerator(String projectOir) throws IOException, InterruptedException {
        //Windows执行的命令
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        //其他系统执行的命令
        String OtherMavenCommand = "mvn clean package -DskipTests=true";
        String mavenCommand = winMavenCommand;

        //拆分命令防止直接读取命令为一个字符串
        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        //生成路径
        processBuilder.directory(new File(projectOir));
        //执行
        Process process = processBuilder.start();

        //读取命令的输出流
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        int exitCode = process.waitFor();
        System.out.println("命令执行结果："+exitCode);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerator("E:\\java2\\moni-generator\\moni-generator-basic");
    }
}
