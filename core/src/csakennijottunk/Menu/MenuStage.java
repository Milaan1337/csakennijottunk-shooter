package csakennijottunk.Menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Game.BearActor;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;

public class MenuStage extends MyStage {
    ExitBUtton exitBUtton;
    StartButton startButton;
    CreditButton creditButton;
    BearActor bearActor;

    public MenuStage(MyGame game) {
        super(new ResponseViewport(500), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        exitBUtton = new ExitBUtton(game);
        addActor(exitBUtton);
        startButton = new StartButton(game);
        addActor(startButton);
        creditButton = new CreditButton(game);
        addActor(creditButton);

    }
}
