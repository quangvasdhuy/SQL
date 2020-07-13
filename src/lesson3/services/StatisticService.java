package lesson3.services;

import lesson3.models.Counter;
import lesson3.models.Statistic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatisticService {
    private final Connection connection;

    public StatisticService(Connection connection) {
        this.connection = connection;
    }

    public List<Statistic> getStatisticByMaker() {
        String sql = "SELECT maker, sum(sold) AS sold, sum(price) AS totalMoney FROM store_cms_plusplus.laptop GROUP BY maker ORDER BY sold DESC";
        return queryDatabaseStatistic(sql);
    }

    public List<Statistic> queryDatabaseStatistic(String sql) {
        List<Statistic> statistics = new ArrayList<>();
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
                    Statistic statistic = null;
                    try {
                        String maker = resultSet.getString(1);
                        int sold = resultSet.getInt(2);
                        int totalMoney = resultSet.getInt(3);
                        statistic = new Statistic(maker, sold, totalMoney);
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                    statistics.add(statistic);
                }
                return statistics;
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


