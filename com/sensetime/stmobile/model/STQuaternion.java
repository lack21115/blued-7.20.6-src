package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STQuaternion.class */
public class STQuaternion {
    float w;
    float x;
    float y;
    float z;

    public STQuaternion(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public STQuaternion(float[] fArr) {
        if (fArr == null || fArr.length < 4) {
            return;
        }
        this.x = fArr[0];
        this.y = fArr[1];
        this.z = fArr[2];
        this.w = fArr[3];
    }

    public float getW() {
        return this.w;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getZ() {
        return this.z;
    }
}
