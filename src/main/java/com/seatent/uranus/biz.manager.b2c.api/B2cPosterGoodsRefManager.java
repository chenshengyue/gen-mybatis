package com.seatent.uranus.biz.manager.b2c.api;
import com.seatent.uranus.entity.b2c.B2cPosterGoodsRef;
import com.seatent.uranus.query.B2cPosterGoodsRefQuery;
import com.seatent.uranus.update.B2cPosterGoodsRefUpdate;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cPosterGoodsRefManager {

    void insert(B2cPosterGoodsRef record);

    int updateById(B2cPosterGoodsRef record);

    void updateByIdThrowException(B2cPosterGoodsRef record);

    int update(B2cPosterGoodsRef record, B2cPosterGoodsRefUpdate condition);

    void updateThrowException(B2cPosterGoodsRef record, B2cPosterGoodsRefUpdate condition);

    B2cPosterGoodsRef getById(String siteId, Long id);

    B2cPosterGoodsRef getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(B2cPosterGoodsRefQuery query);

    List<B2cPosterGoodsRef> selectByQuery(B2cPosterGoodsRefQuery query);

    List<B2cPosterGoodsRef> selectByQueryThrowExceptionIfEmpty(B2cPosterGoodsRefQuery query);

    List<B2cPosterGoodsRef> selectByQueryWithPage(B2cPosterGoodsRefQuery query, Pagination page);

}