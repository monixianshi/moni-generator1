package com.xy.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @program: moni-generator-maker
 * @description: 将json文件读取为java对象
 * @author: xieyu
 * @create: 2024-06-27 17:07
 **/

public class MetaManager {

    //volatile关键字保证多线程情况下的内存可视化，保证meta对象修改时其他线程也可以看到
    private static volatile Meta meta;

    //创建一个双检索单例模式
    public static Meta getMetaObject() {
        //防止meta有值的时候线程还去抢锁，优化性能
        if (meta == null) {
            //当多个线程调用时会同时修改meta，所以要加锁
            synchronized (MetaManager.class) {
                //防止线程有值还进来
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    //单例模式结束
    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
//        todo 校验配置文件，处理默认值
        return newMeta;
    }
}
