package com.dmitriyz.essenses;

public class SeaFerrisWheel extends FerrisWheel {
    public SeaFerrisWheel(String name) {
        super(name, DiskType.CommonDisk, Position.WATER);
    }

    protected SeaFerrisWheel(String name, DiskType diskType, Position position) {
        super(name, diskType, position);
    }

    @Override
    protected void throwObjectCompletely(Shorty shorty) {
        System.out.println(shorty.getName() + " скатился в воду с диска " + this.getNAME()
                + " типа " + disk.getTYPE().getTitle() + " чёртова колеса " + getNAME());
        shorty.setPosition(Position.WATER);
        shorty.setAppetite(shorty.getAppetite() + 1);
    }
}
