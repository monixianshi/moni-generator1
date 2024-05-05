package com.xy.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
// some exports omitted for the sake of brevity

/**
 * mixinStandardHelpOptions: 是否打印帮助信息
 */
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {

    //通过"-s"或"--font-size"命令给fontSize赋值
    //names: 指定命令
    //description: 命令注释
    //required = true: 设置参数为用户必填
    @Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    //paramLabel： 用户展示信息
    //defaultValue： 参数默认值
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };

    @Override
    public void run() {
        //自己实现的逻辑
        System.out.println("fontSize="+fontSize);
        System.out.println("word="+String.join(",",words));
    }

    public static void main(String[] args) {
        //CommandLine： 创建一个命令行工具
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        //退出
        System.exit(exitCode);
    }
}