package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gb.class */
public enum gb {
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
    
    private final int b;

    gb(int i) {
        this.b = i;
    }

    public static gb a(int i) {
        gb[] values = values();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 11) {
                return NONE;
            }
            gb gbVar = values[i3];
            if (gbVar.b == i) {
                return gbVar;
            }
            i2 = i3 + 1;
        }
    }

    public int a() {
        return this.b;
    }
}
