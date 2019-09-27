package com.seatent.uranus.biz.manager.b2c.api;
import com.seatent.uranus.entity.b2c.B2cMemberPoster;
import com.seatent.uranus.query.B2cMemberPosterQuery;
import com.seatent.uranus.update.B2cMemberPosterUpdate;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cMemberPosterManager {

    void insert(B2cMemberPoster record);

    int updateById(B2cMemberPoster record);

    void updateByIdThrowException(B2cMemberPoster record);

    int update(B2cMemberPoster record, B2cMemberPosterUpdate condition);

    void updateThrowException(B2cMemberPoster record, B2cMemberPosterUpdate condition);

    B2cMemberPoster getById(String siteId, Long id);

    B2cMemberPoster getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(B2cMemberPosterQuery query);

    List<B2cMemberPoster> selectByQuery(B2cMemberPosterQuery query);

    List<B2cMemberPoster> selectByQueryThrowExceptionIfEmpty(B2cMemberPosterQuery query);

    List<B2cMemberPoster> selectByQueryWithPage(B2cMemberPosterQuery query, Pagination page);

}