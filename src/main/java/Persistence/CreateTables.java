package Persistence;
import java.sql.*;
public class CreateTables {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres","postgres","123456"
        )){

            String sizeType = "CREATE TYPE Size AS ENUM ('Small', 'Medium', 'Large');";
            String cropType = "CREATE TYPE Crop AS ENUM ('Wheat', 'Barley', 'Oats', 'Rye', 'Corn', 'Beans', 'Beets');";
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

            String createSequence = "CREATE SEQUENCE SEQ START 1;";
            String createSequence2 = "CREATE SEQUENCE SEQ2 START 1;";

            String createGrazingFieldTable ="CREATE TABLE GRAZINGFIELD(" +
                    "id INT PRIMARY KEY DEFAULT nextval('seq2')," +
                    "name VARCHAR(255)," +
                    "size INTEGER," +
                    "type INTEGER," +
                    "fertility DOUBLE PRECISION," +
                    "lastGrazingDate DATE);";

            String createCropFieldTable = "CREATE TABLE CROPFIELD(" +
                    "id INT PRIMARY KEY DEFAULT nextval('seq')," +
                    "name VARCHAR(255)," +
                    "size INTEGER," +
                    "type INTEGER," +
                    "irrigated BOOLEAN," +
                    "cropType crop);";
            String createAnimalGrazingFieldTalbe= "CREATE TABLE ANIMALGRAZINGFIELD(" +
                    "animalId VARCHAR(50) REFERENCES COW(earTag) ON DELETE CASCADE," +
                    "grazingFieldId INT REFERENCES GRAZINGFIELD(id) ON DELETE CASCADE," +
                    "PRIMARY KEY (animalId, grazingFieldId));";



            try(Statement statement = connection.createStatement()){
                statement.execute("DROP TYPE IF EXISTS size CASCADE;");
                statement.execute(sizeType);
                statement.execute("DROP TYPE IF EXISTS crop CASCADE;");
                statement.execute(cropType);
                statement.execute("DROP TABLE IF EXISTS COW CASCADE;");
                statement.execute(createCowTable);
                statement.execute("DROP TABLE IF EXISTS SHEEP CASCADE;");
                statement.execute(createSheepTable);
                statement.execute("DROP TABLE IF EXISTS CHICKEN CASCADE;");
                statement.execute(createChickenTable);
                statement.execute("DROP TABLE IF EXISTS BEEHIVE CASCADE;");
                statement.execute(createBeehiveTable);
                statement.execute("DROP SEQUENCE IF EXISTS SEQ CASCADE;");
                statement.execute(createSequence);
                statement.execute("DROP SEQUENCE IF EXISTS SEQ2 CASCADE;");
                statement.execute(createSequence2);
                statement.execute("DROP TABLE IF EXISTS GRAZINGFIELD CASCADE;");
                statement.execute(createGrazingFieldTable);
                statement.execute("DROP TABLE IF EXISTS CROPFIELD CASCADE;");
                statement.execute(createCropFieldTable);
                statement.execute("DROP TABLE IF EXISTS ANIMALGRAZINGFIELD CASCADE;");
                statement.execute(createAnimalGrazingFieldTalbe);

                System.out.println("Table created successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
