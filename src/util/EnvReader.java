package util;

import java.io.*;
import java.util.*;

public class EnvReader {
    private static final Properties props = new Properties();

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(".env"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    props.setProperty(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Failed to load .env file: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
