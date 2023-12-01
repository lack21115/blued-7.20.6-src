package android.hardware;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/GeomagneticField.class */
public class GeomagneticField {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long BASE_TIME = 0;
    private static final float[][] DELTA_G = null;
    private static final float[][] DELTA_H = null;
    private static final float EARTH_REFERENCE_RADIUS_KM = 6371.2f;
    private static final float EARTH_SEMI_MAJOR_AXIS_KM = 6378.137f;
    private static final float EARTH_SEMI_MINOR_AXIS_KM = 6356.7524f;
    private static final float[][] G_COEFF = null;
    private static final float[][] H_COEFF = null;
    private static final float[][] SCHMIDT_QUASI_NORM_FACTORS = null;
    private float mGcLatitudeRad;
    private float mGcLongitudeRad;
    private float mGcRadiusKm;
    private float mX;
    private float mY;
    private float mZ;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/GeomagneticField$LegendreTable.class */
    private static class LegendreTable {
        static final /* synthetic */ boolean $assertionsDisabled;
        public final float[][] mP;
        public final float[][] mPDeriv;

        static {
            $assertionsDisabled = !GeomagneticField.class.desiredAssertionStatus();
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [float[], float[][]] */
        /* JADX WARN: Type inference failed for: r1v5, types: [float[], float[][]] */
        public LegendreTable(int i, float f) {
            float cos = (float) Math.cos(f);
            float sin = (float) Math.sin(f);
            this.mP = new float[i + 1];
            this.mPDeriv = new float[i + 1];
            float[][] fArr = this.mP;
            float[] fArr2 = new float[1];
            fArr2[0] = 1.0f;
            fArr[0] = fArr2;
            float[][] fArr3 = this.mPDeriv;
            float[] fArr4 = new float[1];
            fArr4[0] = 0.0f;
            fArr3[0] = fArr4;
            int i2 = 1;
            loop0: while (true) {
                int i3 = i2;
                if (i3 > i) {
                    return;
                }
                this.mP[i3] = new float[i3 + 1];
                this.mPDeriv[i3] = new float[i3 + 1];
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 <= i3) {
                        if (i3 == i5) {
                            this.mP[i3][i5] = this.mP[i3 - 1][i5 - 1] * sin;
                            this.mPDeriv[i3][i5] = (this.mP[i3 - 1][i5 - 1] * cos) + (this.mPDeriv[i3 - 1][i5 - 1] * sin);
                        } else if (i3 == 1 || i5 == i3 - 1) {
                            this.mP[i3][i5] = this.mP[i3 - 1][i5] * cos;
                            this.mPDeriv[i3][i5] = ((-sin) * this.mP[i3 - 1][i5]) + (this.mPDeriv[i3 - 1][i5] * cos);
                        } else if ($assertionsDisabled || (i3 > 1 && i5 < i3 - 1)) {
                            float f2 = (((i3 - 1) * (i3 - 1)) - (i5 * i5)) / (((i3 * 2) - 1) * ((i3 * 2) - 3));
                            this.mP[i3][i5] = (this.mP[i3 - 1][i5] * cos) - (this.mP[i3 - 2][i5] * f2);
                            this.mPDeriv[i3][i5] = (((-sin) * this.mP[i3 - 1][i5]) + (this.mPDeriv[i3 - 1][i5] * cos)) - (this.mPDeriv[i3 - 2][i5] * f2);
                        }
                        i4 = i5 + 1;
                    }
                }
                i2 = i3 + 1;
            }
            throw new AssertionError();
        }
    }

    static {
        throw new VerifyError("bad dex opcode");
    }

    public GeomagneticField(float f, float f2, float f3, long j) {
        int length = G_COEFF.length;
        float min = Math.min(89.99999f, Math.max(-89.99999f, f));
        computeGeocentricCoordinates(min, f2, f3);
        if (!$assertionsDisabled && G_COEFF.length != H_COEFF.length) {
            throw new AssertionError();
        }
        LegendreTable legendreTable = new LegendreTable(length - 1, (float) (1.5707963267948966d - this.mGcLatitudeRad));
        float[] fArr = new float[length + 2];
        fArr[0] = 1.0f;
        fArr[1] = EARTH_REFERENCE_RADIUS_KM / this.mGcRadiusKm;
        int i = 2;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                break;
            }
            fArr[i2] = fArr[i2 - 1] * fArr[1];
            i = i2 + 1;
        }
        float[] fArr2 = new float[length];
        float[] fArr3 = new float[length];
        fArr2[0] = 0.0f;
        fArr3[0] = 1.0f;
        fArr2[1] = (float) Math.sin(this.mGcLongitudeRad);
        fArr3[1] = (float) Math.cos(this.mGcLongitudeRad);
        int i3 = 2;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            int i5 = i4 >> 1;
            fArr2[i4] = (fArr2[i4 - i5] * fArr3[i5]) + (fArr3[i4 - i5] * fArr2[i5]);
            fArr3[i4] = (fArr3[i4 - i5] * fArr3[i5]) - (fArr2[i4 - i5] * fArr2[i5]);
            i3 = i4 + 1;
        }
        float cos = 1.0f / ((float) Math.cos(this.mGcLatitudeRad));
        float f4 = ((float) (j - BASE_TIME)) / 3.1536001E10f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        int i6 = 1;
        while (true) {
            int i7 = i6;
            if (i7 >= length) {
                double radians = Math.toRadians(min) - this.mGcLatitudeRad;
                this.mX = (float) ((f5 * Math.cos(radians)) + (f7 * Math.sin(radians)));
                this.mY = f6;
                this.mZ = (float) (((-f5) * Math.sin(radians)) + (f7 * Math.cos(radians)));
                return;
            }
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 <= i7) {
                    float f8 = G_COEFF[i7][i9] + (DELTA_G[i7][i9] * f4);
                    float f9 = H_COEFF[i7][i9] + (DELTA_H[i7][i9] * f4);
                    f5 += fArr[i7 + 2] * ((fArr3[i9] * f8) + (fArr2[i9] * f9)) * legendreTable.mPDeriv[i7][i9] * SCHMIDT_QUASI_NORM_FACTORS[i7][i9];
                    f6 += fArr[i7 + 2] * i9 * ((fArr2[i9] * f8) - (fArr3[i9] * f9)) * legendreTable.mP[i7][i9] * SCHMIDT_QUASI_NORM_FACTORS[i7][i9] * cos;
                    f7 -= ((((i7 + 1) * fArr[i7 + 2]) * ((fArr3[i9] * f8) + (fArr2[i9] * f9))) * legendreTable.mP[i7][i9]) * SCHMIDT_QUASI_NORM_FACTORS[i7][i9];
                    i8 = i9 + 1;
                }
            }
            i6 = i7 + 1;
        }
    }

    private void computeGeocentricCoordinates(float f, float f2, float f3) {
        float f4 = f3 / 1000.0f;
        double radians = Math.toRadians(f);
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        float f5 = sin / cos;
        float sqrt = (float) Math.sqrt((4.0680636E7f * cos * cos) + (4.04083E7f * sin * sin));
        this.mGcLatitudeRad = (float) Math.atan((((sqrt * f4) + 4.04083E7f) * f5) / ((sqrt * f4) + 4.0680636E7f));
        this.mGcLongitudeRad = (float) Math.toRadians(f2);
        this.mGcRadiusKm = (float) Math.sqrt((f4 * f4) + (2.0f * f4 * ((float) Math.sqrt((4.0680636E7f * cos * cos) + (4.04083E7f * sin * sin)))) + (((((4.0680636E7f * 4.0680636E7f) * cos) * cos) + (((4.04083E7f * 4.04083E7f) * sin) * sin)) / (((4.0680636E7f * cos) * cos) + ((4.04083E7f * sin) * sin))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [float[], float[][]] */
    private static float[][] computeSchmidtQuasiNormFactors(int i) {
        ?? r0 = new float[i + 1];
        float[] fArr = new float[1];
        fArr[0] = 1.0f;
        r0[0] = fArr;
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > i) {
                return r0;
            }
            r0[i3] = new float[i3 + 1];
            r0[i3][0] = (r0[i3 - 1][0] * ((i3 * 2) - 1)) / i3;
            int i4 = 1;
            while (true) {
                int i5 = i4;
                if (i5 <= i3) {
                    r0[i3][i5] = ((float) Math.sqrt(((i5 == 1 ? 2 : 1) * ((i3 - i5) + 1)) / (i3 + i5))) * r0[i3][i5 - 1];
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    public float getDeclination() {
        return (float) Math.toDegrees(Math.atan2(this.mY, this.mX));
    }

    public float getFieldStrength() {
        return (float) Math.sqrt((this.mX * this.mX) + (this.mY * this.mY) + (this.mZ * this.mZ));
    }

    public float getHorizontalStrength() {
        return (float) Math.sqrt((this.mX * this.mX) + (this.mY * this.mY));
    }

    public float getInclination() {
        return (float) Math.toDegrees(Math.atan2(this.mZ, getHorizontalStrength()));
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    public float getZ() {
        return this.mZ;
    }
}
