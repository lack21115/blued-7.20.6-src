package com.amap.api.maps.model.particle;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/particle/RotationOverLife.class */
public abstract class RotationOverLife {
    protected final int TYPE_DEFAULT = -1;
    protected final int TYPE_CONSTANTROTATIONOVERLIFE = 0;
    protected int type = -1;

    public abstract float getRotate();
}
