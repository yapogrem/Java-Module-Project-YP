package application;


public class InputCountMembers {
    private ScannerWrapper scanner;
    public InputCountMembers(ScannerWrapper scanner){
        this.scanner=scanner;
    }
    public int countMembers() {
        int countMembers;
        while (true) {
            System.out.println("Введите количество посетителей? (Число больше 1)");
            if (scanner.scanner.hasNextInt()) {
                countMembers = scanner.scanner.nextInt();
                if (countMembers > 1) {
                    break;
                }
            }else {
                scanner.scanner.next();
            }
            System.out.println("Введены некорректные данные, необходимо число больше 1");
        }
        return countMembers;
    }
}
