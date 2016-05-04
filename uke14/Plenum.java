import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import javafx.geometry.Insets;

public class Plenum extends Application {
    Stage stage;
    TextField filFelt;
    BorderPane root;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        root = new BorderPane();

        HBox toppBoks = lagToppBoks();

        root.setTop(toppBoks);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private HBox lagToppBoks() {
        Button knapp = new Button("Velg fil...");
        knapp.setOnAction(new FilVelger());

        filFelt = new TextField();

        Button openFileButton = new Button("Åpne fil!");
        openFileButton.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ArrayList<Integer> tallListe = new FilLeser().lesFil(filFelt.getText());
                    FlowPane tallBeholder = new FlowPane();

                    for(int i : tallListe) {
                        Label tallLabel = new Label(""+i);
                        tallLabel.setPadding(new Insets(10));
                        tallBeholder.getChildren().add(tallLabel);
                    }

                    root.setCenter(tallBeholder);
                    stage.sizeToScene();
                }
                // Tips: Koden for aa lage alerts er nesten lik, saa her
                // er det lurt aa lage en egen metode for aa vise alert-vinduer
                catch(FileNotFoundException e) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Feil!");
                    alert.setHeaderText(null);
                    alert.setContentText("Feil: Fant ikke filen!");
                    alert.showAndWait();
                }
                catch(FeilFormatUnntak e) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Feil!");
                    alert.setHeaderText(null);
                    alert.setContentText("Feil: Filen har feil format!");
                    alert.showAndWait();
                }
            }
        });

        return new HBox(50, knapp, filFelt, openFileButton);
    }

    private class FilVelger implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Åpne fil!");
            fileChooser.getExtensionFilters().add(
                new ExtensionFilter("Alle filer", "*.*"));
            File fil = fileChooser.showOpenDialog(stage);
            if (fil != null) {
                filFelt.setText(fil.getPath());
            }
        }
    }
}