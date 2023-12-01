package com.amap.api.maps.model.particle;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/particle/ConstantRotationOverLife.class */
public class ConstantRotationOverLife extends RotationOverLife {
    private float rotate;

    public ConstantRotationOverLife(float f) {
        this.rotate = 0.0f;
        this.rotate = f;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.RotationOverLife
    public float getRotate() {
        return this.rotate;
    }
}
