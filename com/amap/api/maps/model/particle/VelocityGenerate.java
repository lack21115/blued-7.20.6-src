package com.amap.api.maps.model.particle;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/particle/VelocityGenerate.class */
public abstract class VelocityGenerate {
    protected final int TYPE_DEFAULT = -1;
    protected final int TYPE_RANDOMVELOCITYBETWEENTWOCONSTANTS = 0;
    protected int type = -1;

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();
}
