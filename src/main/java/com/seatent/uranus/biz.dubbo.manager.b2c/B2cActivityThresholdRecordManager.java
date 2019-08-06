package com.seatent.uranus.biz.dubbo.manager.b2c;
import com.seatent.uranus.entity.b2c.B2cActivityThresholdRecord;
import com.seatent.uranus.query.B2cActivityThresholdRecordQuery;
import com.seatent.uranus.update.B2cActivityThresholdRecordUpdate;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cActivityThresholdRecordManager {

    void insert(B2cActivityThresholdRecord record);

    int updateById(B2cActivityThresholdRecord record);

    void updateByIdThrowException(B2cActivityThresholdRecord record);

    int update(B2cActivityThresholdRecord record, B2cActivityThresholdRecordUpdate condition);

    void updateThrowException(B2cActivityThresholdRecord record, B2cActivityThresholdRecordUpdate condition);

    B2cActivityThresholdRecord getById(String siteId, Long id);

    B2cActivityThresholdRecord getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(B2cActivityThresholdRecordQuery query);

    List<B2cActivityThresholdRecord> selectByQuery(B2cActivityThresholdRecordQuery query);

    List<B2cActivityThresholdRecord> selectByQueryThrowExceptionIfEmpty(B2cActivityThresholdRecordQuery query);

    List<B2cActivityThresholdRecord> selectByQueryWithPage(B2cActivityThresholdRecordQuery query, Pagination page);

}