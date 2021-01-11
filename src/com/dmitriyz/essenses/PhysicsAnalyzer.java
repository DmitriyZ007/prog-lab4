package com.dmitriyz.essenses;

public class PhysicsAnalyzer {
    public void analyzeTrajectory(DiskType diskType, Jollier jollier) {
        if (diskType.equals(DiskType.Paraboloid)) {
            System.out.println(jollier.getName() + " летит по параболлической траектории");
            jollier.setAppetite(jollier.getAppetite() + 1);
        }
    }

    public void analyzePosition(Shorty shorty, Weather weather) {
        if (shorty.getPosition().equals(Position.AIR)) {
            System.out.println(shorty.getName() + " падает");
            shorty.fall(weather);
        } else if (shorty.getPosition().equals(Position.GROUND)) {
            System.out.println(shorty.getName() + " на твёрдой земле");
        } else {
            System.out.println(shorty.getName() + " в воде");
        }
    }

    @Override
    public String toString() {
        return "PhysicsAnalyzer{}";
    }
}
