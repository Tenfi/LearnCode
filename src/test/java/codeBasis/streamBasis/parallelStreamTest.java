package codeBasis.streamBasis;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author huangtengfei
 * @description
 * @time 2020/12/3 14:18
 */
public class parallelStreamTest {
    public List<String> getInitData(){
        int max = 1000000;
        List<String> values = new ArrayList<String>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }

//    @Test
    public void sequentialSortTest(){
        List<String> values=getInitData();
        // 串行排序
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

//    @Test
    public void parallelStreamTest(){
        List<String> values=getInitData();
        // 并行排序
        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }

    @Test
    public void test1(){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <100000; i++) {
            list.add(i);
        }
        for (int num:list){
            writeToCsv(num,"test1");
        }
    }

    @Test
    public void test2(){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <100000; i++) {
            list.add(i);
        }

        list.stream().forEach(x->writeToCsv(x,"test2"));
    }

    @Test
    public void test3(){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <100000; i++) {
            list.add(i);
        }
        list.parallelStream().forEach(x->writeToCsv(x,"test3"));
    }


    public void writeToCsv(int num,String fileName){
        File file = new File("C:\\Users\\admin\\Desktop\\test\\"+fileName+".csv");
        try (BufferedWriter writeFile = new BufferedWriter(new FileWriter(file, true))) {
            if (file.length() == 0) {
                String header = "num"+ "\n";
                writeFile.write(header);
                writeFile.flush();
            }
            writeFile.write(String.valueOf(num) + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
