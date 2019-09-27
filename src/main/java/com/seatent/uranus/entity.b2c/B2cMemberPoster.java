package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class B2cMemberPoster {

    //主键id
    private Long id;

    //站点id
    private String siteId;

    //店铺Id
    private String memberId;

    //海报模板id
    private String parentId;

    //活动名称
    private String name;

    //海报banner
    private String banner;

    //海报背景颜色
    private String bgColor;

    //横排背景图片
    private String inlineBgImg;

    //宫格背景图片
    private String palaceBgImg;

    //排列类型(0:横排，1:宫格)
    private Integer layoutType;

    //活动开始时间
    private Date beginTime;

    //活动结束时间
    private Date endTime;

    //活动标签
    private String label;

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
