package learnProto.protostuffTest.model;

import java.util.List;
import learnProto.protostuffTest.model.Student;
/**
 * @author huangtengfei
 * @description
 * @time 2021/1/12 15:49
 */
public class School {
    private  String schoolName;
    private List<Student> students;
    public School(String schoolName, List<Student> students) {
        this.schoolName = schoolName;
        this.students = students;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}



