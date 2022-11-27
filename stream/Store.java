package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Store {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();

        list.add(new Product(1, "Notebook", 2500.00));
        list.add(new Product(2, "Mouse", 30.00));
        list.add(new Product(3, "Keyboard", 80.00));
        list.add(new Product(4, "Screen", 450.00));
        list.add(new Product(5, "Printer", 600.00));
        list.add(new Product(6, "Mouse Pad", 10.00));

        list.stream().forEach((p -> {
            System.out.println(p);
        }));

        System.out.println("\nProducts in alphabetical order: ");
                                    //is the same as p -> p.getName
        list.stream().sorted(Comparator.comparing(Product::getName)).forEach(product -> System.out.println(product));

        System.out.println("\nProducts in price order: ");
        list.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(product -> System.out.println(product));

        System.out.println("\nThe most expensive product:");
        Product mostExpensive;
        mostExpensive = list.stream().max(Comparator.comparing(p -> p.getPrice())).orElse(null);
        if(mostExpensive != null){
            System.out.println("The most expensive product is: " + mostExpensive);
        }


        System.out.println("\nThe cheapest product:");
        Product cheapest;
        cheapest = list.stream().min(Comparator.comparing(p -> p.getPrice())).orElse(null);
        if(cheapest != null){
            System.out.println("The cheapest product is: " + cheapest);
        }

    }
}
