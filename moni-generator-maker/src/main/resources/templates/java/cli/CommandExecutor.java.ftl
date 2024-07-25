package ${basePackage}.cli;

import ${basePackage}.cli.command.ConfigCommand;
import ${basePackage}.cli.command.GenerateCommand;
import ${basePackage}.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @program: moni-generator-basic
 * @description: 主命令工具，相当于遥控器
 **/
@Command(name = "${name}", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {


    //调用子命令
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());

    }

    //提示信息
    @Override
    public void run() {
        System.out.println("请输入具体命令，输入--help查看帮助手册");
    }

    //传递参数并调用子命令集
    public Integer doExecutor(String[] args){
        return commandLine.execute(args);
    }
}
