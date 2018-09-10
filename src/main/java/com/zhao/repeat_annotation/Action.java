package com.zhao.repeat_annotation;

import java.lang.annotation.*;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-10 23:19
 * @描述
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Actions.class)
public @interface Action {
    String value();
}