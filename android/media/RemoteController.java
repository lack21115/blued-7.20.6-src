package android.media;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.IRemoteControlDisplay;
import android.media.session.MediaController;
import android.media.session.MediaSessionLegacyHelper;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.List;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/media/RemoteController.class */
public final class RemoteController {
    private static final boolean DEBUG = false;
    private static final int MAX_BITMAP_DIMENSION = 512;
    private static final int MSG_CLIENT_CHANGE = 4;
    private static final int MSG_DISPLAY_ENABLE = 5;
    private static final int MSG_NEW_MEDIA_METADATA = 7;
    private static final int MSG_NEW_METADATA = 3;
    private static final int MSG_NEW_PENDING_INTENT = 0;
    private static final int MSG_NEW_PLAYBACK_INFO = 1;
    private static final int MSG_NEW_PLAYBACK_STATE = 6;
    private static final int MSG_NEW_TRANSPORT_INFO = 2;
    public static final int POSITION_SYNCHRONIZATION_CHECK = 1;
    public static final int POSITION_SYNCHRONIZATION_NONE = 0;
    private static final int SENDMSG_NOOP = 1;
    private static final int SENDMSG_QUEUE = 2;
    private static final int SENDMSG_REPLACE = 0;
    private static final String TAG = "RemoteController";
    private static final int TRANSPORT_UNKNOWN = 0;
    private static final boolean USE_SESSIONS = true;
    private static final Object mGenLock = new Object();
    private static final Object mInfoLock = new Object();
    private int mArtworkHeight;
    private int mArtworkWidth;
    private final AudioManager mAudioManager;
    private int mClientGenerationIdCurrent;
    private PendingIntent mClientPendingIntentCurrent;
    private final Context mContext;
    private MediaController mCurrentSession;
    private boolean mEnabled;
    private final EventHandler mEventHandler;
    private boolean mIsRegistered;
    private PlaybackInfo mLastPlaybackInfo;
    private final int mMaxBitmapDimension;
    private MetadataEditor mMetadataEditor;
    private OnClientUpdateListener mOnClientUpdateListener;
    private final RcDisplay mRcd;
    private MediaController.Callback mSessionCb;
    private MediaSessionManager.OnActiveSessionsChangedListener mSessionListener;
    private MediaSessionManager mSessionManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteController$EventHandler.class */
    public class EventHandler extends Handler {
        public EventHandler(RemoteController remoteController, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case 0:
                    RemoteController.this.onNewPendingIntent(message.arg1, (PendingIntent) message.obj);
                    return;
                case 1:
                    RemoteController.this.onNewPlaybackInfo(message.arg1, (PlaybackInfo) message.obj);
                    return;
                case 2:
                    RemoteController.this.onNewTransportInfo(message.arg1, message.arg2);
                    return;
                case 3:
                    RemoteController.this.onNewMetadata(message.arg1, (Bundle) message.obj);
                    return;
                case 4:
                    RemoteController remoteController = RemoteController.this;
                    int i = message.arg1;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    remoteController.onClientChange(i, z);
                    return;
                case 5:
                    RemoteController.this.onDisplayEnable(message.arg1 == 1);
                    return;
                case 6:
                    RemoteController.this.onNewPlaybackState((PlaybackState) message.obj);
                    return;
                case 7:
                    RemoteController.this.onNewMediaMetadata((MediaMetadata) message.obj);
                    return;
                default:
                    Log.e(RemoteController.TAG, "unknown event " + message.what);
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteController$MediaControllerCallback.class */
    private class MediaControllerCallback extends MediaController.Callback {
        private MediaControllerCallback() {
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            RemoteController.this.onNewMediaMetadata(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlayItemResponse(boolean z) {
            Log.d(RemoteController.TAG, "MediaControllerCallback: onPlayItemResponse");
            RemoteController.this.onSetPlayItemResponse(z);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            RemoteController.this.onNewPlaybackState(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onUpdateFolderInfoBrowsedPlayer(String str) {
            Log.d(RemoteController.TAG, "MediaControllerCallback: onUpdateFolderInfoBrowsedPlayer");
            RemoteController.this.onFolderInfoBrowsedPlayer(str);
        }

        @Override // android.media.session.MediaController.Callback
        public void onUpdateNowPlayingContentChange() {
            Log.d(RemoteController.TAG, "MediaControllerCallback: onUpdateNowPlayingContentChange");
            RemoteController.this.onNowPlayingContentChange();
        }

        @Override // android.media.session.MediaController.Callback
        public void onUpdateNowPlayingEntries(long[] jArr) {
            Log.d(RemoteController.TAG, "MediaControllerCallback: onUpdateNowPlayingEntries");
            RemoteController.this.onNowPlayingEntriesUpdate(jArr);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteController$MetadataEditor.class */
    public class MetadataEditor extends MediaMetadataEditor {
        protected MetadataEditor() {
        }

        protected MetadataEditor(Bundle bundle, long j) {
            this.mEditorMetadata = bundle;
            this.mEditableKeys = j;
            this.mEditorArtwork = (Bitmap) bundle.getParcelable(String.valueOf(100));
            if (this.mEditorArtwork != null) {
                cleanupBitmapFromBundle(100);
            }
            this.mMetadataChanged = true;
            this.mArtworkChanged = true;
            this.mApplied = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanupBitmapFromBundle(int i) {
            if (METADATA_KEYS_TYPE.get(i, -1) == 2) {
                this.mEditorMetadata.remove(String.valueOf(i));
            }
        }

        @Override // android.media.MediaMetadataEditor
        public void apply() {
            Rating rating;
            synchronized (this) {
                if (this.mMetadataChanged) {
                    synchronized (RemoteController.mInfoLock) {
                        if (RemoteController.this.mCurrentSession != null && this.mEditorMetadata.containsKey(String.valueOf((int) MediaMetadataEditor.RATING_KEY_BY_USER)) && (rating = (Rating) getObject(MediaMetadataEditor.RATING_KEY_BY_USER, null)) != null) {
                            RemoteController.this.mCurrentSession.getTransportControls().setRating(rating);
                        }
                    }
                    this.mApplied = false;
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteController$OnClientUpdateListener.class */
    public interface OnClientUpdateListener {
        void onClientChange(boolean z);

        void onClientFolderInfoBrowsedPlayer(String str);

        void onClientMetadataUpdate(MetadataEditor metadataEditor);

        void onClientNowPlayingContentChange();

        void onClientPlayItemResponse(boolean z);

        void onClientPlaybackStateUpdate(int i);

        void onClientPlaybackStateUpdate(int i, long j, long j2, float f);

        void onClientTransportControlUpdate(int i);

        void onClientUpdateNowPlayingEntries(long[] jArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteController$PlaybackInfo.class */
    public static class PlaybackInfo {
        long mCurrentPosMs;
        float mSpeed;
        int mState;
        long mStateChangeTimeMs;

        PlaybackInfo(int i, long j, long j2, float f) {
            this.mState = i;
            this.mStateChangeTimeMs = j;
            this.mCurrentPosMs = j2;
            this.mSpeed = f;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteController$RcDisplay.class */
    private static class RcDisplay extends IRemoteControlDisplay.Stub {
        private final WeakReference<RemoteController> mController;

        RcDisplay(RemoteController remoteController) {
            this.mController = new WeakReference<>(remoteController);
        }

        @Override // android.media.IRemoteControlDisplay
        public void setAllMetadata(int i, Bundle bundle, Bitmap bitmap) {
            RemoteController remoteController = this.mController.get();
            if (remoteController == null) {
                return;
            }
            if (bundle == null && bitmap == null) {
                return;
            }
            synchronized (RemoteController.mGenLock) {
                if (remoteController.mClientGenerationIdCurrent != i) {
                    return;
                }
                Bundle bundle2 = bundle;
                if (bundle == null) {
                    bundle2 = new Bundle(1);
                }
                if (bitmap != null) {
                    bundle2.putParcelable(String.valueOf(100), bitmap);
                }
                RemoteController.sendMsg(remoteController.mEventHandler, 3, 2, i, 0, bundle2, 0);
            }
        }

        @Override // android.media.IRemoteControlDisplay
        public void setArtwork(int i, Bitmap bitmap) {
            RemoteController remoteController = this.mController.get();
            if (remoteController == null) {
                return;
            }
            synchronized (RemoteController.mGenLock) {
                if (remoteController.mClientGenerationIdCurrent != i) {
                    return;
                }
                Bundle bundle = new Bundle(1);
                bundle.putParcelable(String.valueOf(100), bitmap);
                RemoteController.sendMsg(remoteController.mEventHandler, 3, 2, i, 0, bundle, 0);
            }
        }

        @Override // android.media.IRemoteControlDisplay
        public void setCurrentClientId(int i, PendingIntent pendingIntent, boolean z) {
            RemoteController remoteController = this.mController.get();
            if (remoteController == null) {
                return;
            }
            boolean z2 = false;
            synchronized (RemoteController.mGenLock) {
                if (remoteController.mClientGenerationIdCurrent != i) {
                    remoteController.mClientGenerationIdCurrent = i;
                    z2 = true;
                }
            }
            if (pendingIntent != null) {
                RemoteController.sendMsg(remoteController.mEventHandler, 0, 0, i, 0, pendingIntent, 0);
            }
            if (z2 || z) {
                RemoteController.sendMsg(remoteController.mEventHandler, 4, 0, i, z ? 1 : 0, null, 0);
            }
        }

        @Override // android.media.IRemoteControlDisplay
        public void setEnabled(boolean z) {
            RemoteController remoteController = this.mController.get();
            if (remoteController == null) {
                return;
            }
            RemoteController.sendMsg(remoteController.mEventHandler, 5, 0, z ? 1 : 0, 0, null, 0);
        }

        @Override // android.media.IRemoteControlDisplay
        public void setMetadata(int i, Bundle bundle) {
            RemoteController remoteController = this.mController.get();
            if (remoteController == null || bundle == null) {
                return;
            }
            synchronized (RemoteController.mGenLock) {
                if (remoteController.mClientGenerationIdCurrent != i) {
                    return;
                }
                RemoteController.sendMsg(remoteController.mEventHandler, 3, 2, i, 0, bundle, 0);
            }
        }

        @Override // android.media.IRemoteControlDisplay
        public void setPlaybackState(int i, int i2, long j, long j2, float f) {
            RemoteController remoteController = this.mController.get();
            if (remoteController == null) {
                return;
            }
            synchronized (RemoteController.mGenLock) {
                if (remoteController.mClientGenerationIdCurrent != i) {
                    return;
                }
                RemoteController.sendMsg(remoteController.mEventHandler, 1, 0, i, 0, new PlaybackInfo(i2, j, j2, f), 0);
            }
        }

        @Override // android.media.IRemoteControlDisplay
        public void setTransportControlInfo(int i, int i2, int i3) {
            RemoteController remoteController = this.mController.get();
            if (remoteController == null) {
                return;
            }
            synchronized (RemoteController.mGenLock) {
                if (remoteController.mClientGenerationIdCurrent != i) {
                    return;
                }
                RemoteController.sendMsg(remoteController.mEventHandler, 2, 0, i, i2, null, 0);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteController$TopTransportSessionListener.class */
    private class TopTransportSessionListener implements MediaSessionManager.OnActiveSessionsChangedListener {
        private TopTransportSessionListener() {
        }

        @Override // android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
        public void onActiveSessionsChanged(List<MediaController> list) {
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    RemoteController.this.updateController(null);
                    return;
                }
                MediaController mediaController = list.get(i2);
                if ((2 & mediaController.getFlags()) != 0) {
                    RemoteController.this.updateController(mediaController);
                    return;
                }
                i = i2 + 1;
            }
        }
    }

    public RemoteController(Context context, OnClientUpdateListener onClientUpdateListener) throws IllegalArgumentException {
        this(context, onClientUpdateListener, null);
    }

    public RemoteController(Context context, OnClientUpdateListener onClientUpdateListener, Looper looper) throws IllegalArgumentException {
        this.mSessionCb = new MediaControllerCallback();
        this.mClientGenerationIdCurrent = 0;
        this.mIsRegistered = false;
        this.mArtworkWidth = -1;
        this.mArtworkHeight = -1;
        this.mEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("Invalid null Context");
        }
        if (onClientUpdateListener == null) {
            throw new IllegalArgumentException("Invalid null OnClientUpdateListener");
        }
        if (looper != null) {
            this.mEventHandler = new EventHandler(this, looper);
        } else {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                throw new IllegalArgumentException("Calling thread not associated with a looper");
            }
            this.mEventHandler = new EventHandler(this, myLooper);
        }
        this.mOnClientUpdateListener = onClientUpdateListener;
        this.mContext = context;
        this.mRcd = new RcDisplay(this);
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mSessionManager = (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
        this.mSessionListener = new TopTransportSessionListener();
        if (ActivityManager.isLowRamDeviceStatic()) {
            this.mMaxBitmapDimension = 512;
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mMaxBitmapDimension = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClientChange(int i, boolean z) {
        OnClientUpdateListener onClientUpdateListener;
        synchronized (mGenLock) {
            if (this.mClientGenerationIdCurrent != i) {
                return;
            }
            synchronized (mInfoLock) {
                onClientUpdateListener = this.mOnClientUpdateListener;
                this.mMetadataEditor = null;
            }
            if (onClientUpdateListener != null) {
                onClientUpdateListener.onClientChange(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDisplayEnable(boolean z) {
        int i;
        synchronized (mInfoLock) {
            this.mEnabled = z;
            OnClientUpdateListener onClientUpdateListener = this.mOnClientUpdateListener;
        }
        if (z) {
            return;
        }
        synchronized (mGenLock) {
            i = this.mClientGenerationIdCurrent;
        }
        sendMsg(this.mEventHandler, 1, 0, i, 0, new PlaybackInfo(1, SystemClock.elapsedRealtime(), 0L, 0.0f), 0);
        sendMsg(this.mEventHandler, 2, 0, i, 0, null, 0);
        Bundle bundle = new Bundle(3);
        bundle.putString(String.valueOf(7), "");
        bundle.putString(String.valueOf(2), "");
        bundle.putLong(String.valueOf(9), 0L);
        sendMsg(this.mEventHandler, 3, 2, i, 0, bundle, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewMediaMetadata(MediaMetadata mediaMetadata) {
        OnClientUpdateListener onClientUpdateListener;
        MetadataEditor metadataEditor;
        if (mediaMetadata == null) {
            return;
        }
        synchronized (mInfoLock) {
            onClientUpdateListener = this.mOnClientUpdateListener;
            this.mMetadataEditor = new MetadataEditor(MediaSessionLegacyHelper.getOldMetadata(mediaMetadata, this.mArtworkWidth, this.mArtworkHeight), this.mCurrentSession != null && this.mCurrentSession.getRatingType() != 0 ? 268435457L : 0L);
            metadataEditor = this.mMetadataEditor;
        }
        if (onClientUpdateListener != null) {
            onClientUpdateListener.onClientMetadataUpdate(metadataEditor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewMetadata(int i, Bundle bundle) {
        OnClientUpdateListener onClientUpdateListener;
        MetadataEditor metadataEditor;
        synchronized (mGenLock) {
            if (this.mClientGenerationIdCurrent != i) {
                return;
            }
            long j = bundle.getLong(String.valueOf((int) MediaMetadataEditor.KEY_EDITABLE_MASK), 0L);
            if (j != 0) {
                bundle.remove(String.valueOf((int) MediaMetadataEditor.KEY_EDITABLE_MASK));
            }
            synchronized (mInfoLock) {
                onClientUpdateListener = this.mOnClientUpdateListener;
                if (this.mMetadataEditor == null || this.mMetadataEditor.mEditorMetadata == null) {
                    this.mMetadataEditor = new MetadataEditor(bundle, j);
                } else {
                    if (this.mMetadataEditor.mEditorMetadata != bundle) {
                        this.mMetadataEditor.mEditorMetadata.putAll(bundle);
                    }
                    this.mMetadataEditor.putBitmap(100, (Bitmap) bundle.getParcelable(String.valueOf(100)));
                    this.mMetadataEditor.cleanupBitmapFromBundle(100);
                }
                metadataEditor = this.mMetadataEditor;
            }
            if (onClientUpdateListener != null) {
                onClientUpdateListener.onClientMetadataUpdate(metadataEditor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewPendingIntent(int i, PendingIntent pendingIntent) {
        synchronized (mGenLock) {
            if (this.mClientGenerationIdCurrent != i) {
                return;
            }
            synchronized (mInfoLock) {
                this.mClientPendingIntentCurrent = pendingIntent;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewPlaybackInfo(int i, PlaybackInfo playbackInfo) {
        OnClientUpdateListener onClientUpdateListener;
        synchronized (mGenLock) {
            if (this.mClientGenerationIdCurrent != i) {
                return;
            }
            synchronized (mInfoLock) {
                onClientUpdateListener = this.mOnClientUpdateListener;
                this.mLastPlaybackInfo = playbackInfo;
            }
            if (onClientUpdateListener != null) {
                if (playbackInfo.mCurrentPosMs == RemoteControlClient.PLAYBACK_POSITION_ALWAYS_UNKNOWN) {
                    onClientUpdateListener.onClientPlaybackStateUpdate(playbackInfo.mState);
                } else {
                    onClientUpdateListener.onClientPlaybackStateUpdate(playbackInfo.mState, playbackInfo.mStateChangeTimeMs, playbackInfo.mCurrentPosMs, playbackInfo.mSpeed);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewPlaybackState(PlaybackState playbackState) {
        OnClientUpdateListener onClientUpdateListener;
        synchronized (mInfoLock) {
            onClientUpdateListener = this.mOnClientUpdateListener;
        }
        if (onClientUpdateListener != null) {
            int rccStateFromState = playbackState == null ? 0 : PlaybackState.getRccStateFromState(playbackState.getState());
            if (playbackState == null || playbackState.getPosition() == -1) {
                onClientUpdateListener.onClientPlaybackStateUpdate(rccStateFromState);
            } else {
                onClientUpdateListener.onClientPlaybackStateUpdate(rccStateFromState, playbackState.getLastPositionUpdateTime(), playbackState.getPosition(), playbackState.getPlaybackSpeed());
            }
            if (playbackState != null) {
                onClientUpdateListener.onClientTransportControlUpdate(PlaybackState.getRccControlFlagsFromActions(playbackState.getActions()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewTransportInfo(int i, int i2) {
        OnClientUpdateListener onClientUpdateListener;
        synchronized (mGenLock) {
            if (this.mClientGenerationIdCurrent != i) {
                return;
            }
            synchronized (mInfoLock) {
                onClientUpdateListener = this.mOnClientUpdateListener;
            }
            if (onClientUpdateListener != null) {
                onClientUpdateListener.onClientTransportControlUpdate(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendMsg(Handler handler, int i, int i2, int i3, int i4, Object obj, int i5) {
        if (handler == null) {
            Log.e(TAG, "null event handler, will not deliver message " + i);
            return;
        }
        if (i2 == 0) {
            handler.removeMessages(i);
        } else if (i2 == 1 && handler.hasMessages(i)) {
            return;
        }
        handler.sendMessageDelayed(handler.obtainMessage(i, i3, i4, obj), i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateController(MediaController mediaController) {
        synchronized (mInfoLock) {
            if (mediaController == null) {
                if (this.mCurrentSession != null) {
                    Log.v(TAG, "Updating current controller as null");
                    this.mAudioManager.updateMediaPlayerList(this.mCurrentSession.getPackageName(), false);
                    this.mCurrentSession.unregisterCallback(this.mSessionCb);
                    this.mCurrentSession = null;
                    sendMsg(this.mEventHandler, 4, 0, 0, 1, null, 0);
                }
            } else if (this.mCurrentSession == null || !mediaController.getSessionToken().equals(this.mCurrentSession.getSessionToken())) {
                if (this.mCurrentSession != null) {
                    Log.v(TAG, "Updating current controller package as " + mediaController.getPackageName() + " from " + this.mCurrentSession.getPackageName());
                    this.mCurrentSession.unregisterCallback(this.mSessionCb);
                } else {
                    Log.v(TAG, "Updating current controller package as " + mediaController.getPackageName() + " from null");
                }
                sendMsg(this.mEventHandler, 4, 0, 0, 0, null, 0);
                this.mCurrentSession = mediaController;
                this.mCurrentSession.registerCallback(this.mSessionCb, this.mEventHandler);
                this.mAudioManager.updateMediaPlayerList(this.mCurrentSession.getPackageName(), true);
                sendMsg(this.mEventHandler, 6, 0, 0, 0, mediaController.getPlaybackState(), 0);
                sendMsg(this.mEventHandler, 7, 0, 0, 0, mediaController.getMetadata(), 0);
            }
        }
    }

    public boolean clearArtworkConfiguration() {
        return setArtworkConfiguration(false, -1, -1);
    }

    public MetadataEditor editMetadata() {
        MetadataEditor metadataEditor = new MetadataEditor();
        metadataEditor.mEditorMetadata = new Bundle();
        metadataEditor.mEditorArtwork = null;
        metadataEditor.mMetadataChanged = true;
        metadataEditor.mArtworkChanged = true;
        metadataEditor.mEditableKeys = 0L;
        return metadataEditor;
    }

    int[] getArtworkSize() {
        int i;
        int i2;
        synchronized (mInfoLock) {
            i = this.mArtworkWidth;
            i2 = this.mArtworkHeight;
        }
        return new int[]{i, i2};
    }

    public long getEstimatedMediaPosition() {
        PlaybackState playbackState;
        synchronized (mInfoLock) {
            if (this.mCurrentSession == null || (playbackState = this.mCurrentSession.getPlaybackState()) == null) {
                return -1L;
            }
            return playbackState.getPosition();
        }
    }

    RcDisplay getRcDisplay() {
        return this.mRcd;
    }

    public void getRemoteControlClientNowPlayingEntries() {
        Log.e(TAG, "getRemoteControlClientNowPlayingEntries()");
        if (!this.mEnabled) {
            Log.e(TAG, "Cannot use getRemoteControlClientNowPlayingEntries() from a disabled RemoteController");
            return;
        }
        synchronized (mInfoLock) {
            if (this.mCurrentSession != null) {
                this.mCurrentSession.getTransportControls().getRemoteControlClientNowPlayingEntries();
            }
        }
    }

    public String getRemoteControlClientPackageName() {
        String packageName;
        synchronized (mInfoLock) {
            packageName = this.mCurrentSession != null ? this.mCurrentSession.getPackageName() : null;
        }
        return packageName;
    }

    OnClientUpdateListener getUpdateListener() {
        return this.mOnClientUpdateListener;
    }

    public void onFolderInfoBrowsedPlayer(String str) {
        OnClientUpdateListener onClientUpdateListener;
        Log.d(TAG, "RemoteController: onFolderInfoBrowsedPlayer");
        synchronized (mInfoLock) {
            onClientUpdateListener = this.mOnClientUpdateListener;
        }
        if (onClientUpdateListener != null) {
            onClientUpdateListener.onClientFolderInfoBrowsedPlayer(str);
        }
    }

    public void onNowPlayingContentChange() {
        OnClientUpdateListener onClientUpdateListener;
        Log.d(TAG, "RemoteController: onNowPlayingContentChange");
        synchronized (mInfoLock) {
            onClientUpdateListener = this.mOnClientUpdateListener;
        }
        if (onClientUpdateListener != null) {
            onClientUpdateListener.onClientNowPlayingContentChange();
        }
    }

    public void onNowPlayingEntriesUpdate(long[] jArr) {
        OnClientUpdateListener onClientUpdateListener;
        Log.d(TAG, "RemoteController: onUpdateNowPlayingEntries");
        synchronized (mInfoLock) {
            onClientUpdateListener = this.mOnClientUpdateListener;
        }
        if (onClientUpdateListener != null) {
            onClientUpdateListener.onClientUpdateNowPlayingEntries(jArr);
        }
    }

    public void onSetPlayItemResponse(boolean z) {
        OnClientUpdateListener onClientUpdateListener;
        Log.d(TAG, "RemoteController: onPlayItemResponse");
        synchronized (mInfoLock) {
            onClientUpdateListener = this.mOnClientUpdateListener;
        }
        if (onClientUpdateListener != null) {
            onClientUpdateListener.onClientPlayItemResponse(z);
        }
    }

    public boolean seekTo(long j) throws IllegalArgumentException {
        Log.e(TAG, "seekTo() in RemoteController");
        if (!this.mEnabled) {
            Log.e(TAG, "Cannot use seekTo() from a disabled RemoteController");
            return false;
        } else if (j < 0) {
            throw new IllegalArgumentException("illegal negative time value");
        } else {
            synchronized (mInfoLock) {
                if (this.mCurrentSession != null) {
                    this.mCurrentSession.getTransportControls().seekTo(j);
                }
            }
            return true;
        }
    }

    public boolean sendMediaKeyEvent(KeyEvent keyEvent) throws IllegalArgumentException {
        if (KeyEvent.isMediaKey(keyEvent.getKeyCode())) {
            synchronized (mInfoLock) {
                if (this.mCurrentSession != null) {
                    return this.mCurrentSession.dispatchMediaButtonEvent(keyEvent);
                }
                return false;
            }
        }
        throw new IllegalArgumentException("not a media key event");
    }

    public boolean setArtworkConfiguration(int i, int i2) throws IllegalArgumentException {
        return setArtworkConfiguration(true, i, i2);
    }

    public boolean setArtworkConfiguration(boolean z, int i, int i2) throws IllegalArgumentException {
        synchronized (mInfoLock) {
            if (!z) {
                this.mArtworkWidth = -1;
                this.mArtworkHeight = -1;
            } else if (i <= 0 || i2 <= 0) {
                throw new IllegalArgumentException("Invalid dimensions");
            } else {
                int i3 = i;
                if (i > this.mMaxBitmapDimension) {
                    i3 = this.mMaxBitmapDimension;
                }
                int i4 = i2;
                if (i2 > this.mMaxBitmapDimension) {
                    i4 = this.mMaxBitmapDimension;
                }
                this.mArtworkWidth = i3;
                this.mArtworkHeight = i4;
            }
        }
        return true;
    }

    void setIsRegistered(boolean z) {
        synchronized (mInfoLock) {
            this.mIsRegistered = z;
        }
    }

    public void setRemoteControlClientBrowsedPlayer() {
        Log.e(TAG, "setRemoteControlClientBrowsedPlayer()");
        if (!this.mEnabled) {
            Log.e(TAG, "Cannot use setRemoteControlClientBrowsedPlayer() from a disabled RemoteController");
            return;
        }
        synchronized (mInfoLock) {
            if (this.mCurrentSession != null) {
                this.mCurrentSession.getTransportControls().setRemoteControlClientBrowsedPlayer();
            }
        }
    }

    public void setRemoteControlClientPlayItem(long j, int i) {
        Log.e(TAG, "setRemoteControlClientPlayItem()");
        if (!this.mEnabled) {
            Log.e(TAG, "Cannot use setRemoteControlClientPlayItem() from a disabled RemoteController");
            return;
        }
        synchronized (mInfoLock) {
            if (this.mCurrentSession != null) {
                this.mCurrentSession.getTransportControls().setRemoteControlClientPlayItem(j, i);
            }
        }
    }

    public boolean setSynchronizationMode(int i) throws IllegalArgumentException {
        boolean z = false;
        if (i == 0 || i == 1) {
            if (!this.mIsRegistered) {
                Log.e(TAG, "Cannot set synchronization mode on an unregistered RemoteController");
                return false;
            }
            AudioManager audioManager = this.mAudioManager;
            RcDisplay rcDisplay = this.mRcd;
            if (1 == i) {
                z = true;
            }
            audioManager.remoteControlDisplayWantsPlaybackPositionSync(rcDisplay, z);
            return true;
        }
        throw new IllegalArgumentException("Unknown synchronization mode " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startListeningToSessions() {
        ComponentName componentName = new ComponentName(this.mContext, this.mOnClientUpdateListener.getClass());
        Handler handler = null;
        if (Looper.myLooper() == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        this.mSessionManager.addOnActiveSessionsChangedListener(this.mSessionListener, componentName, UserHandle.myUserId(), handler);
        this.mSessionListener.onActiveSessionsChanged(this.mSessionManager.getActiveSessions(componentName));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopListeningToSessions() {
        this.mSessionManager.removeOnActiveSessionsChangedListener(this.mSessionListener);
    }
}
