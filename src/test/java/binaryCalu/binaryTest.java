package binaryCalu;

import org.junit.Test;

public class binaryTest {
    public void print(int value){
        System.out.println("value="+value+",其二进制串为（左侧的0省略）："+Integer.toBinaryString(value));
    }

    @Test
    public void zuoyi(){
        int i=1;
        System.out.println("================原始数据===============");
        print(i);
        System.out.println("================左移1位===============");
        print(i<<1);
        System.out.println("================左移31位===============");
        print(i<<31);

        int j =-1;
        System.out.println("================原始数据===============");
        print(j);
        System.out.println("================左移1位===============");
        print(j<<1);
        System.out.println("================左移31位===============");
        print(j<<31);
    }

    @Test
    public void youyi(){
        int i=5;
        System.out.println("================原始数据===============");
        print(i);
        System.out.println("================右移1位===============");
        print(i>>1);
        System.out.println("================右移2位===============");
        print(i>>2);
        System.out.println("================右移3位===============");
        print(i>>3);

        int j =-5;
        System.out.println("================原始数据===============");
        print(j);
        System.out.println("================右移1位===============");
        print(j>>1);
        System.out.println("================右移2位===============");
        print(j>>2);
        System.out.println("================右移3位===============");
        print(j>>3);
    }

    @Test
    public void youyi2(){
        int i=5;
        System.out.println("================原始数据===============");
        print(i);
        System.out.println("================右移1位===============");
        print(i>>>1);
        System.out.println("================右移2位===============");
        print(i>>>2);
        System.out.println("================右移3位===============");
        print(i>>>3);

        int j =-5;
        System.out.println("================原始数据===============");
        print(j);
        System.out.println("================右移1位===============");
        print(j>>>1);
        System.out.println("================右移2位===============");
        print(j>>>2);
        System.out.println("================右移3位===============");
        print(j>>>3);
    }

    @Test
    public void test(){
        int i=1;
        print(i);  // 原码
        print(~i); // 反码
        print(~i+1);  // 补码
    }

    @Test
    public void convert(){
        // 二进制表示
        System.out.println(0b101);
        // 十六进制表示
        System.out.println(0x101);
        // 二进制转十进制
        System.out.println(Integer.valueOf("101",2));
        // 十六进制转十进制
        System.out.println(Integer.valueOf("a",16));
        // 十进制转二进制
        System.out.println(Integer.toBinaryString(10));
        // 十进制转十六进制
        System.out.println(Integer.toHexString(10));
    }

}
