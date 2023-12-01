package android.hardware.location;

import android.content.Context;
import android.location.IFusedGeofenceHardware;
import android.location.IGpsGeofenceHardware;
import android.location.Location;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardwareImpl.class */
public final class GeofenceHardwareImpl {
    private static final int ADD_GEOFENCE_CALLBACK = 2;
    private static final int CALLBACK_ADD = 2;
    private static final int CALLBACK_REMOVE = 3;
    private static final int GEOFENCE_CALLBACK_BINDER_DIED = 6;
    private static final int GEOFENCE_STATUS = 1;
    private static final int GEOFENCE_TRANSITION_CALLBACK = 1;
    private static final int LOCATION_HAS_ACCURACY = 16;
    private static final int LOCATION_HAS_ALTITUDE = 2;
    private static final int LOCATION_HAS_BEARING = 8;
    private static final int LOCATION_HAS_LAT_LONG = 1;
    private static final int LOCATION_HAS_SPEED = 4;
    private static final int LOCATION_INVALID = 0;
    private static final int MONITOR_CALLBACK_BINDER_DIED = 4;
    private static final int PAUSE_GEOFENCE_CALLBACK = 4;
    private static final int REAPER_GEOFENCE_ADDED = 1;
    private static final int REAPER_MONITOR_CALLBACK_ADDED = 2;
    private static final int REAPER_REMOVED = 3;
    private static final int REMOVE_GEOFENCE_CALLBACK = 3;
    private static final int RESOLUTION_LEVEL_COARSE = 2;
    private static final int RESOLUTION_LEVEL_FINE = 3;
    private static final int RESOLUTION_LEVEL_NONE = 1;
    private static final int RESUME_GEOFENCE_CALLBACK = 5;
    private static GeofenceHardwareImpl sInstance;
    private final Context mContext;
    private IFusedGeofenceHardware mFusedService;
    private IGpsGeofenceHardware mGpsService;
    private PowerManager.WakeLock mWakeLock;
    private static final String TAG = "GeofenceHardwareImpl";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private final SparseArray<IGeofenceHardwareCallback> mGeofences = new SparseArray<>();
    private final ArrayList<IGeofenceHardwareMonitorCallback>[] mCallbacks = new ArrayList[2];
    private final ArrayList<Reaper> mReapers = new ArrayList<>();
    private int[] mSupportedMonitorTypes = new int[2];
    private Handler mGeofenceHandler = new Handler() { // from class: android.hardware.location.GeofenceHardwareImpl.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IGeofenceHardwareCallback iGeofenceHardwareCallback;
            IGeofenceHardwareCallback iGeofenceHardwareCallback2;
            IGeofenceHardwareCallback iGeofenceHardwareCallback3;
            IGeofenceHardwareCallback iGeofenceHardwareCallback4;
            boolean z;
            IGeofenceHardwareCallback iGeofenceHardwareCallback5;
            switch (message.what) {
                case 1:
                    GeofenceTransition geofenceTransition = (GeofenceTransition) message.obj;
                    synchronized (GeofenceHardwareImpl.this.mGeofences) {
                        iGeofenceHardwareCallback = (IGeofenceHardwareCallback) GeofenceHardwareImpl.this.mGeofences.get(geofenceTransition.mGeofenceId);
                        if (GeofenceHardwareImpl.DEBUG) {
                            Log.d(GeofenceHardwareImpl.TAG, "GeofenceTransistionCallback: GPS : GeofenceId: " + geofenceTransition.mGeofenceId + " Transition: " + geofenceTransition.mTransition + " Location: " + geofenceTransition.mLocation + ":" + GeofenceHardwareImpl.this.mGeofences);
                        }
                    }
                    if (iGeofenceHardwareCallback != null) {
                        try {
                            iGeofenceHardwareCallback.onGeofenceTransition(geofenceTransition.mGeofenceId, geofenceTransition.mTransition, geofenceTransition.mLocation, geofenceTransition.mTimestamp, geofenceTransition.mMonitoringType);
                        } catch (RemoteException e) {
                        }
                    }
                    GeofenceHardwareImpl.this.releaseWakeLock();
                    return;
                case 2:
                    int i = message.arg1;
                    synchronized (GeofenceHardwareImpl.this.mGeofences) {
                        iGeofenceHardwareCallback5 = (IGeofenceHardwareCallback) GeofenceHardwareImpl.this.mGeofences.get(i);
                    }
                    if (iGeofenceHardwareCallback5 != null) {
                        try {
                            iGeofenceHardwareCallback5.onGeofenceAdd(i, message.arg2);
                        } catch (RemoteException e2) {
                            Log.i(GeofenceHardwareImpl.TAG, "Remote Exception:" + e2);
                        }
                    }
                    GeofenceHardwareImpl.this.releaseWakeLock();
                    return;
                case 3:
                    int i2 = message.arg1;
                    synchronized (GeofenceHardwareImpl.this.mGeofences) {
                        iGeofenceHardwareCallback4 = (IGeofenceHardwareCallback) GeofenceHardwareImpl.this.mGeofences.get(i2);
                    }
                    if (iGeofenceHardwareCallback4 != null) {
                        try {
                            iGeofenceHardwareCallback4.onGeofenceRemove(i2, message.arg2);
                        } catch (RemoteException e3) {
                        }
                        IBinder asBinder = iGeofenceHardwareCallback4.asBinder();
                        synchronized (GeofenceHardwareImpl.this.mGeofences) {
                            GeofenceHardwareImpl.this.mGeofences.remove(i2);
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                z = false;
                                if (i4 < GeofenceHardwareImpl.this.mGeofences.size()) {
                                    if (((IGeofenceHardwareCallback) GeofenceHardwareImpl.this.mGeofences.valueAt(i4)).asBinder() == asBinder) {
                                        z = true;
                                    } else {
                                        i3 = i4 + 1;
                                    }
                                }
                            }
                        }
                        if (!z) {
                            Iterator it = GeofenceHardwareImpl.this.mReapers.iterator();
                            while (it.hasNext()) {
                                Reaper reaper = (Reaper) it.next();
                                if (reaper.mCallback != null && reaper.mCallback.asBinder() == asBinder) {
                                    it.remove();
                                    reaper.unlinkToDeath();
                                    if (GeofenceHardwareImpl.DEBUG) {
                                        Log.d(GeofenceHardwareImpl.TAG, String.format("Removed reaper %s because binder %s is no longer needed.", reaper, asBinder));
                                    }
                                }
                            }
                        }
                    }
                    GeofenceHardwareImpl.this.releaseWakeLock();
                    return;
                case 4:
                    int i5 = message.arg1;
                    synchronized (GeofenceHardwareImpl.this.mGeofences) {
                        iGeofenceHardwareCallback3 = (IGeofenceHardwareCallback) GeofenceHardwareImpl.this.mGeofences.get(i5);
                    }
                    if (iGeofenceHardwareCallback3 != null) {
                        try {
                            iGeofenceHardwareCallback3.onGeofencePause(i5, message.arg2);
                        } catch (RemoteException e4) {
                        }
                    }
                    GeofenceHardwareImpl.this.releaseWakeLock();
                    return;
                case 5:
                    int i6 = message.arg1;
                    synchronized (GeofenceHardwareImpl.this.mGeofences) {
                        iGeofenceHardwareCallback2 = (IGeofenceHardwareCallback) GeofenceHardwareImpl.this.mGeofences.get(i6);
                    }
                    if (iGeofenceHardwareCallback2 != null) {
                        try {
                            iGeofenceHardwareCallback2.onGeofenceResume(i6, message.arg2);
                        } catch (RemoteException e5) {
                        }
                    }
                    GeofenceHardwareImpl.this.releaseWakeLock();
                    return;
                case 6:
                    IGeofenceHardwareCallback iGeofenceHardwareCallback6 = (IGeofenceHardwareCallback) message.obj;
                    if (GeofenceHardwareImpl.DEBUG) {
                        Log.d(GeofenceHardwareImpl.TAG, "Geofence callback reaped:" + iGeofenceHardwareCallback6);
                    }
                    int i7 = message.arg1;
                    synchronized (GeofenceHardwareImpl.this.mGeofences) {
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 < GeofenceHardwareImpl.this.mGeofences.size()) {
                                if (((IGeofenceHardwareCallback) GeofenceHardwareImpl.this.mGeofences.valueAt(i9)).equals(iGeofenceHardwareCallback6)) {
                                    int keyAt = GeofenceHardwareImpl.this.mGeofences.keyAt(i9);
                                    GeofenceHardwareImpl.this.removeGeofence(GeofenceHardwareImpl.this.mGeofences.keyAt(i9), i7);
                                    GeofenceHardwareImpl.this.mGeofences.remove(keyAt);
                                }
                                i8 = i9 + 1;
                            }
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private Handler mCallbacksHandler = new Handler() { // from class: android.hardware.location.GeofenceHardwareImpl.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    GeofenceHardwareMonitorEvent geofenceHardwareMonitorEvent = (GeofenceHardwareMonitorEvent) message.obj;
                    ArrayList arrayList = GeofenceHardwareImpl.this.mCallbacks[geofenceHardwareMonitorEvent.getMonitoringType()];
                    if (arrayList != null) {
                        if (GeofenceHardwareImpl.DEBUG) {
                            Log.d(GeofenceHardwareImpl.TAG, "MonitoringSystemChangeCallback: " + geofenceHardwareMonitorEvent);
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            try {
                                ((IGeofenceHardwareMonitorCallback) it.next()).onMonitoringSystemChange(geofenceHardwareMonitorEvent);
                            } catch (RemoteException e) {
                                Log.d(GeofenceHardwareImpl.TAG, "Error reporting onMonitoringSystemChange.", e);
                            }
                        }
                    }
                    GeofenceHardwareImpl.this.releaseWakeLock();
                    return;
                case 2:
                    int i = message.arg1;
                    IGeofenceHardwareMonitorCallback iGeofenceHardwareMonitorCallback = (IGeofenceHardwareMonitorCallback) message.obj;
                    ArrayList arrayList2 = GeofenceHardwareImpl.this.mCallbacks[i];
                    ArrayList arrayList3 = arrayList2;
                    if (arrayList2 == null) {
                        arrayList3 = new ArrayList();
                        GeofenceHardwareImpl.this.mCallbacks[i] = arrayList3;
                    }
                    if (arrayList3.contains(iGeofenceHardwareMonitorCallback)) {
                        return;
                    }
                    arrayList3.add(iGeofenceHardwareMonitorCallback);
                    return;
                case 3:
                    int i2 = message.arg1;
                    IGeofenceHardwareMonitorCallback iGeofenceHardwareMonitorCallback2 = (IGeofenceHardwareMonitorCallback) message.obj;
                    ArrayList arrayList4 = GeofenceHardwareImpl.this.mCallbacks[i2];
                    if (arrayList4 != null) {
                        arrayList4.remove(iGeofenceHardwareMonitorCallback2);
                        return;
                    }
                    return;
                case 4:
                    IGeofenceHardwareMonitorCallback iGeofenceHardwareMonitorCallback3 = (IGeofenceHardwareMonitorCallback) message.obj;
                    if (GeofenceHardwareImpl.DEBUG) {
                        Log.d(GeofenceHardwareImpl.TAG, "Monitor callback reaped:" + iGeofenceHardwareMonitorCallback3);
                    }
                    ArrayList arrayList5 = GeofenceHardwareImpl.this.mCallbacks[message.arg1];
                    if (arrayList5 == null || !arrayList5.contains(iGeofenceHardwareMonitorCallback3)) {
                        return;
                    }
                    arrayList5.remove(iGeofenceHardwareMonitorCallback3);
                    return;
                default:
                    return;
            }
        }
    };
    private Handler mReaperHandler = new Handler() { // from class: android.hardware.location.GeofenceHardwareImpl.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    IGeofenceHardwareCallback iGeofenceHardwareCallback = (IGeofenceHardwareCallback) message.obj;
                    Reaper reaper = new Reaper(iGeofenceHardwareCallback, message.arg1);
                    if (GeofenceHardwareImpl.this.mReapers.contains(reaper)) {
                        return;
                    }
                    GeofenceHardwareImpl.this.mReapers.add(reaper);
                    try {
                        iGeofenceHardwareCallback.asBinder().linkToDeath(reaper, 0);
                        return;
                    } catch (RemoteException e) {
                        return;
                    }
                case 2:
                    IGeofenceHardwareMonitorCallback iGeofenceHardwareMonitorCallback = (IGeofenceHardwareMonitorCallback) message.obj;
                    Reaper reaper2 = new Reaper(iGeofenceHardwareMonitorCallback, message.arg1);
                    if (GeofenceHardwareImpl.this.mReapers.contains(reaper2)) {
                        return;
                    }
                    GeofenceHardwareImpl.this.mReapers.add(reaper2);
                    try {
                        iGeofenceHardwareMonitorCallback.asBinder().linkToDeath(reaper2, 0);
                        return;
                    } catch (RemoteException e2) {
                        return;
                    }
                case 3:
                    GeofenceHardwareImpl.this.mReapers.remove((Reaper) message.obj);
                    return;
                default:
                    return;
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardwareImpl$GeofenceTransition.class */
    private class GeofenceTransition {
        private int mGeofenceId;
        private Location mLocation;
        private int mMonitoringType;
        private int mSourcesUsed;
        private long mTimestamp;
        private int mTransition;

        GeofenceTransition(int i, int i2, long j, Location location, int i3, int i4) {
            this.mGeofenceId = i;
            this.mTransition = i2;
            this.mTimestamp = j;
            this.mLocation = location;
            this.mMonitoringType = i3;
            this.mSourcesUsed = i4;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/location/GeofenceHardwareImpl$Reaper.class */
    class Reaper implements IBinder.DeathRecipient {
        private IGeofenceHardwareCallback mCallback;
        private IGeofenceHardwareMonitorCallback mMonitorCallback;
        private int mMonitoringType;

        Reaper(IGeofenceHardwareCallback iGeofenceHardwareCallback, int i) {
            this.mCallback = iGeofenceHardwareCallback;
            this.mMonitoringType = i;
        }

        Reaper(IGeofenceHardwareMonitorCallback iGeofenceHardwareMonitorCallback, int i) {
            this.mMonitorCallback = iGeofenceHardwareMonitorCallback;
            this.mMonitoringType = i;
        }

        private boolean binderEquals(IInterface iInterface, IInterface iInterface2) {
            boolean z = false;
            if (iInterface == null) {
                return iInterface2 == null;
            }
            if (iInterface2 != null && iInterface.asBinder() == iInterface2.asBinder()) {
                z = true;
            }
            return z;
        }

        private boolean callbackEquals(IGeofenceHardwareCallback iGeofenceHardwareCallback) {
            return this.mCallback != null && this.mCallback.asBinder() == iGeofenceHardwareCallback.asBinder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean unlinkToDeath() {
            if (this.mMonitorCallback != null) {
                return this.mMonitorCallback.asBinder().unlinkToDeath(this, 0);
            }
            if (this.mCallback != null) {
                return this.mCallback.asBinder().unlinkToDeath(this, 0);
            }
            return true;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (this.mCallback != null) {
                Message obtainMessage = GeofenceHardwareImpl.this.mGeofenceHandler.obtainMessage(6, this.mCallback);
                obtainMessage.arg1 = this.mMonitoringType;
                GeofenceHardwareImpl.this.mGeofenceHandler.sendMessage(obtainMessage);
            } else if (this.mMonitorCallback != null) {
                Message obtainMessage2 = GeofenceHardwareImpl.this.mCallbacksHandler.obtainMessage(4, this.mMonitorCallback);
                obtainMessage2.arg1 = this.mMonitoringType;
                GeofenceHardwareImpl.this.mCallbacksHandler.sendMessage(obtainMessage2);
            }
            GeofenceHardwareImpl.this.mReaperHandler.sendMessage(GeofenceHardwareImpl.this.mReaperHandler.obtainMessage(3, this));
        }

        public boolean equals(Object obj) {
            boolean z;
            if (obj == null) {
                z = false;
            } else {
                z = true;
                if (obj != this) {
                    Reaper reaper = (Reaper) obj;
                    if (!binderEquals(reaper.mCallback, this.mCallback) || !binderEquals(reaper.mMonitorCallback, this.mMonitorCallback)) {
                        return false;
                    }
                    z = true;
                    if (reaper.mMonitoringType != this.mMonitoringType) {
                        return false;
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.mCallback != null ? this.mCallback.asBinder().hashCode() : 0;
            if (this.mMonitorCallback != null) {
                i = this.mMonitorCallback.asBinder().hashCode();
            }
            return ((((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + i) * 31) + this.mMonitoringType;
        }
    }

    private GeofenceHardwareImpl(Context context) {
        this.mContext = context;
        setMonitorAvailability(0, 2);
        setMonitorAvailability(1, 2);
    }

    private void acquireWakeLock() {
        if (this.mWakeLock == null) {
            this.mWakeLock = ((PowerManager) this.mContext.getSystemService(Context.POWER_SERVICE)).newWakeLock(1, TAG);
        }
        this.mWakeLock.acquire();
    }

    public static GeofenceHardwareImpl getInstance(Context context) {
        GeofenceHardwareImpl geofenceHardwareImpl;
        synchronized (GeofenceHardwareImpl.class) {
            try {
                if (sInstance == null) {
                    sInstance = new GeofenceHardwareImpl(context);
                }
                geofenceHardwareImpl = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return geofenceHardwareImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWakeLock() {
        if (this.mWakeLock.isHeld()) {
            this.mWakeLock.release();
        }
    }

    private void reportGeofenceOperationStatus(int i, int i2, int i3) {
        acquireWakeLock();
        Message obtainMessage = this.mGeofenceHandler.obtainMessage(i);
        obtainMessage.arg1 = i2;
        obtainMessage.arg2 = i3;
        obtainMessage.sendToTarget();
    }

    private void setMonitorAvailability(int i, int i2) {
        synchronized (this.mSupportedMonitorTypes) {
            this.mSupportedMonitorTypes[i] = i2;
        }
    }

    private void updateFusedHardwareAvailability() {
        boolean z;
        try {
            z = this.mFusedService != null ? this.mFusedService.isSupported() : false;
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException calling LocationManagerService");
            z = false;
        }
        if (z) {
            setMonitorAvailability(1, 0);
        }
    }

    private void updateGpsHardwareAvailability() {
        boolean z;
        try {
            z = this.mGpsService.isHardwareGeofenceSupported();
        } catch (RemoteException e) {
            Log.e(TAG, "Remote Exception calling LocationManagerService");
            z = false;
        }
        if (z) {
            setMonitorAvailability(0, 0);
        }
    }

    public boolean addCircularFence(int i, GeofenceHardwareRequestParcelable geofenceHardwareRequestParcelable, IGeofenceHardwareCallback iGeofenceHardwareCallback) {
        boolean z;
        int id = geofenceHardwareRequestParcelable.getId();
        if (DEBUG) {
            Log.d(TAG, String.format("addCircularFence: monitoringType=%d, %s", Integer.valueOf(i), geofenceHardwareRequestParcelable));
        }
        synchronized (this.mGeofences) {
            this.mGeofences.put(id, iGeofenceHardwareCallback);
        }
        switch (i) {
            case 0:
                if (this.mGpsService != null) {
                    try {
                        z = this.mGpsService.addCircularHardwareGeofence(geofenceHardwareRequestParcelable.getId(), geofenceHardwareRequestParcelable.getLatitude(), geofenceHardwareRequestParcelable.getLongitude(), geofenceHardwareRequestParcelable.getRadius(), geofenceHardwareRequestParcelable.getLastTransition(), geofenceHardwareRequestParcelable.getMonitorTransitions(), geofenceHardwareRequestParcelable.getNotificationResponsiveness(), geofenceHardwareRequestParcelable.getUnknownTimer());
                        break;
                    } catch (RemoteException e) {
                        Log.e(TAG, "AddGeofence: Remote Exception calling LocationManagerService");
                        z = false;
                        break;
                    }
                } else {
                    return false;
                }
            case 1:
                if (this.mFusedService != null) {
                    try {
                        this.mFusedService.addGeofences(new GeofenceHardwareRequestParcelable[]{geofenceHardwareRequestParcelable});
                        z = true;
                        break;
                    } catch (RemoteException e2) {
                        Log.e(TAG, "AddGeofence: RemoteException calling LocationManagerService");
                        z = false;
                        break;
                    }
                } else {
                    return false;
                }
            default:
                z = false;
                break;
        }
        if (z) {
            Message obtainMessage = this.mReaperHandler.obtainMessage(1, iGeofenceHardwareCallback);
            obtainMessage.arg1 = i;
            this.mReaperHandler.sendMessage(obtainMessage);
        } else {
            synchronized (this.mGeofences) {
                this.mGeofences.remove(id);
            }
        }
        if (DEBUG) {
            Log.d(TAG, "addCircularFence: Result is: " + z);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAllowedResolutionLevel(int i, int i2) {
        if (this.mContext.checkPermission("android.permission.ACCESS_FINE_LOCATION", i, i2) == 0) {
            return 3;
        }
        return this.mContext.checkPermission("android.permission.ACCESS_COARSE_LOCATION", i, i2) == 0 ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMonitoringResolutionLevel(int i) {
        int i2 = 3;
        switch (i) {
            case 0:
            case 1:
                break;
            default:
                i2 = 1;
                break;
        }
        return i2;
    }

    public int[] getMonitoringTypes() {
        boolean z;
        boolean z2;
        synchronized (this.mSupportedMonitorTypes) {
            z = this.mSupportedMonitorTypes[0] != 2;
            z2 = this.mSupportedMonitorTypes[1] != 2;
        }
        return z ? z2 ? new int[]{0, 1} : new int[]{0} : z2 ? new int[]{1} : new int[0];
    }

    public int getStatusOfMonitoringType(int i) {
        int i2;
        synchronized (this.mSupportedMonitorTypes) {
            if (i >= this.mSupportedMonitorTypes.length || i < 0) {
                throw new IllegalArgumentException("Unknown monitoring type");
            }
            i2 = this.mSupportedMonitorTypes[i];
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean pauseGeofence(int r6, int r7) {
        /*
            r5 = this;
            r0 = 0
            r9 = r0
            boolean r0 = android.hardware.location.GeofenceHardwareImpl.DEBUG
            if (r0 == 0) goto L23
            java.lang.String r0 = "GeofenceHardwareImpl"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.String r2 = "Pause Geofence: GeofenceId: "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r6
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            int r0 = android.util.Log.d(r0, r1)
        L23:
            r0 = r5
            android.util.SparseArray<android.hardware.location.IGeofenceHardwareCallback> r0 = r0.mGeofences
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = r5
            android.util.SparseArray<android.hardware.location.IGeofenceHardwareCallback> r0 = r0.mGeofences     // Catch: java.lang.Throwable -> L59
            r1 = r6
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L59
            if (r0 != 0) goto L61
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L59
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r3 = r2
            r3.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r3 = "Geofence "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L59
            r3 = r6
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L59
            java.lang.String r3 = " not registered."
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L59
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L59
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L59
            throw r0     // Catch: java.lang.Throwable -> L59
        L59:
            r11 = move-exception
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L59
            r0 = r11
            throw r0
        L61:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L59
            r0 = r7
            switch(r0) {
                case 0: goto La7;
                case 1: goto Lcc;
                default: goto L7c;
            }
        L7c:
            r0 = 0
            r8 = r0
        L7e:
            r0 = r8
            r9 = r0
            boolean r0 = android.hardware.location.GeofenceHardwareImpl.DEBUG
            if (r0 == 0) goto La4
            java.lang.String r0 = "GeofenceHardwareImpl"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.String r2 = "pauseGeofence: Result is: "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r8
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            int r0 = android.util.Log.d(r0, r1)
            r0 = r8
            r9 = r0
        La4:
            r0 = r9
            return r0
        La7:
            r0 = r5
            android.location.IGpsGeofenceHardware r0 = r0.mGpsService
            if (r0 == 0) goto La4
            r0 = r5
            android.location.IGpsGeofenceHardware r0 = r0.mGpsService     // Catch: android.os.RemoteException -> Lbc
            r1 = r6
            boolean r0 = r0.pauseHardwareGeofence(r1)     // Catch: android.os.RemoteException -> Lbc
            r8 = r0
            goto L7e
        Lbc:
            r10 = move-exception
            java.lang.String r0 = "GeofenceHardwareImpl"
            java.lang.String r1 = "PauseGeofence: Remote Exception calling LocationManagerService"
            int r0 = android.util.Log.e(r0, r1)
            r0 = 0
            r8 = r0
            goto L7e
        Lcc:
            r0 = r5
            android.location.IFusedGeofenceHardware r0 = r0.mFusedService
            if (r0 == 0) goto La4
            r0 = r5
            android.location.IFusedGeofenceHardware r0 = r0.mFusedService     // Catch: android.os.RemoteException -> Le2
            r1 = r6
            r0.pauseMonitoringGeofence(r1)     // Catch: android.os.RemoteException -> Le2
            r0 = 1
            r8 = r0
            goto L7e
        Le2:
            r10 = move-exception
            java.lang.String r0 = "GeofenceHardwareImpl"
            java.lang.String r1 = "PauseGeofence: RemoteException calling LocationManagerService"
            int r0 = android.util.Log.e(r0, r1)
            r0 = 0
            r8 = r0
            goto L7e
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.location.GeofenceHardwareImpl.pauseGeofence(int, int):boolean");
    }

    public boolean registerForMonitorStateChangeCallback(int i, IGeofenceHardwareMonitorCallback iGeofenceHardwareMonitorCallback) {
        Message obtainMessage = this.mReaperHandler.obtainMessage(2, iGeofenceHardwareMonitorCallback);
        obtainMessage.arg1 = i;
        this.mReaperHandler.sendMessage(obtainMessage);
        Message obtainMessage2 = this.mCallbacksHandler.obtainMessage(2, iGeofenceHardwareMonitorCallback);
        obtainMessage2.arg1 = i;
        this.mCallbacksHandler.sendMessage(obtainMessage2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean removeGeofence(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.location.GeofenceHardwareImpl.removeGeofence(int, int):boolean");
    }

    public void reportGeofenceAddStatus(int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "AddCallback| id:" + i + ", status:" + i2);
        }
        reportGeofenceOperationStatus(2, i, i2);
    }

    public void reportGeofenceMonitorStatus(int i, int i2, Location location, int i3) {
        setMonitorAvailability(i, i2);
        acquireWakeLock();
        this.mCallbacksHandler.obtainMessage(1, new GeofenceHardwareMonitorEvent(i, i2, i3, location)).sendToTarget();
    }

    public void reportGeofencePauseStatus(int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "PauseCallbac| id:" + i + ", status" + i2);
        }
        reportGeofenceOperationStatus(4, i, i2);
    }

    public void reportGeofenceRemoveStatus(int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "RemoveCallback| id:" + i + ", status:" + i2);
        }
        reportGeofenceOperationStatus(3, i, i2);
    }

    public void reportGeofenceResumeStatus(int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "ResumeCallback| id:" + i + ", status:" + i2);
        }
        reportGeofenceOperationStatus(5, i, i2);
    }

    public void reportGeofenceTransition(int i, Location location, int i2, long j, int i3, int i4) {
        if (location == null) {
            Log.e(TAG, String.format("Invalid Geofence Transition: location=%p", location));
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "GeofenceTransition| " + location + ", transition:" + i2 + ", transitionTimestamp:" + j + ", monitoringType:" + i3 + ", sourcesUsed:" + i4);
        }
        GeofenceTransition geofenceTransition = new GeofenceTransition(i, i2, j, location, i3, i4);
        acquireWakeLock();
        this.mGeofenceHandler.obtainMessage(1, geofenceTransition).sendToTarget();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean resumeGeofence(int r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.location.GeofenceHardwareImpl.resumeGeofence(int, int, int):boolean");
    }

    public void setFusedGeofenceHardware(IFusedGeofenceHardware iFusedGeofenceHardware) {
        if (this.mFusedService == null) {
            this.mFusedService = iFusedGeofenceHardware;
            updateFusedHardwareAvailability();
        } else if (iFusedGeofenceHardware != null) {
            Log.e(TAG, "Error: FusedService being set again");
        } else {
            this.mFusedService = null;
            Log.w(TAG, "Fused Geofence Hardware service seems to have crashed");
        }
    }

    public void setGpsHardwareGeofence(IGpsGeofenceHardware iGpsGeofenceHardware) {
        if (this.mGpsService == null) {
            this.mGpsService = iGpsGeofenceHardware;
            updateGpsHardwareAvailability();
        } else if (iGpsGeofenceHardware != null) {
            Log.e(TAG, "Error: GpsService being set again.");
        } else {
            this.mGpsService = null;
            Log.w(TAG, "GPS Geofence Hardware service seems to have crashed");
        }
    }

    public boolean unregisterForMonitorStateChangeCallback(int i, IGeofenceHardwareMonitorCallback iGeofenceHardwareMonitorCallback) {
        Message obtainMessage = this.mCallbacksHandler.obtainMessage(3, iGeofenceHardwareMonitorCallback);
        obtainMessage.arg1 = i;
        this.mCallbacksHandler.sendMessage(obtainMessage);
        return true;
    }
}
