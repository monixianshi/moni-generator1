package ${basePackage};

import ${basePackage}.cli.CommandExecutor;

/**
 * @program: moni-generator-basic
 * @description: 用户执行主方法
 **/

public class Main {
    public static void main(String[] args) {
        //创建主命令工具
        CommandExecutor commandExecutor = new CommandExecutor();
        //执行
        commandExecutor.doExecutor(args);
    }
}
