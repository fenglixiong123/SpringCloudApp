package com.flx.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/3 15:01
 */

@AllArgsConstructor //全参构造方法
@NoArgsConstructor //空参构造方法
@Data //set get 方法
@Accessors(chain = true) //允许链式调用
public class Dept implements Serializable{

    //主键
    private Long deptno;
    //部门名称
    private String dname;
    //来自哪个数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

    public static void main(String[] args) {

        Dept dept = new Dept("");
        dept.setDname("ssss").setDname("").setDb_source("hehe").setDeptno(12l);
        System.out.println(dept);
    }
}
