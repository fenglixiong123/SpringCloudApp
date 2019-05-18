package com.flx.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 16:04
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String hobby;

}
