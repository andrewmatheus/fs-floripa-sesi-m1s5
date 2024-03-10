package M1S5EX1;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Andrew", 33);
        player1.addPoints(10);
        player1.addAttempt();
        player1.displayInformation();

        Player player2 = new Player("Miguel", 10);
        player2.addPoints(10);
        player2.addAttempt();
        player2.displayInformation();

    }
}