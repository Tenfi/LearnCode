package codeBasis.collectionCode;

/**
 * @author huangtengfei
 * @description
 * @time 2021/5/10 10:39
 */

public class A implements Comparable<A> {
    private String name;
    private Integer order;

    public A(String name, Integer order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "order=" + order+ " name=" + name;
    }

    @Override
    public int compareTo(A a) {
        return this.order.compareTo(a.getOrder());
    }
}
