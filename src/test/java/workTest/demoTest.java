package workTest;

import org.junit.Test;
import utils.tupleUtil.TupleTwo;

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

    }
}
