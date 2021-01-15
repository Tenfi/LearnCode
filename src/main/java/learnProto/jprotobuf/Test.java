package learnProto.jprotobuf;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import learnProto.jprotobuf.model.*;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/12 16:12
 */
public class Test {
    public static void writeFileByte(byte[] b,String path) {
        File file = new File(path);
        long size = file.length();
        try (FileOutputStream fos = new FileOutputStream(file)) {
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
            if (fis.read(b) < 0) {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
    public static void main(String[] args) {

        Person person = new Person().setAge(10).setGender(Person.Gender.MAN).setName("Tom").setHeight(100.00f).setWeight(100.00d).setPersonLocation(
                new Person.Location().setPlaceId(123l).setPlaceName("hubei")
        );
        Student stu = new Student().setCalssId(10).setScore(-1).setBaseInfo(person);
        Student stu1 = new Student().setCalssId(10).setScore(1).setBaseInfo(person);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(stu);
        studentArrayList.add(stu1);

        School sch = new School().setOpen(true).setAllStudents(studentArrayList).setSchoolLocation(new School.Location().setId(123).setName("hubei"));

        try {
            // 序列化
            Codec<School> simpleTypeCodec = ProtobufProxy.create(School.class);
            byte[] b = simpleTypeCodec.encode(sch);
            writeFileByte(b,"C:\\Users\\admin\\Desktop\\jproto.pack");
            System.out.println("序列化后的数据：" + Arrays.toString(b)+",字节个数："+b.length);
            // 反序列化
            byte[] bytes =readFileByte("C:\\Users\\admin\\Desktop\\jproto.pack");
            School newStt = simpleTypeCodec.decode(bytes);
            System.out.println("反序列化后的数据："+newStt);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回的内容即为 Protobuf的IDL描述文件
        String code = ProtobufIDLGenerator.getIDL(School.class);
        System.out.println(code);
    }
}
