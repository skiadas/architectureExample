package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split("\\+");
            if (parts.length != 2) {
                System.out.println("Cannot parse expression");
            } else {
                int a = Integer.parseInt(parts[0].trim());
                int b = Integer.parseInt(parts[1].trim());
                int result = a + b;
                System.out.println(result);
            }
        }
    }
}
