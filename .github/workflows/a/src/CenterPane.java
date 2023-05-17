
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CenterPane extends GridPane {
	int rectangleCount = 10;
	private int vx;
	private int vy;
	private CityButton forNextCity;
	ImageView imageView = new ImageView();
	NewLevel level = new NewLevel();
	
	public CenterPane() {
		
	}
	
	public CenterPane(NewLevel lvl) {
		level = lvl;
		int id = 1;
		
		for (int row = 0; row < rectangleCount; row++) {
			for (int col = 0; col < rectangleCount; col++) {
				Rectangle square = new Rectangle();
				square.widthProperty().bind(widthProperty().divide(10).subtract(10));
				square.heightProperty().bind(heightProperty().divide(10).subtract(10));
				;
				// RENKSIZ OLMASI ICIN YAZDIM
				square.setFill(Color.YELLOW);
				square.setStroke(Color.BLACK);
				square.setId(String.valueOf(id));

				add(square, col, row);

				id++;
			}
		}

		Image img = new Image("ist.png");
		Image img1 = new Image("mersin.png");
		Image img2 = new Image("city1.png");
		Image img3 = new Image("city2.png");
		Image img4 = new Image("city3.png");
		Image img5 = new Image("city4.png");
		Image img6 = new Image("fixedcellsign.jpg");
		Image car = new Image("minivan.png");
		Image minivan = new Image("car.png");
		Image bus = new Image("bus.png");
		Image[] imgarr = { img, img1, img2, img3, img4, img5 };
		int rectangleCount = 10;
		int i = 0, a = 0, b = 0;
		for (int row = 0; row < rectangleCount; row++) {
			for (int col = 0; col < rectangleCount; col++) {

				if (a == lvl.cities.size())
					break;
				if (!(lvl.fixedCells.size() == b)) {
					ImageView iv = new ImageView(img6);
					iv.setFitWidth(35);
					iv.setFitHeight(35);
					add(iv, (lvl.fixedCells.get(b) % 10) - 1, (lvl.fixedCells.get(b)) / 10);
					b++;
				}
				if (lvl.cities.get(a).getLocId() == i) { // koordinatların tam olması için 1 den çıkartmıyoruz
					CityButton cB = new CityButton(lvl.cities.get(a).getName(), imgarr[(int) (Math.random() * 6)],
							(lvl.cities.get(a).getLocId() % 10 == 0 ? (lvl.cities.get(a).getLocId() % 10) + 8
									: (lvl.cities.get(a).getLocId() % 10)),
							(lvl.cities.get(a).getLocId() % 10 == 0) ? (lvl.cities.get(a).getLocId() / 10)
									: (lvl.cities.get(a).getLocId()) / 10 + 1);
					forNextCity = cB;
					if (lvl.cities.get(a).getLocId() % 10 == 0) {
						add(cB.cityButton(this), (lvl.cities.get(a).getLocId() % 10) + 9,
								(lvl.cities.get(a).getLocId() / 10) - 1);
					} else {
						add(cB.cityButton(this), (lvl.cities.get(a).getLocId() % 10) - 1,
								(lvl.cities.get(a).getLocId() / 10));
					}
					row = 0;
					col = 0;
					a++;
					i = 0;

				} else
					i++;
			}

		}
		createVehicle(lvl);
	}



	public void createVehicle(NewLevel lvl) {
		Vehicle vehicle = lvl.vehicles.get(0);
		Image car;	
		if (lvl.vehicles.get(0).getCapacity() <= 5) {
			car = new Image("minivan.png");
			imageView = new ImageView(car);
		} else if (lvl.vehicles.get(0).getCapacity() > 5 && lvl.vehicles.get(0).getCapacity() < 14) {
			car = new Image("car.png");
			imageView = new ImageView(car);
		} else {
			car = new Image("bus.png");
			imageView = new ImageView(car);
		}

		imageView.setFitWidth(35);
		imageView.setFitHeight(35);
		int location = 0;
		for (int i = 0; i < lvl.cities.size(); i++) {
			if (vehicle.getCityId() == lvl.cities.get(i).getId())
				location = lvl.cities.get(i).getLocId();
		}
		vx = location % 10 - 1;
		vy = location / 10;
		add(imageView, vx, vy);
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}
	public CityButton getForNextCity() {
		return forNextCity;
	}
}
