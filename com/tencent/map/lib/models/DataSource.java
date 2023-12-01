package com.tencent.map.lib.models;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/DataSource.class */
public enum DataSource {
    NONE(-1),
    SATELLITE(0),
    DEM(1),
    MAP(2),
    STREET_VIEW_ROAD(3),
    TRAFFIC_NETWORK(4),
    INDOOR_BUILDINGS(5),
    LANDMARK(6),
    TILE_OVERLAY(7),
    INDOOR_CONFIG(8),
    NUM(9);
    
    private final int mValue;

    DataSource(int i) {
        this.mValue = i;
    }

    public static DataSource get(int i) {
        DataSource[] values = values();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 11) {
                return NONE;
            }
            DataSource dataSource = values[i3];
            if (dataSource.mValue == i) {
                return dataSource;
            }
            i2 = i3 + 1;
        }
    }

    public int getValue() {
        return this.mValue;
    }
}
