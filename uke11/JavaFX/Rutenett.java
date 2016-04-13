import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Rutenett extends Application {

	@Override
	public void start(Stage primaryStage) {

		// Lager GridPane
		GridPane rutenettet = lagRutenett();

		Scene scene = new Scene(rutenettet);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rutenett");
		primaryStage.show();
	}

	public GridPane lagRutenett() {
		GridPane rutenettet = new GridPane();

		int raderPerBoks = 3;
		int kolonnerPerBoks = 3;
		int storrelse = raderPerBoks * kolonnerPerBoks;

		for(int rad = 0; rad < storrelse; rad++) {
			for(int kol = 0; kol < storrelse; kol++) {
				StackPane pane = new StackPane();
				int venstre = 1;
				int topp = 1;

				if (kol % kolonnerPerBoks == 0) {
					venstre = 5; // Stoerre verdi gir tjukkere venstre border
				}
				if (rad % raderPerBoks == 0) {
					topp = 5; // Stoerre verdi gir tjukkere top border
				}

				//For dere som har vaert borte i CSS:
				//rutenettet.setStyle("-fx-border-color: black");
				pane.setBorder(new Border(new BorderStroke(Color.RED,
														   BorderStrokeStyle.SOLID,
														   CornerRadii.EMPTY,
														   new BorderWidths(topp,   // TOP width
														   	                1,      // RIGHT width
														   	                1,      // BOT width
														   	                venstre // LEFT width
														   	         		))));
				Text tekst = new Text("("+kol+","+rad+")");
				pane.getChildren().add(tekst);

				rutenettet.add(pane, kol, rad);
			}
		}

		// For hver kolonne/rad, sett stoerrelsen som prosent av bredde/hoyde
		for(int i = 0; i < storrelse; i++) {
			ColumnConstraints kolonneStr = new ColumnConstraints();
			kolonneStr.setPercentWidth(100.0/storrelse);
			rutenettet.getColumnConstraints().add(kolonneStr);

			RowConstraints radStr = new RowConstraints();
			radStr.setPercentHeight(100.0/storrelse);
			rutenettet.getRowConstraints().add(radStr);
		}

		/*
		 * Det aller foerste eksempelet med GridPane.
		 * Legger element inn paa bestemt posisjon,
		 * uten aa angi stoerrelse paa GridPane foerst.
		*/
		//rutenettet.add(new Text("Forste"), 0, 0);
		//rutenettet.add(new Text("Andre"), 1, 0);
		//rutenettet.add(new Text("Tredje"), 1, 1);

		return rutenettet;
	}
} 