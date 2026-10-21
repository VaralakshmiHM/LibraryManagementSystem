
package library;

import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryDAO dao = new LibraryDAO();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. View Members");
            System.out.println("4. Add Member");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dao.viewBooks();
                    break;

                case 2:
                    dao.addBook();
                    break;

                case 3:
                    dao.viewMembers();
                    break;

                case 4:
                    dao.addMember();
                    break;

                case 5:
                    System.out.println("Thank you for using the Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
