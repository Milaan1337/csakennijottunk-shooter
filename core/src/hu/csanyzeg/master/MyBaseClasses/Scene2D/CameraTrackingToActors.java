package hu.csanyzeg.master.MyBaseClasses.Scene2D;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.SnapshotArray;

public class CameraTrackingToActors extends CameraTracking{
    public SnapshotArray<Actor> actors = new SnapshotArray<>();
    public float marginLeft = 0.2f;
    public float marginBottom = 0.2f;
    public float marginRight = 0.2f;
    public float marginTop = 0.2f;
    public float max_zoom = 8;

    public CameraTrackingToActors(OrthographicCamera orthographicCamera) {
        super(orthographicCamera);
    }

    public int getActorCount(){
        return actors.size;
    }

    public void addActor(Actor a){
        actors.add(a);
    }

    public void removeActor(Actor a){
        actors.removeValue(a, true);
    }

    @Override
    public void act(float delta_time) {

    }
}
