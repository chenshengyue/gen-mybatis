package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cBargainInfo;
import com.seatent.uranus.query.B2cBargainInfoQuery;
import com.seatent.uranus.update.B2cBargainInfoUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cBargainInfoDao {

    int delete(@Param("query") B2cBargainInfoQuery query);

    int logicDelete(@Param("query") B2cBargainInfoQuery query);

    int insert(B2cBargainInfo record);

    int updateById(@Param("record") B2cBargainInfo record);

    int updateByCondition(@Param("record") B2cBargainInfo record, @Param("condition") B2cBargainInfoUpdate condition);


    B2cBargainInfo getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cBargainInfoQuery query);

    List<B2cBargainInfo> selectByQuery(@Param("query") B2cBargainInfoQuery query);

    List<B2cBargainInfo> selectByQueryWithPage(B2cBargainInfoQuery query, Pagination page);

}