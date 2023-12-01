package android.media;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.session.MediaSession;
import android.media.session.MediaSessionLegacyHelper;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/media/RemoteControlClient.class */
public class RemoteControlClient {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_PLAYBACK_VOLUME = 15;
    public static final int DEFAULT_PLAYBACK_VOLUME_HANDLING = 1;
    public static final int FLAGS_KEY_MEDIA_NONE = 0;
    public static final int FLAG_INFORMATION_REQUEST_ALBUM_ART = 8;
    public static final int FLAG_INFORMATION_REQUEST_KEY_MEDIA = 2;
    public static final int FLAG_INFORMATION_REQUEST_METADATA = 1;
    public static final int FLAG_INFORMATION_REQUEST_PLAYSTATE = 4;
    public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    public static final int FLAG_KEY_MEDIA_NEXT = 128;
    public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    public static final int FLAG_KEY_MEDIA_PLAY = 4;
    public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    public static final int FLAG_KEY_MEDIA_POSITION_UPDATE = 256;
    public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    public static final int FLAG_KEY_MEDIA_RATING = 512;
    public static final int FLAG_KEY_MEDIA_REWIND = 2;
    public static final int FLAG_KEY_MEDIA_STOP = 32;
    public static int MEDIA_POSITION_READABLE = 1;
    public static int MEDIA_POSITION_WRITABLE = 2;
    private static final int MSG_GET_NOW_PLAYING_ENTRIES = 14;
    private static final int MSG_POSITION_DRIFT_CHECK = 11;
    private static final int MSG_SET_BROWSED_PLAYER = 12;
    private static final int MSG_SET_PLAY_ITEM = 13;
    public static final int PLAYBACKINFO_INVALID_VALUE = Integer.MIN_VALUE;
    public static final int PLAYBACKINFO_PLAYBACK_TYPE = 1;
    public static final int PLAYBACKINFO_USES_STREAM = 5;
    public static final int PLAYBACKINFO_VOLUME = 2;
    public static final int PLAYBACKINFO_VOLUME_HANDLING = 4;
    public static final int PLAYBACKINFO_VOLUME_MAX = 3;
    public static final long PLAYBACK_POSITION_ALWAYS_UNKNOWN = -9216204211029966080L;
    public static final long PLAYBACK_POSITION_INVALID = -1;
    public static final float PLAYBACK_SPEED_1X = 1.0f;
    public static final int PLAYBACK_TYPE_LOCAL = 0;
    private static final int PLAYBACK_TYPE_MAX = 1;
    private static final int PLAYBACK_TYPE_MIN = 0;
    public static final int PLAYBACK_TYPE_REMOTE = 1;
    public static final int PLAYBACK_VOLUME_FIXED = 0;
    public static final int PLAYBACK_VOLUME_VARIABLE = 1;
    public static final int PLAYSTATE_BUFFERING = 8;
    public static final int PLAYSTATE_ERROR = 9;
    public static final int PLAYSTATE_FAST_FORWARDING = 4;
    public static final int PLAYSTATE_NONE = 0;
    public static final int PLAYSTATE_PAUSED = 2;
    public static final int PLAYSTATE_PLAYING = 3;
    public static final int PLAYSTATE_REWINDING = 5;
    public static final int PLAYSTATE_SKIPPING_BACKWARDS = 7;
    public static final int PLAYSTATE_SKIPPING_FORWARDS = 6;
    public static final int PLAYSTATE_STOPPED = 1;
    private static final long POSITION_DRIFT_MAX_MS = 500;
    private static final long POSITION_REFRESH_PERIOD_MIN_MS = 2000;
    private static final long POSITION_REFRESH_PERIOD_PLAYING_MS = 15000;
    public static final int RCSE_ID_UNREGISTERED = -1;
    private static final String TAG = "RemoteControlClient";
    private EventHandler mEventHandler;
    private OnGetNowPlayingEntriesListener mGetNowPlayingEntriesListener;
    private MediaMetadata mMediaMetadata;
    private OnMetadataUpdateListener mMetadataUpdateListener;
    private Bitmap mOriginalArtwork;
    private OnGetPlaybackPositionListener mPositionProvider;
    private OnPlaybackPositionUpdateListener mPositionUpdateListener;
    private final PendingIntent mRcMediaIntent;
    private MediaSession mSession;
    private OnSetBrowsedPlayerListener mSetBrowsedPlayerListener;
    private OnSetPlayItemListener mSetPlayItemListener;
    private final Object mCacheLock = new Object();
    private int mPlaybackState = 0;
    private long mPlaybackStateChangeTimeMs = 0;
    private long mPlaybackPositionMs = -1;
    private float mPlaybackSpeed = 1.0f;
    private int mTransportControlFlags = 0;
    private Bundle mMetadata = new Bundle();
    private int mCurrentClientGenId = -1;
    private boolean mNeedsPositionSync = false;
    private PlaybackState mSessionPlaybackState = null;
    private MediaSession.Callback mTransportListener = new MediaSession.Callback() { // from class: android.media.RemoteControlClient.1
        @Override // android.media.session.MediaSession.Callback
        public void getNowPlayingEntries() {
            if (RemoteControlClient.this.mEventHandler != null) {
                RemoteControlClient.this.mEventHandler.removeMessages(14);
                RemoteControlClient.this.mEventHandler.sendMessage(RemoteControlClient.this.mEventHandler.obtainMessage(14, 0, 0, null));
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j) {
            RemoteControlClient.this.onSeekTo(RemoteControlClient.this.mCurrentClientGenId, j);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating rating) {
            if ((RemoteControlClient.this.mTransportControlFlags & 512) != 0) {
                RemoteControlClient.this.onUpdateMetadata(RemoteControlClient.this.mCurrentClientGenId, MediaMetadataEditor.RATING_KEY_BY_USER, rating);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void setBrowsedPlayer() {
            Log.d(RemoteControlClient.TAG, "setBrowsedPlayer in RemoteControlClient");
            if (RemoteControlClient.this.mEventHandler != null) {
                RemoteControlClient.this.mEventHandler.sendMessage(RemoteControlClient.this.mEventHandler.obtainMessage(12, 0, 0, null));
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void setPlayItem(int i, long j) {
            if (RemoteControlClient.this.mEventHandler != null) {
                RemoteControlClient.this.mEventHandler.removeMessages(13);
                RemoteControlClient.this.mEventHandler.sendMessage(RemoteControlClient.this.mEventHandler.obtainMessage(13, 0, i, new Long(j)));
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteControlClient$EventHandler.class */
    public class EventHandler extends Handler {
        public EventHandler(RemoteControlClient remoteControlClient, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 11:
                    RemoteControlClient.this.onPositionDriftCheck();
                    return;
                case 12:
                    Log.d(RemoteControlClient.TAG, "MSG_SET_BROWSED_PLAYER in RemoteControlClient");
                    RemoteControlClient.this.onSetBrowsedPlayer();
                    return;
                case 13:
                    RemoteControlClient.this.onSetPlayItem(message.arg2, ((Long) message.obj).longValue());
                    return;
                case 14:
                    RemoteControlClient.this.onGetNowPlayingEntries();
                    return;
                default:
                    Log.e(RemoteControlClient.TAG, "Unknown event " + message.what + " in RemoteControlClient handler");
                    return;
            }
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteControlClient$MetadataEditor.class */
    public class MetadataEditor extends MediaMetadataEditor {
        public static final int BITMAP_KEY_ARTWORK = 100;
        public static final int METADATA_KEY_ARTWORK = 100;

        private MetadataEditor() {
        }

        @Override // android.media.MediaMetadataEditor
        public void apply() {
            synchronized (this) {
                if (this.mApplied) {
                    Log.e(RemoteControlClient.TAG, "Can't apply a previously applied MetadataEditor");
                } else {
                    synchronized (RemoteControlClient.this.mCacheLock) {
                        RemoteControlClient.this.mMetadata = new Bundle(this.mEditorMetadata);
                        RemoteControlClient.this.mMetadata.putLong(String.valueOf((int) MediaMetadataEditor.KEY_EDITABLE_MASK), this.mEditableKeys);
                        if (RemoteControlClient.this.mOriginalArtwork != null && !RemoteControlClient.this.mOriginalArtwork.equals(this.mEditorArtwork)) {
                            RemoteControlClient.this.mOriginalArtwork.recycle();
                        }
                        RemoteControlClient.this.mOriginalArtwork = this.mEditorArtwork;
                        this.mEditorArtwork = null;
                        if (RemoteControlClient.this.mSession != null && this.mMetadataBuilder != null) {
                            RemoteControlClient.this.mMediaMetadata = this.mMetadataBuilder.build();
                            RemoteControlClient.this.mSession.setMetadata(RemoteControlClient.this.mMediaMetadata);
                        }
                        this.mApplied = true;
                    }
                }
            }
        }

        @Override // android.media.MediaMetadataEditor
        public void clear() {
            synchronized (this) {
                super.clear();
            }
        }

        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        @Override // android.media.MediaMetadataEditor
        public MetadataEditor putBitmap(int i, Bitmap bitmap) throws IllegalArgumentException {
            String keyFromMetadataEditorKey;
            synchronized (this) {
                super.putBitmap(i, bitmap);
                if (this.mMetadataBuilder != null && (keyFromMetadataEditorKey = MediaMetadata.getKeyFromMetadataEditorKey(i)) != null) {
                    this.mMetadataBuilder.putBitmap(keyFromMetadataEditorKey, bitmap);
                }
            }
            return this;
        }

        @Override // android.media.MediaMetadataEditor
        public MetadataEditor putLong(int i, long j) throws IllegalArgumentException {
            String keyFromMetadataEditorKey;
            synchronized (this) {
                super.putLong(i, j);
                if (this.mMetadataBuilder != null && (keyFromMetadataEditorKey = MediaMetadata.getKeyFromMetadataEditorKey(i)) != null) {
                    this.mMetadataBuilder.putLong(keyFromMetadataEditorKey, j);
                }
            }
            return this;
        }

        @Override // android.media.MediaMetadataEditor
        public MetadataEditor putObject(int i, Object obj) throws IllegalArgumentException {
            String keyFromMetadataEditorKey;
            synchronized (this) {
                super.putObject(i, obj);
                if (this.mMetadataBuilder != null && ((i == 268435457 || i == 101) && (keyFromMetadataEditorKey = MediaMetadata.getKeyFromMetadataEditorKey(i)) != null)) {
                    this.mMetadataBuilder.putRating(keyFromMetadataEditorKey, (Rating) obj);
                }
            }
            return this;
        }

        @Override // android.media.MediaMetadataEditor
        public MetadataEditor putString(int i, String str) throws IllegalArgumentException {
            String keyFromMetadataEditorKey;
            synchronized (this) {
                super.putString(i, str);
                if (this.mMetadataBuilder != null && (keyFromMetadataEditorKey = MediaMetadata.getKeyFromMetadataEditorKey(i)) != null) {
                    this.mMetadataBuilder.putText(keyFromMetadataEditorKey, str);
                }
            }
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteControlClient$OnGetNowPlayingEntriesListener.class */
    public interface OnGetNowPlayingEntriesListener {
        void onGetNowPlayingEntries();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteControlClient$OnGetPlaybackPositionListener.class */
    public interface OnGetPlaybackPositionListener {
        long onGetPlaybackPosition();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteControlClient$OnMetadataUpdateListener.class */
    public interface OnMetadataUpdateListener {
        void onMetadataUpdate(int i, Object obj);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteControlClient$OnPlaybackPositionUpdateListener.class */
    public interface OnPlaybackPositionUpdateListener {
        void onPlaybackPositionUpdate(long j);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteControlClient$OnSetBrowsedPlayerListener.class */
    public interface OnSetBrowsedPlayerListener {
        void onSetBrowsedPlayer();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteControlClient$OnSetPlayItemListener.class */
    public interface OnSetPlayItemListener {
        void onSetPlayItem(int i, long j);
    }

    public RemoteControlClient(PendingIntent pendingIntent) {
        this.mRcMediaIntent = pendingIntent;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.mEventHandler = new EventHandler(this, mainLooper);
            return;
        }
        this.mEventHandler = null;
        Log.e(TAG, "RemoteControlClient() couldn't find main application thread");
    }

    public RemoteControlClient(PendingIntent pendingIntent, Looper looper) {
        this.mRcMediaIntent = pendingIntent;
        this.mEventHandler = new EventHandler(this, looper);
    }

    private static long getCheckPeriodFromSpeed(float f) {
        return Math.abs(f) <= 1.0f ? POSITION_REFRESH_PERIOD_PLAYING_MS : Math.max(15000.0f / Math.abs(f), 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetNowPlayingEntries() {
        Log.d(TAG, "onGetNowPlayingEntries");
        synchronized (this.mCacheLock) {
            if (this.mGetNowPlayingEntriesListener != null) {
                Log.d(TAG, "mGetNowPlayingEntriesListener.onGetNowPlayingEntries");
                this.mGetNowPlayingEntriesListener.onGetNowPlayingEntries();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPositionDriftCheck() {
        synchronized (this.mCacheLock) {
            if (this.mEventHandler == null || this.mPositionProvider == null || !this.mNeedsPositionSync) {
                return;
            }
            if (this.mPlaybackPositionMs < 0 || this.mPlaybackSpeed == 0.0f) {
                return;
            }
            long j = this.mPlaybackPositionMs;
            long elapsedRealtime = ((float) (SystemClock.elapsedRealtime() - this.mPlaybackStateChangeTimeMs)) / this.mPlaybackSpeed;
            long onGetPlaybackPosition = this.mPositionProvider.onGetPlaybackPosition();
            if (onGetPlaybackPosition < 0) {
                this.mEventHandler.removeMessages(11);
            } else if (Math.abs((j + elapsedRealtime) - onGetPlaybackPosition) > 500) {
                setPlaybackState(this.mPlaybackState, onGetPlaybackPosition, this.mPlaybackSpeed);
            } else {
                this.mEventHandler.sendMessageDelayed(this.mEventHandler.obtainMessage(11), getCheckPeriodFromSpeed(this.mPlaybackSpeed));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSeekTo(int i, long j) {
        synchronized (this.mCacheLock) {
            if (this.mCurrentClientGenId == i && this.mPositionUpdateListener != null) {
                this.mPositionUpdateListener.onPlaybackPositionUpdate(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetBrowsedPlayer() {
        Log.d(TAG, "onSetBrowsedPlayer");
        synchronized (this.mCacheLock) {
            if (this.mSetBrowsedPlayerListener != null) {
                Log.d(TAG, "mSetBrowsedPlayerListener.onSetBrowsedPlayer");
                this.mSetBrowsedPlayerListener.onSetBrowsedPlayer();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetPlayItem(int i, long j) {
        Log.d(TAG, "onSetPlayItem");
        synchronized (this.mCacheLock) {
            if (this.mSetPlayItemListener != null) {
                Log.d(TAG, "mSetPlayItemListener.onSetPlayItem");
                this.mSetPlayItemListener.onSetPlayItem(i, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateMetadata(int i, int i2, Object obj) {
        synchronized (this.mCacheLock) {
            if (this.mCurrentClientGenId == i && this.mMetadataUpdateListener != null) {
                this.mMetadataUpdateListener.onMetadataUpdate(i2, obj);
            }
        }
    }

    private void playItemResponseInt(boolean z) {
        Log.d(TAG, "playItemResponseInt");
        Log.v(TAG, "success: " + z);
        if (this.mSession != null) {
            this.mSession.playItemResponse(z);
        }
    }

    static boolean playbackPositionShouldMove(int i) {
        switch (i) {
            case 1:
            case 2:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            case 3:
            case 4:
            case 5:
            default:
                return true;
        }
    }

    private void setPlaybackStateInt(int i, long j, float f, boolean z) {
        synchronized (this.mCacheLock) {
            if (this.mPlaybackState != i || this.mPlaybackPositionMs != j || this.mPlaybackSpeed != f) {
                this.mPlaybackState = i;
                if (!z) {
                    this.mPlaybackPositionMs = PLAYBACK_POSITION_ALWAYS_UNKNOWN;
                } else if (j < 0) {
                    this.mPlaybackPositionMs = -1L;
                } else {
                    this.mPlaybackPositionMs = j;
                }
                this.mPlaybackSpeed = f;
                this.mPlaybackStateChangeTimeMs = SystemClock.elapsedRealtime();
                if (this.mSession != null) {
                    int stateFromRccState = PlaybackState.getStateFromRccState(i);
                    long j2 = -1;
                    if (z) {
                        j2 = this.mPlaybackPositionMs;
                    }
                    PlaybackState.Builder builder = new PlaybackState.Builder(this.mSessionPlaybackState);
                    builder.setState(stateFromRccState, j2, f, SystemClock.elapsedRealtime());
                    builder.setErrorMessage(null);
                    this.mSessionPlaybackState = builder.build();
                    this.mSession.setPlaybackState(this.mSessionPlaybackState);
                }
            }
        }
    }

    private void updateFolderInfoBrowsedPlayerInt(String str) {
        Log.d(TAG, "updateFolderInfoBrowsedPlayerInt");
        if (this.mSession != null) {
            this.mSession.updateFolderInfoBrowsedPlayer(str);
        }
    }

    private void updateNowPlayingContentChangeInt() {
        Log.d(TAG, "updateNowPlayingContentChangeInt");
        if (this.mSession != null) {
            this.mSession.updateNowPlayingContentChange();
        }
    }

    private void updateNowPlayingEntriesInt(long[] jArr) {
        Log.d(TAG, "updateNowPlayingEntriesInt");
        if (this.mSession != null) {
            this.mSession.updateNowPlayingEntries(jArr);
        }
    }

    public MetadataEditor editMetadata(boolean z) {
        MetadataEditor metadataEditor = new MetadataEditor();
        if (z) {
            metadataEditor.mEditorMetadata = new Bundle();
            metadataEditor.mEditorArtwork = null;
            metadataEditor.mMetadataChanged = true;
            metadataEditor.mArtworkChanged = true;
            metadataEditor.mEditableKeys = 0L;
        } else {
            metadataEditor.mEditorMetadata = new Bundle(this.mMetadata);
            metadataEditor.mEditorArtwork = this.mOriginalArtwork;
            metadataEditor.mMetadataChanged = false;
            metadataEditor.mArtworkChanged = false;
        }
        if (z || this.mMediaMetadata == null) {
            metadataEditor.mMetadataBuilder = new MediaMetadata.Builder();
            return metadataEditor;
        }
        metadataEditor.mMetadataBuilder = new MediaMetadata.Builder(this.mMediaMetadata);
        return metadataEditor;
    }

    public MediaSession getMediaSession() {
        return this.mSession;
    }

    public PendingIntent getRcMediaIntent() {
        return this.mRcMediaIntent;
    }

    public void playItemResponse(boolean z) {
        Log.e(TAG, "playItemResponse");
        playItemResponseInt(z);
    }

    public void registerWithSession(MediaSessionLegacyHelper mediaSessionLegacyHelper) {
        mediaSessionLegacyHelper.addRccListener(this.mRcMediaIntent, this.mTransportListener);
        this.mSession = mediaSessionLegacyHelper.getSession(this.mRcMediaIntent);
        setTransportControlFlags(this.mTransportControlFlags);
    }

    public void setBrowsedPlayerUpdateListener(OnSetBrowsedPlayerListener onSetBrowsedPlayerListener) {
        Log.d(TAG, "setBrowsedPlayerUpdateListener");
        synchronized (this.mCacheLock) {
            this.mSetBrowsedPlayerListener = onSetBrowsedPlayerListener;
        }
    }

    public void setMetadataUpdateListener(OnMetadataUpdateListener onMetadataUpdateListener) {
        synchronized (this.mCacheLock) {
            this.mMetadataUpdateListener = onMetadataUpdateListener;
        }
    }

    public void setNowPlayingEntriesUpdateListener(OnGetNowPlayingEntriesListener onGetNowPlayingEntriesListener) {
        Log.d(TAG, "setNowPlayingEntriesUpdateListener");
        synchronized (this.mCacheLock) {
            this.mGetNowPlayingEntriesListener = onGetNowPlayingEntriesListener;
        }
    }

    public void setOnGetPlaybackPositionListener(OnGetPlaybackPositionListener onGetPlaybackPositionListener) {
        synchronized (this.mCacheLock) {
            this.mPositionProvider = onGetPlaybackPositionListener;
            if (this.mPositionProvider != null && this.mEventHandler != null && playbackPositionShouldMove(this.mPlaybackState)) {
                this.mEventHandler.sendMessageDelayed(this.mEventHandler.obtainMessage(11), 0L);
            }
        }
    }

    public void setPlayItemListener(OnSetPlayItemListener onSetPlayItemListener) {
        Log.d(TAG, "setPlayItemListener");
        synchronized (this.mCacheLock) {
            this.mSetPlayItemListener = onSetPlayItemListener;
        }
    }

    public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener) {
        synchronized (this.mCacheLock) {
            this.mPositionUpdateListener = onPlaybackPositionUpdateListener;
        }
    }

    public void setPlaybackState(int i) {
        setPlaybackStateInt(i, PLAYBACK_POSITION_ALWAYS_UNKNOWN, 1.0f, false);
    }

    public void setPlaybackState(int i, long j, float f) {
        setPlaybackStateInt(i, j, f, true);
    }

    public void setTransportControlFlags(int i) {
        synchronized (this.mCacheLock) {
            this.mTransportControlFlags = i;
            if (this.mSession != null) {
                PlaybackState.Builder builder = new PlaybackState.Builder(this.mSessionPlaybackState);
                builder.setActions(PlaybackState.getActionsFromRccControlFlags(i));
                this.mSessionPlaybackState = builder.build();
                this.mSession.setPlaybackState(this.mSessionPlaybackState);
            }
        }
    }

    public void unregisterWithSession(MediaSessionLegacyHelper mediaSessionLegacyHelper) {
        mediaSessionLegacyHelper.removeRccListener(this.mRcMediaIntent);
        this.mSession = null;
    }

    public void updateFolderInfoBrowsedPlayer(String str) {
        Log.e(TAG, "updateFolderInfoBrowsedPlayer");
        synchronized (this.mCacheLock) {
            updateFolderInfoBrowsedPlayerInt(str);
        }
    }

    public void updateNowPlayingContentChange() {
        Log.e(TAG, "updateNowPlayingContentChange");
        synchronized (this.mCacheLock) {
            updateNowPlayingContentChangeInt();
        }
    }

    public void updateNowPlayingEntries(long[] jArr) {
        Log.e(TAG, "updateNowPlayingEntries: Item numbers: " + jArr.length);
        updateNowPlayingEntriesInt(jArr);
    }
}
