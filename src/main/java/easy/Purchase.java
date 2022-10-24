package easy;

import java.util.Map;

public class Purchase {
    private  String title;
    private int count;
    protected Purchase[] purchases;

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public Purchase(int size) {
        this.purchases = new Purchase[size];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public int sum(Map<String, Integer> prices) {
        //todo long на int, т.к. int count парсим и используем для хранения
        int sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            //todo можно обойтись без создания новых объектов, есть доступ напрямую
           /* Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);*/

            if (purchases[i] == null) continue;
            //todo промежуточная переменная для сокращения вычислений суммы товара
            int productSum = purchases[i].count * prices.get(purchases[i].title);
            System.out.println("\t" + purchases[i].title + " " + purchases[i].count + " шт. в сумме " + productSum + " руб.");
            sum += productSum;
        }
        return sum;
    }
}
