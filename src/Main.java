import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Хлеб", 56));
        products.add(new Product("Масло", 153));
        products.add(new Product("Колбаса", 211));
        products.add(new Product("Пирожок", 45));

        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        int i = 0;
        for (Product product : products) {
            System.out.printf("%s. %s за %s руб./шт.%n", ++i, product.getTitle(), product.getPrice());
        }

        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket();
        while (true) {
            System.out.println("Выберите номер товара и его количество через пробел.\n" + "Для завершения программы и подсчета корзины введите: \"0\" и нажмите Enter.");
            String input = scanner.nextLine();
            if ("0".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }

            try {
                String[] parts = input.split(" ", 2);
                int productId = Integer.parseInt(parts[0]) - 1;
                int count = Integer.parseInt(parts[1]);

                if (productId >= products.size()) {
                    throw new IllegalArgumentException("Нет такого продукта");
                }
                if (count <= 0) {
                    throw new IllegalArgumentException("Количество должно быть больше 0");
                }

                basket.addPurchase(new Purchase(productId, count));
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Неправильный формат ввода");
            }
        }
        scanner.close();

        basket.calculateBasket(products);
    }
}