package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

/**
 * @program: moni-generator
 * @description: 动态文件生成器，使用FreeMarker实现
 * @author: xieyu
 **/

public class DynamicGenerator {
    /**
     *
     * @param inputpath
     * @param outputpath
     * @param model
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerator(String inputpath,String outputpath,Object model) throws IOException, TemplateException {

        // new 出configuration对象,参数为FreeMarker版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        //指定模板文件所在的路径
        File TemplateFile = new File(inputpath).getParentFile();
        configuration.setDirectoryForTemplateLoading(TemplateFile);
        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        //解决数据地区敏感格式带来的问题如2024在freemaker中为2,023
        configuration.setNumberFormat("0.#####");
        //创建模板对象,加载指定模板
        String templateName = new File(inputpath).getName();
        Template template = configuration.getTemplate(templateName);
//        如果没有文件则创建该文件夹

        if(!FileUtil.exist(outputpath)){
            FileUtil.touch(outputpath);
        }

        //指定生成文件

        Writer out = new FileWriter(outputpath);
        //调用模板生成文件
        template.process(model, out);
        //生成文件后别忘了关闭哦
        out.close();

    }
}
