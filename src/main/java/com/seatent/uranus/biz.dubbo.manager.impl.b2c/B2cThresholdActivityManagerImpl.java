package com.seatent.uranus.biz.dubbo.manager.impl.b2c;

import com.seatent.uranus.biz.dubbo.manager.b2c.B2cThresholdActivityManager;
import com.seatent.uranus.dao.b2c.B2cThresholdActivityDao;
import com.seatent.uranus.entity.b2c.B2cThresholdActivity;
import com.seatent.uranus.query.B2cThresholdActivityQuery;
import com.seatent.uranus.update.B2cThresholdActivityUpdate;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class B2cThresholdActivityManagerImpl implements B2cThresholdActivityManager {

    @Autowired
    private B2cThresholdActivityDao b2cThresholdActivityDao;

    @Override
    public void insert(B2cThresholdActivity record) {
        Date now = new Date();
        record.setDeleted(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        b2cThresholdActivityDao.insert(record);
    }

    @Override
    public int updateById(B2cThresholdActivity record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cThresholdActivityDao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(B2cThresholdActivity record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(B2cThresholdActivity record, B2cThresholdActivityUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cThresholdActivityDao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(B2cThresholdActivity record, B2cThresholdActivityUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public B2cThresholdActivity getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return b2cThresholdActivityDao.getById(siteId, id);
    }

    @Override
    public B2cThresholdActivity getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        B2cThresholdActivity result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(B2cThresholdActivityQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cThresholdActivityDao.countByQuery(query);
    }

    @Override
    public List<B2cThresholdActivity> selectByQuery(B2cThresholdActivityQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cThresholdActivityDao.selectByQuery(query);
    }

    @Override
    public List<B2cThresholdActivity> selectByQueryThrowExceptionIfEmpty(B2cThresholdActivityQuery query) {
        List<B2cThresholdActivity> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<B2cThresholdActivity> selectByQueryWithPage(B2cThresholdActivityQuery query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cThresholdActivityDao.selectByQueryWithPage(query, page);
    }

}