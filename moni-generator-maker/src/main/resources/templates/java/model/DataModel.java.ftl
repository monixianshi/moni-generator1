package ${basePackage}.maker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: moni-generator
 * @description:数据模型
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataModel {

<#list modelConfig.models as modelInfo>

    <#if modelInfo.description??>
        /**
        * ${modelInfo.description}
        */
    </#if>
    private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;

</#list>
}
