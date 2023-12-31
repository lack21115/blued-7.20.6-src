package android.hardware;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/Sensor.class */
public final class Sensor {
    public static final int REPORTING_MODE_CONTINUOUS = 0;
    private static final int REPORTING_MODE_MASK = 14;
    public static final int REPORTING_MODE_ONE_SHOT = 2;
    public static final int REPORTING_MODE_ON_CHANGE = 1;
    private static final int REPORTING_MODE_SHIFT = 1;
    public static final int REPORTING_MODE_SPECIAL_TRIGGER = 3;
    private static final int SENSOR_FLAG_WAKE_UP_SENSOR = 1;
    public static final String SENSOR_STRING_TYPE_TILT_DETECTOR = "android.sensor.tilt_detector";
    public static final String STRING_TYPE_ACCELEROMETER = "android.sensor.accelerometer";
    public static final String STRING_TYPE_AMBIENT_TEMPERATURE = "android.sensor.ambient_temperature";
    public static final String STRING_TYPE_GAME_ROTATION_VECTOR = "android.sensor.game_rotation_vector";
    public static final String STRING_TYPE_GEOMAGNETIC_ROTATION_VECTOR = "android.sensor.geomagnetic_rotation_vector";
    public static final String STRING_TYPE_GLANCE_GESTURE = "android.sensor.glance_gesture";
    public static final String STRING_TYPE_GRAVITY = "android.sensor.gravity";
    public static final String STRING_TYPE_GYROSCOPE = "android.sensor.gyroscope";
    public static final String STRING_TYPE_GYROSCOPE_UNCALIBRATED = "android.sensor.gyroscope_uncalibrated";
    public static final String STRING_TYPE_HEART_RATE = "android.sensor.heart_rate";
    public static final String STRING_TYPE_LIGHT = "android.sensor.light";
    public static final String STRING_TYPE_LINEAR_ACCELERATION = "android.sensor.linear_acceleration";
    public static final String STRING_TYPE_MAGNETIC_FIELD = "android.sensor.magnetic_field";
    public static final String STRING_TYPE_MAGNETIC_FIELD_UNCALIBRATED = "android.sensor.magnetic_field_uncalibrated";
    @Deprecated
    public static final String STRING_TYPE_ORIENTATION = "android.sensor.orientation";
    public static final String STRING_TYPE_PICK_UP_GESTURE = "android.sensor.pick_up_gesture";
    public static final String STRING_TYPE_PRESSURE = "android.sensor.pressure";
    public static final String STRING_TYPE_PROXIMITY = "android.sensor.proximity";
    public static final String STRING_TYPE_RELATIVE_HUMIDITY = "android.sensor.relative_humidity";
    public static final String STRING_TYPE_ROTATION_VECTOR = "android.sensor.rotation_vector";
    public static final String STRING_TYPE_SIGNIFICANT_MOTION = "android.sensor.significant_motion";
    public static final String STRING_TYPE_STEP_COUNTER = "android.sensor.step_counter";
    public static final String STRING_TYPE_STEP_DETECTOR = "android.sensor.step_detector";
    @Deprecated
    public static final String STRING_TYPE_TEMPERATURE = "android.sensor.temperature";
    public static final String STRING_TYPE_WAKE_GESTURE = "android.sensor.wake_gesture";
    public static final int TYPE_ACCELEROMETER = 1;
    public static final int TYPE_ALL = -1;
    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
    public static final int TYPE_GAME_ROTATION_VECTOR = 15;
    public static final int TYPE_GEOMAGNETIC_ROTATION_VECTOR = 20;
    public static final int TYPE_GLANCE_GESTURE = 24;
    public static final int TYPE_GRAVITY = 9;
    public static final int TYPE_GYROSCOPE = 4;
    public static final int TYPE_GYROSCOPE_UNCALIBRATED = 16;
    public static final int TYPE_HEART_RATE = 21;
    public static final int TYPE_LIGHT = 5;
    public static final int TYPE_LINEAR_ACCELERATION = 10;
    public static final int TYPE_MAGNETIC_FIELD = 2;
    public static final int TYPE_MAGNETIC_FIELD_UNCALIBRATED = 14;
    public static final int TYPE_MOTION_ACCEL = 33171011;
    @Deprecated
    public static final int TYPE_ORIENTATION = 3;
    public static final int TYPE_PICK_UP_GESTURE = 25;
    public static final int TYPE_PRESSURE = 6;
    public static final int TYPE_PROXIMITY = 8;
    public static final int TYPE_RELATIVE_HUMIDITY = 12;
    public static final int TYPE_ROTATION_VECTOR = 11;
    public static final int TYPE_SIGNIFICANT_MOTION = 17;
    public static final int TYPE_STEP_COUNTER = 19;
    public static final int TYPE_STEP_DETECTOR = 18;
    @Deprecated
    public static final int TYPE_TEMPERATURE = 7;
    public static final int TYPE_TILT_DETECTOR = 22;
    public static final int TYPE_WAKE_GESTURE = 23;
    private static final int[] sSensorReportingModes = {0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 3, 3, 6, 4, 6, 1, 1, 1, 5, 1, 1, 1, 1, 1};
    private int mFifoMaxEventCount;
    private int mFifoReservedEventCount;
    private int mFlags;
    private int mHandle;
    private int mMaxDelay;
    private float mMaxRange;
    private int mMinDelay;
    private String mName;
    private float mPower;
    private String mRequiredPermission;
    private float mResolution;
    private String mStringType;
    private int mType;
    private String mVendor;
    private int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getMaxLengthValuesArray(Sensor sensor, int i) {
        if (sensor.mType != 11 || i > 17) {
            int i2 = sensor.mType;
            if (i2 >= sSensorReportingModes.length) {
                return 16;
            }
            return sSensorReportingModes[i2];
        }
        return 3;
    }

    public int getFifoMaxEventCount() {
        return this.mFifoMaxEventCount;
    }

    public int getFifoReservedEventCount() {
        return this.mFifoReservedEventCount;
    }

    public int getHandle() {
        return this.mHandle;
    }

    public int getMaxDelay() {
        return this.mMaxDelay;
    }

    public float getMaximumRange() {
        return this.mMaxRange;
    }

    public int getMinDelay() {
        return this.mMinDelay;
    }

    public String getName() {
        return this.mName;
    }

    public float getPower() {
        return this.mPower;
    }

    public int getReportingMode() {
        return (this.mFlags & 14) >> 1;
    }

    public String getRequiredPermission() {
        return this.mRequiredPermission;
    }

    public float getResolution() {
        return this.mResolution;
    }

    public String getStringType() {
        return this.mStringType;
    }

    public int getType() {
        return this.mType;
    }

    public String getVendor() {
        return this.mVendor;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean isWakeUpSensor() {
        return (this.mFlags & 1) != 0;
    }

    void setRange(float f, float f2) {
        this.mMaxRange = f;
        this.mResolution = f2;
    }

    public String toString() {
        return "{Sensor name=\"" + this.mName + "\", vendor=\"" + this.mVendor + "\", version=" + this.mVersion + ", type=" + this.mType + ", maxRange=" + this.mMaxRange + ", resolution=" + this.mResolution + ", power=" + this.mPower + ", minDelay=" + this.mMinDelay + "}";
    }
}
