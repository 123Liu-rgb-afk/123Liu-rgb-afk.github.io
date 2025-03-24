package com.lrx.mapper;

import com.lrx.entity.Pet;

import java.util.List;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午5:29
 */
public interface PetMapper {
    //通过 User 的 id 来获取 pet 对象，可能有多个，因此使用 List 接收
    public List<Pet> getPetByUserId(Integer userId);

    //通过 pet 的 id 获取 Pet 对象
    public Pet getPetById(Integer id);
}
