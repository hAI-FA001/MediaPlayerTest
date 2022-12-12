import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class MediaPlayerDemo extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //first create a file object like this
        File file = new File("production_ID_4873122.mp4");
        //sout to check what this is
        System.out.println(file);
        System.out.println(file.toURI());
        System.out.println(file.toURI().toURL());

        //create media player object                                 //Media is created using this method chain
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toURL().toString()));
        //create media view to actually display it in gui
        MediaView mediaView = new MediaView(mediaPlayer);

        //some code to make the video fit the whole scene/screen otherwise it may be smaller than scene/screen
        DoubleProperty width = mediaView.fitWidthProperty();
        DoubleProperty height = mediaView.fitHeightProperty();

        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
        mediaView.setPreserveRatio(false);

        //some container to add media view into so we can see it
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(mediaView);

        //need scene for app
        Scene scene = new Scene(stackPane, 500, 500, Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Media Player Test");
        stage.show();
        //play media after showing stage/window
        mediaPlayer.play();
    }
}
