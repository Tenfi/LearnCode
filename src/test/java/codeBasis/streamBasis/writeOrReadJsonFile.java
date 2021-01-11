package codeBasis.streamBasis;

import org.junit.Test;

import java.io.*;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/11 15:47
 */
public class writeOrReadJsonFile {
    public static void writeStrToJsonFile(String data, String filePath, String fileName) {
        String path=filePath + fileName+ ".json";
        //如果文件不存在，则新建一个
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入数据，默认utf-8编码，如果有中文可以改为gbk
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,false))) {
            writer.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readJsonFileToStr(String filePath,String fileName) {
        String path=filePath + fileName+ ".json";
        String result = "";
        // 读取数据，默认utf-8编码，如果有中文可以改为gbk
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                result += tempString;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void writeStrToJsonFile2(String data, String filePath, String fileName) {
        String path=filePath + fileName+ ".json";
        //如果文件不存在，则新建一个
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入数据，默认utf-8编码，如果有中文可以改为gbk
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,false), "UTF-8"))) {
            writer.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readJsonFileToStr2(String filePath,String fileName) {
        String path=filePath + fileName+ ".json";
        String result = "";
        // 读取数据，默认utf-8编码，如果有中文可以改为gbk
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                result += tempString;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public void test(){
        String rodm_demo = readJsonFileToStr("C:\\Users\\admin\\Desktop\\工作\\众包\\现实库\\", "RODM_demo");
        System.out.println(rodm_demo);
    }

}
