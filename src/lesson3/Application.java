package lesson3;

import lesson3.models.Counter;
import lesson3.models.Laptop;
import lesson3.models.Statistic;
import lesson3.services.CounterService;
import lesson3.services.LaptopService;
import lesson3.services.StatisticService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Connection connection;
    private static final String hostName = "localhost";
    private static final String databaseName = "store_cms_plusplus";
    private static final String userName = "root";
    private static final String password = "AR/m-F)+7/f}V`?Z";
    private static List<Laptop> laptops;
    private static List<Counter> counters;
    private static List<Statistic> statistics;

    public static void main(String[] args) {
        Application mainApp = new Application();
        connection = getDatabaseConnection(hostName, databaseName, userName, password);
        while (true) mainApp.menu(connection);
    }

    private void menu(Connection connection) {
        LaptopService laptopService = new LaptopService(connection);
        CounterService counterService = new CounterService(connection);
        StatisticService statisticService = new StatisticService(connection);

        Scanner scanner = new Scanner(System.in);
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("HỆ THỐNG QUẢN LÝ SẢN PHẨM");
        System.out.println("1. Tìm kiếm laptop");
        System.out.println("2. Thêm thông tin laptop");
        System.out.println("3. Chỉnh sửa thông tin ");
        System.out.println("4. Xóa thông tin laptop");
        System.out.println("5. Thống kê số lượng laptop theo hãng sản xuất");
        System.out.println("6. Thống kê số lượng, số tiền bán được của mỗi hãng sản xuất");

        try {
            System.out.println("\nNhập lựa chọn:");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("1. Tìm kiếm laptop");
//                    System.out.println("Nhập vào lần lượt các tiêu chí cần tìm: Mức giá nhỏ nhất, Mức giá lớn nhất, Hãng sản xuất, " +
//                            "Kích thước màn hình, CPU, RAM, SSD, HDD, Card màn hình, Loại máy tính, Sắp xếp theo thứ tự");
//                    Float fromPrice = scanner.nextFloat();
//                    scanner.nextLine();
//                    Float toPrice = scanner.nextFloat();
//                    scanner.nextLine();
//                    String maker = scanner.nextLine();
//                    Float screenSize = scanner.nextFloat();
//                    scanner.nextLine();
//                    String cpu = scanner.nextLine();
//                    String ram = scanner.nextLine();
//                    String ssd = scanner.nextLine();
//                    String hdd = scanner.nextLine();
//                    String card = scanner.nextLine();
//                    String type = scanner.nextLine();
//                    String order = scanner.nextLine();
//                   laptops = laptopService.searchLaptop(fromPrice, toPrice, maker, screenSize, cpu, ram, ssd, hdd, card, type, order);
 //                   laptops = laptopService.searchLapTop(0.0f, 10000000.0f, "Asus", 14.0f, "Intel", null, null, null, null, null, "DESC");
                    if (laptops == null || laptops.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin sản phẩm.");
                    } else {
                        for (Laptop laptop : laptops) {
                            System.out.println(laptop.toString());
                        }
                    }
                    break;
                case 2:
                    System.out.println("2. Thêm thông tin laptop");
                    break;
                case 3:
                    System.out.println("3. Chỉnh sửa thông tin ");
                    break;
                case 4:
                    System.out.println("4. Xóa thông tin laptop");
                    break;
                case 5:
                    System.out.println("5. Thống kê số lượng laptop theo hãng sản xuất");
                    counters = counterService.getCounterByMaker();
                    if (counters == null || counters.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin sản phẩm.");
                    } else {
                        for (Counter counter : counters) {
                            System.out.println(counter.toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println("6. Thống kê số lượng, số tiền bán được của mỗi hãng sản xuất");
                    statistics = statisticService.getStatisticByMaker();
                    if (statistics == null || statistics.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin sản phẩm.");
                    } else {
                        for (Statistic statistic : statistics) {
                            System.out.println(statistic.toString());
                        }
                    }
                    break;
                default:
                    menu(connection);
                    break;
            }
        } catch (Exception exception) {
            menu(connection);
        }
    }

    public static Connection getDatabaseConnection(String hostName, String databaseName, String userName, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy MySQL JDBC Driver!!");
            return null;
        }

        try {
            String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + databaseName;
            connection = DriverManager.getConnection(connectionURL, userName, password);
            return connection;
        } catch (SQLException e) {
            System.out.println("Kết nối database thất bại!");
        }
        return null;
    }
}