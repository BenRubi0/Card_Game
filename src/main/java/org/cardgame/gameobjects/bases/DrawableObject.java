package org.cardgame.gameobjects.bases;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import com.raylib.Raylib.*;
import org.cardgame.gameobjects.interfaces.Object;
import org.cardgame.help.Drawable;

public class DrawableObject extends Drawable implements Object {
    public Texture texture;
    public Vector2 pos;

    // drawing other stuff
    public boolean isDebugDrawing = false;

    public DrawableObject(Texture texture, Vector2 pos) {
        this.texture = texture;
        this.pos = pos;
    }

    @Override
    public void draw() {
        if (this.getShouldDraw())
            // the textures height should always be more than 0, if not then the texture file doesn't exist
            if (this.texture.height() > 0 || this.texture != null)
                // draw the texture to the screen
                Raylib.DrawTextureV(this.texture, this.pos, Jaylib.WHITE);
            else {
                // if the texture is null then set the texture to missing.png
                this.texture = Raylib.LoadTexture("textures/missing.png");
                Raylib.DrawTextureV(this.texture, this.pos, Jaylib.WHITE);
            }
    }

    @Override
    public void destroy() {
        Raylib.UnloadTexture(this.texture);
    }

    // empty
    @Override
    public void update() {}

    // extra draw call
    public void _draw() {}
}
