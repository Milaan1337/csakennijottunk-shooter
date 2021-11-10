package csakennijottunk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import csakennijottunk.Game.PlayerActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class Level {
    char[][] levelarray;
    int width;
    int height;
    MyStage stage;

    public Level(int id, MyStage stage) {
        this.stage =stage;
        FileHandle f = Gdx.files.internal("Levels/" + id + ".txt");
        String[] lines = f.readString().split("\n");
        int max = 0;
        for (String s: lines) {
            if (s.length() > max) {
                max = s.trim().length();
            }
        }
        //levelarray = new char[vízszintes][függőleges];
        width = max;
        height = lines.length;
        levelarray = new char[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                levelarray[x][y] = ' ';
            }
        }

        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].trim().length(); x++){
                levelarray[x][y] = lines[y].charAt(x);
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print((char)(levelarray[x][y] ));
            }
            System.out.println();
        }
    }

    public void build(){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                switch (levelarray[x][y]){
                    case 'o':
                        MyActor m = new PlayerActor(stage.game);
                        m.setPosition(x*20, y*20);
                        stage.addActor(m);
                        break;
                    case 'x':
                        MyActor d = new PlayerActor(stage.game);
                        d.setPosition(x*20, y*20);
                        stage.addActor(d);
                        break;
                }
            }
        }
    }
}
