package middle;

public class Purchase {

    private final String title;
    private int count;

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    /*public middle.Purchase(int size) {
        this.purchases = new middle.Purchase[size];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new middle.Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public int sum(Map<String, Integer> prices) {
        int sum = 0;//todo int count парсим и используем для хранения
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            //todo можно обойтись без создания новых объектов,
            */
            /*middle.Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);*/
    /*

            if (purchases[i] == null) continue;
            //todo промежуточная переменная для сокращения вычислений суммы товара
            int productSum = purchases[i].count * prices.get(purchases[i].title);
            System.out.println("\t" + purchases[i].title + " " + purchases[i].count + " шт. в сумме " + productSum + " руб.");
            sum += productSum;

        }
        return sum;
    }*/

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count += count;
    }

    @Override
    public String toString() {
        return String.format("Наименование: %s. Количество: %s", title, count);
    }
}
