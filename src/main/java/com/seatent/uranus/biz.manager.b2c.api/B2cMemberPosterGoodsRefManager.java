package com.seatent.uranus.biz.manager.b2c.api;
import com.seatent.uranus.entity.b2c.B2cMemberPosterGoodsRef;
import com.seatent.uranus.query.B2cMemberPosterGoodsRefQuery;
import com.seatent.uranus.update.B2cMemberPosterGoodsRefUpdate;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cMemberPosterGoodsRefManager {

    void insert(B2cMemberPosterGoodsRef record);

    int updateById(B2cMemberPosterGoodsRef record);

    void updateByIdThrowException(B2cMemberPosterGoodsRef record);

    int update(B2cMemberPosterGoodsRef record, B2cMemberPosterGoodsRefUpdate condition);

    void updateThrowException(B2cMemberPosterGoodsRef record, B2cMemberPosterGoodsRefUpdate condition);

    B2cMemberPosterGoodsRef getById(String siteId, Long id);

    B2cMemberPosterGoodsRef getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(B2cMemberPosterGoodsRefQuery query);

    List<B2cMemberPosterGoodsRef> selectByQuery(B2cMemberPosterGoodsRefQuery query);

    List<B2cMemberPosterGoodsRef> selectByQueryThrowExceptionIfEmpty(B2cMemberPosterGoodsRefQuery query);

    List<B2cMemberPosterGoodsRef> selectByQueryWithPage(B2cMemberPosterGoodsRefQuery query, Pagination page);

}