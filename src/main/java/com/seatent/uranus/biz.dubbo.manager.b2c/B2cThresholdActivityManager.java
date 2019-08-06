package com.seatent.uranus.biz.dubbo.manager.b2c;
import com.seatent.uranus.entity.b2c.B2cThresholdActivity;
import com.seatent.uranus.query.B2cThresholdActivityQuery;
import com.seatent.uranus.update.B2cThresholdActivityUpdate;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cThresholdActivityManager {

    void insert(B2cThresholdActivity record);

    int updateById(B2cThresholdActivity record);

    void updateByIdThrowException(B2cThresholdActivity record);

    int update(B2cThresholdActivity record, B2cThresholdActivityUpdate condition);

    void updateThrowException(B2cThresholdActivity record, B2cThresholdActivityUpdate condition);

    B2cThresholdActivity getById(String siteId, Long id);

    B2cThresholdActivity getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(B2cThresholdActivityQuery query);

    List<B2cThresholdActivity> selectByQuery(B2cThresholdActivityQuery query);

    List<B2cThresholdActivity> selectByQueryThrowExceptionIfEmpty(B2cThresholdActivityQuery query);

    List<B2cThresholdActivity> selectByQueryWithPage(B2cThresholdActivityQuery query, Pagination page);

}