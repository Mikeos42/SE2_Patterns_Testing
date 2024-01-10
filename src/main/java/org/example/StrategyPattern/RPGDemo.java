interface WeaponBehavior {
    void useWeapon();
}

class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.print("Swinging a sword");
    }
}

class BowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.print("Shooting an arrow");
    }
}

class DaggerBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.print("Stabbing with dagger");
    }
}

interface EnchantmentBehavior {
    String getEnchantmentEffect();
}

class BurningEnchantment implements EnchantmentBehavior {
    @Override
    public String getEnchantmentEffect() {
        return "Burning";
    }
}

class FreezingEnchantment implements EnchantmentBehavior {
    @Override
    public String getEnchantmentEffect() {
        return "Freezing";
    }
}

class PoisonedEnchantment implements EnchantmentBehavior {

    @Override
    public String getEnchantmentEffect() {
        return "Poisoning";
    }
}

class NoEnchantment implements EnchantmentBehavior {

    @Override
    public String getEnchantmentEffect() {
        return "no";
    }
}

class Character {
    private WeaponBehavior weaponBehavior;
    private EnchantmentBehavior enchantmentBehavior;

    public Character(WeaponBehavior weaponBehavior, EnchantmentBehavior enchantmentBehavior) {
        this.weaponBehavior = weaponBehavior;
        this.enchantmentBehavior = enchantmentBehavior;
    }

    public Character(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
        this.enchantmentBehavior = new NoEnchantment();
    }

    void useWeapon() {
        weaponBehavior.useWeapon();
        System.out.println(" with " + enchantmentBehavior.getEnchantmentEffect() + " effect.\n");
    }
}

// Usage
public class RPGDemo {
    public static void main(String[] args) {
        Character warrior = new Character(new SwordBehavior(), new BurningEnchantment());
        warrior.useWeapon();

        Character archer = new Character(new BowBehavior(), new FreezingEnchantment());
        archer.useWeapon();

        Character assassin = new Character(new DaggerBehavior(), new PoisonedEnchantment());
        assassin.useWeapon();

        Character inexperienced_assassin = new Character(new DaggerBehavior());
        inexperienced_assassin.useWeapon();
    }
}
