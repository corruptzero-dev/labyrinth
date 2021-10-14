package task;

import java.util.Random;
import java.util.Scanner;

public class Maze {
    int size;
    int[][] maze;
    private static final String WALL = "▩";
    private static final String PASS = "◻";
    private static final String PLAYER = "●";
    Scanner scanner = new Scanner(System.in);
    public Maze() {
        System.out.print("Введите размер поля: ");
        this.size = scanner.nextInt();
        maze = new int[size][size];
        genWalls();
    }
    public void printMaze(){
        for(int[] array:this.maze){
            for(int value:array){
                if (value==0){
                    System.out.print(PASS);
                } else if (value == 1) {
                    System.out.print(WALL);
                } else if (value == 2){
                    System.out.print(PLAYER);
                }
            }
            System.out.println();
        }
    }
    private void genWalls(){
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (j%2==1){
                    this.maze[i][j] = random.nextInt(2);
                } else {
                    for (int k = 0; k < size/2; k++) {
                        this.maze[k][j] = random.nextInt(2);
                    }
                }

            }
        }
    }
}