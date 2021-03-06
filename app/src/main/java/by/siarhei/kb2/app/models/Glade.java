package by.siarhei.kb2.app.models;

import by.siarhei.kb2.app.entities.Entity;

public interface Glade {
    MapPoint getMapPoint(int x, int y);

    MapPoint[][] getMapPoints();

    boolean isEntity(int x, int y);

    boolean isLand(int x, int y);

    Entity getEntity(int x, int y);

    boolean inBorders(int x, int y);
}
