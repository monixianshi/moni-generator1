package com.xy;

import com.xy.maker.cli.CommandExecutor;

/**
 * @program: moni-generator-basic
 * @description: 用户执行主方法
 * @author: xieyu
 * @create: 2024-05-05 16:06
 **/

public class Main {
    public static void main(String[] args) {
//        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"list"};
//        args = new String[]{"config"};
        //创建主命令工具
        CommandExecutor commandExecutor = new CommandExecutor();
        //执行
        commandExecutor.doExecutor(args);
    }
}
