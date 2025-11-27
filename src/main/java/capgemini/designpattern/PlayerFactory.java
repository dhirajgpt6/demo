package capgemini.designpattern;

public class PlayerFactory {
    public static Player createPlayer(String type, String name, int power) {
        if(!type.equalsIgnoreCase("fast") && !type.equalsIgnoreCase("slow")) {
            return null; // invalid type
        }
        return new GamePlayer(type, name, power);
    }
}
