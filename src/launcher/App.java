package launcher;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.CaesarEncryptie;
import model.Geheimschrift;
import model.GeheimschriftBehavior;
import model.SpiegelingEncryptie;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("App voor een string te coderen/decoderen");
        FlowPane root = new FlowPane();
        Scene mainScene = new Scene(root, 800, 500);
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setVgap(5);
        root.setHgap(5);

        Label stringLabel = new Label("Tekst die je gaat coderen/decoderen");
        TextField stringTextfield = new TextField();



        Label verschillendeEncrypties = new Label("Encryptietypes");
        String alles[] = {"Caesar", "Spiegeling"};

        Label intCaesar = new Label("Geeft een cijfer als je voor Caesarencryptie kiest");
        TextField caesarGetal = new TextField();

        ComboBox combobox = new ComboBox(FXCollections.observableArrayList(alles));
        Button decodeerBtn =  new Button("Decodeer");
        Button codeerBtn = new Button("codeer");

        Label uitkomstLabel = new Label("Resultaat= ");
        TextField uikomstResultaat = new TextField();


        root.getChildren().add(stringLabel);
        root.getChildren().add(stringTextfield);
        root.getChildren().add(verschillendeEncrypties);
        root.getChildren().add(combobox);
        root.getChildren().add(codeerBtn);
        root.getChildren().add(decodeerBtn);
        root.getChildren().add(intCaesar);
        root.getChildren().add(caesarGetal);
        root.getChildren().add(uitkomstLabel);
        root.getChildren().add(uikomstResultaat);



        decodeerBtn.setOnAction(new CheckResultHandler(){
            @Override
            public void handle(ActionEvent event) {
                if(combobox.getValue().equals("Spiegeling")){
                    SpiegelingEncryptie s= new SpiegelingEncryptie();
                    String a = s.decodeer(stringTextfield.getText());
                    uikomstResultaat.setText(a);
                }
                else if(combobox.getValue().equals("Caesar")){
                    CaesarEncryptie c= new CaesarEncryptie(Integer.parseInt(caesarGetal.getText()));
                    String b = c.decodeer(stringTextfield.getText());
                    uikomstResultaat.setText(b);
                }
                else{
                    uitkomstLabel.setText("Er is iets fout gelopen");

                }
            }
        });
        codeerBtn.setOnAction(new CheckResultHandler(){
            @Override
            public void handle(ActionEvent event) {
                if(combobox.getValue().equals("Spiegeling")){
                    SpiegelingEncryptie s = new SpiegelingEncryptie();
                    String a = s.codeer(stringTextfield.getText());
                    uikomstResultaat.setText(a);
                }
                else if(combobox.getValue().equals("Caesar")){
                    CaesarEncryptie c = new CaesarEncryptie(Integer.parseInt(caesarGetal.getText()));
                    String b = c.codeer(stringTextfield.getText());
                    uikomstResultaat.setText(b);
                }
                else{
                    uikomstResultaat.setText("Er is iets fout gelopen");
                }
            }
        });
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }
}
