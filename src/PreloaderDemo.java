import javafx.application.Preloader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//is linked with MediaPlayerDemo
public class PreloaderDemo extends Preloader {
    ProgressBar progressBar;
    Stage stage;
    int width = 750;
    int height = 500;

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene());
        stage.show();
    }

    private Scene createPreloaderScene() {
        progressBar = new ProgressBar();
        Group group = new Group();
        progressBar.setLayoutX(width/2);
        progressBar.setLayoutY(height/2);

        group.getChildren().add(progressBar);
        return new Scene(group, width, height);
    }

    @Override
    public void handleProgressNotification(ProgressNotification pN){
        System.out.println(pN.getProgress());
        progressBar.setProgress(pN.getProgress());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {}

    }
    @Override
    public void handleStateChangeNotification(StateChangeNotification sCN){
        if(sCN.getType() == StateChangeNotification.Type.BEFORE_START){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stage.close();
        }
    }

    private Scene createAppLoadedScene() {
        BorderPane borderPane = new BorderPane();
        Text welcome = new Text("Welcome To App");
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(width);
        rectangle.setHeight(height/7);
        rectangle.setFill(Color.PINK);

        borderPane.setCenter(welcome);
        borderPane.setTop(rectangle);

        return new Scene(borderPane, width, height);
    }
}
