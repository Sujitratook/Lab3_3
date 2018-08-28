import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner ac = new Scanner(System.in);
    private static int col, row;

    public static void input(){
        boolean canPut = true;
        do {
            System.out.print(ox.getCurrentPlayer() + " (Col: )");
            col = ac.nextInt();
            System.out.print(ox.getCurrentPlayer() + " (Row: )");
            row = ac.nextInt();
            canPut = ox.put(col, row);
            if (!canPut) {
                System.out.println("Please input number between 0-2");
            }
        }while (!canPut);
    }

    public static void printScore(){
        System.out.print(ox.getTableString());
        System.out.println("X win "+ox.getAtscoreX());
        System.out.println("O win "+ox.getAtscoreO());
        System.out.println("Draw win "+ox.getAtscoreDraw());
    }
    public static void main(String[] age){
        ox = new OX();
        while (true) {
            System.out.print(ox.getTableString());
            input();
            if (ox.Checkwin(col,row)){
                printScore();
                ox.reset();
                continue;
            }
            if (ox.isDraw()){
                printScore();
                ox.reset();
            }
            ox.Switchplayer();

        }
    }
}
