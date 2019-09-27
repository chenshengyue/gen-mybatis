package com.seatent.uranus.dao.b2c;
import com.seatent.uranus.entity.b2c.B2cPoster;
import com.seatent.uranus.query.B2cPosterQuery;
import com.seatent.uranus.update.B2cPosterUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface B2cPosterDao {

    int delete(@Param("query") B2cPosterQuery query);

    int logicDelete(@Param("query") B2cPosterQuery query);

    int insert(B2cPoster record);

    int updateById(@Param("record") B2cPoster record);

    int updateByCondition(@Param("record") B2cPoster record, @Param("condition") B2cPosterUpdate condition);


    B2cPoster getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") B2cPosterQuery query);

    List<B2cPoster> selectByQuery(@Param("query") B2cPosterQuery query);

    List<B2cPoster> selectByQueryWithPage(B2cPosterQuery query, Pagination page);

}