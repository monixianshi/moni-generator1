package com.xy.cli.pattern;

/**
 * @program: moni-generator-basic
 * @description: 接收者
 * @author: xieyu
 * @create: 2024-05-04 11:09
 **/

public class Device {

    private String name;

    public Device(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name + "设备开启");
    }

    public void turnOff() {
        System.out.println(name + "设备关闭");
    }
}
