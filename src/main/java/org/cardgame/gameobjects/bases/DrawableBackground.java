// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame.gameobjects.bases;

import com.raylib.Jaylib;
import org.cardgame.help.Drawable;

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
