package com.seatent.uranus.query;

import com.csy.mybatis.Column;
import com.csy.mybatis.ColumnAction;
import lombok.Getter;
import lombok.Setter;

import com.seatent.uranus.entity.b2c.B2cBargainInfo;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class B2cBargainInfoQuery extends B2cBargainInfo {

    @Column(column = "id", action = ColumnAction.IN)
    private List<Integer> ids;

    @Column(column = "b_user_id", action = ColumnAction.IN)
    private List<String> bUserIds;

    @Column(column = "bargain_end_time", action = ColumnAction.GREATER_THAN)
    private Date bargainEndTimeGreaterThan;

    @Column(column = "bargain_end_time", action = ColumnAction.LESS_THAN)
    private Date bargainEndTimeLessThan;

    @Column(column = "create_time", action = ColumnAction.GREATER_THAN)
    private Date createTimeGreaterThan;

    @Column(column = "create_time", action = ColumnAction.LESS_THAN)
    private Date createTimeLessThan;

    @Column(column = "status", action = ColumnAction.IN)
    private List<Integer> statuses;
}
