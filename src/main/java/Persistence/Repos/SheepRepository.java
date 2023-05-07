package Persistence.Repos;

import Model.Sheep;
import Persistence.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SheepRepository implements GenericRepository<Sheep> {
    private final Map<String, Sheep> storage = new HashMap<>();
    public static final String INSERT_STATEMENT = "INSERT INTO sheep (earTag, name, weight, age, healthStatus, woolBreed, letterIdentifier, uniqueNumberIdentifier, species) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_STATEMENT = "SELECT * FROM sheep";
    public static final String SELECT_BY_ID_STATEMENT = "SELECT * FROM sheep WHERE earTag = ?";
    public static final String DELETE_STATEMENT = "DELETE FROM sheep WHERE earTag = ?";
    private final Connection connection;
    private static volatile SheepRepository instance;

    private SheepRepository() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public static SheepRepository getInstance() throws SQLException {
        if (instance == null) {
            synchronized (SheepRepository.class) {
                if (instance == null) {
                    instance = new SheepRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public Sheep save(Sheep sheep) throws SQLException {
        storage.put(sheep.getEarTag(), sheep);
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
        preparedStatement.setString(1, sheep.getEarTag());
        preparedStatement.setString(2, sheep.getName());
        preparedStatement.setDouble(3, sheep.getWeight());
        preparedStatement.setInt(4, sheep.getAge());
        preparedStatement.setString(5, sheep.getHealthStatus());
        preparedStatement.setString(6, sheep.getWoolBreed());
        preparedStatement.setString(7, sheep.getLetterIdentifier());
        preparedStatement.setInt(8, sheep.getUniqueNumberIdentifier());
        preparedStatement.setString(9, sheep.getSpecies());
        preparedStatement.executeUpdate();
        return sheep;
    }

    @Override
    public List<Sheep> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STATEMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Sheep> sheeps = new ArrayList<>();

            while (resultSet.next()) {
                Sheep sheep = new Sheep(
                        resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getDouble("weight"),
                        resultSet.getInt("age"),
                        resultSet.getString("healthStatus"),
                        resultSet.getString("woolBreed"),
                        resultSet.getString("letterIdentifier"),
                        resultSet.getInt("uniqueNumberIdentifier"),
                        resultSet.getDate("lastShearing"));
                sheeps.add(sheep);
            }
            return sheeps;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Sheep> findById(String earTag){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_STATEMENT);
            preparedStatement.setString(1, earTag);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Sheep sheep = new Sheep(
                        resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getDouble("weight"),
                        resultSet.getInt("age"),
                        resultSet.getString("healthStatus"),
                        resultSet.getString("woolBreed"),
                        resultSet.getString("letterIdentifier"),
                        resultSet.getInt("uniqueNumberIdentifier"),
                        resultSet.getDate("lastShearing"));
                return Optional.of(sheep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    @Override
    public void delete(Sheep sheep) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT);
            preparedStatement.setString(1, sheep.getEarTag());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(Sheep sheep){
        storage.put(sheep.getEarTag(), sheep);
    }
}
