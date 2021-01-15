package learnProto.jprotobuf.model;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/15 16:30
 */
@ProtobufClass
public class Teacher {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public Teacher setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }
}
