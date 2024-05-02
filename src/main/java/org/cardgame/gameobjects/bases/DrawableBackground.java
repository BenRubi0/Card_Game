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
        DrawTextureEx(this.bgTexture, new Vector2().x(0).y(0), 0, 1.5f, Jaylib.WHITE);
    }

    @Override
    public void destroy() {
        UnloadTexture(this.bgTexture);
    }
}
