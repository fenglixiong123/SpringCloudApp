package com.flx.springcloud.nacos.api.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/18 18:03
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private Integer age = 25;
    private String hobby;

}
