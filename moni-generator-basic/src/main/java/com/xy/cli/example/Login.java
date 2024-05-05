package com.xy.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @program: moni-generator-basic
 * @description:
 * @author: xieyu
 * @create: 2024-05-04 10:12
 * Callable: 使用交互式命令行时实现该接口
 * Integer： 退出码
 **/

public class Login implements Callable<Integer> {
    @Option(names ={"-u","--user"},description = "user:")
    String user;

    //interactive: 是否将命令设置为可交互的
    @Option(names ={"-p","--password"},description = "password:",interactive = true)
    String password;

    //echo: 是否显示参数(当用jar包运行时),默认值为false
    //prompt：自定义提示
    //arity: 表示可以接收几个参数;0..1表示可以传递0个或1个值，表示可以通过用户交互传递，也可以直接传递
    @Option(names ={"-p2","--password2"},description = "password2:",arity = "0..1",interactive = true,echo = false,prompt = "请输入密码：")
    String password2;



    @Override
    public Integer call() throws Exception {
        System.out.println("password="+password);
        System.out.println("password2="+password2);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u","user1","-p","-p2","xxx");
    }
}
