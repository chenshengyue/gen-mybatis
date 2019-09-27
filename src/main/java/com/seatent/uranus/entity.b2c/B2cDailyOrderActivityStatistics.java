package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class B2cDailyOrderActivityStatistics {

    //自增主键
    private Long id;

    //站点ID
    private String siteId;

    //用户ID
    private String memberId;

    //帐户ID
    private String accountId;

    //
    private Integer totalNum;

    //
    private Integer totalReward;

    //类型
    private Integer type;

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
