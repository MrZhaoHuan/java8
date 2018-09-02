package com.zhao;

import com.zhao._interface.AnimalService;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-09-02 20:02
 * @描述
    Lambda 表达式需要“函数式接口”的支持
    函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 			   可以检查是否是函数式接口
 **/
public class LambdaTest {

    //语法格式一：无参数，无返回值
    @Test
    public void t1(){
        Runnable runnable = () -> System.out.println("任务");
        runnable.run();
    }

    //语法格式二：有一个参数，并且无返回值
    @Test
    public void t2(){
        //AnimalService animalService = new AnimalService() {
        //    public void eat(String food) {
        //        System.out.println(food);
        //    }
        //};
        //animalService.eat("食物");

        AnimalService animalService = (food) -> {
            System.out.println(food);
        };
        animalService.eat("食物");
    }


    //语法格式三：若只有一个参数，小括号可以省略不写
    @Test
    public void t3(){
        AnimalService animalService = food -> {
            System.out.println(food);
        };
        animalService.eat("食物");
    }

    //语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
    @Test
    public void t4(){
        Comparator<Integer> comparator = (x,y) -> {
            System.out.println("x:"+x+" compare y:"+y);
            return x.compareTo(y);
        };

        int compareResult = comparator.compare(new Integer(3), new Integer(3));
        System.out.println(compareResult);
    }

    //语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
    @Test
    public void t5(){
        Comparator<Integer> comparator = (x,y) -> x.compareTo(y);

        int compareResult = comparator.compare(new Integer(3), new Integer(3));
        System.out.println(compareResult);
    }

    //利用lambda遍历list
    @Test
    public void t6(){
        List<String> player = Arrays.asList("zhang","li","wang","zhao");
        //以前的方式
        //for (String p : player){
        //    System.out.println(p);
        //}

        //lambda方式
        //player.forEach( p -> System.out.println(p) );
        //lambda方式：双冒号
        player.forEach(System.out::println);
    }

    //lambda实例
    @Test
    public void t7(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务");
            }
        });
        thread.start();

        //lambda
        thread = new Thread(() -> System.out.println("lambda任务"));
        thread.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}