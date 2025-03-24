package com.lrx.mapper;

import com.lrx.entity.IdenCard;
import org.apache.ibatis.annotations.Select;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午3:40
 */
public interface IdenCardMapperAnnotation {
    @Select("SELECT * FROM `idencard` WHERE `id` = #{id}")
    public IdenCard getIdenCardById(Integer id);
}
