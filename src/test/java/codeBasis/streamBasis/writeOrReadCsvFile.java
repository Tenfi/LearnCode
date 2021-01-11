package codeBasis.streamBasis;

import org.junit.Test;

import java.io.*;
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
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileByChar() {
        try (FileReader input = new FileReader("C:\\Users\\admin\\Desktop\\demo.txt")) {
            int n;
            // 按字节读取数据
            while ((n = input.read()) != -1) {
                System.out.println((char)n);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void writeToCsv(String fileName){
        File file = new File("C:\\Users\\admin\\Desktop\\"+fileName+".csv");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"utf-8"))) {
            // 首行写字段名
            if (file.length() == 0) {
                String header = "field1,field2";
                writer.write(header);
            }
            // 添加行分隔符 "\n"
            writer.newLine();
            String content = "1,2";
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        String str = "你好hello";
        int byte_len = str.getBytes().length;
        int len = str.length();
        System.out.println("字节长度为：" + byte_len);
        System.out.println("字符长度为：" + len);
        System.out.println("系统默认编码方式：" + System.getProperty("file.encoding"));
    }

    @Test
    public void test(){
        readFileByByte();
        System.out.println("=======");
        readFileByChar();
//        readFile();
//        writeToCsv("csv1");
    }
}
