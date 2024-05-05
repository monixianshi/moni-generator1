package com.xy.cli.pattern;

/**
 * @program: moni-generator-basic
 * @description: 开启命令,相当于按钮
 * @author: xieyu
 * @create: 2024-05-04 11:14
 **/

public class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
