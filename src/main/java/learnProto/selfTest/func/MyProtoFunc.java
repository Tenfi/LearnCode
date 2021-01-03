package learnProto.selfTest.func;

import com.google.protobuf.CodedOutputStream;
import learnProto.selfTest.Enum.WireType;

import java.io.IOException;

public class MyProtoFunc {
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = (1 << TAG_TYPE_BITS) - 1;

    /*Initial size*/
    static int getSerializedSize(){
        return 0;
    }

    /*write to */
    static void writeTo(){

    }


    /** Given a tag value, determines the wire type (the lower 3 bits). */
    static int getTagWireType(final int tag) {
        return tag & TAG_TYPE_MASK;
    }

    /** Given a tag value, determines the field number (the upper 29 bits). */
    public static int getTagFieldNumber(final int tag) {
        return tag >>> TAG_TYPE_BITS;
    }

    /** Makes a tag value given a field number and wire type. */
    static int makeTag(int fieldNumber, WireType wireType) {
        return fieldNumber << 3 | wireType.getValue();
    }

    static  public void print(int value){
        System.out.println("value="+value+",其二进制串为（左侧的0省略）："+Integer.toBinaryString(value));
    }

//    public byte[] toByteArray() {
//        try {
//            // 初始化
//            byte[] result = new byte[getSerializedSize()];
//            CodedOutputStream output = CodedOutputStream.newInstance(result);
//            // 写入
//            writeTo(output);
//            output.checkNoSpaceLeft();
//            return result;
//        } catch (IOException var3) {
//            throw new RuntimeException(this.getSerializingExceptionMessage("byte array"), var3);
//        }
//    }

    public static void main(String[] args) {
        int tag=makeTag(10, WireType.VARIENT);
        print(tag);
        print(getTagWireType(tag));
        print(getTagFieldNumber(tag));

        System.out.println(Long.toBinaryString(0x7FL));
        print(0xFF);
    }

}
