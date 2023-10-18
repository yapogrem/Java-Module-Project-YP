package application;

import java.util.Locale;
import java.util.Objects;

public class InputProducts {
    private ScannerWrapper scanner;

    public InputProducts(ScannerWrapper scanner) {
        this.scanner = scanner;
    }

    public String inputProd(int countMembers) {
        String products = "";
        double totalCost = 0;
        String endInput = "Завершить";
        String currentInput;
        while (true) {
            System.out.println("Введите название товара или Завершить для завершения ввода");
            currentInput = scanner.scanner.next();
            if (Objects.equals(currentInput, endInput)) {
                break;
            } else {
                products = products + currentInput;
                while (true) {
                    System.out.println("Введите стоимость товара в формате рубли.копейки, например 11.22");
                    if (scanner.scanner.hasNextDouble()) {
                        String cost = scanner.scanner.next();
                        double costDouble = Double.parseDouble(cost);
                        String[] splitter = cost.split("\\.");
                        if (splitter[1].length() == 2 && costDouble > 0) {
                            totalCost = totalCost + costDouble;
                            products = products + " " + cost + "\n";
                            System.out.println("Товар успешно добавлен");
                            break;
                        }
                    } else {
                        scanner.scanner.next();
                    }
                    System.out.println("Введены некорректные данные");
                }

            }
        }
        String totalCostDouble = String.format(Locale.US, "%.2f", totalCost);
        products = products + "Итого: " + totalCostDouble + "\n";
        double membersCost = totalCost / countMembers;
        String membersCostDouble = String.format(Locale.US, "%.2f", membersCost);
        String[] splitterRub = membersCostDouble.split("\\.");
        String membersCostRub = splitterRub[0];
        String rub = VarRubCop(membersCostRub, "рубль", "рубля", "рублей");
        String membersCostCop = splitterRub[1];
        String cop = VarRubCop(membersCostCop, "копейка", "копейки", "копеек");
        products = products + "Cумма, которую должен заплатить каждый человек: " + membersCostRub + " " + rub + " " + membersCostCop + " " + cop + ".";
        return products;
    }

    public String VarRubCop(String checksum, String var1, String var2, String var3) {
        if (checksum.length() >= 2 && checksum.charAt(checksum.length() - 2) == '1') {
            return var3;
        }
        return switch (checksum.charAt(checksum.length() - 1)) {
            case '1' -> var1;
            case '2', '3', '4' -> var2;
            default -> var3;
        };

    }
}
