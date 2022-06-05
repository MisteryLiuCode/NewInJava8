import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @program: NewInJava8
 * @description:
 * @author: 刘帅彪
 * @create: 2022-06-04 15:08
 **/


public class MyTest {
    //    语法格式一，普通方式，简单使用
    @Test
    public void test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通方式，重写Runnable接口的方法");
            }
        };
//        我这里只是重写了run方法，并没有实现runnable接口，也没有调用start方法，不是多线程
        runnable.run();
        System.out.println("======使用lamdba表达式调用=====");
        Runnable runnable1 = () -> System.out.println("使用lamdba表达式输出");
        runnable1.run();
    }

    //    语法格式2，参数为String
    public void test2(){
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("谎言和誓言的区别是什么");
        System.out.println("========");
        Consumer<String> consumer1=(String s)->{
            System.out.println(s);
        };
        consumer1.accept("一个是听得人当真了，一个是说的人当真了");
    }
    @Test
//    语法格式三，类型推断，前面泛型指定之后，那么括号里面的类型可以省略
    public void test3() {
//        类型推到
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("谎言和誓言的区别是什么");
        System.out.println("========");
//        前面泛型已经指定为String类型了，所以可以省略泛型
        Consumer<String> consumer1 = (s) -> {
            System.out.println(s);
        };
        consumer1.accept("一个是听得人当真了，一个是说的人当真了");
    }

    //    语法格式四，如果只有一个参数，那么小括号也可以省略
    @Test
    public void test4() {
//        类型推到
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("谎言和誓言的区别是什么");
        System.out.println("========");
//        可以省略这个地方的小括号
        Consumer<String> consumer1 = s -> {
            System.out.println(s);
        };
        consumer1.accept("一个是听得人当真了，一个是说的人当真了");
    }


    //    语法格式五，需要两个或者两个以上的参数，多条执行和语句，并且可以有返回值
    @Test
    public void test5() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1, o2);
            }
        };
//        因为11比21小，所以输出-1
        int compare2 = comparator.compare(11, 21);
        System.out.println(compare2);
//        有多条执行语句，并且有返回值
        Comparator<Integer> com3 = (Integer o1, Integer o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
//        21比11大，输出1
        int compare3 = com3.compare(21, 11);
        System.out.println(compare3);
    }


    //    语法格式六，当Lamdba体只有一条执行语句，return与大括号若有，都可以省略
    @Test
    public void test6() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1, o2);
            }
        };
//        因为11比21小，所以输出-1
        int compare2 = comparator.compare(11, 21);
        System.out.println(compare2);
//        只有一条返回值，那么可以省略retuern和大括号
        Comparator<Integer> com3 = (Integer o1, Integer o2) ->Integer.compare(o1, o2);
//        21比11大，输出1
        int compare3 = com3.compare(21, 11);
        System.out.println(compare3);
    }
}
