package learnProto.selfTest;

import com.google.protobuf.InvalidProtocolBufferException;
import learnProto.selfTest.MyTest.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        convertProto(1000);
//        convertProto(1000);
//        convertProto(1000000000);
//        convertProto(-1);
    }

    public static void convertProto(int value) {
        //1.通过build创建消息构造器
        Data.Builder dataBuilder = Data.newBuilder();
        //2.设置字段值
        dataBuilder.setInt32(value);
        //3.通过消息构造器构造消息对象
        Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //5.反序列化
        try {
            learnProto.selfTest.MyTest.Data parseFrom = learnProto.selfTest.MyTest.Data.parseFrom(bytes);
            System.out.println("反序列化后的数据："+parseFrom.getInt32());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    public static void convertProtoByStream(int value) {
        //1.通过build创建消息构造器
        Data.Builder dataBuilder = Data.newBuilder();
        //2.设置字段值
        dataBuilder.setInt32(value);
        //3.通过消息构造器构造消息对象
        Data data = dataBuilder.build();
        //4.序列化
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            // 将消息序列化并写入输出流
            data.writeTo(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 通过输出流转化成二进制字节流
        byte[] bytes = output.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //5.反序列化
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        try {
            Data parseFrom = Data.parseFrom(input);
            System.out.println("反序列化后的数据："+parseFrom.getInt32());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
