package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kwad.sdk.components.DevelopMangerComponents;
import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/f/d.class */
public final class d {
    private volatile boolean alV = true;
    private float amd;
    private b ame;
    private a amf;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/f/d$a.class */
    final class a implements SensorEventListener {
        private Random ahn;
        private boolean amh;
        private final float[] amg = {0.0f, 0.0f, 9.8f};
        private final float[] ami = {0.0f, 0.0f, 0.0f};

        public a() {
            this.amh = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
                this.amh = false;
            }
        }

        private void a(float[] fArr) {
            b(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            if (!d.this.alV || sqrt < d.this.amd || d.this.ame == null) {
                return;
            }
            d.a(d.this, false);
            d.this.ame.a(sqrt);
        }

        private void b(float[] fArr) {
            float f = fArr[0];
            float[] fArr2 = this.ami;
            fArr[0] = (f * 0.6f) + (fArr2[0] * 0.39999998f);
            fArr[1] = (fArr[1] * 0.6f) + (fArr2[1] * 0.39999998f);
            fArr[2] = (fArr[2] * 0.6f) + (fArr2[2] * 0.39999998f);
            System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, 3);
        }

        private void xH() {
            if (this.ahn == null) {
                this.ahn = new Random();
            }
            if (this.ahn.nextInt(100) == 1) {
                a(this.amg);
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.amh) {
                xH();
            }
        }
    }

    public d(float f) {
        if (f <= 0.0f) {
            this.amd = 5.0f;
        } else {
            this.amd = f;
        }
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.alV = false;
        return false;
    }

    public final void a(b bVar) {
        this.ame = bVar;
    }

    public final void aX(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.b.d("ShakeDetector", "startDetect context is null");
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(10);
        if (defaultSensor != null) {
            if (this.amf == null) {
                this.amf = new a();
            }
            sensorManager.registerListener(this.amf, defaultSensor, 2);
            return;
        }
        b bVar = this.ame;
        if (bVar != null) {
            bVar.bd();
        }
        com.kwad.sdk.core.d.b.d("ShakeDetector", "startDetect default linear acceleration is null");
    }

    public final void aY(Context context) {
        synchronized (this) {
            if (context != null) {
                if (this.amf != null) {
                    ((SensorManager) context.getSystemService("sensor")).unregisterListener(this.amf);
                    this.amf = null;
                }
            }
        }
    }

    public final void e(float f) {
        this.amd = f;
    }

    public final void xD() {
        synchronized (this) {
            this.alV = true;
        }
    }
}
