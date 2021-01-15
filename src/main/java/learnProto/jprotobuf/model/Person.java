package learnProto.jprotobuf.model;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/13 17:26
 */

@ProtobufClass
public class Person {
    @ProtobufClass
    public enum Gender {
        MAN(0),WOMAN(1);
        @Protobuf(fieldType= FieldType.INT32, order=1)
        private final Integer value;

        Gender(Integer value) { this.value = value; }

        public Integer toValue() { return this.value; }

        public Integer value() {
            return toValue();
        }
    }
    @ProtobufClass
    public static class Location{
        @Protobuf(fieldType= FieldType.STRING, order=1)
        private String placeName;
        @Protobuf(fieldType= FieldType.UINT64, order=2)
        private Long placeId;

        public String getPlaceName() {
            return placeName;
        }

        public Location setPlaceName(String placeName) {
            this.placeName = placeName;
            return this;
        }

        public Long getPlaceId() {
            return placeId;
        }

        public Location setPlaceId(Long placeId) {
            this.placeId = placeId;
            return this;
        }
    }

    @Protobuf(fieldType= FieldType.STRING, order=1)
    private String name;
    @Protobuf(fieldType= FieldType.INT32, order=2)
    private Integer age;
    @Protobuf(fieldType= FieldType.ENUM, order=3)
    private Gender gender;
    @Protobuf(fieldType= FieldType.FLOAT, order=4)
    private Float height;
    @Protobuf(fieldType= FieldType.DOUBLE, order=5)
    private Double weight;
    @Protobuf(fieldType= FieldType.OBJECT, order=6)
    private Location personLocation;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Float getHeight() {
        return height;
    }

    public Person setHeight(Float height) {
        this.height = height;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public Person setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Location getPersonLocation() {
        return personLocation;
    }

    public Person setPersonLocation(Location personLocation) {
        this.personLocation = personLocation;
        return this;
    }
}
