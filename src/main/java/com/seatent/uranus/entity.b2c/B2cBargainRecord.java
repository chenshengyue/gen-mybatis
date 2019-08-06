package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class B2cBargainRecord {

    //
    private Long id;

    //
    private String siteId;

    //
    private String bUserId;

    //
    private String cUserId;

    //
    private String sharedUserId;

    //
    private Long b2cBargainInfoId;

    //砍价活动id
    private String activityId;

    //单次的砍价金额
    private BigDecimal bargainAmount;

    //状态(1:可用;0:不可用)
    private Integer status;

    //删除与否(0:未删除，1：已删除)
    private Boolean deleted;

    //
    private Date createTime;

    //
    private Date updateTime;

}
