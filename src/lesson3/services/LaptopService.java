package lesson3.services;

import lesson3.models.Laptop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopService {
    private final Connection connection;

    public LaptopService(Connection connection) {
        this.connection = connection;
    }

    public List<Laptop> searchLaptop(Float fromPrice, Float toPrice, String maker, Float screeenSize, String cpu, String ram, String ssd, String hdd, String type, String card, String order) {
        String sql = "SELECT * FROM laptop WHERE TRUE ";
        if (fromPrice != null) {
            sql += " AND price >= " + fromPrice;
        }
        if (toPrice != null) {
            sql += " AND price <= " + toPrice;
        }
        if (maker != null) {
            sql += " AND maker = '" + maker + "'";
        }
        if (screeenSize != null) {
            sql += " AND screen_size = '" + screeenSize + "'";
        }
        if (ram != null) {
            sql += " AND ram = '" + ram + "'";
        }
        if (cpu != null) {
            sql += " AND cpu LIKE '%" + cpu + "%'";
        }
        if (ssd != null) {
            sql += " AND ssd = '" + ssd + "'";
        }
        if (hdd != null) {
            sql += " AND hdd = '" + hdd + "'";
        }
        if (type != null) {
            sql += " AND type = '" + type + "'";
        }
        if (card != null) {
            sql += " AND card = '" + card + "'";
        }
        if (order != null) {
            if (order.contains("ASC")) {
                sql += " ORDER BY sold ASC";
            } else if (order.contains("DESC")) {
                sql += " ORDER BY sold DESC";
            } else {
                sql += "";
            }
        }
        return queryDatabaseLaptop(sql);
    }

    public List<Laptop> queryDatabaseLaptop(String sql) {
        List<Laptop> laptops = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            try {
                ResultSet resultSet = statement.executeQuery(sql);
                while (true) {
                    try {
                        if (!resultSet.next()) break;
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                    Laptop laptop = null;
                    try {
                        int id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String url = resultSet.getString(3);
                        String maker = resultSet.getString(4);
                        String type = resultSet.getString(5);
                        String ram = resultSet.getString(6);
                        String cpu = resultSet.getString(7);
                        String ssd = resultSet.getString(8);
                        String hdd = resultSet.getString(9);
                        Float price = resultSet.getFloat(10);
                        String card = resultSet.getString(11);
                        String screenResolution = resultSet.getString(12);
                        Float screenSize = resultSet.getFloat(13);
                        int sold = resultSet.getInt(14);
                        Timestamp createdTimestamp = resultSet.getTimestamp(15);
                        Timestamp lastUpdatedTimestamp = resultSet.getTimestamp(16);

                        laptop = new Laptop(id, name, url, maker, type, ram, cpu, ssd, hdd, price, card, screenResolution, screenSize, sold, createdTimestamp, lastUpdatedTimestamp);
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                    laptops.add(laptop);
                }
                return laptops;
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                return null;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }



}