package com.tencent.map.sdk.utilities.visualization;

import android.graphics.Color;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/Gradient.class */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    public final int mColorMapSize;
    public int[] mColors;
    public float[] mStartPoints;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/Gradient$b.class */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f23571a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final float f23572c;

        private b(int i, int i2, float f) {
            this.f23571a = i;
            this.b = i2;
            this.f23572c = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    public Gradient(int[] iArr, float[] fArr, int i) {
        if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        }
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= fArr.length) {
                this.mColorMapSize = i;
                int[] iArr2 = new int[iArr.length];
                this.mColors = iArr2;
                this.mStartPoints = new float[fArr.length];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
                return;
            } else if (fArr[i3] <= fArr[i3 - 1]) {
                throw new IllegalArgumentException("startPoints should be in increasing order");
            } else {
                i2 = i3 + 1;
            }
        }
    }

    private HashMap<Integer, b> generateColorIntervals() {
        HashMap<Integer, b> hashMap = new HashMap<>();
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new b(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0]));
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
            hashMap.put(Integer.valueOf(i4), new b(i5, i6, (fArr[i2] - fArr[i3]) * f));
            i = i2 + 1;
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            int i7 = (int) (this.mColorMapSize * fArr2[length]);
            int[] iArr2 = this.mColors;
            hashMap.put(Integer.valueOf(i7), new b(iArr2[length], iArr2[length], this.mColorMapSize * (1.0f - this.mStartPoints[length])));
        }
        return hashMap;
    }

    public static int interpolateColor(int i, int i2, float f) {
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

    public final int[] generateColorMap(double d) {
        HashMap<Integer, b> generateColorIntervals = generateColorIntervals();
        int[] iArr = new int[this.mColorMapSize];
        b bVar = generateColorIntervals.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.mColorMapSize; i2++) {
            if (generateColorIntervals.containsKey(Integer.valueOf(i2))) {
                bVar = generateColorIntervals.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = interpolateColor(bVar.f23571a, bVar.b, (i2 - i) / bVar.f23572c);
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
}
