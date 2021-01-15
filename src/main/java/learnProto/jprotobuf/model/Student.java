package learnProto.jprotobuf.model;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/12 16:26
 */

@ProtobufClass
public class Student{
    @Protobuf(fieldType=FieldType.OBJECT, order=1)
    private Person baseInfo;
    @Protobuf(fieldType=FieldType.FIXED32, order=2)
    private Integer calssId;
    @Protobuf(fieldType=FieldType.SINT32, order=3)
    private Integer score;

    public Person getBaseInfo() {
        return baseInfo;
    }

    public Student setBaseInfo(Person baseInfo) {
        this.baseInfo = baseInfo;
        return this;
    }

    public Integer getCalssId() {
        return calssId;
    }

    public Student setCalssId(Integer calssId) {
        this.calssId = calssId;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public Student setScore(Integer score) {
        this.score = score;
        return this;
    }
}