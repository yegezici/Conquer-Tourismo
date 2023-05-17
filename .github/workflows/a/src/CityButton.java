import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CityButton {
	String name;
	Image img;
	ArrayList<Integer> rowLinePoints = new ArrayList<>();
	ArrayList<Integer> colLinePoints = new ArrayList<>();
	static ArrayList<Integer> points = new ArrayList<Integer>();
	private static CityButton nextCity;
	static int clickCount = 0;
	int colIndex = 0, rowIndex = 0;
	int endColIndex = 0, endRowIndex = 0;
	int sRI, bRI, sCI, bCI;
	ArrayList<Double> x = new ArrayList<>();
	ArrayList<Double> y = new ArrayList<>();
	static CenterPane pane = new CenterPane();
	//Calculate score icin
	CityButton loc;

	CityButton() {

	}

	CityButton(String name, Image img, int colIndex, int rowIndex) {
		this.name = name;
		this.img = img;
		this.colIndex = colIndex;
		this.rowIndex = rowIndex;

	}

	public BorderPane cityButton(CenterPane pane) {
		Button cB = new Button();
		CityButton.pane = pane;
		cB.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		cB.setOnMouseClicked(event -> {
			x.add(event.getX());
			y.add(event.getY());
			System.out.println("Mouse clicked at (" + x + ", " + y + ")");
		});
		cB.setOnAction(e -> {
			// row index aslinda y degeri o yuzden ilk colu almamiz laizm yerlerini
			// degistirdim
			points.add(colIndex - 1);
			points.add(rowIndex - 1);
			nextCity = this;
			loc = this;
			clickCount++;
			for (int i = 0; i < points.size(); i++)
				System.out.print(points.get(i) + "-");

			/*
			 * if (points.size() == 4) { if ((points.get(0) > points.get(2))) { bRI =
			 * points.get(0); sRI = points.get(2);
			 * 
			 * } else { bRI = points.get(2); sRI = points.get(0); } if ((points.get(1) >
			 * points.get(3))) { bCI = points.get(1); sCI = points.get(3);
			 * 
			 * } else { bCI = points.get(3); sCI = points.get(1); } for (int i = bRI - 1; i
			 * >= sRI; i--) { Direction d = new Direction(); pane.add(d.createRowLine(), i,
			 * points.get(1)); rowLinePoints.add(i); rowLinePoints.add(points.get(1)); } for
			 * (int i = sCI; i < bCI; i++) { Direction d = new Direction();
			 * pane.add(d.createColLine(), points.get(2), i);
			 * colLinePoints.add(points.get(2)); colLinePoints.add(i); }
			 * 
			 * System.out.println(calculateDistance(points.get(0), points.get(1),
			 * points.get(2), points.get(3))); }
			 * 
			 * if (points.size() == 6) { ArrayList<Node> nodesToRemove = new ArrayList<>();
			 * for (int i = 0; i < rowLinePoints.size(); i++) { for (Node n :
			 * pane.getChildren()) { if (GridPane.getRowIndex(n) == rowLinePoints.get(1) &&
			 * GridPane.getColumnIndex(n) == rowLinePoints.get(i)) { nodesToRemove.add(n); }
			 * } } rowLinePoints.clear();
			 * 
			 * for (int i = 0; i < colLinePoints.size(); i++) { for (Node n :
			 * pane.getChildren()) { if (GridPane.getRowIndex(n) == colLinePoints.get(i) &&
			 * GridPane.getColumnIndex(n) == colLinePoints.get(1)) { nodesToRemove.add(n); }
			 * } } colLinePoints.clear(); for (Node node : nodesToRemove) {
			 * pane.getChildren().remove(node); }
			 * 
			 * int x = points.get(4); int y = points.get(5); points.clear(); points.add(x);
			 * points.add(y); }
			 */
		});

		Label label = new Label("  " + this.name);
		label.setAlignment(Pos.BOTTOM_CENTER);

		label.toFront();

		BorderPane bP = new BorderPane();

		ImageView iv = new ImageView(this.img);
		iv.setFitHeight(35);
		iv.setFitWidth(35);

		cB.setGraphic(iv);
		VBox vB = new VBox(1);
		vB.getChildren().addAll(cB, label);
		bP.setCenter(vB);

		return bP;

	}

	public int calculateDistance(int x1, int y1, int x2, int y2) {
		return (int) (Math.ceil(Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2))));

	}

	public static CityButton getNextCity() {
		return nextCity;
	}

	public IntegerProperty calculateScore() {
		int cost = calculateDistance(points.get(0), points.get(1), points.get(2), points.get(3));
		System.out.println("cost " + cost);
		int income = (int) ((pane.level.vehicle.getCapacity()) * (cost) * (0.2));
		System.out.println("income " + income);
		int moveScore = income - cost;
		IntegerProperty returnValue = new SimpleIntegerProperty(moveScore);
		System.out.println(moveScore);
		points.clear();
		return returnValue;
		
	}

}
