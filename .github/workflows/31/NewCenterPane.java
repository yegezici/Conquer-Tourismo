import java.util.ArrayList;

import javafx.animation.PathTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class NewCenterPane extends Pane {
	Node[][] nodes = new Node[10][10];
	NewLevel lvl;
	DoubleProperty xlength;
	DoubleProperty ylength;
	double cellWidth;
	double cellHeight;
	NewCityButton city;


	NewCenterPane(NewLevel lvl, Text text) {
		this.lvl = lvl;
		Image img = new Image("ist.png");
		Image img1 = new Image("mersin.png");
		Image img2 = new Image("city1.png");
		Image img3 = new Image("city2.png");
		Image img4 = new Image("city3.png");
		Image img5 = new Image("city4.png");
		Image img6 = new Image("fixedcellsign.jpg");
		Image[] imgarr = { img, img1, img2, img3, img4, img5 };

		int i = 0, a = 0, b = 0;
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (a == lvl.cities.size())
					break;
				if (!(lvl.fixedCells.size() == b)) {
					ImageView iv = new ImageView(img6);
					iv.setFitWidth(35);
					iv.setFitHeight(35);
					nodes[(lvl.fixedCells.get(b) % 10) - 1][(lvl.fixedCells.get(b)) / 10] = iv;
					b++;
				}
				if (lvl.cities.get(a).getLocId() == i) { // koordinatların tam olması için 1 den çıkartmıyoruz
					NewCityButton button = new NewCityButton(lvl.cities.get(a).getName(),
							imgarr[(int) (Math.random() * 6)],
							(lvl.cities.get(a).getLocId() % 10 == 0
									? (((lvl.cities.get(a).getLocId() % 10) + 8) - 1) * cellWidth
									: (((lvl.cities.get(a).getLocId() % 10)) - 1) * cellWidth),
							(lvl.cities.get(a).getLocId() % 10 == 0)
									? ((lvl.cities.get(a).getLocId() / 10) - 1) * cellHeight
									: (((lvl.cities.get(a).getLocId()) / 10 + 1) - 1) * cellHeight,
							lvl, a);

					city = button;

					// bazilarini buranin ustunde silmis olabilirim
					// forNextCity = cB;
					// buttons[index++] =cB;
					if (lvl.cities.get(a).getLocId() % 10 == 0) {
						nodes[(lvl.cities.get(a).getLocId() % 10) + 9][(lvl.cities.get(a).getLocId() / 10) - 1] = button
								.createButton(text);

					} else {
						nodes[(lvl.cities.get(a).getLocId() % 10) - 1][(lvl.cities.get(a).getLocId() / 10)] = button
								.createButton(text);
					}
					row = 0;
					col = 0;
					a++;
					i = 0;

				} else
					i++;
			}

		}



		this.setPrefSize(500, 500);
		cellWidth = this.getPrefWidth() / 10;
		cellHeight = this.getPrefHeight() / 10;

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (nodes[row][col] != null) {
					Node willAdded = nodes[row][col];
					willAdded.setLayoutX(cellWidth * row);
					willAdded.setLayoutY(cellHeight * col);
					this.getChildren().add(willAdded);

				}
			}
		}
		createVehicle(lvl);

	}

	public Polyline createLine(double startX, double startY, double endX, double endY) {
		Polyline polyline = new Polyline();
		polyline.getPoints().addAll(startX, startY, endX, startY, endX, endY);
		polyline.setStroke(Color.GREEN);
		polyline.setStrokeWidth(7);
		return polyline;

	}



	public void createVehicle(NewLevel lvl) {
		Vehicle vehicle = lvl.vehicles.get(0);
		int location = 0;
		for (int i = 0; i < lvl.cities.size(); i++) {
			if (vehicle.getCityId() == lvl.cities.get(i).getId())
				location = lvl.cities.get(i).getLocId();
		}
		int vx = location % 10 - 1;
		int vy = location / 10;
		System.out.println(vx + " " + vy);
		lvl.vehicle.imageView.setFitWidth(35);
		lvl.vehicle.imageView.setFitHeight(35);
		lvl.vehicle.xCordinate = vx * cellWidth;
		lvl.vehicle.yCordinate = vy * cellHeight;
		lvl.vehicle.imageView.setLayoutX(lvl.vehicle.xCordinate);
		lvl.vehicle.imageView.setLayoutY(lvl.vehicle.yCordinate);
		this.getChildren().add(lvl.vehicle.imageView);
	
	}

	public void animation(Polyline polyline) {
		PathTransition transition = new PathTransition();
		transition.setDuration(Duration.millis(2000));
		transition.setPath(polyline);
		transition.setNode(lvl.vehicle.imageView);
		transition.setCycleCount(1);
		transition.play();
	}

}
