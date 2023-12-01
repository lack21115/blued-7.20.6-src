package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/Gradient.class */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/Gradient$a.class */
    public static final class a {
        private final int a;
        private final int b;
        private final float c;

        private a(int i, int i2, float f) {
            this.a = i;
            this.b = i2;
            this.c = f;
        }

        /* synthetic */ a(int i, int i2, float f, byte b) {
            this(i, i2, f);
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, (byte) 0);
    }

    private Gradient(int[] iArr, float[] fArr, byte b) {
        this.isAvailable = true;
        try {
            if (iArr == null || fArr == null) {
                throw new AMapException("colors and startPoints should not be null");
            }
            if (iArr.length != fArr.length) {
                throw new AMapException("colors and startPoints should be same length");
            }
            if (iArr.length == 0) {
                throw new AMapException("No colors have been defined");
            }
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= fArr.length) {
                    this.mColorMapSize = 1000;
                    int[] iArr2 = new int[iArr.length];
                    this.mColors = iArr2;
                    this.mStartPoints = new float[fArr.length];
                    System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr.length);
                    System.arraycopy((Object) fArr, 0, (Object) this.mStartPoints, 0, fArr.length);
                    this.isAvailable = true;
                    return;
                } else if (fArr[i2] < fArr[i2 - 1]) {
                    throw new AMapException("startPoints should be in increasing order");
                } else {
                    i = i2 + 1;
                }
            }
        } catch (AMapException e) {
            this.isAvailable = false;
            Log.e("amap", e.getErrorMessage());
            e.printStackTrace();
        }
    }

    private static int a(int i, int i2, float f) {
        int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    private HashMap<Integer, a> a() {
        HashMap<Integer, a> hashMap = new HashMap<>(32);
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], (byte) 0));
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.mColors.length) {
                break;
            }
            int i3 = i2 - 1;
            int i4 = (int) (this.mColorMapSize * this.mStartPoints[i3]);
            int[] iArr = this.mColors;
            int i5 = iArr[i3];
            int i6 = iArr[i2];
            float f = this.mColorMapSize;
            float[] fArr = this.mStartPoints;
            hashMap.put(Integer.valueOf(i4), new a(i5, i6, f * (fArr[i2] - fArr[i3]), (byte) 0));
            i = i2 + 1;
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            int i7 = (int) (this.mColorMapSize * fArr2[length]);
            int[] iArr2 = this.mColors;
            hashMap.put(Integer.valueOf(i7), new a(iArr2[length], iArr2[length], this.mColorMapSize * (1.0f - this.mStartPoints[length]), (byte) 0));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] generateColorMap(double d) {
        HashMap<Integer, a> a2 = a();
        int[] iArr = new int[this.mColorMapSize];
        a aVar = a2.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.mColorMapSize; i2++) {
            if (a2.containsKey(Integer.valueOf(i2))) {
                aVar = a2.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = a(aVar.a, aVar.b, (i2 - i) / aVar.c);
        }
        if (d != 1.0d) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.mColorMapSize) {
                    break;
                }
                int i5 = iArr[i4];
                iArr[i4] = Color.argb((int) (Color.alpha(i5) * d), Color.red(i5), Color.green(i5), Color.blue(i5));
                i3 = i4 + 1;
            }
        }
        return iArr;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float[] getStartPoints() {
        return this.mStartPoints;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAvailable() {
        return this.isAvailable;
    }
}
