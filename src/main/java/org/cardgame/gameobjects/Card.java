package org.cardgame.gameobjects;

import static com.raylib.Raylib.*;
import org.cardgame.gameobjects.bases.DrawableSpriteSheetObject;
import org.cardgame.help.Draggable;
import org.cardgame.help.texture.CardMaps;

public class Card extends DrawableSpriteSheetObject {
    public int type = 1;

    public Card(Vector2 pos, int type) {
        super(LoadTexture("textures/cards/cards-spritesheet.png"), pos, CardMaps.map[type]);
        this.type = type;
    }

    // creates a draggable class connected to this with the map
    Draggable draggable = new Draggable(this, this.map);

    @Override
    public void update() {
        draggable.updateDrag();
    }

    // only if debug drawing is true
    @Override
    public void _draw() {
        draggable.drawHitbox();
    }
}
