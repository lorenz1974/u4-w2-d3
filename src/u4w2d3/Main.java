package u4w2d3;

import java.time.LocalDate; // https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {

                Customer customer1 = new Customer(1, "Mario Rossi", 1);
                Customer customer2 = new Customer(2, "Anna Bianchi", 2);
                Customer customer3 = new Customer(3, "Luigi Verdi", 3);

                List<Customer> customers = Arrays.asList(customer1, customer2, customer3);

                List<Product> products = new ArrayList<>();

                products.addAll(Arrays.asList(
                                new Product(1, "Book 1", "Book", 12345678.99),
                                new Product(2, "Book 2", "Book", 150.0),
                                new Product(3, "Book 3", "Book", 90.0),
                                new Product(4, "Book 4", "Book", 105.0),
                                new Product(5, "Book 5", "Book", 30.0)));

                products.addAll(Arrays.asList(
                                new Product(6, "Baby Toy 1", "Baby", 8.0),
                                new Product(7, "Baby Toy 2", "Baby", 12.0),
                                new Product(8, "Baby Toy 3", "Baby", 18.0),
                                new Product(9, "Baby Toy 4", "Baby", 22.0),
                                new Product(10, "Baby Toy 5", "Baby", 28.0)));

                products.addAll(Arrays.asList(
                                new Product(11, "Boys Toy 1", "Boys", 14.0),
                                new Product(12, "Boys Toy 2", "Boys", 16.0),
                                new Product(13, "Boys Toy 3", "Boys", 21.0),
                                new Product(14, "Boys Toy 4", "Boys", 24.0),
                                new Product(15, "Boys Toy 5", "Boys", 27.0)));

                List<Order> orders = new ArrayList<>();

                orders.add(new Order(2, "Pending", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 10),
                                Arrays.asList(products.get(1), products.get(7)), customer2));

                orders.add(new Order(3, "Shipped", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20),
                                Arrays.asList(products.get(2), products.get(8)), customer3));

                orders.add(new Order(4, "Completed", LocalDate.of(2021, 4, 1), LocalDate.of(2021, 4, 5),
                                Arrays.asList(products.get(3), products.get(9)), customer1));

                orders.add(new Order(5, "Pending", LocalDate.of(2021, 5, 10), LocalDate.of(2021, 5, 15),
                                Arrays.asList(products.get(4), products.get(10)), customer2));

                orders.add(new Order(6, "Completed", LocalDate.of(2021, 6, 15), LocalDate.of(2021, 6, 20),
                                Arrays.asList(products.get(5), products.get(11)), customer3));

                orders.add(new Order(1, "Completed", LocalDate.of(2021, 1, 15),
                                Arrays.asList(products.get(0), products.get(6)), customer1));

                // ------------------------------------------------------------------------------------------------------------

                // Esecizio #1
                String category1 = "Book";
                double price = 100.0;
                printExerciseHeader("Prodotti con categoria " + category1 + " e prezzo maggiore di " + price + ":");
                // products.stream()
                // .filter(product -> product.getCategory().equals(category1)
                // && product.getPrice() > price)
                // .forEach(System.out::println);

                List<Product> filteredProducts1 = filterProductsByCategory(products, category1)
                                .stream()
                                .filter(product -> product.getPrice() > price)
                                .toList();

                filteredProducts1.forEach(System.out::println);
                _W("");

                // Esercizio #2
                String category2 = "Baby";
                printExerciseHeader("Prodotti con categoria " + category2 + ":");
                List<Product> filteredProducts2 = filterProductsByCategory(products, category2);
                filteredProducts2.forEach(System.out::println);
                _W("");

                // Esercizio #3
                String category3 = "Boys";
                double discount = 0.1;
                printExerciseHeader("Prodotti con categoria " + category3 + " scontati del " + discount * 100 + "%:");

                // Così cambio il prezzo del prodotto non restituisco un nuovo oggetto!!!
                // filterProductsByCategory(products, category3)
                // .forEach(product -> product.setPrice(priceDiscounted(product.getPrice(),
                // discount)));

                List<Product> discountedProducts = filterProductsByCategory(products, category3)
                                .stream()
                                .map(product -> new Product(
                                                product.getId(),
                                                product.getName(),
                                                product.getCategory(),
                                                priceDiscounted(product.getPrice(), discount)))
                                .toList();

                // Stampa i prodotti scontati
                discountedProducts.forEach(System.out::println);
                _W("");

                // Esercizio #4
                LocalDate startDate = LocalDate.of(2021, 2, 1);
                LocalDate endDate = LocalDate.of(2021, 4, 1);
                printExerciseHeader("Ordini filtrati (01/02/2021 - 01/04/2021):");

                // Provo scrittura sintetica
                List<Order> filteredOrders = filterOrdersByDate(orders, startDate, endDate)
                                .stream()
                                .filter(order -> order.getCustomer().getTier() == 2)
                                .toList();

                filteredOrders.forEach(System.out::println);

                // Se volessi stampare direttamente senza passare per un'altra lista
                // filterOrdersByDate(orders, startDate, endDate)
                // .stream()
                // .filter(order -> order.getCustomer().getTier() == 2)
                // forEach(System.out::println);

                _W("");
        }

        // Esercizio #2
        private static List<Product> filterProductsByCategory(List<Product> products, String category) {
                return products.stream()
                                .filter(product -> product.getCategory().equals(category))
                                .toList();
        }

        // Esercizio #4
        private static List<Order> filterOrdersByDate(List<Order> orders, LocalDate startDate, LocalDate endDate) {
                // https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
                // https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html#isAfter-java.time.chrono.ChronoLocalDate-
                // https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html#isBefore-java.time.chrono.ChronoLocalDate-
                return orders.stream()
                                .filter(order -> order.getOrderDate().isAfter(startDate)
                                                && order.getOrderDate().isBefore(endDate))
                                .toList();
        }

        private static double priceDiscounted(double price, double discount) {
                discount = discount <= 1 ? discount : discount / 100;
                return price * (1 - discount);
        }

        public static void _W(String text) {
                System.out.println(text != null ? text : "");
        }

        private static void printExerciseHeader(String text) {
                _W("-".repeat(50));
                _W(text);
                _W("-".repeat(50));
        }

}
