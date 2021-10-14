package task;
import java.util.Random;
public class Player {
    public int posX;
    public int posY;
    Random random = new Random();
    public Player() {
        this.posX = random.nextInt(10);
        this.posY = 0;
    }

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public void move(int posX, int posY){
        this.posX += posX;
        this.posY += posY;
    }
}