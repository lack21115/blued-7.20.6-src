package android.media.browse;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ParceledListSlice;
import android.media.MediaDescription;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.IMediaBrowserService;
import android.service.media.IMediaBrowserServiceCallbacks;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/browse/MediaBrowser.class */
public final class MediaBrowser {
    private static final int CONNECT_STATE_CONNECTED = 2;
    private static final int CONNECT_STATE_CONNECTING = 1;
    private static final int CONNECT_STATE_DISCONNECTED = 0;
    private static final int CONNECT_STATE_SUSPENDED = 3;
    private static final boolean DBG = false;
    private static final String TAG = "MediaBrowser";
    private final ConnectionCallback mCallback;
    private final Context mContext;
    private Bundle mExtras;
    private MediaSession.Token mMediaSessionToken;
    private final Bundle mRootHints;
    private String mRootId;
    private IMediaBrowserService mServiceBinder;
    private IMediaBrowserServiceCallbacks mServiceCallbacks;
    private final ComponentName mServiceComponent;
    private MediaServiceConnection mServiceConnection;
    private final Handler mHandler = new Handler();
    private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();
    private int mState = 0;

    /* loaded from: source-9557208-dex2jar.jar:android/media/browse/MediaBrowser$ConnectionCallback.class */
    public static class ConnectionCallback {
        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/browse/MediaBrowser$MediaItem.class */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.media.browse.MediaBrowser.MediaItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescription mDescription;
        private final int mFlags;

        public MediaItem(MediaDescription mediaDescription, int i) {
            if (mediaDescription == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescription.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = i;
            this.mDescription = mediaDescription;
        }

        private MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = MediaDescription.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaDescription getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=").append(this.mFlags);
            sb.append(", mDescription=").append(this.mDescription);
            sb.append('}');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/browse/MediaBrowser$MediaServiceConnection.class */
    public class MediaServiceConnection implements ServiceConnection {
        private MediaServiceConnection() {
        }

        private boolean isCurrent(String str) {
            if (MediaBrowser.this.mServiceConnection != this) {
                if (MediaBrowser.this.mState != 0) {
                    Log.i(MediaBrowser.TAG, str + " for " + MediaBrowser.this.mServiceComponent + " with mServiceConnection=" + MediaBrowser.this.mServiceConnection + " this=" + this);
                    return false;
                }
                return false;
            }
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (isCurrent("onServiceConnected")) {
                MediaBrowser.this.mServiceBinder = IMediaBrowserService.Stub.asInterface(iBinder);
                MediaBrowser.this.mServiceCallbacks = MediaBrowser.this.getNewServiceCallbacks();
                MediaBrowser.this.mState = 1;
                try {
                    MediaBrowser.this.mServiceBinder.connect(MediaBrowser.this.mContext.getPackageName(), MediaBrowser.this.mRootHints, MediaBrowser.this.mServiceCallbacks);
                } catch (RemoteException e) {
                    Log.w(MediaBrowser.TAG, "RemoteException during connect for " + MediaBrowser.this.mServiceComponent);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (isCurrent("onServiceDisconnected")) {
                MediaBrowser.this.mServiceBinder = null;
                MediaBrowser.this.mServiceCallbacks = null;
                MediaBrowser.this.mState = 3;
                MediaBrowser.this.mCallback.onConnectionSuspended();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/browse/MediaBrowser$ServiceCallbacks.class */
    public static class ServiceCallbacks extends IMediaBrowserServiceCallbacks.Stub {
        private WeakReference<MediaBrowser> mMediaBrowser;

        public ServiceCallbacks(MediaBrowser mediaBrowser) {
            this.mMediaBrowser = new WeakReference<>(mediaBrowser);
        }

        @Override // android.service.media.IMediaBrowserServiceCallbacks
        public void onConnect(String str, MediaSession.Token token, Bundle bundle) {
            MediaBrowser mediaBrowser = this.mMediaBrowser.get();
            if (mediaBrowser != null) {
                mediaBrowser.onServiceConnected(this, str, token, bundle);
            }
        }

        @Override // android.service.media.IMediaBrowserServiceCallbacks
        public void onConnectFailed() {
            MediaBrowser mediaBrowser = this.mMediaBrowser.get();
            if (mediaBrowser != null) {
                mediaBrowser.onConnectionFailed(this);
            }
        }

        @Override // android.service.media.IMediaBrowserServiceCallbacks
        public void onLoadChildren(String str, ParceledListSlice parceledListSlice) {
            MediaBrowser mediaBrowser = this.mMediaBrowser.get();
            if (mediaBrowser != null) {
                mediaBrowser.onLoadChildren(this, str, parceledListSlice);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/browse/MediaBrowser$Subscription.class */
    private static class Subscription {
        SubscriptionCallback callback;
        final String id;

        Subscription(String str) {
            this.id = str;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/browse/MediaBrowser$SubscriptionCallback.class */
    public static abstract class SubscriptionCallback {
        public void onChildrenLoaded(String str, List<MediaItem> list) {
        }

        public void onError(String str) {
        }
    }

    public MediaBrowser(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (componentName == null) {
            throw new IllegalArgumentException("service component must not be null");
        }
        if (connectionCallback == null) {
            throw new IllegalArgumentException("connection callback must not be null");
        }
        this.mContext = context;
        this.mServiceComponent = componentName;
        this.mCallback = connectionCallback;
        this.mRootHints = bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceCloseConnection() {
        if (this.mServiceConnection != null) {
            this.mContext.unbindService(this.mServiceConnection);
        }
        this.mState = 0;
        this.mServiceConnection = null;
        this.mServiceBinder = null;
        this.mServiceCallbacks = null;
        this.mRootId = null;
        this.mMediaSessionToken = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ServiceCallbacks getNewServiceCallbacks() {
        return new ServiceCallbacks(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStateLabel(int i) {
        switch (i) {
            case 0:
                return "CONNECT_STATE_DISCONNECTED";
            case 1:
                return "CONNECT_STATE_CONNECTING";
            case 2:
                return "CONNECT_STATE_CONNECTED";
            case 3:
                return "CONNECT_STATE_SUSPENDED";
            default:
                return "UNKNOWN/" + i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrent(IMediaBrowserServiceCallbacks iMediaBrowserServiceCallbacks, String str) {
        if (this.mServiceCallbacks != iMediaBrowserServiceCallbacks) {
            if (this.mState != 0) {
                Log.i(TAG, str + " for " + this.mServiceComponent + " with mServiceConnection=" + this.mServiceCallbacks + " this=" + this);
                return false;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConnectionFailed(final IMediaBrowserServiceCallbacks iMediaBrowserServiceCallbacks) {
        this.mHandler.post(new Runnable() { // from class: android.media.browse.MediaBrowser.3
            @Override // java.lang.Runnable
            public void run() {
                Log.e(MediaBrowser.TAG, "onConnectFailed for " + MediaBrowser.this.mServiceComponent);
                if (MediaBrowser.this.isCurrent(iMediaBrowserServiceCallbacks, "onConnectFailed")) {
                    if (MediaBrowser.this.mState != 1) {
                        Log.w(MediaBrowser.TAG, "onConnect from service while mState=" + MediaBrowser.getStateLabel(MediaBrowser.this.mState) + "... ignoring");
                        return;
                    }
                    MediaBrowser.this.forceCloseConnection();
                    MediaBrowser.this.mCallback.onConnectionFailed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadChildren(final IMediaBrowserServiceCallbacks iMediaBrowserServiceCallbacks, final String str, final ParceledListSlice parceledListSlice) {
        this.mHandler.post(new Runnable() { // from class: android.media.browse.MediaBrowser.4
            @Override // java.lang.Runnable
            public void run() {
                if (MediaBrowser.this.isCurrent(iMediaBrowserServiceCallbacks, "onLoadChildren")) {
                    List<MediaItem> list = parceledListSlice.getList();
                    List<MediaItem> list2 = list;
                    if (list == null) {
                        list2 = Collections.emptyList();
                    }
                    Subscription subscription = (Subscription) MediaBrowser.this.mSubscriptions.get(str);
                    if (subscription != null) {
                        subscription.callback.onChildrenLoaded(str, list2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onServiceConnected(final IMediaBrowserServiceCallbacks iMediaBrowserServiceCallbacks, final String str, final MediaSession.Token token, final Bundle bundle) {
        this.mHandler.post(new Runnable() { // from class: android.media.browse.MediaBrowser.2
            @Override // java.lang.Runnable
            public void run() {
                if (MediaBrowser.this.isCurrent(iMediaBrowserServiceCallbacks, "onConnect")) {
                    if (MediaBrowser.this.mState != 1) {
                        Log.w(MediaBrowser.TAG, "onConnect from service while mState=" + MediaBrowser.getStateLabel(MediaBrowser.this.mState) + "... ignoring");
                        return;
                    }
                    MediaBrowser.this.mRootId = str;
                    MediaBrowser.this.mMediaSessionToken = token;
                    MediaBrowser.this.mExtras = bundle;
                    MediaBrowser.this.mState = 2;
                    MediaBrowser.this.mCallback.onConnected();
                    for (String str2 : MediaBrowser.this.mSubscriptions.keySet()) {
                        try {
                            MediaBrowser.this.mServiceBinder.addSubscription(str2, MediaBrowser.this.mServiceCallbacks);
                        } catch (RemoteException e) {
                            Log.d(MediaBrowser.TAG, "addSubscription failed with RemoteException parentId=" + str2);
                        }
                    }
                }
            }
        });
    }

    public void connect() {
        if (this.mState != 0) {
            throw new IllegalStateException("connect() called while not disconnected (state=" + getStateLabel(this.mState) + ")");
        }
        if (this.mServiceBinder != null) {
            throw new RuntimeException("mServiceBinder should be null. Instead it is " + this.mServiceBinder);
        }
        if (this.mServiceCallbacks != null) {
            throw new RuntimeException("mServiceCallbacks should be null. Instead it is " + this.mServiceCallbacks);
        }
        this.mState = 1;
        Intent intent = new Intent("android.media.browse.MediaBrowserService");
        intent.setComponent(this.mServiceComponent);
        final MediaServiceConnection mediaServiceConnection = new MediaServiceConnection();
        this.mServiceConnection = mediaServiceConnection;
        boolean z = false;
        try {
            z = this.mContext.bindService(intent, this.mServiceConnection, 1);
        } catch (Exception e) {
            Log.e(TAG, "Failed binding to service " + this.mServiceComponent);
        }
        if (z) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: android.media.browse.MediaBrowser.1
            @Override // java.lang.Runnable
            public void run() {
                if (mediaServiceConnection == MediaBrowser.this.mServiceConnection) {
                    MediaBrowser.this.forceCloseConnection();
                    MediaBrowser.this.mCallback.onConnectionFailed();
                }
            }
        });
    }

    public void disconnect() {
        if (this.mServiceCallbacks != null) {
            try {
                this.mServiceBinder.disconnect(this.mServiceCallbacks);
            } catch (RemoteException e) {
                Log.w(TAG, "RemoteException during connect for " + this.mServiceComponent);
            }
        }
        forceCloseConnection();
    }

    void dump() {
        Log.d(TAG, "MediaBrowser...");
        Log.d(TAG, "  mServiceComponent=" + this.mServiceComponent);
        Log.d(TAG, "  mCallback=" + this.mCallback);
        Log.d(TAG, "  mRootHints=" + this.mRootHints);
        Log.d(TAG, "  mState=" + getStateLabel(this.mState));
        Log.d(TAG, "  mServiceConnection=" + this.mServiceConnection);
        Log.d(TAG, "  mServiceBinder=" + this.mServiceBinder);
        Log.d(TAG, "  mServiceCallbacks=" + this.mServiceCallbacks);
        Log.d(TAG, "  mRootId=" + this.mRootId);
        Log.d(TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
    }

    public Bundle getExtras() {
        if (isConnected()) {
            return this.mExtras;
        }
        throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
    }

    public String getRoot() {
        if (isConnected()) {
            return this.mRootId;
        }
        throw new IllegalStateException("getSessionToken() called while not connected (state=" + getStateLabel(this.mState) + ")");
    }

    public ComponentName getServiceComponent() {
        if (isConnected()) {
            return this.mServiceComponent;
        }
        throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
    }

    public MediaSession.Token getSessionToken() {
        if (isConnected()) {
            return this.mMediaSessionToken;
        }
        throw new IllegalStateException("getSessionToken() called while not connected (state=" + this.mState + ")");
    }

    public boolean isConnected() {
        return this.mState == 2;
    }

    public void subscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (str == null) {
            throw new IllegalArgumentException("parentId is null");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        Subscription subscription = this.mSubscriptions.get(str);
        boolean z = subscription == null;
        if (z) {
            subscription = new Subscription(str);
            this.mSubscriptions.put(str, subscription);
        }
        subscription.callback = subscriptionCallback;
        if (this.mState == 2 && z) {
            try {
                this.mServiceBinder.addSubscription(str, this.mServiceCallbacks);
            } catch (RemoteException e) {
                Log.d(TAG, "addSubscription failed with RemoteException parentId=" + str);
            }
        }
    }

    public void unsubscribe(String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId is null");
        }
        Subscription remove = this.mSubscriptions.remove(str);
        if (this.mState != 2 || remove == null) {
            return;
        }
        try {
            this.mServiceBinder.removeSubscription(str, this.mServiceCallbacks);
        } catch (RemoteException e) {
            Log.d(TAG, "removeSubscription failed with RemoteException parentId=" + str);
        }
    }
}
