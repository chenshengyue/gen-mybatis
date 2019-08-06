package com.seatent.mars.query;

import com.csy.mybatis.Column;
import com.csy.mybatis.ColumnAction;
import lombok.Getter;
import lombok.Setter;

import com.seatent.mars.entity.CacheKey;

import java.util.List;

@Getter
@Setter
public class CacheKeyQuery extends CacheKey {

    @Column(column = "id", action = ColumnAction.IN)
    private List<Long> ids;

    @Column(column = "siteId", action = ColumnAction.IN)
    private List<String> siteIds;

}
