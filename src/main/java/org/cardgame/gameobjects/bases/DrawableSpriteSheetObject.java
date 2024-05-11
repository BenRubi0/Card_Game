// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame.gameobjects.bases;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Raylib.*;

public class DrawableSpriteSheetObject extends DrawableObject{
    public Rectangle map;

    public DrawableSpriteSheetObject(Texture sprite_sheet, Vector2 pos, Rectangle map) {
        super(sprite_sheet, pos);
        this.map = map;
    }

    @Override
    public void draw() {
        if (this.getShouldDraw())
            // the textures height should always be more than 0, if not then the texture file doesn't exist
            if (this.texture.height() > 0 || this.texture != null)
                // draw the texture to the screen
                DrawTextureRec(this.texture, this.map, this.pos, Jaylib.WHITE);
            else {
                // if the texture is null then set the texture to missing.png
                this.texture = Raylib.LoadTexture("textures/missing.png");
                DrawTextureV(this.texture, this.pos, Jaylib.WHITE);
            }
    }
}
