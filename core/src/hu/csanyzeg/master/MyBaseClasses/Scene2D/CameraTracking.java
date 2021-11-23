package hu.csanyzeg.master.MyBaseClasses.Scene2D;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.SnapshotArray;

public abstract class CameraTracking{

    public OrthographicCamera orthographicCamera;

    public CameraTracking(OrthographicCamera orthographicCamera) {
        this.orthographicCamera = orthographicCamera;
    }

    public abstract void act(float delta_time);
}
