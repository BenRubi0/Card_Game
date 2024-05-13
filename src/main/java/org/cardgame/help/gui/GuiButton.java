// Made by Benjamin Rubio
// For Mr. Gross Software and Programming Dev 1 Class
// Contact at benjamin.rubio@malad.us

package org.cardgame.help.gui;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib;
import org.cardgame.gameobjects.bases.DrawableObject;
import org.cardgame.gameobjects.interfaces.Object;
import org.cardgame.help.ClickDetector;

public abstract class GuiButton extends DrawableObject implements Object {
    public Rectangle hitbox;

    public boolean clickable = true;

    public GuiButton(Texture texture, Vector2 pos) {
        super(texture, pos);
        hitbox = new Rectangle().x(pos.x())
                .y(pos.y()).width(texture.width())
                .height(texture.height());
    }

    // click detector
    ClickDetector clickDetector = new ClickDetector(this);

    public abstract void onClick();
    public abstract void onHover();
    public abstract void onHoverExit();
    public abstract void onMouseDown();

    public void showTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void draw() {
        DrawTextureV(this.texture, this.pos, Jaylib.WHITE);
    }

    @Override
    public void destroy() {
        UnloadTexture(this.texture);
    }

    @Override
    public void update() {
        // update the hitbox to the textures dimensions
        this.hitbox.x(this.pos.x()).y(this.pos.y())
                .width(this.texture.width()).height(this.texture.height());

        // clicking and hovering
        if (this.clickable)
            clickDetector.detect(this::onClick, this::onMouseDown, this::onHover, this::onHoverExit);
    }

    @Override
    public void _draw() {
        this.clickDetector.drawHitbox();
    }
}
