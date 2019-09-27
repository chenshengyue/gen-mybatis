package com.seatent.uranus.biz.manager.b2c.impl;

import com.seatent.uranus.biz.manager.b2c.api.B2cPosterGoodsRefManager;
import com.seatent.uranus.dao.b2c.B2cPosterGoodsRefDao;
import com.seatent.uranus.entity.b2c.B2cPosterGoodsRef;
import com.seatent.uranus.query.B2cPosterGoodsRefQuery;
import com.seatent.uranus.update.B2cPosterGoodsRefUpdate;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class B2cPosterGoodsRefManagerImpl implements B2cPosterGoodsRefManager {

    @Autowired
    private B2cPosterGoodsRefDao b2cPosterGoodsRefDao;

    @Override
    public void insert(B2cPosterGoodsRef record) {
        Date now = new Date();
        record.setDeleted(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        b2cPosterGoodsRefDao.insert(record);
    }

    @Override
    public int updateById(B2cPosterGoodsRef record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cPosterGoodsRefDao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(B2cPosterGoodsRef record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(B2cPosterGoodsRef record, B2cPosterGoodsRefUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cPosterGoodsRefDao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(B2cPosterGoodsRef record, B2cPosterGoodsRefUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public B2cPosterGoodsRef getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return b2cPosterGoodsRefDao.getById(siteId, id);
    }

    @Override
    public B2cPosterGoodsRef getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        B2cPosterGoodsRef result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(B2cPosterGoodsRefQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cPosterGoodsRefDao.countByQuery(query);
    }

    @Override
    public List<B2cPosterGoodsRef> selectByQuery(B2cPosterGoodsRefQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cPosterGoodsRefDao.selectByQuery(query);
    }

    @Override
    public List<B2cPosterGoodsRef> selectByQueryThrowExceptionIfEmpty(B2cPosterGoodsRefQuery query) {
        List<B2cPosterGoodsRef> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<B2cPosterGoodsRef> selectByQueryWithPage(B2cPosterGoodsRefQuery query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cPosterGoodsRefDao.selectByQueryWithPage(query, page);
    }

}