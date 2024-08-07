package com.library.system;

import com.library.system.common.ScannerProvider;
import com.library.system.handlers.InputHandler;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = ScannerProvider.getInstance().getScanner();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int key = sc.nextInt();
            if (key == 0) {
                break;
            }
            InputHandler.getHandler(key).handleInput();
        }
    }

    public static void displayMenu() {
        System.out.println("Enter the key to do the operation : ");
        System.out.println("1. Add library");
        System.out.println("2. Display libraries");
        System.out.println("3. Add Books");
        System.out.println("4. Display books");
        System.out.println("5. Add Patron");
        System.out.println("6. Display Patrons");
        System.out.println("7. Search books");
        System.out.println("8. Borrow book");
        System.out.println("9. Return book");
        System.out.println("10. Show books borrowed by patron");
        System.out.println("11. Display books borrowed from library");
        System.out.print("Choice : ");
    }
}
