package application;

import java.util.Locale;
import java.util.Scanner;

public class ScannerWrapper {
    Scanner scanner;

    public ScannerWrapper() {
        this.scanner = new Scanner(System.in);
        this.scanner.useLocale(Locale.US);
    }
}
