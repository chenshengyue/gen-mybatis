package com.seatent.uranus.biz.manager.b2c.impl;

import com.seatent.uranus.biz.manager.b2c.api.B2cMemberPosterManager;
import com.seatent.uranus.dao.b2c.B2cMemberPosterDao;
import com.seatent.uranus.entity.b2c.B2cMemberPoster;
import com.seatent.uranus.query.B2cMemberPosterQuery;
import com.seatent.uranus.update.B2cMemberPosterUpdate;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class B2cMemberPosterManagerImpl implements B2cMemberPosterManager {

    @Autowired
    private B2cMemberPosterDao b2cMemberPosterDao;

    @Override
    public void insert(B2cMemberPoster record) {
        Date now = new Date();
        record.setDeleted(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        b2cMemberPosterDao.insert(record);
    }

    @Override
    public int updateById(B2cMemberPoster record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cMemberPosterDao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(B2cMemberPoster record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(B2cMemberPoster record, B2cMemberPosterUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cMemberPosterDao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(B2cMemberPoster record, B2cMemberPosterUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public B2cMemberPoster getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return b2cMemberPosterDao.getById(siteId, id);
    }

    @Override
    public B2cMemberPoster getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        B2cMemberPoster result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(B2cMemberPosterQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cMemberPosterDao.countByQuery(query);
    }

    @Override
    public List<B2cMemberPoster> selectByQuery(B2cMemberPosterQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cMemberPosterDao.selectByQuery(query);
    }

    @Override
    public List<B2cMemberPoster> selectByQueryThrowExceptionIfEmpty(B2cMemberPosterQuery query) {
        List<B2cMemberPoster> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<B2cMemberPoster> selectByQueryWithPage(B2cMemberPosterQuery query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cMemberPosterDao.selectByQueryWithPage(query, page);
    }

}