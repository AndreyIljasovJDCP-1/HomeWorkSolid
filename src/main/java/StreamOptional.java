import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StreamOptional {

    public static void main(String[] args) {
        Map<String, Integer> basketMap = new TreeMap<>();
        Map<String, Integer> products = new HashMap<>();

        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);
        products.put("Пирожное", 60);

        printProductLine(products);

        while (true) {
            System.out.println("Введите два слова: название товара и количество" +
                    " через пробел или end - для выхода.");
            String line = Main.scanner.nextLine();

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
                basketMap.merge(product, count, Integer::sum);
            } catch (NumberFormatException e) {
                printError("некорректное количество: " + parts[1]);
            }
        }

        System.out.println("КОРЗИНА: ");
        basketMap.forEach(
                (key, value) -> System.out.println(key + " "
                + value + " шт. в сумме "
                + value * products.get(key) + " руб.")
        );

        System.out.println("ИТОГО: "
                + basketMap.entrySet().stream()
                .map(kv -> kv.getValue() * products.get(kv.getKey()))
                .reduce(0, Integer::sum)
        );

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
