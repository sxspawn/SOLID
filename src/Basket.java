import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Purchase> purchases;

    public Basket() {
        this.purchases = new ArrayList<>();
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
    }

    public void calculateBasket(List<Product> products) {
        int[] amount = new int[products.size()];
        for (Purchase purchase : purchases) {
            amount[purchase.getProductId()] += purchase.getCount();
        }

        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < amount.length; i++) {
            if (amount[i] == 0) {
                continue;
            }

            Product product = products.get(i);
            int price = amount[i] * product.getPrice();
            System.out.printf("\t%s, %s шт. в сумме %s руб.%n", product.getTitle(), amount[i], price);
            sum += price;
        }
        System.out.println("ИТОГО: " + sum);
    }
}
