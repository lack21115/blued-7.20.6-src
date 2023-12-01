package android.gesture;

import android.graphics.RectF;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/GestureUtils.class */
public final class GestureUtils {
    private static final float NONUNIFORM_SCALE = (float) Math.sqrt(2.0d);
    private static final float SCALING_THRESHOLD = 0.26f;

    private GestureUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(GestureConstants.LOG_TAG, "Could not close stream", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float[] computeCentroid(float[] fArr) {
        float f = 0.0f;
        float f2 = 0.0f;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new float[]{(2.0f * f) / length, (2.0f * f2) / length};
            }
            f += fArr[i2];
            int i3 = i2 + 1;
            f2 += fArr[i3];
            i = i3 + 1;
        }
    }

    private static float[][] computeCoVariance(float[] fArr) {
        float[][] fArr2 = (float[][]) Array.newInstance(Float.TYPE, 2, 2);
        fArr2[0][0] = 0.0f;
        fArr2[0][1] = 0.0f;
        fArr2[1][0] = 0.0f;
        fArr2[1][1] = 0.0f;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                float[] fArr3 = fArr2[0];
                fArr3[0] = fArr3[0] / (length / 2);
                float[] fArr4 = fArr2[0];
                fArr4[1] = fArr4[1] / (length / 2);
                float[] fArr5 = fArr2[1];
                fArr5[0] = fArr5[0] / (length / 2);
                float[] fArr6 = fArr2[1];
                fArr6[1] = fArr6[1] / (length / 2);
                return fArr2;
            }
            float f = fArr[i2];
            int i3 = i2 + 1;
            float f2 = fArr[i3];
            float[] fArr7 = fArr2[0];
            fArr7[0] = fArr7[0] + (f * f);
            float[] fArr8 = fArr2[0];
            fArr8[1] = fArr8[1] + (f * f2);
            fArr2[1][0] = fArr2[0][1];
            float[] fArr9 = fArr2[1];
            fArr9[1] = fArr9[1] + (f2 * f2);
            i = i3 + 1;
        }
    }

    private static float[] computeOrientation(float[][] fArr) {
        float[] fArr2 = new float[2];
        if (fArr[0][1] == 0.0f || fArr[1][0] == 0.0f) {
            fArr2[0] = 1.0f;
            fArr2[1] = 0.0f;
        }
        float f = -fArr[0][0];
        float f2 = fArr[1][1];
        float f3 = (f - f2) / 2.0f;
        float sqrt = (float) Math.sqrt(Math.pow(f3, 2.0d) - ((fArr[0][0] * fArr[1][1]) - (fArr[0][1] * fArr[1][0])));
        float f4 = (-f3) + sqrt;
        float f5 = (-f3) - sqrt;
        if (f4 == f5) {
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            return fArr2;
        }
        if (f4 <= f5) {
            f4 = f5;
        }
        fArr2[0] = 1.0f;
        fArr2[1] = (f4 - fArr[0][0]) / fArr[0][1];
        return fArr2;
    }

    public static OrientedBoundingBox computeOrientedBoundingBox(ArrayList<GesturePoint> arrayList) {
        int size = arrayList.size();
        float[] fArr = new float[size * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return computeOrientedBoundingBox(fArr, computeCentroid(fArr));
            }
            GesturePoint gesturePoint = arrayList.get(i2);
            int i3 = i2 * 2;
            fArr[i3] = gesturePoint.x;
            fArr[i3 + 1] = gesturePoint.y;
            i = i2 + 1;
        }
    }

    public static OrientedBoundingBox computeOrientedBoundingBox(float[] fArr) {
        int length = fArr.length;
        float[] fArr2 = new float[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return computeOrientedBoundingBox(fArr2, computeCentroid(fArr2));
            }
            fArr2[i2] = fArr[i2];
            i = i2 + 1;
        }
    }

    private static OrientedBoundingBox computeOrientedBoundingBox(float[] fArr, float[] fArr2) {
        float atan2;
        translate(fArr, -fArr2[0], -fArr2[1]);
        float[] computeOrientation = computeOrientation(computeCoVariance(fArr));
        if (computeOrientation[0] == 0.0f && computeOrientation[1] == 0.0f) {
            atan2 = -1.5707964f;
        } else {
            atan2 = (float) Math.atan2(computeOrientation[1], computeOrientation[0]);
            rotate(fArr, -atan2);
        }
        float f = Float.MAX_VALUE;
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MIN_VALUE;
        float f4 = Float.MIN_VALUE;
        int length = fArr.length;
        int i = 0;
        while (i < length) {
            float f5 = f;
            if (fArr[i] < f) {
                f5 = fArr[i];
            }
            float f6 = f3;
            if (fArr[i] > f3) {
                f6 = fArr[i];
            }
            int i2 = i + 1;
            float f7 = f2;
            if (fArr[i2] < f2) {
                f7 = fArr[i2];
            }
            float f8 = f4;
            if (fArr[i2] > f4) {
                f8 = fArr[i2];
            }
            i = i2 + 1;
            f3 = f6;
            f4 = f8;
            f = f5;
            f2 = f7;
        }
        return new OrientedBoundingBox((float) ((180.0f * atan2) / 3.141592653589793d), fArr2[0], fArr2[1], f3 - f, f4 - f2);
    }

    static float computeStraightness(float[] fArr) {
        float computeTotalLength = computeTotalLength(fArr);
        float f = fArr[2] - fArr[0];
        float f2 = fArr[3] - fArr[1];
        return ((float) Math.sqrt((f * f) + (f2 * f2))) / computeTotalLength;
    }

    static float computeStraightness(float[] fArr, float f) {
        float f2 = fArr[2] - fArr[0];
        float f3 = fArr[3] - fArr[1];
        return ((float) Math.sqrt((f2 * f2) + (f3 * f3))) / f;
    }

    static float computeTotalLength(float[] fArr) {
        float f = 0.0f;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length - 4) {
                return f;
            }
            float f2 = fArr[i2 + 2] - fArr[i2];
            float f3 = fArr[i2 + 3] - fArr[i2 + 1];
            f = (float) (f + Math.sqrt((f2 * f2) + (f3 * f3)));
            i = i2 + 2;
        }
    }

    static float cosineDistance(float[] fArr, float[] fArr2) {
        float f = 0.0f;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (float) Math.acos(f);
            }
            f += fArr[i2] * fArr2[i2];
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float minimumCosineDistance(float[] fArr, float[] fArr2, int i) {
        int length = fArr.length;
        float f = 0.0f;
        float f2 = 0.0f;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            f += (fArr[i3] * fArr2[i3]) + (fArr[i3 + 1] * fArr2[i3 + 1]);
            f2 += (fArr[i3] * fArr2[i3 + 1]) - (fArr[i3 + 1] * fArr2[i3]);
            i2 = i3 + 2;
        }
        if (f != 0.0f) {
            float f3 = f2 / f;
            double atan = Math.atan(f3);
            if (i <= 2 || Math.abs(atan) < 3.141592653589793d / i) {
                double cos = Math.cos(atan);
                return (float) Math.acos((f * cos) + (f2 * cos * f3));
            }
            return (float) Math.acos(f);
        }
        return 1.5707964f;
    }

    private static void plot(float f, float f2, float[] fArr, int i) {
        float f3 = f;
        if (f < 0.0f) {
            f3 = 0.0f;
        }
        float f4 = f2;
        if (f2 < 0.0f) {
            f4 = 0.0f;
        }
        int floor = (int) Math.floor(f3);
        int ceil = (int) Math.ceil(f3);
        int floor2 = (int) Math.floor(f4);
        int ceil2 = (int) Math.ceil(f4);
        if (f3 == floor && f4 == floor2) {
            int i2 = (ceil2 * i) + ceil;
            if (fArr[i2] < 1.0f) {
                fArr[i2] = 1.0f;
                return;
            }
            return;
        }
        double pow = Math.pow(floor - f3, 2.0d);
        double pow2 = Math.pow(floor2 - f4, 2.0d);
        double pow3 = Math.pow(ceil - f3, 2.0d);
        double pow4 = Math.pow(ceil2 - f4, 2.0d);
        float sqrt = (float) Math.sqrt(pow + pow2);
        float sqrt2 = (float) Math.sqrt(pow3 + pow2);
        float sqrt3 = (float) Math.sqrt(pow + pow4);
        float sqrt4 = (float) Math.sqrt(pow3 + pow4);
        float f5 = sqrt + sqrt2 + sqrt3 + sqrt4;
        float f6 = sqrt / f5;
        int i3 = (floor2 * i) + floor;
        if (f6 > fArr[i3]) {
            fArr[i3] = f6;
        }
        float f7 = sqrt2 / f5;
        int i4 = (floor2 * i) + ceil;
        if (f7 > fArr[i4]) {
            fArr[i4] = f7;
        }
        float f8 = sqrt3 / f5;
        int i5 = (ceil2 * i) + floor;
        if (f8 > fArr[i5]) {
            fArr[i5] = f8;
        }
        float f9 = sqrt4 / f5;
        int i6 = (ceil2 * i) + ceil;
        if (f9 > fArr[i6]) {
            fArr[i6] = f9;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float[] rotate(float[] fArr, float f) {
        float cos = (float) Math.cos(f);
        float sin = (float) Math.sin(f);
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return fArr;
            }
            float f2 = fArr[i2];
            float f3 = fArr[i2 + 1];
            float f4 = fArr[i2];
            float f5 = fArr[i2 + 1];
            fArr[i2] = (f2 * cos) - (f3 * sin);
            fArr[i2 + 1] = (f4 * sin) + (f5 * cos);
            i = i2 + 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float[] scale(float[] fArr, float f, float f2) {
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return fArr;
            }
            fArr[i2] = fArr[i2] * f;
            int i3 = i2 + 1;
            fArr[i3] = fArr[i3] * f2;
            i = i2 + 2;
        }
    }

    public static float[] spatialSampling(Gesture gesture, int i) {
        return spatialSampling(gesture, i, false);
    }

    public static float[] spatialSampling(Gesture gesture, int i, boolean z) {
        float f;
        float f2;
        float f3 = i - 1;
        float[] fArr = new float[i * i];
        Arrays.fill(fArr, 0.0f);
        RectF boundingBox = gesture.getBoundingBox();
        float width = boundingBox.width();
        float height = boundingBox.height();
        float f4 = f3 / width;
        float f5 = f3 / height;
        if (z) {
            float f6 = f4 < f5 ? f4 : f5;
            f2 = f6;
            f = f6;
        } else {
            float f7 = width / height;
            float f8 = f7;
            if (f7 > 1.0f) {
                f8 = 1.0f / f7;
            }
            if (f8 < SCALING_THRESHOLD) {
                float f9 = f4 < f5 ? f4 : f5;
                float f10 = f9;
                f = f9;
                f2 = f10;
            } else if (f4 > f5) {
                float f11 = f5 * NONUNIFORM_SCALE;
                f = f4;
                f2 = f5;
                if (f11 < f4) {
                    f = f11;
                    f2 = f5;
                }
            } else {
                float f12 = f4 * NONUNIFORM_SCALE;
                f = f4;
                f2 = f5;
                if (f12 < f5) {
                    f2 = f12;
                    f = f4;
                }
            }
        }
        float f13 = -boundingBox.centerX();
        float f14 = -boundingBox.centerY();
        float f15 = f3 / 2.0f;
        float f16 = f3 / 2.0f;
        ArrayList<GestureStroke> strokes = gesture.getStrokes();
        int size = strokes.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return fArr;
            }
            float[] fArr2 = strokes.get(i3).points;
            int length = fArr2.length;
            float[] fArr3 = new float[length];
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length) {
                    break;
                }
                fArr3[i5] = ((fArr2[i5] + f13) * f) + f15;
                fArr3[i5 + 1] = ((fArr2[i5 + 1] + f14) * f2) + f16;
                i4 = i5 + 2;
            }
            float f17 = -1.0f;
            float f18 = -1.0f;
            int i6 = 0;
            while (i6 < length) {
                float f19 = fArr3[i6] < 0.0f ? 0.0f : fArr3[i6];
                float f20 = fArr3[i6 + 1] < 0.0f ? 0.0f : fArr3[i6 + 1];
                float f21 = f19;
                if (f19 > f3) {
                    f21 = f3;
                }
                float f22 = f20;
                if (f20 > f3) {
                    f22 = f3;
                }
                plot(f21, f22, fArr, i);
                if (f17 != -1.0f) {
                    if (f17 > f21) {
                        float f23 = (f18 - f22) / (f17 - f21);
                        for (float ceil = (float) Math.ceil(f21); ceil < f17; ceil += 1.0f) {
                            plot(ceil, ((ceil - f21) * f23) + f22, fArr, i);
                        }
                    } else if (f17 < f21) {
                        float f24 = (f18 - f22) / (f17 - f21);
                        for (float ceil2 = (float) Math.ceil(f17); ceil2 < f21; ceil2 += 1.0f) {
                            plot(ceil2, ((ceil2 - f21) * f24) + f22, fArr, i);
                        }
                    }
                    if (f18 > f22) {
                        float f25 = (f17 - f21) / (f18 - f22);
                        for (float ceil3 = (float) Math.ceil(f22); ceil3 < f18; ceil3 += 1.0f) {
                            plot(((ceil3 - f22) * f25) + f21, ceil3, fArr, i);
                        }
                    } else if (f18 < f22) {
                        float f26 = (f17 - f21) / (f18 - f22);
                        for (float ceil4 = (float) Math.ceil(f18); ceil4 < f22; ceil4 += 1.0f) {
                            plot(((ceil4 - f22) * f26) + f21, ceil4, fArr, i);
                        }
                    }
                }
                i6 += 2;
                f17 = f21;
                f18 = f22;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float squaredEuclideanDistance(float[] fArr, float[] fArr2) {
        float f = 0.0f;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return f / length;
            }
            float f2 = fArr[i2] - fArr2[i2];
            f += f2 * f2;
            i = i2 + 1;
        }
    }

    public static float[] temporalSampling(GestureStroke gestureStroke, int i) {
        float f = gestureStroke.length / (i - 1);
        int i2 = i * 2;
        float[] fArr = new float[i2];
        float f2 = 0.0f;
        float[] fArr2 = gestureStroke.points;
        float f3 = fArr2[0];
        float f4 = fArr2[1];
        float f5 = Float.MIN_VALUE;
        float f6 = Float.MIN_VALUE;
        fArr[0] = f3;
        int i3 = 0 + 1;
        fArr[i3] = f4;
        int i4 = i3 + 1;
        int i5 = 0;
        int length = fArr2.length / 2;
        while (i5 < length) {
            float f7 = f5;
            int i6 = i5;
            if (f5 == Float.MIN_VALUE) {
                i6 = i5 + 1;
                if (i6 >= length) {
                    break;
                }
                f7 = fArr2[i6 * 2];
                f6 = fArr2[(i6 * 2) + 1];
            }
            float f8 = f7 - f3;
            float f9 = f6 - f4;
            float sqrt = (float) Math.sqrt((f8 * f8) + (f9 * f9));
            if (f2 + sqrt >= f) {
                float f10 = (f - f2) / sqrt;
                f3 += f10 * f8;
                f4 += f10 * f9;
                fArr[i4] = f3;
                int i7 = i4 + 1;
                fArr[i7] = f4;
                i4 = i7 + 1;
                f2 = 0.0f;
                f5 = f7;
                i5 = i6;
            } else {
                f3 = f7;
                f4 = f6;
                f5 = Float.MIN_VALUE;
                f6 = Float.MIN_VALUE;
                f2 += sqrt;
                i5 = i6;
            }
        }
        while (i4 < i2) {
            fArr[i4] = f3;
            fArr[i4 + 1] = f4;
            i4 += 2;
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float[] translate(float[] fArr, float f, float f2) {
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return fArr;
            }
            fArr[i2] = fArr[i2] + f;
            int i3 = i2 + 1;
            fArr[i3] = fArr[i3] + f2;
            i = i2 + 2;
        }
    }
}
