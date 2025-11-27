package capgemini.designpattern;

public class GamePlayer implements Player{
    private String type;
    private String name;
    private int power;
    private int speed;

    public GamePlayer(String type, String name, int power) {
        this.type = type;
        this.name = name;
        this.power = power;

        if(type.equalsIgnoreCase("fast")) {
            this.speed = power / 2;
        } else if(type.equalsIgnoreCase("slow")) {
            this.speed = power / 4;
        }
    }

    @Override
    public String attack() {
        return type.substring(0,1).toUpperCase() + type.substring(1).toLowerCase() +
                " Player " + name +
                " attacking with a speed of " + speed +
                " and a power of " + power;
    }
}
