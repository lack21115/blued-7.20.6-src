package android.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ParceledListSlice;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.ISessionCallback;
import android.media.session.ISessionController;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSession.class */
public final class MediaSession {
    public static final int FLAG_EXCLUSIVE_GLOBAL_PRIORITY = 65536;
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    private static final String TAG = "MediaSession";
    private boolean mActive;
    private final ISession mBinder;
    private CallbackMessageHandler mCallback;
    private final CallbackStub mCbStub;
    private final MediaController mController;
    private final Object mLock;
    private final int mMaxBitmapSize;
    private PlaybackState mPlaybackState;
    private final Token mSessionToken;
    private VolumeProvider mVolumeProvider;

    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSession$Callback.class */
    public static abstract class Callback {
        private MediaSession mSession;

        public void getNowPlayingEntries() {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            KeyEvent keyEvent;
            if (this.mSession == null || !Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction()) || (keyEvent = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT)) == null || keyEvent.getAction() != 0) {
                return false;
            }
            PlaybackState playbackState = this.mSession.mPlaybackState;
            long actions = playbackState == null ? 0L : playbackState.getActions();
            switch (keyEvent.getKeyCode()) {
                case 79:
                case 85:
                    boolean z = playbackState == null ? false : playbackState.getState() == 3;
                    boolean z2 = (516 & actions) != 0;
                    boolean z3 = (514 & actions) != 0;
                    if (z && z3) {
                        onPause();
                        return true;
                    } else if (z || !z2) {
                        return false;
                    } else {
                        onPlay();
                        return true;
                    }
                case 86:
                    if ((1 & actions) != 0) {
                        onStop();
                        return true;
                    }
                    return false;
                case 87:
                    if ((32 & actions) != 0) {
                        onSkipToNext();
                        return true;
                    }
                    return false;
                case 88:
                    if ((16 & actions) != 0) {
                        onSkipToPrevious();
                        return true;
                    }
                    return false;
                case 89:
                    if ((8 & actions) != 0) {
                        onRewind();
                        return true;
                    }
                    return false;
                case 90:
                    if ((64 & actions) != 0) {
                        onFastForward();
                        return true;
                    }
                    return false;
                case 126:
                    if ((4 & actions) != 0) {
                        onPlay();
                        return true;
                    }
                    return false;
                case 127:
                    if ((2 & actions) != 0) {
                        onPause();
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetRating(Rating rating) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }

        public void setBrowsedPlayer() {
        }

        public void setPlayItem(int i, long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSession$CallbackMessageHandler.class */
    public class CallbackMessageHandler extends Handler {
        private static final int MSG_ADJUST_VOLUME = 19;
        private static final int MSG_COMMAND = 15;
        private static final int MSG_CUSTOM_ACTION = 13;
        private static final int MSG_FAST_FORWARD = 9;
        private static final int MSG_GET_NOW_PLAYING_ITEMS = 18;
        private static final int MSG_MEDIA_BUTTON = 14;
        private static final int MSG_NEXT = 7;
        private static final int MSG_PAUSE = 5;
        private static final int MSG_PLAY = 1;
        private static final int MSG_PLAY_MEDIA_ID = 2;
        private static final int MSG_PLAY_SEARCH = 3;
        private static final int MSG_PREVIOUS = 8;
        private static final int MSG_RATE = 12;
        private static final int MSG_REWIND = 10;
        private static final int MSG_SEEK_TO = 11;
        private static final int MSG_SET_BROWSED_PLAYER = 16;
        private static final int MSG_SET_PLAY_ITEM = 17;
        private static final int MSG_SET_VOLUME = 20;
        private static final int MSG_SKIP_TO_ITEM = 4;
        private static final int MSG_STOP = 6;
        private Callback mCallback;

        public CallbackMessageHandler(Looper looper, Callback callback) {
            super(looper, null, true);
            this.mCallback = callback;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VolumeProvider volumeProvider;
            VolumeProvider volumeProvider2;
            switch (message.what) {
                case 1:
                    this.mCallback.onPlay();
                    return;
                case 2:
                    this.mCallback.onPlayFromMediaId((String) message.obj, message.getData());
                    return;
                case 3:
                    this.mCallback.onPlayFromSearch((String) message.obj, message.getData());
                    return;
                case 4:
                    this.mCallback.onSkipToQueueItem(((Long) message.obj).longValue());
                    return;
                case 5:
                    this.mCallback.onPause();
                    return;
                case 6:
                    this.mCallback.onStop();
                    return;
                case 7:
                    this.mCallback.onSkipToNext();
                    return;
                case 8:
                    this.mCallback.onSkipToPrevious();
                    return;
                case 9:
                    this.mCallback.onFastForward();
                    return;
                case 10:
                    this.mCallback.onRewind();
                    return;
                case 11:
                    this.mCallback.onSeekTo(((Long) message.obj).longValue());
                    return;
                case 12:
                    this.mCallback.onSetRating((Rating) message.obj);
                    return;
                case 13:
                    this.mCallback.onCustomAction((String) message.obj, message.getData());
                    return;
                case 14:
                    this.mCallback.onMediaButtonEvent((Intent) message.obj);
                    return;
                case 15:
                    Command command = (Command) message.obj;
                    this.mCallback.onCommand(command.command, command.extras, command.stub);
                    return;
                case 16:
                    Log.d(MediaSession.TAG, "MSG_SET_BROWSED_PLAYER received in CallbackMessageHandler");
                    this.mCallback.setBrowsedPlayer();
                    return;
                case 17:
                    Log.d(MediaSession.TAG, "MSG_SET_PLAY_ITEM received in CallbackMessageHandler");
                    PlayItemToken playItemToken = (PlayItemToken) message.obj;
                    this.mCallback.setPlayItem(playItemToken.getScope(), playItemToken.getUid());
                    return;
                case 18:
                    Log.d(MediaSession.TAG, "MSG_GET_NOW_PLAYING_ITEMS received in CallbackMessageHandler");
                    this.mCallback.getNowPlayingEntries();
                    break;
                case 19:
                    break;
                case 20:
                    synchronized (MediaSession.this.mLock) {
                        volumeProvider = MediaSession.this.mVolumeProvider;
                    }
                    if (volumeProvider != null) {
                        volumeProvider.onSetVolumeTo(((Integer) message.obj).intValue());
                        return;
                    }
                    return;
                default:
                    return;
            }
            synchronized (MediaSession.this.mLock) {
                volumeProvider2 = MediaSession.this.mVolumeProvider;
            }
            if (volumeProvider2 != null) {
                volumeProvider2.onAdjustVolume(((Integer) message.obj).intValue());
            }
        }

        public void post(int i) {
            post(i, null);
        }

        public void post(int i, Object obj) {
            obtainMessage(i, obj).sendToTarget();
        }

        public void post(int i, Object obj, int i2) {
            obtainMessage(i, i2, 0, obj).sendToTarget();
        }

        public void post(int i, Object obj, Bundle bundle) {
            Message obtainMessage = obtainMessage(i, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSession$CallbackStub.class */
    public static class CallbackStub extends ISessionCallback.Stub {
        private WeakReference<MediaSession> mMediaSession;

        public CallbackStub(MediaSession mediaSession) {
            this.mMediaSession = new WeakReference<>(mediaSession);
        }

        @Override // android.media.session.ISessionCallback
        public void getRemoteControlClientNowPlayingEntries() throws RemoteException {
            Log.d(MediaSession.TAG, "getRemoteControlClientNowPlayingEntries in CallbackStub");
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchGetNowPlayingItemsCommand();
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onAdjustVolume(int i) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchAdjustVolume(i);
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.postCommand(str, bundle, resultReceiver);
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onCustomAction(String str, Bundle bundle) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchCustomAction(str, bundle);
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onFastForward() {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchFastForward();
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onMediaButton(Intent intent, int i, ResultReceiver resultReceiver) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                try {
                    mediaSession.dispatchMediaButton(intent);
                } finally {
                    if (resultReceiver != null) {
                        resultReceiver.send(i, null);
                    }
                }
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onNext() {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchNext();
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onPause() {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchPause();
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onPlay() {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchPlay();
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onPlayFromMediaId(String str, Bundle bundle) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchPlayFromMediaId(str, bundle);
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onPlayFromSearch(String str, Bundle bundle) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchPlayFromSearch(str, bundle);
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onPrevious() {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchPrevious();
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onRate(Rating rating) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchRate(rating);
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onRewind() {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchRewind();
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onSeekTo(long j) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchSeekTo(j);
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onSetVolumeTo(int i) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchSetVolumeTo(i);
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onSkipToTrack(long j) {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchSkipToItem(j);
            }
        }

        @Override // android.media.session.ISessionCallback
        public void onStop() {
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchStop();
            }
        }

        @Override // android.media.session.ISessionCallback
        public void setRemoteControlClientBrowsedPlayer() throws RemoteException {
            Log.d(MediaSession.TAG, "setRemoteControlClientBrowsedPlayer in CallbackStub");
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchSetBrowsedPlayerCommand();
            }
        }

        @Override // android.media.session.ISessionCallback
        public void setRemoteControlClientPlayItem(long j, int i) throws RemoteException {
            Log.d(MediaSession.TAG, "setRemoteControlClientPlayItem in CallbackStub");
            MediaSession mediaSession = this.mMediaSession.get();
            if (mediaSession != null) {
                mediaSession.dispatchSetPlayItemCommand(j, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSession$Command.class */
    public static final class Command {
        public final String command;
        public final Bundle extras;
        public final ResultReceiver stub;

        public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.command = str;
            this.extras = bundle;
            this.stub = resultReceiver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSession$PlayItemToken.class */
    public class PlayItemToken {
        private int mScope;
        private long mUid;

        public PlayItemToken(long j, int i) {
            this.mUid = j;
            this.mScope = i;
        }

        public int getScope() {
            return this.mScope;
        }

        public long getUid() {
            return this.mUid;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSession$QueueItem.class */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() { // from class: android.media.session.MediaSession.QueueItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        public static final int UNKNOWN_ID = -1;
        private final MediaDescription mDescription;
        private final long mId;

        public QueueItem(MediaDescription mediaDescription, long j) {
            if (mediaDescription == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.mDescription = mediaDescription;
            this.mId = j;
        }

        private QueueItem(Parcel parcel) {
            this.mDescription = MediaDescription.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaDescription getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.mDescription.writeToParcel(parcel, i);
            parcel.writeLong(this.mId);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSession$Token.class */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() { // from class: android.media.session.MediaSession.Token.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Token createFromParcel(Parcel parcel) {
                return new Token(ISessionController.Stub.asInterface(parcel.readStrongBinder()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Token[] newArray(int i) {
                return new Token[i];
            }
        };
        private ISessionController mBinder;

        public Token(ISessionController iSessionController) {
            this.mBinder = iSessionController;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Token token = (Token) obj;
                return this.mBinder == null ? token.mBinder == null : this.mBinder.asBinder().equals(token.mBinder.asBinder());
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ISessionController getBinder() {
            return this.mBinder;
        }

        public int hashCode() {
            return (this.mBinder == null ? 0 : this.mBinder.asBinder().hashCode()) + 31;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStrongBinder(this.mBinder.asBinder());
        }
    }

    public MediaSession(Context context, String str) {
        this(context, str, UserHandle.myUserId());
    }

    public MediaSession(Context context, String str, int i) {
        this.mLock = new Object();
        this.mActive = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null.");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag cannot be null or empty");
        }
        this.mMaxBitmapSize = context.getResources().getDimensionPixelSize(17104911);
        this.mCbStub = new CallbackStub(this);
        try {
            this.mBinder = ((MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE)).createSession(this.mCbStub, str, i);
            this.mSessionToken = new Token(this.mBinder.getController());
            this.mController = new MediaController(context, this.mSessionToken);
        } catch (RemoteException e) {
            throw new RuntimeException("Remote error creating session.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAdjustVolume(int i) {
        postToCallback(19, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCustomAction(String str, Bundle bundle) {
        postToCallback(13, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchFastForward() {
        postToCallback(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchGetNowPlayingItemsCommand() {
        postToCallback(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchMediaButton(Intent intent) {
        postToCallback(14, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchNext() {
        postToCallback(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPause() {
        postToCallback(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPlay() {
        postToCallback(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPlayFromMediaId(String str, Bundle bundle) {
        postToCallback(2, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPlayFromSearch(String str, Bundle bundle) {
        postToCallback(3, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPrevious() {
        postToCallback(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRate(Rating rating) {
        postToCallback(12, rating);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRewind() {
        postToCallback(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSeekTo(long j) {
        postToCallback(11, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSetBrowsedPlayerCommand() {
        postToCallback(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSetPlayItemCommand(long j, int i) {
        postToCallback(17, new PlayItemToken(j, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSetVolumeTo(int i) {
        postToCallback(20, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSkipToItem(long j) {
        postToCallback(4, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchStop() {
        postToCallback(6);
    }

    public static boolean isActiveState(int i) {
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
                return true;
            case 7:
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        postToCallback(15, new Command(str, bundle, resultReceiver));
    }

    private void postToCallback(int i) {
        postToCallback(i, null);
    }

    private void postToCallback(int i, Object obj) {
        postToCallback(i, obj, null);
    }

    private void postToCallback(int i, Object obj, Bundle bundle) {
        synchronized (this.mLock) {
            if (this.mCallback != null) {
                this.mCallback.post(i, obj, bundle);
            }
        }
    }

    public MediaController getController() {
        return this.mController;
    }

    public Token getSessionToken() {
        return this.mSessionToken;
    }

    public boolean isActive() {
        return this.mActive;
    }

    public void notifyRemoteVolumeChanged(VolumeProvider volumeProvider) {
        synchronized (this.mLock) {
            if (volumeProvider != null) {
                if (volumeProvider == this.mVolumeProvider) {
                    try {
                        this.mBinder.setCurrentVolume(volumeProvider.getCurrentVolume());
                        return;
                    } catch (RemoteException e) {
                        Log.e(TAG, "Error in notifyVolumeChanged", e);
                        return;
                    }
                }
            }
            Log.w(TAG, "Received update from stale volume provider");
        }
    }

    public void playItemResponse(boolean z) {
        Log.d(TAG, "MediaSession: playItemResponse");
        try {
            this.mBinder.playItemResponse(z);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Dead object in playItemResponse.", e);
        }
    }

    public void release() {
        try {
            this.mBinder.destroy();
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error releasing session: ", e);
        }
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        try {
            this.mBinder.sendEvent(str, bundle);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Error sending event", e);
        }
    }

    public void setActive(boolean z) {
        if (this.mActive == z) {
            return;
        }
        try {
            this.mBinder.setActive(z);
            this.mActive = z;
        } catch (RemoteException e) {
            Log.wtf(TAG, "Failure in setActive.", e);
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        synchronized (this.mLock) {
            if (callback == null) {
                if (this.mCallback != null) {
                    this.mCallback.mCallback.mSession = null;
                }
                this.mCallback = null;
                return;
            }
            if (this.mCallback != null) {
                this.mCallback.mCallback.mSession = null;
            }
            Handler handler2 = handler;
            if (handler == null) {
                handler2 = new Handler();
            }
            callback.mSession = this;
            this.mCallback = new CallbackMessageHandler(handler2.getLooper(), callback);
        }
    }

    public void setExtras(Bundle bundle) {
        try {
            this.mBinder.setExtras(bundle);
        } catch (RemoteException e) {
            Log.wtf("Dead object in setExtras.", e);
        }
    }

    public void setFlags(int i) {
        try {
            this.mBinder.setFlags(i);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Failure in setFlags.", e);
        }
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        try {
            this.mBinder.setMediaButtonReceiver(pendingIntent);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Failure in setMediaButtonReceiver.", e);
        }
    }

    public void setMetadata(MediaMetadata mediaMetadata) {
        MediaMetadata mediaMetadata2 = mediaMetadata;
        if (mediaMetadata != null) {
            mediaMetadata2 = new MediaMetadata.Builder(mediaMetadata, this.mMaxBitmapSize).build();
        }
        try {
            this.mBinder.setMetadata(mediaMetadata2);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Dead object in setPlaybackState.", e);
        }
    }

    public void setPlaybackState(PlaybackState playbackState) {
        this.mPlaybackState = playbackState;
        try {
            this.mBinder.setPlaybackState(playbackState);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Dead object in setPlaybackState.", e);
        }
    }

    public void setPlaybackToLocal(AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            throw new IllegalArgumentException("Attributes cannot be null for local playback.");
        }
        try {
            this.mBinder.setPlaybackToLocal(audioAttributes);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Failure in setPlaybackToLocal.", e);
        }
    }

    public void setPlaybackToRemote(VolumeProvider volumeProvider) {
        if (volumeProvider == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        synchronized (this.mLock) {
            this.mVolumeProvider = volumeProvider;
        }
        volumeProvider.setCallback(new VolumeProvider.Callback() { // from class: android.media.session.MediaSession.1
            @Override // android.media.VolumeProvider.Callback
            public void onVolumeChanged(VolumeProvider volumeProvider2) {
                MediaSession.this.notifyRemoteVolumeChanged(volumeProvider2);
            }
        });
        try {
            this.mBinder.setPlaybackToRemote(volumeProvider.getVolumeControl(), volumeProvider.getMaxVolume());
            this.mBinder.setCurrentVolume(volumeProvider.getCurrentVolume());
        } catch (RemoteException e) {
            Log.wtf(TAG, "Failure in setPlaybackToRemote.", e);
        }
    }

    public void setQueue(List<QueueItem> list) {
        try {
            this.mBinder.setQueue(list == null ? null : new ParceledListSlice(list));
        } catch (RemoteException e) {
            Log.wtf("Dead object in setQueue.", e);
        }
    }

    public void setQueueTitle(CharSequence charSequence) {
        try {
            this.mBinder.setQueueTitle(charSequence);
        } catch (RemoteException e) {
            Log.wtf("Dead object in setQueueTitle.", e);
        }
    }

    public void setRatingType(int i) {
        try {
            this.mBinder.setRatingType(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Error in setRatingType.", e);
        }
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        try {
            this.mBinder.setLaunchPendingIntent(pendingIntent);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Failure in setLaunchPendingIntent.", e);
        }
    }

    public void updateFolderInfoBrowsedPlayer(String str) {
        Log.d(TAG, "MediaSession: updateFolderInfoBrowsedPlayer");
        try {
            this.mBinder.updateFolderInfoBrowsedPlayer(str);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Dead object in updateFolderInfoBrowsedPlayer.", e);
        }
    }

    public void updateNowPlayingContentChange() {
        Log.d(TAG, "MediaSession: updateNowPlayingContentChange");
        try {
            this.mBinder.updateNowPlayingContentChange();
        } catch (RemoteException e) {
            Log.wtf(TAG, "Dead object in updateNowPlayingContentChange.", e);
        }
    }

    public void updateNowPlayingEntries(long[] jArr) {
        Log.d(TAG, "MediaSession: updateNowPlayingEntries");
        try {
            this.mBinder.updateNowPlayingEntries(jArr);
        } catch (RemoteException e) {
            Log.wtf(TAG, "Dead object in updateNowPlayingEntries.", e);
        }
    }
}
