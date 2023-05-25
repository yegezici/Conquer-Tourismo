//Muhammed Hasan Erzincanli 150121031
//Yunus Emre Gezici 150121066
import java.util.ArrayList;
import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class NewCenterPane extends Pane {
	// Keeps the nodes on this pane
	Node[][] nodes = new Node[10][10];
	// Keeps the current NewLevel object
	NewLevel lvl;
	// Width every cell
	double cellWidth;
	// Height of every cell
	double cellHeight;
	// Keeps a NewCityButton object
	NewCityButton city;

	public NewCenterPane(NewLevel lvl, Text text) {
		this.lvl = lvl;
		// These are our images that used on this pane
		Image img = new Image("ist.png");
		Image img1 = new Image("mersin.png");
		Image img2 = new Image("city1.png");
		Image img3 = new Image("city2.png");
		Image img4 = new Image("city3.png");
		Image img5 = new Image("city4.png");
		Image img6 = new Image("fixedcellsign.png");
		// Due to our cities's image are selected randomly we put them in an array
		Image[] imgarr = { img, img1, img2, img3, img4, img5 };
        //Nested loops for 10x10 field.
		int i = 0, a = 0, b = 0;   //a refers to index in lvl.cities array list, b refers to fixedCells index of array list, i refers to id of each cell.
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (a == lvl.cities.size())       //
					break;
				//Placing fixed cell image in the correct position
				if (!(lvl.fixedCells.size() == b)) {           
					ImageView iv = new ImageView(img6);
					iv.setFitWidth(35);
					iv.setFitHeight(35);
					nodes[(lvl.fixedCells.get(b) % 10) - 1][(lvl.fixedCells.get(b)) / 10] = iv; //Mathematical calculations to determine row and column 
					b++; 
				}
			//If city ID and i (cell ID) matches, create a NewCityButton object and call createButton method.	
				if (lvl.cities.get(a).getLocId() == i) {
					NewCityButton button = new NewCityButton(lvl.cities.get(a).getName(),  //Getting the name of the city by accessing the array list 
							imgarr[(int) (Math.random() * 6)],   //Random image between six images		
	/** If city is in the edge of the pane calculations is made different. And the result will multiply with cellWidth or cellHeight
		for getting correct position (x,y) of the city in the pane */
							(lvl.cities.get(a).getLocId() % 10 == 0
									? (((lvl.cities.get(a).getLocId() % 10) + 8) - 1) * cellWidth
									: (((lvl.cities.get(a).getLocId() % 10)) - 1) * cellWidth),
							(lvl.cities.get(a).getLocId() % 10 == 0)
									? ((lvl.cities.get(a).getLocId() / 10) - 1) * cellHeight
									: (((lvl.cities.get(a).getLocId()) / 10 + 1) - 1) * cellHeight,
							lvl, a);                //As it is said, a refers to index of the city in the array list.

					city = button;

					if (lvl.cities.get(a).getLocId() % 10 == 0) {
						nodes[(lvl.cities.get(a).getLocId() % 10) + 9][(lvl.cities.get(a).getLocId() / 10) - 1] = button
								.createButton(text);

					} else {
						nodes[(lvl.cities.get(a).getLocId() % 10) - 1][(lvl.cities.get(a).getLocId() / 10)] = button
								.createButton(text);
					}
					//row, col, i is reseted. And loop will start iterating again and again for every indexes of cities array list.
					row = 0;              
					col = 0;
					a++;
					i = 0;

				} else           //If any NewCityButton is not created, loop will continue iterating.
					i++;
			}

		}
		// Sets this pane's size 500 width 500 height
		this.setPrefSize(500, 500);
		// Pane includes 100 cells so we divide width and height by 10
		cellWidth = this.getPrefWidth() / 10;
		cellHeight = this.getPrefHeight() / 10;

		// This nested loop looks every point of nodes array
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				// If this point includes an object
				if (nodes[row][col] != null) {
					// To arrange its positions and add to the pane
					Node willAdded = nodes[row][col];
					// To distinguish cities from others (our cities are represented on buttons)
					if (willAdded instanceof Button) {
						// To find exact location on the pane it is multiplied by cellWidth and height
						// We subtract 5 from their locations to gain better appearance
						willAdded.setLayoutX(cellWidth * row - 5);
						willAdded.setLayoutY(cellHeight * col - 5);
					} else {
						// To find exact location on the pane it is multiplied by cellWidth and height
						// We add 5 from their locations to gain better appearance
						willAdded.setLayoutX(cellWidth * row + 5);
						willAdded.setLayoutY(cellHeight * col + 5);
					} // Finally, it is added on the pane
					this.getChildren().add(willAdded);

				}
			}
		} // Vehicle created on the pane
		createVehicle(lvl);

	}
	//To create a polyline between two points
	public Polyline createLine(double startX, double startY, double endX, double endY) {
		Polyline polyline = new Polyline();
		//If a fixed cell exist on the line
		int fixed = isThere(startX, startY, endX, endY);
		//This part is our incomplete part, we start here but we couldn't run it as we want
		//Therefore; these part almost useless 
		//I will explain just certain parts
		if (fixed != 0) {
			// To determine coordinates of fixed cell
			//Takes the cordinates of fixed cell
			double xOfFixed = (fixed % 10 - 1) * cellWidth;
			double yOfFixed = (fixed / 10 + 1) * cellHeight - 5;
			//if vehicle's x coordinate bigger than city and y coordinate smaller than
			if (startX > endX && startY < endY) {
				//if fixed cell on same column with city
				if (xOfFixed == endX) {
					polyline.getPoints().addAll(startX, startY, endX, startY, endX, yOfFixed - 50, endX + 50,
							yOfFixed - 50);
					fixed = isThere(endX + 50, yOfFixed - 50, endX, endY);
					if (fixed == 0) {
						polyline.getPoints().addAll(endX - 50, endY, endX, endY);
					} else {
						// ...
					}
					//if fixed cell on same row with vehicle
				} else if (yOfFixed == startY) {
					polyline.getPoints().addAll(startX, startY, xOfFixed - 50, startY);
					fixed = isThere(xOfFixed - 50, startY, endX, endY);
					if (fixed == 0) {
						polyline.getPoints().addAll(xOfFixed - 50, endY, endX, endY);
					}
					else {
						xOfFixed = (fixed % 10 - 1) * cellWidth;
						yOfFixed = (fixed / 10) * cellHeight;
					}//After that part is useles but we did not want to delete
				} else if (yOfFixed == endY) {
				} else if (xOfFixed == startX) {
				} else {
					polyline.getPoints().addAll(startX, startY, endX, startY, endX, endY);
				}
			} else if (startX < endX && startY > endY) {
				if (startY == yOfFixed) {
					polyline.getPoints().addAll(startX, startY, xOfFixed - 50, startY, xOfFixed - 50, startY - 50);
					fixed = isThere(xOfFixed - 50, startY - 50, endX, endY);
					if (fixed == 0) {
						polyline.getPoints().addAll(endX, startY - 50, endX, endY);

					} else {

					}
				} else {
					polyline.getPoints().addAll(startX, startY, endX, startY, endX, endY);
				}
			} else {
				polyline.getPoints().addAll(startX, startY, endX, startY, endX, endY);
			}
		} else {
			polyline.getPoints().addAll(startX, startY, endX, startY, endX, endY);

		}
		//Changes the polyline's color and width and returns it
		polyline.setStroke(Color.GREEN);
		polyline.setStrokeWidth(7);
		return polyline;

	}
	//To show the vehicle on the pane
	public void createVehicle(NewLevel lvl) {
		//To find vehicle's city id
		int location = 0;
		for (int i = 0; i < lvl.cities.size(); i++) {
			if (lvl.vehicle.getCityId() == lvl.cities.get(i).getId())
				location = lvl.cities.get(i).getLocId();
		}
		//To find its coordinates on the pane
		int vx = location % 10 - 1;
		int vy = location / 10;
		//Resize the imageview of the vehicle
		lvl.vehicle.imageView.setFitWidth(35);
		lvl.vehicle.imageView.setFitHeight(35);
		lvl.vehicle.xCoordinate = vx * cellWidth;
		lvl.vehicle.yCoordinate = vy * cellHeight;
		//Put the vehicle on to the pane
		lvl.vehicle.imageView.setLayoutX(lvl.vehicle.xCoordinate);
		lvl.vehicle.imageView.setLayoutY(lvl.vehicle.yCoordinate);
		this.getChildren().add(lvl.vehicle.imageView);

	}
	//To animate the car on a line
	public void animation(Polyline polyline) {
		PathTransition transition = new PathTransition();
		//The duration time of the animation is 2 seconds
		transition.setDuration(Duration.millis(2000));
		//Set the path
		transition.setPath(polyline);
		//Set the node
		transition.setNode(lvl.vehicle.imageView);
		//To take vehicle to the front
		lvl.vehicle.imageView.toFront();
		//Just 1 time animation will be displayed
		transition.setCycleCount(1);
		//Starts the animation
		transition.play();
	}
	//If a fixed cell exist on the line, this method returns its location id
	public int isThere(double startX, double startY, double endX, double endY) {
		int fixed = 0;
		//To check colums
		ArrayList<Double> x = new ArrayList<>();
		//To check rows
		ArrayList<Double> y = new ArrayList<>();
		//If a fixed cell exist add its coordinates to arraylists
		for (int i = 0; i < lvl.fixedCells.size(); i++) {
			x.add((lvl.fixedCells.get(i) % 10 - 1) * cellWidth);
			y.add((lvl.fixedCells.get(i) / 10) * cellHeight);
		}
		//Finally initialize the fixed cell with its location id 
		for (int i = 0; i < lvl.fixedCells.size(); i++) {
			if ((x.get(i) <= startX && x.get(i) >= endX) || (x.get(i) >= startX && x.get(i) <= endX)) {
				if ((y.get(i) <= startY && y.get(i) >= endY) || (y.get(i) >= startY && x.get(i) <= endY)) {
					fixed = lvl.fixedCells.get(i);
				}
			}
		}//returns fixed
		return fixed;
	}

}
