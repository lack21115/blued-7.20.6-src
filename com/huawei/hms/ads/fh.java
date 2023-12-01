package com.huawei.hms.ads;

import android.opengl.Matrix;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fh.class */
public class fh {
    private static final float[] Code;
    private float B;
    private float C;
    private float S;
    private final fg V;
    private float Z;
    private int I = -1;
    private final float[] F = new float[16];
    private boolean D = false;
    private final float[] L = new float[16];

    static {
        float[] fArr = new float[16];
        Code = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public fh(fg fgVar) {
        this.V = fgVar;
    }

    private void Code() {
        float[] fArr = this.F;
        Matrix.setIdentityM(fArr, 0);
        Matrix.translateM(fArr, 0, this.C, this.S, 0.0f);
        Matrix.scaleM(fArr, 0, this.Z, this.B, 1.0f);
        this.D = true;
    }

    private float[] V() {
        if (!this.D) {
            Code();
        }
        return this.F;
    }

    public void Code(float f, float f2) {
        this.Z = f;
        this.B = f2;
        this.D = false;
    }

    public void Code(int i) {
        this.I = i;
    }

    public void Code(fi fiVar, float[] fArr) {
        Matrix.multiplyMM(this.L, 0, fArr, 0, V(), 0);
        fiVar.Code(new fj(this.L, this.V.Code(), 0, this.V.I(), this.V.C(), this.V.Z(), Code, this.V.V(), this.I, this.V.B()));
    }

    public void V(float f, float f2) {
        this.C = f;
        this.S = f2;
        this.D = false;
    }
}
