package android.hardware;

import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.IRotationWatcher;
import android.view.IWindowManager;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/hardware/LegacySensorManager.class */
public final class LegacySensorManager {
    private static boolean sInitialized;
    private static int sRotation = 0;
    private static IWindowManager sWindowManager;
    private final HashMap<SensorListener, LegacyListener> mLegacyListenersMap = new HashMap<>();
    private final SensorManager mSensorManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/LegacySensorManager$LegacyListener.class */
    public static final class LegacyListener implements SensorEventListener {
        private SensorListener mTarget;
        private float[] mValues = new float[6];
        private final LmsFilter mYawfilter = new LmsFilter();
        private int mSensors = 0;

        LegacyListener(SensorListener sensorListener) {
            this.mTarget = sensorListener;
        }

        private static int getLegacySensorType(int i) {
            switch (i) {
                case 1:
                    return 2;
                case 2:
                    return 8;
                case 3:
                    return 128;
                case 4:
                case 5:
                case 6:
                default:
                    return 0;
                case 7:
                    return 4;
            }
        }

        private static boolean hasOrientationSensor(int i) {
            return (i & 129) != 0;
        }

        private void mapSensorDataToWindow(int i, float[] fArr, int i2) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            switch (i) {
                case 1:
                case 128:
                    f3 = -f3;
                    break;
                case 2:
                    f = -f;
                    f2 = -f2;
                    f3 = -f3;
                    break;
                case 8:
                    f = -f;
                    f2 = -f2;
                    break;
            }
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f;
            fArr[4] = f2;
            fArr[5] = f3;
            if ((i2 & 1) != 0) {
                switch (i) {
                    case 1:
                    case 128:
                        fArr[0] = (f < 270.0f ? 90 : -270) + f;
                        fArr[1] = f3;
                        fArr[2] = f2;
                        break;
                    case 2:
                    case 8:
                        fArr[0] = -f2;
                        fArr[1] = f;
                        fArr[2] = f3;
                        break;
                }
            }
            if ((i2 & 2) != 0) {
                float f4 = fArr[0];
                float f5 = fArr[1];
                float f6 = fArr[2];
                switch (i) {
                    case 1:
                    case 128:
                        fArr[0] = f4 >= 180.0f ? f4 - 180.0f : f4 + 180.0f;
                        fArr[1] = -f5;
                        fArr[2] = -f6;
                        return;
                    case 2:
                    case 8:
                        fArr[0] = -f4;
                        fArr[1] = -f5;
                        fArr[2] = f6;
                        return;
                    default:
                        return;
                }
            }
        }

        boolean hasSensors() {
            return this.mSensors != 0;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            try {
                this.mTarget.onAccuracyChanged(getLegacySensorType(sensor.getType()), i);
            } catch (AbstractMethodError e) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = this.mValues;
            fArr[0] = sensorEvent.values[0];
            fArr[1] = sensorEvent.values[1];
            fArr[2] = sensorEvent.values[2];
            int type = sensorEvent.sensor.getType();
            int legacySensorType = getLegacySensorType(type);
            mapSensorDataToWindow(legacySensorType, fArr, LegacySensorManager.getRotation());
            if (type != 3) {
                this.mTarget.onSensorChanged(legacySensorType, fArr);
                return;
            }
            if ((this.mSensors & 128) != 0) {
                this.mTarget.onSensorChanged(128, fArr);
            }
            if ((this.mSensors & 1) != 0) {
                fArr[0] = this.mYawfilter.filter(sensorEvent.timestamp, fArr[0]);
                this.mTarget.onSensorChanged(1, fArr);
            }
        }

        boolean registerSensor(int i) {
            if ((this.mSensors & i) != 0) {
                return false;
            }
            boolean hasOrientationSensor = hasOrientationSensor(this.mSensors);
            this.mSensors |= i;
            return (hasOrientationSensor && hasOrientationSensor(i)) ? false : true;
        }

        boolean unregisterSensor(int i) {
            if ((this.mSensors & i) == 0) {
                return false;
            }
            this.mSensors &= i ^ (-1);
            return (hasOrientationSensor(i) && hasOrientationSensor(this.mSensors)) ? false : true;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/LegacySensorManager$LmsFilter.class */
    private static final class LmsFilter {
        private static final int COUNT = 12;
        private static final float PREDICTION_RATIO = 0.33333334f;
        private static final float PREDICTION_TIME = 0.08f;
        private static final int SENSORS_RATE_MS = 20;
        private float[] mV = new float[24];
        private long[] mT = new long[24];
        private int mIndex = 12;

        public float filter(long j, float f) {
            float f2;
            float f3 = this.mV[this.mIndex];
            if (f - f3 > 180.0f) {
                f2 = f - 360.0f;
            } else {
                f2 = f;
                if (f3 - f > 180.0f) {
                    f2 = f + 360.0f;
                }
            }
            this.mIndex++;
            if (this.mIndex >= 24) {
                this.mIndex = 12;
            }
            this.mV[this.mIndex] = f2;
            this.mT[this.mIndex] = j;
            this.mV[this.mIndex - 12] = f2;
            this.mT[this.mIndex - 12] = j;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 11) {
                    break;
                }
                int i3 = (this.mIndex - 1) - i2;
                float f9 = this.mV[i3];
                float f10 = ((float) (((this.mT[i3] / 2) + (this.mT[i3 + 1] / 2)) - j)) * 1.0E-9f;
                float f11 = ((float) (this.mT[i3] - this.mT[i3 + 1])) * 1.0E-9f;
                float f12 = f11 * f11;
                f8 += f9 * f12;
                f7 += f10 * f12 * f10;
                f6 += f10 * f12;
                f5 += f10 * f12 * f9;
                f4 += f12;
                i = i2 + 1;
            }
            float f13 = ((f8 * f7) + (f6 * f5)) / ((f4 * f7) + (f6 * f6));
            float f14 = (f13 + (PREDICTION_TIME * (((f4 * f13) - f8) / f6))) * 0.0027777778f;
            float f15 = f14;
            if ((f14 >= 0.0f ? f14 : -f14) >= 0.5f) {
                f15 = (f14 - ((float) Math.ceil(0.5f + f14))) + 1.0f;
            }
            float f16 = f15;
            if (f15 < 0.0f) {
                f16 = f15 + 1.0f;
            }
            return f16 * 360.0f;
        }
    }

    public LegacySensorManager(SensorManager sensorManager) {
        this.mSensorManager = sensorManager;
        synchronized (SensorManager.class) {
            try {
                if (!sInitialized) {
                    sWindowManager = IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
                    if (sWindowManager != null) {
                        try {
                            sRotation = sWindowManager.watchRotation(new IRotationWatcher.Stub() { // from class: android.hardware.LegacySensorManager.1
                                @Override // android.view.IRotationWatcher
                                public void onRotationChanged(int i) {
                                    LegacySensorManager.onRotationChanged(i);
                                }
                            });
                        } catch (RemoteException e) {
                        }
                    }
                }
            } finally {
            }
        }
    }

    static int getRotation() {
        int i;
        synchronized (SensorManager.class) {
            try {
                i = sRotation;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    static void onRotationChanged(int i) {
        synchronized (SensorManager.class) {
            try {
                sRotation = i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean registerLegacyListener(int i, int i2, SensorListener sensorListener, int i3, int i4) {
        Sensor defaultSensor;
        boolean registerListener;
        if ((i3 & i) == 0 || (defaultSensor = this.mSensorManager.getDefaultSensor(i2)) == null) {
            return false;
        }
        synchronized (this.mLegacyListenersMap) {
            LegacyListener legacyListener = this.mLegacyListenersMap.get(sensorListener);
            LegacyListener legacyListener2 = legacyListener;
            if (legacyListener == null) {
                legacyListener2 = new LegacyListener(sensorListener);
                this.mLegacyListenersMap.put(sensorListener, legacyListener2);
            }
            registerListener = legacyListener2.registerSensor(i) ? this.mSensorManager.registerListener(legacyListener2, defaultSensor, i4) : true;
        }
        return registerListener;
    }

    private void unregisterLegacyListener(int i, int i2, SensorListener sensorListener, int i3) {
        Sensor defaultSensor;
        if ((i3 & i) == 0 || (defaultSensor = this.mSensorManager.getDefaultSensor(i2)) == null) {
            return;
        }
        synchronized (this.mLegacyListenersMap) {
            LegacyListener legacyListener = this.mLegacyListenersMap.get(sensorListener);
            if (legacyListener != null && legacyListener.unregisterSensor(i)) {
                this.mSensorManager.unregisterListener(legacyListener, defaultSensor);
                if (!legacyListener.hasSensors()) {
                    this.mLegacyListenersMap.remove(sensorListener);
                }
            }
        }
    }

    public int getSensors() {
        int i = 0;
        for (Sensor sensor : this.mSensorManager.getFullSensorList()) {
            switch (sensor.getType()) {
                case 1:
                    i |= 2;
                    break;
                case 2:
                    i |= 8;
                    break;
                case 3:
                    i |= 129;
                    break;
            }
        }
        return i;
    }

    public boolean registerListener(SensorListener sensorListener, int i, int i2) {
        if (sensorListener == null) {
            return false;
        }
        return registerLegacyListener(4, 7, sensorListener, i, i2) || (registerLegacyListener(1, 3, sensorListener, i, i2) || (registerLegacyListener(128, 3, sensorListener, i, i2) || (registerLegacyListener(8, 2, sensorListener, i, i2) || (registerLegacyListener(2, 1, sensorListener, i, i2) || 0 != 0))));
    }

    public void unregisterListener(SensorListener sensorListener, int i) {
        if (sensorListener == null) {
            return;
        }
        unregisterLegacyListener(2, 1, sensorListener, i);
        unregisterLegacyListener(8, 2, sensorListener, i);
        unregisterLegacyListener(128, 3, sensorListener, i);
        unregisterLegacyListener(1, 3, sensorListener, i);
        unregisterLegacyListener(4, 7, sensorListener, i);
    }
}
