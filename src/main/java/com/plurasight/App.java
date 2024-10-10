package com.plurasight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f \n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory () {
                ArrayList<Product> inventory = new ArrayList<Product>();
                String input;

                try {
                    BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
                    while ((input = bufReader.readLine()) != null) {
                        String[] splitData = input.split(Pattern.quote("|"));

                        int productID = Integer.parseInt(splitData[0]);
                        String productName = splitData[1];
                        float productPrice = Float.parseFloat(splitData[2]);

                        inventory.add(new Product(productID, productName, productPrice));


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        Collections.sort(inventory);
        return inventory;
    }
}

