import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    public Arena(int width, int height) {
        hero = new Hero(10,10);
        this.width = width;
        this.height = height;
        this.walls = createWalls();
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
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

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#d9a8ff"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        this.hero.draw(graphics);
    }
    public boolean canHeroMove(Position position){
        for (Wall wall : walls){
            if (wall.getPosition().equals(position)){return false;}
        }
        return true;
    }
    private void moveHero(Position position) {
        if (canHeroMove(position)) {hero.setPosition(position);}
    }

}
