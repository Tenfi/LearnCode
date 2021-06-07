package codeBasis.streamBasis;

import org.apache.commons.io.input.ReaderInputStream;
import org.junit.Test;

import java.io.*;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/11 15:50
 */
public class writeOrReadCsvFile {
    // 一个字节一个字节的读取
    public static void readFileByByte(){
        try (InputStream input = new FileInputStream("C:\\Users\\admin\\Desktop\\demo.txt")) {
            int n;
            // 按字节读取数据
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 自己设定缓冲区容量，按buffer数量读取
    public static void readFileByByte2() {
        try (InputStream input = new FileInputStream("C:\\Users\\admin\\Desktop\\demo.txt")) {
            // 定义3个字节大小的缓冲区:
            byte[] buffer = new byte[3];
            int n;
            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
                // 每次读取后,把数组的有效字节部分，变成字符串打印
                System.out.println(new String(buffer,0,n));//  len 每次读取的有效字节个数
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileByChar() {
        try (FileReader input = new FileReader("C:\\Users\\admin\\Desktop\\demo.txt")) {
            int n;
            // 按字符读取数据
            while ((n = input.read()) != -1) {
                System.out.println((char)n);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToCsv(String filePath,String fileName){
        File file = new File("C:\\Users\\admin\\Desktop\\"+fileName+".csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))) {
            // 首行写字段名
            if (file.length() == 0) {
                String header = "field1,field2,s,d";
                writer.write(header);
            }
            // 添加行分隔符 "\n"
            writer.newLine();
            String content = "1,2,是,asd";
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readFromCsv(String filePath,String fileName){
        File file = new File("C:\\Users\\admin\\Desktop\\"+fileName+".csv");
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                result += tempString;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        String filePath ="C:\\Users\\admin\\Desktop\\";
//        String fileName = "ARK-SP9-TRAFFIC_LIGHT";
        String fileName = "test";
        writeToCsv(filePath,fileName);
        readFromCsv(filePath,fileName);
    }
}
