package codeBasis.lambdaFunc;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/1 14:17
 */
public class Apple {
    private String color;
    private int weight;

    public Apple() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }
}
