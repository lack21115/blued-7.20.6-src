package com.google.android.material.color;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/color/Cam16.class */
final class Cam16 {
    private final float astar;
    private final float bstar;
    private final float chroma;
    private final float hue;
    private final float j;
    private final float jstar;
    private final float m;
    private final float q;
    private final float s;
    static final float[][] XYZ_TO_CAM16RGB = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    static final float[][] CAM16RGB_TO_XYZ = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    private Cam16(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.hue = f;
        this.chroma = f2;
        this.j = f3;
        this.q = f4;
        this.m = f5;
        this.s = f6;
        this.jstar = f7;
        this.astar = f8;
        this.bstar = f9;
    }

    public static Cam16 fromInt(int i) {
        return fromIntInViewingConditions(i, ViewingConditions.DEFAULT);
    }

    static Cam16 fromIntInViewingConditions(int i, ViewingConditions viewingConditions) {
        double d;
        double d2;
        float f;
        float pow;
        float linearized = ColorUtils.linearized(((16711680 & i) >> 16) / 255.0f) * 100.0f;
        float linearized2 = ColorUtils.linearized(((65280 & i) >> 8) / 255.0f) * 100.0f;
        float linearized3 = ColorUtils.linearized((i & 255) / 255.0f) * 100.0f;
        float f2 = (0.41233894f * linearized) + (0.35762063f * linearized2) + (0.18051042f * linearized3);
        float f3 = (0.2126f * linearized) + (0.7152f * linearized2) + (0.0722f * linearized3);
        float f4 = (linearized * 0.01932141f) + (linearized2 * 0.11916382f) + (linearized3 * 0.9503448f);
        float[][] fArr = XYZ_TO_CAM16RGB;
        float f5 = fArr[0][0];
        float f6 = fArr[0][1];
        float f7 = fArr[0][2];
        float f8 = fArr[1][0];
        float f9 = fArr[1][1];
        float f10 = fArr[1][2];
        float f11 = fArr[2][0];
        float f12 = fArr[2][1];
        float f13 = fArr[2][2];
        float f14 = viewingConditions.getRgbD()[0] * ((f5 * f2) + (f6 * f3) + (f7 * f4));
        float f15 = viewingConditions.getRgbD()[1] * ((f8 * f2) + (f9 * f3) + (f10 * f4));
        float f16 = viewingConditions.getRgbD()[2] * ((f2 * f11) + (f3 * f12) + (f4 * f13));
        float pow2 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f14)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f15)) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f16)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f14) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f15) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f16) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d3 = signum;
        double d4 = signum2;
        double d5 = signum3;
        float f17 = ((float) (((d3 * 11.0d) + (d4 * (-12.0d))) + d5)) / 11.0f;
        float f18 = ((float) ((signum + signum2) - (d5 * 2.0d))) / 9.0f;
        float f19 = signum2 * 20.0f;
        float f20 = (((signum * 20.0f) + f19) + (21.0f * signum3)) / 20.0f;
        float f21 = (((signum * 40.0f) + f19) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f18, f17)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            f = atan2 + 360.0f;
        } else {
            f = atan2;
            if (atan2 >= 360.0f) {
                f = atan2 - 360.0f;
            }
        }
        float f22 = (3.1415927f * f) / 180.0f;
        float pow5 = ((float) Math.pow((f21 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float c2 = 4.0f / viewingConditions.getC();
        float sqrt = (float) Math.sqrt(pow5 / 100.0f);
        float aw = viewingConditions.getAw();
        float flRoot = viewingConditions.getFlRoot();
        float pow6 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(Math.toRadians(((double) f) < 20.14d ? 360.0f + f : f) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.hypot(d2, d))) / (f20 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow5 / 100.0d));
        float flRoot2 = pow6 * viewingConditions.getFlRoot();
        float sqrt2 = (float) Math.sqrt((pow * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f));
        float f23 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log1p = ((float) Math.log1p(0.0228f * flRoot2)) * 43.85965f;
        double d6 = f22;
        return new Cam16(f, pow6, pow5, c2 * sqrt * (aw + 4.0f) * flRoot, flRoot2, sqrt2 * 50.0f, f23, log1p * ((float) Math.cos(d6)), log1p * ((float) Math.sin(d6)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Cam16 fromJch(float f, float f2, float f3) {
        return fromJchInViewingConditions(f, f2, f3, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(float f, float f2, float f3, ViewingConditions viewingConditions) {
        double d;
        float c2 = 4.0f / viewingConditions.getC();
        float sqrt = (float) Math.sqrt(f / 100.0d);
        float aw = viewingConditions.getAw();
        float flRoot = viewingConditions.getFlRoot();
        float flRoot2 = f2 * viewingConditions.getFlRoot();
        float sqrt2 = (float) Math.sqrt(((f2 / ((float) Math.sqrt(d))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f));
        float f4 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float log1p = ((float) Math.log1p(flRoot2 * 0.0228d)) * 43.85965f;
        double d2 = (3.1415927f * f3) / 180.0f;
        return new Cam16(f3, f2, f, c2 * sqrt * (aw + 4.0f) * flRoot, flRoot2, sqrt2 * 50.0f, f4, log1p * ((float) Math.cos(d2)), log1p * ((float) Math.sin(d2)));
    }

    public static Cam16 fromUcs(float f, float f2, float f3) {
        return fromUcsInViewingConditions(f, f2, f3, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(float f, float f2, float f3, ViewingConditions viewingConditions) {
        double d = f2;
        double d2 = f3;
        double expm1 = (Math.expm1(Math.hypot(d, d2) * 0.02280000038444996d) / 0.02280000038444996d) / viewingConditions.getFlRoot();
        double atan2 = Math.atan2(d2, d) * 57.29577951308232d;
        double d3 = atan2;
        if (atan2 < 0.0d) {
            d3 = atan2 + 360.0d;
        }
        return fromJchInViewingConditions(f / (1.0f - ((f - 100.0f) * 0.007f)), (float) expm1, (float) d3, viewingConditions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float distance(Cam16 cam16) {
        float jStar = getJStar() - cam16.getJStar();
        float aStar = getAStar() - cam16.getAStar();
        float bStar = getBStar() - cam16.getBStar();
        return (float) (Math.pow(Math.sqrt((jStar * jStar) + (aStar * aStar) + (bStar * bStar)), 0.63d) * 1.41d);
    }

    public float getAStar() {
        return this.astar;
    }

    public float getBStar() {
        return this.bstar;
    }

    public float getChroma() {
        return this.chroma;
    }

    public float getHue() {
        return this.hue;
    }

    public int getInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public float getJ() {
        return this.j;
    }

    public float getJStar() {
        return this.jstar;
    }

    public float getM() {
        return this.m;
    }

    public float getQ() {
        return this.q;
    }

    public float getS() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int viewed(ViewingConditions viewingConditions) {
        float pow = (float) Math.pow(((((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) ? 0.0f : getChroma() / ((float) Math.sqrt(getJ() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float cos = (float) (Math.cos(2.0d + hue) + 3.8d);
        float aw = viewingConditions.getAw();
        float pow2 = (float) Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ());
        float nc = viewingConditions.getNc();
        float ncb = viewingConditions.getNcb();
        float nbb = (aw * pow2) / viewingConditions.getNbb();
        float sin = (float) Math.sin(hue);
        float cos2 = (float) Math.cos(hue);
        float f = (((0.305f + nbb) * 23.0f) * pow) / (((((((cos * 0.25f) * 3846.1538f) * nc) * ncb) * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f2 = cos2 * f;
        float f3 = f * sin;
        float f4 = nbb * 460.0f;
        float f5 = (((451.0f * f2) + f4) + (288.0f * f3)) / 1403.0f;
        float f6 = ((f4 - (891.0f * f2)) - (261.0f * f3)) / 1403.0f;
        float f7 = ((f4 - (f2 * 220.0f)) - (f3 * 6300.0f)) / 1403.0f;
        float max = (float) Math.max(0.0d, (Math.abs(f5) * 27.13d) / (400.0d - Math.abs(f5)));
        float signum = Math.signum(f5);
        float fl = 100.0f / viewingConditions.getFl();
        float pow3 = (float) Math.pow(max, 2.380952380952381d);
        float max2 = (float) Math.max(0.0d, (Math.abs(f6) * 27.13d) / (400.0d - Math.abs(f6)));
        float signum2 = Math.signum(f6);
        float fl2 = 100.0f / viewingConditions.getFl();
        float pow4 = (float) Math.pow(max2, 2.380952380952381d);
        float max3 = (float) Math.max(0.0d, (Math.abs(f7) * 27.13d) / (400.0d - Math.abs(f7)));
        float signum3 = Math.signum(f7);
        float fl3 = 100.0f / viewingConditions.getFl();
        float pow5 = (float) Math.pow(max3, 2.380952380952381d);
        float f8 = ((signum * fl) * pow3) / viewingConditions.getRgbD()[0];
        float f9 = ((signum2 * fl2) * pow4) / viewingConditions.getRgbD()[1];
        float f10 = ((signum3 * fl3) * pow5) / viewingConditions.getRgbD()[2];
        float[][] fArr = CAM16RGB_TO_XYZ;
        return ColorUtils.intFromXyzComponents((fArr[0][0] * f8) + (fArr[0][1] * f9) + (fArr[0][2] * f10), (fArr[1][0] * f8) + (fArr[1][1] * f9) + (fArr[1][2] * f10), (f8 * fArr[2][0]) + (f9 * fArr[2][1]) + (f10 * fArr[2][2]));
    }
}
