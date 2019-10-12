<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#assign beanName = table.beanName/>
<#assign tableName = table.tableName/>
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#macro mapperPrimaryKey value>${r"#{"}${value.propertyName}}</#macro>
<#macro mapperPrimaryKeyWithRecord value>${r"#{record."}${value.propertyName}}</#macro>
<#macro mapperBeanInfo value>${r"#{"}${value.propertyName}}</#macro>
<#macro mapperBeanInfoWithParams value>${r"#{param1."}${value.propertyName}}</#macro>
<#macro mapperBeanInfoWithQuery value>${r"#{query."}${value.propertyName}}</#macro>
<#macro mapperBeanInfoWithRecord value>${r"#{record."}${value.propertyName}}</#macro>
<#macro mapperBeanInfoWithUpdate value>${r"#{condition."}${value.propertyName}}</#macro>
<#assign bean = config.basePackage+"."+config.bean+"."+beanName/>
<#assign dao = config.basePackage+"."+config.dao+"."+table.beanName+"Dao"/>
<#assign propertiesToColumns = table.propertiesToColumns/>
<#assign propertiesToColumnsKeys = propertiesToColumns?keys/>
<#assign queryConditionInfos = table.queryConditionInfos/>
<#assign pageConditionInfos = table.pageConditionInfos/>
<#assign updateConditionInfos = table.updateConditionInfos/>
<#assign primaryKey = table.primaryKey/>
<#assign primaryKeys = primaryKey?keys/>
<#assign beanInfos = table.beanInfos?values/>
<mapper namespace="${dao}">

    <resultMap id="BaseResultMap" type="${bean}">
    <#list beanInfos as beanInfo>
        <#if beanInfo.columnName !="${primaryKeys[0]}">
        <result column="${beanInfo.columnName}" jdbcType="${beanInfo.columnType}" property="${beanInfo.propertyName}"/>
        <#else>
        <id column="${beanInfo.columnName}" jdbcType="${beanInfo.columnType}" property="${beanInfo.propertyName}"/>
        </#if>
    </#list>
    </resultMap>

    <delete id="delete">
        delete from ${tableName}
        <include refid="findCondition" />
    </delete>

    <update id="logicDelete">
        update ${tableName}
        set deleted = 1
        <include refid="findCondition" />
    </update>

    <insert id="insert" keyColumn="${primaryKey["${primaryKeys[0]}"].columnName}" keyProperty="${primaryKeys[0]}" parameterType="${bean}" useGeneratedKeys="true">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list propertiesToColumnsKeys as key>
                <#if key !="${primaryKeys[0]}">
            <if test="${key} !=null">
                ${propertiesToColumns["${key}"]},
            </if>
                </#if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list beanInfos as beanInfo>
                <#if beanInfo.propertyName !="${primaryKeys[0]}">
            <if test="${beanInfo.propertyName} !=null">
                <@mapperBeanInfo beanInfo/>,
            </if>
                </#if>
            </#list>
        </trim>
    </insert>

    <update id="updateById">
        update ${tableName}
        <set>
            <#list beanInfos as beanInfo>
                <#if beanInfo.propertyName !="${primaryKeys[0]}">
            <if test="record.${beanInfo.propertyName} !=null">
                ${beanInfo.columnName} = <@mapperBeanInfoWithRecord beanInfo/>,
            </if>
                </#if>
            </#list>
        </set>
        where ${primaryKeys[0]} = <@mapperPrimaryKeyWithRecord primaryKey["${primaryKeys[0]}"]/> and site_id = ${r"#{record.siteId}"}
    </update>

    <update id="updateByCondition">
        update ${tableName}
        <set>
            <#list beanInfos as beanInfo>
                <#if beanInfo.propertyName !="${primaryKeys[0]}" && beanInfo.propertyName  !="createTime">
            <if test="record.${beanInfo.propertyName} !=null">
                ${beanInfo.columnName} = <@mapperBeanInfoWithRecord beanInfo/>,
            </if>
                </#if>
            </#list>
        </set>
        <where>
            <#list beanInfos as beanInfo>
                <#if beanInfo.propertyName  !="createTime">
            <if test="condition.${beanInfo.propertyName} !=null">
                and ${beanInfo.columnName} = <@mapperBeanInfoWithUpdate beanInfo/>
            </if>
                </#if>
            </#list>

            <#list updateConditionInfos as updateCondition>
            <if test="condition.${updateCondition.propertyName} != null">
                ${updateCondition.xmlSql}
            </if>
            </#list>
        </where>
    </update>

    <select id="getById" resultMap="BaseResultMap">
        <include refid="findColumn" />
        where id = ${r"#{id}"} and site_id = ${r"#{siteId}"} and deleted = 0
    </select>

    <select id="countByQuery" resultType="java.lang.Integer">
        select count(1) from ${tableName}
        <include refid="findCondition" />
    </select>

    <select id="selectByQuery" resultMap="BaseResultMap">
        <include refid="findColumn" />
        <include refid="findCondition" />
    </select>

    <select id="selectByQueryWithPage" parameterType="map" resultMap="BaseResultMap">
        <include refid="findColumn" />
        <include refid="findConditionWithPage" />
    </select>

    <sql id="baseColumnList">
        <#list propertiesToColumnsKeys as key>
        ${propertiesToColumns["${key}"]}<#if key_has_next>, </#if>
        </#list>
    </sql>

    <sql id="findColumn">
        select
        <include refid="baseColumnList" />
        from ${tableName}
    </sql>

    <sql id="findCondition">
        <where>
            <#list beanInfos as beanInfo>
            <if test="query.${beanInfo.propertyName} != null">
                and ${beanInfo.columnName} = <@mapperBeanInfoWithQuery beanInfo/>
            </if>
            </#list>

            <#list queryConditionInfos as queryCondition>
            <if test="query.${queryCondition.propertyName} != null">
                ${queryCondition.xmlSql}
            </if>
            </#list>
        </where>
    </sql>

    <sql id="findConditionWithPage">
        <where>
            <#list beanInfos as beanInfo>
            <if test="param1.${beanInfo.propertyName} != null">
                and ${beanInfo.columnName} = <@mapperBeanInfoWithParams beanInfo/>
            </if>
            </#list>

            <#list pageConditionInfos as pageCondition>
            <if test="param1.${pageCondition.propertyName} != null">
                ${pageCondition.xmlSql}
            </if>
            </#list>
        </where>
    </sql>

</mapper>