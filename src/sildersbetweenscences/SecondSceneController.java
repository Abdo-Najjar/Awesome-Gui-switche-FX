
package sildersbetweenscences;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class SecondSceneController implements Initializable {
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML 
    private Button button;
    
    
    @FXML
    private void loadThirdScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ThirdScene.fxml"));
        Scene scene = button.getScene();
        root.translateXProperty().set(scene.getHeight());
        
        StackPane stackPane = (StackPane) scene.getRoot();
        stackPane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        
        timeline.setOnFinished((event) -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
