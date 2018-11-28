package falloutgame;

import java.util.ArrayList;

public class Weapons {
    final public static int NUM_WEAPONS = 5;    
    private static int numWeapons = 0;    
    private String name;
    private int damage;
    
//    public static Weapons Create(String _name, int _damage) {
//        Weapons ptr = new Weapons(_name,_damage);
//        weapons.add(ptr);
//        return (ptr);
//    }    
    public static int GetNumWeapons() {
        return(numWeapons);
    }
    Weapons() {
        name = "fists";
        damage = 7;
    }
    Weapons(String _name, int _damage) {
        name = _name;
        damage = _damage;
    }
    public String getName() {
        return(name);
    }
    public int getDamage() {
        return(damage);
    }    
}
