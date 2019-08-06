package com.seatent.mars.dao;
import com.seatent.mars.entity.CacheKey;
import com.seatent.mars.query.CacheKeyQuery;
import com.seatent.mars.update.CacheKeyUpdate;
import org.apache.ibatis.annotations.Param;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface CacheKeyDao {

    int delete(@Param("query") CacheKeyQuery query);

    int logicDelete(@Param("query") CacheKeyQuery query);

    int insert(CacheKey record);

    int updateById(@Param("record") CacheKey record);

    int updateByCondition(@Param("record") CacheKey record, @Param("condition") CacheKeyUpdate condition);


    CacheKey getById(@Param("siteId") String siteId, @Param("id") Long id);

    int countByQuery(@Param("query") CacheKeyQuery query);

    List<CacheKey> selectByQuery(@Param("query") CacheKeyQuery query);

    List<CacheKey> selectByQueryWithPage(CacheKeyQuery query, Pagination page);

}