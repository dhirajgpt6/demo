package capgemini.designpattern;

public class PlayerFactory {
    static {
        System.out.println("Static Block Executed");
    }
    public static Player createPlayer(String type, String name, int power) {
        System.out.println("STATIC CREATE PLAYER");
        System.out.println(type);
        System.out.println(name);
        System.out.println(power);
        if(!type.equalsIgnoreCase("fast") && !type.equalsIgnoreCase("slow")) {
            return null; // invalid type
        }
        return new GamePlayer(type, name, power);
    }
}
