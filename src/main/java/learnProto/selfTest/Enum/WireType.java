package learnProto.selfTest.Enum;
/*
* https://blog.csdn.net/carson_ho/article/details/70568606
* */
public enum WireType {
    VARIENT(0),
    FIXED64(1),
    LENGTHDELIMI(2),
    FIXED32(5);
    private int value;


    WireType(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
