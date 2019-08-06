package com.seatent.uranus.update;

import com.csy.mybatis.Column;
import com.csy.mybatis.ColumnAction;
import lombok.Getter;
import lombok.Setter;

import com.seatent.uranus.entity.b2c.B2cBargainInfo;

import java.util.List;

@Getter
@Setter
public class B2cBargainInfoUpdate extends B2cBargainInfo {

    @Column(column = "id", action = ColumnAction.NOT_EQUAL_TO)
    private Long idNotEqualTo;

    @Column(column = "already_bargain_count", action = ColumnAction.EQUAL_TO)
    private Integer oldAlreadyBargainCountEqualTo;

    @Column(column = "status", action = ColumnAction.EQUAL_TO)
    private Integer oldStatusEqualTo;

    @Column(column = "status", action = ColumnAction.IN)
    private List<Integer> oldStatuses;

}
