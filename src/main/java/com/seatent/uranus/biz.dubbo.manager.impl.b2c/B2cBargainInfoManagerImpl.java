package com.seatent.uranus.biz.dubbo.manager.impl.b2c;

import com.seatent.uranus.biz.dubbo.manager.b2c.B2cBargainInfoManager;
import com.seatent.uranus.dao.b2c.B2cBargainInfoDao;
import com.seatent.uranus.entity.b2c.B2cBargainInfo;
import com.seatent.uranus.query.B2cBargainInfoQuery;
import com.seatent.uranus.update.B2cBargainInfoUpdate;
import com.seatent.core.common.entity.Pagination;
import com.seatent.core.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class B2cBargainInfoManagerImpl implements B2cBargainInfoManager {

    @Autowired
    private B2cBargainInfoDao b2cBargainInfoDao;

    @Override
    public void insert(B2cBargainInfo record) {
        Date now = new Date();
        record.setDeleted(false);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        b2cBargainInfoDao.insert(record);
    }

    @Override
    public int updateById(B2cBargainInfo record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cBargainInfoDao.updateById(record);
    }

    @Override
    public void updateByIdThrowException(B2cBargainInfo record) {
        if (StringUtils.isBlank(record.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.updateById(record) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public int update(B2cBargainInfo record, B2cBargainInfoUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        return b2cBargainInfoDao.updateByCondition(record, condition);
    }

    @Override
    public void updateThrowException(B2cBargainInfo record, B2cBargainInfoUpdate condition) {
        if (StringUtils.isBlank(condition.getSiteId())) {
            throw new BizException("系统异常");
        }
        record.setUpdateTime(new Date());
        if (this.update(record, condition) < 1) {
            throw new BizException("修改失败");
        }
    }

    @Override
    public B2cBargainInfo getById(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        return b2cBargainInfoDao.getById(siteId, id);
    }

    @Override
    public B2cBargainInfo getByIdThrowExceptionIfNull(String siteId, Long id) {
        if (StringUtils.isBlank(siteId)) {
            throw new BizException("系统异常");
        }
        B2cBargainInfo result = this.getById(siteId, id);
        if (result == null) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public int countByQuery(B2cBargainInfoQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cBargainInfoDao.countByQuery(query);
    }

    @Override
    public List<B2cBargainInfo> selectByQuery(B2cBargainInfoQuery query) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cBargainInfoDao.selectByQuery(query);
    }

    @Override
    public List<B2cBargainInfo> selectByQueryThrowExceptionIfEmpty(B2cBargainInfoQuery query) {
        List<B2cBargainInfo> result = this.selectByQuery(query);
        if (CollectionUtils.isEmpty(result)) {
            throw new BizException("信息不存在");
        }
        return result;
    }

    @Override
    public List<B2cBargainInfo> selectByQueryWithPage(B2cBargainInfoQuery query, Pagination page) {
        if (StringUtils.isBlank(query.getSiteId())) {
            throw new BizException("系统异常");
        }
        return b2cBargainInfoDao.selectByQueryWithPage(query, page);
    }

}