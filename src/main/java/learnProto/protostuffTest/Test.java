package learnProto.protostuffTest;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import learnProto.protostuffTest.model.School;
import learnProto.protostuffTest.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/12 15:53
 */
public class Test {
    public static void main(String[] args) {
        // 实例化
        List<Student> studentList=new ArrayList<>();
        Student student =new Student("tom",12);
        studentList.add(student);
        School school =new School("fang",studentList);


        Schema<School> schema = RuntimeSchema.getSchema(School.class);
        //避免每次序列化都重新申请Buffer空间
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

        // 序列化
        final byte[] protostuff;
        try
        {
            protostuff = ProtostuffIOUtil.toByteArray(school, schema, buffer);
            System.out.println(protostuff);
        }
        finally
        {
            buffer.clear();
        }

        // 反序列化
        Schema<School> schemaed = RuntimeSchema.getSchema(School.class);
        School Parsed = schemaed.newMessage();
        ProtostuffIOUtil.mergeFrom(protostuff, Parsed, schemaed);
        System.out.println();
    }
}
