package com.seatent.mars.biz.dubbo.manager.impl;

import com.seatent.mars.biz.dubbo.manager.CacheKeyManager;
import com.seatent.mars.dao.CacheKeyDao;
import com.seatent.mars.entity.CacheKey;
import com.seatent.mars.query.CacheKeyQuery;
import com.seatent.mars.update.CacheKeyUpdate;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CacheKeyManagerImpl implements CacheKeyManager {

    @Autowired
    private CacheKeyDao cacheKeyDao;

    @Override
    public void insert(CacheKey record) {
        Date now = new Date();
        record.setDeleted(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        cacheKeyDao.insert(record);
    }

    @Override
    public int updateById(CacheKey record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return cacheKeyDao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(CacheKey record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(CacheKey record, CacheKeyUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return cacheKeyDao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(CacheKey record, CacheKeyUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public CacheKey getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return cacheKeyDao.getById(siteId, id);
    }

    @Override
    public CacheKey getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        CacheKey result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(CacheKeyQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return cacheKeyDao.countByQuery(query);
    }

    @Override
    public List<CacheKey> selectByQuery(CacheKeyQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return cacheKeyDao.selectByQuery(query);
    }

    @Override
    public List<CacheKey> selectByQueryThrowExceptionIfEmpty(CacheKeyQuery query) {
        List<CacheKey> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<CacheKey> selectByQueryWithPage(CacheKeyQuery query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return cacheKeyDao.selectByQueryWithPage(query, page);
    }

}