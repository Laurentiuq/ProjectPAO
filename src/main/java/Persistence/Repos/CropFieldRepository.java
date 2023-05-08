package Persistence.Repos;
import Model.CropField;
import Model.Crop;
//import Model.CropField.Crop;
import Persistence.DBConnection;
import java.sql.*;
import java.util.*;

public class CropFieldRepository implements GenericRepository<CropField>{
    private final Map<String, CropField> storage = new HashMap<>();
    private static final String INSERT_STATEMENT = "INSERT INTO cropfield (name, size, type, irrigated, cropType) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STATEMENT = "SELECT * FROM cropfield";
    private static final String SELECT_BY_ID_STATEMENT = "SELECT * FROM cropfield WHERE id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM cropfield WHERE id = ?";
    private static final String UPDATE_STATEMENT = "UPDATE cropfield SET name = ?, size = ?, type = ?, irrigated = ?, cropType = ? WHERE id = ?";
    private final Connection connection;
    private static volatile CropFieldRepository instance;

    private CropFieldRepository() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public static CropFieldRepository getInstance() throws SQLException {
        if (instance == null) {
            synchronized (CropFieldRepository.class) {
                if (instance == null) {
                    instance = new CropFieldRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public CropField save(CropField cropField) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
//        preparedStatement.setInt(1, cropField.getId());
        preparedStatement.setString(1, cropField.getName());
        preparedStatement.setDouble(2, cropField.getSize());
        preparedStatement.setInt(3, cropField.getType());
        preparedStatement.setBoolean(4, cropField.isIrrigated());
        preparedStatement.setObject(5, cropField.getCropType(), java.sql.Types.OTHER);
        preparedStatement.executeUpdate();
        return cropField;
    }

    @Override
    public void update(CropField cropField)  {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT);
            preparedStatement.setString(1, cropField.getName());
            preparedStatement.setDouble(2, cropField.getSize());
            preparedStatement.setInt(3, cropField.getType());
            preparedStatement.setBoolean(4, cropField.isIrrigated());
            preparedStatement.setObject(5, cropField.getCropType(), java.sql.Types.OTHER);
            preparedStatement.setInt(6, cropField.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<CropField> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STATEMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CropField> cropFields = new ArrayList<>();
            while (resultSet.next()) {
                CropField cropField = new CropField();
                cropField.setId(resultSet.getInt("id"));
                cropField.setName(resultSet.getString("name"));
                cropField.setSize(resultSet.getInt("size"));
                cropField.setType(resultSet.getInt("type"));
                cropField.setIrrigated(resultSet.getBoolean("irrigated"));
                cropField.setCropType(Crop.valueOf(resultSet.getString("cropType")));
                cropFields.add(cropField);
            }
            return cropFields;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    @Override
    public Optional<CropField> findById(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_STATEMENT);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CropField cropField = new CropField();
                cropField.setId(resultSet.getInt("id"));
                cropField.setName(resultSet.getString("name"));
                cropField.setSize(resultSet.getInt("size"));
                cropField.setType(resultSet.getInt("type"));
                cropField.setIrrigated(resultSet.getBoolean("irrigated"));
                cropField.setCropType(Crop.valueOf(resultSet.getString("cropType")));
                return Optional.of(cropField);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(CropField cropField) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT);
            preparedStatement.setInt(1, cropField.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
