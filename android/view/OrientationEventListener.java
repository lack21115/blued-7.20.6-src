package android.view;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/view/OrientationEventListener.class */
public abstract class OrientationEventListener {
    private static final boolean DEBUG = false;
    public static final int ORIENTATION_UNKNOWN = -1;
    private static final String TAG = "OrientationEventListener";
    private static final boolean localLOGV = false;
    private boolean mEnabled;
    private OrientationListener mOldListener;
    private int mOrientation;
    private int mRate;
    private Sensor mSensor;
    private SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;

    /* loaded from: source-9557208-dex2jar.jar:android/view/OrientationEventListener$SensorEventListenerImpl.class */
    class SensorEventListenerImpl implements SensorEventListener {
        private static final int _DATA_X = 0;
        private static final int _DATA_Y = 1;
        private static final int _DATA_Z = 2;

        SensorEventListenerImpl() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int i;
            float[] fArr = sensorEvent.values;
            int i2 = -1;
            float f = -fArr[0];
            float f2 = -fArr[1];
            float f3 = -fArr[2];
            if (4.0f * ((f * f) + (f2 * f2)) >= f3 * f3) {
                int i3 = 90;
                int round = Math.round(((float) Math.atan2(-f2, f)) * 57.29578f);
                while (true) {
                    int i4 = i3 - round;
                    i = i4;
                    if (i4 < 360) {
                        break;
                    }
                    i3 = i4;
                    round = 360;
                }
                while (true) {
                    i2 = i;
                    if (i >= 0) {
                        break;
                    }
                    i += 360;
                }
            }
            if (OrientationEventListener.this.mOldListener != null) {
                OrientationEventListener.this.mOldListener.onSensorChanged(1, sensorEvent.values);
            }
            if (i2 != OrientationEventListener.this.mOrientation) {
                OrientationEventListener.this.mOrientation = i2;
                OrientationEventListener.this.onOrientationChanged(i2);
            }
        }
    }

    public OrientationEventListener(Context context) {
        this(context, 3);
    }

    public OrientationEventListener(Context context, int i) {
        this.mOrientation = -1;
        this.mEnabled = false;
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        this.mRate = i;
        this.mSensor = this.mSensorManager.getDefaultSensor(1);
        if (this.mSensor != null) {
            this.mSensorEventListener = new SensorEventListenerImpl();
        }
    }

    public boolean canDetectOrientation() {
        return this.mSensor != null;
    }

    public void disable() {
        if (this.mSensor == null) {
            Log.w(TAG, "Cannot detect sensors. Invalid disable");
        } else if (this.mEnabled) {
            this.mSensorManager.unregisterListener(this.mSensorEventListener);
            this.mEnabled = false;
        }
    }

    public void enable() {
        if (this.mSensor == null) {
            Log.w(TAG, "Cannot detect sensors. Not enabled");
        } else if (this.mEnabled) {
        } else {
            this.mSensorManager.registerListener(this.mSensorEventListener, this.mSensor, this.mRate);
            this.mEnabled = true;
        }
    }

    public abstract void onOrientationChanged(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerListener(OrientationListener orientationListener) {
        this.mOldListener = orientationListener;
    }
}
