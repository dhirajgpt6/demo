package capgemini.designpattern;

public class Main {
    public static void main(String[] args) {
        String type  = "fast";
        String name =  "A";
        int power = 20;
        Player player = PlayerFactory.createPlayer(type, name, power);
        System.out.println(player.attack());
    }
}
