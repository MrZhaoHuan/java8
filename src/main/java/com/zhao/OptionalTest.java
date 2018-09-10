package com.zhao;

import com.zhao.bean.Animal;
import org.junit.Test;

import java.util.Optional;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-10 22:38
 * @描述    这个功能鸡肋0.0
 **/
public class OptionalTest {

    @Test
    public void t1(){
        Optional<Animal> animalOptional = Optional.ofNullable(null);
       // Optional<Animal> animalOptional = Optional.ofNullable(new Animal("zhao","red",18));
        boolean present = animalOptional.isPresent();
        if(present){
            System.out.println(animalOptional.get());
        }else{
            System.out.println(present);
        }
    }
}