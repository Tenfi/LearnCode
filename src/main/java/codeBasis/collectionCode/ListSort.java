package codeBasis.collectionCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListSort {


    static class B {
        private String name;
        private String order;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        @Override
        public String toString() {
            return "name is " + name + " order is " + order;
        }
    }

    public static void main(String[] args) {
        // list排序
        //第一种方法示例：
        List<String> lists = new ArrayList<String>();
        lists.add("5");
        lists.add("2");
        lists.add("9");
        //lists中的对象String 本身含有compareTo方法，所以可以直接调用sort方法，按自然顺序排序，即升序排序
        Collections.sort(lists);

        //第一种方法示例：
        List<A> listA = new ArrayList<>();
        listA.add(new A("a2",2));
        listA.add(new A("a1",1));
        //list中的对象A实现Comparable接口
        Collections.sort(listA);

        //第二种方法示例：
        List<B> listB = new ArrayList<B>();
        B b1 = new B();
        b1.setName("b2");
        b1.setOrder("b");
        B b2 = new B();
        b2.setName("b1");
        b2.setOrder("a");
        listB.add(b1);
        listB.add(b2);
        //list中的对象B没有实现Comparable接口
        //直接改变原始数据的顺序
        listB.sort(Comparator.comparing(B::getOrder));
        //不改变原始的数据顺序，返回结果
        List<B> c = listB.stream().sorted(Comparator.comparing(B::getOrder).thenComparing(B::getName)).collect(Collectors.toList());

        System.out.println(lists);
        System.out.println(listA);
        System.out.println(listB);
        System.out.println(c);


        // 第三种自定义排序

    }
}