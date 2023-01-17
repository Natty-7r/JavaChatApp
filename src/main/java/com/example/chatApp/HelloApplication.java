package com.example.chatApp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.PseudoColumnUsage;
import java.sql.SQLException;

public class HelloApplication extends Application {
    static  int currentButton =  1;
    static String loggedUsername ="SomeOne";

    static String studentSubPage = "search";

    @Override
    public void start(Stage stage) throws SQLException {

//        Database.getConnection();

      setStageContent(stage,chatAppPage(stage,"hi",1));


    }

    private static  void  setStage(Stage stage){

        stage.setHeight(450);
        stage.setMinHeight(350);
        stage.setMaxHeight(500);
        stage.setResizable(false);
        stage.setTitle("CHAT APP");


    }
    public static   void setStageContent(Stage stage,HBox chatApp){
        VBox wholePage =  new VBox();
        wholePage.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(chatApp);

        stage.setScene(scene);
        setStage(stage);
        stage.show();

    }

    static public HBox chatAppPage(Stage stage,String message , int type ){ //chat App
        HBox chatApp =  new HBox();

        VBox contacts =  new VBox();
        {
            contacts.setPrefWidth(150);
            contacts.setPrefHeight(400);
            contacts.setStyle("" +
                    "-fx-background-color:rgb(12, 74, 110);"
            );
        }

        VBox chatBox =  new VBox();
        HBox chatHeader =  new HBox();
        {
            Button back  =  new Button("<-");
            Label receiverName =  new Label("SomeOne");
            receiverName.setTextFill(Color.WHITE);
            chatHeader.setStyle("" +
                    "-fx-background-color:rgb(12, 74, 110);"
            );
            chatHeader.setAlignment(Pos.CENTER_LEFT);
            chatHeader.setSpacing(5);
            chatHeader.setPadding(new Insets(5,5,5,20));
            chatHeader.getChildren().addAll(back,receiverName);

        }
        VBox chatView =  new VBox();
        chatView =  updateChatView(chatView,message,type);
        chatBox.getChildren().addAll(chatHeader,chatView);

        chatApp.getChildren().addAll(contacts,chatBox);
   //
        return  chatApp;

    }
    static  private HBox chat(String message ,int type){ // for single message
        Label messageLabel=  new Label(message);
        messageLabel.setTextFill(Color.WHITE);
        HBox messageBar = new HBox();

        HBox messageBox =  new HBox();
        messageBox.getChildren().add(messageLabel);
        messageBox.setPadding(new Insets(5,5,5,10));
        messageBox.setMaxWidth(200);
        messageBox.setPrefWidth(200);
        if(type==1){
            messageBar.setAlignment(Pos.CENTER_LEFT);
            messageBox.setStyle("-fx-background-color:rgb(128, 0, 128);");
        }
        if(type==2){
            messageBar.setAlignment(Pos.CENTER_RIGHT);
            messageBox.setStyle("-fx-background-color:rgba(128, 0, 128, 0.735);");
        }
        messageBar.getChildren().add(messageBox);
        return messageBar;
    }

     static  private VBox updateChatView(VBox chatView,String message ,int type){

         {
             chatView.setMinWidth(350);
             chatView.setPrefWidth(400);
             chatView.setPrefHeight(400);
             chatView.setPadding(new Insets(5));
             chatView.setStyle("" +
                     "-fx-background-color:white;"
             );

             chatView.setSpacing(5);

         }
        chatView.getChildren().add(chat(message,type));
        return  chatView;

    }

    public static void main(String[] args) {
        launch();
    }
}