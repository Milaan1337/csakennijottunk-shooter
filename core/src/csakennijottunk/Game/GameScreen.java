package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class GameScreen extends MyScreen {
    public GameScreen(MyGame game) {
        super(game);
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new GameStage(game), 1, true);
        addStage(new GameStageForBUttons(game), 2, true);
    }
}
