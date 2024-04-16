package com.example.coverviewer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;


import java.net.URL;

public class CoverViewerController {
    // instance variables for interacting with GUI
    @FXML
    private ListView<Book> booksListView;
    @FXML
    private ImageView coverImageView;

    // stores the list of Book Objects
    private final ObservableList<Book> books = FXCollections.observableArrayList();

    // initialize controller
    public void initialize() {
        // populate the ObservableList<Book>
        books.add(new Book("Android How to Program", "images/small/androidhtp.jpg", "images/large/androidhtp.jpg"));
        books.add(new Book("C How to Program", "images/small/chtp.jpg", "images/large/chtp.jpg"));
        books.add(new Book("C++ How to Program", "images/small/cpphtp.jpg", "images/large/cpphtp.jpg"));
        books.add(new Book("Visual C# How to Program", "images/small/vcshtp.jpg", "images/large/vcshtp.jpg"));
        books.add(new Book("Visual Basic How to Program", "images/small/vbhtp.jpg", "images/large/vbhtp.jpg"));
        books.add(new Book("Internet and World Wide Web How to Program", "images/small/iw3htp.jpg", "images/large/iw3htp.jpg"));

        booksListView.setItems(books); // bind bookListView to books

        // when ListView selection changes, show large cover in ImageView
        booksListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<Book>() {
                            @Override
                            public void changed(ObservableValue<? extends Book> ov, Book oldValue, Book newValue) {
                                if (newValue != null) {
                                    URL imageUrl = getClass().getResource(newValue.getLargeImage());
                                    if (imageUrl == null) {
                                        System.out.println("Resource not found: " + newValue.getLargeImage());
                                    } else {
                                        Image image = new Image(imageUrl.toExternalForm());
                                        coverImageView.setImage(image);
                                    }
                                }

                            }
                        }
                );


//        booksListView.setCellFactory(
//                new Callback<ListView<Book>, ListCell<Book>>() {
//                    @Override
//                    public ListCell<Book> call(ListView<Book> listView) {
//                        return new ImageTextCell();
//                    }
//                }
//        );
    }
}