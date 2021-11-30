package csakennijottunk.Menu;


import csakennijottunk.Game.BearActor;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

class MyLoadingStage extends LoadingStage {
    protected MyActor percent;
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("badlogic.jpg").protect = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //System.out.println(" LLLLLL " + getPercent());
        percent.setRotation(getPercent());
    }

    public MyLoadingStage(MyGame game) {
        super(new ResponseViewport(720), game);
        addActor(percent = new OneSpriteStaticActor(game, "badlogic.jpg"));
    }

    @Override
    public AssetList getAssetList() {
        return assetList;
    }
}
