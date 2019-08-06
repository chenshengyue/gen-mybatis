package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cActivityThresholdRecord;
import com.seatent.uranus.query.B2cActivityThresholdRecordQuery;
import com.seatent.uranus.update.B2cActivityThresholdRecordUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cActivityThresholdRecordDao {

    int delete(@Param("query") B2cActivityThresholdRecordQuery query);

    int logicDelete(@Param("query") B2cActivityThresholdRecordQuery query);

    int insert(B2cActivityThresholdRecord record);

    int updateById(@Param("record") B2cActivityThresholdRecord record);

    int updateByCondition(@Param("record") B2cActivityThresholdRecord record, @Param("condition") B2cActivityThresholdRecordUpdate condition);


    B2cActivityThresholdRecord getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cActivityThresholdRecordQuery query);

    List<B2cActivityThresholdRecord> selectByQuery(@Param("query") B2cActivityThresholdRecordQuery query);

    List<B2cActivityThresholdRecord> selectByQueryWithPage(B2cActivityThresholdRecordQuery query, Pagination page);

}