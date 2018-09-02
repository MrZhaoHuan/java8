package com.zhao;

import com.zhao.bean.Animal;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-02 22:07
 * @描述 stream(filter/collect sorted/collect limit min/get map/reduce foreach)
 **/
public class StreamTest {

    List<Animal> animals;

    @Before
    public void before() {
        animals = Arrays.asList(
                new Animal("dog", "red", 10),
                new Animal("cat", "blue", 3),
                new Animal("pig", "green", 20),
                new Animal("monkey", "blue", 11),
                new Animal("snake", "yellow", 16)
        );
    }

    //过滤筛选出 age>10
    @Test
    public void t1() {
        List<Animal> filterAnimals = animals.stream()
                .filter(x -> x.getAge() > 10)
                .collect(Collectors.toList());
        filterAnimals.forEach(x -> System.out.println(x));
    }

    //根据age排序，显示前3条
    @Test
    public void t2() {
        //animals.sort( (x,y) -> x.getAge()-y.getAge() );
        //animals.stream().limit(3).forEach( x -> System.out.println(x));

        animals.stream()
                .sorted((x, y) -> x.getAge() - y.getAge())
                .limit(3)
                .forEach(x -> System.out.println(x));
    }

    //显示age最高 和 最低的 animal
    @Test
    public void t3() {
        System.out.println(animals.stream().max((x, y) -> x.getAge() - y.getAge()).get());
        System.out.println(animals.stream().min((x, y) -> x.getAge() - y.getAge()));
    }

    //strem ——> map
    @Test
    public void t4() {
        animals.stream()
                .map(x -> x.getAge())
                .collect(Collectors.toList())
                .forEach(x -> System.out.println(x));
    }

    //strem ——> reduce
    @Test
    public void t5() {
        List<Integer> nums = Arrays.asList(1, 3, 2);

        Optional<Integer> sum = nums.stream()
                .reduce((x, y) -> x + y);

        System.out.println(sum.get());
    }
}