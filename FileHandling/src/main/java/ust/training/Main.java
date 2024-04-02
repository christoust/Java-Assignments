package ust.training;

import ust.training.model.Person;
import ust.training.util.FileUtil;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Person person = null;
        int option;
        do {
            System.out.println("1.Read from file\n2.Edit existing value\n3.Add new value\n0.Exit");
            System.out.println("Enter the option");
            option = scanner.nextInt();
            try {
                switch (option) {
                    case 1: {
                        person = FileUtil.readJsonFile();
                        System.out.println("Read from json file " + person);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the value you want to edit");
                        String choice = scanner.next();
                        switch (choice){
                            case "age":{
                                System.out.println("Enter the new age");
                                int newAge = scanner.nextInt();
                                person.setAge(newAge);
                                break;
                            }
                            case "role": {
                                System.out.println("Enter the new role");
                                String newRole = scanner.next();
                                person.setRole(newRole);
                                break;
                            }

                        }
                        FileUtil.writeJsonFile(person);
                        System.out.println("Successfully wrote to JSON file");
                        break;
                    }
                    case 3: {
                        person.setRole("developer");
                        person.setLocation("Trivandrum");
                        FileUtil.writeJsonFile(person);
                        break;
                    }
                    default: {
                        System.out.println("Exitting the program");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (option != 0);

    }
}