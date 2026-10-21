
package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LibraryDAO {

    Scanner sc = new Scanner(System.in);

    public void viewBooks() {
        String sql = "SELECT * FROM books";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- Available Books ---");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("book_id")
                    + " | Title: " + rs.getString("title")
                    + " | Author: " + rs.getString("author")
                    + " | Available: " + rs.getInt("available")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBook() {
        try {
            sc.nextLine();

            System.out.print("Enter book title: ");
            String title = sc.nextLine();

            System.out.print("Enter author name: ");
            String author = sc.nextLine();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            String sql = "INSERT INTO books "
                    + "(title, author, quantity, available) "
                    + "VALUES (?, ?, ?, ?)";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, title);
                ps.setString(2, author);
                ps.setInt(3, quantity);
                ps.setInt(4, quantity);

                ps.executeUpdate();
                System.out.println("Book added successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewMembers() {
        String sql = "SELECT * FROM members";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- Library Members ---");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("member_id")
                    + " | Name: " + rs.getString("name")
                    + " | Phone: " + rs.getString("phone")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMember() {
        try {
            sc.nextLine();

            System.out.print("Enter member name: ");
            String name = sc.nextLine();

            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();

            String sql = "INSERT INTO members (name, phone) VALUES (?, ?)";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, name);
                ps.setString(2, phone);

                ps.executeUpdate();
                System.out.println("Member added successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
