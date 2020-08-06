package AssociativeArrayPackage_Exercice;

//Description
//Write a program, which keeps information about products and their prices.
//Each product has a name, a price and its quantity.
//If the product doesn't exist yet, add it with its starting quantity.
//If you receive a product, which already exists increase its quantity by the input quantity and if its price is different, replace the price as well.
//You will receive products' names, prices and quantities on new lines.
//Until you receive the command "buy", keep adding items.
//When you do receive the command "buy", print the items with their names and total price of all the products with that name.
//Input
//Until you receive "buy", the products come in the format: "{name} {price} {quantity}".
//The product data is always delimited by a single space.
//Output
//Print information about each product, following the format:
//"{productName} -> {totalPrice}"
//Format the total price to the second digit after the decimal point

//Example
//Input	                                Output
//Beer 2.20 100                         Beer -> 220.00
//IceTea 1.50 50                        IceTea -> 75.00
//Juice 3.30 80                         Juice -> 264.00
//Water 1.00 500                        Water -> 500.00
//buy


//Example
//Input	                                Output
//CaesarSalad 10.20 25                  CaesarSalad -> 255.00
//SuperEnergy 0.80 400                  SuperEnergy -> 320.00
//Beer 1.35 350                         Beer -> 472.50
//IceCream 1.50 25                      IceCream -> 37.50
//buy

import java.util.*;

public class Orders {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<Double>> products = new LinkedHashMap<>();
        String line = scanner.nextLine();

        while (!line.equals("buy")) {
            String[] tockens = line.split(" ");
            String Key = tockens[0];
            double price = Double.parseDouble(tockens[1]);
            double cantity = Double.parseDouble(tockens[2]);

            ArrayList<Double> details = new ArrayList<>();


            if (products.containsKey(Key)) {
                ArrayList<Double> check = new ArrayList<>();
                //If you receive a product, which already exists increase its cantity by the input cantity
                // and if its price is different, replace the price as well.
                check.add(products.get(Key).get(0));
                check.add(products.get(Key).get(1));
                check.set(1, check.get(1) + cantity);

                //double pricee=products.get(Key).get(0);
                //double quantityy = products.get(Key).get(1);
                if (!check.get(0).equals(price)) {
                    check.set(0, price);
                    products.put(Key, check);
                }
            } else {
                details.add(price);
                details.add(cantity);
                products.put(Key, details);
            }

            line = scanner.nextLine();
        }

        Map<String, Double> output = new LinkedHashMap<>();

        for (String extractKey : products.keySet()) {
            List<Double> extractEntry = new ArrayList<>();
            double extractPrice =products.get(extractKey).get(0);
            double extractQuantity =products.get(extractKey).get(1);
            double totalSum = extractPrice * extractQuantity;

            output.put(extractKey, totalSum);

        }

        for (Map.Entry<String, Double> entry : output.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }


    }
}
