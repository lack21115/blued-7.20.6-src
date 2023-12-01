package com.amap.api.maps;

import android.location.Location;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/LocationSource.class */
public interface LocationSource {

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/LocationSource$OnLocationChangedListener.class */
    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
