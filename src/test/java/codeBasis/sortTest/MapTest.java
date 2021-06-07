package codeBasis.sortTest;

import codeBasis.collectionCode.A;
import org.junit.Test;

import java.util.*;

/**
 * @author huangtengfei
 * @description
 * @time 2021/2/26 11:43
 */
public class MapTest {
    @Test
    public void test() {
        Map<String, Double> map = new HashMap<>();
        map.put("b", 0.08);
        map.put("a", 0.1);
        map.put("c", 0.02);
        map.put("d", 0.91);
        System.out.println("原始：" + map);

        Map<String, Double> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        System.out.println("按key升序排：" + result);

        Map<String, Double> result2 = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(e -> result2.put(e.getKey(), e.getValue()));
        System.out.println("按value升序排：" + result2);
    }


    @Test
    public void treeMapTest() {
        TreeMap<String, Double> map = new TreeMap<>();
        map.put("b", 0.08);
        map.put("a", 0.1);
        map.put("c", 0.02);
        System.out.println("默认按key正序:" + map);

        TreeMap<String, Double> map2 = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        map2.put("b", 0.08);
        map2.put("a", 0.1);
        map2.put("c", 0.02);
        System.out.println("自定义按key逆序:" + map2);
    }


    @Test
    public void objectTest() {
        Map<String, A> map = new HashMap<>();
        map.put("b", new A("a2", 1));
        map.put("a", new A("a3", 3));
        map.put("c", new A("a3", 2));
        map.put("d", new A("a1", 3));
        Map<String, A> result = new LinkedHashMap<>();
        Comparator<Map.Entry<String, A>> comparator = (c1, c2) -> {
            A a1 = c1.getValue();
            A a2 = c2.getValue();
            if (a1.getOrder().equals(a2.getOrder())) {
                return -a1.getName().compareTo(a2.getName());
            }
            return a1.getOrder().compareTo(a2.getOrder());
        };
        map.entrySet().stream().sorted(comparator).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        System.out.println("按照value中的order升序及name的降序排序" + result);
    }

    @Test
    public void teste(){
        System.out.println("sasd".indexOf("sd"));
        String a= "asdasd";
        System.out.println(a.toCharArray()[0]);
    }
}
