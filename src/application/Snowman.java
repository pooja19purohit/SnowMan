/** Snowman.java: A class that builds a snowman
 * 
    @author Pooja Purohit 
    @since April 1, 2015
 */

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.shape.StrokeLineCap;


public class Snowman extends Application {
	static int bodyClick = 0;
	//face
	Circle first;
	double firstX;
	double firstY;
	double firstRadius = 80;
	//chest
	Circle second;
	double secondX;
	double secondY;
	double secondRadius;
	//bottom
	Circle third;
	double thirdRadius;
	double thirdX;
	double thirdY;
	//eyes
	Circle leftEye;
	Circle rightEye;
	double eyeY;
	//buttons
	Circle button1;
	Circle button2;
	Circle button3;
	double buttonX;
	//mouth
	Circle smile1;
	Circle smile2;
	Circle smile3;
	Circle smile4;
	//hand
	Line hand;
	double handX;
	double handY;
	//Display message
	Text display = new Text(14,14,"Press C for Crimson or Y for Light Yellow or V for violet background ");
	//scene
	Scene scene;
	//Pane to build the snowman
	static Pane pane = new Pane();
	
	@Override
	public void start(Stage primaryStage) {
		display.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18));
		pane.getChildren().add(display);
		scene = new Scene(pane,700,900);
		buildGUI();
		primaryStage.setScene(scene);	
		primaryStage.setTitle("Mr.Bossman");
		primaryStage.show();	
		
	}
	
	public void buildGUI() {
		/*The event handler handles the event for Background color change.
		 * 1 Built in color and the other 2 are created
		 */
		scene.setOnKeyReleased(e->{
			KeyCode kcode = e.getCode();
			switch ( kcode ) {
			case Y: {
				Color lightYellow = new Color(1,1,0.6,1);
				scene.setFill(lightYellow);
				display.setText("Click the mouse near the top window for a snowman's face ");
                break;
            }
			case C : {
				scene.setFill(Color.CRIMSON);
				display.setText("Click the mouse near the top window for a snowman's face ");
				break;
			}
			case V : {
				Color violet = new Color(0.6,0.6,0.9,1);
				scene.setFill(violet);
				display.setText("Click the mouse near the top window for a snowman's face ");
				break;
			}
			}
		});
		
		/*Handle the mouse click event for building the snowman
		 * bodyClick count is used to add the respective body part to the pane
		 */
		scene.setOnMouseClicked(event-> {
			switch(bodyClick) {
			case 0 : 
				firstX = event.getX();
				firstY = event.getY();
				first = new Circle(firstX,firstY,firstRadius);
				first.setFill(Color.WHITE);
				first.setStroke(Color.BLACK);
				pane.getChildren().add(first);
				bodyClick++;
				display.setText("Click below the face to get the chest part.");
				break;
			
			case 1 :
				secondX = firstX;	
				secondY = event.getY();
				secondRadius = secondY - firstY - firstRadius+6;
				second = new Circle(secondX,secondY,secondRadius);
				second.setFill(Color.WHITE);
				second.setStroke(Color.BLACK);
				pane.getChildren().add(second);
				bodyClick++;
				display.setText("Click below the chest to get the lower body.");
				break;
				
			case 2 :
				thirdX = firstX;
				thirdY = event.getY();
				thirdRadius = thirdY - secondY - secondRadius+6;
				third = new Circle(thirdX,thirdY,thirdRadius);
				third.setFill(Color.WHITE);
				third.setStroke(Color.BLACK);
				pane.getChildren().add(third);
				bodyClick++;
				display.setText("Click on the intended left eye location.");
				break;
			
			case 3 :
				eyeY = event.getY();
				leftEye = new Circle(event.getX(),eyeY,7);
				leftEye.setFill(Color.BLACK);
				pane.getChildren().add(leftEye);
				bodyClick++;
				display.setText("Click on the intended right eye location.");
				break;			
			
			
			case 4 :
				rightEye = new Circle(event.getX(),eyeY,7);
				rightEye.setFill(Color.BLACK);
				pane.getChildren().add(rightEye);
				bodyClick++;
				display.setText("Click 4 times to get the mouth curve.");
				break;
			
			case 5 :
				smile1 = new Circle(event.getX(),event.getY(),6);
				smile1.setFill(Color.BLACK);
				pane.getChildren().add(smile1);
				bodyClick++;
				break;
				
			case 6 :
				smile2 = new Circle(event.getX(),event.getY(),6);
				smile2.setFill(Color.BLACK);
				pane.getChildren().add(smile2);
				bodyClick++;
				break;
				
			case 7 :
				smile3 = new Circle(event.getX(),event.getY(),6);
				smile3.setFill(Color.BLACK);
				pane.getChildren().add(smile3);
				bodyClick++;
				break;
			
			case 8 :
				smile4 = new Circle(event.getX(),event.getY(),6);
				smile4.setFill(Color.BLACK);
				pane.getChildren().add(smile4);
				bodyClick++;
				display.setText("Click to get the coat button.");
				break;
				
			case 9 :
				button1 = new Circle(event.getX(),event.getY(),8);
				button1.setFill(Color.BLACK);
				pane.getChildren().add(button1);
				bodyClick++;
				display.setText("Click to get the second coat button.");
				break;
			
			case 10 :
				button2 = new Circle(event.getX(),event.getY(),8);
				button2.setFill(Color.BLACK);
				pane.getChildren().add(button2);
				bodyClick++;
				display.setText("Drag the mouse to get the arms.");
				break;
			
			default :
				System.out.println("Mouse Click event");
				double slineX = event.getX();
				double slineY = event.getY();
				hand = new Line(handX,handY,slineX,slineY);
				hand.setStroke(Color.BROWN);
				hand.setStrokeWidth(8);
				hand.setStrokeLineCap(StrokeLineCap.ROUND);
				pane.getChildren().add(hand);
				bodyClick++;
				if(bodyClick == 13) {
					display.setText("Your snowman is ready :)");
				}
				break;			
			
		}			
		});
		
		//Drag event
		scene.setOnMousePressed(e->{
			System.out.println("Mouse pressed event");
			handX = e.getX();
			handY = e.getY();
		});
	}	
}
