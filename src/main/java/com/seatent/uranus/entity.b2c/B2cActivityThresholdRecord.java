package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class B2cActivityThresholdRecord {

    //自动递增
    private Long id;

    //站点id
    private String siteId;

    //用户id
    private String accountId;

    //用户id
    private String memberId;

    //0：未发放，1：已发放
    private Integer sendStatus;

    //优惠券id
    private String bonusTypeId;

    //优惠券数量
    private Integer bonusNum;

    //抽奖活动类型（1:2019.7月活动）
    private Integer type;

    //日期
    private String date;

    //
    private String description;

    //
    private String createAccount;

    //
    private Date createTime;

    //
    private String updateAccount;

    //
    private Date updateTime;

}
