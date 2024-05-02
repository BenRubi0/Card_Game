package org.cardgame.gameobjects.bases;

import com.raylib.Jaylib;
import org.cardgame.help.Drawable;
import org.cardgame.help.WindowHelp;

import static com.raylib.Raylib.*;

public class DrawableBackground extends Drawable {
    public Texture bgTexture;

    public DrawableBackground(Texture bgTexture) {
        this.bgTexture = bgTexture;
    }

    @Override
    public void draw() {
        DrawTextureEx(this.bgTexture, WindowHelp.getWinMidPos(), 0, 1, Jaylib.WHITE);
    }

    @Override
    public void destroy() {
        UnloadTexture(this.bgTexture);
    }
}
