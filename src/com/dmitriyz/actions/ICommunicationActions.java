package com.dmitriyz.actions;

import com.dmitriyz.essenses.Weather;

public interface ICommunicationActions {
    public void sayHi();

    public void sayBye();

    public void sayAboutHunger();

    public void sayAboutWeather(Weather weather);

    public void sayAboutHappiness();
}
