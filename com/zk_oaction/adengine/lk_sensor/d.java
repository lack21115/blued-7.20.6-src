package com.zk_oaction.adengine.lk_sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sensor/d.class */
public class d {
    public com.zk_oaction.adengine.lk_sdk.b d;
    public int e;
    public Sensor f;
    public String[] g;
    public boolean h;

    public d(com.zk_oaction.adengine.lk_sdk.b bVar, String str, int i, Sensor sensor, String[] strArr) {
        this.d = bVar;
        this.e = i;
        this.f = sensor;
        if (strArr != null) {
            this.g = (String[]) strArr.clone();
        }
    }

    public void a() {
    }

    public void a(SensorEvent sensorEvent) {
        try {
            String[] strArr = this.g;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= sensorEvent.values.length) {
                    return;
                }
                String[] strArr2 = this.g;
                if (strArr2[i2] != null) {
                    com.zk_oaction.adengine.lk_sdk.b bVar = this.d;
                    String str = strArr2[i2];
                    bVar.a(str, "" + sensorEvent.values[i2]);
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
        }
    }
}
