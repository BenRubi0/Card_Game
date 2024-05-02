package org.cardgame.help;

import com.raylib.Jaylib;
import org.cardgame.gameobjects.bases.DrawableObject;
import org.cardgame.gameobjects.bases.DrawableSpriteSheetObject;

import static com.raylib.Raylib.*;

public class Draggable {
    Rectangle hitbox;
    DrawableObject object;

    public Draggable(DrawableObject object) {
        this.hitbox = new Rectangle().x(object.pos.x()).y(object.pos.y()).width(object.texture.width()).height(object.texture.height());
        this.object = object;
    }

    public Draggable(DrawableSpriteSheetObject spriteSheetObject, Rectangle map) {
        this.hitbox = new Rectangle().x(spriteSheetObject.pos.x()).y(spriteSheetObject.pos.y()).width(spriteSheetObject.map.width()).height(spriteSheetObject.map.height());
        this.object = spriteSheetObject;
    }

    public void updatePosDrag(Vector2 pos) {
        this.hitbox.x(pos.x() - this.hitbox.width()/2).y(pos.y() - this.hitbox.height()/2);
        object.pos.x(pos.x() - this.hitbox.width()/2).y(pos.y() - this.hitbox.height()/2);
    }

    public void detectDrag() {
        Vector2 mousePosition = GetMousePosition();
        boolean colliding = CheckCollisionPointRec(mousePosition, this.hitbox);
        if (colliding)
            if (IsMouseButtonDown(MOUSE_BUTTON_LEFT)) {
                if (Mouse.objectDragging == null || Mouse.objectDragging == this.object) {
                    updatePosDrag(new Vector2().x(GetMouseX() - GetMouseDelta().x()).y(GetMouseY() - GetMouseDelta().y()));
                    Mouse.objectDragging = this.object;
                }
            } else if (!IsMouseButtonDown(MOUSE_BUTTON_LEFT))
                Mouse.objectDragging = null;
    }

    public void updateDrag() {
        this.detectDrag();
    }

    public void drawHitbox() {
        DrawRectangleLinesEx(this.hitbox, 5.0f, Jaylib.RED);
    }
}
