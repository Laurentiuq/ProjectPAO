package Persistence.Repos;

import Persistence.DBConnection;
import java.sql.Connection;
import java.sql.*;
import java.util.*;
import Model.AnimalGrazingField;
public class AnimalGrazingFieldRepository implements GenericRepository<AnimalGrazingField> {
    private static final String INSERT_STATEMENT = "INSERT INTO animalgrazingfield (animalId, grazingFieldId) VALUES (?, ?)";
    private static final String SELECT_ALL_STATEMENT = "SELECT * FROM animalgrazingfield";
    private static final String SELECT_BY_ID_STATEMENT = "SELECT * FROM animalgrazingfield WHERE id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM animalgrazingfield WHERE id = ?";
    private static final String UPDATE_STATEMENT = "UPDATE animalgrazingfield SET animalId = ?, grazingFieldId = ? WHERE id = ?";
    private static final String FIND_ANIMAL_BY_GRAZING_FIELD_ID = "SELECT * FROM animalgrazingfield WHERE grazingFieldId = ?";
    private static final String FIND_GRAZING_FIELD_BY_ANIMAL_ID = "SELECT * FROM animalgrazingfield WHERE animalId = ?";
    private static volatile AnimalGrazingFieldRepository instance;
    private final Connection connection;

    private AnimalGrazingFieldRepository() throws Exception {
        connection = DBConnection.getConnection();
    }

    public static AnimalGrazingFieldRepository getInstance() throws Exception {
        if (instance == null) {
            synchronized (AnimalGrazingFieldRepository.class) {
                if (instance == null) {
                    instance = new AnimalGrazingFieldRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public AnimalGrazingField save(AnimalGrazingField animalGrazingField) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
        preparedStatement.setString(1, animalGrazingField.getAnimalId());
        preparedStatement.setInt(2, animalGrazingField.getGrazingFieldId());
        preparedStatement.executeUpdate();
        return animalGrazingField;
    }

    @Override
    public void update(AnimalGrazingField animalGrazingField) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT);
            preparedStatement.setString(1, animalGrazingField.getAnimalId());
            preparedStatement.setInt(2, animalGrazingField.getGrazingFieldId());
            preparedStatement.setString(3, animalGrazingField.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<AnimalGrazingField> findAll() {
        List<AnimalGrazingField> animalGrazingFields = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_STATEMENT);
            while (resultSet.next()) {
                AnimalGrazingField animalGrazingField = new AnimalGrazingField();
                animalGrazingField.setId(resultSet.getString("id"));
                animalGrazingField.setAnimalId(resultSet.getString("animalId"));
                animalGrazingField.setGrazingFieldId(resultSet.getInt("grazingFieldId"));
                animalGrazingFields.add(animalGrazingField);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return animalGrazingFields;
    }

    @Override
    public Optional<AnimalGrazingField> findById(String id) {
        AnimalGrazingField animalGrazingField = new AnimalGrazingField();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_STATEMENT);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                animalGrazingField.setId(resultSet.getString("id"));
                animalGrazingField.setAnimalId(resultSet.getString("animalId"));
                animalGrazingField.setGrazingFieldId(resultSet.getInt("grazingFieldId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.of(animalGrazingField);
    }

    @Override
    public void delete(AnimalGrazingField animalGrazingField) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT);
            preparedStatement.setString(1, animalGrazingField.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //find animal by grazing field id
    public Optional<AnimalGrazingField> findAnimalByGrazingFieldId(int id) {
        AnimalGrazingField animalGrazingField = new AnimalGrazingField();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ANIMAL_BY_GRAZING_FIELD_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                animalGrazingField.setId(resultSet.getString("id"));
                animalGrazingField.setAnimalId(resultSet.getString("animalId"));
                animalGrazingField.setGrazingFieldId(resultSet.getInt("grazingFieldId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.of(animalGrazingField);
    }

    //find grazing field by animal id

    public Optional<AnimalGrazingField> findGrazingFieldByAnimalId(String id) {
        AnimalGrazingField animalGrazingField = new AnimalGrazingField();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_GRAZING_FIELD_BY_ANIMAL_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                animalGrazingField.setId(resultSet.getString("id"));
                animalGrazingField.setAnimalId(resultSet.getString("animalId"));
                animalGrazingField.setGrazingFieldId(resultSet.getInt("grazingFieldId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.of(animalGrazingField);
    }



}
