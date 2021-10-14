package task;

import java.util.Scanner;

public class Game {
    public static void play(){
        Scanner scanner = new Scanner(System.in);
        Maze m = new Maze();
        Player p = new Player();
        m.maze[p.posY][p.posX] = 2;
        System.out.println("""
                Добро пожаловать в игру 'Лабиринт'.
                Вы - точка в первом ряду.
                Ваша цель - выйти из нижнего ряда лабиринта.
                Не врезайтесь в стены и не пытайтесь выйти с боков лабиринта.
                Удачи!
                """);
        m.printMaze();
        while(p.posY<m.size){
            String move = scanner.next();
            int prevY = p.getPosY();
            int prevX = p.getPosX();
            m.maze[prevY][prevX] = 0;
            if(move.equalsIgnoreCase("w") && (p.posY!=0) && (m.maze[p.posY-1][p.posX]!=1)){
                p.move(0,-1);
            } else if(move.equalsIgnoreCase("a") && (p.posX!=0) && (m.maze[p.posY][p.posX-1]!=1)){
                p.move(-1,0);
            } else if(move.equalsIgnoreCase("s") && (p.posY!=m.size-1) && (m.maze[p.posY+1][p.posX]!=1)){
                p.move(0,1);
            } else if(move.equalsIgnoreCase("d") && (p.posX!=m.size-1) && (m.maze[p.posY][p.posX+1]!=1)){
                p.move(1,0);
            } else if(p.posY == m.size-1 && move.equalsIgnoreCase("s")){
                System.out.println("Вы выиграли!");
                break;
            } else {
                System.out.println("Неверный ход!");
            }
            m.maze[p.posY][p.posX] = 2;
            m.printMaze();
        }
    }
}
