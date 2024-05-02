package org.cardgame.gameobjects.cards;

import com.raylib.Raylib;
import org.cardgame.gameobjects.Card;
import org.cardgame.gameobjects.other.CardTypes;

public class AceOfSpades extends Card {
    public AceOfSpades(Raylib.Vector2 pos) {
        super(pos, CardTypes.Spades);
    }
}
