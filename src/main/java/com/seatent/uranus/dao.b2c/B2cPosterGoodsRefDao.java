package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cPosterGoodsRef;
import com.seatent.uranus.query.B2cPosterGoodsRefQuery;
import com.seatent.uranus.update.B2cPosterGoodsRefUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cPosterGoodsRefDao {

    int delete(@Param("query") B2cPosterGoodsRefQuery query);

    int logicDelete(@Param("query") B2cPosterGoodsRefQuery query);

    int insert(B2cPosterGoodsRef record);

    int updateById(@Param("record") B2cPosterGoodsRef record);

    int updateByCondition(@Param("record") B2cPosterGoodsRef record, @Param("condition") B2cPosterGoodsRefUpdate condition);


    B2cPosterGoodsRef getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cPosterGoodsRefQuery query);

    List<B2cPosterGoodsRef> selectByQuery(@Param("query") B2cPosterGoodsRefQuery query);

    List<B2cPosterGoodsRef> selectByQueryWithPage(B2cPosterGoodsRefQuery query, Pagination page);

}