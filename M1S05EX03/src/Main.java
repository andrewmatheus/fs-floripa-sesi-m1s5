import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        try {
            int optionSelected;

            System.out.println("*******************************");
            System.out.println("*          MINI GAMES         *");
            System.out.println("*******************************\n");

            do {
                System.out.println("+-----------------------------+");
                System.out.println("+       MENU - PRINCIPAL      +");
                System.out.println("+-----------------------------+");
                System.out.println("| (1) - Novo Jogo             |");
                System.out.println("+-----------------------------+");
                System.out.println("| (0) - Sair                  |");
                System.out.println("+-----------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        newGame(scan);
                        break;
                    case 0:
                        System.out.println("Obrigado volte sempre. Aplicação finalizada com sucesso!");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Informe uma opção do menu e tente novamente!");
                }
            } while (optionSelected != 0);

            scan.close();
        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }

    }

    public static void newGame(Scanner scan) {

        Game gameStart = new Game();

        int optionSelected;

        do {
            System.out.println("\n+--------------------------------+");
            System.out.println("+         Seja Bem Vindo         +");
            System.out.println("+--------------------------------+");
            System.out.println("| (1) - Informar Jogador         |");
            System.out.println("+--------------------------------+");
            System.out.println("| (0) - Sair do jogo             |");
            System.out.println("+--------------------------------+");
            System.out.print  ("Selecione uma opção: "     );

            optionSelected = scan.nextInt();

            switch (optionSelected) {
                case 1:
                    loginPlayer(gameStart, scan);
                    break;
                case 0:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
            }
        } while (optionSelected != 0);


    }

    public static void loginPlayer(Game gameStart, Scanner scan) {
        System.out.println("Digite o seu nome ou apelido: ");
        String namePlayer = scan.next();

        Player player;

        if (gameStart.checkPlayerExists(namePlayer)) {
            player = gameStart.getExistingPlayer(namePlayer);
        } else {
            System.out.println("Informe sua idade: ");
            int agePlayer = scan.nextInt();

            player = new Player(namePlayer, agePlayer);
        }

        gameStart.newPlayer(player);


        System.out.println("\n+-----------------------------+");

        gameStart.showTopPlayers();

        System.out.println("+-----------------------------+\n");

    }
}