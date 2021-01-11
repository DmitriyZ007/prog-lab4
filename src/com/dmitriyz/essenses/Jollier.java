package com.dmitriyz.essenses;

import com.dmitriyz.actions.IAttractionActions;
import com.dmitriyz.exceptions.PositionException;

import java.util.Random;

public class Jollier extends Shorty implements IAttractionActions {

    public Jollier(String name, Circs circs, int mass) {
        super(name, circs, mass);
    }

    @Override
    public void sitInCenter(Attraction attraction) throws PositionException {
        if (getPosition().equals(attraction.getPosition())) {
            attraction.addPassengerOnBoard(this);
            System.out.println(getName() + " сел в центре диска аттракциона " + attraction.getNAME());
        } else throw new PositionException();
    }

    @Override
    public void goToAttraction(Attraction attraction) {
        if (getPosition() != attraction.getPosition()) {
            if (getPosition().equals(Position.GROUND)) {
                try {
                    goToWater();
                } catch (PositionException positionException) {
                    System.err.println(getName() + " уже в воде");
                }
            } else if (getPosition().equals(Position.WATER)) {
                try {
                    goOutWater();
                } catch (PositionException positionException) {
                    System.err.println(getName() + " уже на берегу");
                }
            }
        }
        System.out.println(getName() + " рядом с аттракционом " + attraction.getNAME());
    }

    @Override
    public Attraction chooseAttraction(FerrisWheel ferrisWheel, SeaFerrisWheel seaFerrisWheel, SeaParaboloid seaParaboloid) {
        Random random = new Random();
        System.out.println(getName() + " выбирает случайный аттракцион");
        switch (random.nextInt(3)) {
            case 0:
                return ferrisWheel;
            case 1:
                return seaFerrisWheel;
            default:
                return seaParaboloid;
        }
    }
}
