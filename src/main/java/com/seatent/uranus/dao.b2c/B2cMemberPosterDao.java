package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cMemberPoster;
import com.seatent.uranus.query.B2cMemberPosterQuery;
import com.seatent.uranus.update.B2cMemberPosterUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cMemberPosterDao {

    int delete(@Param("query") B2cMemberPosterQuery query);

    int logicDelete(@Param("query") B2cMemberPosterQuery query);

    int insert(B2cMemberPoster record);

    int updateById(@Param("record") B2cMemberPoster record);

    int updateByCondition(@Param("record") B2cMemberPoster record, @Param("condition") B2cMemberPosterUpdate condition);


    B2cMemberPoster getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cMemberPosterQuery query);

    List<B2cMemberPoster> selectByQuery(@Param("query") B2cMemberPosterQuery query);

    List<B2cMemberPoster> selectByQueryWithPage(B2cMemberPosterQuery query, Pagination page);

}