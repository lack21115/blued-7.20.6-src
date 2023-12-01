package cn.shuzilm.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/c.class */
public class c implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4172a;
    final /* synthetic */ SensorManager b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ DUHelper f4173c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DUHelper dUHelper, Context context, SensorManager sensorManager) {
        this.f4173c = dUHelper;
        this.f4172a = context;
        this.b = sensorManager;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            float[] fArr = sensorEvent.values;
            sensorEvent.sensor.getType();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= fArr.length) {
                    break;
                }
                sb.append(fArr[i2] + "");
                sb.append(" , ");
                i = i2 + 1;
            }
            DUHelper.onSensorChanged(this.f4172a, sensorEvent);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        this.b.unregisterListener(this);
    }
}
