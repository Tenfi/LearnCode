package learnProto.selfTest.func;

import learnProto.selfTest.Enum.WireType;

public class MyProtoFunc {
    static int makeTag(int fieldNumber, WireType wireType) {
        return fieldNumber << 3 | wireType.getValue();
    }

    public static void main(String[] args) {
        int tag = makeTag(1, WireType.VARIENT);
        System.out.println(tag);

        short i=-1;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i>>1));
        System.out.println(Integer.toBinaryString(i>>>1));
    }

}
