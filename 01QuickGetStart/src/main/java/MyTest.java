import org.junit.Test;

import java.util.Comparator;

public class MyTest {
    public static void main(String[] args) {
        MyTest myTest = new MyTest();
    }

    @Test
    public void test1() {
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

    @Test
    public void test2() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
//        因为11比21小，所以输出-1
        int compare2 = comparator.compare(11, 21);
        System.out.println(compare2);
        System.out.println("=========方法引用======");
        Comparator<Integer> com3=Integer ::compare;
//        21比11大，输出1
        int compare3 = com3.compare(21, 11);
        System.out.println(compare3);
    }

};

