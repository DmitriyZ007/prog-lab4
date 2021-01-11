package com.dmitriyz.essenses;

import com.dmitriyz.exceptions.DiskException;
import com.dmitriyz.exceptions.ShaftException;

import java.util.*;

public class FerrisWheel extends Attraction {
    public Disk disk;
    protected Shaft shaft;

    public FerrisWheel(String name) {
        super(name, Position.GROUND);
        disk = new Disk(DiskType.CommonDisk);
    }

    protected FerrisWheel(String name, DiskType diskType, Position position) {
        super(name, position);
        disk = new Disk(diskType);
    }

    @Override
    public void exitQueue() throws DiskException {
        if (disk.isRotating()) {
            getPassengersOnBoard().sort(new Comparator<Jollier>() {
                @Override
                public int compare(Jollier j1, Jollier j2) {
                    if (j1.getMass() == j2.getMass()) return 0;
                    else if (j1.getMass() > j2.getMass()) return 1;
                    else return -1;
                }
            });
            for (int i = getPassengersOnBoard().size() - 1; i >= 0; i--) {
                centrifugalForce(getPassengersOnBoard().get(i));
                throwObjectCompletely(getPassengersOnBoard().get(i));
                if (i == 0) {
                    System.out.println(getPassengersOnBoard().get(i).getName() + " победил, держался до последнего");
                }
            }
        } else throw new DiskException();
    }

    protected void centrifugalForce(Shorty shorty) {
        System.out.println(shorty.getName() + " скатывается к краю диска типа: " + disk.getTYPE().getTitle() + ", аттракциона " + getNAME());
        shorty.setAppetite(shorty.getAppetite() + 1);
    }

    protected void throwObjectCompletely(Shorty shorty) {
        System.out.println(shorty.getName() + " скатился на землю с диска " + this.getNAME()
                + " типа " + disk.getTYPE().getTitle() + " чёртова колеса " + getNAME());
        shorty.setPosition(Position.GROUND);
        shorty.setAppetite(shorty.getAppetite() + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FerrisWheel that = (FerrisWheel) o;
        return disk.equals(that.disk) &&
                shaft.equals(that.shaft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disk, shaft);
    }

    @Override
    public String toString() {
        return "FerrisWheel{" +
                "disk=" + disk +
                ", shaft=" + shaft +
                '}';
    }

    public void setShaft(Shaft shaft) {
        this.shaft = shaft;
    }

    public class Shaft {
        protected String NAME;

        public Shaft(String name) {
            NAME = name;
            System.out.println("У аттракциона " + FerrisWheel.this.getNAME() + " есть ось " + this.getNAME());
        }

        public String getNAME() {
            return NAME;
        }
    }

    public class Disk {
        private final DiskType TYPE;
        private boolean isRotating = false;

        public Disk(DiskType diskType) {
            TYPE = diskType;
        }

        public void startRotating() throws ShaftException {
            if (shaft != null) {
                isRotating = true;
                System.out.println("Диск " + getNAME() + " аттракциона " + FerrisWheel.this.getNAME() + " крутится");
            } else throw new ShaftException();
        }

        public void stopRotating() {
            if (isRotating()) {
                isRotating = false;
                System.out.println("Диск " + getNAME() + " аттракциона " + FerrisWheel.this.getNAME() + " остановлен");
            }
        }

        public boolean isRotating() {
            return isRotating;
        }

        public DiskType getTYPE() {
            return TYPE;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Disk disk = (Disk) o;
            return isRotating() == disk.isRotating() &&
                    getTYPE() == disk.getTYPE();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTYPE(), isRotating());
        }

        @Override
        public String toString() {
            return "TYPE" + getTYPE().getTitle();
        }
    }
}
