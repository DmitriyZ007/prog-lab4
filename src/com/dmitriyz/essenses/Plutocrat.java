package com.dmitriyz.essenses;

import java.util.Random;

public class Plutocrat extends Jollier {
    public Plutocrat(String name, int mass) {
        super(name, Circs.WEALTHY, mass);
    }
    @Override
    public Attraction chooseAttraction(FerrisWheel ferrisWheel, SeaFerrisWheel seaFerrisWheel, SeaParaboloid seaParaboloid) {
        Random random = new Random();
        System.out.println(getName() + " выбирает случайный аттракцион, скорее всего он выберет Морской Параболлоид");
        switch (random.nextInt(5)){
            case 0:
                return ferrisWheel;
            case 1:
                return seaFerrisWheel;
            default:
                return seaParaboloid;
        }
    }
}
