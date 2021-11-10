package csakennijottunk.Credit;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class CreditStage extends MyStage {
    BackButton backButton;
    public CreditStage(MyGame game) {
        super(new ResponseViewport(500),game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        backButton = new BackButton(game);
        addActor(backButton);

    }
}
