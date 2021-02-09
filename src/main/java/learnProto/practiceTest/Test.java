package learnProto.practiceTest;

import com.google.protobuf.InvalidProtocolBufferException;
import learnProto.practiceTest.protoModel.Person;
import learnProto.practiceTest.protoModel.School;
import learnProto.practiceTest.protoModel.Student;

import java.io.*;
import java.util.Arrays;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/14 11:39
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
        Person.Builder builderPerson = Person.newBuilder().setAge(10).setGender(Person.Gender.woman).setName("Tom").setHeight(100.00f).setWeight(100.00d).setLocation(
                Person.Location.newBuilder().setPlaceId(123l).setPlaceName("hubei")
        );
        School school = School.newBuilder()
                .setIsOpen(true)
                .setSchoolLocation(School.Location.newBuilder().setId(123).setName("hubei"))
                .addAllStudents(Student.newBuilder().setBaseInfo(builderPerson).setCalssId(10).setScore(-1))
                .addAllStudents(Student.newBuilder().setBaseInfo(builderPerson).setCalssId(10).setScore(1))
                .build();

        // 序列化
        String path="C:\\Users\\admin\\Desktop\\Protodemo.pack";
        byte[] bytes = school.toByteArray();
        writeFileByte(bytes,path);
        System.out.println("序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //反序列化
        School parseFrom = null;
        try {
            byte[] bytes1 = readFileByte(path);
            parseFrom = School.parseFrom(bytes1);
            System.out.println("反序列化后的数据："+parseFrom);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
