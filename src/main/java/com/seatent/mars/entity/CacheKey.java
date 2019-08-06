package com.seatent.mars.entity;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class CacheKey {

    //自增主键
    private Long id;

    //站点id
    private String siteId;

    //redisKey 比如 %s:member_baseInfo_%s
    private String redisKey;

    //redisKey需要填充的值的属性。比如redis_key = %s:member_baseInfo_%s，需要填充的是siteId和memberId，那么这个值存的是siteId,memberId。空的话说明redis_key不需要format
    private String redisKeyName;

    //同redis_key
    private String redisField;

    //同redis_key_name
    private String redisFieldName;

    //缓存类型 1：string 2：hash
    private Integer cacheType;

    //是否批量 1：是 0：否
    private Integer isBatch;

    //是否反转 1：是 （redis_key需要format） 0：否 （redis_field需要format）
    private Integer isReverse;

    //缓存业务类型描述
    private String bizTypeDesc;

    //dubbo接口名
    private String interfaceName;

    //方法名称
    private String methodName;

    //删除与否(0:未删除，1：已删除)
    private Boolean deleted;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

}
