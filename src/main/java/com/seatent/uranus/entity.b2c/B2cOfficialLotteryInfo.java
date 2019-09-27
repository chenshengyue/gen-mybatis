package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class B2cOfficialLotteryInfo {

    //
    private Long id;

    //hd_b2c_official_activity主键
    private Long b2cOfficialActivityId;

    //奖项名称
    private String awardName;

    //是否默认
    private Integer isDefault;

    //中奖。千一。0.1%存的是1，100%存1000
    private Integer probability;

}
