package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21857a = c.class.getSimpleName();
    private SensorManager b;

    /* renamed from: c  reason: collision with root package name */
    private a f21858c;
    private b d;
    private boolean e;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/c$a.class */
    class a implements SensorEventListener {
        private float b;

        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 5) {
                this.b = sensorEvent.values[0];
                if (c.this.d != null) {
                    c.this.d.a(this.b);
                }
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/c$b.class */
    public interface b {
        void a(float f);
    }

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.c.b.c$c  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/c$c.class */
    static class C0738c {

        /* renamed from: a  reason: collision with root package name */
        private static c f21860a = new c();
    }

    private c() {
        this.e = false;
    }

    public static c a() {
        return C0738c.f21860a;
    }

    public int a(Context context, b bVar) {
        if (this.e) {
            YTAGReflectLiveCheckJNIInterface.nativeLog("MicroMsg.LightSensor", "[SensorManagerWorker.start] light sensor has started");
            return 2;
        }
        this.e = true;
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        this.b = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        if (defaultSensor == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog("MicroMsg.LightSensor", "[SensorManagerWorker.start] System do not have lightSensor");
            return 1;
        }
        a aVar = new a();
        this.f21858c = aVar;
        this.b.registerListener(aVar, defaultSensor, 3);
        this.d = bVar;
        return 0;
    }

    public float b() {
        if (this.f21858c != null) {
            Log.d("MicroMsg.LightSensor", "Light lux: " + this.f21858c.b);
            return this.f21858c.b;
        }
        return -1.0f;
    }

    public void c() {
        SensorManager sensorManager;
        if (!this.e || (sensorManager = this.b) == null) {
            return;
        }
        this.e = false;
        sensorManager.unregisterListener(this.f21858c);
    }
}
