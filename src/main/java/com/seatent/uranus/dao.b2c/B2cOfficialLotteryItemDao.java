package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cOfficialLotteryItem;
import com.seatent.uranus.query.B2cOfficialLotteryItemQuery;
import com.seatent.uranus.update.B2cOfficialLotteryItemUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cOfficialLotteryItemDao {

    int delete(@Param("query") B2cOfficialLotteryItemQuery query);

    int logicDelete(@Param("query") B2cOfficialLotteryItemQuery query);

    int insert(B2cOfficialLotteryItem record);

    int updateById(@Param("record") B2cOfficialLotteryItem record);

    int updateByCondition(@Param("record") B2cOfficialLotteryItem record, @Param("condition") B2cOfficialLotteryItemUpdate condition);


    B2cOfficialLotteryItem getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cOfficialLotteryItemQuery query);

    List<B2cOfficialLotteryItem> selectByQuery(@Param("query") B2cOfficialLotteryItemQuery query);

    List<B2cOfficialLotteryItem> selectByQueryWithPage(B2cOfficialLotteryItemQuery query, Pagination page);

}