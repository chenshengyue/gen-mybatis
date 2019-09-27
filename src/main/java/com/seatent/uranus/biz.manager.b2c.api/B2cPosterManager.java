package com.seatent.uranus.biz.manager.b2c.api;
import com.seatent.uranus.entity.b2c.B2cPoster;
import com.seatent.uranus.query.B2cPosterQuery;
import com.seatent.uranus.update.B2cPosterUpdate;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cPosterManager {

    void insert(B2cPoster record);

    int updateById(B2cPoster record);

    void updateByIdThrowException(B2cPoster record);

    int update(B2cPoster record, B2cPosterUpdate condition);

    void updateThrowException(B2cPoster record, B2cPosterUpdate condition);

    B2cPoster getById(String siteId, Long id);

    B2cPoster getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(B2cPosterQuery query);

    List<B2cPoster> selectByQuery(B2cPosterQuery query);

    List<B2cPoster> selectByQueryThrowExceptionIfEmpty(B2cPosterQuery query);

    List<B2cPoster> selectByQueryWithPage(B2cPosterQuery query, Pagination page);

}