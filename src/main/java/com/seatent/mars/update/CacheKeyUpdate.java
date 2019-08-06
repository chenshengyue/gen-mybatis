package com.seatent.mars.update;

import com.csy.mybatis.Column;
import com.csy.mybatis.ColumnAction;
import lombok.Getter;
import lombok.Setter;

import com.seatent.mars.entity.CacheKey;

@Getter
@Setter
public class CacheKeyUpdate extends CacheKey {

    @Column(column = "isBatch", action = ColumnAction.EQUAL_TO)
    private Integer oldIsBatch;
}
