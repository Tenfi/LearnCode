package codeBasis.collectionCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huangtengfei
 * @description
 * @time 2021/2/26 11:28
 */
public class MapSort {

    /*
     * 基于value排序
     * @param  isReverse 表示是否逆序排
     * @return
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean isReverse) {
        Map<K, V> result = new LinkedHashMap<>();

        if (isReverse) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    /*
     * 基于key排序
     * @param  isReverse 表示是否逆序排
     * @return
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isReverse) {
        Map<K, V> result = new LinkedHashMap<>();
        if (isReverse) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("b", 0.08);
        map.put("a", 0.1);
        map.put("c", 0.02);
        map.put("d", 0.91);
        System.out.println("原始："+map);

        Map<String, Double> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        System.out.println("按key升序排："+result);

        Map<String, Double> result2 = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        System.out.println("按value升序排："+result2);


        Map<String, Double> stringDoubleMap2 = sortByKey(map, false);
        System.out.println("按key排序："+stringDoubleMap2);

        Map<String, Double> stringDoubleMap = sortByValue(map, false);
        System.out.println("按value排序："+stringDoubleMap);
    }

}
