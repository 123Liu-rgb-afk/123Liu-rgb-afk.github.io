package com.lrx.mapper;

import com.lrx.entity.IdenCard;
import org.apache.ibatis.annotations.Select;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午2:51
 */
public interface IdenCardMapper {


    public IdenCard getIdenCardById(Integer id);

    //级联查询
    public IdenCard getIdenCardById2(Integer id);

}
