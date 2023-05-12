

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomPane extends GridPane {
    private static final int FIELD_SIZE = 10;
    private static final int SQUARE_SIZE = 50;

    public CustomPane() {
        int id = 1;

        for (int row = 0; row < FIELD_SIZE; row++) {
            for (int col = 0; col < FIELD_SIZE; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                square.setFill(Color.WHITE);
                square.setId(String.valueOf(id));
              //  square.setStroke(Color.BLACK);

                add(square, col, row);

                if (id == 14) {
                	
                    Label label = new Label("Istanbul");
                    label.setAlignment(Pos.BOTTOM_CENTER);
                    label.setFont(Font.font("Arial" , FontWeight.BOLD , 12));
                   // add(label, 3, 1);
                    
                    label.toFront();
                    //label.setPadding(new Insets(0,0,0,15));
                    Image img = new Image("ist.png");
                    ImageView iv = new ImageView(img);
                    iv.setFitHeight(35);
                    iv.setFitWidth(35);
                   // add(iv, 3, 1);
                    VBox vb = new VBox(5);
                    vb.getChildren().addAll(iv, label);
                    vb.setAlignment(Pos.CENTER);
                    add(vb, 3, 1);
                    
                    
                    
                }
                if (id == 62) {
                    Label label = new Label("Mersin");
                    add(label, 1, 6);
                    setPadding(new Insets(15,15,15,15));
                    Image img = new Image("mersin.png");
                    ImageView iv = new ImageView(img);
                    iv.setFitHeight(35);
                    iv.setFitWidth(35);
                   // add(iv, 3, 1);
                    VBox vb = new VBox(5);
                    vb.getChildren().addAll(iv, label);
                    vb.setAlignment(Pos.CENTER);
                    add(vb, 1, 6);
                }
                if (id == 89) {
                    Label label = new Label("Van");
                    add(label, 8, 8);
                    setPadding(new Insets(15,15,15,15));
                    Image img = new Image("ist.png");
                    ImageView iv = new ImageView(img);
                    iv.setFitHeight(35);
                    iv.setFitWidth(35);
                   // add(iv, 3, 1);
                    VBox vb = new VBox(5);
                    vb.getChildren().addAll(iv, label);
                    vb.setAlignment(Pos.CENTER);
                    add(vb, 8, 8);
                }

                id++;
            }
        }
    }

	
}
