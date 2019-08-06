package ${config.basePackage}.${config.bean};
import lombok.Getter;
import lombok.Setter;
<#list table.packages as package>
${package}
</#list>

@Getter
@Setter
public class ${table.beanName} {
<#assign properties = table.properties/>
<#assign beanInfos = table.beanInfos?values/>
<#assign keys = properties?keys/>
<#list beanInfos as beanInfo>

    //${beanInfo.propertyDesc}
    private ${beanInfo.propertyType} ${beanInfo.propertyName};
</#list>

}
