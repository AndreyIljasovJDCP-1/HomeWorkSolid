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
        //todo long на int, т.к. int count парсим и используем для хранения
        int sum = 0;

        for (Purchase purchase : purchases) {
            //todo можно обойтись без создания новых объектов
            //todo объекты добавляются в массив по порядку 1-й null,
            // значит больше объектов нет можно выходить, поэтому break
            //if (purchase == null) continue;
            if (purchase == null) break;
            sum += purchase.getCount() * prices.get(purchase.getTitle());
        }
        return sum;
    }

    public void printBasket(Map<String, Integer> prices) {
        //todo long на int, т.к.  и используем для хранения
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            //todo можно обойтись без создания новых объектов
            //todo объекты добавляются в массив по порядку и 1-й null,
            // значит больше объектов нет можно выходить, поэтому break
            /*Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);*/
            if (purchases[i] == null) break;
            //todo промежуточная переменная для сокращения вычислений суммы товара 1 раз вместо 2-х
            /*System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);*/
            int productSum = purchases[i].getCount() * prices.get(purchases[i].getTitle());
            System.out.println("\t" + purchases[i].getTitle() + " " + purchases[i].getCount() + " шт. в сумме " + productSum + " руб.");
            sum += productSum;
        }
        System.out.println("ИТОГО: " + sum);
    }

}
