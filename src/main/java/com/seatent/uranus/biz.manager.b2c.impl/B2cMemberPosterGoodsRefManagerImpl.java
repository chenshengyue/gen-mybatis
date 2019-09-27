package com.seatent.uranus.biz.manager.b2c.impl;

import com.seatent.uranus.biz.manager.b2c.api.B2cMemberPosterGoodsRefManager;
import com.seatent.uranus.dao.b2c.B2cMemberPosterGoodsRefDao;
import com.seatent.uranus.entity.b2c.B2cMemberPosterGoodsRef;
import com.seatent.uranus.query.B2cMemberPosterGoodsRefQuery;
import com.seatent.uranus.update.B2cMemberPosterGoodsRefUpdate;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class B2cMemberPosterGoodsRefManagerImpl implements B2cMemberPosterGoodsRefManager {

    @Autowired
    private B2cMemberPosterGoodsRefDao b2cMemberPosterGoodsRefDao;

    @Override
    public void insert(B2cMemberPosterGoodsRef record) {
        Date now = new Date();
        record.setDeleted(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        b2cMemberPosterGoodsRefDao.insert(record);
    }

    @Override
    public int updateById(B2cMemberPosterGoodsRef record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cMemberPosterGoodsRefDao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(B2cMemberPosterGoodsRef record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(B2cMemberPosterGoodsRef record, B2cMemberPosterGoodsRefUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cMemberPosterGoodsRefDao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(B2cMemberPosterGoodsRef record, B2cMemberPosterGoodsRefUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public B2cMemberPosterGoodsRef getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return b2cMemberPosterGoodsRefDao.getById(siteId, id);
    }

    @Override
    public B2cMemberPosterGoodsRef getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        B2cMemberPosterGoodsRef result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(B2cMemberPosterGoodsRefQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cMemberPosterGoodsRefDao.countByQuery(query);
    }

    @Override
    public List<B2cMemberPosterGoodsRef> selectByQuery(B2cMemberPosterGoodsRefQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cMemberPosterGoodsRefDao.selectByQuery(query);
    }

    @Override
    public List<B2cMemberPosterGoodsRef> selectByQueryThrowExceptionIfEmpty(B2cMemberPosterGoodsRefQuery query) {
        List<B2cMemberPosterGoodsRef> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<B2cMemberPosterGoodsRef> selectByQueryWithPage(B2cMemberPosterGoodsRefQuery query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cMemberPosterGoodsRefDao.selectByQueryWithPage(query, page);
    }

}