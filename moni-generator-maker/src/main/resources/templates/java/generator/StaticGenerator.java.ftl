package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;

/**
 * @program: moni-generator
 * @description:静态文件生成器
 * @author: xieyu
 **/

public class StaticGenerator {


    /**
     * 使用Hutool根据类将一个目录完整复制到另外一个目录下
     *
     * @param inputpath  输入目录地址
     * @param outputPath 输出目录地址
     */
    public static void copyFilesByHutool(String inputpath, String outputPath) {
        //false表示不覆盖目录
        FileUtil.copy(inputpath, outputPath, false);
    }
}
