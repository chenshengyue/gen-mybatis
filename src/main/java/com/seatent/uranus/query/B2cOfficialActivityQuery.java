package com.seatent.uranus.query;

import com.csy.mybatis.Column;
import com.csy.mybatis.ColumnAction;
import lombok.Getter;
import lombok.Setter;

import com.seatent.uranus.entity.b2c.B2cOfficialActivity;

import java.util.Date;

@Getter
@Setter
public class B2cOfficialActivityQuery extends B2cOfficialActivity {

    @Column(column = "activity_start_time", action = ColumnAction.GREATER_THAN)
    private Date activityStartTimeGreatThan;

    @Column(column = "activity_start_time", action = ColumnAction.LESS_THAN)
    private Date activityStartTimeLessThan;

    @Column(column = "activity_end_time", action = ColumnAction.GREATER_THAN)
    private Date activityEndTimeGreatThan;

    @Column(column = "activity_end_time", action = ColumnAction.LESS_THAN)
    private Date activityEndTimeLessThan;

    @Column(column = "name", action = ColumnAction.Like)
    private String nameLike;
}
