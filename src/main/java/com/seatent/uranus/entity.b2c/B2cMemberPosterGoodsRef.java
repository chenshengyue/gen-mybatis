package com.seatent.uranus.entity.b2c;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class B2cMemberPosterGoodsRef {

    //主键id
    private Long id;

    //站点id
    private String siteId;

    //店铺海报id
    private String memberPosterId;

    //商品编号
    private String goodsId;

    //规格数量
    private Integer productNum;

    //排序
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