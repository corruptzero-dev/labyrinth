package task;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String PLAYER = "•";
    private static final String WALL = "▩";
    private static final String PASS = "◻";
    private static int initialPos = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] maze = genArr();
        printMaze(maze);
        int currentPosX=initialPos;
        int currentPosY=0;
        while (true){
            String move = scanner.next();
            if(move.equalsIgnoreCase("w") && (maze[0][initialPos]!=2) && (maze[currentPosY-1][currentPosX] != 1)){
                maze[currentPosY][currentPosX] = 0;
                maze[currentPosY-1][currentPosX] = 2;
                currentPosY--;
            } else if(move.equalsIgnoreCase("a") && (currentPosX!=0) && (maze[currentPosY][currentPosX-1] != 1)){
                maze[currentPosY][currentPosX] = 0;
                maze[currentPosY][currentPosX-1] = 2;
                currentPosX--;
            } else if(move.equalsIgnoreCase("s") && currentPosY!=4 && (maze[currentPosY+1][currentPosX] != 1)){
                maze[currentPosY][currentPosX] = 0;
                maze[currentPosY+1][currentPosX] = 2;
                currentPosY++;
            } else if(move.equalsIgnoreCase("d") && (currentPosX!=4) && (maze[currentPosY][currentPosX+1] != 1)){
                maze[currentPosY][currentPosX] = 0;
                maze[currentPosY][currentPosX+1] = 2;
                currentPosX++;

            } else if(currentPosY == 4 && move.equalsIgnoreCase("s")){
                System.out.println("Вы выиграли!");
                break;
            } else {
                System.out.println("Неверный ход!");
            }
            printMaze(maze);
        }

    }
    public static void printMaze(int[][] maze){
        for(int[] array:maze){
            for(int value:array){
                if (value == 0){
                    System.out.print(PASS);
                } else if (value == 1){
                    System.out.print(WALL);
                } else if (value==2){
                    System.out.print(PLAYER);
                }
            }
            System.out.println();
        }
    }
    public static int[][] genArr() {
        //0 пусто 1 стена 2 игрок
        Random random = new Random();
        int[][] maze = new int[5][5];
        int position = random.nextInt(5);
        initialPos = position;
        maze[0][position] = 2;
        if (position%2==0){
            for (int i = 0; i < 5; i++) {
                if (i%2 != 0){
                    maze[1][i] = 1;
                } else {
                    maze[1][i] = 0;
                }
            }
            for (int i = 0; i < 2; i++) {
                int wall2 = random.nextInt(5);
                maze[2][wall2] = 1;
            }
            for (int i = 0; i < 5; i++) {
                if(maze[2][i]==1){
                    maze[3][i] = 0;
                } else {
                    maze[3][i] = 1;
                    break;
                }
            }
            for (int i = 0; i < 5; i++) {
                if(i%2==0){
                    maze[4][i]=0;
                } else {
                    maze[4][i]=1;
                }
            }
        } else {
            for (int i = 0; i < 5; i++) {
                if (i%2==0){
                    maze[1][i]=1;
                } else {
                    maze[1][i]=0;
                }

            }
            for (int i = 0; i < 2; i++) {
                int wall2 = random.nextInt(5);
                maze[2][wall2] = 1;
            }
            for (int i = 0; i < 5; i++) {
                if(maze[2][i]==1){
                    maze[3][i] = 0;
                } else {
                    maze[3][i] = 1;
                    break;
                }
            }
            for (int i = 0; i < 5; i++) {
                if(i%2==0){
                    maze[4][i]=0;
                } else {
                    maze[4][i]=1;
                }
            }
        }
        return maze;
    }
}
