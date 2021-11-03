package csakennijottunk;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class MenuStage extends MyStage {
    public MenuStage( MyGame game) {
        super(new ResponseViewport(500), game);
    }
}
