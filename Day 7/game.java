import java.util.*;

class Character {
    String name;

    Character(String name) {
        this.name = name;
    }

    void attack() {
        System.out.println(name + " attacks");
    }
}

class Warrior extends Character {

    Warrior(String name) {
        super(name);
    }

    @Override
    void attack() {
        System.out.println(name + " attacks with sword");
    }
}

class Archer extends Character {

    Archer(String name) {
        super(name);
    }

    @Override
    void attack() {
        System.out.println(name + " attacks with arrow");
    }
}

class Mage extends Character {

    Mage(String name) {
        super(name);
    }

    @Override
    void attack() {
        System.out.println(name + " attacks with magic");
    }
}

public class game {
    public static void main(String args[]) {

        Character c;

        c = new Warrior("THOR");
        c.attack();

        c = new Archer("LEGOLAS");
        c.attack();

        c = new Mage("GANDALF");
        c.attack();
    }
}
