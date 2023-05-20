import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane{
	TopPane top;
	NewCenterPane center;
	BottomPane bottom;
	
	
	public MainPane(TopPane top, NewCenterPane center, BottomPane bottom) {
		this.top = top;
		this.center = center;
		this.bottom = bottom;
		
		setTop(top);
		setCenter(center);
		setBottom(bottom);
	}
	
	
}
