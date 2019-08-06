package com.seatent.uranus.biz.dubbo.manager.impl.b2c;

import com.seatent.uranus.biz.dubbo.manager.b2c.B2cBargainRecordManager;
import com.seatent.uranus.dao.b2c.B2cBargainRecordDao;
import com.seatent.uranus.entity.b2c.B2cBargainRecord;
import com.seatent.uranus.query.B2cBargainRecordQuery;
import com.seatent.uranus.update.B2cBargainRecordUpdate;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class B2cBargainRecordManagerImpl implements B2cBargainRecordManager {

    @Autowired
    private B2cBargainRecordDao b2cBargainRecordDao;

    @Override
    public void insert(B2cBargainRecord record) {
        Date now = new Date();
        record.setDeleted(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        b2cBargainRecordDao.insert(record);
    }

    @Override
    public int updateById(B2cBargainRecord record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cBargainRecordDao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(B2cBargainRecord record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(B2cBargainRecord record, B2cBargainRecordUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cBargainRecordDao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(B2cBargainRecord record, B2cBargainRecordUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public B2cBargainRecord getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return b2cBargainRecordDao.getById(siteId, id);
    }

    @Override
    public B2cBargainRecord getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        B2cBargainRecord result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(B2cBargainRecordQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cBargainRecordDao.countByQuery(query);
    }

    @Override
    public List<B2cBargainRecord> selectByQuery(B2cBargainRecordQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cBargainRecordDao.selectByQuery(query);
    }

    @Override
    public List<B2cBargainRecord> selectByQueryThrowExceptionIfEmpty(B2cBargainRecordQuery query) {
        List<B2cBargainRecord> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<B2cBargainRecord> selectByQueryWithPage(B2cBargainRecordQuery query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cBargainRecordDao.selectByQueryWithPage(query, page);
    }

}