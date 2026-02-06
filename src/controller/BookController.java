package controller;

import model.Book;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookController {

    // 🔥 Reuse smallest missing ID
    private static int getNextId(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT book_id FROM books ORDER BY book_id"
        );

        int expected = 1;
        while (rs.next()) {
            if (rs.getInt(1) != expected) {
                return expected;
            }
            expected++;
        }
        return expected;
    }

    public static void addBook(String title, String author) throws Exception {
        Connection con = DBUtil.getConnection();
        int id = getNextId(con);

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books VALUES (?, ?, ?)"
        );
        ps.setInt(1, id);
        ps.setString(2, title);
        ps.setString(3, author);
        ps.executeUpdate();
        con.close();
    }

    public static List<Book> getBooks() throws Exception {
        List<Book> list = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM books");

        while (rs.next()) {
            list.add(new Book(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
            ));
        }
        con.close();
        return list;
    }

    public static void updateBook(int id, String title, String author)
            throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "UPDATE books SET title=?, author=? WHERE book_id=?"
        );
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setInt(3, id);
        ps.executeUpdate();
        con.close();
    }

    public static void deleteBook(int id) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM books WHERE book_id=?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}
