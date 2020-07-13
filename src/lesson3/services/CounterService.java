package lesson3.services;

import lesson3.models.Counter;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CounterService {
    private final Connection connection;

    public CounterService(Connection connection) {
        this.connection = connection;
    }

    public List<Counter> getCounterByMaker(){
        String sql = "SELECT maker, count(*) AS quantity FROM store_cms_plusplus.laptop GROUP BY maker ORDER BY quantity DESC";
        return queryDatabaseCounter(sql);
    }

    public List<Counter> queryDatabaseCounter(String sql) {
        List<Counter> counters = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                Counter counter = null;
                try {
                    String maker = resultSet.getString(1);
                    int quantity = resultSet.getInt(2);
                    counter = new Counter(maker, quantity);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                counters.add(counter);
            }
            return counters;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }
}
