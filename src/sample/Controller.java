package sample;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField text;

    @FXML
    ListView list;

    ObservableList<ToDoItem> toDoItems = FXCollections.observableArrayList();

    public void addItem(){
        System.out.println("addItem");
        String s = text.getText();
        ToDoItem item = new ToDoItem(s, false);
        toDoItems.add(item);
        text.clear();
    }

    public void removeItem(){
        System.out.println("removeItem");
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItem();
        toDoItems.remove(item);
        list.refresh();
    }

    public void toggleItem(){
        System.out.println("toggleItem");
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItem();
        item.isDone = !item.isDone;
        list.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(toDoItems);
        list.refresh();
    }
}
