package com.dmitriyz.essenses;

public class SeaParaboloid extends SeaFerrisWheel {
    public SeaParaboloid(String name) {
        super(name, DiskType.Paraboloid, Position.WATER);
    }

    protected SeaParaboloid(String name, DiskType diskType, Position position) {
        super(name, diskType, position);
    }

    @Override
    protected void throwObjectCompletely(Shorty shorty) {
        System.out.println(shorty.getName() + " подлетел в воздух с диска " + this.getNAME()
                + " типа " + disk.getTYPE().getTitle() + " морского параболлоида " + getNAME());
        shorty.setPosition(Position.AIR);
        shorty.setAppetite(shorty.getAppetite() + 1);
        shorty.setHappinessLevel(shorty.getHappinessLevel() + 1);
    }
}
