package workTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangtengfei
 * @description
 * @time 2020/12/2 18:25
 */
public class RSDparse {
    @Test
    public void test(){
        char[] data=new char[]{'1','2','3','4','5','6','7','8',
                '1','2','3','4','5','6','7','8',
                '1','2','3','4','5','6','7','8',
                '1','2','3','4','5','6','7','8',
                '1','2','3','4','5','6','7','8',
                '1','2','3','4','5','6','7','8',
                '1','2','3','4','5','6','7','8',
                '1','2','3','4','5','6','7','8'
        };

        List<int[]> indexList = new ArrayList<>();
        indexList.add(new int[]{0,10});
        indexList.add(new int[]{10,10});
        indexList.add(new int[]{20,10});
        indexList.add(new int[]{30,1});
        indexList.add(new int[]{31,1});

        // 记录数据在第几个字节
        List<String> indexs=new ArrayList<>(data.length);
        for (int i = 0; i < data.length; i++) {
                indexs.add(String.valueOf(i/8+1));
        }

        // 1、按1个字节来处理数据
        for (int[] starEndIndex:indexList){
            int startIndex = starEndIndex[0];
            int endIndex = starEndIndex[1];
            // 跨度有几个字节
            int byteNumber = endIndex-startIndex;
        }


        // 2、从总数据中提取数据

        // 3、将提取的数据，以块为单位存入栈

        // 4、从栈中取出数据
    }

    public void pushToStack(List<List<String>> stack,List<String> pushedData){
        stack.add(pushedData);

    }

    public String StackToString(List<List<String>> stack){
        Collections.reverse(stack);
        List<String> temp=new ArrayList<>();
        for (List<String> list:stack){
            temp.add(String.join("",list));
        }
        return String.join("",temp);
    }
}
