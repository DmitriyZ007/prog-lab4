package com.dmitriyz.actions;

import com.dmitriyz.exceptions.PositionException;

public interface IWaterActivities {
    public void goToWater() throws PositionException;

    public void goOutWater() throws PositionException;
}
