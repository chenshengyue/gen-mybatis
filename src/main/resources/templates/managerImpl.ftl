package ${config.basePackage}.${config.managerImpl};

import ${config.basePackage}.${config.manager}.${table.beanName}Manager;
import ${config.basePackage}.${config.dao}.${table.beanName}Dao;
import ${config.basePackage}.${config.bean}.${table.beanName};
import ${config.basePackage}.${config.query}.${table.beanName}Query;
import ${config.basePackage}.${config.update}.${table.beanName}Update;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ${table.beanName}ManagerImpl implements ${table.beanName}Manager {

    @Autowired
    private ${table.beanName}Dao ${table.refBeanName}Dao;

    @Override
    public void insert(${table.beanName} record) {
        Date now = new Date();
        record.setDeleted(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        ${table.refBeanName}Dao.insert(record);
    }

    @Override
    public int updateById(${table.beanName} record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return ${table.refBeanName}Dao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(${table.beanName} record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(${table.beanName} record, ${table.beanName}Update condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return ${table.refBeanName}Dao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(${table.beanName} record, ${table.beanName}Update condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public ${table.beanName} getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return ${table.refBeanName}Dao.getById(siteId, id);
    }

    @Override
    public ${table.beanName} getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        ${table.beanName} result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(${table.beanName}Query query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        if (query.getDeleted() == null) {
            query.setDeleted(false);
        }
        return ${table.refBeanName}Dao.countByQuery(query);
    }

    @Override
    public List<${table.beanName}> selectByQuery(${table.beanName}Query query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        if (query.getDeleted() == null) {
            query.setDeleted(false);
        }
        return ${table.refBeanName}Dao.selectByQuery(query);
    }

    @Override
    public List<${table.beanName}> selectByQueryThrowExceptionIfEmpty(${table.beanName}Query query) {
        List<${table.beanName}> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<${table.beanName}> selectByQueryWithPage(${table.beanName}Query query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        if (query.getDeleted() == null) {
            query.setDeleted(false);
        }
        return ${table.refBeanName}Dao.selectByQueryWithPage(query, page);
    }

}