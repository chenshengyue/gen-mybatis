package ${config.basePackage}.${config.dao};
import ${config.basePackage}.${config.bean}.${table.beanName};
import ${config.basePackage}.${config.query}.${table.beanName}Query;
import ${config.basePackage}.${config.update}.${table.beanName}Update;
<#--import ${config.basePackage}.mybatis.MyBatisRepository;-->
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

<#--@MyBatisRepository-->
public interface ${table.beanName}Dao {

    int delete(@Param("query") ${table.beanName}Query query);

    int logicDelete(@Param("query") ${table.beanName}Query query);

    int insert(${table.beanName} record);

    int updateById(@Param("record") ${table.beanName} record);

    int updateByCondition(@Param("record") ${table.beanName} record, @Param("condition") ${table.beanName}Update condition);


    ${table.beanName} getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") ${table.beanName}Query query);

    List<${table.beanName}> selectByQuery(@Param("query") ${table.beanName}Query query);

    List<${table.beanName}> selectByQueryWithPage(${table.beanName}Query query, Pagination page);

}