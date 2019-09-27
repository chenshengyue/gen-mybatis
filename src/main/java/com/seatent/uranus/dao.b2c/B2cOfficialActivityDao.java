package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cOfficialActivity;
import com.seatent.uranus.query.B2cOfficialActivityQuery;
import com.seatent.uranus.update.B2cOfficialActivityUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cOfficialActivityDao {

    int delete(@Param("query") B2cOfficialActivityQuery query);

    int logicDelete(@Param("query") B2cOfficialActivityQuery query);

    int insert(B2cOfficialActivity record);

    int updateById(@Param("record") B2cOfficialActivity record);

    int updateByCondition(@Param("record") B2cOfficialActivity record, @Param("condition") B2cOfficialActivityUpdate condition);


    B2cOfficialActivity getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cOfficialActivityQuery query);

    List<B2cOfficialActivity> selectByQuery(@Param("query") B2cOfficialActivityQuery query);

    List<B2cOfficialActivity> selectByQueryWithPage(B2cOfficialActivityQuery query, Pagination page);

}