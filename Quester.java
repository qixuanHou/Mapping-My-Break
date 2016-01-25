public class Quester {
    private String name;
    private int health;
    public Quester(String name, int startingHealth) {
        this.name = name;
        this.health = startingHealth;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void updateHealth(int n) {
        health = health + n;
    }
    public boolean isAlive() {
        return health > 0;
    }
}
