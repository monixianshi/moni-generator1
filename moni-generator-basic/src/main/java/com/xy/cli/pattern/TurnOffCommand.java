package com.xy.cli.pattern;

/**
 * @program: moni-generator-basic
 * @description: 关闭命令,相当于按钮
 * @author: xieyu
 * @create: 2024-05-04 11:16
 **/

public class TurnOffCommand implements Command {

    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }

}
