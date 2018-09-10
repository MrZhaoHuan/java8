package com.zhao;

import com.zhao.repeat_annotation.Action;
import com.zhao.repeat_annotation.Actions;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-10 23:22
 * @描述     2种方式 测试重复注解
 **/
public class RepeatAnnotationTest {

    @Actions({@Action("吃饭"),@Action("睡觉"),@Action("打豆豆")})
    public void myAction1(){

    }
    @Test
    public void test1() throws NoSuchMethodException {
        Method myAction1 = RepeatAnnotationTest.class.getMethod("myAction1");
        Actions anno = myAction1.getAnnotationsByType(Actions.class)[0];
        Action[] actions = anno.value();
        for (Action action:actions){
            System.out.println(action.value());
        }
    }


    @Action("吃饭2")
    @Action("睡觉2")
    @Action("打豆豆2")
    public void myAction2(){

    }
    @Test
    public void test2() throws NoSuchMethodException {
        Method myAction2 = RepeatAnnotationTest.class.getMethod("myAction2");
        Action[] actions = myAction2.getAnnotationsByType(Action.class);
        for (Action action:actions){
            System.out.println(action.value());
        }
    }
}