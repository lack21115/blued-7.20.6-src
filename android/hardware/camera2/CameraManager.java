package android.hardware.camera2;

import android.content.Context;
import android.hardware.CameraInfo;
import android.hardware.ICameraService;
import android.hardware.ICameraServiceListener;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.legacy.LegacyMetadataMapper;
import android.hardware.camera2.utils.CameraRuntimeException;
import android.hardware.camera2.utils.CameraServiceBinderDecorator;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraManager.class */
public final class CameraManager {
    private static final int API_VERSION_1 = 1;
    private static final int API_VERSION_2 = 2;
    private static final String TAG = "CameraManager";
    private static final int USE_CALLING_UID = -1;
    private final Context mContext;
    private ArrayList<String> mDeviceIdList;
    private final Object mLock = new Object();
    private final boolean DEBUG = Log.isLoggable(TAG, 3);

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraManager$AvailabilityCallback.class */
    public static abstract class AvailabilityCallback {
        public void onCameraAvailable(String str) {
        }

        public void onCameraUnavailable(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraManager$CameraManagerGlobal.class */
    public static final class CameraManagerGlobal extends ICameraServiceListener.Stub implements IBinder.DeathRecipient {
        private static final String CAMERA_SERVICE_BINDER_NAME = "media.camera";
        public static final int STATUS_ENUMERATING = 2;
        public static final int STATUS_NOT_AVAILABLE = Integer.MIN_VALUE;
        public static final int STATUS_NOT_PRESENT = 0;
        public static final int STATUS_PRESENT = 1;
        private static final String TAG = "CameraManagerGlobal";
        private static final CameraManagerGlobal gCameraManager = new CameraManagerGlobal();
        private ICameraService mCameraService;
        private final boolean DEBUG = Log.isLoggable(TAG, 3);
        private final ArrayMap<String, Integer> mDeviceStatus = new ArrayMap<>();
        private final ArrayMap<AvailabilityCallback, Handler> mCallbackMap = new ArrayMap<>();
        private final Object mLock = new Object();

        private CameraManagerGlobal() {
        }

        private void connectCameraServiceLocked() {
            this.mCameraService = null;
            IBinder service = ServiceManager.getService(CAMERA_SERVICE_BINDER_NAME);
            if (service == null) {
                return;
            }
            try {
                service.linkToDeath(this, 0);
                ICameraService iCameraService = (ICameraService) CameraServiceBinderDecorator.newInstance(ICameraService.Stub.asInterface(service));
                try {
                    CameraServiceBinderDecorator.throwOnError(CameraMetadataNative.nativeSetupGlobalVendorTagDescriptor());
                } catch (CameraRuntimeException e) {
                    handleRecoverableSetupErrors(e, "Failed to set up vendor tags");
                }
                try {
                    iCameraService.addListener(this);
                    this.mCameraService = iCameraService;
                } catch (CameraRuntimeException e2) {
                    throw new IllegalStateException("Failed to register a camera service listener", e2.asChecked());
                } catch (RemoteException e3) {
                }
            } catch (RemoteException e4) {
            }
        }

        public static CameraManagerGlobal get() {
            return gCameraManager;
        }

        private void handleRecoverableSetupErrors(CameraRuntimeException cameraRuntimeException, String str) {
            int reason = cameraRuntimeException.getReason();
            switch (reason) {
                case 2:
                    Log.w(TAG, str + ": " + CameraAccessException.getDefaultMessage(reason));
                    return;
                default:
                    throw new IllegalStateException(str, cameraRuntimeException.asChecked());
            }
        }

        private boolean isAvailable(int i) {
            switch (i) {
                case 1:
                    return true;
                default:
                    return false;
            }
        }

        private void onStatusChangedLocked(int i, String str) {
            if (this.DEBUG) {
                Log.v(TAG, String.format("Camera id %s has status changed to 0x%x", str, Integer.valueOf(i)));
            }
            if (!validStatus(i)) {
                Log.e(TAG, String.format("Ignoring invalid device %s status 0x%x", str, Integer.valueOf(i)));
                return;
            }
            Integer put = this.mDeviceStatus.put(str, Integer.valueOf(i));
            if (put != null && put.intValue() == i) {
                if (this.DEBUG) {
                    Log.v(TAG, String.format("Device status changed to 0x%x, which is what it already was", Integer.valueOf(i)));
                }
            } else if (put != null && isAvailable(i) == isAvailable(put.intValue())) {
                if (this.DEBUG) {
                    Log.v(TAG, String.format("Device status was previously available (%d),  and is now again available (%d)so no new client visible update will be sent", Boolean.valueOf(isAvailable(i)), Boolean.valueOf(isAvailable(i))));
                }
            } else {
                int size = this.mCallbackMap.size();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= size) {
                        return;
                    }
                    postSingleUpdate(this.mCallbackMap.keyAt(i3), this.mCallbackMap.valueAt(i3), str, i);
                    i2 = i3 + 1;
                }
            }
        }

        private void postSingleUpdate(final AvailabilityCallback availabilityCallback, Handler handler, final String str, int i) {
            if (isAvailable(i)) {
                handler.post(new Runnable() { // from class: android.hardware.camera2.CameraManager.CameraManagerGlobal.1
                    @Override // java.lang.Runnable
                    public void run() {
                        availabilityCallback.onCameraAvailable(str);
                    }
                });
            } else {
                handler.post(new Runnable() { // from class: android.hardware.camera2.CameraManager.CameraManagerGlobal.2
                    @Override // java.lang.Runnable
                    public void run() {
                        availabilityCallback.onCameraUnavailable(str);
                    }
                });
            }
        }

        private void updateCallbackLocked(AvailabilityCallback availabilityCallback, Handler handler) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mDeviceStatus.size()) {
                    return;
                }
                postSingleUpdate(availabilityCallback, handler, this.mDeviceStatus.keyAt(i2), this.mDeviceStatus.valueAt(i2).intValue());
                i = i2 + 1;
            }
        }

        private boolean validStatus(int i) {
            switch (i) {
                case Integer.MIN_VALUE:
                case 0:
                case 1:
                case 2:
                    return true;
                default:
                    return false;
            }
        }

        @Override // android.hardware.ICameraServiceListener.Stub, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (this.mLock) {
                if (this.mCameraService == null) {
                    return;
                }
                this.mCameraService = null;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mDeviceStatus.size()) {
                        return;
                    }
                    onStatusChangedLocked(1, this.mDeviceStatus.keyAt(i2));
                    i = i2 + 1;
                }
            }
        }

        public ICameraService getCameraService() {
            ICameraService iCameraService;
            synchronized (this.mLock) {
                if (this.mCameraService == null) {
                    Log.i(TAG, "getCameraService: Reconnecting to camera service");
                    connectCameraServiceLocked();
                    if (this.mCameraService == null) {
                        Log.e(TAG, "Camera service is unavailable");
                    }
                }
                iCameraService = this.mCameraService;
            }
            return iCameraService;
        }

        @Override // android.hardware.ICameraServiceListener
        public void onStatusChanged(int i, int i2) throws RemoteException {
            synchronized (this.mLock) {
                onStatusChangedLocked(i, String.valueOf(i2));
            }
        }

        public void registerAvailabilityCallback(AvailabilityCallback availabilityCallback, Handler handler) {
            synchronized (this.mLock) {
                if (this.mCallbackMap.put(availabilityCallback, handler) == null) {
                    updateCallbackLocked(availabilityCallback, handler);
                }
            }
        }

        public void unregisterAvailabilityCallback(AvailabilityCallback availabilityCallback) {
            synchronized (this.mLock) {
                this.mCallbackMap.remove(availabilityCallback);
            }
        }
    }

    public CameraManager(Context context) {
        synchronized (this.mLock) {
            this.mContext = context;
        }
    }

    private ArrayList<String> getOrCreateDeviceIdListLocked() throws CameraAccessException {
        if (this.mDeviceIdList == null) {
            ICameraService cameraService = CameraManagerGlobal.get().getCameraService();
            ArrayList<String> arrayList = new ArrayList<>();
            if (cameraService == null) {
                return arrayList;
            }
            try {
                int numberOfCameras = cameraService.getNumberOfCameras();
                CameraMetadataNative cameraMetadataNative = new CameraMetadataNative();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= numberOfCameras) {
                        this.mDeviceIdList = arrayList;
                        break;
                    }
                    boolean z = false;
                    try {
                        cameraService.getCameraCharacteristics(i2, cameraMetadataNative);
                    } catch (CameraRuntimeException e) {
                        if (e.getReason() != 2) {
                            throw e.asChecked();
                        }
                    } catch (RemoteException e2) {
                        arrayList.clear();
                        return arrayList;
                    } catch (IllegalArgumentException e3) {
                    }
                    if (cameraMetadataNative.isEmpty()) {
                        throw new AssertionError("Expected to get non-empty characteristics");
                        break;
                    }
                    z = true;
                    if (z) {
                        arrayList.add(String.valueOf(i2));
                    } else {
                        Log.w(TAG, "Error querying camera device " + i2 + " for listing.");
                    }
                    i = i2 + 1;
                }
            } catch (CameraRuntimeException e4) {
                throw e4.asChecked();
            } catch (RemoteException e5) {
                return arrayList;
            }
        }
        return this.mDeviceIdList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x010c, code lost:
        if (r14.getReason() == 2) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.hardware.camera2.CameraDevice openCameraDeviceUserAsync(java.lang.String r8, android.hardware.camera2.CameraDevice.StateCallback r9, android.os.Handler r10) throws android.hardware.camera2.CameraAccessException {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.camera2.CameraManager.openCameraDeviceUserAsync(java.lang.String, android.hardware.camera2.CameraDevice$StateCallback, android.os.Handler):android.hardware.camera2.CameraDevice");
    }

    private boolean supportsCamera2ApiLocked(String str) {
        return supportsCameraApiLocked(str, 2);
    }

    private boolean supportsCameraApiLocked(String str, int i) {
        int parseInt = Integer.parseInt(str);
        try {
            ICameraService cameraService = CameraManagerGlobal.get().getCameraService();
            if (cameraService == null) {
                return false;
            }
            int supportsCameraApi = cameraService.supportsCameraApi(parseInt, i);
            if (supportsCameraApi != 0) {
                throw new AssertionError("Unexpected value " + supportsCameraApi);
            }
            return true;
        } catch (CameraRuntimeException e) {
            if (e.getReason() != 1000) {
                throw e;
            }
            return false;
        } catch (RemoteException e2) {
            return false;
        }
    }

    public CameraCharacteristics getCameraCharacteristics(String str) throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics;
        synchronized (this.mLock) {
            if (!getOrCreateDeviceIdListLocked().contains(str)) {
                throw new IllegalArgumentException(String.format("Camera id %s does not match any currently connected camera device", str));
            }
            int intValue = Integer.valueOf(str).intValue();
            ICameraService cameraService = CameraManagerGlobal.get().getCameraService();
            if (cameraService == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            try {
                try {
                    if (supportsCamera2ApiLocked(str)) {
                        CameraMetadataNative cameraMetadataNative = new CameraMetadataNative();
                        cameraService.getCameraCharacteristics(intValue, cameraMetadataNative);
                        cameraCharacteristics = new CameraCharacteristics(cameraMetadataNative);
                    } else {
                        String[] strArr = new String[1];
                        cameraService.getLegacyParameters(intValue, strArr);
                        String str2 = strArr[0];
                        CameraInfo cameraInfo = new CameraInfo();
                        cameraService.getCameraInfo(intValue, cameraInfo);
                        cameraCharacteristics = LegacyMetadataMapper.createCharacteristics(str2, cameraInfo);
                    }
                } catch (CameraRuntimeException e) {
                    throw e.asChecked();
                }
            } catch (RemoteException e2) {
                throw new CameraAccessException(2, "Camera service is currently unavailable", e2);
            }
        }
        return cameraCharacteristics;
    }

    public String[] getCameraIdList() throws CameraAccessException {
        String[] strArr;
        synchronized (this.mLock) {
            strArr = (String[]) getOrCreateDeviceIdListLocked().toArray(new String[0]);
        }
        return strArr;
    }

    public void openCamera(String str, CameraDevice.StateCallback stateCallback, Handler handler) throws CameraAccessException {
        if (str == null) {
            throw new IllegalArgumentException("cameraId was null");
        }
        if (stateCallback == null) {
            throw new IllegalArgumentException("callback was null");
        }
        Handler handler2 = handler;
        if (handler == null) {
            if (Looper.myLooper() == null) {
                throw new IllegalArgumentException("Looper doesn't exist in the calling thread");
            }
            handler2 = new Handler();
        }
        openCameraDeviceUserAsync(str, stateCallback, handler2);
    }

    public void registerAvailabilityCallback(AvailabilityCallback availabilityCallback, Handler handler) {
        Handler handler2 = handler;
        if (handler == null) {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler2 = new Handler(myLooper);
        }
        CameraManagerGlobal.get().registerAvailabilityCallback(availabilityCallback, handler2);
    }

    public void unregisterAvailabilityCallback(AvailabilityCallback availabilityCallback) {
        CameraManagerGlobal.get().unregisterAvailabilityCallback(availabilityCallback);
    }
}
