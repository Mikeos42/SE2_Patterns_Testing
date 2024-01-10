package org.example.StrategyPattern;

public class StrategyRPGDemo {
    interface DoDamage {
        void dealDamage(int damage);
    }

    static class WeaponBase {
        int damage = 0;
        DoDamage damageType;

        void attack() {
            damageType.dealDamage(damage);
        }
    }

    static class FireDamage implements DoDamage {

        @Override
        public void dealDamage(int damage) {
            System.out.println("Dealing " + damage + " fire damage");
        }
    }

    static class IceDamage implements DoDamage {

        @Override
        public void dealDamage(int damage) {
            System.out.println("Dealing " + damage + " ice damage");
        }
    }

    static class FireSword extends WeaponBase {
        public FireSword() {
            damageType = new FireDamage();
            damage = 10;
        }
    }

    public static void main(String[] args) {
        WeaponBase sword = new FireSword();
        sword.attack();
    }
}
