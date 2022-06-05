import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyTest {

    @Test
    public void test() {
//        传统方法调用
        testConsume(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("传统方法消费" + aDouble + "元");
            }
        });
//       lambda方法调用
        testConsume(400, money -> System.out.println("lambda表达式方法消费" + money + "元"));
    }

    public void testConsume(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }


    //    调用断定型接口
    @Test
    public void testFilter() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("01");
        strings.add("02");
        strings.add("03");
        strings.add("11");
//        普通方法调用
        List<String> strings2 = filterString(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("1");
            }
        });
        System.out.println(strings2);
        System.out.println("=======lambda表达式调用======");
//        lambda表达式调用
        List<String> strings1 = filterString(strings, s -> s.contains("1"));
        System.out.println(strings1);
    }

    //断定型接口，根据规则过滤字符串中的字符
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        list.forEach((item) -> {
            if (predicate.test(item)) {
                filterList.add(item);
            }

        });
        return filterList;
    }

}
