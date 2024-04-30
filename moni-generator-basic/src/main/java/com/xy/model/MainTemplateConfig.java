package com.xy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: moni-generator
 * @description:
 * @author: xieyu
 * @create: 2024-04-30 10:58
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainTemplateConfig {
    /**
     * 是否循环
     */
    private boolean loop;
    /**
     * 作者（填充值）
     */
    private String author="xy";
    /**
     * 输出信息
     */
    private String outputText="计算结果：";

}
