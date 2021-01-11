package com.dmitriyz.essenses;

import com.dmitriyz.exceptions.DiskException;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Attraction {
    private final String NAME;
    private Position position = Position.GROUND;
    private ArrayList<Jollier> passengersOnBoard;

    public Attraction(String name) {
        NAME = name;
        passengersOnBoard = new ArrayList<>();
        System.out.println("Аттракцион " + NAME + " в проекте");
    }

    protected Attraction(String name, Position position) {
        NAME = name;
        passengersOnBoard = new ArrayList<>();
        this.position = position;
        System.out.println("Аттракцион " + NAME + " создан");
    }

    public void addPassengerOnBoard(Jollier jollier) {
        passengersOnBoard.add(jollier);
    }

    public abstract void exitQueue() throws DiskException;

    public void resetPassangersOnBoard() {
        passengersOnBoard.clear();
    }

    public ArrayList<Jollier> getPassengersOnBoard() {
        return passengersOnBoard;
    }

    public String getNAME() {
        return NAME;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return getNAME().equals(that.getNAME()) &&
                getPosition() == that.getPosition() &&
                getPassengersOnBoard().equals(that.getPassengersOnBoard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNAME(), getPosition(), getPassengersOnBoard());
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "NAME='" + NAME + '\'' +
                ", position=" + position +
                ", passengersOnBoard=" + passengersOnBoard +
                '}';
    }
}
