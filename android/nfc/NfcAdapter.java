package android.nfc;

import android.app.Activity;
import android.app.ActivityThread;
import android.app.AppOpsManager;
import android.app.OnActivityPausedListener;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.INfcAdapter;
import android.nfc.INfcUnlockHandler;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcAdapter.class */
public final class NfcAdapter {
    public static final String ACTION_ADAPTER_STATE_CHANGED = "android.nfc.action.ADAPTER_STATE_CHANGED";
    public static final String ACTION_HANDOVER_TRANSFER_DONE = "android.nfc.action.HANDOVER_TRANSFER_DONE";
    public static final String ACTION_HANDOVER_TRANSFER_STARTED = "android.nfc.action.HANDOVER_TRANSFER_STARTED";
    public static final String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";
    public static final String ACTION_TAG_DISCOVERED = "android.nfc.action.TAG_DISCOVERED";
    public static final String ACTION_TAG_LEFT_FIELD = "android.nfc.action.TAG_LOST";
    public static final String ACTION_TECH_DISCOVERED = "android.nfc.action.TECH_DISCOVERED";
    public static final String EXTRA_ADAPTER_STATE = "android.nfc.extra.ADAPTER_STATE";
    public static final String EXTRA_HANDOVER_TRANSFER_STATUS = "android.nfc.extra.HANDOVER_TRANSFER_STATUS";
    public static final String EXTRA_HANDOVER_TRANSFER_URI = "android.nfc.extra.HANDOVER_TRANSFER_URI";
    public static final String EXTRA_ID = "android.nfc.extra.ID";
    public static final String EXTRA_NDEF_MESSAGES = "android.nfc.extra.NDEF_MESSAGES";
    public static final String EXTRA_READER_PRESENCE_CHECK_DELAY = "presence";
    public static final String EXTRA_TAG = "android.nfc.extra.TAG";
    public static final int FLAG_NDEF_PUSH_NO_CONFIRM = 1;
    public static final int FLAG_READER_NFC_A = 1;
    public static final int FLAG_READER_NFC_B = 2;
    public static final int FLAG_READER_NFC_BARCODE = 16;
    public static final int FLAG_READER_NFC_F = 4;
    public static final int FLAG_READER_NFC_V = 8;
    public static final int FLAG_READER_NO_PLATFORM_SOUNDS = 256;
    public static final int FLAG_READER_SKIP_NDEF_CHECK = 128;
    public static final int HANDOVER_TRANSFER_STATUS_FAILURE = 1;
    public static final int HANDOVER_TRANSFER_STATUS_SUCCESS = 0;
    public static final int STATE_OFF = 1;
    public static final int STATE_ON = 3;
    public static final int STATE_TURNING_OFF = 4;
    public static final int STATE_TURNING_ON = 2;
    static final String TAG = "NFC";
    static INfcCardEmulation sCardEmulationService;
    static boolean sIsInitialized = false;
    static HashMap<Context, NfcAdapter> sNfcAdapters = new HashMap<>();
    static NfcAdapter sNullContextNfcAdapter;
    static INfcAdapter sService;
    static INfcTag sTagService;
    private final AppOpsManager mAppOps;
    final Context mContext;
    OnActivityPausedListener mForegroundDispatchListener = new OnActivityPausedListener() { // from class: android.nfc.NfcAdapter.1
        @Override // android.app.OnActivityPausedListener
        public void onPaused(Activity activity) {
            NfcAdapter.this.disableForegroundDispatchInternal(activity, true);
        }
    };
    final NfcActivityManager mNfcActivityManager = new NfcActivityManager(this);
    final HashMap<NfcUnlockHandler, INfcUnlockHandler> mNfcUnlockHandlers = new HashMap<>();
    final Object mLock = new Object();

    /* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcAdapter$CreateBeamUrisCallback.class */
    public interface CreateBeamUrisCallback {
        Uri[] createBeamUris(NfcEvent nfcEvent);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcAdapter$CreateNdefMessageCallback.class */
    public interface CreateNdefMessageCallback {
        NdefMessage createNdefMessage(NfcEvent nfcEvent);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcAdapter$NfcUnlockHandler.class */
    public interface NfcUnlockHandler {
        boolean onUnlockAttempted(Tag tag);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcAdapter$OnNdefPushCompleteCallback.class */
    public interface OnNdefPushCompleteCallback {
        void onNdefPushComplete(NfcEvent nfcEvent);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcAdapter$ReaderCallback.class */
    public interface ReaderCallback {
        void onTagDiscovered(Tag tag);
    }

    NfcAdapter(Context context) {
        this.mContext = context;
        this.mAppOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
    }

    @Deprecated
    public static NfcAdapter getDefaultAdapter() {
        Log.w(TAG, "WARNING: NfcAdapter.getDefaultAdapter() is deprecated, use NfcAdapter.getDefaultAdapter(Context) instead", new Exception());
        return getNfcAdapter(null);
    }

    public static NfcAdapter getDefaultAdapter(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new IllegalArgumentException("context not associated with any application (using a mock context?)");
        }
        NfcManager nfcManager = (NfcManager) applicationContext.getSystemService("nfc");
        if (nfcManager == null) {
            return null;
        }
        return nfcManager.getDefaultAdapter();
    }

    public static NfcAdapter getNfcAdapter(Context context) {
        NfcAdapter nfcAdapter;
        synchronized (NfcAdapter.class) {
            try {
                if (!sIsInitialized) {
                    if (!hasNfcFeature()) {
                        Log.v(TAG, "this device does not have NFC support");
                        throw new UnsupportedOperationException();
                    }
                    sService = getServiceInterface();
                    if (sService == null) {
                        Log.e(TAG, "could not retrieve NFC service");
                        throw new UnsupportedOperationException();
                    }
                    try {
                        sTagService = sService.getNfcTagInterface();
                        try {
                            sCardEmulationService = sService.getNfcCardEmulationInterface();
                            sIsInitialized = true;
                        } catch (RemoteException e) {
                            Log.e(TAG, "could not retrieve card emulation service");
                            throw new UnsupportedOperationException();
                        }
                    } catch (RemoteException e2) {
                        Log.e(TAG, "could not retrieve NFC Tag service");
                        throw new UnsupportedOperationException();
                    }
                }
                if (context == null) {
                    if (sNullContextNfcAdapter == null) {
                        sNullContextNfcAdapter = new NfcAdapter(null);
                    }
                    nfcAdapter = sNullContextNfcAdapter;
                } else {
                    NfcAdapter nfcAdapter2 = sNfcAdapters.get(context);
                    nfcAdapter = nfcAdapter2;
                    if (nfcAdapter2 == null) {
                        nfcAdapter = new NfcAdapter(context);
                        sNfcAdapters.put(context, nfcAdapter);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nfcAdapter;
    }

    private static INfcAdapter getServiceInterface() {
        IBinder service = ServiceManager.getService("nfc");
        if (service == null) {
            return null;
        }
        return INfcAdapter.Stub.asInterface(service);
    }

    private static boolean hasNfcFeature() {
        IPackageManager packageManager = ActivityThread.getPackageManager();
        if (packageManager == null) {
            Log.e(TAG, "Cannot get package manager, assuming no NFC feature");
            return false;
        }
        try {
            return packageManager.hasSystemFeature(PackageManager.FEATURE_NFC);
        } catch (RemoteException e) {
            Log.e(TAG, "Package manager query failed, assuming no NFC feature", e);
            return false;
        }
    }

    public boolean addNfcUnlockHandler(final NfcUnlockHandler nfcUnlockHandler, String[] strArr) {
        if (strArr.length == 0) {
            return false;
        }
        try {
            synchronized (this.mLock) {
                if (this.mNfcUnlockHandlers.containsKey(nfcUnlockHandler)) {
                    sService.removeNfcUnlockHandler(this.mNfcUnlockHandlers.get(nfcUnlockHandler));
                    this.mNfcUnlockHandlers.remove(nfcUnlockHandler);
                }
                INfcUnlockHandler.Stub stub = new INfcUnlockHandler.Stub() { // from class: android.nfc.NfcAdapter.2
                    @Override // android.nfc.INfcUnlockHandler
                    public boolean onUnlockAttempted(Tag tag) throws RemoteException {
                        return nfcUnlockHandler.onUnlockAttempted(tag);
                    }
                };
                sService.addNfcUnlockHandler(stub, Tag.getTechCodesFromStrings(strArr));
                this.mNfcUnlockHandlers.put(nfcUnlockHandler, stub);
            }
            return true;
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, "Unable to register LockscreenDispatch", e2);
            return false;
        }
    }

    public void attemptDeadServiceRecovery(Exception exc) {
        Log.e(TAG, "NFC service dead - attempting to recover", exc);
        INfcAdapter serviceInterface = getServiceInterface();
        if (serviceInterface == null) {
            Log.e(TAG, "could not retrieve NFC service during service recovery");
            return;
        }
        sService = serviceInterface;
        try {
            sTagService = serviceInterface.getNfcTagInterface();
            try {
                sCardEmulationService = serviceInterface.getNfcCardEmulationInterface();
            } catch (RemoteException e) {
                Log.e(TAG, "could not retrieve NFC card emulation service during service recovery");
            }
        } catch (RemoteException e2) {
            Log.e(TAG, "could not retrieve NFC tag service during service recovery");
        }
    }

    public boolean disable() {
        try {
            return sService.disable(true);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public boolean disable(boolean z) {
        try {
            return sService.disable(z);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public void disableForegroundDispatch(Activity activity) {
        ActivityThread.currentActivityThread().unregisterOnActivityPausedListener(activity, this.mForegroundDispatchListener);
        disableForegroundDispatchInternal(activity, false);
    }

    void disableForegroundDispatchInternal(Activity activity, boolean z) {
        try {
            sService.setForegroundDispatch(null, null, null);
            if (z || activity.isResumed()) {
                return;
            }
            throw new IllegalStateException("You must disable foreground dispatching while your activity is still resumed");
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    @Deprecated
    public void disableForegroundNdefPush(Activity activity) {
        if (activity == null) {
            throw new NullPointerException();
        }
        enforceResumed(activity);
        this.mNfcActivityManager.setNdefPushMessage(activity, null, 0);
        this.mNfcActivityManager.setNdefPushMessageCallback(activity, null, 0);
        this.mNfcActivityManager.setOnNdefPushCompleteCallback(activity, null);
    }

    public boolean disableNdefPush() {
        try {
            return sService.disableNdefPush();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public void disableReaderMode(Activity activity) {
        this.mNfcActivityManager.disableReaderMode(activity);
    }

    public void dispatch(Tag tag) {
        if (tag == null) {
            throw new NullPointerException("tag cannot be null");
        }
        try {
            sService.dispatch(tag);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public boolean enable() {
        if (this.mAppOps.noteOp(54) != 0) {
            return false;
        }
        try {
            return sService.enable();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public void enableForegroundDispatch(Activity activity, PendingIntent pendingIntent, IntentFilter[] intentFilterArr, String[][] strArr) {
        if (activity == null || pendingIntent == null) {
            throw new NullPointerException();
        }
        if (!activity.isResumed()) {
            throw new IllegalStateException("Foreground dispatch can only be enabled when your activity is resumed");
        }
        TechListParcel techListParcel = null;
        if (strArr != null) {
            techListParcel = null;
            try {
                if (strArr.length > 0) {
                    techListParcel = new TechListParcel(strArr);
                }
            } catch (RemoteException e) {
                attemptDeadServiceRecovery(e);
                return;
            }
        }
        ActivityThread.currentActivityThread().registerOnActivityPausedListener(activity, this.mForegroundDispatchListener);
        sService.setForegroundDispatch(pendingIntent, intentFilterArr, techListParcel);
    }

    @Deprecated
    public void enableForegroundNdefPush(Activity activity, NdefMessage ndefMessage) {
        if (activity == null || ndefMessage == null) {
            throw new NullPointerException();
        }
        enforceResumed(activity);
        this.mNfcActivityManager.setNdefPushMessage(activity, ndefMessage, 0);
    }

    public boolean enableNdefPush() {
        try {
            return sService.enableNdefPush();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public void enableReaderMode(Activity activity, ReaderCallback readerCallback, int i, Bundle bundle) {
        this.mNfcActivityManager.enableReaderMode(activity, readerCallback, i, bundle);
    }

    void enforceResumed(Activity activity) {
        if (!activity.isResumed()) {
            throw new IllegalStateException("API cannot be called while activity is paused");
        }
    }

    public int getAdapterState() {
        try {
            return sService.getState();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return 1;
        }
    }

    public INfcCardEmulation getCardEmulationService() {
        isEnabled();
        return sCardEmulationService;
    }

    public Context getContext() {
        return this.mContext;
    }

    public INfcAdapterExtras getNfcAdapterExtrasInterface() {
        if (this.mContext == null) {
            throw new UnsupportedOperationException("You need a context on NfcAdapter to use the  NFC extras APIs");
        }
        try {
            return sService.getNfcAdapterExtrasInterface(this.mContext.getPackageName());
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return null;
        }
    }

    int getSdkVersion() {
        if (this.mContext == null) {
            return 9;
        }
        return this.mContext.getApplicationInfo().targetSdkVersion;
    }

    public INfcAdapter getService() {
        isEnabled();
        return sService;
    }

    public INfcTag getTagService() {
        isEnabled();
        return sTagService;
    }

    public boolean invokeBeam(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity may not be null.");
        }
        enforceResumed(activity);
        try {
            sService.invokeBeam();
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "invokeBeam: NFC process has died.");
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public boolean invokeBeam(BeamShareData beamShareData) {
        try {
            Log.e(TAG, "invokeBeamInternal()");
            sService.invokeBeamInternal(beamShareData);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "invokeBeam: NFC process has died.");
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public boolean isEnabled() {
        boolean z = false;
        try {
            if (sService.getState() == 3) {
                z = true;
            }
            return z;
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public boolean isNdefPushEnabled() {
        try {
            return sService.isNdefPushEnabled();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public void pausePolling(int i) {
        try {
            sService.pausePolling(i);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public boolean removeNfcUnlockHandler(NfcUnlockHandler nfcUnlockHandler) {
        try {
            synchronized (this.mLock) {
                if (this.mNfcUnlockHandlers.containsKey(nfcUnlockHandler)) {
                    sService.removeNfcUnlockHandler(this.mNfcUnlockHandlers.remove(nfcUnlockHandler));
                }
            }
            return true;
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
            return false;
        }
    }

    public void resumePolling() {
        try {
            sService.resumePolling();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public void setBeamPushUris(Uri[] uriArr, Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity cannot be null");
        }
        if (uriArr != null) {
            int length = uriArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Uri uri = uriArr[i2];
                if (uri == null) {
                    throw new NullPointerException("Uri not allowed to be null");
                }
                String scheme = uri.getScheme();
                if (scheme == null || !(scheme.equalsIgnoreCase(ContentResolver.SCHEME_FILE) || scheme.equalsIgnoreCase("content"))) {
                    break;
                }
                i = i2 + 1;
            }
            throw new IllegalArgumentException("URI needs to have either scheme file or scheme content");
        }
        this.mNfcActivityManager.setNdefPushContentUri(activity, uriArr);
    }

    public void setBeamPushUrisCallback(CreateBeamUrisCallback createBeamUrisCallback, Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity cannot be null");
        }
        this.mNfcActivityManager.setNdefPushContentUriCallback(activity, createBeamUrisCallback);
    }

    public void setNdefPushMessage(NdefMessage ndefMessage, Activity activity, int i) {
        if (activity == null) {
            throw new NullPointerException("activity cannot be null");
        }
        this.mNfcActivityManager.setNdefPushMessage(activity, ndefMessage, i);
    }

    public void setNdefPushMessage(NdefMessage ndefMessage, Activity activity, Activity... activityArr) {
        int sdkVersion = getSdkVersion();
        try {
            if (activity == null) {
                throw new NullPointerException("activity cannot be null");
            }
            this.mNfcActivityManager.setNdefPushMessage(activity, ndefMessage, 0);
            int length = activityArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Activity activity2 = activityArr[i2];
                if (activity2 == null) {
                    throw new NullPointerException("activities cannot contain null");
                }
                this.mNfcActivityManager.setNdefPushMessage(activity2, ndefMessage, 0);
                i = i2 + 1;
            }
        } catch (IllegalStateException e) {
            if (sdkVersion >= 16) {
                throw e;
            }
            Log.e(TAG, "Cannot call API with Activity that has already been destroyed", e);
        }
    }

    public void setNdefPushMessageCallback(CreateNdefMessageCallback createNdefMessageCallback, Activity activity, int i) {
        if (activity == null) {
            throw new NullPointerException("activity cannot be null");
        }
        this.mNfcActivityManager.setNdefPushMessageCallback(activity, createNdefMessageCallback, i);
    }

    public void setNdefPushMessageCallback(CreateNdefMessageCallback createNdefMessageCallback, Activity activity, Activity... activityArr) {
        int sdkVersion = getSdkVersion();
        try {
            if (activity == null) {
                throw new NullPointerException("activity cannot be null");
            }
            this.mNfcActivityManager.setNdefPushMessageCallback(activity, createNdefMessageCallback, 0);
            int length = activityArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Activity activity2 = activityArr[i2];
                if (activity2 == null) {
                    throw new NullPointerException("activities cannot contain null");
                }
                this.mNfcActivityManager.setNdefPushMessageCallback(activity2, createNdefMessageCallback, 0);
                i = i2 + 1;
            }
        } catch (IllegalStateException e) {
            if (sdkVersion >= 16) {
                throw e;
            }
            Log.e(TAG, "Cannot call API with Activity that has already been destroyed", e);
        }
    }

    public void setOnNdefPushCompleteCallback(OnNdefPushCompleteCallback onNdefPushCompleteCallback, Activity activity, Activity... activityArr) {
        int sdkVersion = getSdkVersion();
        try {
            if (activity == null) {
                throw new NullPointerException("activity cannot be null");
            }
            this.mNfcActivityManager.setOnNdefPushCompleteCallback(activity, onNdefPushCompleteCallback);
            int length = activityArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Activity activity2 = activityArr[i2];
                if (activity2 == null) {
                    throw new NullPointerException("activities cannot contain null");
                }
                this.mNfcActivityManager.setOnNdefPushCompleteCallback(activity2, onNdefPushCompleteCallback);
                i = i2 + 1;
            }
        } catch (IllegalStateException e) {
            if (sdkVersion >= 16) {
                throw e;
            }
            Log.e(TAG, "Cannot call API with Activity that has already been destroyed", e);
        }
    }

    public void setP2pModes(int i, int i2) {
        try {
            sService.setP2pModes(i, i2);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }
}
