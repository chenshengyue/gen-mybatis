package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class B2cPoster {

    //主键id
    private Long id;

    //站点id
    private String siteId;

    //海报名称
    private String name;

    //海报图标
    private String logo;

    //海报banner
    private String banner;

    //海报背景颜色
    private String bgColor;

    //横排背景图片
    private String inlineBgImg;

    //宫格背景图片
    private String palaceBgImg;

    //开启与否(0:否，1：是)
    private Integer isOpen;

    //是否热门(0:否，1：是)
    private Integer isHot;

    //浏览量
    private Integer pageviews;

    //使用量
    private Integer usage;

    //描述
    private String remark;

    //分组排序
    private Integer sort;

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
