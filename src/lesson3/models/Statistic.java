package lesson3.models;

public class Statistic {
    private String maker;
    private int slod;
    private int totalMoney;

    public Statistic(String maker, int slod, int totalMoney) {
        this.maker = maker;
        this.slod = slod;
        this.totalMoney = totalMoney;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getSlod() {
        return slod;
    }

    public void setSlod(int slod) {
        this.slod = slod;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "maker='" + maker + '\'' +
                ", slod=" + slod +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
