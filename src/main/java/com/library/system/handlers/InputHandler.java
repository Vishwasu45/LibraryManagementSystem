package com.library.system.handlers;

import com.library.system.exception.LibraryManagementException;

public interface InputHandler {

    static InputHandler getHandler(int choice) {
        return switch (choice) {
            case 1 -> new LibraryAdditionHandler();
            case 2 -> new DisplayLibrariesHandler();
            case 3 -> new BookAdditionHandler();
            case 4 -> new DisplayBooksByLibraryHandler();
            case 5 -> new PatronAdditionHandler();
            case 6 -> new DisplayPatronsOfLibraryHandler();
            case 7 -> new SearchBookHandler();
            case 8 -> new BorrowBookHandler();
            case 9 -> new ReturnBookHandler();
            case 10 -> new DisplayBooksBorrowedByPatronHandler();
            case 11 -> new DisplayBooksBorrowedFromLibraryHandler();
            default -> throw new LibraryManagementException("Invalid choice");
        };
    }

    void handleInput();
}
