package com.amap.api.maps.model.particle;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/particle/CurveSizeOverLife.class */
public class CurveSizeOverLife extends SizeOverLife {
    private float x;
    private float y;
    private float z;

    public CurveSizeOverLife(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float f) {
        return 0.0f;
    }
}
