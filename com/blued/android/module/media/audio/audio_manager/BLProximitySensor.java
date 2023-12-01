package com.blued.android.module.media.audio.audio_manager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Log;
import com.blued.android.module.media.audio.audio_manager.ThreadUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLProximitySensor.class */
public class BLProximitySensor implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadUtils.ThreadChecker f15520a = new ThreadUtils.ThreadChecker();
    private final Runnable b;

    /* renamed from: c  reason: collision with root package name */
    private final SensorManager f15521c;
    private Sensor d;
    private boolean e;

    private BLProximitySensor(Context context, Runnable runnable) {
        Log.d("BLProximitySensor", "BLProximitySensor");
        this.b = runnable;
        this.f15521c = (SensorManager) context.getSystemService("sensor");
    }

    public static BLProximitySensor a(Context context, Runnable runnable) {
        return new BLProximitySensor(context, runnable);
    }

    private boolean d() {
        if (this.d != null) {
            return true;
        }
        Sensor defaultSensor = this.f15521c.getDefaultSensor(8);
        this.d = defaultSensor;
        if (defaultSensor == null) {
            return false;
        }
        e();
        return true;
    }

    private void e() {
        if (this.d == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("Proximity sensor: ");
        sb.append("name=");
        sb.append(this.d.getName());
        sb.append(", vendor: ");
        sb.append(this.d.getVendor());
        sb.append(", power: ");
        sb.append(this.d.getPower());
        sb.append(", resolution: ");
        sb.append(this.d.getResolution());
        sb.append(", max range: ");
        sb.append(this.d.getMaximumRange());
        sb.append(", min delay: ");
        sb.append(this.d.getMinDelay());
        if (Build.VERSION.SDK_INT >= 20) {
            sb.append(", type: ");
            sb.append(this.d.getStringType());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            sb.append(", max delay: ");
            sb.append(this.d.getMaxDelay());
            sb.append(", reporting mode: ");
            sb.append(this.d.getReportingMode());
            sb.append(", isWakeUpSensor: ");
            sb.append(this.d.isWakeUpSensor());
        }
        Log.d("BLProximitySensor", sb.toString());
    }

    public boolean a() {
        this.f15520a.a();
        Log.d("BLProximitySensor", "start");
        if (d()) {
            this.f15521c.registerListener(this, this.d, 3);
            return true;
        }
        return false;
    }

    public void b() {
        this.f15520a.a();
        Log.d("BLProximitySensor", "stop");
        Sensor sensor = this.d;
        if (sensor == null) {
            return;
        }
        this.f15521c.unregisterListener(this, sensor);
    }

    public boolean c() {
        this.f15520a.a();
        return this.e;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
        this.f15520a.a();
        BLUtils.a(sensor.getType() == 8);
        if (i == 0) {
            Log.e("BLProximitySensor", "The values returned by this sensor cannot be trusted");
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.f15520a.a();
        BLUtils.a(sensorEvent.sensor.getType() == 8);
        if (sensorEvent.values[0] < this.d.getMaximumRange()) {
            Log.d("BLProximitySensor", "Proximity sensor => NEAR state");
            this.e = true;
        } else {
            Log.d("BLProximitySensor", "Proximity sensor => FAR state");
            this.e = false;
        }
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
        Log.d("BLProximitySensor", "onSensorChanged" + BLUtils.a() + ": accuracy=" + sensorEvent.accuracy + ", timestamp=" + sensorEvent.timestamp + ", distance=" + sensorEvent.values[0]);
    }
}
