package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class B2cOfficialActivityReceive {

    //
    private Long id;

    //站点ID
    private String siteId;

    //
    private String accountId;

    //
    private String memberId;

    //hd_b2c_official_activity主键
    private Long b2cOfficialActivityId;

    //hd_b2c_official_lottery_item主键
    private Long b2cOfficialLotteryItemId;

    //
    private Integer awardType;

    //
    private String awardRefId;

    //
    private String awardName;

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
