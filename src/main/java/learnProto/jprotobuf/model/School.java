package learnProto.jprotobuf.model;

import com.baidu.bjf.remoting.protobuf.Any;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

import java.util.List;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/13 17:37
 */

@ProtobufClass
public class School {
    @ProtobufClass
    public static class Location{
        @Protobuf(fieldType= FieldType.STRING, order=1)
        private String name;
        @Protobuf(fieldType= FieldType.UINT32, order=2)
        private Integer id;

        public String getName() {
            return name;
        }

        public Location setName(String name) {
            this.name = name;
            return this;
        }
        public Integer getId() {
            return id;
        }
        public Location setId(Integer id) {
            this.id = id;
            return this;
        }
    }
    @Protobuf(fieldType= FieldType.OBJECT, order=1)
    private Location schoolLocation;
    @Protobuf(fieldType= FieldType.BOOL, order=2)
    private Boolean isOpen;
    @Protobuf(fieldType= FieldType.OBJECT, order=3)
    private List<Student> allStudents;
    @Protobuf(fieldType = FieldType.OBJECT,order = 4)
    private Any extend;

    public Any getExtend() {
        return extend;
    }

    public School setExtend(Any extend) {
        this.extend = extend;
        return this;
    }

    public Location getSchoolLocation() {
        return schoolLocation;
    }

    public School setSchoolLocation(Location schoolLocation) {
        this.schoolLocation = schoolLocation;
        return this;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public School setOpen(Boolean open) {
        isOpen = open;
        return this;
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

    public School setAllStudents(List<Student> allStudents) {
        this.allStudents = allStudents;
        return this;
    }
}
