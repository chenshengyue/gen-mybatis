package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class B2cBargainInfo {

    //
    private Long id;

    //
    private String siteId;

    //b用户的accountId
    private String bUserId;

    //c用户的accountId
    private String cUserId;

    //砍价活动id
    private String activityId;

    //砍价金额(商品原价-底价)
    private BigDecimal bargainAmount;

    //剩余砍价金额
    private BigDecimal remainBargainAmount;

    //已砍次数
    private Integer alreadyBargainCount;

    //砍价次数
    private Integer bargainCount;

    //砍价结束时间（这个砍价结束时间和砍价活动的结束时间不同）
    private Date bargainEndTime;

    //0:零元购 1:底价购
    private Integer purchaseLimit;

    //状态(1:未到底价;2:未提交订单;3:已提交订单;)
    private Integer status;

    //调仓状态 1:调仓 0:正常订单
    private Integer adjustDepotStatus;

    //活动即将结束短信是否发送过
    private Integer finishSoonStatus;

    //活动结束短信是否发送；也是是否回退库存标志
    private Integer finishStatus;

    //库存不足短信是否发送过
    private Integer failStatus;

    //
    private String orderId;

    //
    private String orderSn;

    //砍价成功时间（状态为2的时间）
    private Date bargainSuccessTime;

    //提交订单时间（状态为3的时间）
    private Date payTime;

    //
    private String attribute;

    //
    private Integer attributeVersion;

    //删除与否(0:未删除，1：已删除)
    private Boolean deleted;

    //
    private Date createTime;

    //
    private Date updateTime;

}
