package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kwad.sdk.core.response.model.AdMatrixInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/f/c.class */
public final class c {
    private volatile boolean alV = true;
    private long alW = 0;
    private double alX = 9.999999717180685E-10d;
    private double[] alY = {0.0d, 0.0d, 0.0d};
    private double[] alZ = {0.0d, 0.0d, 0.0d};
    private com.kwad.sdk.core.f.a ama;
    private a amb;
    private AdMatrixInfo.RotateInfo rotateInfo;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/f/c$a.class */
    final class a implements SensorEventListener {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            if (c.this.alW != 0) {
                double d = (sensorEvent.timestamp - c.this.alW) * c.this.alX;
                double[] dArr = c.this.alZ;
                dArr[0] = dArr[0] + Math.toDegrees(f * d);
                double[] dArr2 = c.this.alZ;
                dArr2[1] = dArr2[1] + Math.toDegrees(f2 * d);
                double[] dArr3 = c.this.alZ;
                dArr3[2] = dArr3[2] + Math.toDegrees(f3 * d);
                c.this.xE();
                c.this.xF();
            }
            c.this.alW = sensorEvent.timestamp;
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private boolean a(int i, double d, int i2) {
        if (d <= 0.0d || Math.abs(this.alZ[i]) < d) {
            return false;
        }
        if (this.alZ[i] <= 0.0d || i2 != 1) {
            return this.alZ[i] >= 0.0d || i2 != 2;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE() {
        if (this.alV) {
            if (Math.abs(this.alZ[0]) > Math.abs(this.alY[0])) {
                this.alY[0] = this.alZ[0];
            }
            if (Math.abs(this.alZ[1]) > Math.abs(this.alY[1])) {
                this.alY[1] = this.alZ[1];
            }
            if (Math.abs(this.alZ[2]) > Math.abs(this.alY[2])) {
                this.alY[2] = this.alZ[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.alV || (rotateInfo = this.rotateInfo) == null || this.ama == null) {
            return;
        }
        if (a(0, rotateInfo.x.rotateDegree, this.rotateInfo.x.direction) || a(1, this.rotateInfo.y.rotateDegree, this.rotateInfo.y.direction) || a(2, this.rotateInfo.z.rotateDegree, this.rotateInfo.z.direction)) {
            this.alV = false;
            this.ama.ae(xG());
            this.alZ = new double[]{0.0d, 0.0d, 0.0d};
            this.alY = new double[]{0.0d, 0.0d, 0.0d};
        }
    }

    private String xG() {
        return "{\"x\": " + this.alY[0] + ",\"y\":" + this.alY[1] + ",\"z\":" + this.alY[2] + "}";
    }

    public final void a(com.kwad.sdk.core.f.a aVar) {
        this.ama = aVar;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void aX(Context context) {
        if (context == null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(4);
        if (defaultSensor != null) {
            if (this.amb == null) {
                this.amb = new a(this, (byte) 0);
            }
            sensorManager.registerListener(this.amb, defaultSensor, 2);
            return;
        }
        com.kwad.sdk.core.f.a aVar = this.ama;
        if (aVar != null) {
            aVar.la();
        }
    }

    public final void aY(Context context) {
        synchronized (this) {
            if (context != null) {
                if (this.amb != null) {
                    ((SensorManager) context.getSystemService("sensor")).unregisterListener(this.amb);
                    this.amb = null;
                }
            }
        }
    }

    public final void xD() {
        synchronized (this) {
            this.alV = true;
        }
    }
}
