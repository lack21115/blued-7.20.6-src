package com.zego.ve;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/SensorHelper.class */
public class SensorHelper implements SensorEventListener {
    private static final float ACCELERATION_TOLERANCE = 4.0f;
    private static final int ACCELEROMETER_DATA_X = 0;
    private static final int ACCELEROMETER_DATA_Y = 1;
    private static final int ACCELEROMETER_DATA_Z = 2;
    private static final int ADJACENT_ORIENTATION_ANGLE_GAP = 45;
    private static final float FILTER_TIME_CONSTANT_MS = 200.0f;
    private static final float MAX_ACCELERATION_MAGNITUDE = 13.80665f;
    private static final long MAX_FILTER_DELTA_TIME_NANOS = 1000000000;
    private static final int MAX_TILT = 80;
    private static final float MIN_ACCELERATION_MAGNITUDE = 5.80665f;
    protected static final long NANOS_PER_MS = 1000000;
    private static final float NEAR_ZERO_MAGNITUDE = 1.0f;
    private static final long PROPOSAL_MIN_TIME_SINCE_ACCELERATION_ENDED_NANOS = 500000000;
    private static final long PROPOSAL_MIN_TIME_SINCE_FLAT_ENDED_NANOS = 500000000;
    private static final long PROPOSAL_MIN_TIME_SINCE_SWING_ENDED_NANOS = 300000000;
    private static final long PROPOSAL_SETTLE_TIME_NANOS = 40000000;
    private static final float RADIANS_TO_DEGREES = 57.29578f;
    private static final String TAG = "SensorHelper";
    private static final int TILT_HISTORY_SIZE = 200;
    private static final int TILT_OVERHEAD_ENTER = -40;
    private static final int TILT_OVERHEAD_EXIT = -15;
    private boolean mAccelerating;
    private long mAccelerationTimestampNanos;
    private boolean mFlat;
    private long mFlatTimestampNanos;
    private long mLastFilteredTimestampNanos;
    private float mLastFilteredX;
    private float mLastFilteredY;
    private float mLastFilteredZ;
    private boolean mOverhead;
    private int mPredictedRotation;
    private long mPredictedRotationTimestampNanos;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private long mSwingTimestampNanos;
    private boolean mSwinging;
    private int mTiltHistoryIndex;
    private long pthis = 0;
    private Object mLock = new Object();
    private Boolean mIsStarted = false;
    private int mProposedRotation = -1;
    private int mCurrentRotation = -1;
    private float[] mTiltHistory = new float[200];
    private long[] mTiltHistoryTimestampNanos = new long[200];
    private final int[][] mTiltToleranceConfig = {new int[]{-25, 70}, new int[]{-25, 65}, new int[]{-25, 60}, new int[]{-25, 65}};

    private void addTiltHistoryEntryLocked(long j, float f) {
        float[] fArr = this.mTiltHistory;
        int i = this.mTiltHistoryIndex;
        fArr[i] = f;
        long[] jArr = this.mTiltHistoryTimestampNanos;
        jArr[i] = j;
        int i2 = (i + 1) % 200;
        this.mTiltHistoryIndex = i2;
        jArr[i2] = Long.MIN_VALUE;
    }

    private void clearPredictedRotationLocked() {
        this.mPredictedRotation = -1;
        this.mPredictedRotationTimestampNanos = Long.MIN_VALUE;
    }

    private void clearTiltHistoryLocked() {
        this.mTiltHistoryTimestampNanos[0] = Long.MIN_VALUE;
        this.mTiltHistoryIndex = 1;
    }

    private float getLastTiltLocked() {
        int nextTiltHistoryIndexLocked = nextTiltHistoryIndexLocked(this.mTiltHistoryIndex);
        if (nextTiltHistoryIndexLocked >= 0) {
            return this.mTiltHistory[nextTiltHistoryIndexLocked];
        }
        return Float.NaN;
    }

    private boolean isFlatLocked(long j) {
        int nextTiltHistoryIndexLocked;
        int i = this.mTiltHistoryIndex;
        do {
            nextTiltHistoryIndexLocked = nextTiltHistoryIndexLocked(i);
            if (nextTiltHistoryIndexLocked < 0 || this.mTiltHistory[nextTiltHistoryIndexLocked] < 80.0f) {
                return false;
            }
            i = nextTiltHistoryIndexLocked;
        } while (this.mTiltHistoryTimestampNanos[nextTiltHistoryIndexLocked] + 1000000000 > j);
        return true;
    }

    private boolean isOrientationAngleAcceptableLocked(int i, int i2) {
        int i3 = this.mCurrentRotation;
        if (i3 >= 0) {
            if (i == i3 || i == (i3 + 1) % 4) {
                int i4 = ((i * 90) - 45) + 22;
                if (i == 0) {
                    if (i2 >= 315 && i2 < i4 + 360) {
                        return false;
                    }
                } else if (i2 < i4) {
                    return false;
                }
            }
            if (i == i3 || i == (i3 + 3) % 4) {
                int i5 = ((i * 90) + 45) - 22;
                return i == 0 ? i2 > 45 || i2 <= i5 : i2 <= i5;
            }
            return true;
        }
        return true;
    }

    private boolean isPredictedRotationAcceptableLocked(long j) {
        return j >= this.mPredictedRotationTimestampNanos + PROPOSAL_SETTLE_TIME_NANOS && j >= this.mFlatTimestampNanos + 500000000 && j >= this.mSwingTimestampNanos + PROPOSAL_MIN_TIME_SINCE_SWING_ENDED_NANOS && j >= this.mAccelerationTimestampNanos + 500000000;
    }

    private boolean isSwingingLocked(long j, float f) {
        int nextTiltHistoryIndexLocked;
        int i = this.mTiltHistoryIndex;
        do {
            nextTiltHistoryIndexLocked = nextTiltHistoryIndexLocked(i);
            if (nextTiltHistoryIndexLocked < 0 || this.mTiltHistoryTimestampNanos[nextTiltHistoryIndexLocked] + PROPOSAL_MIN_TIME_SINCE_SWING_ENDED_NANOS < j) {
                return false;
            }
            i = nextTiltHistoryIndexLocked;
        } while (this.mTiltHistory[nextTiltHistoryIndexLocked] + 20.0f > f);
        return true;
    }

    private boolean isTiltAngleAcceptableLocked(int i, int i2) {
        int[][] iArr = this.mTiltToleranceConfig;
        boolean z = false;
        if (i2 >= iArr[i][0]) {
            z = false;
            if (i2 <= iArr[i][1]) {
                z = true;
            }
        }
        return z;
    }

    private int nextTiltHistoryIndexLocked(int i) {
        int i2 = i;
        if (i == 0) {
            i2 = 200;
        }
        int i3 = i2 - 1;
        if (this.mTiltHistoryTimestampNanos[i3] != Long.MIN_VALUE) {
            return i3;
        }
        return -1;
    }

    private static native int on_rotation(long j, int i);

    private float remainingMS(long j, long j2) {
        if (j >= j2) {
            return 0.0f;
        }
        return ((float) (j2 - j)) * 1.0E-6f;
    }

    private void updatePredictedRotationLocked(long j, int i) {
        if (this.mPredictedRotation != i) {
            this.mPredictedRotation = i;
            this.mPredictedRotationTimestampNanos = j;
        }
    }

    public void create(long j, Context context) {
        this.pthis = j;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.mSensor = sensorManager.getDefaultSensor(1);
    }

    public void destroy() {
        synchronized (this.mLock) {
            this.pthis = 0L;
        }
        stop();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        int i2;
        synchronized (this.mLock) {
            boolean z4 = false;
            int i3 = 0;
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            long j = sensorEvent.timestamp;
            long j2 = this.mLastFilteredTimestampNanos;
            float f4 = ((float) (j - j2)) * 1.0E-6f;
            if (j < j2 || j > j2 + 1000000000 || (f == 0.0f && f2 == 0.0f && f3 == 0.0f)) {
                resetLocked(true);
                z = true;
            } else {
                float f5 = f4 / (200.0f + f4);
                f = ((f - this.mLastFilteredX) * f5) + this.mLastFilteredX;
                f2 = ((f2 - this.mLastFilteredY) * f5) + this.mLastFilteredY;
                f3 = this.mLastFilteredZ + (f5 * (f3 - this.mLastFilteredZ));
                z = false;
            }
            this.mLastFilteredTimestampNanos = j;
            this.mLastFilteredX = f;
            this.mLastFilteredY = f2;
            this.mLastFilteredZ = f3;
            if (!z) {
                float sqrt = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
                if (sqrt < 1.0f) {
                    clearPredictedRotationLocked();
                } else {
                    if (sqrt < MIN_ACCELERATION_MAGNITUDE || sqrt > MAX_ACCELERATION_MAGNITUDE) {
                        this.mAccelerationTimestampNanos = j;
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    int round = (int) Math.round(Math.asin(f3 / sqrt) * 57.295780181884766d);
                    float f6 = round;
                    addTiltHistoryEntryLocked(j, f6);
                    if (isFlatLocked(j)) {
                        this.mFlatTimestampNanos = j;
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (isSwingingLocked(j, f6)) {
                        this.mSwingTimestampNanos = j;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (round <= TILT_OVERHEAD_ENTER) {
                        this.mOverhead = true;
                    } else if (round >= -15) {
                        this.mOverhead = false;
                    }
                    if (this.mOverhead) {
                        clearPredictedRotationLocked();
                    } else if (Math.abs(round) > 80) {
                        clearPredictedRotationLocked();
                    } else {
                        int round2 = (int) Math.round((-Math.atan2(-f, f2)) * 57.295780181884766d);
                        int i4 = round2;
                        if (round2 < 0) {
                            i4 = round2 + 360;
                        }
                        int i5 = (i4 + 45) / 90;
                        if (i5 != 4) {
                            i3 = i5;
                        }
                        if (isTiltAngleAcceptableLocked(i3, round) && isOrientationAngleAcceptableLocked(i3, i4)) {
                            updatePredictedRotationLocked(j, i3);
                        } else {
                            clearPredictedRotationLocked();
                        }
                    }
                    this.mFlat = z4;
                    this.mSwinging = z2;
                    this.mAccelerating = z3;
                    i = this.mProposedRotation;
                    if (this.mPredictedRotation >= 0 || isPredictedRotationAcceptableLocked(j)) {
                        this.mProposedRotation = this.mPredictedRotation;
                    }
                    i2 = this.mProposedRotation;
                }
            }
            z2 = false;
            z3 = false;
            this.mFlat = z4;
            this.mSwinging = z2;
            this.mAccelerating = z3;
            i = this.mProposedRotation;
            if (this.mPredictedRotation >= 0) {
            }
            this.mProposedRotation = this.mPredictedRotation;
            i2 = this.mProposedRotation;
        }
        if (i2 == i || i2 < 0) {
            return;
        }
        Log.d(TAG, "rotation changed to: " + i2);
        long j3 = this.pthis;
        if (j3 != 0) {
            on_rotation(j3, i2);
        } else {
            android.util.Log.d(TAG, "ignore callback:");
        }
    }

    public void resetLocked(boolean z) {
        this.mLastFilteredTimestampNanos = Long.MIN_VALUE;
        if (z) {
            this.mProposedRotation = -1;
        }
        this.mFlatTimestampNanos = Long.MIN_VALUE;
        this.mFlat = false;
        this.mSwingTimestampNanos = Long.MIN_VALUE;
        this.mSwinging = false;
        this.mAccelerationTimestampNanos = Long.MIN_VALUE;
        this.mAccelerating = false;
        this.mOverhead = false;
        clearPredictedRotationLocked();
        clearTiltHistoryLocked();
    }

    public void start() {
        synchronized (this.mLock) {
            if (!this.mIsStarted.booleanValue()) {
                this.mSensorManager.registerListener(this, this.mSensor, 3);
                this.mIsStarted = true;
            }
        }
    }

    public void stop() {
        synchronized (this.mLock) {
            if (this.mIsStarted.booleanValue()) {
                this.mSensorManager.unregisterListener(this, this.mSensor);
                this.mIsStarted = false;
            }
        }
    }
}
