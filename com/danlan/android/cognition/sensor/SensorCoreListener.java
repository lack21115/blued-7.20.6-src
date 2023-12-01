package com.danlan.android.cognition.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.util.PermissionUtil;
import com.huawei.hms.framework.common.ExceptionCode;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/sensor/SensorCoreListener.class */
public class SensorCoreListener implements SensorEventListener {
    private Sensor accelerometer;
    private Context context;
    private PermissionUtil permissionUtil;
    private SensorManager sensorManager;
    private DataGroupArrayList<SensorAccelerometerModel> accelerometerData = new DataGroupArrayList<>(3);
    private long lastAccelerometerRun = 0;
    private int sensorDelay = ExceptionCode.CRASH_EXCEPTION;

    public SensorCoreListener() {
    }

    public SensorCoreListener(Context context) {
        this.context = context;
        this.permissionUtil = new PermissionUtil(context);
        SensorManager sensorManager = (SensorManager) context.getSystemService(StringFog.decrypt("UkZKUE5R"));
        this.sensorManager = sensorManager;
        if (sensorManager != null) {
            try {
                this.accelerometer = sensorManager.getDefaultSensor(1);
            } catch (Exception e) {
            }
        }
    }

    private void addAccelerometerData(SensorEvent sensorEvent) {
        if (!shouldRun(this.accelerometer, this.lastAccelerometerRun, 0) || this.accelerometerData.size() == 2) {
            return;
        }
        this.accelerometerData.add(new SensorAccelerometerModel(sensorEvent));
        this.lastAccelerometerRun = getCurrentTimeInMicroSeconds();
    }

    private long getCurrentTimeInMicroSeconds() {
        return System.currentTimeMillis() * 1000;
    }

    private void registerListener(Sensor sensor) {
        registerListener(sensor, Integer.valueOf(this.sensorDelay));
    }

    private void registerListener(Sensor sensor, Integer num) {
        if (sensor == null) {
            return;
        }
        if (num == null) {
            this.sensorManager.registerListener(this, sensor, this.sensorDelay);
        } else {
            this.sensorManager.registerListener(this, sensor, num.intValue());
        }
    }

    private boolean shouldRun(Sensor sensor, long j) {
        return shouldRun(sensor, j, Integer.valueOf(this.sensorDelay));
    }

    private boolean shouldRun(Sensor sensor, long j, Integer num) {
        return shouldRun(sensor, j, num, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r7.permissionUtil.isPermissionGranted(r12) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
        if (r13 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
        r16 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean shouldRun(android.hardware.Sensor r8, long r9, java.lang.Integer r11, java.lang.String r12) {
        /*
            r7 = this;
            r0 = r11
            int r0 = r0.intValue()
            long r0 = (long) r0
            r14 = r0
            r0 = 0
            r17 = r0
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L26
            r0 = r7
            long r0 = r0.getCurrentTimeInMicroSeconds()
            r1 = r14
            r2 = r9
            long r1 = r1 + r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L20
            goto L26
        L20:
            r0 = 0
            r13 = r0
            goto L29
        L26:
            r0 = 1
            r13 = r0
        L29:
            r0 = r12
            if (r0 == 0) goto L52
            r0 = r17
            r16 = r0
            r0 = r8
            if (r0 == 0) goto L66
            r0 = r17
            r16 = r0
            r0 = r13
            if (r0 == 0) goto L66
            r0 = r17
            r16 = r0
            r0 = r7
            com.danlan.android.cognition.collector.util.PermissionUtil r0 = r0.permissionUtil
            r1 = r12
            boolean r0 = r0.isPermissionGranted(r1)
            if (r0 == 0) goto L66
            goto L63
        L52:
            r0 = r17
            r16 = r0
            r0 = r8
            if (r0 == 0) goto L66
            r0 = r17
            r16 = r0
            r0 = r13
            if (r0 == 0) goto L66
        L63:
            r0 = 1
            r16 = r0
        L66:
            r0 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.sensor.SensorCoreListener.shouldRun(android.hardware.Sensor, long, java.lang.Integer, java.lang.String):boolean");
    }

    private void unregisterListener(Sensor sensor) {
        if (sensor != null) {
            this.sensorManager.unregisterListener(this, sensor);
        }
    }

    public DataGroupArrayList<SensorAccelerometerModel> getAccelerometerData() {
        return this.accelerometerData;
    }

    public int getSensorDelay() {
        return this.sensorDelay;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() != 1) {
                return;
            }
            addAccelerometerData(sensorEvent);
        } catch (Exception e) {
        }
    }

    public void registerListeners() {
        if (Volunteer.getInstance().ready(CognitionDataOpt.SENSOR_ACCELEROMETER)) {
            registerListener(this.accelerometer);
        }
    }

    public void reset() {
        this.accelerometerData = new DataGroupArrayList<>(3);
    }

    public void setSensorDelay(int i) {
        this.sensorDelay = i;
    }

    public void unregisterListeners() {
        if (Volunteer.getInstance().ready(CognitionDataOpt.SENSOR_ACCELEROMETER)) {
            unregisterListener(this.accelerometer);
        }
    }
}
