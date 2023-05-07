package Persistence.Repos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

import Model.Beehive;
import Persistence.DBConnection;
public class BeehiveRepository implements GenericRepository<Beehive>{
    private final Map<String, Beehive> storage = new HashMap<>();
    private static final String INSERT_STATEMENT = "INSERT INTO beehive (id, nrSupers, queenExcluder, lastExtractionDate, lastExtractionQuantity) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STATEMENT = "SELECT * FROM beehive";
    private static final String SELECT_BY_ID_STATEMENT = "SELECT * FROM beehive WHERE id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM beehive WHERE id = ?";
    private final Connection connection;
    private static volatile BeehiveRepository instance;

    private BeehiveRepository() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public static BeehiveRepository getInstance() throws SQLException {
        if (instance == null) {
            synchronized (BeehiveRepository.class) {
                if (instance == null) {
                    instance = new BeehiveRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public Beehive save(Beehive beehive) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
        preparedStatement.setString(1, beehive.getIdentifier());
        preparedStatement.setInt(2, beehive.getNrSupers());
        preparedStatement.setBoolean(3, beehive.isQueenExcluder());
        preparedStatement.setDate(4, (Date) beehive.getLastExtractionDate());
        preparedStatement.setDouble(5, beehive.getLastExtractionQuantity());
        preparedStatement.executeUpdate();
        return beehive;
    }
    @Override
    public List<Beehive> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STATEMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Beehive> beehives = new ArrayList<>();
            while (resultSet.next()) {
                Beehive beehive = new Beehive(
                        resultSet.getString("id"),
                        resultSet.getInt("nrSupers"),
                        resultSet.getBoolean("queenExcluder"),
                        resultSet.getDate("lastExtractionDate"),
                        resultSet.getDouble("lastExtractionQuantity")
                );
                beehives.add(beehive);
            }
            return beehives;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Beehive> findById(String identifier) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_STATEMENT);
            preparedStatement.setString(1, identifier);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Beehive beehive = new Beehive(
                        resultSet.getString("id"),
                        resultSet.getInt("nrSupers"),
                        resultSet.getBoolean("queenExcluder"),
                        resultSet.getDate("lastExtractionDate"),
                        resultSet.getDouble("lastExtractionQuantity")
                );
                return Optional.of(beehive);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Beehive beehive) {
        storage.put(beehive.getIdentifier(), beehive);
    }

    @Override
    public void delete(Beehive entity) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT);
            preparedStatement.setString(1, entity.getIdentifier());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
