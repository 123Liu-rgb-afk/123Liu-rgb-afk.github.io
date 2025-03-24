package com.lrx.mapper;

import com.lrx.entity.Person;


/**
 * @author lrx
 * {@code @date} 2025/3/23 下午2:51
 */
public interface PersonMapper {



    public Person getPersonById(Integer id);

    public Person getPersonById2(Integer id);

}
