package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class B2cOfficialLotteryItem {

    //
    private Long id;

    //站点ID
    private String siteId;

    //hd_b2c_official_activity主键
    private Long b2cOfficialActivityId;

    //hd_b2c_official_lottery_info主键
    private Long b2cOfficialLotteryInfoId;

    //奖品类型 0-谢谢参与 1-优惠券
    private Integer awardType;

    //奖品对应物品id。优惠券对应优惠券id。谢谢参与对应0
    private String awardRefId;

    //奖品库存。 -1:无库存限制
    private Integer awardStock;

    //
    private Boolean isDisable;

    //删除与否(0:未删除，1：已删除)
    private Boolean deleted;

    //创建用户
    private String createAccount;

    //创建时间
    private Date createTime;

    //更新用户
    private String updateAccount;

    //更新时间
    private Date updateTime;

}
