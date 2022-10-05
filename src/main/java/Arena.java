import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10,10);
    }
    public boolean canHeroMove(Position position){
        if (position.getX() < 0 || position.getX() >= width) return false;
        if (position.getY() < 0 || position.getY() >= height) return false;
        return true;
    }
    private void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    public void processKey(KeyStroke key) throws IOException{
        switch (key.getKeyType()){
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
        }
    }
    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        this.hero.draw(graphics);
    }
}
