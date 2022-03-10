package com.example.kierra;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Kierra extends Application {
    private int asteet = 0;
    public void start(Stage stage) {
        HBox paneeliPainikkeille = new HBox(20);    //Paneeli napille
        Button kierra = new Button("Kierrä");   //Luodaan nappi
        paneeliPainikkeille.getChildren().addAll(kierra);
        paneeliPainikkeille.setAlignment(Pos.CENTER);
        paneeliPainikkeille.setStyle("-fx-border-color: green");

        BorderPane paneeli = new BorderPane();
        paneeli.setBottom(paneeliPainikkeille);

        Pane paneeliSuorakulmiolle = new Pane();    //Paneeli suorakulmiolle
        Rectangle suora = new Rectangle(130, 50);   //Luodaan suorakulmio
        suora.setLayoutX(suora.getX() + suora.getWidth());      //Asetetaan suorakulmiolle sijainti ikkunassa
        suora.setLayoutY(suora.getY() + suora.getHeight()+50);
        suora.setStroke(Color.BLACK);
        suora.setFill(Color.WHITE);

        paneeliSuorakulmiolle.getChildren().add(suora);     //Sijoitetaan suorakulmio suorakulmion paneeliin
        paneeli.setCenter(paneeliSuorakulmiolle);         //Sijotetaan suorakulmion paneeli keskelle

        kierra.setOnAction(e -> {       //Asetetaan napille kiertotoiminto
            if(e.getSource() == kierra) {
                asteet = asteet + 15;
                suora.setRotate(asteet);
            }
        });

        Scene scene = new Scene(paneeli, 400, 320);
        stage.setTitle("Kierrä suorakulmiota");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}