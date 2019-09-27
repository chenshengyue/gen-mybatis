package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class B2cOfficialActivity {

    //
    private Long id;

    //站点ID
    private String siteId;

    //活动名称
    private String name;

    //活动类型 1-抽奖
    private Integer type;

    //活动主图
    private String mainImgs;

    //活动详情图
    private String detialImgs;

    //活动总库存
    private Integer activityStock;

    //活动开始时间
    private Date activityStartTime;

    //活动结束时间
    private Date activityEndTime;

    //描述
    private String description;

    //首页推荐
    private Integer isRecommend;

    //用户参与活动次数限制（与daily_limit组合使用）
    private Integer partInLimit;

    //用户参与活动次数限制 1:次/天 0:次
    private Integer limitType;

    //1-不可用（暂停） 0-可用
    private Boolean disabled;

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

    //
    private Integer sort;

}
