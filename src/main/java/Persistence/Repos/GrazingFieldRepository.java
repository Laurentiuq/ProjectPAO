package Persistence.Repos;

import Model.GrazingField;
import Persistence.DBConnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GrazingFieldRepository implements GenericRepository<GrazingField>{
    private static final String INSERT_STATEMENT = "INSERT INTO grazingfield (name, size, type, fertility, lastGrazingDate) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STATEMENT = "SELECT * FROM grazingfield";
    private static final String SELECT_BY_ID_STATEMENT = "SELECT * FROM grazingfield WHERE id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM grazingfield WHERE id = ?";
    private static final String UPDATE_STATEMENT = "UPDATE grazingfield SET name = ?, size = ?, type = ?, fertility = ?, lastGrazingDate = ? WHERE id = ?";

    private final Connection connection;
    private static volatile GrazingFieldRepository instance;

    private GrazingFieldRepository() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public static GrazingFieldRepository getInstance() throws SQLException {
        if (instance == null) {
            synchronized (GrazingFieldRepository.class) {
                if (instance == null) {
                    instance = new GrazingFieldRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public GrazingField save(GrazingField grazingField) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
//        preparedStatement.setInt(1, grazingField.getId());
        preparedStatement.setString(1, grazingField.getName());
        preparedStatement.setDouble(2, grazingField.getSize());
        preparedStatement.setInt(3, grazingField.getType());
        preparedStatement.setDouble(4, grazingField.getFertility());
        preparedStatement.setDate(5, new java.sql.Date(grazingField.getLastGrazingDate().getTime()));
        preparedStatement.executeUpdate();
        return grazingField;
    }

    @Override
    public void update(GrazingField grazingField)  {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT);
            preparedStatement.setString(1, grazingField.getName());
            preparedStatement.setDouble(2, grazingField.getSize());
            preparedStatement.setInt(3, grazingField.getType());
            preparedStatement.setDouble(4, grazingField.getFertility());
            preparedStatement.setDate(5, new java.sql.Date(grazingField.getLastGrazingDate().getTime()));
            preparedStatement.setInt(6, grazingField.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(GrazingField grazingField) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT);
            preparedStatement.setInt(1, grazingField.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Optional<GrazingField> findById(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_STATEMENT);
            int idInt = Integer.parseInt(id);
            preparedStatement.setInt(1, idInt);
            ResultSet resultSet= preparedStatement.executeQuery();
            if(resultSet.next()) {
                return Optional.of(new GrazingField(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("size"),
                        resultSet.getInt("type"),
                        resultSet.getDouble("fertility"),
                        resultSet.getDate("lastGrazingDate")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<GrazingField> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STATEMENT);
            ResultSet resultSet= preparedStatement.executeQuery();
            List<GrazingField> grazingFields = new ArrayList<>();
            while(resultSet.next()) {
                GrazingField grazingField = new GrazingField(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("size"),
                        resultSet.getInt("type"),
                        resultSet.getDouble("fertility"),
                        resultSet.getDate("lastGrazingDate")
                );
                grazingFields.add(grazingField);

            }
            return grazingFields;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }




}
