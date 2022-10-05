import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Hero hero;
    public Game(){
        try {
            hero = new Hero(10, 10);
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException{
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }
    public void run() throws IOException{
        while(true){
        draw();
        KeyStroke key = screen.readInput();
        processKey(key);
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){screen.close();}
        if (key.getKeyType() == KeyType.EOF) {
            break;}
        }
    }
    private void processKey(KeyStroke key) throws IOException{
        switch (key.getKeyType()){
            case ArrowRight:
                hero.moveRight();
                break;
            case ArrowLeft:
                hero.moveLeft();
                break;
            case ArrowUp:
                hero.moveUp();
                break;
            case ArrowDown:
                hero.moveDown();
                break;
        }
    }
}
