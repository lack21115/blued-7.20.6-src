package com.zk_oaction.adengine.lk_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.SystemClock;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sensor/a.class */
public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    private static float f28281c = 0.8f;

    /* renamed from: a  reason: collision with root package name */
    public float[] f28282a;
    public long b;
    private boolean i;
    private long j;
    private float k;
    private float l;
    private float m;
    private float[] n;
    private float[] o;

    public a(com.zk_oaction.adengine.lk_sdk.b bVar, String str, int i, Sensor sensor, String[] strArr) {
        super(bVar, str, i, sensor, strArr);
        this.b = 0L;
        this.l = 17.0f;
        this.m = 1000.0f;
        this.n = new float[3];
        this.o = new float[3];
        try {
            if (this.f == null) {
                return;
            }
            this.f28282a = new float[3];
        } catch (Throwable th) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_sensor.d
    public void a() {
        super.a();
        this.b = 0L;
        this.k = 0.0f;
    }

    @Override // com.zk_oaction.adengine.lk_sensor.d
    public void a(SensorEvent sensorEvent) {
        try {
            if (this.k != 0.0f) {
                if (this.b == 0) {
                    this.b = System.currentTimeMillis();
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 3) {
                        break;
                    }
                    String[] strArr = this.g;
                    if (strArr[i2] != null) {
                        float[] fArr = this.n;
                        float f = f28281c;
                        float f2 = fArr[i2];
                        float[] fArr2 = sensorEvent.values;
                        fArr[i2] = ((1.0f - f) * fArr2[i2]) + (f2 * f);
                        this.o[i2] = fArr2[i2] - fArr[i2];
                        float[] fArr3 = this.f28282a;
                        fArr3[i2] = (fArr3[i2] * 0.85f) + (fArr2[i2] * 0.15f);
                        com.zk_oaction.adengine.lk_sdk.b bVar = this.d;
                        String str = strArr[i2];
                        bVar.a(str, "" + this.f28282a[i2]);
                    }
                    i = i2 + 1;
                }
                String b = this.d.b("shake_range");
                if (!TextUtils.isEmpty(b)) {
                    this.l = Float.parseFloat(b);
                }
                String b2 = this.d.b("shake_wait");
                if (!TextUtils.isEmpty(b2)) {
                    this.m = Float.parseFloat(b2);
                }
                if (Math.abs(this.o[0]) <= this.l && Math.abs(this.o[1]) <= this.l && Math.abs(this.o[2]) <= this.l) {
                    if (((float) Math.abs(SystemClock.uptimeMillis() - this.j)) > this.m) {
                        this.i = false;
                    }
                }
                if (!this.i && System.currentTimeMillis() - this.b > 500) {
                    String b3 = this.d.b("shake");
                    int parseInt = Integer.parseInt((b3 == null || b3.isEmpty()) ? "0" : "0");
                    com.zk_oaction.adengine.lk_sdk.b bVar2 = this.d;
                    bVar2.a("shake", "" + (parseInt + 1));
                    this.i = true;
                    this.j = SystemClock.uptimeMillis();
                }
            }
            this.k = (float) sensorEvent.timestamp;
        } catch (Throwable th) {
        }
    }
}
