package csakennijottunk.Menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Level;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class MenuStage extends MyStage {
    MenuActor menuActor;
    public MenuStage( MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListener();
        menuActor = new MenuActor(game);
        addActor(menuActor);
        menuActor.setY(0);
        menuActor.setX(0);
        new Level(1, this).build();

    }
}
