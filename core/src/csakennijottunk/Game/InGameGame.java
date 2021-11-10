package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class InGameGame extends MyGame {
    public InGameGame(boolean debug) {
        super(debug);
    }

    @Override
    public void create() {
        super.create();
        setScreen(new GameScreen(this));
    }
}
