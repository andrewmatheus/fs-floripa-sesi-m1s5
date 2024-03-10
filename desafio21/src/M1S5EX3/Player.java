package M1S5EX3;

public class Player {
    // <editor-fold desc="Attributes">
    private String name;
    private int age;
    private double punctuation;
    private int numberAttempts;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.punctuation = 0;
        this.numberAttempts = 0;
    }
    // </editor-fold>

    // <editor-fold desc="methods">

    // <editor-fold desc="methods-attributes">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(double punctuation) {
        this.punctuation = punctuation;
    }

    public int getNumberAttempts() {
        return numberAttempts;
    }

    public void setNumberAttempts(int numberAttempts) {
        this.numberAttempts = numberAttempts;
    }
    // </editor-fold>

    // <editor-fold desc="methods-player">

    public void addPoints(int points) {
        this.punctuation += points;
    }

    public void losePoints(int points) {
        this.punctuation -= points;

        if (this.punctuation < 0) {
            this.punctuation = 0;
        }
    }

    public void addAttempt() {
        this.numberAttempts++;
    }

    public void displayInformation() {
        System.out.println("Nome: " + this.name);
        System.out.println("Idade: " + this.age);
        System.out.println("Pontuação: " + this.punctuation);
        System.out.println("Número de Tentativas: " + this.numberAttempts);
    }

    // </editor-fold>

    // </editor-fold>
}
