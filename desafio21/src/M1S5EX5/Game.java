package M1S5EX5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {
    // <editor-fold desc="Attributes">
    private List<Player> listOfPlayers;
    private List<Player> rankingPlayers;

    private String nameLogged;

    // <editor-fold desc="Constructor">
    public Game() {
        this.listOfPlayers = new ArrayList<>();
        this.rankingPlayers = new ArrayList<>();
        this.nameLogged = "";
    }
    // </editor-fold>

    // <editor-fold desc="methods">

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

    // </editor-fold>
}

