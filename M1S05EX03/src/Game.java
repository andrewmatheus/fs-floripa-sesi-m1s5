import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {
    // <editor-fold desc="Attributes">
    private List<Player> listOfPlayers;
    private List<Player> rankingPlayers;

    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Game() {
        this.listOfPlayers = new ArrayList<>();
        this.rankingPlayers = new ArrayList<>();
    }
    // </editor-fold>

    // <editor-fold desc="methods">

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
        System.out.println("Melhores Jogadores:");
        for (int contList = 0; contList < this.rankingPlayers.size(); contList++) {
            Player player = this.rankingPlayers.get(contList);
            System.out.println((contList + 1) + ". " + player.getName() + " - Pontuação: " + player.getPunctuation());
        }
    }

    // </editor-fold>
}

