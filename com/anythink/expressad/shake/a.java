package com.anythink.expressad.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.anythink.core.common.b.n;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/shake/a.class */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f5338c;

    /* renamed from: a  reason: collision with root package name */
    Sensor f5339a;
    private SensorManager b;

    private a() {
        Context g = n.a().g();
        if (g != null) {
            try {
                if (this.b == null) {
                    this.b = (SensorManager) g.getSystemService("sensor");
                }
                if (this.f5339a == null) {
                    this.f5339a = this.b.getDefaultSensor(1);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static a a() {
        if (f5338c == null) {
            synchronized (a.class) {
                try {
                    if (f5338c == null) {
                        f5338c = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5338c;
    }

    public final void a(SensorEventListener sensorEventListener) {
        try {
            this.b.registerListener(sensorEventListener, this.f5339a, 2);
        } catch (Throwable th) {
        }
    }

    public final void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.b;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable th) {
            }
        }
    }

    public final boolean b() {
        return this.f5339a != null;
    }
}
