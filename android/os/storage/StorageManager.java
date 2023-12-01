package android.os.storage;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.storage.IMountService;
import android.os.storage.IMountServiceListener;
import android.os.storage.IObbActionListener;
import android.provider.Settings;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.util.Preconditions;
import com.google.android.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageManager.class */
public class StorageManager {
    public static final int CRYPT_TYPE_DEFAULT = 1;
    public static final int CRYPT_TYPE_PASSWORD = 0;
    public static final int CRYPT_TYPE_PATTERN = 2;
    public static final int CRYPT_TYPE_PIN = 3;
    private static final long DEFAULT_FULL_THRESHOLD_BYTES = 1048576;
    private static final long DEFAULT_THRESHOLD_MAX_BYTES = 524288000;
    private static final int DEFAULT_THRESHOLD_PERCENTAGE = 10;
    public static final String OWNER_INFO_KEY = "OwnerInfo";
    public static final String PATTERN_VISIBLE_KEY = "PatternVisible";
    public static final String SYSTEM_LOCALE_KEY = "SystemLocale";
    private static final String TAG = "StorageManager";
    private MountServiceBinderListener mBinderListener;
    private final ContentResolver mResolver;
    private final Looper mTgtLooper;
    private List<ListenerDelegate> mListeners = new ArrayList();
    private final AtomicInteger mNextNonce = new AtomicInteger(0);
    private final ObbActionListener mObbActionListener = new ObbActionListener();
    private final IMountService mMountService = IMountService.Stub.asInterface(ServiceManager.getService("mount"));

    /* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageManager$ListenerDelegate.class */
    private class ListenerDelegate {
        private final Handler mHandler;
        final StorageEventListener mStorageEventListener;

        ListenerDelegate(StorageEventListener storageEventListener) {
            this.mStorageEventListener = storageEventListener;
            this.mHandler = new Handler(StorageManager.this.mTgtLooper) { // from class: android.os.storage.StorageManager.ListenerDelegate.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    StorageEvent storageEvent = (StorageEvent) message.obj;
                    if (message.what == 1) {
                        ListenerDelegate.this.mStorageEventListener.onUsbMassStorageConnectionChanged(((UmsConnectionChangedStorageEvent) storageEvent).available);
                    } else if (message.what != 2) {
                        Log.e(StorageManager.TAG, "Unsupported event " + message.what);
                    } else {
                        StorageStateChangedStorageEvent storageStateChangedStorageEvent = (StorageStateChangedStorageEvent) storageEvent;
                        ListenerDelegate.this.mStorageEventListener.onStorageStateChanged(storageStateChangedStorageEvent.path, storageStateChangedStorageEvent.oldState, storageStateChangedStorageEvent.newState);
                    }
                }
            };
        }

        StorageEventListener getListener() {
            return this.mStorageEventListener;
        }

        void sendShareAvailabilityChanged(boolean z) {
            this.mHandler.sendMessage(new UmsConnectionChangedStorageEvent(z).getMessage());
        }

        void sendStorageStateChanged(String str, String str2, String str3) {
            this.mHandler.sendMessage(new StorageStateChangedStorageEvent(str, str2, str3).getMessage());
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageManager$MountServiceBinderListener.class */
    private class MountServiceBinderListener extends IMountServiceListener.Stub {
        private MountServiceBinderListener() {
        }

        @Override // android.os.storage.IMountServiceListener
        public void onStorageStateChanged(String str, String str2, String str3) {
            int size = StorageManager.this.mListeners.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                ((ListenerDelegate) StorageManager.this.mListeners.get(i2)).sendStorageStateChanged(str, str2, str3);
                i = i2 + 1;
            }
        }

        @Override // android.os.storage.IMountServiceListener
        public void onUsbMassStorageConnectionChanged(boolean z) {
            int size = StorageManager.this.mListeners.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                ((ListenerDelegate) StorageManager.this.mListeners.get(i2)).sendShareAvailabilityChanged(z);
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageManager$ObbActionListener.class */
    private class ObbActionListener extends IObbActionListener.Stub {
        private SparseArray<ObbListenerDelegate> mListeners;

        private ObbActionListener() {
            this.mListeners = new SparseArray<>();
        }

        public int addListener(OnObbStateChangeListener onObbStateChangeListener) {
            ObbListenerDelegate obbListenerDelegate = new ObbListenerDelegate(onObbStateChangeListener);
            synchronized (this.mListeners) {
                this.mListeners.put(obbListenerDelegate.nonce, obbListenerDelegate);
            }
            return obbListenerDelegate.nonce;
        }

        @Override // android.os.storage.IObbActionListener
        public void onObbResult(String str, int i, int i2) {
            ObbListenerDelegate obbListenerDelegate;
            synchronized (this.mListeners) {
                obbListenerDelegate = this.mListeners.get(i);
                if (obbListenerDelegate != null) {
                    this.mListeners.remove(i);
                }
            }
            if (obbListenerDelegate != null) {
                obbListenerDelegate.sendObbStateChanged(str, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageManager$ObbListenerDelegate.class */
    public class ObbListenerDelegate {
        private final Handler mHandler;
        private final WeakReference<OnObbStateChangeListener> mObbEventListenerRef;
        private final int nonce;

        ObbListenerDelegate(OnObbStateChangeListener onObbStateChangeListener) {
            this.nonce = StorageManager.this.getNextNonce();
            this.mObbEventListenerRef = new WeakReference<>(onObbStateChangeListener);
            this.mHandler = new Handler(StorageManager.this.mTgtLooper) { // from class: android.os.storage.StorageManager.ObbListenerDelegate.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    OnObbStateChangeListener listener = ObbListenerDelegate.this.getListener();
                    if (listener == null) {
                        return;
                    }
                    StorageEvent storageEvent = (StorageEvent) message.obj;
                    if (message.what != 3) {
                        Log.e(StorageManager.TAG, "Unsupported event " + message.what);
                        return;
                    }
                    ObbStateChangedStorageEvent obbStateChangedStorageEvent = (ObbStateChangedStorageEvent) storageEvent;
                    listener.onObbStateChange(obbStateChangedStorageEvent.path, obbStateChangedStorageEvent.state);
                }
            };
        }

        OnObbStateChangeListener getListener() {
            if (this.mObbEventListenerRef == null) {
                return null;
            }
            return this.mObbEventListenerRef.get();
        }

        void sendObbStateChanged(String str, int i) {
            this.mHandler.sendMessage(new ObbStateChangedStorageEvent(str, i).getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageManager$ObbStateChangedStorageEvent.class */
    public class ObbStateChangedStorageEvent extends StorageEvent {
        public final String path;
        public final int state;

        public ObbStateChangedStorageEvent(String str, int i) {
            super(3);
            this.path = str;
            this.state = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageManager$StorageEvent.class */
    public class StorageEvent {
        static final int EVENT_OBB_STATE_CHANGED = 3;
        static final int EVENT_STORAGE_STATE_CHANGED = 2;
        static final int EVENT_UMS_CONNECTION_CHANGED = 1;
        private Message mMessage = Message.obtain();

        public StorageEvent(int i) {
            this.mMessage.what = i;
            this.mMessage.obj = this;
        }

        public Message getMessage() {
            return this.mMessage;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageManager$StorageStateChangedStorageEvent.class */
    public class StorageStateChangedStorageEvent extends StorageEvent {
        public String newState;
        public String oldState;
        public String path;

        public StorageStateChangedStorageEvent(String str, String str2, String str3) {
            super(2);
            this.path = str;
            this.oldState = str2;
            this.newState = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageManager$UmsConnectionChangedStorageEvent.class */
    public class UmsConnectionChangedStorageEvent extends StorageEvent {
        public boolean available;

        public UmsConnectionChangedStorageEvent(boolean z) {
            super(1);
            this.available = z;
        }
    }

    public StorageManager(ContentResolver contentResolver, Looper looper) throws RemoteException {
        this.mResolver = contentResolver;
        this.mTgtLooper = looper;
        if (this.mMountService == null) {
            Log.e(TAG, "Unable to connect to mount service! - is it running yet?");
        }
    }

    public static StorageManager from(Context context) {
        return (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNextNonce() {
        return this.mNextNonce.getAndIncrement();
    }

    public static StorageVolume getNoEmulatedVolume(StorageVolume[] storageVolumeArr) {
        int length = storageVolumeArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            StorageVolume storageVolume = storageVolumeArr[i2];
            if (!storageVolume.isEmulated()) {
                return storageVolume;
            }
            i = i2 + 1;
        }
    }

    public static ArrayList<StorageVolume> getPhysicalExternalVolume(StorageVolume[] storageVolumeArr) {
        int length = storageVolumeArr.length;
        ArrayList<StorageVolume> newArrayList = Lists.newArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return newArrayList;
            }
            if (!storageVolumeArr[i2].isEmulated()) {
                newArrayList.add(storageVolumeArr[i2]);
            }
            i = i2 + 1;
        }
    }

    public static StorageVolume getPrimaryVolume(StorageVolume[] storageVolumeArr) {
        int length = storageVolumeArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Log.w(TAG, "No primary storage defined");
                return null;
            }
            StorageVolume storageVolume = storageVolumeArr[i2];
            if (storageVolume.isPrimary()) {
                return storageVolume;
            }
            i = i2 + 1;
        }
    }

    public void disableUsbMassStorage() {
        try {
            this.mMountService.setUsbMassStorageEnabled(false);
        } catch (Exception e) {
            Log.e(TAG, "Failed to disable UMS", e);
        }
    }

    public void enableUsbMassStorage() {
        try {
            this.mMountService.setUsbMassStorageEnabled(true);
        } catch (Exception e) {
            Log.e(TAG, "Failed to enable UMS", e);
        }
    }

    public String getMountedObbPath(String str) {
        Preconditions.checkNotNull(str, "rawPath cannot be null");
        try {
            return this.mMountService.getMountedObbPath(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to find mounted path for OBB", e);
            return null;
        }
    }

    public StorageVolume getPrimaryVolume() {
        return getPrimaryVolume(getVolumeList());
    }

    public long getStorageBytesUntilLow(File file) {
        return file.getUsableSpace() - getStorageFullBytes(file);
    }

    public long getStorageFullBytes(File file) {
        return Settings.Global.getLong(this.mResolver, Settings.Global.SYS_STORAGE_FULL_THRESHOLD_BYTES, 1048576L);
    }

    public long getStorageLowBytes(File file) {
        return Math.min((file.getTotalSpace() * Settings.Global.getInt(this.mResolver, Settings.Global.SYS_STORAGE_THRESHOLD_PERCENTAGE, 10)) / 100, Settings.Global.getLong(this.mResolver, Settings.Global.SYS_STORAGE_THRESHOLD_MAX_BYTES, DEFAULT_THRESHOLD_MAX_BYTES));
    }

    public StorageVolume[] getVolumeList() {
        StorageVolume[] storageVolumeArr;
        if (this.mMountService == null) {
            storageVolumeArr = new StorageVolume[0];
        } else {
            try {
                StorageVolume[] volumeList = this.mMountService.getVolumeList();
                if (volumeList != null) {
                    int length = volumeList.length;
                    StorageVolume[] storageVolumeArr2 = new StorageVolume[length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        storageVolumeArr = storageVolumeArr2;
                        if (i2 >= length) {
                            break;
                        }
                        storageVolumeArr2[i2] = volumeList[i2];
                        i = i2 + 1;
                    }
                } else {
                    return new StorageVolume[0];
                }
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to get volume list", e);
                return null;
            }
        }
        return storageVolumeArr;
    }

    public String[] getVolumePaths() {
        String[] strArr;
        StorageVolume[] volumeList = getVolumeList();
        if (volumeList != null) {
            int length = volumeList.length;
            String[] strArr2 = new String[length];
            int i = 0;
            while (true) {
                int i2 = i;
                strArr = strArr2;
                if (i2 >= length) {
                    break;
                }
                strArr2[i2] = volumeList[i2].getPath();
                i = i2 + 1;
            }
        } else {
            strArr = null;
        }
        return strArr;
    }

    public String getVolumeState(String str) {
        if (this.mMountService == null) {
            return Environment.MEDIA_REMOVED;
        }
        try {
            return this.mMountService.getVolumeState(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get volume state", e);
            return null;
        }
    }

    public boolean isObbMounted(String str) {
        Preconditions.checkNotNull(str, "rawPath cannot be null");
        try {
            return this.mMountService.isObbMounted(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to check if OBB is mounted", e);
            return false;
        }
    }

    public boolean isUsbMassStorageConnected() {
        try {
            return this.mMountService.isUsbMassStorageConnected();
        } catch (Exception e) {
            Log.e(TAG, "Failed to get UMS connection state", e);
            return false;
        }
    }

    public boolean isUsbMassStorageEnabled() {
        try {
            return this.mMountService.isUsbMassStorageEnabled();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to get UMS enable state", e);
            return false;
        }
    }

    public boolean mountObb(String str, String str2, OnObbStateChangeListener onObbStateChangeListener) {
        Preconditions.checkNotNull(str, "rawPath cannot be null");
        Preconditions.checkNotNull(onObbStateChangeListener, "listener cannot be null");
        try {
            this.mMountService.mountObb(str, new File(str).getCanonicalPath(), str2, this.mObbActionListener, this.mObbActionListener.addListener(onObbStateChangeListener));
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to mount OBB", e);
            return false;
        } catch (IOException e2) {
            throw new IllegalArgumentException("Failed to resolve path: " + str, e2);
        }
    }

    public void registerListener(StorageEventListener storageEventListener) {
        if (storageEventListener == null) {
            return;
        }
        synchronized (this.mListeners) {
            if (this.mBinderListener == null) {
                try {
                    this.mBinderListener = new MountServiceBinderListener();
                    this.mMountService.registerListener(this.mBinderListener);
                } catch (RemoteException e) {
                    Log.e(TAG, "Register mBinderListener failed");
                    return;
                }
            }
            this.mListeners.add(new ListenerDelegate(storageEventListener));
        }
    }

    public boolean unmountObb(String str, boolean z, OnObbStateChangeListener onObbStateChangeListener) {
        Preconditions.checkNotNull(str, "rawPath cannot be null");
        Preconditions.checkNotNull(onObbStateChangeListener, "listener cannot be null");
        try {
            this.mMountService.unmountObb(str, z, this.mObbActionListener, this.mObbActionListener.addListener(onObbStateChangeListener));
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to mount OBB", e);
            return false;
        }
    }

    public void unregisterListener(StorageEventListener storageEventListener) {
        if (storageEventListener == null) {
            return;
        }
        synchronized (this.mListeners) {
            int size = this.mListeners.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                } else if (this.mListeners.get(i2).getListener() == storageEventListener) {
                    this.mListeners.remove(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (this.mListeners.size() == 0 && this.mBinderListener != null) {
                try {
                    this.mMountService.unregisterListener(this.mBinderListener);
                } catch (RemoteException e) {
                    Log.e(TAG, "Unregister mBinderListener failed");
                }
            }
        }
    }
}
