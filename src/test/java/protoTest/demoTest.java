package protoTest;

import com.google.protobuf.InvalidProtocolBufferException;
import learnProto.selfTest.MyTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author huangtengfei
 * @description
 * @time 2020/12/29 10:39
 */
public class demoTest {
    public void convertUint32(int value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setUint32(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertInt32(int value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setInt32(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertSint32(int value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setSint32(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertFixed32(int value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setFixed32(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertUint64(long value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setUint64(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertInt64(long value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setInt64(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertSint64(long value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setSint64(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertFixed64(long value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setFixed64(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertDouble(double value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setDouble(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertStr(String value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setStr(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    public void convertBool(boolean value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setBool(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
    }

    @Test
    public void test32(){
        // UInt32 - [0 : 4294967295]
        // Int32 - [-2147483648 : 2147483647]
        // java 中没有uint  相当于int
        System.out.println("=================uint32================");
        convertUint32(1);
        convertUint32(1000);
        convertUint32(Integer.MAX_VALUE);
        convertUint32(-1);
        convertUint32(-1000);
        convertUint32(Integer.MIN_VALUE);

        // 当输入为负数时，自动扩展为64为表示；表达负数时统一占用10个字节
        System.out.println("=================int32================");
        convertInt32(1);
        convertInt32(1000);
        convertInt32(2147483647);
        convertInt32(-1);
        convertInt32(-1000);
        convertInt32(-2147483648);

        // 表达负数更省字节
        System.out.println("=================sint32================");
        convertSint32(1);
        convertSint32(1000);
        convertSint32(2147483647);
        convertSint32(-1);
        convertSint32(-1000);
        convertSint32(-2147483648);

        // 省略了tag，统一占4个字节，适合于数值较大的占比多的情况。
        System.out.println("=================fix32================");
        convertFixed32(1);
        convertFixed32(1000);
        convertFixed32(2147483647);
        convertFixed32(-1);
        convertFixed32(-1000);
        convertFixed32(-2147483648);
    }

    @Test
    public void test64(){
        // UInt64 - [0 : 18446744073709551615]
        // Int64 - [-9223372036854775808 : 9223372036854775807]
        // java 中没有uint  相当于int
        System.out.println("=================uint64================");
        convertUint64(1);
        convertUint64(1000);
        convertUint64(Long.MAX_VALUE);
        convertUint64(-1);
        convertUint64(-1000);
        convertUint64(Long.MIN_VALUE);

        // 当输入为负数时，自动扩展为64为表示；表达负数时统一占用10个字节
        System.out.println("=================int64================");
        convertInt64(1);
        convertInt64(1000);
        convertInt64(Long.MAX_VALUE);
        convertInt64(-1);
        convertInt64(-1000);
        convertInt64(Long.MIN_VALUE);

        // 表达负数更省字节
        System.out.println("=================sint64================");
        convertSint64(1);
        convertSint64(1000);
        convertSint64(Long.MAX_VALUE);
        convertSint64(-1);
        convertSint64(-1000);
        convertSint64(Long.MIN_VALUE);

        // 省略了tag，统一占4个字节，适合于数值较大的占比多的情况。
        System.out.println("=================fixed64================");
        convertFixed64(1);
        convertFixed64(1000);
        convertFixed64(Long.MAX_VALUE);
        convertFixed64(-1);
        convertFixed64(-1000);
        convertFixed64(Long.MIN_VALUE);
    }

    @Test
    public void testDouble() {
        System.out.println("=================double================");
        convertDouble(1.0);
        convertDouble(1.0001);
        convertDouble(Double.MAX_VALUE);
        convertDouble(-1.0);
        convertDouble(-1.0001);
        convertDouble(Double.MIN_VALUE);
    }

    @Test
    public void test(){
        System.out.println("================若保留7位小数===============");
        System.out.println("--> 转为整数，用int64编码：");
        convertAndValiddInt(1700000001);
        System.out.println("--> 仍用小数，用float编码：");
        convertAndValiddFloat(170.0000001f);
        System.out.println("--> 仍用小数，用double编码：");
        convertAndValiddDouble(170.0000001);
        System.out.println("================若保留8位小数===============");
        System.out.println("--> 转为整数，用int64编码：");
        convertAndValiddInt(Long.valueOf("17000000001"));
        System.out.println("--> 仍用小数，用float编码：");
        convertAndValiddFloat(170.00000001f);
        System.out.println("--> 仍用小数，用double编码：");
        convertAndValiddDouble(170.00000001);
    }

    @Test
    public void testTime(){
        System.out.println("================测试时间戳(精确到秒)===============");
        System.out.println("--> 用int64编码：");
        convertInt64(Long.valueOf("1600229610283"));
        System.out.println("--> 用fixed64编码：");
        convertFixed64(Long.valueOf("1600229610283"));
        System.out.println("================测试时间戳(精确到毫秒)===============");
        System.out.println("--> 用int64编码：");
        convertInt64(Long.valueOf("1600229610283000"));
        System.out.println("--> 用fixed64编码：");
        convertFixed64(Long.valueOf("1600229610283000"));
    }





    public void convertAndValiddInt(long value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setInt64(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //5.反序列化
        try {
            MyTest.Data parseFrom = MyTest.Data.parseFrom(bytes);
            System.out.println("反序列化后的数据="+parseFrom.getInt64());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    public void convertAndValiddDouble(double value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setDouble(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //5.反序列化
        try {
            MyTest.Data parseFrom = MyTest.Data.parseFrom(bytes);
            System.out.println("反序列化后的数据="+parseFrom.getDouble());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    public void convertAndValiddFloat(float value) {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        dataBuilder.setFloat(value);
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        //4.序列化
        byte[] bytes = data.toByteArray();
        System.out.println(value+"序列化后的数据：" + Arrays.toString(bytes)+",字节个数："+bytes.length);
        //5.反序列化
        try {
            MyTest.Data parseFrom = MyTest.Data.parseFrom(bytes);
            System.out.println("反序列化后的数据="+parseFrom.getFloat());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStr() {
        System.out.println("=================string================");
        convertStr("");
        convertStr("a");
        convertStr("abc");
        convertStr("啊");
        convertStr("啊啊");
    }

    @Test
    public void testbool() {
        System.out.println("=================bool================");
        convertBool(false);
        convertBool(true);
    }

    @Test
    public void testXingneng() {
        //1.通过build创建消息构造器
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
        //2.设置字段值
        for (int i = 0; i < 10000000; i++) {
            dataBuilder.setInt32(i);
        }
        //3.通过消息构造器构造消息对象
        MyTest.Data data = dataBuilder.build();
        long t0 = System.nanoTime();
        byte[] bytes = data.toByteArray();
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("time: %d ms", millis));
    }
}
