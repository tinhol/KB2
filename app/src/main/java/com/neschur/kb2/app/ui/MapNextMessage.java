package com.neschur.kb2.app.ui;

import android.content.res.Resources;

import com.neschur.kb2.app.R;
import com.neschur.kb2.app.controllers.GameController;

/**
 * Created by siarhei on 17.1.15.
 */
public class MapNextMessage extends Message {
    public MapNextMessage(Resources resources, GameController gameController) {
        super(resources, gameController);
        message = resources.getString(R.string.entity_mapNext_message);
    }

    public void action() {
        player.upAvailableCountry();
    }
}