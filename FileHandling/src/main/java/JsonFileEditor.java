import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JsonFileEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to the input JSON file:");
        String inputFilePath = scanner.nextLine();

        System.out.println("Enter the path to the output JSON file:");
        String outputFilePath = scanner.nextLine();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(inputFilePath));

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Edit values of two keys");
                System.out.println("2. Add two additional keys and their values");
                System.out.println("3. Save and exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        editValues(rootNode, scanner);
                        break;
                    case 2:
                        addKeys(rootNode, scanner);
                        break;
                    case 3:
                        saveJson(objectMapper, rootNode, outputFilePath);
                        System.out.println("JSON file has been edited and saved successfully.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while editing the JSON file: " + e.getMessage());
        }
    }

    private static void editValues(JsonNode rootNode, Scanner scanner) {
        System.out.println("Enter the key to edit:");
        String key = scanner.nextLine();

        if (rootNode.has(key)) {
            System.out.println("Enter the new value:");
            String value = scanner.nextLine();
            ((ObjectNode) rootNode).put(key, value);
        } else {
            System.out.println("Key not found.");
        }
    }

    private static void addKeys(JsonNode rootNode, Scanner scanner) {
        System.out.println("Enter the first new key:");
        String key1 = scanner.nextLine();
        System.out.println("Enter the value for " + key1 + ":");
        String value1 = scanner.nextLine();
        ((ObjectNode) rootNode).put(key1, value1);

        System.out.println("Enter the second new key:");
        String key2 = scanner.nextLine();
        System.out.println("Enter the value for " + key2 + ":");
        String value2 = scanner.nextLine();
        ((ObjectNode) rootNode).put(key2, value2);
    }

    private static void saveJson(ObjectMapper objectMapper, JsonNode rootNode, String outputFilePath) throws IOException {
        objectMapper.writeValue(new File(outputFilePath), rootNode);
    }


}
