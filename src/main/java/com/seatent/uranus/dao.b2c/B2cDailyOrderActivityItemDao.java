package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cDailyOrderActivityItem;
import com.seatent.uranus.query.B2cDailyOrderActivityItemQuery;
import com.seatent.uranus.update.B2cDailyOrderActivityItemUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cDailyOrderActivityItemDao {

    int delete(@Param("query") B2cDailyOrderActivityItemQuery query);

    int logicDelete(@Param("query") B2cDailyOrderActivityItemQuery query);

    int insert(B2cDailyOrderActivityItem record);

    int updateById(@Param("record") B2cDailyOrderActivityItem record);

    int updateByCondition(@Param("record") B2cDailyOrderActivityItem record, @Param("condition") B2cDailyOrderActivityItemUpdate condition);


    B2cDailyOrderActivityItem getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cDailyOrderActivityItemQuery query);

    List<B2cDailyOrderActivityItem> selectByQuery(@Param("query") B2cDailyOrderActivityItemQuery query);

    List<B2cDailyOrderActivityItem> selectByQueryWithPage(B2cDailyOrderActivityItemQuery query, Pagination page);

}