package protoTest;

import org.junit.Test;

public class sourceCodeAnalysis {
    public void print(int value){
        System.out.println("value="+value+",其二进制串为（左侧的0省略）："+Integer.toBinaryString(value));
    }

    /**
     * Compute the number of bytes that would be needed to encode a varint.
     * {@code value} is treated as unsigned, so it won't be sign-extended if
     * negative.
     * value视为无符整数，因此使用0xffffffff，判断value序列化后需要占用几个字节！
     */
    public static int computeRawVarint32Size(final int value) {
        if ((value & (0xffffffff <<  7)) == 0) return 1;
        if ((value & (0xffffffff << 14)) == 0) return 2;
        if ((value & (0xffffffff << 21)) == 0) return 3;
        if ((value & (0xffffffff << 28)) == 0) return 4;
        return 5;
    }

    @Test
    public void testGetSize(){
//        int value=0x00000080;
//        print(value);
//        print(0xffffffff <<  7);
//        print(computeRawVarint32Size(value));
//        print((1<<3));
//        print((1<<3)-1);
        print(127);
    }
}
