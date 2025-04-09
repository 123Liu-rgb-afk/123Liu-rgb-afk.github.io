package com.lrx.springbootusersys.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

/**
 * @author lrx
 * {@code @date} 2025/4/7 下午10:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String email;
}
