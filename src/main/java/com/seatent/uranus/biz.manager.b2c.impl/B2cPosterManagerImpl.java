package com.seatent.uranus.biz.manager.b2c.impl;

import com.seatent.uranus.biz.manager.b2c.api.B2cPosterManager;
import com.seatent.uranus.dao.b2c.B2cPosterDao;
import com.seatent.uranus.entity.b2c.B2cPoster;
import com.seatent.uranus.query.B2cPosterQuery;
import com.seatent.uranus.update.B2cPosterUpdate;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class B2cPosterManagerImpl implements B2cPosterManager {

    @Autowired
    private B2cPosterDao b2cPosterDao;

    @Override
    public void insert(B2cPoster record) {
        Date now = new Date();
        record.setDeleted(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        b2cPosterDao.insert(record);
    }

    @Override
    public int updateById(B2cPoster record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cPosterDao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(B2cPoster record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(B2cPoster record, B2cPosterUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cPosterDao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(B2cPoster record, B2cPosterUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public B2cPoster getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return b2cPosterDao.getById(siteId, id);
    }

    @Override
    public B2cPoster getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        B2cPoster result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(B2cPosterQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cPosterDao.countByQuery(query);
    }

    @Override
    public List<B2cPoster> selectByQuery(B2cPosterQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cPosterDao.selectByQuery(query);
    }

    @Override
    public List<B2cPoster> selectByQueryThrowExceptionIfEmpty(B2cPosterQuery query) {
        List<B2cPoster> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<B2cPoster> selectByQueryWithPage(B2cPosterQuery query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cPosterDao.selectByQueryWithPage(query, page);
    }

}