package com.opos.mobad.service.tasks;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.omes.scorpion.OmasStub;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/tasks/b.class */
public class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private CountDownLatch f13734a;
    private Map<Integer, float[]> b;

    public Map<Integer, float[]> a(Context context, int[] iArr, int i) {
        return (Map) OmasStub.omasObject(25, new Object[]{this, context, iArr, Integer.valueOf(i)});
    }

    public void a() {
        OmasStub.omasVoid(26, new Object[]{this});
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        OmasStub.omasVoid(27, new Object[]{this, sensor, Integer.valueOf(i)});
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        OmasStub.omasVoid(28, new Object[]{this, sensorEvent});
    }
}
