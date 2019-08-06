package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cThresholdActivity;
import com.seatent.uranus.query.B2cThresholdActivityQuery;
import com.seatent.uranus.update.B2cThresholdActivityUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cThresholdActivityDao {

    int delete(@Param("query") B2cThresholdActivityQuery query);

    int logicDelete(@Param("query") B2cThresholdActivityQuery query);

    int insert(B2cThresholdActivity record);

    int updateById(@Param("record") B2cThresholdActivity record);

    int updateByCondition(@Param("record") B2cThresholdActivity record, @Param("condition") B2cThresholdActivityUpdate condition);


    B2cThresholdActivity getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cThresholdActivityQuery query);

    List<B2cThresholdActivity> selectByQuery(@Param("query") B2cThresholdActivityQuery query);

    List<B2cThresholdActivity> selectByQueryWithPage(B2cThresholdActivityQuery query, Pagination page);

}