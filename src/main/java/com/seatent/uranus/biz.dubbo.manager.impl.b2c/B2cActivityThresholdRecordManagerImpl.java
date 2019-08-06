package com.seatent.uranus.biz.dubbo.manager.impl.b2c;

import com.seatent.uranus.biz.dubbo.manager.b2c.B2cActivityThresholdRecordManager;
import com.seatent.uranus.dao.b2c.B2cActivityThresholdRecordDao;
import com.seatent.uranus.entity.b2c.B2cActivityThresholdRecord;
import com.seatent.uranus.query.B2cActivityThresholdRecordQuery;
import com.seatent.uranus.update.B2cActivityThresholdRecordUpdate;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class B2cActivityThresholdRecordManagerImpl implements B2cActivityThresholdRecordManager {

    @Autowired
    private B2cActivityThresholdRecordDao b2cActivityThresholdRecordDao;

    @Override
    public void insert(B2cActivityThresholdRecord record) {
        Date now = new Date();
        record.setCreateTime(now);
        record.setUpdateTime(now);
        b2cActivityThresholdRecordDao.insert(record);
    }

    @Override
    public int updateById(B2cActivityThresholdRecord record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cActivityThresholdRecordDao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(B2cActivityThresholdRecord record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(B2cActivityThresholdRecord record, B2cActivityThresholdRecordUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cActivityThresholdRecordDao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(B2cActivityThresholdRecord record, B2cActivityThresholdRecordUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public B2cActivityThresholdRecord getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return b2cActivityThresholdRecordDao.getById(siteId, id);
    }

    @Override
    public B2cActivityThresholdRecord getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        B2cActivityThresholdRecord result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(B2cActivityThresholdRecordQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cActivityThresholdRecordDao.countByQuery(query);
    }

    @Override
    public List<B2cActivityThresholdRecord> selectByQuery(B2cActivityThresholdRecordQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cActivityThresholdRecordDao.selectByQuery(query);
    }

    @Override
    public List<B2cActivityThresholdRecord> selectByQueryThrowExceptionIfEmpty(B2cActivityThresholdRecordQuery query) {
        List<B2cActivityThresholdRecord> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<B2cActivityThresholdRecord> selectByQueryWithPage(B2cActivityThresholdRecordQuery query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cActivityThresholdRecordDao.selectByQueryWithPage(query, page);
    }

}