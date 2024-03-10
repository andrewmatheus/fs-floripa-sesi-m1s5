package M1S5EX6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Game {
    // <editor-fold desc="Attributes">
    private List<Player> listOfPlayers;
    private List<Player> rankingPlayers;
    private String nameLogged;
    private Player bestPlayer;
    private int numberOfGames;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Game() {
        this.listOfPlayers = new ArrayList<>();
        this.rankingPlayers = new ArrayList<>();
        this.nameLogged = "";
        this.bestPlayer = null;
        this.numberOfGames = 0;
    }
    // </editor-fold>

    // <editor-fold desc="methods">

    public Player getBestPlayer() {
        return bestPlayer;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public String getNameLogged() {
        return nameLogged;
    }

    public void setNameLogged(String nameLogged) {
        this.nameLogged = nameLogged;
    }

    public void newPlayer(Player player) {
        this.listOfPlayers.add(player);
        updateRanking();
    }

    public boolean checkPlayerExists(String name) {
        for (Player player : this.listOfPlayers) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Player getExistingPlayer(String name) {
        for (Player player : this.listOfPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void updateRanking() {
        // Ordena a lista de jogadores por pontuação em ordem decrescente
        this.listOfPlayers.sort(Comparator.comparingDouble(Player::getPunctuation).reversed());

        // Atualiza a lista de melhores jogadores com os top N (por exemplo, top 10)
        int topN = 10;
        this.rankingPlayers = new ArrayList<>(listOfPlayers.subList(0, Math.min(topN, listOfPlayers.size())));
    }

    public void showTopPlayers() {
        System.out.println("Ranking dos Melhores Jogadores:");
        int position = -1;
        for (int contList = 0; contList < this.rankingPlayers.size(); contList++) {
            Player player = this.rankingPlayers.get(contList);
            System.out.println("Nome do jogador: " + player.getName() + " - Posição: " + (contList + 1) + "º" + " - Pontuação: " + player.getPunctuation());

            if (player.getName().equals(this.nameLogged)) {
                position = (contList + 1);
            }
        }

        System.out.println("-------------------------------");
        if (position > 0) {
            System.out.println("Parabéns " + this.nameLogged + " você terminou na posição: " + position);
        } else {
            System.out.println("Tente novamente " + this.nameLogged + ", você terminou fora do ranking.");
        }

    }

    // método jogar()
    public void gameRockPaperScissors(Player player, String attempt) {
        System.out.println("Rodada: " + getNumberOfGames());

        Random random = new Random();
        String[] options = {"pedra", "papel", "tesoura"};
        String playComputer = options[random.nextInt(options.length)];

        System.out.println("\nJogador " + player.getName() + " escolheu: " + attempt);
        System.out.println("Computador escolheu: " + playComputer);

        if (attempt.equals(playComputer)) {
            player.addPoints(1);
            System.out.println("Empate!");
        } else if ((attempt.equals("pedra") && playComputer.equals("tesoura")) ||
                (attempt.equals("papel") && playComputer.equals("pedra")) ||
                (attempt.equals("tesoura") && playComputer.equals("papel"))) {
            System.out.println("Parabéns! Você ganhou a partida.");
            player.addPoints(10);
        } else {
            player.losePoints(5);
            System.out.println("Ops! Você perdeu.");
        }

        player.addAttempt();
        setNumberOfGames(getNumberOfGames() + 1);

        if (bestPlayer == null || player.getPunctuation() > bestPlayer.getPunctuation()) {
            bestPlayer = player;
        }

        System.out.println("Melhor jogador rankeado até o momento: " + bestPlayer.getName() + ", com a pontuação: " + bestPlayer.getPunctuation());
    }

    // </editor-fold>
}

