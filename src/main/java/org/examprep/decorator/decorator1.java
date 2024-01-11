package org.examprep.decorator;

class Beverage1 {
    String description;
    boolean milk, soy, mocha, whip;

    public Beverage1(String description) {
        milk = soy = mocha = whip = false;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean isWhip() {
        return whip;
    }

    public void setWhip(boolean whip) {
        this.whip = whip;
    }

    public int cost() {
        int cost = 0;
        if(milk) {
            cost += 1;
        }
        if(soy) {
            cost += 2;
        }
        if (mocha) {
            cost += 1;
        }
        if (whip) {
            cost += 3;
        }
        return cost;
    }
}

class Matcha extends Beverage1 {
    public Matcha(String description) {
        super(description);
    }

    @Override
    public int cost() {
        return super.cost() + 15;
    }
}

public class decorator1 {
    public static void main(String[] args) {
        Beverage1 MatchaLatte = new Matcha("Matcha Late");
        MatchaLatte.setMilk(true);

        System.out.println(MatchaLatte.cost());
    }
}
