package com.dmitriyz;

import com.dmitriyz.essenses.*;
import com.dmitriyz.exceptions.DiskException;
import com.dmitriyz.exceptions.PositionException;
import com.dmitriyz.exceptions.ShaftException;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        PhysicsAnalyzer physicsAnalyzer = new PhysicsAnalyzer();

        Weather weather = Weather.HOT;

        ArrayList<Jollier> jolliers = new ArrayList<>();
        jolliers.add(new Jollier("Спрутс", Circs.POOR, 30));
        jolliers.add(new Jollier("Дубс", Circs.POOR, 40));
        jolliers.add(new Donut(34));
        jolliers.add(new Plutocrat("Грязинг", 32));
        jolliers.add(new Plutocrat("Дрянинг", 37));
        jolliers.add(new Plutocrat("Скуперфильд", 39));
        System.out.println();

        FerrisWheel ferrisWheel1 = new FerrisWheel("EarthQuake");
        ferrisWheel1.setShaft(ferrisWheel1.new Shaft("Стержень1"));
        FerrisWheel ferrisWheel2 = new FerrisWheel("RoarFlame");
        ferrisWheel2.setShaft(ferrisWheel1.new Shaft("Стержень2"));
        FerrisWheel[] ferrisWheels = new FerrisWheel[]{ferrisWheel1, ferrisWheel2};
        System.out.println();

        SeaFerrisWheel seaFerrisWheel1 = new SeaFerrisWheel("DragonForce");
        seaFerrisWheel1.setShaft(seaFerrisWheel1.new Shaft("Стержень3"));
        SeaFerrisWheel seaFerrisWheel2 = new SeaFerrisWheel("RoyalScramble");
        //seaFerrisWheel2.setShaft(seaFerrisWheel2.new Shaft("Стержень4"));
        SeaFerrisWheel[] seaFerrisWheels = new SeaFerrisWheel[]{seaFerrisWheel1, seaFerrisWheel2};
        System.out.println();

        SeaParaboloid seaParaboloid1 = new SeaParaboloid("RearPunch");
        seaParaboloid1.setShaft(seaParaboloid1.new Shaft("Стержень5"));
        SeaParaboloid seaParaboloid2 = new SeaParaboloid("SpaceStellar");
        seaParaboloid2.setShaft(seaParaboloid2.new Shaft("Стержень6"));
        SeaParaboloid[] seaParaboloids = new SeaParaboloid[]{seaParaboloid1, seaParaboloid2};
        System.out.println();

        FerrisWheel[] attractions = new FerrisWheel[]{
                ferrisWheel1, ferrisWheel2,
                seaFerrisWheel1, seaFerrisWheel2,
                seaParaboloid1, seaParaboloid2
        };

        for (Jollier jollier : jolliers) {
            jollier.sayHi();
            Random random = new Random();
            Attraction attraction = jollier.chooseAttraction(
                    ferrisWheels[random.nextInt(2)],
                    seaFerrisWheels[random.nextInt(2)],
                    seaParaboloids[random.nextInt(2)]);
            jollier.goToAttraction(attraction);
            try {
                jollier.sitInCenter(attraction);
            } catch (PositionException positionException) {
                positionException.printStackTrace();
                System.err.println(jollier.getName() + " не рядом с аттракционом");
                System.err.println();
            }
            System.out.println();
        }
        for (FerrisWheel attraction : attractions) {
            try {
                attraction.disk.startRotating();
            } catch (ShaftException shaftException) {
                shaftException.printStackTrace();
                System.err.println(attraction.getNAME() + ": Отсутствует ось");
                System.err.println();
            }
            try {
                attraction.exitQueue();
            } catch (DiskException diskException) {
                diskException.printStackTrace();
                System.err.println(attraction.getNAME() + ": Диск не вращается");
                System.err.println();
            }
            System.out.println();
            attraction.disk.stopRotating();
            System.out.println();
            for (Jollier jollier : attraction.getPassengersOnBoard()) {
                physicsAnalyzer.analyzeTrajectory(attraction.disk.getTYPE(), jollier);
                physicsAnalyzer.analyzePosition(jollier, weather);
                try {
                    jollier.goOutWater();
                } catch (PositionException positionException) {
                    positionException.printStackTrace();
                    System.err.println(jollier.getName() + " уже на берегу");
                    System.err.println();
                }
                jollier.sayAboutHunger();
                jollier.sayAboutHappiness();
                jollier.sayBye();
                System.out.println();
            }
        }
    }
}
