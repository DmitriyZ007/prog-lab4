package com.dmitriyz.actions;

import com.dmitriyz.essenses.Attraction;
import com.dmitriyz.essenses.FerrisWheel;
import com.dmitriyz.essenses.SeaFerrisWheel;
import com.dmitriyz.essenses.SeaParaboloid;
import com.dmitriyz.exceptions.PositionException;

public interface IAttractionActions {
    public void sitInCenter(Attraction attraction) throws PositionException;

    public void goToAttraction(Attraction attraction);

    public Attraction chooseAttraction(FerrisWheel ferrisWheel, SeaFerrisWheel seaFerrisWheel, SeaParaboloid seaParaboloid);
}
