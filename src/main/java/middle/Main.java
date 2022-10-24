package middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //todo interface Map
        Map<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);
        products.put("Пирожное", 60);//+
        //todo возможность расширить ассортимент
        int productLineSize = products.size();
        //todo можно вынести в отдельный метод
        /*System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }*/

        printProductLine(products);

        // todo перенести в цикл
        // System.out.println("Введите два слова: название товара и количество. Или end");

        //todo можно в статичную переменную
        //Scanner scanner = new Scanner(System.in);

        //todo размер массива объектов задаем в зависимости от продуктовой линейки
        //middle.Purchase purchase = new middle.Purchase(productLineSize);
        //todo Зачем хранить данные о всех покупках в классе покупка,
        // так у каждого объекта будет еще и свой, пустой неиспользуемый! массив
        // класс middle.Purchase будет использоваться для хранения состояния только 1 объекта покупки
        // для хранения и обработки данных о всех покупках создадим отдельный класс middle.Basket
        // в него переносится вся логика по обработке данных
        Basket basket = new Basket(productLineSize);

        //todo добавил проверки ввода
        while (true) {
            System.out.println("Введите два слова: название товара и количество" +
                    " через пробел или end - для выхода.");
            String line = scanner.nextLine();

            if ("end".equals(line)) break;

            String[] parts = line.split(" ");
            if (parts.length != 2) {
                printError("введено не 2 значения: " + line);
                continue;
            }

            String product = parts[0];
            if (!products.containsKey(product)) {
                printError("товара нет в ассортименте: " + parts[0]);
                continue;
            }

            try {
                int count = Integer.parseInt(parts[1]);

                //todo за обработку данных теперь отвечает класс middle.Basket
                //purchase.addPurchase(product, count);
                basket.addPurchase(product, count);
            } catch (NumberFormatException e) {
                printError("некорректное количество: " + parts[1]);
            }

        }
        //todo long на int, т.к. int count парсим и используем для хранения
        //todo за обработку данных теперь отвечает класс middle.Basket
        //int sum = purchase.sum(products);
        //todo если нам нужна сумма для каких-то еще вычислений,
        // например чек не должен превышать какой-то предел
        // оставляем метод

        //todo если сумма отдельно не нужна,
        // то вывод корзины 1 методом,
        // метод sum и переменная sum больше не нужны
        //int sum = basket.sum(products);
        //System.out.println("ИТОГО: " + sum);

        basket.printBasket(products);
    }

    private static void printProductLine(Map<String, Integer> products) {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey()
                    + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }

    private static void printError(String message) {
        System.out.println("ошибка ввода: " + message);
    }
}
