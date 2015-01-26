package com.neschur.kb2.app.countries;

import com.neschur.kb2.app.R;
import com.neschur.kb2.app.entities.ArmyShop;
import com.neschur.kb2.app.entities.City;

public class Country1 extends Country {

    public Country1() {
        this.id = 0;
        river(30);
        river(20);
        river(40);
        landscape(7, R.drawable.forest);
        landscape(20, R.drawable.stone);

        cities();
        guidePosts();
        goldChests(40, 220, 550);
        army(10, 0);
        mapNext();
    }
}
