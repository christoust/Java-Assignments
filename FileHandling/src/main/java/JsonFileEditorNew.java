import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class JsonFileEditorNew {

    public static void main(String[] args) {
        editJsonFile("src/main/resources/static/data.json", "src/main/resources/static/output.json");
    }

    public static void editJsonFile(String inputFilePath, String outputFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(inputFilePath));


            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the empId to edit: ");
            String empIdToEdit = scanner.nextLine();

            if (rootNode.isArray()) {
                ArrayNode arrayNode = (ArrayNode) rootNode;
                Iterator<JsonNode> iterator = arrayNode.elements();

                while (iterator.hasNext()) {
                    JsonNode node = iterator.next();
                    if (node.has("empId") && node.get("empId").asText().equals(empIdToEdit)) {
                        System.out.println("Editing employee with empId: " + empIdToEdit);
                        System.out.println("Current values:");
                        System.out.println("Name: " + node.get("name").asText());
                        System.out.println("Age: " + node.get("age").asText());
                        System.out.println("Email: " + node.get("email").asText());
                        System.out.println("Role: "+ node.get("role").asText());
                        System.out.println("Location: "+ node.get("location").asText());
                        while (true) {
                            System.out.println("\nMenu:");
                            System.out.println("1. Edit values of key");
                            System.out.println("2. Add two additional keys and their values");
                            System.out.println("3. Save and exit");

                            int choice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            switch (choice) {
                                case 1:
                                    editValues(node, scanner);
                                    break;
                                case 2:
                                    addKeys(node, scanner);
                                    break;
                                case 3:
                                    saveJson(objectMapper, rootNode, outputFilePath);
                                    System.out.println("JSON file has been edited and saved successfully.");
                                    return;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        }


                    }
                }

                System.out.println("All changes saved to output.json");
            } else {
                System.out.println("Input file does not contain a JSON array.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while editing the JSON file: " + e.getMessage());
        }

    }

    private static void editValues(JsonNode node, Scanner scanner) {
        System.out.println("Enter the key to edit:");
        String key = scanner.nextLine();

        if (node.has(key)) {
            System.out.println("Enter the new value:");
            String value = scanner.nextLine();
            ((ObjectNode) node).put(key, value);
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
