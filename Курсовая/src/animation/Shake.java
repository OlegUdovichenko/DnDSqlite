package animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    public TranslateTransition tt;

    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(120), node);
        tt.setFromY(0f);
        tt.setByY(10f);
        tt.setCycleCount(5);
        tt.setAutoReverse(true);
    }

    public void playAnin(){
        tt.playFromStart();
    }
}
