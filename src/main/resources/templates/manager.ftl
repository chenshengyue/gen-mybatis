package ${config.basePackage}.${config.manager};
import ${config.basePackage}.${config.bean}.${table.beanName};
import ${config.basePackage}.${config.query}.${table.beanName}Query;
import ${config.basePackage}.${config.update}.${table.beanName}Update;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface ${table.beanName}Manager {

    void logicDelete(${table.beanName}Query query);

    void insert(${table.beanName} record);

    int updateById(${table.beanName} record);

    void updateByIdThrowException(${table.beanName} record);

    int update(${table.beanName} record, ${table.beanName}Update condition);

    void updateThrowException(${table.beanName} record, ${table.beanName}Update condition);

    ${table.beanName} getById(String siteId, Long id);

    ${table.beanName} getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(${table.beanName}Query query);

    List<${table.beanName}> selectByQuery(${table.beanName}Query query);

    List<${table.beanName}> selectByQueryThrowExceptionIfEmpty(${table.beanName}Query query);

    List<${table.beanName}> selectByQueryWithPage(${table.beanName}Query query, Pagination page);

}