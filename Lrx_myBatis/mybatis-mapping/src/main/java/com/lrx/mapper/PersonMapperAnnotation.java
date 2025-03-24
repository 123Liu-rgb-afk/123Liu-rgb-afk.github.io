package com.lrx.mapper;

import com.lrx.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午3:41
 */
public interface PersonMapperAnnotation {
    @Select("SELECT * FROM person WHERE id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "card",column = "card_id",
                    one = @One(select = "com.lrx.mapper.IdenCardMapper.getIdenCardById"))

    })
    public Person getPersonById(Integer id);

}
