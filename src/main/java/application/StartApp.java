package application;

public class StartApp {
    public void start() {
        ScannerWrapper scanner = new ScannerWrapper();
        InputCountMembers inputCountMembers = new InputCountMembers(scanner);
        int countMembers = inputCountMembers.countMembers();
        System.out.println("количество посетителей: " + countMembers);
        InputProducts inputProducts = new InputProducts(scanner);
        String prod = inputProducts.inputProd(countMembers);
        System.out.println("Добавленные товары: " + "\n" + prod);
    }
}
