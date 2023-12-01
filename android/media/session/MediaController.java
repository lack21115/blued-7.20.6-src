package android.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ParceledListSlice;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.ISessionControllerCallback;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaController.class */
public final class MediaController {
    private static final int MSG_DESTROYED = 12;
    private static final int MSG_EVENT = 1;
    private static final int MSG_FOLDER_INFO_BROWSED_PLAYER = 8;
    private static final int MSG_PLAY_ITEM_RESPONSE = 11;
    private static final int MSG_UPDATE_EXTRAS = 7;
    private static final int MSG_UPDATE_METADATA = 3;
    private static final int MSG_UPDATE_NOWPLAYING_CONTENT_CHANGE = 10;
    private static final int MSG_UPDATE_NOWPLAYING_ENTRIES = 9;
    private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
    private static final int MSG_UPDATE_QUEUE = 5;
    private static final int MSG_UPDATE_QUEUE_TITLE = 6;
    private static final int MSG_UPDATE_VOLUME = 4;
    private static final String TAG = "MediaController";
    private final ArrayList<MessageHandler> mCallbacks;
    private boolean mCbRegistered;
    private final CallbackStub mCbStub;
    private final Context mContext;
    private final Object mLock;
    private String mPackageName;
    private final ISessionController mSessionBinder;
    private String mTag;
    private final MediaSession.Token mToken;
    private final TransportControls mTransportControls;

    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaController$Callback.class */
    public static abstract class Callback {
        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
        }

        public void onPlayItemResponse(boolean z) {
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onUpdateFolderInfoBrowsedPlayer(String str) {
        }

        public void onUpdateNowPlayingContentChange() {
        }

        public void onUpdateNowPlayingEntries(long[] jArr) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaController$CallbackStub.class */
    public static final class CallbackStub extends ISessionControllerCallback.Stub {
        private final WeakReference<MediaController> mController;

        public CallbackStub(MediaController mediaController) {
            this.mController = new WeakReference<>(mediaController);
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onEvent(String str, Bundle bundle) {
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(1, str, bundle);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onExtrasChanged(Bundle bundle) {
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(7, bundle, null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(3, mediaMetadata, null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onPlayItemResponse(boolean z) {
            Log.d(MediaController.TAG, "CallBackStub: onPlayItemResponse");
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(11, new Boolean(z), null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(2, playbackState, null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onQueueChanged(ParceledListSlice parceledListSlice) {
            List list = parceledListSlice == null ? null : parceledListSlice.getList();
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(5, list, null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onQueueTitleChanged(CharSequence charSequence) {
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(6, charSequence, null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onSessionDestroyed() {
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(12, null, null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onUpdateFolderInfoBrowsedPlayer(String str) {
            Log.d(MediaController.TAG, "CallBackStub: onUpdateFolderInfoBrowsedPlayer");
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(8, str, null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onUpdateNowPlayingContentChange() {
            Log.d(MediaController.TAG, "CallBackStub: onUpdateNowPlayingContentChange");
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(10, null, null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onUpdateNowPlayingEntries(long[] jArr) {
            Log.d(MediaController.TAG, "CallBackStub: onUpdateNowPlayingEntries");
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(9, jArr, null);
            }
        }

        @Override // android.media.session.ISessionControllerCallback
        public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
            MediaController mediaController = this.mController.get();
            if (mediaController != null) {
                mediaController.postMessage(4, new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioAttrs, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaController$MessageHandler.class */
    public static final class MessageHandler extends Handler {
        private final Callback mCallback;
        private boolean mRegistered;

        public MessageHandler(Looper looper, Callback callback) {
            super(looper, null, true);
            this.mRegistered = false;
            this.mCallback = callback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.mRegistered) {
                switch (message.what) {
                    case 1:
                        this.mCallback.onSessionEvent((String) message.obj, message.getData());
                        return;
                    case 2:
                        this.mCallback.onPlaybackStateChanged((PlaybackState) message.obj);
                        return;
                    case 3:
                        this.mCallback.onMetadataChanged((MediaMetadata) message.obj);
                        return;
                    case 4:
                        this.mCallback.onAudioInfoChanged((PlaybackInfo) message.obj);
                        return;
                    case 5:
                        this.mCallback.onQueueChanged((List) message.obj);
                        return;
                    case 6:
                        this.mCallback.onQueueTitleChanged((CharSequence) message.obj);
                        return;
                    case 7:
                        this.mCallback.onExtrasChanged((Bundle) message.obj);
                        return;
                    case 8:
                        this.mCallback.onUpdateFolderInfoBrowsedPlayer((String) message.obj);
                        return;
                    case 9:
                        this.mCallback.onUpdateNowPlayingEntries((long[]) message.obj);
                        return;
                    case 10:
                        this.mCallback.onUpdateNowPlayingContentChange();
                        return;
                    case 11:
                        this.mCallback.onPlayItemResponse(((Boolean) message.obj).booleanValue());
                        return;
                    case 12:
                        this.mCallback.onSessionDestroyed();
                        return;
                    default:
                        return;
                }
            }
        }

        public void post(int i, Object obj, Bundle bundle) {
            obtainMessage(i, obj).sendToTarget();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaController$PlaybackInfo.class */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final AudioAttributes mAudioAttrs;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mVolumeControl;
        private final int mVolumeType;

        public PlaybackInfo(int i, AudioAttributes audioAttributes, int i2, int i3, int i4) {
            this.mVolumeType = i;
            this.mAudioAttrs = audioAttributes;
            this.mVolumeControl = i2;
            this.mMaxVolume = i3;
            this.mCurrentVolume = i4;
        }

        public AudioAttributes getAudioAttributes() {
            return this.mAudioAttrs;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getPlaybackType() {
            return this.mVolumeType;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaController$TransportControls.class */
    public final class TransportControls {
        private static final String TAG = "TransportController";

        private TransportControls() {
        }

        public void fastForward() {
            try {
                MediaController.this.mSessionBinder.fastForward();
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling fastForward.", e);
            }
        }

        public void getRemoteControlClientNowPlayingEntries() {
            Log.d(TAG, "getRemoteControlClientNowPlayingEntries in TransportControls");
            try {
                MediaController.this.mSessionBinder.getRemoteControlClientNowPlayingEntries();
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling getRemoteControlClientNowPlayingEntries.", e);
            }
        }

        public void pause() {
            try {
                MediaController.this.mSessionBinder.pause();
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling pause.", e);
            }
        }

        public void play() {
            try {
                MediaController.this.mSessionBinder.play();
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling play.", e);
            }
        }

        public void playFromMediaId(String str, Bundle bundle) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("You must specify a non-empty String for playFromMediaId.");
            }
            try {
                MediaController.this.mSessionBinder.playFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling play(" + str + ").", e);
            }
        }

        public void playFromSearch(String str, Bundle bundle) {
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            try {
                MediaController.this.mSessionBinder.playFromSearch(str2, bundle);
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling play(" + str2 + ").", e);
            }
        }

        public void rewind() {
            try {
                MediaController.this.mSessionBinder.rewind();
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling rewind.", e);
            }
        }

        public void seekTo(long j) {
            Log.d(TAG, "seekTo in TransportControls");
            try {
                MediaController.this.mSessionBinder.seekTo(j);
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling seekTo.", e);
            }
        }

        public void sendCustomAction(PlaybackState.CustomAction customAction, Bundle bundle) {
            if (customAction == null) {
                throw new IllegalArgumentException("CustomAction cannot be null.");
            }
            sendCustomAction(customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("CustomAction cannot be null.");
            }
            try {
                MediaController.this.mSessionBinder.sendCustomAction(str, bundle);
            } catch (RemoteException e) {
                Log.d(TAG, "Dead object in sendCustomAction.", e);
            }
        }

        public void setRating(Rating rating) {
            try {
                MediaController.this.mSessionBinder.rate(rating);
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling rate.", e);
            }
        }

        public void setRemoteControlClientBrowsedPlayer() {
            Log.d(TAG, "setRemoteControlClientBrowsedPlayer in TransportControls");
            try {
                MediaController.this.mSessionBinder.setRemoteControlClientBrowsedPlayer();
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling setRemoteControlClientBrowsedPlayer.", e);
            }
        }

        public void setRemoteControlClientPlayItem(long j, int i) {
            Log.d(TAG, "setRemoteControlClientPlayItem in TransportControls");
            try {
                MediaController.this.mSessionBinder.setRemoteControlClientPlayItem(j, i);
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling setRemoteControlClientPlayItem.", e);
            }
        }

        public void skipToNext() {
            try {
                MediaController.this.mSessionBinder.next();
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling next.", e);
            }
        }

        public void skipToPrevious() {
            try {
                MediaController.this.mSessionBinder.previous();
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling previous.", e);
            }
        }

        public void skipToQueueItem(long j) {
            try {
                MediaController.this.mSessionBinder.skipToQueueItem(j);
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling skipToItem(" + j + ").", e);
            }
        }

        public void stop() {
            try {
                MediaController.this.mSessionBinder.stop();
            } catch (RemoteException e) {
                Log.wtf(TAG, "Error calling stop.", e);
            }
        }
    }

    public MediaController(Context context, ISessionController iSessionController) {
        this.mCbStub = new CallbackStub(this);
        this.mCallbacks = new ArrayList<>();
        this.mLock = new Object();
        this.mCbRegistered = false;
        if (iSessionController == null) {
            throw new IllegalArgumentException("Session token cannot be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        this.mSessionBinder = iSessionController;
        this.mTransportControls = new TransportControls();
        this.mToken = new MediaSession.Token(iSessionController);
        this.mContext = context;
    }

    public MediaController(Context context, MediaSession.Token token) {
        this(context, token.getBinder());
    }

    private void addCallbackLocked(Callback callback, Handler handler) {
        if (getHandlerForCallbackLocked(callback) != null) {
            Log.w(TAG, "Callback is already added, ignoring");
            return;
        }
        MessageHandler messageHandler = new MessageHandler(handler.getLooper(), callback);
        this.mCallbacks.add(messageHandler);
        messageHandler.mRegistered = true;
        if (this.mCbRegistered) {
            return;
        }
        try {
            this.mSessionBinder.registerCallbackListener(this.mCbStub);
            this.mCbRegistered = true;
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in registerCallback", e);
        }
    }

    private MessageHandler getHandlerForCallbackLocked(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        int size = this.mCallbacks.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return null;
            }
            MessageHandler messageHandler = this.mCallbacks.get(i);
            if (callback == messageHandler.mCallback) {
                return messageHandler;
            }
            size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postMessage(int i, Object obj, Bundle bundle) {
        synchronized (this.mLock) {
            int size = this.mCallbacks.size();
            while (true) {
                int i2 = size - 1;
                if (i2 >= 0) {
                    this.mCallbacks.get(i2).post(i, obj, bundle);
                    size = i2;
                }
            }
        }
    }

    private boolean removeCallbackLocked(Callback callback) {
        boolean z = false;
        int size = this.mCallbacks.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            MessageHandler messageHandler = this.mCallbacks.get(i);
            if (callback == messageHandler.mCallback) {
                this.mCallbacks.remove(i);
                z = true;
                messageHandler.mRegistered = false;
            }
            size = i;
        }
        if (this.mCbRegistered && this.mCallbacks.size() == 0) {
            try {
                this.mSessionBinder.unregisterCallbackListener(this.mCbStub);
            } catch (RemoteException e) {
                Log.e(TAG, "Dead object in removeCallbackLocked");
            }
            this.mCbRegistered = false;
        }
        return z;
    }

    public void adjustVolume(int i, int i2) {
        try {
            this.mSessionBinder.adjustVolume(i, i2, this.mContext.getPackageName());
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling adjustVolumeBy.", e);
        }
    }

    public boolean controlsSameSession(MediaController mediaController) {
        return mediaController != null && this.mSessionBinder.asBinder() == mediaController.getSessionBinder().asBinder();
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        if (KeyEvent.isMediaKey(keyEvent.getKeyCode())) {
            try {
                return this.mSessionBinder.sendMediaButton(keyEvent);
            } catch (RemoteException e) {
                return false;
            }
        }
        return false;
    }

    public Bundle getExtras() {
        try {
            return this.mSessionBinder.getExtras();
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling getExtras", e);
            return null;
        }
    }

    public long getFlags() {
        try {
            return this.mSessionBinder.getFlags();
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling getFlags.", e);
            return 0L;
        }
    }

    public MediaMetadata getMetadata() {
        try {
            return this.mSessionBinder.getMetadata();
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling getMetadata.", e);
            return null;
        }
    }

    public String getPackageName() {
        if (this.mPackageName == null) {
            try {
                this.mPackageName = this.mSessionBinder.getPackageName();
            } catch (RemoteException e) {
                Log.d(TAG, "Dead object in getPackageName.", e);
            }
        }
        return this.mPackageName;
    }

    public PlaybackInfo getPlaybackInfo() {
        try {
            ParcelableVolumeInfo volumeAttributes = this.mSessionBinder.getVolumeAttributes();
            return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioAttrs, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling getAudioInfo.", e);
            return null;
        }
    }

    public PlaybackState getPlaybackState() {
        try {
            return this.mSessionBinder.getPlaybackState();
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling getPlaybackState.", e);
            return null;
        }
    }

    public List<MediaSession.QueueItem> getQueue() {
        try {
            ParceledListSlice queue = this.mSessionBinder.getQueue();
            if (queue != null) {
                return queue.getList();
            }
            return null;
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling getQueue.", e);
            return null;
        }
    }

    public CharSequence getQueueTitle() {
        try {
            return this.mSessionBinder.getQueueTitle();
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling getQueueTitle", e);
            return null;
        }
    }

    public int getRatingType() {
        try {
            return this.mSessionBinder.getRatingType();
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling getRatingType.", e);
            return 0;
        }
    }

    public PendingIntent getSessionActivity() {
        try {
            return this.mSessionBinder.getLaunchPendingIntent();
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling getPendingIntent.", e);
            return null;
        }
    }

    ISessionController getSessionBinder() {
        return this.mSessionBinder;
    }

    public MediaSession.Token getSessionToken() {
        return this.mToken;
    }

    public String getTag() {
        if (this.mTag == null) {
            try {
                this.mTag = this.mSessionBinder.getTag();
            } catch (RemoteException e) {
                Log.d(TAG, "Dead object in getTag.", e);
            }
        }
        return this.mTag;
    }

    public TransportControls getTransportControls() {
        return this.mTransportControls;
    }

    public void registerCallback(Callback callback) {
        registerCallback(callback, null);
    }

    public void registerCallback(Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        Handler handler2 = handler;
        if (handler == null) {
            handler2 = new Handler();
        }
        synchronized (this.mLock) {
            addCallbackLocked(callback, handler2);
        }
    }

    public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }
        try {
            this.mSessionBinder.sendCommand(str, bundle, resultReceiver);
        } catch (RemoteException e) {
            Log.d(TAG, "Dead object in sendCommand.", e);
        }
    }

    public void setVolumeTo(int i, int i2) {
        try {
            this.mSessionBinder.setVolumeTo(i, i2, this.mContext.getPackageName());
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error calling setVolumeTo.", e);
        }
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        synchronized (this.mLock) {
            removeCallbackLocked(callback);
        }
    }
}
