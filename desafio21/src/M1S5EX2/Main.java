package M1S5EX2;

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
                System.out.println("| (1) - Adicionar Jogador     |");
                System.out.println("+-----------------------------+");
                System.out.println("| (0) - Sair                  |");
                System.out.println("+-----------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        addPlayer(scan);
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

    public static void addPlayer(Scanner scan) {
        System.out.println("Digite o seu nome ou apelido: ");
        String namePlayer = scan.nextLine();

        System.out.println("Informe sua idade: ");
        int agePlayer = scan.nextInt();

        Player player = new Player(namePlayer, agePlayer);
        player.addPoints(10);
        player.addAttempt();

        System.out.println("\n+-----------------------------+");

        player.displayInformation();

        System.out.println("+-----------------------------+\n");
    }
}