package com.xy.cli.pattern;

/**
 * 创建实际场景
 */
public class Client {
    public static void main(String[] args) {
        //创建接收者对象
        Device tv = new Device("TV");
        Device stereo = new Device("stereo");
        //创建具体命令对象，可以绑定不同设备
        TurnOnCommand turnon = new TurnOnCommand(tv);
        TurnOffCommand turnoff = new TurnOffCommand(stereo);
        //创建调用者
        RemoteControl remote = new RemoteControl();
        //执行命令
        remote.setCommand(turnon);
        remote.pressButton();


        remote.setCommand(turnoff);
        remote.pressButton();
    }
}