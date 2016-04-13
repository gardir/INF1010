import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class EnkeltEksempel extends Application {
	TextField felt;

	@Override
	public void start(Stage primaryStage) {
		Text tekst = new Text("Skriv inn noe her:");
		tekst.setFont(new Font(20));
		felt = new TextField();

		FlowPane root = new FlowPane();
		root.getChildren().add(tekst);
		root.getChildren().add(felt);
		//alternativt: root.getChildren().addAll(tekst, felt); // Kan variere antall parametre

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		primaryStage.setTitle("Tittelen paa programmet");
		primaryStage.show();
	}

	@Override
	public void stop() {
		System.out.println(felt.getText());
	}

	public static void main(String[] args) {
		launch(args);
	}
}