package binaryCalu;

import org.junit.Test;

public class binaryTest {
    public void print(int value){
        System.out.println("value="+value+",其二进制串为（左侧的0省略）："+Integer.toBinaryString(value));
    }

    @Test
    public void zuoyi(){
        int i=1;
        print(i);
        print(i<<31);

        int j =-1;
        print(j);
        print(j<<1);
    }

    @Test
    public void youyi(){
        int i=11;
        print(i);
        print(i>>1);

        int j =-5;
        print(j);
        print(j>>2);
    }

    @Test
    public void test(){
        int i=1;
        print(i);  // 原码
        print(~i); // 反码
        print(~i+1);  // 补码
    }
}
