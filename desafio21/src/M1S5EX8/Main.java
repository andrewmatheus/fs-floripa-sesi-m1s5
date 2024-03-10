package M1S5EX8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Game gameStart = new Game();

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
                        newGame(scan, gameStart);
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

    public static void newGame(Scanner scan, Game gameStart) {

        int optionSelected;

        do {
            System.out.println("\n+--------------------------------+");
            System.out.println("+         Seja Bem Vindo         +");
            System.out.println("+--------------------------------+");
            System.out.println("| (1) - Novo Jogador             |");
            System.out.println("| (2) - Selecionar Mini Game     |");
            System.out.println("+--------------------------------+");
            System.out.println("| (0) - Sair do jogo             |");
            System.out.println("+--------------------------------+");
            System.out.print  ("Selecione uma opção: "     );

            optionSelected = scan.nextInt();

            switch (optionSelected) {
                case 1:
                    newPlayer(gameStart, scan);
                    break;
                case 2:
                    selectedMiniGame(gameStart, scan);
                    break;
                case 0:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
            }
        } while (optionSelected != 0);


    }

    public static void newPlayer(Game gameStart, Scanner scan) {
        System.out.println("Digite o seu nome ou apelido: ");
        String namePlayer = scan.next();

        Player player;

        while (gameStart.checkPlayerExists(namePlayer)) {
            System.out.println("Jogador com o nome '" + namePlayer + "' já existe. Escolha outro nome:");
            namePlayer = scan.next();
        }

        if (gameStart.checkPlayerExists(namePlayer)) {
            player = gameStart.getExistingPlayer(namePlayer);
        } else {
            System.out.println("Informe sua idade: ");
            int agePlayer = scan.nextInt();

            player = new Player(namePlayer, agePlayer);
        }

        gameStart.setNameLogged(player.getName());

        gameStart.newPlayer(player);

    }

    public static void menuPlayer(Game gameStart, Scanner scan, Player player) {

        try {
            int optionSelected;
            do {
                System.out.println("\nJOGADOR: " + gameStart.getNameLogged());
                System.out.println("+--------------------------------+");
                System.out.println("+ Qual Jogo deseja jogar?        +");
                System.out.println("+--------------------------------+");
                System.out.println("|                                |");
                System.out.println("| (1) - Pedra, Papel e Tesoura   |");
                System.out.println("| (2) - Sexto Sentido            |");
                System.out.println("|                                |");
                System.out.println("+--------------------------------+");
                System.out.println("| (0) - Voltar ao menu anterior  |");
                System.out.println("+--------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        gameRockPaperScissors(gameStart, player, scan);
                        break;
                    case 2:
                        sixthSense(gameStart, player, scan);
                        break;
                    case 0:
                        System.out.println("Deslogado com sucesso!");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);

        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    public static void selectedMiniGame (Game gameStart, Scanner scan) {
        Player player;

        System.out.println("Olá, seja bem vindo!");
        System.out.println("Informe seu nome para acessar: ");
        String name = scan.next().trim();
        while (name.length() <= 3) {
            System.out.println("Informe um nome ou apelido válido! Informe acima de 3 letras.");
            System.out.println("Informe seu nome para acessar: ");
            name = scan.next().trim();
        }

        if (gameStart.checkPlayerExists(name)) {
           player = gameStart.getExistingPlayer(name);
        } else {
            System.out.println("Informe sua idade: ");
            int agePlayer = scan.nextInt();

            player = new Player(name, agePlayer);
        }

        gameStart.setNameLogged(player.getName());

        gameStart.newPlayer(player);

        menuPlayer(gameStart, scan, player);
    }

    public static void sixthSense(Game gameStart, Player player, Scanner scan) {
        System.out.println("Olá, seja bem vindo ao sexto sentido!");
        System.out.println("Será que você consegue advinhar qual número foi o escolhido?");
        System.out.println("Vamos deixar você definir um limite.");
        System.out.println("exemplo: 100 e iremos selecionar um número entre 0 e 100, quanto maior o número maior o desafio. Vamos começar?");
        System.out.println("\nQual número limite você escolheu?");
        int numberChallenge = scan.nextInt();

        while (numberChallenge <= 0) {
            System.out.println("Informe um número maior que 0 para que possamos criar o desafio! Exemplo: 10");
            numberChallenge = scan.nextInt();
        }

        gameStart.toPlayer(player, numberChallenge, scan);

        try {
            int optionSelected;
            do {
                System.out.println("\nJOGADOR: " + gameStart.getNameLogged());
                System.out.println("+--------------------------------+");
                System.out.println("|                                |");
                System.out.println("| (1) - Jogar novamente?         |");
                System.out.println("|                                |");
                System.out.println("+--------------------------------+");
                System.out.println("| (0) - Encerrar jogo            |");
                System.out.println("+--------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        System.out.println("Olá, seja bem vindo ao sexto sentido!");
                        System.out.println("Será que você consegue advinhar qual número foi o escolhido?");
                        System.out.println("Vamos deixar você definir um limite.");
                        System.out.println("exemplo: 100 e iremos selecionar um número entre 0 e 100, quanto maior o número maior o desafio. Vamos começar?");
                        System.out.println("\nQual número limite você escolheu?");
                        numberChallenge = scan.nextInt();

                        while (numberChallenge <= 0) {
                            System.out.println("Informe um número maior que 0 para que possamos criar o desafio! Exemplo: 10");
                            numberChallenge = scan.nextInt();
                        }

                        gameStart.toPlayer(player, numberChallenge, scan);
                        break;
                    case 0:
                        System.out.println("Deslogado com sucesso!");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);

        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    public static void gameRockPaperScissors(Game gameStart, Player player, Scanner scan) {
        System.out.println("Informe sua jogada: \"pedra\", \"papel\", \"tesoura\"");
        String attempt = scan.next().trim().toLowerCase();

        while (!attempt.equals("pedra") && !attempt.equals("papel") && !attempt.equals("tesoura")) {
            System.out.println("Informe uma jogada válida. Opções: \"pedra\", \"papel\", \"tesoura\"");
            attempt = scan.next().trim().toLowerCase();
        }


        gameStart.toPlayer(player, attempt);

        try {
            int optionSelected;
            do {
                System.out.println("\nJOGADOR: " + gameStart.getNameLogged());
                System.out.println("+--------------------------------+");
                System.out.println("|                                |");
                System.out.println("| (1) - Jogar novamente?         |");
                System.out.println("|                                |");
                System.out.println("+--------------------------------+");
                System.out.println("| (0) - Encerrar jogo            |");
                System.out.println("+--------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        System.out.println("Informe sua jogada: \"pedra\", \"papel\", \"tesoura\"");
                        attempt = scan.next().trim().toLowerCase();

                        while (!attempt.equals("pedra") && !attempt.equals("papel") && !attempt.equals("tesoura")) {
                            System.out.println("Informe uma jogada válida. Opções: \"pedra\", \"papel\", \"tesoura\"");
                            attempt = scan.next().trim().toLowerCase();
                        }

                        gameStart.toPlayer(player, attempt);
                        break;
                    case 0:
                        System.out.println("Deslogado com sucesso!");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);

        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    public static void finishMiniGame(Game gameStart) {
        System.out.println("\n+-----------------------------+");
        gameStart.showTopPlayers();
        System.out.println("+-----------------------------+\n");
    }
}