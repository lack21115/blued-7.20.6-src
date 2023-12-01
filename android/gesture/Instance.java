package android.gesture;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/Instance.class */
class Instance {
    private static final float[] ORIENTATIONS = {0.0f, 0.7853982f, 1.5707964f, 2.3561945f, 3.1415927f, 0.0f, -0.7853982f, -1.5707964f, -2.3561945f, -3.1415927f};
    private static final int PATCH_SAMPLE_SIZE = 16;
    private static final int SEQUENCE_SAMPLE_SIZE = 16;
    final long id;
    final String label;
    final float[] vector;

    private Instance(long j, float[] fArr, String str) {
        this.id = j;
        this.vector = fArr;
        this.label = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Instance createInstance(int i, int i2, Gesture gesture, String str) {
        if (i != 2) {
            return new Instance(gesture.getID(), spatialSampler(gesture), str);
        }
        Instance instance = new Instance(gesture.getID(), temporalSampler(i2, gesture), str);
        instance.normalize();
        return instance;
    }

    private void normalize() {
        float[] fArr = this.vector;
        float f = 0.0f;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            f += fArr[i2] * fArr[i2];
            i = i2 + 1;
        }
        float sqrt = (float) Math.sqrt(f);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return;
            }
            fArr[i4] = fArr[i4] / sqrt;
            i3 = i4 + 1;
        }
    }

    private static float[] spatialSampler(Gesture gesture) {
        return GestureUtils.spatialSampling(gesture, 16, false);
    }

    private static float[] temporalSampler(int i, Gesture gesture) {
        float[] temporalSampling = GestureUtils.temporalSampling(gesture.getStrokes().get(0), 16);
        float[] computeCentroid = GestureUtils.computeCentroid(temporalSampling);
        float atan2 = (float) Math.atan2(temporalSampling[1] - computeCentroid[1], temporalSampling[0] - computeCentroid[0]);
        float f = -atan2;
        float f2 = f;
        if (i != 1) {
            int length = ORIENTATIONS.length;
            int i2 = 0;
            while (true) {
                f2 = f;
                if (i2 >= length) {
                    break;
                }
                float f3 = ORIENTATIONS[i2] - atan2;
                float f4 = f;
                if (Math.abs(f3) < Math.abs(f)) {
                    f4 = f3;
                }
                i2++;
                f = f4;
            }
        }
        GestureUtils.translate(temporalSampling, -computeCentroid[0], -computeCentroid[1]);
        GestureUtils.rotate(temporalSampling, f2);
        return temporalSampling;
    }
}
