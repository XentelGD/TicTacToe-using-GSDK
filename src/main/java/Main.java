import gsdk.*;
import gsdk.mwidgets.Listener;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.window.VideoMode;

import java.util.HashMap;


public class Main
{
    public static boolean gameOver = false;

    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(300, 300), "MyWindow", 4); // 4 makes the window non-resizable


        Field.create(); // creating the game field

        while (App.window.isOpen()) {
            App.checkEvents();
            App.window.clear();


            // horizontal
            for (int y = 0; y < 3; y++) {
                for (int sign = 1; sign < 3; sign++) {
                    if (Field.data[0][y] == sign && Field.data[1][y] == sign && Field.data[2][y] == sign) {
                        Field.buttons[0][y].normalColor = new Color(255, 0, 0, 70);
                        Field.buttons[1][y].normalColor = new Color(255, 0, 0, 70);
                        Field.buttons[2][y].normalColor = new Color(255, 0, 0, 70);
                        gameOver = true;
                        break;
                    }
                }
            }

            // vertical
            for (int x = 0; x < 3; x++) {
                for (int sign = 1; sign < 3; sign++) {
                    if (Field.data[x][0] == sign && Field.data[x][1] == sign && Field.data[x][2] == sign) {
                        Field.buttons[x][0].normalColor = new Color(255, 0, 0, 70);
                        Field.buttons[x][1].normalColor = new Color(255, 0, 0, 70);
                        Field.buttons[x][2].normalColor = new Color(255, 0, 0, 70);
                        gameOver = true;
                        break;
                    }
                }
            }

            // diagonal
            for (int sign = 1; sign < 3; sign++) {
                if (Field.data[0][0] == sign && Field.data[1][1] == sign && Field.data[2][2] == sign) {
                    Field.buttons[0][0].normalColor = new Color(255, 0, 0, 70);
                    Field.buttons[1][1].normalColor = new Color(255, 0, 0, 70);
                    Field.buttons[2][2].normalColor = new Color(255, 0, 0, 70);
                    gameOver = true;
                    break;
                }
                if (Field.data[2][0] == sign && Field.data[1][1] == sign && Field.data[0][2] == sign) {
                    Field.buttons[2][0].normalColor = new Color(255, 0, 0, 70);
                    Field.buttons[1][1].normalColor = new Color(255, 0, 0, 70);
                    Field.buttons[0][2].normalColor = new Color(255, 0, 0, 70);
                    gameOver = true;
                    break;
                }
            }

            Field.update();

            App.window.display();
        }
    }
}