package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class B2cThresholdActivity {

    //自增主键
    private Long id;

    //站点ID
    private String siteId;

    //B店铺ID
    private String memberId;

    //B帐户ID
    private String accountId;

    //累计订单数(计入未达阀值清空的数据)
    private Integer totalOrderCount;

    //达到阀值的累计的订单总数（不计清空部分的订单数）
    private Integer thresholdOrderCount;

    //阀值订单奖励结算状态，1:待结算,2:已结算,3:已取消
    private Integer thresholdOrderStatus;

    //达到阀值时间
    private Date thresholdOrderTime;

    //订单数阀值
    private Integer threshold;

    //首单提示状态,0:未查收，1：已查收
    private Integer firstOrderTipsStatus;

    //首单时间
    private Date firstOrderTime;

    //首单结算奖励状态，1:待结算,2:已结算,3:已取消
    private Integer firstOrderStatus;

    //活动类型（1：7月冲单活动）
    private Integer activityType;

    //删除与否(0:未删除，1：已删除)
    private Boolean deleted;

    //创建用户的ID，默认0：系统
    private String createAccount;

    //修改用户的ID，默认0：系统
    private String updateAccount;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

}
