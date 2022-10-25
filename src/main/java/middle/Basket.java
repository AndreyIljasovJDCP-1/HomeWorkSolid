package middle;

import java.util.Map;

public class Basket {
    private final Purchase[] purchases;

    public Basket(int size) {
        this.purchases = new Purchase[size];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].getTitle().equals(title)) {
                purchases[i].setCount(count);
                return;
            }
        }
    }

    public int sum(Map<String, Integer> prices) {
        int sum = 0;
        for (Purchase purchase : purchases) {
            if (purchase == null) break;
            sum += purchase.getCount() * prices.get(purchase.getTitle());
        }
        return sum;
    }

    public void printBasket(Map<String, Integer> prices) {
        int sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) break;
            int productSum = purchase.getCount() * prices.get(purchase.getTitle());
            System.out.println("\t" + purchase.getTitle() + " " + purchase.getCount() + " шт. в сумме " + productSum + " руб.");
            sum += productSum;
        }
        System.out.println("ИТОГО: " + sum);
    }

}
