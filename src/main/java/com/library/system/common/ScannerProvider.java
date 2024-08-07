package com.library.system.common;

import java.util.Scanner;

public class ScannerProvider {

    private static final ScannerProvider INSTANCE = new ScannerProvider();

    private final Scanner scanner;

    private ScannerProvider() {
        scanner = new Scanner(System.in);
    }

    public static ScannerProvider getInstance() {
        return INSTANCE;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
