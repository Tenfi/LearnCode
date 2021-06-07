package codeBasis.sortTest;


import codeBasis.collectionCode.A;
import org.junit.Test;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangtengfei
 * @description
 * @time 2021/5/7 15:40
 */
public class ListTest {

    // 基本要素的排序
    @Test
    public void intTest() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(5);
        intList.add(4);
        System.out.println("原始：" + intList);
        // 倒置
        Collections.reverse(intList);
        System.out.println("倒置：" + intList);
        // 排序
        intList.sort(Comparator.naturalOrder());
        System.out.println("正序：" + intList);
        intList.sort(Comparator.reverseOrder());
        System.out.println("倒序：" + intList);
    }

    @Test
    public void strTest() {
        List<String> strList = new ArrayList<>();
        strList.add("武汉");
        strList.add("北京");
        strList.add("上海");
        System.out.println("原始：" + strList);
        // 排序
        Collator instance = Collator.getInstance(Locale.CHINA);
        strList.sort(instance);
        System.out.println("正序：" + strList);
        strList.sort(instance.reversed());
        System.out.println("倒序：" + strList);
    }


    @Test
    public void objectTest() {
        List<A> listA = new ArrayList<>();
        listA.add(new A("a2", 1));
        listA.add(new A("a3", 3));
        listA.add(new A("a3", 2));
        listA.add(new A("a1", 3));
        System.out.println("原始：" + listA);
        // 1.基于A的order升序排序
        //方法一：list中的对象A实现Comparable接口，直接sort
        listA.sort(Comparator.naturalOrder());
        System.out.println("1.基于order升序——方法1：" + listA);
        //方法二：若A没有实现Comparable接口，使用Comparator.comparing
        listA.sort(Comparator.comparing(A::getOrder));
        System.out.println("1.基于order升序——方法2：" + listA);

        // 2.基于A的order及name的升序排序
        List<A> result1 = listA.stream().sorted(Comparator.comparing(A::getOrder).thenComparing(A::getName)).collect(Collectors.toList());
        System.out.println("2.基于A的order及name的升序排序——方法2扩展：" + result1);

        // 3.基于A的order及name的降序排序
        List<A> result2 = listA.stream().sorted(Comparator.comparing(A::getOrder).thenComparing(A::getName).reversed()).collect(Collectors.toList());
        System.out.println("3.基于A的order及name的降序排序——方法2扩展：" + result2);

        // 4.基于A的order升序以及name的降序排序
        Comparator<A> comparatorName = (a1, a2) -> -a1.getName().compareTo(a2.getName());
        listA.sort(Comparator.comparing(A::getOrder).thenComparing(comparatorName));
        System.out.println("4.基于A的order升序以及name的降序排序——方法2扩展：" + listA);

        //方法三：自定义排序
        Comparator<A> comparator = (a1, a2) -> {
            if (a1.getOrder().equals(a2.getOrder())) {
                return -a1.getName().compareTo(a2.getName());
            }
            return a1.getOrder().compareTo(a2.getOrder());
        };
        listA.sort(comparator);
        System.out.println("4.基于order升序及name降序——方法3：" + listA);
    }
}
