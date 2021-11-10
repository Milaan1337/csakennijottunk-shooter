package csakennijottunk.Menu;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MenuGame extends MyGame {
    public MenuGame(boolean debug) {
        super(debug);
    }

    @Override
    public void create() {
        super.create();
        setScreen(new MenuScreen(this));

    }
}
