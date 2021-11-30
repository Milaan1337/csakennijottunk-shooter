package csakennijottunk.Menu;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.LoadingListener;
import hu.csanyzeg.master.MyBaseClasses.Assets.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class MenuGame extends MyGame {
    public MenuGame(boolean debug) {
        super(debug);
    }

    @Override
    public void create() {
        super.create();
        setLoadingStage(new MyLoadingStage(this));
        setScreen(new MenuScreen(this));

    }
}
