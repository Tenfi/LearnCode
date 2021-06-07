package codeBasis.streamBasis;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/13 16:27
 */
public class writeOrReadByteFile {

    public static void writeFileByte(byte[] b,String path) {
        File file = new File(path);
        long size = file.length();
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(b);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static byte[] readFileByte(String path) {
        File file = new File(path);
        long size = file.length();
        byte[] b = new byte[(int) size];
        try (InputStream fis = new FileInputStream(file)) {
            System.out.println(fis.read());
            if (fis.read(b) < 0) {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Test
    public void test(){
        byte[] data =new byte[]{'a','s','d'};
        writeFileByte(data,"C:\\Users\\admin\\Desktop\\demo.pack");
        data=readFileByte("C:\\Users\\admin\\Desktop\\demo.pack");
        System.out.println(Arrays.toString(data));
    }
}
