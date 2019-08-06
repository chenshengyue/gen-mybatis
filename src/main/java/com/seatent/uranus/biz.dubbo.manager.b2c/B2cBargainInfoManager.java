package com.seatent.uranus.biz.dubbo.manager.b2c;
import com.seatent.uranus.entity.b2c.B2cBargainInfo;
import com.seatent.uranus.query.B2cBargainInfoQuery;
import com.seatent.uranus.update.B2cBargainInfoUpdate;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cBargainInfoManager {

    void insert(B2cBargainInfo record);

    int updateById(B2cBargainInfo record);

    void updateByIdThrowException(B2cBargainInfo record);

    int update(B2cBargainInfo record, B2cBargainInfoUpdate condition);

    void updateThrowException(B2cBargainInfo record, B2cBargainInfoUpdate condition);

    B2cBargainInfo getById(String siteId, Long id);

    B2cBargainInfo getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(B2cBargainInfoQuery query);

    List<B2cBargainInfo> selectByQuery(B2cBargainInfoQuery query);

    List<B2cBargainInfo> selectByQueryThrowExceptionIfEmpty(B2cBargainInfoQuery query);

    List<B2cBargainInfo> selectByQueryWithPage(B2cBargainInfoQuery query, Pagination page);

}