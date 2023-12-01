package android.hardware;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import dalvik.system.CloseGuard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/SystemSensorManager.class */
public class SystemSensorManager extends SensorManager {
    private final Looper mMainLooper;
    private final int mTargetSdkLevel;
    private static boolean sSensorModuleInitialized = false;
    private static final Object sSensorModuleLock = new Object();
    private static final ArrayList<Sensor> sFullSensorsList = new ArrayList<>();
    private static final SparseArray<Sensor> sHandleToSensor = new SparseArray<>();
    private final HashMap<SensorEventListener, SensorEventQueue> mSensorListeners = new HashMap<>();
    private final HashMap<TriggerEventListener, TriggerEventQueue> mTriggerListeners = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/SystemSensorManager$BaseEventQueue.class */
    public static abstract class BaseEventQueue {
        protected final SystemSensorManager mManager;
        private long nSensorEventQueue;
        private final SparseBooleanArray mActiveSensors = new SparseBooleanArray();
        protected final SparseIntArray mSensorAccuracies = new SparseIntArray();
        protected final SparseBooleanArray mFirstEvent = new SparseBooleanArray();
        private final CloseGuard mCloseGuard = CloseGuard.get();
        private final float[] mScratch = new float[16];

        BaseEventQueue(Looper looper, SystemSensorManager systemSensorManager) {
            this.nSensorEventQueue = nativeInitBaseEventQueue(this, looper.getQueue(), this.mScratch);
            this.mCloseGuard.open("dispose");
            this.mManager = systemSensorManager;
        }

        private int disableSensor(Sensor sensor) {
            if (this.nSensorEventQueue == 0) {
                throw new NullPointerException();
            }
            if (sensor == null) {
                throw new NullPointerException();
            }
            return nativeDisableSensor(this.nSensorEventQueue, sensor.getHandle());
        }

        private void dispose(boolean z) {
            if (this.mCloseGuard != null) {
                if (z) {
                    this.mCloseGuard.warnIfOpen();
                }
                this.mCloseGuard.close();
            }
            if (this.nSensorEventQueue != 0) {
                nativeDestroySensorEventQueue(this.nSensorEventQueue);
                this.nSensorEventQueue = 0L;
            }
        }

        private int enableSensor(Sensor sensor, int i, int i2, int i3) {
            if (this.nSensorEventQueue == 0) {
                throw new NullPointerException();
            }
            if (sensor == null) {
                throw new NullPointerException();
            }
            return nativeEnableSensor(this.nSensorEventQueue, sensor.getHandle(), i, i2, i3);
        }

        private static native void nativeDestroySensorEventQueue(long j);

        private static native int nativeDisableSensor(long j, int i);

        private static native int nativeEnableSensor(long j, int i, int i2, int i3, int i4);

        private static native int nativeFlushSensor(long j);

        private native long nativeInitBaseEventQueue(BaseEventQueue baseEventQueue, MessageQueue messageQueue, float[] fArr);

        public boolean addSensor(Sensor sensor, int i, int i2, int i3) {
            int handle = sensor.getHandle();
            if (this.mActiveSensors.get(handle)) {
                return false;
            }
            this.mActiveSensors.put(handle, true);
            addSensorEvent(sensor);
            if (enableSensor(sensor, i, i2, i3) != 0) {
                if (i2 == 0 || (i2 > 0 && enableSensor(sensor, i, 0, 0) != 0)) {
                    removeSensor(sensor, false);
                    return false;
                }
                return true;
            }
            return true;
        }

        protected abstract void addSensorEvent(Sensor sensor);

        protected abstract void dispatchFlushCompleteEvent(int i);

        protected abstract void dispatchSensorEvent(int i, float[] fArr, int i2, long j);

        public void dispose() {
            dispose(false);
        }

        protected void finalize() throws Throwable {
            try {
                dispose(true);
            } finally {
                super.finalize();
            }
        }

        public int flush() {
            if (this.nSensorEventQueue == 0) {
                throw new NullPointerException();
            }
            return nativeFlushSensor(this.nSensorEventQueue);
        }

        public boolean hasSensors() {
            return this.mActiveSensors.indexOfValue(true) >= 0;
        }

        public boolean removeAllSensors() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mActiveSensors.size()) {
                    return true;
                }
                if (this.mActiveSensors.valueAt(i2)) {
                    int keyAt = this.mActiveSensors.keyAt(i2);
                    Sensor sensor = (Sensor) SystemSensorManager.sHandleToSensor.get(keyAt);
                    if (sensor != null) {
                        disableSensor(sensor);
                        this.mActiveSensors.put(keyAt, false);
                        removeSensorEvent(sensor);
                    }
                }
                i = i2 + 1;
            }
        }

        public boolean removeSensor(Sensor sensor, boolean z) {
            boolean z2 = false;
            if (this.mActiveSensors.get(sensor.getHandle())) {
                if (z) {
                    disableSensor(sensor);
                }
                this.mActiveSensors.put(sensor.getHandle(), false);
                removeSensorEvent(sensor);
                z2 = true;
            }
            return z2;
        }

        protected abstract void removeSensorEvent(Sensor sensor);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/SystemSensorManager$SensorEventQueue.class */
    static final class SensorEventQueue extends BaseEventQueue {
        private final SensorEventListener mListener;
        private final SparseArray<SensorEvent> mSensorsEvents;

        public SensorEventQueue(SensorEventListener sensorEventListener, Looper looper, SystemSensorManager systemSensorManager) {
            super(looper, systemSensorManager);
            this.mSensorsEvents = new SparseArray<>();
            this.mListener = sensorEventListener;
        }

        @Override // android.hardware.SystemSensorManager.BaseEventQueue
        public void addSensorEvent(Sensor sensor) {
            SensorEvent sensorEvent = new SensorEvent(Sensor.getMaxLengthValuesArray(sensor, this.mManager.mTargetSdkLevel));
            synchronized (this.mSensorsEvents) {
                this.mSensorsEvents.put(sensor.getHandle(), sensorEvent);
            }
        }

        @Override // android.hardware.SystemSensorManager.BaseEventQueue
        protected void dispatchFlushCompleteEvent(int i) {
            if (this.mListener instanceof SensorEventListener2) {
                ((SensorEventListener2) this.mListener).onFlushCompleted((Sensor) SystemSensorManager.sHandleToSensor.get(i));
            }
        }

        @Override // android.hardware.SystemSensorManager.BaseEventQueue
        protected void dispatchSensorEvent(int i, float[] fArr, int i2, long j) {
            SensorEvent sensorEvent;
            Sensor sensor = (Sensor) SystemSensorManager.sHandleToSensor.get(i);
            synchronized (this.mSensorsEvents) {
                sensorEvent = this.mSensorsEvents.get(i);
            }
            if (sensorEvent == null) {
                return;
            }
            System.arraycopy(fArr, 0, sensorEvent.values, 0, sensorEvent.values.length);
            sensorEvent.timestamp = j;
            sensorEvent.accuracy = i2;
            sensorEvent.sensor = sensor;
            int i3 = this.mSensorAccuracies.get(i);
            if (sensorEvent.accuracy >= 0 && i3 != sensorEvent.accuracy) {
                this.mSensorAccuracies.put(i, sensorEvent.accuracy);
                this.mListener.onAccuracyChanged(sensorEvent.sensor, sensorEvent.accuracy);
            }
            this.mListener.onSensorChanged(sensorEvent);
        }

        @Override // android.hardware.SystemSensorManager.BaseEventQueue
        public void removeSensorEvent(Sensor sensor) {
            synchronized (this.mSensorsEvents) {
                this.mSensorsEvents.delete(sensor.getHandle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/SystemSensorManager$TriggerEventQueue.class */
    public static final class TriggerEventQueue extends BaseEventQueue {
        private final TriggerEventListener mListener;
        private final SparseArray<TriggerEvent> mTriggerEvents;

        public TriggerEventQueue(TriggerEventListener triggerEventListener, Looper looper, SystemSensorManager systemSensorManager) {
            super(looper, systemSensorManager);
            this.mTriggerEvents = new SparseArray<>();
            this.mListener = triggerEventListener;
        }

        @Override // android.hardware.SystemSensorManager.BaseEventQueue
        public void addSensorEvent(Sensor sensor) {
            TriggerEvent triggerEvent = new TriggerEvent(Sensor.getMaxLengthValuesArray(sensor, this.mManager.mTargetSdkLevel));
            synchronized (this.mTriggerEvents) {
                this.mTriggerEvents.put(sensor.getHandle(), triggerEvent);
            }
        }

        @Override // android.hardware.SystemSensorManager.BaseEventQueue
        protected void dispatchFlushCompleteEvent(int i) {
        }

        @Override // android.hardware.SystemSensorManager.BaseEventQueue
        protected void dispatchSensorEvent(int i, float[] fArr, int i2, long j) {
            TriggerEvent triggerEvent;
            Sensor sensor = (Sensor) SystemSensorManager.sHandleToSensor.get(i);
            synchronized (this.mTriggerEvents) {
                triggerEvent = this.mTriggerEvents.get(i);
            }
            if (triggerEvent == null) {
                Log.e("SensorManager", "Error: Trigger Event is null for Sensor: " + sensor);
                return;
            }
            System.arraycopy(fArr, 0, triggerEvent.values, 0, triggerEvent.values.length);
            triggerEvent.timestamp = j;
            triggerEvent.sensor = sensor;
            this.mManager.cancelTriggerSensorImpl(this.mListener, sensor, false);
            this.mListener.onTrigger(triggerEvent);
        }

        @Override // android.hardware.SystemSensorManager.BaseEventQueue
        public void removeSensorEvent(Sensor sensor) {
            synchronized (this.mTriggerEvents) {
                this.mTriggerEvents.delete(sensor.getHandle());
            }
        }
    }

    public SystemSensorManager(Context context, Looper looper) {
        int nativeGetNextSensor;
        this.mMainLooper = looper;
        this.mTargetSdkLevel = context.getApplicationInfo().targetSdkVersion;
        synchronized (sSensorModuleLock) {
            if (!sSensorModuleInitialized) {
                sSensorModuleInitialized = true;
                nativeClassInit();
                ArrayList<Sensor> arrayList = sFullSensorsList;
                int i = 0;
                do {
                    Sensor sensor = new Sensor();
                    nativeGetNextSensor = nativeGetNextSensor(sensor, i);
                    if (nativeGetNextSensor >= 0) {
                        arrayList.add(sensor);
                        sHandleToSensor.append(sensor.getHandle(), sensor);
                    }
                    i = nativeGetNextSensor;
                } while (nativeGetNextSensor > 0);
            }
        }
    }

    private static native void nativeClassInit();

    private static native int nativeGetNextSensor(Sensor sensor, int i);

    @Override // android.hardware.SensorManager
    protected boolean cancelTriggerSensorImpl(TriggerEventListener triggerEventListener, Sensor sensor, boolean z) {
        if (sensor == null || sensor.getReportingMode() == 2) {
            synchronized (this.mTriggerListeners) {
                TriggerEventQueue triggerEventQueue = this.mTriggerListeners.get(triggerEventListener);
                if (triggerEventQueue != null) {
                    boolean removeAllSensors = sensor == null ? triggerEventQueue.removeAllSensors() : triggerEventQueue.removeSensor(sensor, z);
                    if (removeAllSensors && !triggerEventQueue.hasSensors()) {
                        this.mTriggerListeners.remove(triggerEventListener);
                        triggerEventQueue.dispose();
                    }
                    return removeAllSensors;
                }
                return false;
            }
        }
        return false;
    }

    @Override // android.hardware.SensorManager
    protected boolean flushImpl(SensorEventListener sensorEventListener) {
        boolean z = false;
        if (sensorEventListener == null) {
            throw new IllegalArgumentException("listener cannot be null");
        }
        synchronized (this.mSensorListeners) {
            SensorEventQueue sensorEventQueue = this.mSensorListeners.get(sensorEventListener);
            if (sensorEventQueue == null) {
                return false;
            }
            if (sensorEventQueue.flush() == 0) {
                z = true;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.hardware.SensorManager
    public List<Sensor> getFullSensorList() {
        return sFullSensorsList;
    }

    @Override // android.hardware.SensorManager
    protected boolean registerListenerImpl(SensorEventListener sensorEventListener, Sensor sensor, int i, Handler handler, int i2, int i3) {
        if (sensorEventListener == null || sensor == null) {
            Log.e("SensorManager", "sensor or listener is null");
            return false;
        } else if (sensor.getReportingMode() == 2) {
            Log.e("SensorManager", "Trigger Sensors should use the requestTriggerSensor.");
            return false;
        } else if (i2 < 0 || i < 0) {
            Log.e("SensorManager", "maxBatchReportLatencyUs and delayUs should be non-negative");
            return false;
        } else {
            synchronized (this.mSensorListeners) {
                SensorEventQueue sensorEventQueue = this.mSensorListeners.get(sensorEventListener);
                if (sensorEventQueue != null) {
                    return sensorEventQueue.addSensor(sensor, i, i2, i3);
                }
                SensorEventQueue sensorEventQueue2 = new SensorEventQueue(sensorEventListener, handler != null ? handler.getLooper() : this.mMainLooper, this);
                if (sensorEventQueue2.addSensor(sensor, i, i2, i3)) {
                    this.mSensorListeners.put(sensorEventListener, sensorEventQueue2);
                    return true;
                }
                sensorEventQueue2.dispose();
                return false;
            }
        }
    }

    @Override // android.hardware.SensorManager
    protected boolean requestTriggerSensorImpl(TriggerEventListener triggerEventListener, Sensor sensor) {
        if (sensor == null) {
            throw new IllegalArgumentException("sensor cannot be null");
        }
        if (sensor.getReportingMode() != 2) {
            return false;
        }
        synchronized (this.mTriggerListeners) {
            TriggerEventQueue triggerEventQueue = this.mTriggerListeners.get(triggerEventListener);
            if (triggerEventQueue != null) {
                return triggerEventQueue.addSensor(sensor, 0, 0, 0);
            }
            TriggerEventQueue triggerEventQueue2 = new TriggerEventQueue(triggerEventListener, this.mMainLooper, this);
            if (triggerEventQueue2.addSensor(sensor, 0, 0, 0)) {
                this.mTriggerListeners.put(triggerEventListener, triggerEventQueue2);
                return true;
            }
            triggerEventQueue2.dispose();
            return false;
        }
    }

    @Override // android.hardware.SensorManager
    protected void unregisterListenerImpl(SensorEventListener sensorEventListener, Sensor sensor) {
        if (sensor == null || sensor.getReportingMode() != 2) {
            synchronized (this.mSensorListeners) {
                SensorEventQueue sensorEventQueue = this.mSensorListeners.get(sensorEventListener);
                if (sensorEventQueue != null) {
                    if ((sensor == null ? sensorEventQueue.removeAllSensors() : sensorEventQueue.removeSensor(sensor, true)) && !sensorEventQueue.hasSensors()) {
                        this.mSensorListeners.remove(sensorEventListener);
                        sensorEventQueue.dispose();
                    }
                }
            }
        }
    }
}
