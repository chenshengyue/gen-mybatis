package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cBargainRecord;
import com.seatent.uranus.query.B2cBargainRecordQuery;
import com.seatent.uranus.update.B2cBargainRecordUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cBargainRecordDao {

    int delete(@Param("query") B2cBargainRecordQuery query);

    int logicDelete(@Param("query") B2cBargainRecordQuery query);

    int insert(B2cBargainRecord record);

    int updateById(@Param("record") B2cBargainRecord record);

    int updateByCondition(@Param("record") B2cBargainRecord record, @Param("condition") B2cBargainRecordUpdate condition);


    B2cBargainRecord getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cBargainRecordQuery query);

    List<B2cBargainRecord> selectByQuery(@Param("query") B2cBargainRecordQuery query);

    List<B2cBargainRecord> selectByQueryWithPage(B2cBargainRecordQuery query, Pagination page);

}