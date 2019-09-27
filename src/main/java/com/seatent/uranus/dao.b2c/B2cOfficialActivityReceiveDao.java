package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cOfficialActivityReceive;
import com.seatent.uranus.query.B2cOfficialActivityReceiveQuery;
import com.seatent.uranus.update.B2cOfficialActivityReceiveUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cOfficialActivityReceiveDao {

    int delete(@Param("query") B2cOfficialActivityReceiveQuery query);

    int logicDelete(@Param("query") B2cOfficialActivityReceiveQuery query);

    int insert(B2cOfficialActivityReceive record);

    int updateById(@Param("record") B2cOfficialActivityReceive record);

    int updateByCondition(@Param("record") B2cOfficialActivityReceive record, @Param("condition") B2cOfficialActivityReceiveUpdate condition);


    B2cOfficialActivityReceive getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cOfficialActivityReceiveQuery query);

    List<B2cOfficialActivityReceive> selectByQuery(@Param("query") B2cOfficialActivityReceiveQuery query);

    List<B2cOfficialActivityReceive> selectByQueryWithPage(B2cOfficialActivityReceiveQuery query, Pagination page);

}