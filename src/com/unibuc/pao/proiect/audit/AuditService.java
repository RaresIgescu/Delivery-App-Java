package src.com.unibuc.pao.proiect.audit;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private static AuditService instance;
    private final String fileName = "audit.csv";

    private AuditService() {
    }

    public static AuditService getInstance() {
        if (instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public void logAction(String action) {
        try(FileWriter writer = new FileWriter(fileName, true)) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
            writer.append(action).append(",").append(time).append("\n");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisier: " + e.getMessage());
        }
    }
}
