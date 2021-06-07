package workTest;

import org.junit.Test;
import utils.tupleUtil.TupleTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author huangtengfei
 * @description
 * @time 2021/2/2 17:58
 */
public class demoTest {
    @Test
    public void test(){
        TupleTwo<String,Integer> a= new TupleTwo<>("s",1);
        a.set_1("2");

        String s = null;
        Integer s1 = Optional.ofNullable(s).map(Integer::parseInt).orElse(1);

        System.out.println(s1);
    }
}
