package lesson3.models;

import java.sql.Timestamp;

public class Laptop {
    private int id;
    private String name;
    private String url;
    private String maker;
    private String type;
    private String ram;
    private String cpu;
    private String ssd;
    private String hdd;
    private Float price;
    private String card;
    private String screenResolution;
    private Float screenSize;
    private int sold;
    private Timestamp createdTimestamp;
    private Timestamp lastUpdatedTimestamp;

    public Laptop() {
    }

    public Laptop(int id, String name, String url, String maker, String type, String ram, String cpu, String ssd, String hdd, Float price, String card, String screenResolution, Float screenSize, int sold, Timestamp createdTimestamp, Timestamp lastUpdatedTimestamp) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.maker = maker;
        this.type = type;
        this.ram = ram;
        this.cpu = cpu;
        this.ssd = ssd;
        this.hdd = hdd;
        this.price = price;
        this.card = card;
        this.screenResolution = screenResolution;
        this.screenSize = screenSize;
        this.sold = sold;
        this.createdTimestamp = createdTimestamp;
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public Float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Float screenSize) {
        this.screenSize = screenSize;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Timestamp getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(Timestamp lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", maker='" + maker + '\'' +
                ", type='" + type + '\'' +
                ", ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ssd='" + ssd + '\'' +
                ", hdd='" + hdd + '\'' +
                ", price=" + price +
                ", card='" + card + '\'' +
                ", screenResolution='" + screenResolution + '\'' +
                ", screenSize=" + screenSize +
                ", sold=" + sold +
                ", createdTimestamp=" + createdTimestamp +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                '}';
    }
}
