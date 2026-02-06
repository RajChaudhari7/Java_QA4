package view;

import controller.BookController;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Book;

public class BookView {

    public static void show(Stage stage) throws Exception {

        TableView<Book> table = new TableView<>();
        ObservableList<Book> data = FXCollections.observableArrayList(
                BookController.getBooks()
        );

        TableColumn<Book, Integer> idCol
                = new TableColumn<>("ID");
        idCol.setCellValueFactory(
                c -> new javafx.beans.property.SimpleIntegerProperty(
                        c.getValue().getId()).asObject());

        TableColumn<Book, String> titleCol
                = new TableColumn<>("Title");
        titleCol.setCellValueFactory(
                c -> new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getTitle()));

        TableColumn<Book, String> authorCol
                = new TableColumn<>("Author");
        authorCol.setCellValueFactory(
                c -> new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getAuthor()));

        table.getColumns().addAll(idCol, titleCol, authorCol);
        table.setItems(data);

        TextField title = new TextField();
        title.setPromptText("Title");

        TextField author = new TextField();
        author.setPromptText("Author");

        Button add = new Button("Add");
        Button update = new Button("Update");
        Button delete = new Button("Delete");

        add.setOnAction(e -> {
            try {
                BookController.addBook(title.getText(), author.getText());
                data.setAll(BookController.getBooks());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        update.setOnAction(e -> {
            Book b = table.getSelectionModel().getSelectedItem();
            if (b != null) {
                try {
                    BookController.updateBook(
                            b.getId(), title.getText(), author.getText());
                    data.setAll(BookController.getBooks());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        delete.setOnAction(e -> {
            Book b = table.getSelectionModel().getSelectedItem();
            if (b != null) {
                try {
                    BookController.deleteBook(b.getId());
                    data.setAll(BookController.getBooks());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        VBox root = new VBox(10, table, title, author,
                new HBox(10, add, update, delete));

        stage.setScene(new Scene(root, 600, 500));
        stage.setTitle("Library Management System");
        stage.show();
    }
}
