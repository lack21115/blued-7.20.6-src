package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/CameraPosition.class */
public final class CameraPosition {
    public final float bearing;
    public LatLng target;
    public final float tilt;
    public final float zoom;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/CameraPosition$Builder.class */
    public static final class Builder {
        private LatLng p;
        private float q;
        private float r;
        private float s;

        public Builder() {
            this.r = Float.MIN_VALUE;
            this.s = Float.MIN_VALUE;
        }

        public Builder(CameraPosition cameraPosition) {
            this.r = Float.MIN_VALUE;
            this.s = Float.MIN_VALUE;
            this.p = cameraPosition.target;
            this.q = cameraPosition.zoom;
            this.r = cameraPosition.tilt;
            this.s = cameraPosition.bearing;
        }

        public Builder bearing(float f) {
            this.s = f;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.p, this.q, this.r, this.s);
        }

        public Builder target(LatLng latLng) {
            this.p = latLng;
            return this;
        }

        public Builder tilt(float f) {
            this.r = f;
            return this;
        }

        public Builder zoom(float f) {
            this.q = f;
            return this;
        }
    }

    public CameraPosition(int i, LatLng latLng, float f, float f2, float f3) {
        this.target = latLng;
        this.zoom = f;
        this.tilt = f2;
        this.bearing = f3;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this(1, latLng, f, f2, f3);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CameraPosition) {
            CameraPosition cameraPosition = (CameraPosition) obj;
            return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
        }
        return false;
    }

    public String toString() {
        return "latlng:" + this.target.latitude + "," + this.target.longitude + ",zoom:" + this.zoom + ",tilt=" + this.tilt + ",bearing:" + this.bearing;
    }
}
