package Services;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class logService {

    public static volatile logService instance = null;
    private logService() {
    }

    public static logService getInstance() {
        if (instance == null) {
            synchronized (logService.class) {
                if (instance == null) {
                    instance = new logService();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);
        String logMessage = timestamp + " " + message;

        try {
            String logPath = "src/main/java/Persistence/logs.csv";
            FileWriter myWriter = new FileWriter(logPath, true);
            // write to file on a new line
            myWriter.write("\n");
            myWriter.append(logMessage);
            myWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}
