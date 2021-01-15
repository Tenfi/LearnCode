package protoTest;

import com.baidu.bjf.remoting.protobuf.Any;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.google.protobuf.InvalidProtocolBufferException;
import learnProto.jprotobuf.model.Person;
import learnProto.jprotobuf.model.School;
import learnProto.jprotobuf.model.Teacher;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/14 16:04
 */
public class jprotobufTest {
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

    @Test
    public void test(){
        // jproto
//        Person person = new Person();
        Person person = new Person();
        Codec<Person> simpleTypeCodec = ProtobufProxy.create(Person.class);

        try {
            // 序列化
            byte[] b = simpleTypeCodec.encode(person);
            writeFileByte(b,"C:\\Users\\admin\\Desktop\\jproto.pack");
            System.out.println("jproto序列化后的数据：" + Arrays.toString(b)+",字节个数："+b.length);
            // 反序列化
            byte[] bytes =readFileByte("C:\\Users\\admin\\Desktop\\jproto.pack");
            Person newStt = simpleTypeCodec.decode(bytes);
            System.out.println("反序列化后的数据："+newStt);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // proto
//        learnProto.practiceTest.protoModel.Person builderPerson = learnProto.practiceTest.protoModel.Person.newBuilder().build();
        learnProto.practiceTest.protoModel.Person builderPerson = learnProto.practiceTest.protoModel.Person.newBuilder().setAge(0).build();
        // 序列化
        String path="C:\\Users\\admin\\Desktop\\Protodemo.pack";
        byte[] bytes = builderPerson.toByteArray();
        writeFileByte(bytes,path);
        System.out.println("序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //反序列化
        learnProto.practiceTest.protoModel.Person parseFrom = null;
        try {
            byte[] bytes1 = readFileByte(path);
            parseFrom = learnProto.practiceTest.protoModel.Person.parseFrom(bytes1);
//            System.out.println("反序列化后的数据："+parseFrom);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void schooltest() throws IOException {
        // jproto
//        Person person = new Person();
        Any any = Any.pack(new Teacher());
        School person = new School().setExtend(any);
        Codec<School> simpleTypeCodec = ProtobufProxy.create(School.class);

        try {
            // 序列化
            byte[] b = simpleTypeCodec.encode(person);
            writeFileByte(b,"C:\\Users\\admin\\Desktop\\jproto.pack");
            System.out.println("jproto序列化后的数据：" + Arrays.toString(b)+",字节个数："+b.length);
            // 反序列化
            byte[] bytes =readFileByte("C:\\Users\\admin\\Desktop\\jproto.pack");
            School newStt = simpleTypeCodec.decode(bytes);
            System.out.println("反序列化后的数据："+newStt);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // proto
//        learnProto.practiceTest.protoModel.Person builderPerson = learnProto.practiceTest.protoModel.Person.newBuilder().build();

        com.google.protobuf.Any any1 = com.google.protobuf.Any.pack(learnProto.practiceTest.protoModel.Teacher.newBuilder().build());
        learnProto.practiceTest.protoModel.School builderPerson = learnProto.practiceTest.protoModel.School.newBuilder()
                .setExtend(any1)
                .build();
        // 序列化
        String path="C:\\Users\\admin\\Desktop\\Protodemo.pack";
        byte[] bytes = builderPerson.toByteArray();
        writeFileByte(bytes,path);
        System.out.println("序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //反序列化
        learnProto.practiceTest.protoModel.School parseFrom = null;
        try {
            byte[] bytes1 = readFileByte(path);
            parseFrom = learnProto.practiceTest.protoModel.School.parseFrom(bytes1);
            System.out.println("反序列化后的数据："+parseFrom);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
