//Muhammed Hasan Erzincanli 150121031
//Yunus Emre Gezici 150121066
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane{
	//This is the top pane of our main pane
	TopPane top;
	//This is the center pane of our main pane
	NewCenterPane center;
	//This is the bottom pane of our main pane
	BottomPane bottom;
	
	
	public MainPane(TopPane top, NewCenterPane center, BottomPane bottom) {
		this.top = top;
		this.center = center;
		this.bottom = bottom;
		
		//We put them on the pane
		setTop(top);
		setCenter(center);
		setBottom(bottom);
	}
	
	
}
