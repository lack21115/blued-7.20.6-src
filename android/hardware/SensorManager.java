package android.hardware;

import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import com.sobot.chat.camera.StCameraView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/SensorManager.class */
public abstract class SensorManager {
    public static final int AXIS_MINUS_X = 129;
    public static final int AXIS_MINUS_Y = 130;
    public static final int AXIS_MINUS_Z = 131;
    public static final int AXIS_X = 1;
    public static final int AXIS_Y = 2;
    public static final int AXIS_Z = 3;
    @Deprecated
    public static final int DATA_X = 0;
    @Deprecated
    public static final int DATA_Y = 1;
    @Deprecated
    public static final int DATA_Z = 2;
    public static final float GRAVITY_DEATH_STAR_I = 3.5303614E-7f;
    public static final float GRAVITY_EARTH = 9.80665f;
    public static final float GRAVITY_JUPITER = 23.12f;
    public static final float GRAVITY_MARS = 3.71f;
    public static final float GRAVITY_MERCURY = 3.7f;
    public static final float GRAVITY_MOON = 1.6f;
    public static final float GRAVITY_NEPTUNE = 11.0f;
    public static final float GRAVITY_PLUTO = 0.6f;
    public static final float GRAVITY_SATURN = 8.96f;
    public static final float GRAVITY_SUN = 275.0f;
    public static final float GRAVITY_THE_ISLAND = 4.815162f;
    public static final float GRAVITY_URANUS = 8.69f;
    public static final float GRAVITY_VENUS = 8.87f;
    public static final float LIGHT_CLOUDY = 100.0f;
    public static final float LIGHT_FULLMOON = 0.25f;
    public static final float LIGHT_NO_MOON = 0.001f;
    public static final float LIGHT_OVERCAST = 10000.0f;
    public static final float LIGHT_SHADE = 20000.0f;
    public static final float LIGHT_SUNLIGHT = 110000.0f;
    public static final float LIGHT_SUNLIGHT_MAX = 120000.0f;
    public static final float LIGHT_SUNRISE = 400.0f;
    public static final float MAGNETIC_FIELD_EARTH_MAX = 60.0f;
    public static final float MAGNETIC_FIELD_EARTH_MIN = 30.0f;
    public static final float PRESSURE_STANDARD_ATMOSPHERE = 1013.25f;
    @Deprecated
    public static final int RAW_DATA_INDEX = 3;
    @Deprecated
    public static final int RAW_DATA_X = 3;
    @Deprecated
    public static final int RAW_DATA_Y = 4;
    @Deprecated
    public static final int RAW_DATA_Z = 5;
    @Deprecated
    public static final int SENSOR_ACCELEROMETER = 2;
    @Deprecated
    public static final int SENSOR_ALL = 127;
    public static final int SENSOR_DELAY_FASTEST = 0;
    public static final int SENSOR_DELAY_GAME = 1;
    public static final int SENSOR_DELAY_NORMAL = 3;
    public static final int SENSOR_DELAY_UI = 2;
    @Deprecated
    public static final int SENSOR_LIGHT = 16;
    @Deprecated
    public static final int SENSOR_MAGNETIC_FIELD = 8;
    @Deprecated
    public static final int SENSOR_MAX = 64;
    @Deprecated
    public static final int SENSOR_MIN = 1;
    @Deprecated
    public static final int SENSOR_ORIENTATION = 1;
    @Deprecated
    public static final int SENSOR_ORIENTATION_RAW = 128;
    @Deprecated
    public static final int SENSOR_PROXIMITY = 32;
    public static final int SENSOR_STATUS_ACCURACY_HIGH = 3;
    public static final int SENSOR_STATUS_ACCURACY_LOW = 1;
    public static final int SENSOR_STATUS_ACCURACY_MEDIUM = 2;
    public static final int SENSOR_STATUS_NO_CONTACT = -1;
    public static final int SENSOR_STATUS_UNRELIABLE = 0;
    @Deprecated
    public static final int SENSOR_TEMPERATURE = 4;
    @Deprecated
    public static final int SENSOR_TRICORDER = 64;
    public static final float STANDARD_GRAVITY = 9.80665f;
    protected static final String TAG = "SensorManager";
    private static final float[] mTempMatrix = new float[16];
    private LegacySensorManager mLegacySensorManager;
    private final SparseArray<List<Sensor>> mSensorListByType = new SparseArray<>();

    public static float getAltitude(float f, float f2) {
        return 44330.0f * (1.0f - ((float) Math.pow(f2 / f, 0.19029495120048523d)));
    }

    public static void getAngleChange(float[] fArr, float[] fArr2, float[] fArr3) {
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        if (fArr2.length == 9) {
            f = fArr2[0];
            f2 = fArr2[1];
            f3 = fArr2[2];
            f4 = fArr2[3];
            f5 = fArr2[4];
            f6 = fArr2[5];
            f7 = fArr2[6];
            f8 = fArr2[7];
            f9 = fArr2[8];
        } else if (fArr2.length == 16) {
            f = fArr2[0];
            f2 = fArr2[1];
            f3 = fArr2[2];
            f4 = fArr2[4];
            f5 = fArr2[5];
            f6 = fArr2[6];
            f7 = fArr2[8];
            f8 = fArr2[9];
            f9 = fArr2[10];
        }
        if (fArr3.length == 9) {
            f10 = fArr3[0];
            f11 = fArr3[1];
            f12 = fArr3[2];
            f13 = fArr3[3];
            f14 = fArr3[4];
            f15 = fArr3[5];
            f16 = fArr3[6];
            f17 = fArr3[7];
            f18 = fArr3[8];
        } else if (fArr3.length == 16) {
            f10 = fArr3[0];
            f11 = fArr3[1];
            f12 = fArr3[2];
            f13 = fArr3[4];
            f14 = fArr3[5];
            f15 = fArr3[6];
            f16 = fArr3[8];
            f17 = fArr3[9];
            f18 = fArr3[10];
        }
        fArr[0] = (float) Math.atan2((f10 * f2) + (f13 * f5) + (f16 * f8), (f11 * f2) + (f14 * f5) + (f17 * f8));
        fArr[1] = (float) Math.asin(-((f12 * f2) + (f15 * f5) + (f18 * f8)));
        fArr[2] = (float) Math.atan2(-((f12 * f) + (f15 * f4) + (f18 * f7)), (f12 * f3) + (f15 * f6) + (f18 * f9));
    }

    private static int getDelay(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 20000;
            case 2:
                return 66667;
            case 3:
                return StCameraView.MEDIA_QUALITY_DESPAIR;
            default:
                return i;
        }
    }

    public static float getInclination(float[] fArr) {
        return fArr.length == 9 ? (float) Math.atan2(fArr[5], fArr[4]) : (float) Math.atan2(fArr[6], fArr[5]);
    }

    private LegacySensorManager getLegacySensorManager() {
        LegacySensorManager legacySensorManager;
        synchronized (this.mSensorListByType) {
            if (this.mLegacySensorManager == null) {
                Log.i(TAG, "This application is using deprecated SensorManager API which will be removed someday.  Please consider switching to the new API.");
                this.mLegacySensorManager = new LegacySensorManager(this);
            }
            legacySensorManager = this.mLegacySensorManager;
        }
        return legacySensorManager;
    }

    public static float[] getOrientation(float[] fArr, float[] fArr2) {
        if (fArr.length == 9) {
            fArr2[0] = (float) Math.atan2(fArr[1], fArr[4]);
            fArr2[1] = (float) Math.asin(-fArr[7]);
            fArr2[2] = (float) Math.atan2(-fArr[6], fArr[8]);
            return fArr2;
        }
        fArr2[0] = (float) Math.atan2(fArr[1], fArr[5]);
        fArr2[1] = (float) Math.asin(-fArr[9]);
        fArr2[2] = (float) Math.atan2(-fArr[8], fArr[10]);
        return fArr2;
    }

    public static void getQuaternionFromVector(float[] fArr, float[] fArr2) {
        float f = 0.0f;
        if (fArr2.length >= 4) {
            fArr[0] = fArr2[3];
        } else {
            fArr[0] = ((1.0f - (fArr2[0] * fArr2[0])) - (fArr2[1] * fArr2[1])) - (fArr2[2] * fArr2[2]);
            if (fArr[0] > 0.0f) {
                f = (float) Math.sqrt(fArr[0]);
            }
            fArr[0] = f;
        }
        fArr[1] = fArr2[0];
        fArr[2] = fArr2[1];
        fArr[3] = fArr2[2];
    }

    public static boolean getRotationMatrix(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        float f = fArr3[0];
        float f2 = fArr3[1];
        float f3 = fArr3[2];
        float f4 = fArr4[0];
        float f5 = fArr4[1];
        float f6 = fArr4[2];
        float f7 = (f5 * f3) - (f6 * f2);
        float f8 = (f6 * f) - (f4 * f3);
        float f9 = (f4 * f2) - (f5 * f);
        float sqrt = (float) Math.sqrt((f7 * f7) + (f8 * f8) + (f9 * f9));
        if (sqrt < 0.1f) {
            return false;
        }
        float f10 = 1.0f / sqrt;
        float f11 = f7 * f10;
        float f12 = f8 * f10;
        float f13 = f9 * f10;
        float sqrt2 = 1.0f / ((float) Math.sqrt(((f * f) + (f2 * f2)) + (f3 * f3)));
        float f14 = f * sqrt2;
        float f15 = f2 * sqrt2;
        float f16 = f3 * sqrt2;
        float f17 = (f15 * f13) - (f16 * f12);
        float f18 = (f16 * f11) - (f14 * f13);
        float f19 = (f14 * f12) - (f15 * f11);
        if (fArr != null) {
            if (fArr.length == 9) {
                fArr[0] = f11;
                fArr[1] = f12;
                fArr[2] = f13;
                fArr[3] = f17;
                fArr[4] = f18;
                fArr[5] = f19;
                fArr[6] = f14;
                fArr[7] = f15;
                fArr[8] = f16;
            } else if (fArr.length == 16) {
                fArr[0] = f11;
                fArr[1] = f12;
                fArr[2] = f13;
                fArr[3] = 0.0f;
                fArr[4] = f17;
                fArr[5] = f18;
                fArr[6] = f19;
                fArr[7] = 0.0f;
                fArr[8] = f14;
                fArr[9] = f15;
                fArr[10] = f16;
                fArr[11] = 0.0f;
                fArr[12] = 0.0f;
                fArr[13] = 0.0f;
                fArr[14] = 0.0f;
                fArr[15] = 1.0f;
            }
        }
        if (fArr2 != null) {
            float sqrt3 = 1.0f / ((float) Math.sqrt(((f4 * f4) + (f5 * f5)) + (f6 * f6)));
            float f20 = ((f4 * f17) + (f5 * f18) + (f6 * f19)) * sqrt3;
            float f21 = ((f4 * f14) + (f5 * f15) + (f6 * f16)) * sqrt3;
            if (fArr2.length == 9) {
                fArr2[0] = 1.0f;
                fArr2[1] = 0.0f;
                fArr2[2] = 0.0f;
                fArr2[3] = 0.0f;
                fArr2[4] = f20;
                fArr2[5] = f21;
                fArr2[6] = 0.0f;
                fArr2[7] = -f21;
                fArr2[8] = f20;
                return true;
            } else if (fArr2.length == 16) {
                fArr2[0] = 1.0f;
                fArr2[1] = 0.0f;
                fArr2[2] = 0.0f;
                fArr2[4] = 0.0f;
                fArr2[5] = f20;
                fArr2[6] = f21;
                fArr2[8] = 0.0f;
                fArr2[9] = -f21;
                fArr2[10] = f20;
                fArr2[14] = 0.0f;
                fArr2[13] = 0.0f;
                fArr2[12] = 0.0f;
                fArr2[11] = 0.0f;
                fArr2[7] = 0.0f;
                fArr2[3] = 0.0f;
                fArr2[15] = 1.0f;
                return true;
            } else {
                return true;
            }
        }
        return true;
    }

    public static void getRotationMatrixFromVector(float[] fArr, float[] fArr2) {
        float sqrt;
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        if (fArr2.length >= 4) {
            sqrt = fArr2[3];
        } else {
            float f4 = ((1.0f - (f * f)) - (f2 * f2)) - (f3 * f3);
            sqrt = f4 > 0.0f ? (float) Math.sqrt(f4) : 0.0f;
        }
        float f5 = 2.0f * f * f;
        float f6 = 2.0f * f2 * f2;
        float f7 = 2.0f * f3 * f3;
        float f8 = 2.0f * f * f2;
        float f9 = 2.0f * f3 * sqrt;
        float f10 = 2.0f * f * f3;
        float f11 = 2.0f * f2 * sqrt;
        float f12 = 2.0f * f2 * f3;
        float f13 = 2.0f * f * sqrt;
        if (fArr.length == 9) {
            fArr[0] = (1.0f - f6) - f7;
            fArr[1] = f8 - f9;
            fArr[2] = f10 + f11;
            fArr[3] = f8 + f9;
            fArr[4] = (1.0f - f5) - f7;
            fArr[5] = f12 - f13;
            fArr[6] = f10 - f11;
            fArr[7] = f12 + f13;
            fArr[8] = (1.0f - f5) - f6;
        } else if (fArr.length == 16) {
            fArr[0] = (1.0f - f6) - f7;
            fArr[1] = f8 - f9;
            fArr[2] = f10 + f11;
            fArr[3] = 0.0f;
            fArr[4] = f8 + f9;
            fArr[5] = (1.0f - f5) - f7;
            fArr[6] = f12 - f13;
            fArr[7] = 0.0f;
            fArr[8] = f10 - f11;
            fArr[9] = f12 + f13;
            fArr[10] = (1.0f - f5) - f6;
            fArr[11] = 0.0f;
            fArr[14] = 0.0f;
            fArr[13] = 0.0f;
            fArr[12] = 0.0f;
            fArr[15] = 1.0f;
        }
    }

    public static boolean remapCoordinateSystem(float[] fArr, int i, int i2, float[] fArr2) {
        if (fArr == fArr2) {
            float[] fArr3 = mTempMatrix;
            synchronized (fArr3) {
                if (remapCoordinateSystemImpl(fArr, i, i2, fArr3)) {
                    int length = fArr2.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length) {
                            return true;
                        }
                        fArr2[i4] = fArr3[i4];
                        i3 = i4 + 1;
                    }
                }
            }
        }
        return remapCoordinateSystemImpl(fArr, i, i2, fArr2);
    }

    private static boolean remapCoordinateSystemImpl(float[] fArr, int i, int i2, float[] fArr2) {
        int length = fArr2.length;
        if (fArr.length == length && (i & 124) == 0 && (i2 & 124) == 0 && (i & 3) != 0 && (i2 & 3) != 0 && (i & 3) != (i2 & 3)) {
            int i3 = i ^ i2;
            int i4 = (i & 3) - 1;
            int i5 = (i2 & 3) - 1;
            int i6 = (i3 & 3) - 1;
            int i7 = i3;
            if (((i4 ^ ((i6 + 1) % 3)) | (i5 ^ ((i6 + 2) % 3))) != 0) {
                i7 = i3 ^ 128;
            }
            boolean z = i >= 128;
            boolean z2 = i2 >= 128;
            boolean z3 = i7 >= 128;
            int i8 = length == 16 ? 4 : 3;
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= 3) {
                    break;
                }
                int i11 = i10 * i8;
                int i12 = 0;
                while (true) {
                    int i13 = i12;
                    if (i13 < 3) {
                        if (i4 == i13) {
                            fArr2[i11 + i13] = z ? -fArr[i11 + 0] : fArr[i11 + 0];
                        }
                        if (i5 == i13) {
                            fArr2[i11 + i13] = z2 ? -fArr[i11 + 1] : fArr[i11 + 1];
                        }
                        if (i6 == i13) {
                            fArr2[i11 + i13] = z3 ? -fArr[i11 + 2] : fArr[i11 + 2];
                        }
                        i12 = i13 + 1;
                    }
                }
                i9 = i10 + 1;
            }
            if (length == 16) {
                fArr2[14] = 0.0f;
                fArr2[13] = 0.0f;
                fArr2[12] = 0.0f;
                fArr2[11] = 0.0f;
                fArr2[7] = 0.0f;
                fArr2[3] = 0.0f;
                fArr2[15] = 1.0f;
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean cancelTriggerSensor(TriggerEventListener triggerEventListener, Sensor sensor) {
        return cancelTriggerSensorImpl(triggerEventListener, sensor, true);
    }

    protected abstract boolean cancelTriggerSensorImpl(TriggerEventListener triggerEventListener, Sensor sensor, boolean z);

    public boolean flush(SensorEventListener sensorEventListener) {
        return flushImpl(sensorEventListener);
    }

    protected abstract boolean flushImpl(SensorEventListener sensorEventListener);

    public Sensor getDefaultSensor(int i) {
        List<Sensor> sensorList = getSensorList(i);
        boolean z = false;
        z = (i == 8 || i == 17 || i == 22 || i == 23 || i == 24 || i == 25) ? true : true;
        for (Sensor sensor : sensorList) {
            if (sensor.isWakeUpSensor() == z) {
                return sensor;
            }
        }
        return null;
    }

    public Sensor getDefaultSensor(int i, boolean z) {
        for (Sensor sensor : getSensorList(i)) {
            if (sensor.isWakeUpSensor() == z) {
                return sensor;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract List<Sensor> getFullSensorList();

    public List<Sensor> getSensorList(int i) {
        List<Sensor> list;
        ArrayList arrayList;
        List<Sensor> fullSensorList = getFullSensorList();
        synchronized (this.mSensorListByType) {
            List<Sensor> list2 = this.mSensorListByType.get(i);
            list = list2;
            if (list2 == null) {
                if (i != -1) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Sensor> it = fullSensorList.iterator();
                    while (true) {
                        arrayList = arrayList2;
                        if (!it.hasNext()) {
                            break;
                        }
                        Sensor next = it.next();
                        if (next.getType() == i) {
                            arrayList2.add(next);
                        }
                    }
                } else {
                    arrayList = fullSensorList;
                }
                list = Collections.unmodifiableList(arrayList);
                this.mSensorListByType.append(i, list);
            }
        }
        return list;
    }

    @Deprecated
    public int getSensors() {
        return getLegacySensorManager().getSensors();
    }

    public boolean registerListener(SensorEventListener sensorEventListener, Sensor sensor, int i) {
        return registerListener(sensorEventListener, sensor, i, (Handler) null);
    }

    public boolean registerListener(SensorEventListener sensorEventListener, Sensor sensor, int i, int i2) {
        return registerListenerImpl(sensorEventListener, sensor, getDelay(i), null, i2, 0);
    }

    public boolean registerListener(SensorEventListener sensorEventListener, Sensor sensor, int i, int i2, Handler handler) {
        return registerListenerImpl(sensorEventListener, sensor, getDelay(i), handler, i2, 0);
    }

    public boolean registerListener(SensorEventListener sensorEventListener, Sensor sensor, int i, Handler handler) {
        return registerListenerImpl(sensorEventListener, sensor, getDelay(i), handler, 0, 0);
    }

    @Deprecated
    public boolean registerListener(SensorListener sensorListener, int i) {
        return registerListener(sensorListener, i, 3);
    }

    @Deprecated
    public boolean registerListener(SensorListener sensorListener, int i, int i2) {
        return getLegacySensorManager().registerListener(sensorListener, i, i2);
    }

    protected abstract boolean registerListenerImpl(SensorEventListener sensorEventListener, Sensor sensor, int i, Handler handler, int i2, int i3);

    public boolean requestTriggerSensor(TriggerEventListener triggerEventListener, Sensor sensor) {
        return requestTriggerSensorImpl(triggerEventListener, sensor);
    }

    protected abstract boolean requestTriggerSensorImpl(TriggerEventListener triggerEventListener, Sensor sensor);

    public void unregisterListener(SensorEventListener sensorEventListener) {
        if (sensorEventListener == null) {
            return;
        }
        unregisterListenerImpl(sensorEventListener, null);
    }

    public void unregisterListener(SensorEventListener sensorEventListener, Sensor sensor) {
        if (sensorEventListener == null || sensor == null) {
            return;
        }
        unregisterListenerImpl(sensorEventListener, sensor);
    }

    @Deprecated
    public void unregisterListener(SensorListener sensorListener) {
        unregisterListener(sensorListener, 255);
    }

    @Deprecated
    public void unregisterListener(SensorListener sensorListener, int i) {
        getLegacySensorManager().unregisterListener(sensorListener, i);
    }

    protected abstract void unregisterListenerImpl(SensorEventListener sensorEventListener, Sensor sensor);
}
