package com.dmitriyz.essenses;

import com.dmitriyz.actions.ICommunicationActions;
import com.dmitriyz.actions.IGravityActions;
import com.dmitriyz.actions.IWaterActivities;
import com.dmitriyz.exceptions.PositionException;

import java.util.Objects;

public abstract class Shorty implements IWaterActivities, ICommunicationActions, IGravityActions {
    private final String NAME;
    private Circs circs;
    private int happinessLevel = 0; //Коротышки нейтральны по природе
    private int appetite = 0; //Коротышки сыты по природе
    private Position position, previousPosition;
    private int mass;

    public Shorty(String name, Circs circs, int mass) {
        this.NAME = name;
        this.mass = mass;
        this.circs = circs;
        position = Position.GROUND;
        System.out.println(getName() + " приехал в Лос-Поганос");
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position pos) {
        previousPosition = position;
        position = pos;
    }

    public Position getPreviousPosition() {
        return previousPosition;
    }

    public Circs getCircs() {
        return circs;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public void setHappinessLevel(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getName() {
        return NAME;
    }

    @Override
    public void goOutWater() throws PositionException {
        if (getPosition().equals(Position.WATER)) {
            System.out.println(getName() + " поплыл к берегу");
            setPosition(Position.GROUND);
        } else throw new PositionException();
    }

    @Override
    public void goToWater() throws PositionException {
        if (getPosition().equals(Position.GROUND)) {
            System.out.println(getName() + " зашёл в воду");
            setPosition(Position.WATER);
        } else throw new PositionException();
    }

    @Override
    public void fall(Weather weather) {
        System.out.println(getName() + " упал");
        setPosition(previousPosition);
        setAppetite(getAppetite() + 1);
        if (weather.equals(Weather.HOT) && getPosition().equals(Position.WATER)) {
            sayAboutWeather(weather);
            System.out.println(getName() + ": В жаркую погоду в воде веселее!");
            setHappinessLevel(getHappinessLevel() + 2);
        } else {
            sayAboutWeather(weather);
            setHappinessLevel(getHappinessLevel() + 1);
        }
    }

    @Override
    public void sayHi() {
        System.out.println(getName() + ": Привет! Я " + getCircs().getTitle());
    }

    @Override
    public void sayBye() {
        System.out.println(getName() + ": Пока!");
    }

    @Override
    public void sayAboutHunger() {
        switch (appetite) {
            case 0:
                System.out.println(getName() + ": Я не голоден");
                break;
            case 1:
                System.out.println(getName() + ": Я не очень голоден");
                break;
            case 2:
                System.out.println(getName() + ": Я голоден");
                break;
            case 3:
                System.out.println(getName() + ": Я очень голоден");
                break;
        }
    }

    @Override
    public void sayAboutWeather(Weather weather) {
        System.out.println(getName() + ": Погода сейчас " + weather.getTitle());
    }

    @Override
    public void sayAboutHappiness() {
        int happinessLevel = getHappinessLevel();
        if (happinessLevel <= 0) {
            System.out.println(getName() + ": У меня плохое настроение");
        } else if (happinessLevel <= 2) {
            System.out.println(getName() + ": У меня хорошее настроение");
        } else System.out.println(getName() + ": Я просто счастлив!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shorty shorty = (Shorty) o;
        return getHappinessLevel() == shorty.getHappinessLevel() &&
                getAppetite() == shorty.getAppetite() &&
                getMass() == shorty.getMass() &&
                NAME.equals(shorty.NAME) &&
                getCircs() == shorty.getCircs() &&
                getPosition() == shorty.getPosition() &&
                getPreviousPosition() == shorty.getPreviousPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, getCircs(), getHappinessLevel(), getAppetite(), getPosition(), getPreviousPosition(), getMass());
    }

    @Override
    public String toString() {
        return "Shorty{" +
                "NAME='" + NAME + '\'' +
                ", circs=" + circs +
                ", happinessLevel=" + happinessLevel +
                ", appetite=" + appetite +
                ", position=" + position +
                ", previousPosition=" + previousPosition +
                ", mass=" + mass +
                '}';
    }
}

