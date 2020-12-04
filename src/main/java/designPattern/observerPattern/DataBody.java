package designPattern.observerPattern;

/**
 * @author huangtengfei
 * @description
 * @time 2020/11/12 14:09
 */
public class DataBody {
    private double temperture;
    private double humidity;
    private double time;

    public DataBody(double temperture, double humidity, double time) {
        this.temperture = temperture;
        this.humidity = humidity;
        this.time = time;
    }

    public double getTemperture() {
        return temperture;
    }

    public void setTemperture(double temperture) {
        this.temperture = temperture;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
