package com.anythink.expressad.shake;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/shake/b.class */
public abstract class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5340a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5341c = 2;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public long g = 0;
    private int h;
    private int i;

    public b(int i, int i2) {
        this.h = 0;
        this.i = 0;
        this.h = i;
        this.i = i2;
    }

    public abstract void a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x006a, code lost:
        if (java.lang.Math.abs(r0 - r0) > r5.h) goto L5;
     */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r6) {
        /*
            r5 = this;
            r0 = r6
            float[] r0 = r0.values
            r6 = r0
            r0 = r6
            r1 = 0
            r0 = r0[r1]
            float r0 = -r0
            r7 = r0
            r0 = r6
            r1 = 1
            r0 = r0[r1]
            float r0 = -r0
            r8 = r0
            r0 = r6
            r1 = 2
            r0 = r0[r1]
            float r0 = -r0
            r9 = r0
            r0 = r5
            float r0 = r0.d
            r10 = r0
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L32
            r0 = r7
            r1 = r10
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            r1 = r5
            int r1 = r1.h
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L6d
        L32:
            r0 = r5
            float r0 = r0.e
            r10 = r0
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L4f
            r0 = r8
            r1 = r10
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            r1 = r5
            int r1 = r1.h
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L6d
        L4f:
            r0 = r5
            float r0 = r0.f
            r10 = r0
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L8c
            r0 = r9
            r1 = r10
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            r1 = r5
            int r1 = r1.h
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L8c
        L6d:
            long r0 = java.lang.System.currentTimeMillis()
            r11 = r0
            r0 = r11
            r1 = r5
            long r1 = r1.g
            long r0 = r0 - r1
            r1 = r5
            int r1 = r1.i
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L8c
            r0 = r5
            r1 = r11
            r0.g = r1
            r0 = r5
            r0.a()
        L8c:
            r0 = r5
            r1 = r7
            r0.d = r1
            r0 = r5
            r1 = r8
            r0.e = r1
            r0 = r5
            r1 = r9
            r0.f = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.shake.b.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
