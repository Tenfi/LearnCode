package learnProto.selfTest;

import com.google.protobuf.InvalidProtocolBufferException;
import learnProto.selfTest.MyTest.Data;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        convertProto(1);
        convertProto(1000);
        convertProto(1000000000);
        convertProto(-1);
    }

    public static void convertProto(int value) {
        //1.通过build创建消息构造器
        Data.Builder dataBuilder = Data.newBuilder();
        //2.设置字段值
        dataBuilder.setId(value);
        //3.通过消息构造器构造消息对象
        Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //5.反序列化
        try {
            Data parseFrom = Data.parseFrom(bytes);
            System.out.println("id="+parseFrom.getId());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
