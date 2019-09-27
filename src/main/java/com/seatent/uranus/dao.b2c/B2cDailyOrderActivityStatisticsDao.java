package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cDailyOrderActivityStatistics;
import com.seatent.uranus.query.B2cDailyOrderActivityStatisticsQuery;
import com.seatent.uranus.update.B2cDailyOrderActivityStatisticsUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cDailyOrderActivityStatisticsDao {

    int delete(@Param("query") B2cDailyOrderActivityStatisticsQuery query);

    int logicDelete(@Param("query") B2cDailyOrderActivityStatisticsQuery query);

    int insert(B2cDailyOrderActivityStatistics record);

    int updateById(@Param("record") B2cDailyOrderActivityStatistics record);

    int updateByCondition(@Param("record") B2cDailyOrderActivityStatistics record, @Param("condition") B2cDailyOrderActivityStatisticsUpdate condition);


    B2cDailyOrderActivityStatistics getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cDailyOrderActivityStatisticsQuery query);

    List<B2cDailyOrderActivityStatistics> selectByQuery(@Param("query") B2cDailyOrderActivityStatisticsQuery query);

    List<B2cDailyOrderActivityStatistics> selectByQueryWithPage(B2cDailyOrderActivityStatisticsQuery query, Pagination page);

}