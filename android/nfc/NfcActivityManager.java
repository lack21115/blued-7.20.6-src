package android.nfc;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.net.Uri;
import android.nfc.IAppCallback;
import android.nfc.NfcAdapter;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcActivityManager.class */
public final class NfcActivityManager extends IAppCallback.Stub implements Application.ActivityLifecycleCallbacks {
    static final Boolean DBG = false;
    static final String TAG = "NFC";
    final NfcAdapter mAdapter;
    final NfcEvent mDefaultEvent;
    final List<NfcActivityState> mActivities = new LinkedList();
    final List<NfcApplicationState> mApps = new ArrayList(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcActivityManager$NfcActivityState.class */
    public class NfcActivityState {
        Activity activity;
        boolean resumed;
        Binder token;
        NdefMessage ndefMessage = null;
        NfcAdapter.CreateNdefMessageCallback ndefMessageCallback = null;
        NfcAdapter.OnNdefPushCompleteCallback onNdefPushCompleteCallback = null;
        NfcAdapter.CreateBeamUrisCallback uriCallback = null;
        Uri[] uris = null;
        int flags = 0;
        int readerModeFlags = 0;
        NfcAdapter.ReaderCallback readerCallback = null;
        Bundle readerModeExtras = null;

        public NfcActivityState(Activity activity) {
            this.resumed = false;
            if (activity.getWindow().isDestroyed()) {
                throw new IllegalStateException("activity is already destroyed");
            }
            this.resumed = activity.isResumed();
            this.activity = activity;
            this.token = new Binder();
            NfcActivityManager.this.registerApplication(activity.getApplication());
        }

        public void destroy() {
            NfcActivityManager.this.unregisterApplication(this.activity.getApplication());
            this.resumed = false;
            this.activity = null;
            this.ndefMessage = null;
            this.ndefMessageCallback = null;
            this.onNdefPushCompleteCallback = null;
            this.uriCallback = null;
            this.uris = null;
            this.readerModeFlags = 0;
            this.token = null;
        }

        public String toString() {
            StringBuilder append = new StringBuilder("[").append(" ");
            append.append(this.ndefMessage).append(" ").append(this.ndefMessageCallback).append(" ");
            append.append(this.uriCallback).append(" ");
            if (this.uris != null) {
                Uri[] uriArr = this.uris;
                int length = uriArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    append.append(this.onNdefPushCompleteCallback).append(" ").append(uriArr[i2]).append("]");
                    i = i2 + 1;
                }
            }
            return append.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/nfc/NfcActivityManager$NfcApplicationState.class */
    public class NfcApplicationState {
        final Application app;
        int refCount = 0;

        public NfcApplicationState(Application application) {
            this.app = application;
        }

        public void register() {
            this.refCount++;
            if (this.refCount == 1) {
                this.app.registerActivityLifecycleCallbacks(NfcActivityManager.this);
            }
        }

        public void unregister() {
            this.refCount--;
            if (this.refCount == 0) {
                this.app.unregisterActivityLifecycleCallbacks(NfcActivityManager.this);
            } else if (this.refCount < 0) {
                Log.e(NfcActivityManager.TAG, "-ve refcount for " + this.app);
            }
        }
    }

    public NfcActivityManager(NfcAdapter nfcAdapter) {
        this.mAdapter = nfcAdapter;
        this.mDefaultEvent = new NfcEvent(this.mAdapter);
    }

    @Override // android.nfc.IAppCallback
    public BeamShareData createBeamShareData() {
        synchronized (this) {
            NfcActivityState findResumedActivityState = findResumedActivityState();
            if (findResumedActivityState == null) {
                return null;
            }
            NfcAdapter.CreateNdefMessageCallback createNdefMessageCallback = findResumedActivityState.ndefMessageCallback;
            NfcAdapter.CreateBeamUrisCallback createBeamUrisCallback = findResumedActivityState.uriCallback;
            NdefMessage ndefMessage = findResumedActivityState.ndefMessage;
            Uri[] uriArr = findResumedActivityState.uris;
            int i = findResumedActivityState.flags;
            Activity activity = findResumedActivityState.activity;
            if (createNdefMessageCallback != null) {
                ndefMessage = createNdefMessageCallback.createNdefMessage(this.mDefaultEvent);
            }
            if (createBeamUrisCallback != null) {
                Uri[] createBeamUris = createBeamUrisCallback.createBeamUris(this.mDefaultEvent);
                uriArr = createBeamUris;
                if (createBeamUris != null) {
                    ArrayList arrayList = new ArrayList();
                    int length = createBeamUris.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        Uri uri = createBeamUris[i3];
                        if (uri == null) {
                            Log.e(TAG, "Uri not allowed to be null.");
                        } else {
                            String scheme = uri.getScheme();
                            if (scheme == null || !(scheme.equalsIgnoreCase(ContentResolver.SCHEME_FILE) || scheme.equalsIgnoreCase("content"))) {
                                Log.e(TAG, "Uri needs to have either scheme file or scheme content");
                            } else {
                                arrayList.add(ContentProvider.maybeAddUserId(uri, UserHandle.myUserId()));
                            }
                        }
                        i2 = i3 + 1;
                    }
                    uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
                }
            }
            if (uriArr != null && uriArr.length > 0) {
                int length2 = uriArr.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= length2) {
                        break;
                    }
                    activity.grantUriPermission("com.android.nfc", uriArr[i5], 1);
                    i4 = i5 + 1;
                }
            }
            return new BeamShareData(ndefMessage, uriArr, UserHandle.CURRENT, i);
        }
    }

    void destroyActivityState(Activity activity) {
        synchronized (this) {
            NfcActivityState findActivityState = findActivityState(activity);
            if (findActivityState != null) {
                findActivityState.destroy();
                this.mActivities.remove(findActivityState);
            }
        }
    }

    public void disableReaderMode(Activity activity) {
        Binder binder;
        boolean z;
        synchronized (this) {
            NfcActivityState activityState = getActivityState(activity);
            activityState.readerCallback = null;
            activityState.readerModeFlags = 0;
            activityState.readerModeExtras = null;
            binder = activityState.token;
            z = activityState.resumed;
        }
        if (z) {
            setReaderMode(binder, 0, null);
        }
    }

    public void enableReaderMode(Activity activity, NfcAdapter.ReaderCallback readerCallback, int i, Bundle bundle) {
        Binder binder;
        boolean z;
        synchronized (this) {
            NfcActivityState activityState = getActivityState(activity);
            activityState.readerCallback = readerCallback;
            activityState.readerModeFlags = i;
            activityState.readerModeExtras = bundle;
            binder = activityState.token;
            z = activityState.resumed;
        }
        if (z) {
            setReaderMode(binder, i, bundle);
        }
    }

    NfcActivityState findActivityState(Activity activity) {
        NfcActivityState nfcActivityState;
        synchronized (this) {
            Iterator<NfcActivityState> it = this.mActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    nfcActivityState = null;
                    break;
                }
                NfcActivityState next = it.next();
                if (next.activity == activity) {
                    nfcActivityState = next;
                    break;
                }
            }
        }
        return nfcActivityState;
    }

    NfcApplicationState findAppState(Application application) {
        for (NfcApplicationState nfcApplicationState : this.mApps) {
            if (nfcApplicationState.app == application) {
                return nfcApplicationState;
            }
        }
        return null;
    }

    NfcActivityState findResumedActivityState() {
        NfcActivityState nfcActivityState;
        synchronized (this) {
            Iterator<NfcActivityState> it = this.mActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    nfcActivityState = null;
                    break;
                }
                nfcActivityState = it.next();
                if (nfcActivityState.resumed) {
                    break;
                }
            }
        }
        return nfcActivityState;
    }

    NfcActivityState getActivityState(Activity activity) {
        NfcActivityState nfcActivityState;
        synchronized (this) {
            NfcActivityState findActivityState = findActivityState(activity);
            nfcActivityState = findActivityState;
            if (findActivityState == null) {
                nfcActivityState = new NfcActivityState(activity);
                this.mActivities.add(nfcActivityState);
            }
        }
        return nfcActivityState;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        synchronized (this) {
            NfcActivityState findActivityState = findActivityState(activity);
            if (DBG.booleanValue()) {
                Log.d(TAG, "onDestroy() for " + activity + " " + findActivityState);
            }
            if (findActivityState != null) {
                destroyActivityState(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        synchronized (this) {
            NfcActivityState findActivityState = findActivityState(activity);
            if (DBG.booleanValue()) {
                Log.d(TAG, "onPause() for " + activity + " " + findActivityState);
            }
            if (findActivityState == null) {
                return;
            }
            findActivityState.resumed = false;
            Binder binder = findActivityState.token;
            boolean z = findActivityState.readerModeFlags != 0;
            if (z) {
                setReaderMode(binder, 0, null);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        synchronized (this) {
            NfcActivityState findActivityState = findActivityState(activity);
            if (DBG.booleanValue()) {
                Log.d(TAG, "onResume() for " + activity + " " + findActivityState);
            }
            if (findActivityState == null) {
                return;
            }
            findActivityState.resumed = true;
            Binder binder = findActivityState.token;
            int i = findActivityState.readerModeFlags;
            Bundle bundle = findActivityState.readerModeExtras;
            if (i != 0) {
                setReaderMode(binder, i, bundle);
            }
            requestNfcServiceCallback();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.nfc.IAppCallback
    public void onNdefPushComplete() {
        synchronized (this) {
            NfcActivityState findResumedActivityState = findResumedActivityState();
            if (findResumedActivityState == null) {
                return;
            }
            NfcAdapter.OnNdefPushCompleteCallback onNdefPushCompleteCallback = findResumedActivityState.onNdefPushCompleteCallback;
            if (onNdefPushCompleteCallback != null) {
                onNdefPushCompleteCallback.onNdefPushComplete(this.mDefaultEvent);
            }
        }
    }

    @Override // android.nfc.IAppCallback
    public void onTagDiscovered(Tag tag) throws RemoteException {
        synchronized (this) {
            NfcActivityState findResumedActivityState = findResumedActivityState();
            if (findResumedActivityState == null) {
                return;
            }
            NfcAdapter.ReaderCallback readerCallback = findResumedActivityState.readerCallback;
            if (readerCallback != null) {
                readerCallback.onTagDiscovered(tag);
            }
        }
    }

    void registerApplication(Application application) {
        NfcApplicationState findAppState = findAppState(application);
        NfcApplicationState nfcApplicationState = findAppState;
        if (findAppState == null) {
            nfcApplicationState = new NfcApplicationState(application);
            this.mApps.add(nfcApplicationState);
        }
        nfcApplicationState.register();
    }

    void requestNfcServiceCallback() {
        try {
            NfcAdapter.sService.setAppCallback(this);
        } catch (RemoteException e) {
            this.mAdapter.attemptDeadServiceRecovery(e);
        }
    }

    public void setNdefPushContentUri(Activity activity, Uri[] uriArr) {
        boolean z;
        synchronized (this) {
            NfcActivityState activityState = getActivityState(activity);
            activityState.uris = uriArr;
            z = activityState.resumed;
        }
        if (z) {
            requestNfcServiceCallback();
        } else {
            verifyNfcPermission();
        }
    }

    public void setNdefPushContentUriCallback(Activity activity, NfcAdapter.CreateBeamUrisCallback createBeamUrisCallback) {
        boolean z;
        synchronized (this) {
            NfcActivityState activityState = getActivityState(activity);
            activityState.uriCallback = createBeamUrisCallback;
            z = activityState.resumed;
        }
        if (z) {
            requestNfcServiceCallback();
        } else {
            verifyNfcPermission();
        }
    }

    public void setNdefPushMessage(Activity activity, NdefMessage ndefMessage, int i) {
        boolean z;
        synchronized (this) {
            NfcActivityState activityState = getActivityState(activity);
            activityState.ndefMessage = ndefMessage;
            activityState.flags = i;
            z = activityState.resumed;
        }
        if (z) {
            requestNfcServiceCallback();
        } else {
            verifyNfcPermission();
        }
    }

    public void setNdefPushMessageCallback(Activity activity, NfcAdapter.CreateNdefMessageCallback createNdefMessageCallback, int i) {
        boolean z;
        synchronized (this) {
            NfcActivityState activityState = getActivityState(activity);
            activityState.ndefMessageCallback = createNdefMessageCallback;
            activityState.flags = i;
            z = activityState.resumed;
        }
        if (z) {
            requestNfcServiceCallback();
        } else {
            verifyNfcPermission();
        }
    }

    public void setOnNdefPushCompleteCallback(Activity activity, NfcAdapter.OnNdefPushCompleteCallback onNdefPushCompleteCallback) {
        boolean z;
        synchronized (this) {
            NfcActivityState activityState = getActivityState(activity);
            activityState.onNdefPushCompleteCallback = onNdefPushCompleteCallback;
            z = activityState.resumed;
        }
        if (z) {
            requestNfcServiceCallback();
        } else {
            verifyNfcPermission();
        }
    }

    public void setReaderMode(Binder binder, int i, Bundle bundle) {
        if (DBG.booleanValue()) {
            Log.d(TAG, "Setting reader mode");
        }
        try {
            NfcAdapter.sService.setReaderMode(binder, this, i, bundle);
        } catch (RemoteException e) {
            this.mAdapter.attemptDeadServiceRecovery(e);
        }
    }

    void unregisterApplication(Application application) {
        NfcApplicationState findAppState = findAppState(application);
        if (findAppState == null) {
            Log.e(TAG, "app was not registered " + application);
        } else {
            findAppState.unregister();
        }
    }

    void verifyNfcPermission() {
        try {
            NfcAdapter.sService.verifyNfcPermission();
        } catch (RemoteException e) {
            this.mAdapter.attemptDeadServiceRecovery(e);
        }
    }
}
