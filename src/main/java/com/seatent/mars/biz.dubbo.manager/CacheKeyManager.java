package com.seatent.mars.biz.dubbo.manager;
import com.seatent.mars.entity.CacheKey;
import com.seatent.mars.query.CacheKeyQuery;
import com.seatent.mars.update.CacheKeyUpdate;
import com.seatent.core.common.entity.Pagination;

import java.util.List;

public interface CacheKeyManager {

    void insert(CacheKey record);

    int updateById(CacheKey record);

    void updateByIdThrowException(CacheKey record);

    int update(CacheKey record, CacheKeyUpdate condition);

    void updateThrowException(CacheKey record, CacheKeyUpdate condition);

    CacheKey getById(String siteId, Long id);

    CacheKey getByIdThrowExceptionIfNull(String siteId, Long id);

    int countByQuery(CacheKeyQuery query);

    List<CacheKey> selectByQuery(CacheKeyQuery query);

    List<CacheKey> selectByQueryThrowExceptionIfEmpty(CacheKeyQuery query);

    List<CacheKey> selectByQueryWithPage(CacheKeyQuery query, Pagination page);

}