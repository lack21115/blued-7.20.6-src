package android.service.media;

import android.app.Service;
import android.content.Intent;
import android.content.pm.ParceledListSlice;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.media.IMediaBrowserService;
import android.util.ArrayMap;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/service/media/MediaBrowserService.class */
public abstract class MediaBrowserService extends Service {
    private static final boolean DBG = false;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    private static final String TAG = "MediaBrowserService";
    private ServiceBinder mBinder;
    private final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap<>();
    private final Handler mHandler = new Handler();
    MediaSession.Token mSession;

    /* loaded from: source-9557208-dex2jar.jar:android/service/media/MediaBrowserService$BrowserRoot.class */
    public static final class BrowserRoot {
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(String str, Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.mRootId = str;
            this.mExtras = bundle;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/service/media/MediaBrowserService$ConnectionRecord.class */
    public class ConnectionRecord {
        IMediaBrowserServiceCallbacks callbacks;
        String pkg;
        BrowserRoot root;
        Bundle rootHints;
        HashSet<String> subscriptions;

        private ConnectionRecord() {
            this.subscriptions = new HashSet<>();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/media/MediaBrowserService$Result.class */
    public class Result<T> {
        private Object mDebug;
        private boolean mDetachCalled;
        private boolean mSendResultCalled;

        Result(Object obj) {
            this.mDebug = obj;
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            }
            if (this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            }
            this.mDetachCalled = true;
        }

        boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled;
        }

        void onResultSent(T t) {
        }

        public void sendResult(T t) {
            if (this.mSendResultCalled) {
                throw new IllegalStateException("sendResult() called twice for: " + this.mDebug);
            }
            this.mSendResultCalled = true;
            onResultSent(t);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/media/MediaBrowserService$ServiceBinder.class */
    private class ServiceBinder extends IMediaBrowserService.Stub {
        private ServiceBinder() {
        }

        @Override // android.service.media.IMediaBrowserService
        public void addSubscription(final String str, final IMediaBrowserServiceCallbacks iMediaBrowserServiceCallbacks) {
            MediaBrowserService.this.mHandler.post(new Runnable() { // from class: android.service.media.MediaBrowserService.ServiceBinder.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserService.this.mConnections.get(iMediaBrowserServiceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserService.TAG, "addSubscription for callback that isn't registered id=" + str);
                    } else {
                        MediaBrowserService.this.addSubscription(str, connectionRecord);
                    }
                }
            });
        }

        @Override // android.service.media.IMediaBrowserService
        public void connect(final String str, final Bundle bundle, final IMediaBrowserServiceCallbacks iMediaBrowserServiceCallbacks) {
            final int callingUid = Binder.getCallingUid();
            if (!MediaBrowserService.this.isValidPackage(str, callingUid)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + callingUid + " package=" + str);
            }
            MediaBrowserService.this.mHandler.post(new Runnable() { // from class: android.service.media.MediaBrowserService.ServiceBinder.1
                @Override // java.lang.Runnable
                public void run() {
                    IBinder asBinder = iMediaBrowserServiceCallbacks.asBinder();
                    MediaBrowserService.this.mConnections.remove(asBinder);
                    ConnectionRecord connectionRecord = new ConnectionRecord();
                    connectionRecord.pkg = str;
                    connectionRecord.rootHints = bundle;
                    connectionRecord.callbacks = iMediaBrowserServiceCallbacks;
                    connectionRecord.root = MediaBrowserService.this.onGetRoot(str, callingUid, bundle);
                    if (connectionRecord.root == null) {
                        Log.i(MediaBrowserService.TAG, "No root for client " + str + " from service " + getClass().getName());
                        try {
                            iMediaBrowserServiceCallbacks.onConnectFailed();
                            return;
                        } catch (RemoteException e) {
                            Log.w(MediaBrowserService.TAG, "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                            return;
                        }
                    }
                    try {
                        MediaBrowserService.this.mConnections.put(asBinder, connectionRecord);
                        if (MediaBrowserService.this.mSession != null) {
                            iMediaBrowserServiceCallbacks.onConnect(connectionRecord.root.getRootId(), MediaBrowserService.this.mSession, connectionRecord.root.getExtras());
                        }
                    } catch (RemoteException e2) {
                        Log.w(MediaBrowserService.TAG, "Calling onConnect() failed. Dropping client. pkg=" + str);
                        MediaBrowserService.this.mConnections.remove(asBinder);
                    }
                }
            });
        }

        @Override // android.service.media.IMediaBrowserService
        public void disconnect(final IMediaBrowserServiceCallbacks iMediaBrowserServiceCallbacks) {
            MediaBrowserService.this.mHandler.post(new Runnable() { // from class: android.service.media.MediaBrowserService.ServiceBinder.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((ConnectionRecord) MediaBrowserService.this.mConnections.remove(iMediaBrowserServiceCallbacks.asBinder())) != null) {
                    }
                }
            });
        }

        @Override // android.service.media.IMediaBrowserService
        public void removeSubscription(final String str, final IMediaBrowserServiceCallbacks iMediaBrowserServiceCallbacks) {
            MediaBrowserService.this.mHandler.post(new Runnable() { // from class: android.service.media.MediaBrowserService.ServiceBinder.4
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserService.this.mConnections.get(iMediaBrowserServiceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserService.TAG, "removeSubscription for callback that isn't registered id=" + str);
                    } else if (connectionRecord.subscriptions.remove(str)) {
                    } else {
                        Log.w(MediaBrowserService.TAG, "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubscription(String str, ConnectionRecord connectionRecord) {
        if (connectionRecord.subscriptions.add(str)) {
            performLoadChildren(str, connectionRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidPackage(String str, int i) {
        if (str == null) {
            return false;
        }
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        int length = packagesForUid.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (packagesForUid[i3].equals(str)) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performLoadChildren(final String str, final ConnectionRecord connectionRecord) {
        Result<List<MediaBrowser.MediaItem>> result = new Result<List<MediaBrowser.MediaItem>>(str) { // from class: android.service.media.MediaBrowserService.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.service.media.MediaBrowserService.Result
            public void onResultSent(List<MediaBrowser.MediaItem> list) {
                if (list == null) {
                    throw new IllegalStateException("onLoadChildren sent null list for id " + str);
                }
                if (MediaBrowserService.this.mConnections.get(connectionRecord.callbacks.asBinder()) != connectionRecord) {
                    return;
                }
                try {
                    connectionRecord.callbacks.onLoadChildren(str, new ParceledListSlice(list));
                } catch (RemoteException e) {
                    Log.w(MediaBrowserService.TAG, "Calling onLoadChildren() failed for id=" + str + " package=" + connectionRecord.pkg);
                }
            }
        };
        onLoadChildren(str, result);
        if (!result.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.pkg + " id=" + str);
        }
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public MediaSession.Token getSessionToken() {
        return this.mSession;
    }

    public void notifyChildrenChanged(final String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mHandler.post(new Runnable() { // from class: android.service.media.MediaBrowserService.2
            @Override // java.lang.Runnable
            public void run() {
                for (IBinder iBinder : MediaBrowserService.this.mConnections.keySet()) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserService.this.mConnections.get(iBinder);
                    if (connectionRecord.subscriptions.contains(str)) {
                        MediaBrowserService.this.performLoadChildren(str, connectionRecord);
                    }
                }
            }
        });
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
            return this.mBinder;
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mBinder = new ServiceBinder();
    }

    public abstract BrowserRoot onGetRoot(String str, int i, Bundle bundle);

    public abstract void onLoadChildren(String str, Result<List<MediaBrowser.MediaItem>> result);

    public void setSessionToken(final MediaSession.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        }
        this.mSession = token;
        this.mHandler.post(new Runnable() { // from class: android.service.media.MediaBrowserService.1
            @Override // java.lang.Runnable
            public void run() {
                for (IBinder iBinder : MediaBrowserService.this.mConnections.keySet()) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserService.this.mConnections.get(iBinder);
                    try {
                        connectionRecord.callbacks.onConnect(connectionRecord.root.getRootId(), token, connectionRecord.root.getExtras());
                    } catch (RemoteException e) {
                        Log.w(MediaBrowserService.TAG, "Connection for " + connectionRecord.pkg + " is no longer valid.");
                        MediaBrowserService.this.mConnections.remove(iBinder);
                    }
                }
            }
        });
    }
}
