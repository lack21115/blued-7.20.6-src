package android.media;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/media/PlayerRecord.class */
public class PlayerRecord implements IBinder.DeathRecipient {
    private static final boolean DEBUG = false;
    private static final String TAG = "MediaFocusControl";
    public static MediaFocusControl sController;
    private static int sLastRccId = 0;
    private String mCallingPackageName;
    private final PendingIntent mMediaIntent;
    public RccPlaybackState mPlaybackState;
    public int mPlaybackStream;
    public int mPlaybackType;
    public int mPlaybackVolume;
    public int mPlaybackVolumeHandling;
    public int mPlaybackVolumeMax;
    private RcClientDeathHandler mRcClientDeathHandler;
    private int mRccId;
    private final ComponentName mReceiverComponent;
    public IRemoteVolumeObserver mRemoteVolumeObs;
    private IBinder mToken;
    private int mCallingUid = -1;
    private IRemoteControlClient mRcClient = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/PlayerRecord$RcClientDeathHandler.class */
    public class RcClientDeathHandler implements IBinder.DeathRecipient {
        private final IBinder mCb;
        private final PendingIntent mMediaIntent;

        RcClientDeathHandler(IBinder iBinder, PendingIntent pendingIntent) {
            this.mCb = iBinder;
            this.mMediaIntent = pendingIntent;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.w(PlayerRecord.TAG, "  RemoteControlClient died");
            PlayerRecord.sController.registerRemoteControlClient(this.mMediaIntent, null, null);
            PlayerRecord.sController.postReevaluateRemote();
        }

        public IBinder getBinder() {
            return this.mCb;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: source-9557208-dex2jar.jar:android/media/PlayerRecord$RccPlaybackState.class */
    public static class RccPlaybackState {
        public long mPositionMs;
        public float mSpeed;
        public int mState;

        public RccPlaybackState(int i, long j, float f) {
            this.mState = i;
            this.mPositionMs = j;
            this.mSpeed = f;
        }

        private String posToString() {
            return this.mPositionMs == -1 ? "PLAYBACK_POSITION_INVALID" : this.mPositionMs == RemoteControlClient.PLAYBACK_POSITION_ALWAYS_UNKNOWN ? "PLAYBACK_POSITION_ALWAYS_UNKNOWN" : String.valueOf(this.mPositionMs) + "ms";
        }

        private String stateToString() {
            switch (this.mState) {
                case 0:
                    return "PLAYSTATE_NONE";
                case 1:
                    return "PLAYSTATE_STOPPED";
                case 2:
                    return "PLAYSTATE_PAUSED";
                case 3:
                    return "PLAYSTATE_PLAYING";
                case 4:
                    return "PLAYSTATE_FAST_FORWARDING";
                case 5:
                    return "PLAYSTATE_REWINDING";
                case 6:
                    return "PLAYSTATE_SKIPPING_FORWARDS";
                case 7:
                    return "PLAYSTATE_SKIPPING_BACKWARDS";
                case 8:
                    return "PLAYSTATE_BUFFERING";
                case 9:
                    return "PLAYSTATE_ERROR";
                default:
                    return "[invalid playstate]";
            }
        }

        public void reset() {
            this.mState = 1;
            this.mPositionMs = -1L;
            this.mSpeed = 1.0f;
        }

        public String toString() {
            return stateToString() + ", " + posToString() + ", " + this.mSpeed + "X";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: source-9557208-dex2jar.jar:android/media/PlayerRecord$RemotePlaybackState.class */
    public static class RemotePlaybackState {
        int mRccId;
        int mVolume;
        int mVolumeHandling = 1;
        int mVolumeMax;

        /* JADX INFO: Access modifiers changed from: protected */
        public RemotePlaybackState(int i, int i2, int i3) {
            this.mRccId = i;
            this.mVolume = i2;
            this.mVolumeMax = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PlayerRecord(PendingIntent pendingIntent, ComponentName componentName, IBinder iBinder) {
        this.mRccId = -1;
        this.mMediaIntent = pendingIntent;
        this.mReceiverComponent = componentName;
        this.mToken = iBinder;
        int i = sLastRccId + 1;
        sLastRccId = i;
        this.mRccId = i;
        this.mPlaybackState = new RccPlaybackState(1, -1L, 1.0f);
        resetPlaybackInfo();
        if (this.mToken != null) {
            try {
                this.mToken.linkToDeath(this, 0);
            } catch (RemoteException e) {
                sController.unregisterMediaButtonIntentAsync(this.mMediaIntent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setMediaFocusControl(MediaFocusControl mediaFocusControl) {
        sController = mediaFocusControl;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        sController.unregisterMediaButtonIntentAsync(this.mMediaIntent);
    }

    public void destroy() {
        unlinkToRcClientDeath();
        if (this.mToken != null) {
            this.mToken.unlinkToDeath(this, 0);
            this.mToken = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.println("  pi: " + this.mMediaIntent + " -- pack: " + this.mCallingPackageName + "  -- ercvr: " + this.mReceiverComponent + "  -- client: " + this.mRcClient + "  -- uid: " + this.mCallingUid + "  -- type: " + this.mPlaybackType + "  state: " + this.mPlaybackState);
        } else {
            printWriter.println("  uid: " + this.mCallingUid + "  -- id: " + this.mRccId + "  -- type: " + this.mPlaybackType + "  -- state: " + this.mPlaybackState + "  -- vol handling: " + this.mPlaybackVolumeHandling + "  -- vol: " + this.mPlaybackVolume + "  -- volMax: " + this.mPlaybackVolumeMax + "  -- volObs: " + this.mRemoteVolumeObs);
        }
    }

    protected void finalize() throws Throwable {
        destroy();
        super.finalize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PendingIntent getMediaButtonIntent() {
        return this.mMediaIntent;
    }

    protected ComponentName getMediaButtonReceiver() {
        return this.mReceiverComponent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IRemoteControlClient getRcc() {
        return this.mRcClient;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRccId() {
        return this.mRccId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasMatchingMediaButtonIntent(PendingIntent pendingIntent) {
        if (this.mToken != null) {
            return this.mMediaIntent.equals(pendingIntent);
        }
        if (this.mReceiverComponent != null) {
            return this.mReceiverComponent.equals(pendingIntent.getIntent().getComponent());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isPlaybackActive() {
        return MediaFocusControl.isPlaystateActive(this.mPlaybackState.mState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetControllerInfoForNoRcc() {
        unlinkToRcClientDeath();
        this.mRcClient = null;
        this.mCallingPackageName = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetControllerInfoForRcc(IRemoteControlClient iRemoteControlClient, String str, int i) {
        if (this.mRcClientDeathHandler != null) {
            unlinkToRcClientDeath();
        }
        this.mRcClient = iRemoteControlClient;
        this.mCallingPackageName = str;
        this.mCallingUid = i;
        if (iRemoteControlClient == null) {
            resetPlaybackInfo();
            return;
        }
        IBinder asBinder = this.mRcClient.asBinder();
        RcClientDeathHandler rcClientDeathHandler = new RcClientDeathHandler(asBinder, this.mMediaIntent);
        try {
            asBinder.linkToDeath(rcClientDeathHandler, 0);
        } catch (RemoteException e) {
            Log.w(TAG, "registerRemoteControlClient() has a dead client " + asBinder);
            this.mRcClient = null;
        }
        this.mRcClientDeathHandler = rcClientDeathHandler;
    }

    public void resetPlaybackInfo() {
        this.mPlaybackType = 0;
        this.mPlaybackVolume = 15;
        this.mPlaybackVolumeMax = 15;
        this.mPlaybackVolumeHandling = 1;
        this.mPlaybackStream = 3;
        this.mPlaybackState.reset();
        this.mRemoteVolumeObs = null;
    }

    public void unlinkToRcClientDeath() {
        if (this.mRcClientDeathHandler == null || this.mRcClientDeathHandler.mCb == null) {
            return;
        }
        try {
            this.mRcClientDeathHandler.mCb.unlinkToDeath(this.mRcClientDeathHandler, 0);
            this.mRcClientDeathHandler = null;
        } catch (NoSuchElementException e) {
            Log.e(TAG, "Error in unlinkToRcClientDeath()", e);
        }
    }
}
