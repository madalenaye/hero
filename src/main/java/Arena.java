import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

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
    public void draw(Screen screen) throws IOException {
        screen.setCharacter(hero.getPosition().getX(), hero.getPosition().getY(), TextCharacter.fromCharacter('X')[0]);
    }
    private void moveHero(Position position) {
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
}
