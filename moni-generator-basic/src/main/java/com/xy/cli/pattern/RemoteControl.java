package com.xy.cli.pattern;

/**
 * 相当于遥控器
 */
public class RemoteControl {
    private Command command;

    //相当于装填按钮
    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}