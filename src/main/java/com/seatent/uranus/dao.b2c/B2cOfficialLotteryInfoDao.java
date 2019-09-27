package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cOfficialLotteryInfo;
import com.seatent.uranus.query.B2cOfficialLotteryInfoQuery;
import com.seatent.uranus.update.B2cOfficialLotteryInfoUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cOfficialLotteryInfoDao {

    int delete(@Param("query") B2cOfficialLotteryInfoQuery query);

    int logicDelete(@Param("query") B2cOfficialLotteryInfoQuery query);

    int insert(B2cOfficialLotteryInfo record);

    int updateById(@Param("record") B2cOfficialLotteryInfo record);

    int updateByCondition(@Param("record") B2cOfficialLotteryInfo record, @Param("condition") B2cOfficialLotteryInfoUpdate condition);


    B2cOfficialLotteryInfo getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cOfficialLotteryInfoQuery query);

    List<B2cOfficialLotteryInfo> selectByQuery(@Param("query") B2cOfficialLotteryInfoQuery query);

    List<B2cOfficialLotteryInfo> selectByQueryWithPage(B2cOfficialLotteryInfoQuery query, Pagination page);

}