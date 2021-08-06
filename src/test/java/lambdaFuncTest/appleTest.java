package lambdaFuncTest;

import codeBasis.lambdaFunc.Apple;
import com.google.common.base.Supplier;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/1 14:20
 */
public class appleTest {

    class Person {
        private Car car;

        public Car getCar() {
            return car;
        }
    }

    class Car {
        private Insurance insurance;

        public Insurance getInsurance() {
            return insurance;
        }
    }

    class Insurance {
        private String name;

        public String getName() {
            return name;
        }
    }

    public List<Apple> filterApple(List<Apple> apples, Predicate<Apple> a) {
        List<Apple> appleList = new ArrayList<>();
        for (Apple apple : apples) {
            if (a.test(apple)) {
                appleList.add(apple);
            }
        }
        return appleList;
    }

    @Test
    public void test() {
        List<Object> objects = new ArrayList<>();
        Object o = Optional.ofNullable(objects);


        Person person = new Person();
//        String name = person.getCar().getInsurance().getName();
        Optional<String> s = Optional.ofNullable(person).map(Person::getCar).map(Car::getInsurance).map(Insurance::getName);
    }

    @Test
    public void normalTest() {
        Supplier<Apple> appleSupplier = Apple::new;
        Apple apple1 = appleSupplier.get();

        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("green", 12));
        appleList.add(new Apple("red", 13));
        appleList.add(new Apple("blue", 14));

        appleList.remove(2);


        List<Apple> appleList2 = appleList.subList(0, 0);


        List<Apple> collect = appleList.stream().filter(apple -> apple.getWeight() > 12).collect(Collectors.toList());
        System.out.println();


        Predicate<Apple> predicate = x -> x.getColor().equals("green");
        Predicate<Apple> negate = predicate.negate();


        List<Apple> appleList1 = filterApple(appleList, negate);
        System.out.println();

        List<Apple> collect1 = appleList.stream().distinct().collect(Collectors.toList());


        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(3, 4);

        List<int[]> collect2 = a.stream().flatMap(i -> b.stream().map(
                j -> new int[]{i, j})).collect(Collectors.toList());

        System.out.println();

        Integer reduce = a.stream().reduce(1, (i, j) -> i * j);
        System.out.println();


        a.stream().collect(Collectors.summarizingInt(Integer::intValue));


        String temp = "1";
        Optional<String> temp1 = Optional.ofNullable(temp);
        Optional<Integer> integer = Optional.ofNullable(Integer.parseInt(temp));
        System.out.println();


        Integer integer1 = Optional.ofNullable(Integer.parseInt(temp)).orElse(null);
    }
}
