package com.seatent.uranus.biz.dubbo.manager.b2c;
import com.seatent.uranus.entity.b2c.B2cBargainRecord;
import com.seatent.uranus.query.B2cBargainRecordQuery;
import com.seatent.uranus.update.B2cBargainRecordUpdate;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cBargainRecordManager {

    void insert(B2cBargainRecord record);

    int updateById(B2cBargainRecord record);

    void updateByIdThrowException(B2cBargainRecord record);

    int update(B2cBargainRecord record, B2cBargainRecordUpdate condition);

    void updateThrowException(B2cBargainRecord record, B2cBargainRecordUpdate condition);

    B2cBargainRecord getById(String siteId, Long id);

    B2cBargainRecord getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(B2cBargainRecordQuery query);

    List<B2cBargainRecord> selectByQuery(B2cBargainRecordQuery query);

    List<B2cBargainRecord> selectByQueryThrowExceptionIfEmpty(B2cBargainRecordQuery query);

    List<B2cBargainRecord> selectByQueryWithPage(B2cBargainRecordQuery query, Pagination page);

}