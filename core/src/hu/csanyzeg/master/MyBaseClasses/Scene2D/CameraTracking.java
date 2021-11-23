package hu.csanyzeg.master.MyBaseClasses.Scene2D;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.SnapshotArray;

public abstract class CameraTracking{

    public Stage stage;
    public OrthographicCamera orthographicCamera;

    public CameraTracking() {
    }

    public CameraTracking(Stage stage) {
        this.stage = stage;
        this.orthographicCamera = (OrthographicCamera) stage.getCamera();
    }

    public void setStage(Stage stage){
        this.stage = stage;
        this.orthographicCamera = (OrthographicCamera) stage.getCamera();
    }

    public abstract void act(float delta_time);
}
