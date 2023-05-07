package Persistence.Repos;

import Model.Cow;
import Model.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Persistence.DBConnection;

public class CowRepository implements GenericRepository<Cow> {
    private final Map<String, Cow> storage = new HashMap<>();
    private static final String INSERT_STATEMENT = "INSERT INTO cow (earTag, name, weight, age, healthStatus, size, letterIdentifier, uniqueNumberIdentifier, species, subspecies) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STATEMENT = "SELECT * FROM cow";
    private static final String SELECT_BY_ID_STATEMENT = "SELECT * FROM cow WHERE earTag = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM cow WHERE earTag = ?";
    private final Connection connection;
    private static volatile CowRepository instance;

    public CowRepository() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public static CowRepository getInstance() throws SQLException {
        if (instance == null) {
            synchronized (CowRepository.class) {
                if (instance == null) {
                    instance = new CowRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public Cow save(Cow cow) throws SQLException {
        storage.put(cow.getEarTag(), cow);
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
        preparedStatement.setString(1, cow.getEarTag());
        preparedStatement.setString(2, cow.getName());
        preparedStatement.setDouble(3, cow.getWeight());
        preparedStatement.setInt(4, cow.getAge());
        preparedStatement.setString(5, cow.getHealthStatus());
        preparedStatement.setObject(6, cow.getSize(), java.sql.Types.OTHER);
        preparedStatement.setString(7, cow.getLetterIdentifier());
        preparedStatement.setInt(8, cow.getUniqueNumberIdentifier());
        preparedStatement.setString(9, cow.getSpecies());
        preparedStatement.setString(10, cow.getSubspecies());
        preparedStatement.executeUpdate();
        return cow;
    }

    @Override
    public List<Cow> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STATEMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cow> cows = new ArrayList<>();
            while(resultSet.next()) {
                Cow cow = new Cow(resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getDouble("weight"),
                        resultSet.getInt("age"),
                        resultSet.getString("healthStatus"),
                        Size.valueOf(resultSet.getString("size")),
                        resultSet.getString("subspecies"),
                        resultSet.getString("letterIdentifier"),
                        resultSet.getInt("uniqueNumberIdentifier"));
                cows.add(cow);
            }
            return cows;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Cow> findById(String earTag) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_STATEMENT);
            preparedStatement.setString(1, earTag);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Cow cow = new Cow(resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getDouble("weight"),
                        resultSet.getInt("age"),
                        resultSet.getString("healthStatus"),
                        Size.valueOf(resultSet.getString("size")),
                        resultSet.getString("subspecies"),
                        resultSet.getString("letterIdentifier"),
                        resultSet.getInt("uniqueNumberIdentifier"));
                return Optional.of(cow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Cow cow) {
        storage.put(cow.getEarTag(), cow);
    }

    @Override
    public void delete(Cow cow) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT);
            preparedStatement.setString(1, cow.getEarTag());
            preparedStatement.executeUpdate();
            storage.remove(cow.getEarTag());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
