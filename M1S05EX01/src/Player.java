public class Player {
    /*
     * Attributes
     * */
    private String name;
    private int age;
    private double punctuation;
    private int numberAttempts;

    /*
     * Constructor
     * */

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.punctuation = 0;
        this.numberAttempts = 0;
    }

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
}
