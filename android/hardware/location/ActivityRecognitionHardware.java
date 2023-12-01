package android.hardware.location;

import android.content.Context;
import android.hardware.location.IActivityRecognitionHardware;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/location/ActivityRecognitionHardware.class */
public class ActivityRecognitionHardware extends IActivityRecognitionHardware.Stub {
    private static final String HARDWARE_PERMISSION = "android.permission.LOCATION_HARDWARE";
    private static final int INVALID_ACTIVITY_TYPE = -1;
    private static final int NATIVE_SUCCESS_RESULT = 0;
    private static final String TAG = "ActivityRecognitionHardware";
    private static ActivityRecognitionHardware sSingletonInstance = null;
    private static final Object sSingletonInstanceLock = new Object();
    private final Context mContext;
    private final RemoteCallbackList<IActivityRecognitionHardwareSink> mSinks = new RemoteCallbackList<>();
    private final String[] mSupportedActivities;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/location/ActivityRecognitionHardware$Event.class */
    private static class Event {
        public int activity;
        public long timestamp;
        public int type;

        private Event() {
        }
    }

    static {
        nativeClassInit();
    }

    private ActivityRecognitionHardware(Context context) {
        nativeInitialize();
        this.mContext = context;
        this.mSupportedActivities = fetchSupportedActivities();
    }

    private void checkPermissions() {
        this.mContext.enforceCallingPermission("android.permission.LOCATION_HARDWARE", String.format("Permission '%s' not granted to access ActivityRecognitionHardware", "android.permission.LOCATION_HARDWARE"));
    }

    private String[] fetchSupportedActivities() {
        String[] nativeGetSupportedActivities = nativeGetSupportedActivities();
        return nativeGetSupportedActivities != null ? nativeGetSupportedActivities : new String[0];
    }

    private String getActivityName(int i) {
        if (i < 0 || i >= this.mSupportedActivities.length) {
            Log.e(TAG, String.format("Invalid ActivityType: %d, SupportedActivities: %d", Integer.valueOf(i), Integer.valueOf(this.mSupportedActivities.length)));
            return null;
        }
        return this.mSupportedActivities[i];
    }

    private int getActivityType(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            i = -1;
        } else {
            int length = this.mSupportedActivities.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return -1;
                }
                i = i3;
                if (str.equals(this.mSupportedActivities[i3])) {
                    break;
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    public static ActivityRecognitionHardware getInstance(Context context) {
        ActivityRecognitionHardware activityRecognitionHardware;
        synchronized (sSingletonInstanceLock) {
            if (sSingletonInstance == null) {
                sSingletonInstance = new ActivityRecognitionHardware(context);
            }
            activityRecognitionHardware = sSingletonInstance;
        }
        return activityRecognitionHardware;
    }

    public static boolean isSupported() {
        return nativeIsSupported();
    }

    private static native void nativeClassInit();

    private native int nativeDisableActivityEvent(int i, int i2);

    private native int nativeEnableActivityEvent(int i, int i2, long j);

    private native int nativeFlush();

    private native String[] nativeGetSupportedActivities();

    private native void nativeInitialize();

    private static native boolean nativeIsSupported();

    private native void nativeRelease();

    private void onActivityChanged(Event[] eventArr) {
        if (eventArr == null || eventArr.length == 0) {
            Log.d(TAG, "No events to broadcast for onActivityChanged.");
            return;
        }
        int length = eventArr.length;
        ActivityRecognitionEvent[] activityRecognitionEventArr = new ActivityRecognitionEvent[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Event event = eventArr[i2];
            activityRecognitionEventArr[i2] = new ActivityRecognitionEvent(getActivityName(event.activity), event.type, event.timestamp);
            i = i2 + 1;
        }
        ActivityChangedEvent activityChangedEvent = new ActivityChangedEvent(activityRecognitionEventArr);
        int beginBroadcast = this.mSinks.beginBroadcast();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= beginBroadcast) {
                this.mSinks.finishBroadcast();
                return;
            }
            try {
                this.mSinks.getBroadcastItem(i4).onActivityChanged(activityChangedEvent);
            } catch (RemoteException e) {
                Log.e(TAG, "Error delivering activity changed event.", e);
            }
            i3 = i4 + 1;
        }
    }

    @Override // android.hardware.location.IActivityRecognitionHardware
    public boolean disableActivityEvent(String str, int i) {
        checkPermissions();
        int activityType = getActivityType(str);
        return activityType != -1 && nativeDisableActivityEvent(activityType, i) == 0;
    }

    @Override // android.hardware.location.IActivityRecognitionHardware
    public boolean enableActivityEvent(String str, int i, long j) {
        checkPermissions();
        int activityType = getActivityType(str);
        return activityType != -1 && nativeEnableActivityEvent(activityType, i, j) == 0;
    }

    @Override // android.hardware.location.IActivityRecognitionHardware
    public boolean flush() {
        checkPermissions();
        return nativeFlush() == 0;
    }

    @Override // android.hardware.location.IActivityRecognitionHardware
    public String[] getSupportedActivities() {
        checkPermissions();
        return this.mSupportedActivities;
    }

    @Override // android.hardware.location.IActivityRecognitionHardware
    public boolean isActivitySupported(String str) {
        checkPermissions();
        return getActivityType(str) != -1;
    }

    @Override // android.hardware.location.IActivityRecognitionHardware
    public boolean registerSink(IActivityRecognitionHardwareSink iActivityRecognitionHardwareSink) {
        checkPermissions();
        return this.mSinks.register(iActivityRecognitionHardwareSink);
    }

    @Override // android.hardware.location.IActivityRecognitionHardware
    public boolean unregisterSink(IActivityRecognitionHardwareSink iActivityRecognitionHardwareSink) {
        checkPermissions();
        return this.mSinks.unregister(iActivityRecognitionHardwareSink);
    }
}
