package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cMemberPosterGoodsRef;
import com.seatent.uranus.query.B2cMemberPosterGoodsRefQuery;
import com.seatent.uranus.update.B2cMemberPosterGoodsRefUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cMemberPosterGoodsRefDao {

    int delete(@Param("query") B2cMemberPosterGoodsRefQuery query);

    int logicDelete(@Param("query") B2cMemberPosterGoodsRefQuery query);

    int insert(B2cMemberPosterGoodsRef record);

    int updateById(@Param("record") B2cMemberPosterGoodsRef record);

    int updateByCondition(@Param("record") B2cMemberPosterGoodsRef record, @Param("condition") B2cMemberPosterGoodsRefUpdate condition);


    B2cMemberPosterGoodsRef getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cMemberPosterGoodsRefQuery query);

    List<B2cMemberPosterGoodsRef> selectByQuery(@Param("query") B2cMemberPosterGoodsRefQuery query);

    List<B2cMemberPosterGoodsRef> selectByQueryWithPage(B2cMemberPosterGoodsRefQuery query, Pagination page);

}