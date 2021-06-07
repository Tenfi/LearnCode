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


    private List<Integer> getIntegers() {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <1000000; i++) {
            list.add(i);
        }
        return list;
    }

    @Test
    /*
     * [方法描述]  最原始的方法
     * @param  null
     * @return void
     * @author admin
     * @create 2020/12/7 11:38
     */
    public void test1(){
        List<Integer> list = getIntegers();
        for (int num:list){
            writeToCsv(num,"test1");
        }
    }

    @Test
    /*
     * [方法描述]
     * @param null
     * @return 串行计算
     * @author admin
     * @create 2020/12/7 11:37
     */
    public void test2(){
        List<Integer> list = getIntegers();
        list.stream().forEach(x->writeToCsv(x,"test2"));
    }



    @Test
    /*
     * [方法描述]
     * @param null
     * @return 并行计算，io流每次写入都会开启关闭，系统自动加锁,安全的
     * @author admin
     * @create 2020/12/7 11:36
     */
    public void test3(){
        List<Integer> list = getIntegers();
        list.parallelStream().forEach(x->writeToCsv(x,"test3"));
    }

    @Test
    /*
     * [方法描述]
     * @param null
     * @return io不关，将数据流变为全局变量，速度快了，但是数据会丢失或增多，不安全
     * @author admin
     * @create 2020/12/7 11:34
     */
    public void test4() throws IOException {
        List<Integer> list = getIntegers();
        File file = new File("C:\\Users\\admin\\Desktop\\test\\test4.csv");
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(file, true));
        list.parallelStream().forEach(x-> {
            try {
                writeToCsv2(x,"test4",file,writeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writeFile.close();
    }

    @Test
    /*
     * [方法描述]
     * @param null
     * @return  写入方法加锁后，安全
     * @author admin
     * @create 2020/12/7 11:33
     */
    public void test5() throws IOException {
        List<Integer> list = getIntegers();
        File file = new File("C:\\Users\\admin\\Desktop\\test\\test5.csv");
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(file, true));
        list.parallelStream().forEach(x-> {
            try {
                writeToCsv3(x,"test5",file,writeFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writeFile.close();
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

    public void writeToCsv2(int num,String fileName,File file,BufferedWriter writeFile) throws IOException {
        try {
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

    public synchronized void writeToCsv3(int num,String fileName,File file,BufferedWriter writeFile) throws IOException {
        try {
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
