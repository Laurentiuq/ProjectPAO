package Persistence;
import java.sql.*;
public class CreateTables {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres","postgres","123456"
        )){

            String sizeType = "CREATE TYPE Size AS ENUM ('Small', 'Medium', 'Large');";

            String createCowTable = "CREATE TABLE COW("+
                    "earTag VARCHAR(50) PRIMARY KEY,"+
                    "name VARCHAR(255) ,"+
                    "species VARCHAR(255) ,"+
                    "weight DOUBLE PRECISION ,"+
                    "age INTEGER ,"+
                    "healthStatus VARCHAR(255) ,"+
                    "size size ,"+
                    "subspecies VARCHAR(255) ,"+
                    "letterIdentifier VARCHAR(255),"+
                    " uniqueNumberIdentifier INTEGER);";

            String createSheepTable = "CREATE TABLE SHEEP(" +
                    "earTag VARCHAR(50) PRIMARY KEY," +
                    "name VARCHAR(255) ," +
                    "species VARCHAR(255) ," +
                    "weight DOUBLE PRECISION ," +
                    "age INTEGER ," +
                    "healthStatus VARCHAR(255) ," +
                    "woolBreed VARCHAR(255) ," +
                    "letterIdentifier VARCHAR(255)," +
                    "uniqueNumberIdentifier INTEGER," +
                    "lastShearing DATE);";

            String createChickenTable = "CREATE TABLE CHICKEN(" +
                    "ringCode INTEGER, " +
                    "name VARCHAR(255) ," +
                    "species VARCHAR(255) ," +
                    "weight DOUBLE PRECISION ," +
                    "age INTEGER ," +
                    "healthStatus VARCHAR(255) ," +
                    "eggProducer BOOLEAN);";

            String createBeehiveTable = "CREATE TABLE BEEHIVE(" +
                    "id VARCHAR(50) PRIMARY KEY," +
                    "nrSupers INTEGER," +
                    "queenExcluder BOOLEAN," +
                    "lastExtractionDate DATE," +
                    "lastExtractionQuantity DOUBLE PRECISION);";



            try(Statement statement = connection.createStatement()){
                statement.execute("DROP TYPE IF EXISTS size CASCADE;");
                statement.execute(sizeType);
                statement.execute("DROP TABLE IF EXISTS COW CASCADE;");
                statement.execute(createCowTable);
                statement.execute("DROP TABLE IF EXISTS SHEEP CASCADE;");
                statement.execute(createSheepTable);
                statement.execute("DROP TABLE IF EXISTS CHICKEN CASCADE;");
                statement.execute(createChickenTable);
                statement.execute("DROP TABLE IF EXISTS BEEHIVE CASCADE;");
                statement.execute(createBeehiveTable);
                System.out.println("Table created successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
