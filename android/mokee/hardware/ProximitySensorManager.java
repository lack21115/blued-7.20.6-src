package android.mokee.hardware;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemProperties;

/* loaded from: source-9557208-dex2jar.jar:android/mokee/hardware/ProximitySensorManager.class */
public class ProximitySensorManager {
    private boolean mManagerEnabled;
    private final ProximitySensorEventListener mProximitySensorListener;

    /* loaded from: source-9557208-dex2jar.jar:android/mokee/hardware/ProximitySensorManager$ProximitySensorEventListener.class */
    private class ProximitySensorEventListener implements SensorEventListener {
        private final Sensor mAcceleroMeter;
        private float[] mGeomagnetic;
        private float[] mGravity;
        private final ProximitySensorListener mListener;
        private final Sensor mMagneticSensor;
        private final float mMaxProximityValue;
        private final Sensor mProximitySensor;
        private final SensorManager mSensorManager;
        private int SensorOrientationY = 0;
        private int SensorProximity = 0;
        private boolean initProx = true;
        private boolean proxChanged = false;

        public ProximitySensorEventListener(SensorManager sensorManager, Sensor sensor, Sensor sensor2, Sensor sensor3, ProximitySensorListener proximitySensorListener) {
            this.mSensorManager = sensorManager;
            this.mProximitySensor = sensor;
            this.mAcceleroMeter = sensor2;
            this.mMagneticSensor = sensor3;
            this.mMaxProximityValue = sensor.getMaximumRange();
            this.mListener = proximitySensorListener;
        }

        private void registerSensorListener(Sensor sensor) {
            if (sensor != null) {
                this.mSensorManager.registerListener(this, sensor, 1);
            }
        }

        private boolean rightOrientation(int i) {
            return i < -50 && i > -130;
        }

        private void unregisterSensorListener(Sensor sensor) {
            if (sensor != null) {
                this.mSensorManager.unregisterListener(this, sensor);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float f = sensorEvent.values[0];
            if (sensorEvent.sensor.equals(this.mProximitySensor)) {
                int i = (int) f;
                if (this.initProx) {
                    this.SensorProximity = i;
                    this.initProx = false;
                } else if (this.SensorProximity > 0 && i <= this.mMaxProximityValue) {
                    this.proxChanged = true;
                }
                this.SensorProximity = i;
            } else if (sensorEvent.sensor.equals(this.mAcceleroMeter)) {
                this.mGravity = sensorEvent.values;
            } else if (sensorEvent.sensor.equals(this.mMagneticSensor)) {
                this.mGeomagnetic = sensorEvent.values;
            }
            if (this.mGravity != null && this.mGeomagnetic != null) {
                float[] fArr = new float[9];
                if (SensorManager.getRotationMatrix(fArr, new float[9], this.mGravity, this.mGeomagnetic)) {
                    float[] fArr2 = new float[5];
                    SensorManager.getOrientation(fArr, fArr2);
                    this.SensorOrientationY = (int) ((fArr2[1] * 180.0f) / 3.141592653589793d);
                }
            }
            if (rightOrientation(this.SensorOrientationY) && this.SensorProximity <= this.mMaxProximityValue && this.proxChanged) {
                this.mListener.onPickup();
            }
        }

        public void register() {
            this.SensorOrientationY = 0;
            this.SensorProximity = 0;
            this.initProx = true;
            this.proxChanged = false;
            registerSensorListener(this.mProximitySensor);
            registerSensorListener(this.mAcceleroMeter);
            registerSensorListener(this.mMagneticSensor);
        }

        public void unregister() {
            unregisterSensorListener(this.mProximitySensor);
            unregisterSensorListener(this.mAcceleroMeter);
            unregisterSensorListener(this.mMagneticSensor);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/mokee/hardware/ProximitySensorManager$ProximitySensorListener.class */
    public interface ProximitySensorListener {
        void onPickup();
    }

    public ProximitySensorManager(Context context, ProximitySensorListener proximitySensorListener) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        String str = SystemProperties.get("ro.modversion");
        Sensor defaultSensor = sensorManager.getDefaultSensor(8);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(1);
        Sensor defaultSensor3 = sensorManager.getDefaultSensor(2);
        if (!(defaultSensor == null && defaultSensor2 == null && defaultSensor3 == null) && str.startsWith("MK")) {
            this.mProximitySensorListener = new ProximitySensorEventListener(sensorManager, defaultSensor, defaultSensor2, defaultSensor3, proximitySensorListener);
        } else {
            this.mProximitySensorListener = null;
        }
    }

    public void disable() {
        if (this.mProximitySensorListener == null || !this.mManagerEnabled) {
            return;
        }
        this.mProximitySensorListener.unregister();
        this.mManagerEnabled = false;
    }

    public void enable() {
        if (this.mProximitySensorListener == null || this.mManagerEnabled) {
            return;
        }
        this.mProximitySensorListener.register();
        this.mManagerEnabled = true;
    }
}
