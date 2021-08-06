package codeBasis.streamBasis;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tenfi
 * @description
 * @time 2021/8/6 19:36
 */
public class StreamTest {
    class Student {
        private String name;
        private int age;
        private int salary;

        public Student(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }
    }

    public List<Student> initData() {
        Student a = new Student("A", 20, 3000);
        Student b = new Student("B", 26, 8000);
        Student c = new Student("C", 21, 2666);
        Student d = new Student("D", 19, 5677);
        return Arrays.asList(a, b, c, d);
    }

    @Test
    public void test() {
        List<Student> students = initData();
        // 过滤
        List<Student> collect = students.stream().filter(student -> student.getSalary() > 3000).collect(Collectors.toList());
        // 最大值
        Student student = students.stream().max(Comparator.comparing(Student::getSalary)).get();
        Integer integer = students.stream().max(Comparator.comparing(Student::getSalary)).map(Student::getSalary).get();
        // 平均值
        Double collect1 = students.stream().collect(Collectors.averagingInt(Student::getSalary));
        double average = students.stream().mapToInt(Student::getSalary).average().getAsDouble();
        int sum = students.stream().mapToInt(Student::getSalary).sum();


    }

}
