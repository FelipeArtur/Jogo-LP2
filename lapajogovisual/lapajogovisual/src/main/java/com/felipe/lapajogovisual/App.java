package com.felipe.lapajogovisual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static int turno;
    public static Jogador[] J;
    public static char[][] tabuleiro;
    public static Mapa map;
    public static Jogador jogadorVencedor;  
    public static int comeca2;
    public static int comeca1; 
    public static Rectangle[][] mapa;
    public static ImageView[][] mapaPersonagens;
    public static ImageView[][] mapaAnimacao;
    public static ImageView[][] mapaMadeira;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("secondary"), 1100, 501);
        stage.setScene(scene);
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException {
        
             
        launch();
        
        
    }

}