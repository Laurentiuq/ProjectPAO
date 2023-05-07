package Persistence.Repos;

import Model.Chicken;
import Persistence.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ChickenRepository implements GenericRepository<Chicken> {
    private final Map<String, Chicken> storage = new HashMap<>();
    public static final String INSERT_STATEMENT = "INSERT INTO chicken ( ringCode,  name,  species,  weight,  age,  healthStatus,  eggProducer) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_STATEMENT = "SELECT * FROM chicken";
    public static final String SELECT_BY_ID_STATEMENT = "SELECT * FROM chicken WHERE earTag = ?";
    public static final String DELETE_STATEMENT = "DELETE FROM chicken WHERE earTag = ?";
    private final Connection connection;
    private static volatile ChickenRepository instance;

    private ChickenRepository() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public static ChickenRepository getInstance() throws SQLException {
        if (instance == null) {
            synchronized (ChickenRepository.class) {
                if (instance == null) {
                    instance = new ChickenRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public Chicken save(Chicken chicken) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
        preparedStatement.setInt(1, chicken.getRingCode());
        preparedStatement.setString(2, chicken.getName());
        preparedStatement.setString(3, chicken.getSpecies());
        preparedStatement.setDouble(4, chicken.getWeight());
        preparedStatement.setInt(5, chicken.getAge());
        preparedStatement.setString(6, chicken.getHealthStatus());
        preparedStatement.setBoolean(7, chicken.isEggProducer());
        preparedStatement.executeUpdate();
        return chicken;
    }

    @Override
    public List<Chicken> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STATEMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Chicken> chickens = new ArrayList<>();
            while (resultSet.next()) {
                Chicken chicken = new Chicken(
                        resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getDouble("weight"),
                        resultSet.getInt("age"),
                        resultSet.getString("healthStatus"),
                        resultSet.getBoolean("eggProducer"),
                        resultSet.getInt("ringCode")
                                );
                chickens.add(chicken);
            }
            return chickens;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Chicken> findById(String ringCode) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_STATEMENT);
            preparedStatement.setString(1, ringCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Chicken chicken = new Chicken(
                        resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getDouble("weight"),
                        resultSet.getInt("age"),
                        resultSet.getString("healthStatus"),
                        resultSet.getBoolean("eggProducer"),
                        resultSet.getInt("ringCode")
                );
                return Optional.of(chicken);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    @Override
    public void update(Chicken chicken) {
        //TODO
    }

    @Override
    public void delete(Chicken chicken) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT);
            preparedStatement.setInt(1, chicken.getRingCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
