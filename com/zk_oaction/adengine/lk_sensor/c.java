package com.zk_oaction.adengine.lk_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sensor/c.class */
public class c extends d {
    private static int i = 250;

    /* renamed from: a  reason: collision with root package name */
    public float[] f41978a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41979c;
    private float j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private float o;
    private float p;

    public c(com.zk_oaction.adengine.lk_sdk.b bVar, String str, int i2, Sensor sensor, String[] strArr, SensorManager sensorManager) {
        super(bVar, str, i2, sensor, strArr);
        this.n = false;
        this.o = 0.0f;
        this.p = 0.0f;
        this.b = 0L;
        try {
            if (this.f == null) {
                this.e = 1;
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                this.f = defaultSensor;
                if (defaultSensor == null) {
                    return;
                }
            }
            this.f41978a = new float[3];
        } catch (Throwable th) {
        }
    }

    private void b(SensorEvent sensorEvent) {
        try {
            if (this.f == null) {
                return;
            }
            int i2 = this.e;
            if (i2 == 1) {
                float[] fArr = sensorEvent.values;
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2];
                if (!this.n) {
                    this.o = f;
                    this.p = f2;
                    this.n = true;
                } else if (this.g.length > 3) {
                    float abs = Math.abs(this.o - f);
                    if (f3 < 0.0f) {
                        abs = Math.abs((Math.abs(this.o) - Math.abs(f)) + 19.6f);
                    }
                    float max = Math.max(abs, Math.abs(this.p - f2)) / 9.8f;
                    com.zk_oaction.adengine.lk_sdk.b bVar = this.d;
                    String str = this.g[3];
                    bVar.a(str, "" + (max * 90.0f));
                }
            } else if (i2 == 4) {
                if (this.m != 0.0f) {
                    if (this.b == 0) {
                        this.b = System.currentTimeMillis();
                    }
                    float f4 = (((float) sensorEvent.timestamp) - this.m) * 1.0E-9f;
                    float degrees = (float) Math.toDegrees(sensorEvent.values[0] * f4);
                    float degrees2 = (float) Math.toDegrees(sensorEvent.values[1] * f4);
                    float degrees3 = (float) Math.toDegrees(f4 * sensorEvent.values[2]);
                    if (!this.f41979c && (Math.abs(degrees) > 3.0f || Math.abs(degrees2) > 3.0f || Math.abs(degrees3) > 3.0f)) {
                        if (System.currentTimeMillis() - this.b <= i) {
                            return;
                        }
                    }
                    float f5 = degrees + this.j;
                    float f6 = degrees2 + this.k;
                    float f7 = degrees3 + this.l;
                    if (this.g.length > 3) {
                        float abs2 = Math.abs(f5);
                        float abs3 = Math.abs(f6);
                        float max2 = Math.max(Math.max(abs2, abs3), Math.abs(f7));
                        com.zk_oaction.adengine.lk_sdk.b bVar2 = this.d;
                        String str2 = this.g[3];
                        bVar2.a(str2, "" + max2);
                    }
                    this.j = f5;
                    this.k = f6;
                    this.l = f7;
                    this.f41979c = true;
                }
                this.m = (float) sensorEvent.timestamp;
            }
        } catch (Exception e) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_sensor.d
    public void a() {
        super.a();
        this.f41979c = false;
        this.n = false;
        this.b = 0L;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
    }

    @Override // com.zk_oaction.adengine.lk_sensor.d
    public void a(SensorEvent sensorEvent) {
        com.zk_oaction.adengine.lk_sdk.b bVar;
        String str;
        StringBuilder sb;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 3) {
                break;
            }
            try {
                String[] strArr = this.g;
                if (strArr[i3] != null) {
                    if (this.e == 1) {
                        float[] fArr = this.f41978a;
                        fArr[i3] = (fArr[i3] * 0.85f) + (sensorEvent.values[i3] * 0.15f);
                        bVar = this.d;
                        str = strArr[i3];
                        sb = new StringBuilder();
                        sb.append("");
                        sb.append(this.f41978a[i3]);
                    } else {
                        bVar = this.d;
                        str = strArr[i3];
                        sb = new StringBuilder();
                        sb.append("");
                        sb.append(sensorEvent.values[i3] * 10.0f);
                    }
                    bVar.a(str, sb.toString());
                }
                i2 = i3 + 1;
            } catch (Throwable th) {
                return;
            }
            return;
        }
        if (this.g.length > 3) {
            b(sensorEvent);
        }
    }
}
