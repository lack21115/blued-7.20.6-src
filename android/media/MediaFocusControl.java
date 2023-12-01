package android.media;

import android.Manifest;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.media.AudioService;
import android.media.PlayerRecord;
import android.media.audiopolicy.IAudioPolicyCallback;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.UserHandle;
import android.provider.Settings;
import android.speech.RecognizerIntent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.Slog;
import android.view.KeyEvent;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaFocusControl.class */
public class MediaFocusControl implements PendingIntent.OnFinished {
    protected static final boolean DEBUG_RC = false;
    protected static final boolean DEBUG_VOL = false;
    private static final String EXTRA_WAKELOCK_ACQUIRED = "android.media.AudioService.WAKELOCK_ACQUIRED";
    protected static final String IN_VOICE_COMM_FOCUS_ID = "AudioFocus_For_Phone_Ring_And_Calls";
    private static final int MSG_RCC_GET_NOW_PLAYING_ENTRIES = 14;
    private static final int MSG_RCC_NEW_PLAYBACK_INFO = 4;
    private static final int MSG_RCC_NEW_PLAYBACK_STATE = 6;
    private static final int MSG_RCC_NEW_VOLUME_OBS = 5;
    private static final int MSG_RCC_SEEK_REQUEST = 7;
    private static final int MSG_RCC_SET_BROWSED_PLAYER = 12;
    private static final int MSG_RCC_SET_PLAY_ITEM = 13;
    private static final int MSG_RCC_UPDATE_METADATA = 8;
    private static final int MSG_RCDISPLAY_CLEAR = 1;
    private static final int MSG_RCDISPLAY_INIT_INFO = 9;
    private static final int MSG_RCDISPLAY_UPDATE = 2;
    private static final int MSG_REEVALUATE_RCD = 10;
    private static final int MSG_REEVALUATE_REMOTE = 3;
    private static final int MSG_UNREGISTER_MEDIABUTTONINTENT = 11;
    private static final int RCD_REG_FAILURE = 0;
    private static final int RCD_REG_SUCCESS_ENABLED_NOTIF = 2;
    private static final int RCD_REG_SUCCESS_PERMISSION = 1;
    private static final int RC_INFO_ALL = 15;
    private static final int RC_INFO_NONE = 0;
    private static final int SENDMSG_NOOP = 1;
    private static final int SENDMSG_QUEUE = 2;
    private static final int SENDMSG_REPLACE = 0;
    private static final String TAG = "MediaFocusControl";
    private static final int VOICEBUTTON_ACTION_DISCARD_CURRENT_KEY_PRESS = 1;
    private static final int VOICEBUTTON_ACTION_SIMULATE_KEY_PRESS = 3;
    private static final int VOICEBUTTON_ACTION_START_VOICE_INPUT = 2;
    private static final int WAKELOCK_RELEASE_ON_FINISHED = 1980;
    private final AppOpsManager mAppOps;
    private final AudioService mAudioService;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final MediaEventHandler mEventHandler;
    private boolean mHasRemotePlayback;
    private final KeyguardManager mKeyguardManager;
    private boolean mMainRemoteIsActive;
    private final PowerManager.WakeLock mMediaEventWakeLock;
    private final NotificationListenerObserver mNotifListenerObserver;
    private boolean mVoiceButtonDown;
    private boolean mVoiceButtonHandled;
    private final AudioService.VolumeController mVolumeController;
    private static final Uri ENABLED_NOTIFICATION_LISTENERS_URI = Settings.Secure.getUriFor(Settings.Secure.ENABLED_NOTIFICATION_LISTENERS);
    private static final Object mAudioFocusLock = new Object();
    private static final Object mRingingLock = new Object();
    private boolean mIsRinging = false;
    private PhoneStateListener mPhoneStateListener = new PhoneStateListener() { // from class: android.media.MediaFocusControl.1
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            if (i == 1) {
                synchronized (MediaFocusControl.mRingingLock) {
                    MediaFocusControl.this.mIsRinging = true;
                }
            } else if (i == 2 || i == 0) {
                synchronized (MediaFocusControl.mRingingLock) {
                    MediaFocusControl.this.mIsRinging = false;
                }
            }
        }
    };
    private final Stack<FocusRequester> mFocusStack = new Stack<>();
    private boolean mNotifyFocusOwnerOnDuck = true;
    private ArrayList<IAudioPolicyCallback> mFocusFollowers = new ArrayList<>();
    private final Object mVoiceEventLock = new Object();
    BroadcastReceiver mKeyEventDone = new BroadcastReceiver() { // from class: android.media.MediaFocusControl.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey(MediaFocusControl.EXTRA_WAKELOCK_ACQUIRED)) {
                return;
            }
            MediaFocusControl.this.mMediaEventWakeLock.release();
        }
    };
    private final Object mCurrentRcLock = new Object();
    private IRemoteControlClient mCurrentRcClient = null;
    private PendingIntent mCurrentRcClientIntent = null;
    private int mCurrentRcClientGen = 0;
    private final Stack<PlayerRecord> mPRStack = new Stack<>();
    private ComponentName mMediaReceiverForCalls = null;
    private ArrayList<DisplayInfoForServer> mRcDisplays = new ArrayList<>(1);
    private PlayerRecord.RemotePlaybackState mMainRemote = new PlayerRecord.RemotePlaybackState(-1, AudioService.getMaxStreamVolume(3), AudioService.getMaxStreamVolume(3));

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaFocusControl$AudioFocusDeathHandler.class */
    public class AudioFocusDeathHandler implements IBinder.DeathRecipient {
        private IBinder mCb;

        AudioFocusDeathHandler(IBinder iBinder) {
            this.mCb = iBinder;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (MediaFocusControl.mAudioFocusLock) {
                Log.w(MediaFocusControl.TAG, "  AudioFocus   audio focus client died");
                MediaFocusControl.this.removeFocusStackEntryForClient(this.mCb);
            }
        }

        public IBinder getBinder() {
            return this.mCb;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaFocusControl$DisplayInfoForServer.class */
    public class DisplayInfoForServer implements IBinder.DeathRecipient {
        private int mArtworkExpectedHeight;
        private int mArtworkExpectedWidth;
        private ComponentName mClientNotifListComp;
        private final IRemoteControlDisplay mRcDisplay;
        private final IBinder mRcDisplayBinder;
        private boolean mWantsPositionSync = false;
        private boolean mEnabled = true;

        public DisplayInfoForServer(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2) {
            this.mArtworkExpectedWidth = -1;
            this.mArtworkExpectedHeight = -1;
            this.mRcDisplay = iRemoteControlDisplay;
            this.mRcDisplayBinder = iRemoteControlDisplay.asBinder();
            this.mArtworkExpectedWidth = i;
            this.mArtworkExpectedHeight = i2;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (MediaFocusControl.this.mPRStack) {
                Log.w(MediaFocusControl.TAG, "RemoteControl: display " + this.mRcDisplay + " died");
                Iterator it = MediaFocusControl.this.mRcDisplays.iterator();
                do {
                    if (!it.hasNext()) {
                        return;
                    }
                } while (((DisplayInfoForServer) it.next()).mRcDisplay != this.mRcDisplay);
                it.remove();
            }
        }

        public boolean init() {
            try {
                this.mRcDisplayBinder.linkToDeath(this, 0);
                return true;
            } catch (RemoteException e) {
                Log.w(MediaFocusControl.TAG, "registerRemoteControlDisplay() has a dead client " + this.mRcDisplayBinder);
                return false;
            }
        }

        public void release() {
            try {
                this.mRcDisplayBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException e) {
                Log.e(MediaFocusControl.TAG, "Error in DisplaInfoForServer.relase()", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaFocusControl$MediaEventHandler.class */
    public class MediaEventHandler extends Handler {
        MediaEventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    MediaFocusControl.this.onRcDisplayClear();
                    return;
                case 2:
                    MediaFocusControl.this.onRcDisplayUpdate((PlayerRecord) message.obj, message.arg1);
                    return;
                case 3:
                    MediaFocusControl.this.onReevaluateRemote();
                    return;
                case 4:
                case 6:
                case 7:
                case 8:
                default:
                    return;
                case 5:
                    MediaFocusControl.this.onRegisterVolumeObserverForRcc(message.arg1, (IRemoteVolumeObserver) message.obj);
                    return;
                case 9:
                    MediaFocusControl.this.onRcDisplayInitInfo((IRemoteControlDisplay) message.obj, message.arg1, message.arg2);
                    return;
                case 10:
                    MediaFocusControl.this.onReevaluateRemoteControlDisplays();
                    return;
                case 11:
                    MediaFocusControl.this.unregisterMediaButtonIntent((PendingIntent) message.obj);
                    return;
                case 12:
                    Log.d(MediaFocusControl.TAG, "MSG_RCC_SET_BROWSED_PLAYER: ");
                    MediaFocusControl.this.onSetRemoteControlClientBrowsedPlayer();
                    return;
                case 13:
                    Log.d(MediaFocusControl.TAG, "MSG_RCC_SET_PLAY_ITEM: " + ((Long) message.obj).longValue());
                    MediaFocusControl.this.onSetRemoteControlClientPlayItem(message.arg2, Long.valueOf(((Long) message.obj).longValue()));
                    return;
                case 14:
                    Log.d(MediaFocusControl.TAG, "MSG_RCC_GET_NOW_PLAYING_ENTRIES: ");
                    MediaFocusControl.this.onGetRemoteControlClientNowPlayingEntries();
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaFocusControl$NotificationListenerObserver.class */
    private class NotificationListenerObserver extends ContentObserver {
        NotificationListenerObserver() {
            super(MediaFocusControl.this.mEventHandler);
            MediaFocusControl.this.mContentResolver.registerContentObserver(Settings.Secure.getUriFor(Settings.Secure.ENABLED_NOTIFICATION_LISTENERS), false, this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            if (!MediaFocusControl.ENABLED_NOTIFICATION_LISTENERS_URI.equals(uri) || z) {
                return;
            }
            MediaFocusControl.this.postReevaluateRemoteControlDisplays();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MediaFocusControl(Looper looper, Context context, AudioService.VolumeController volumeController, AudioService audioService) {
        this.mEventHandler = new MediaEventHandler(looper);
        this.mContext = context;
        this.mContentResolver = this.mContext.getContentResolver();
        this.mVolumeController = volumeController;
        this.mAudioService = audioService;
        this.mMediaEventWakeLock = ((PowerManager) this.mContext.getSystemService(Context.POWER_SERVICE)).newWakeLock(1, "handleMediaEvent");
        ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.mPhoneStateListener, 32);
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService(Context.APP_OPS_SERVICE);
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService(Context.KEYGUARD_SERVICE);
        this.mNotifListenerObserver = new NotificationListenerObserver();
        this.mHasRemotePlayback = false;
        this.mMainRemoteIsActive = false;
        PlayerRecord.setMediaFocusControl(this);
        postReevaluateRemote();
    }

    private boolean canReassignAudioFocus() {
        return this.mFocusStack.isEmpty() || !isLockedFocusOwner(this.mFocusStack.peek());
    }

    private int checkRcdRegistrationAuthorization(ComponentName componentName) {
        if (this.mContext.checkCallingOrSelfPermission(Manifest.permission.MEDIA_CONTENT_CONTROL) == 0) {
            return 1;
        }
        if (componentName != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                String stringForUser = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), Settings.Secure.ENABLED_NOTIFICATION_LISTENERS, ActivityManager.getCurrentUser());
                if (stringForUser != null) {
                    String[] split = stringForUser.split(":");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= split.length) {
                            break;
                        }
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(split[i2]);
                        if (unflattenFromString != null && componentName.equals(unflattenFromString)) {
                            Binder.restoreCallingIdentity(clearCallingIdentity);
                            return 2;
                        }
                        i = i2 + 1;
                    }
                }
                return 0;
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return 0;
    }

    private void checkUpdateRemoteControlDisplay_syncPrs(int i) {
        if (this.mPRStack.isEmpty()) {
            clearRemoteControlDisplay_syncPrs();
        } else {
            updateRemoteControlDisplay_syncPrs(i);
        }
    }

    private void clearRemoteControlDisplay_syncPrs() {
        synchronized (this.mCurrentRcLock) {
            this.mCurrentRcClient = null;
        }
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(1));
    }

    private void dispatchMediaKeyEvent(KeyEvent keyEvent, boolean z) {
        if (z) {
            this.mMediaEventWakeLock.acquire();
        }
        Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON, (Uri) null);
        intent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
        synchronized (this.mPRStack) {
            if (this.mPRStack.empty()) {
                if (z) {
                    intent.putExtra(EXTRA_WAKELOCK_ACQUIRED, WAKELOCK_RELEASE_ON_FINISHED);
                }
                long clearCallingIdentity = Binder.clearCallingIdentity();
                this.mContext.sendOrderedBroadcastAsUser(intent, UserHandle.ALL, null, this.mKeyEventDone, this.mEventHandler, -1, null, null);
                Binder.restoreCallingIdentity(clearCallingIdentity);
            } else {
                try {
                    this.mPRStack.peek().getMediaButtonIntent().send(this.mContext, z ? WAKELOCK_RELEASE_ON_FINISHED : 0, intent, this, this.mEventHandler);
                } catch (PendingIntent.CanceledException e) {
                    Log.e(TAG, "Error sending pending intent " + this.mPRStack.peek());
                    e.printStackTrace();
                }
            }
        }
    }

    private void dispatchMediaKeyEventForCalls(KeyEvent keyEvent, boolean z) {
        Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON, (Uri) null);
        intent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
        intent.setPackage(this.mMediaReceiverForCalls.getPackageName());
        if (z) {
            this.mMediaEventWakeLock.acquire();
            intent.putExtra(EXTRA_WAKELOCK_ACQUIRED, WAKELOCK_RELEASE_ON_FINISHED);
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            this.mContext.sendOrderedBroadcastAsUser(intent, UserHandle.ALL, null, this.mKeyEventDone, this.mEventHandler, -1, null, null);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    private void dumpFocusStack(PrintWriter printWriter) {
        printWriter.println("\nAudio Focus stack entries (last is top of stack):");
        synchronized (mAudioFocusLock) {
            Iterator<FocusRequester> it = this.mFocusStack.iterator();
            while (it.hasNext()) {
                it.next().dump(printWriter);
            }
        }
        printWriter.println("\n Notify on duck: " + this.mNotifyFocusOwnerOnDuck + "\n");
    }

    private void dumpRCCStack(PrintWriter printWriter) {
        printWriter.println("\nRemote Control Client stack entries (last is top of stack):");
        synchronized (this.mPRStack) {
            Iterator<PlayerRecord> it = this.mPRStack.iterator();
            while (it.hasNext()) {
                it.next().dump(printWriter, false);
            }
            synchronized (this.mCurrentRcLock) {
                printWriter.println("\nCurrent remote control generation ID = " + this.mCurrentRcClientGen);
            }
        }
        synchronized (this.mMainRemote) {
            printWriter.println("\nRemote Volume State:");
            printWriter.println("  has remote: " + this.mHasRemotePlayback);
            printWriter.println("  is remote active: " + this.mMainRemoteIsActive);
            printWriter.println("  rccId: " + this.mMainRemote.mRccId);
            printWriter.println("  volume handling: " + (this.mMainRemote.mVolumeHandling == 0 ? "PLAYBACK_VOLUME_FIXED(0)" : "PLAYBACK_VOLUME_VARIABLE(1)"));
            printWriter.println("  volume: " + this.mMainRemote.mVolume);
            printWriter.println("  volume steps: " + this.mMainRemote.mVolumeMax);
        }
    }

    private void dumpRCDList(PrintWriter printWriter) {
        printWriter.println("\nRemote Control Display list entries:");
        synchronized (this.mPRStack) {
            Iterator<DisplayInfoForServer> it = this.mRcDisplays.iterator();
            while (it.hasNext()) {
                DisplayInfoForServer next = it.next();
                printWriter.println("  IRCD: " + next.mRcDisplay + "  -- w:" + next.mArtworkExpectedWidth + "  -- h:" + next.mArtworkExpectedHeight + "  -- wantsPosSync:" + next.mWantsPositionSync + "  -- " + (next.mEnabled ? "enabled" : "disabled"));
            }
        }
    }

    private void dumpRCStack(PrintWriter printWriter) {
        printWriter.println("\nRemote Control stack entries (last is top of stack):");
        synchronized (this.mPRStack) {
            Iterator<PlayerRecord> it = this.mPRStack.iterator();
            while (it.hasNext()) {
                it.next().dump(printWriter, true);
            }
        }
    }

    private void enableRemoteControlDisplayForClient_syncRcStack(IRemoteControlDisplay iRemoteControlDisplay, boolean z) {
        Iterator<PlayerRecord> it = this.mPRStack.iterator();
        while (it.hasNext()) {
            PlayerRecord next = it.next();
            if (next.getRcc() != null) {
                try {
                    next.getRcc().enableRemoteControlDisplay(iRemoteControlDisplay, z);
                } catch (RemoteException e) {
                    Log.e(TAG, "Error connecting RCD to client: ", e);
                }
            }
        }
    }

    private void filterMediaKeyEvent(KeyEvent keyEvent, boolean z) {
        if (!isValidMediaKeyEvent(keyEvent)) {
            Log.e(TAG, "not dispatching invalid media key event " + keyEvent);
            return;
        }
        synchronized (mRingingLock) {
            synchronized (this.mPRStack) {
                if (this.mMediaReceiverForCalls != null && (this.mIsRinging || this.mAudioService.getMode() == 2)) {
                    dispatchMediaKeyEventForCalls(keyEvent, z);
                } else if (isValidVoiceInputKeyCode(keyEvent.getKeyCode())) {
                    filterVoiceInputKeyEvent(keyEvent, z);
                } else {
                    dispatchMediaKeyEvent(keyEvent, z);
                }
            }
        }
    }

    private void filterVoiceInputKeyEvent(KeyEvent keyEvent, boolean z) {
        boolean z2;
        int action = keyEvent.getAction();
        synchronized (this.mVoiceEventLock) {
            if (action != 0) {
                z2 = true;
                if (action == 1) {
                    z2 = true;
                    if (this.mVoiceButtonDown) {
                        this.mVoiceButtonDown = false;
                        z2 = true;
                        if (!this.mVoiceButtonHandled) {
                            z2 = true;
                            if (!keyEvent.isCanceled()) {
                                z2 = true;
                            }
                        }
                    }
                }
            } else if (keyEvent.getRepeatCount() == 0) {
                this.mVoiceButtonDown = true;
                this.mVoiceButtonHandled = false;
                z2 = true;
            } else {
                z2 = true;
                if (this.mVoiceButtonDown) {
                    z2 = true;
                    if (!this.mVoiceButtonHandled) {
                        z2 = true;
                        if ((keyEvent.getFlags() & 128) != 0) {
                            this.mVoiceButtonHandled = true;
                            z2 = true;
                        }
                    }
                }
            }
        }
        switch (z2) {
            case true:
            default:
                return;
            case true:
                startVoiceBasedInteractions(z);
                return;
            case true:
                sendSimulatedMediaButtonEvent(keyEvent, z);
                return;
        }
    }

    private boolean isComponentInStringArray(ComponentName componentName, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String flattenToString = componentName.flattenToString();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return false;
            }
            if (flattenToString.equals(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private boolean isCurrentRcController(PendingIntent pendingIntent) {
        return !this.mPRStack.empty() && this.mPRStack.peek().hasMatchingMediaButtonIntent(pendingIntent);
    }

    private boolean isLockedFocusOwner(FocusRequester focusRequester) {
        return focusRequester.hasSameClient(IN_VOICE_COMM_FOCUS_ID) || focusRequester.isLockedFocusOwner();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isPlaystateActive(int i) {
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    private static boolean isValidMediaKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        return KeyEvent.isMediaKey(keyEvent.getKeyCode());
    }

    private static boolean isValidVoiceInputKeyCode(int i) {
        return i == 79;
    }

    private void notifyTopOfAudioFocusStack() {
        if (this.mFocusStack.empty() || !canReassignAudioFocus()) {
            return;
        }
        this.mFocusStack.peek().handleFocusGain(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetRemoteControlClientNowPlayingEntries() {
        Log.d(TAG, "onGetRemoteControlClientNowPlayingEntries: ");
        synchronized (this.mCurrentRcLock) {
            if (this.mCurrentRcClient != null) {
                try {
                    this.mCurrentRcClient.getNowPlayingEntries();
                } catch (RemoteException e) {
                    Log.e(TAG, "Current valid remote client is dead: " + e);
                    this.mCurrentRcClient = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRcDisplayClear() {
        synchronized (this.mPRStack) {
            synchronized (this.mCurrentRcLock) {
                this.mCurrentRcClientGen++;
                setNewRcClient_syncRcsCurrc(this.mCurrentRcClientGen, null, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRcDisplayInitInfo(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2) {
        synchronized (this.mPRStack) {
            synchronized (this.mCurrentRcLock) {
                if (this.mCurrentRcClient != null) {
                    try {
                        iRemoteControlDisplay.setCurrentClientId(this.mCurrentRcClientGen, this.mCurrentRcClientIntent, false);
                        try {
                            this.mCurrentRcClient.informationRequestForDisplay(iRemoteControlDisplay, i, i2);
                        } catch (RemoteException e) {
                            Log.e(TAG, "Current valid remote client is dead: ", e);
                            this.mCurrentRcClient = null;
                        }
                    } catch (RemoteException e2) {
                        Log.e(TAG, "Dead display in onRcDisplayInitInfo()", e2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRcDisplayUpdate(PlayerRecord playerRecord, int i) {
        synchronized (this.mPRStack) {
            synchronized (this.mCurrentRcLock) {
                if (this.mCurrentRcClient != null && this.mCurrentRcClient.equals(playerRecord.getRcc())) {
                    this.mCurrentRcClientGen++;
                    setNewRcClient_syncRcsCurrc(this.mCurrentRcClientGen, playerRecord.getMediaButtonIntent(), false);
                    try {
                        this.mCurrentRcClient.onInformationRequested(this.mCurrentRcClientGen, i);
                    } catch (RemoteException e) {
                        Log.e(TAG, "Current valid remote client is dead: " + e);
                        this.mCurrentRcClient = null;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReevaluateRemote() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReevaluateRemoteControlDisplays() {
        String stringForUser = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), Settings.Secure.ENABLED_NOTIFICATION_LISTENERS, ActivityManager.getCurrentUser());
        synchronized (mAudioFocusLock) {
            synchronized (this.mPRStack) {
                String[] split = stringForUser == null ? null : stringForUser.split(":");
                Iterator<DisplayInfoForServer> it = this.mRcDisplays.iterator();
                while (it.hasNext()) {
                    DisplayInfoForServer next = it.next();
                    if (next.mClientNotifListComp != null) {
                        boolean z = next.mEnabled;
                        next.mEnabled = isComponentInStringArray(next.mClientNotifListComp, split);
                        if (z != next.mEnabled) {
                            try {
                                next.mRcDisplay.setEnabled(next.mEnabled);
                                enableRemoteControlDisplayForClient_syncRcStack(next.mRcDisplay, next.mEnabled);
                                if (next.mEnabled) {
                                    sendMsg(this.mEventHandler, 9, 2, next.mArtworkExpectedWidth, next.mArtworkExpectedHeight, next.mRcDisplay, 0);
                                }
                            } catch (RemoteException e) {
                                Log.e(TAG, "Error en/disabling RCD: ", e);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        r0.mRemoteVolumeObs = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRegisterVolumeObserverForRcc(int r5, android.media.IRemoteVolumeObserver r6) {
        /*
            r4 = this;
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack
            r8 = r0
            r0 = r8
            monitor-enter(r0)
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L37 java.lang.Throwable -> L45
            int r0 = r0.size()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L37 java.lang.Throwable -> L45
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
        L13:
            r0 = r7
            if (r0 < 0) goto L33
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L37 java.lang.Throwable -> L45
            r1 = r7
            java.lang.Object r0 = r0.elementAt(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L37 java.lang.Throwable -> L45
            android.media.PlayerRecord r0 = (android.media.PlayerRecord) r0     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L37 java.lang.Throwable -> L45
            r9 = r0
            r0 = r9
            int r0 = r0.getRccId()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L37 java.lang.Throwable -> L45
            r1 = r5
            if (r0 != r1) goto L4b
            r0 = r9
            r1 = r6
            r0.mRemoteVolumeObs = r1     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L37 java.lang.Throwable -> L45
        L33:
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            return
        L37:
            r6 = move-exception
            java.lang.String r0 = "MediaFocusControl"
            java.lang.String r1 = "Wrong index accessing media button stack, lock error? "
            r2 = r6
            int r0 = android.util.Log.e(r0, r1, r2)     // Catch: java.lang.Throwable -> L45
            goto L33
        L45:
            r6 = move-exception
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            r0 = r6
            throw r0
        L4b:
            r0 = r7
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.MediaFocusControl.onRegisterVolumeObserverForRcc(int, android.media.IRemoteVolumeObserver):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetRemoteControlClientBrowsedPlayer() {
        Log.d(TAG, "onSetRemoteControlClientBrowsedPlayer: ");
        PlayerRecord peek = this.mPRStack.peek();
        if (peek.getRcc() == null) {
            Log.d(TAG, "can not proceed with setBrowsedPlayer");
            return;
        }
        Log.d(TAG, "proceed with setBrowsedPlayer");
        try {
            Log.d(TAG, "Calling setBrowsedPlayer");
            peek.getRcc().setBrowsedPlayer();
        } catch (RemoteException e) {
            Log.e(TAG, "Current valid remote client is dead: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetRemoteControlClientPlayItem(int i, Long l) {
        Log.d(TAG, "onSetRemoteControlClientPlayItem: " + l);
        synchronized (this.mCurrentRcLock) {
            if (this.mCurrentRcClient != null) {
                try {
                    this.mCurrentRcClient.setPlayItem(i, l.longValue());
                } catch (RemoteException e) {
                    Log.e(TAG, "Current valid remote client is dead: " + e);
                    this.mCurrentRcClient = null;
                }
            }
        }
    }

    private void plugRemoteControlDisplaysIntoClient_syncPrs(IRemoteControlClient iRemoteControlClient) {
        Iterator<DisplayInfoForServer> it = this.mRcDisplays.iterator();
        while (it.hasNext()) {
            DisplayInfoForServer next = it.next();
            try {
                iRemoteControlClient.plugRemoteControlDisplay(next.mRcDisplay, next.mArtworkExpectedWidth, next.mArtworkExpectedHeight);
                if (next.mWantsPositionSync) {
                    iRemoteControlClient.setWantsSyncForDisplay(next.mRcDisplay, true);
                }
            } catch (RemoteException e) {
                Log.e(TAG, "Error connecting RCD to RCC in RCC registration", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postReevaluateRemoteControlDisplays() {
        sendMsg(this.mEventHandler, 10, 2, 0, 0, null, 0);
    }

    private void propagateFocusLossFromGain_syncAf(int i) {
        Iterator<FocusRequester> it = this.mFocusStack.iterator();
        while (it.hasNext()) {
            it.next().handleExternalFocusGain(i);
        }
    }

    private int pushBelowLockedFocusOwners(FocusRequester focusRequester) {
        int size = this.mFocusStack.size();
        int size2 = this.mFocusStack.size();
        while (true) {
            int i = size2 - 1;
            if (i < 0) {
                break;
            }
            if (isLockedFocusOwner(this.mFocusStack.elementAt(i))) {
                size = i;
            }
            size2 = i;
        }
        if (size != this.mFocusStack.size()) {
            this.mFocusStack.insertElementAt(focusRequester, size);
            return 2;
        }
        Log.e(TAG, "No exclusive focus owner found in propagateFocusLossFromGain_syncAf()", new Exception());
        propagateFocusLossFromGain_syncAf(focusRequester.getGainRequest());
        this.mFocusStack.push(focusRequester);
        return 1;
    }

    private boolean pushMediaButtonReceiver_syncPrs(PendingIntent pendingIntent, ComponentName componentName, IBinder iBinder) {
        if (this.mPRStack.empty()) {
            this.mPRStack.push(new PlayerRecord(pendingIntent, componentName, iBinder));
            return true;
        } else if (this.mPRStack.peek().hasMatchingMediaButtonIntent(pendingIntent) || this.mAppOps.noteOp(31, Binder.getCallingUid(), pendingIntent.getCreatorPackage()) != 0) {
            return false;
        } else {
            this.mPRStack.lastElement();
            int size = this.mPRStack.size();
            int i = -1;
            try {
                int size2 = this.mPRStack.size() - 1;
                while (size2 >= 0) {
                    try {
                        PlayerRecord elementAt = this.mPRStack.elementAt(size2);
                        int i2 = size;
                        if (elementAt.isPlaybackActive()) {
                            i2 = size2;
                        }
                        if (elementAt.hasMatchingMediaButtonIntent(pendingIntent)) {
                            i = size2;
                        }
                        size2--;
                        size = i2;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e = e;
                        Log.e(TAG, "Wrong index (inStack=" + i + " lastPlaying=" + size + " size=" + this.mPRStack.size() + " accessing media button stack", e);
                        return false;
                    }
                }
                if (i == -1) {
                    int i3 = i;
                    this.mPRStack.add(size, new PlayerRecord(pendingIntent, componentName, iBinder));
                    return false;
                } else if (this.mPRStack.size() > 1) {
                    PlayerRecord elementAt2 = this.mPRStack.elementAt(i);
                    int i4 = i;
                    this.mPRStack.removeElementAt(i);
                    int i5 = i;
                    if (elementAt2.isPlaybackActive()) {
                        int i6 = i;
                        this.mPRStack.push(elementAt2);
                        return false;
                    } else if (i > size) {
                        this.mPRStack.add(size, elementAt2);
                        return false;
                    } else {
                        this.mPRStack.add(size - 1, elementAt2);
                        return false;
                    }
                } else {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                size = size;
                i = -1;
            }
        }
    }

    private boolean rcDisplayIsPluggedIn_syncRcStack(IRemoteControlDisplay iRemoteControlDisplay) {
        Iterator<DisplayInfoForServer> it = this.mRcDisplays.iterator();
        while (it.hasNext()) {
            if (it.next().mRcDisplay.asBinder().equals(iRemoteControlDisplay.asBinder())) {
                return true;
            }
        }
        return false;
    }

    private void registerRemoteControlDisplay_int(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2, ComponentName componentName) {
        synchronized (mAudioFocusLock) {
            synchronized (this.mPRStack) {
                if (iRemoteControlDisplay == null || rcDisplayIsPluggedIn_syncRcStack(iRemoteControlDisplay)) {
                    return;
                }
                DisplayInfoForServer displayInfoForServer = new DisplayInfoForServer(iRemoteControlDisplay, i, i2);
                displayInfoForServer.mEnabled = true;
                displayInfoForServer.mClientNotifListComp = componentName;
                if (displayInfoForServer.init()) {
                    this.mRcDisplays.add(displayInfoForServer);
                    Iterator<PlayerRecord> it = this.mPRStack.iterator();
                    while (it.hasNext()) {
                        PlayerRecord next = it.next();
                        if (next.getRcc() != null) {
                            try {
                                next.getRcc().plugRemoteControlDisplay(iRemoteControlDisplay, i, i2);
                            } catch (RemoteException e) {
                                Log.e(TAG, "Error connecting RCD to client: ", e);
                            }
                        }
                    }
                    sendMsg(this.mEventHandler, 9, 2, i, i2, iRemoteControlDisplay, 0);
                }
            }
        }
    }

    private void removeFocusStackEntry(String str, boolean z, boolean z2) {
        if (this.mFocusStack.empty() || !this.mFocusStack.peek().hasSameClient(str)) {
            Iterator<FocusRequester> it = this.mFocusStack.iterator();
            while (it.hasNext()) {
                FocusRequester next = it.next();
                if (next.hasSameClient(str)) {
                    Log.i(TAG, "AudioFocus  removeFocusStackEntry(): removing entry for " + str);
                    it.remove();
                    next.release();
                }
            }
            return;
        }
        FocusRequester pop = this.mFocusStack.pop();
        pop.release();
        if (z2) {
            AudioFocusInfo audioFocusInfo = pop.toAudioFocusInfo();
            audioFocusInfo.clearLossReceived();
            notifyExtPolicyFocusLoss_syncAf(audioFocusInfo, false);
        }
        if (z) {
            notifyTopOfAudioFocusStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFocusStackEntryForClient(IBinder iBinder) {
        boolean z = !this.mFocusStack.isEmpty() && this.mFocusStack.peek().hasSameBinder(iBinder);
        Iterator<FocusRequester> it = this.mFocusStack.iterator();
        while (it.hasNext()) {
            if (it.next().hasSameBinder(iBinder)) {
                Log.i(TAG, "AudioFocus  removeFocusStackEntry(): removing entry for " + iBinder);
                it.remove();
            }
        }
        if (z) {
            notifyTopOfAudioFocusStack();
        }
    }

    private void removeMediaButtonReceiver_syncPrs(PendingIntent pendingIntent) {
        try {
            int size = this.mPRStack.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                PlayerRecord elementAt = this.mPRStack.elementAt(i);
                if (elementAt.hasMatchingMediaButtonIntent(pendingIntent)) {
                    elementAt.destroy();
                    this.mPRStack.removeElementAt(i);
                    return;
                }
                size = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.e(TAG, "Wrong index accessing media button stack, lock error? ", e);
        }
    }

    private static void sendMsg(Handler handler, int i, int i2, int i3, int i4, Object obj, int i5) {
        if (i2 == 0) {
            handler.removeMessages(i);
        } else if (i2 == 1 && handler.hasMessages(i)) {
            return;
        }
        handler.sendMessageDelayed(handler.obtainMessage(i, i3, i4, obj), i5);
    }

    private void sendSimulatedMediaButtonEvent(KeyEvent keyEvent, boolean z) {
        dispatchMediaKeyEvent(KeyEvent.changeAction(keyEvent, 0), z);
        dispatchMediaKeyEvent(KeyEvent.changeAction(keyEvent, 1), z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        r8 = r0.mRemoteVolumeObs;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sendVolumeUpdateToRemote(int r5, int r6) {
        /*
            r4 = this;
            r0 = r6
            if (r0 != 0) goto L5
        L4:
            return
        L5:
            r0 = 0
            r9 = r0
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L7b
            int r0 = r0.size()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L7b
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
        L1b:
            r0 = r9
            r8 = r0
            r0 = r7
            if (r0 < 0) goto L40
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L7b
            r1 = r7
            java.lang.Object r0 = r0.elementAt(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L7b
            android.media.PlayerRecord r0 = (android.media.PlayerRecord) r0     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L7b
            r8 = r0
            r0 = r8
            int r0 = r0.getRccId()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L7b
            r1 = r5
            if (r0 != r1) goto L60
            r0 = r8
            android.media.IRemoteVolumeObserver r0 = r0.mRemoteVolumeObs     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L7b
            r8 = r0
        L40:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7b
            r0 = r8
            if (r0 == 0) goto L4
            r0 = r8
            r1 = r6
            r2 = -1
            r0.dispatchRemoteVolumeUpdate(r1, r2)     // Catch: android.os.RemoteException -> L52
            return
        L52:
            r8 = move-exception
            java.lang.String r0 = "MediaFocusControl"
            java.lang.String r1 = "Error dispatching relative volume update"
            r2 = r8
            int r0 = android.util.Log.e(r0, r1, r2)
            return
        L60:
            r0 = r7
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
            goto L1b
        L67:
            r8 = move-exception
            java.lang.String r0 = "MediaFocusControl"
            java.lang.String r1 = "Wrong index accessing media button stack, lock error? "
            r2 = r8
            int r0 = android.util.Log.e(r0, r1, r2)     // Catch: java.lang.Throwable -> L7b
            r0 = r9
            r8 = r0
            goto L40
        L7b:
            r8 = move-exception
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7b
            r0 = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.MediaFocusControl.sendVolumeUpdateToRemote(int, int):void");
    }

    private void setNewRcClientGenerationOnClients_syncRcsCurrc(int i) {
        Iterator<PlayerRecord> it = this.mPRStack.iterator();
        while (it.hasNext()) {
            PlayerRecord next = it.next();
            if (next != null && next.getRcc() != null) {
                try {
                    next.getRcc().setCurrentClientGenerationId(i);
                } catch (RemoteException e) {
                    Log.w(TAG, "Dead client in setNewRcClientGenerationOnClients_syncRcsCurrc()", e);
                    it.remove();
                    next.unlinkToRcClientDeath();
                }
            }
        }
    }

    private void setNewRcClientOnDisplays_syncRcsCurrc(int i, PendingIntent pendingIntent, boolean z) {
        synchronized (this.mPRStack) {
            if (this.mRcDisplays.size() > 0) {
                Iterator<DisplayInfoForServer> it = this.mRcDisplays.iterator();
                while (it.hasNext()) {
                    DisplayInfoForServer next = it.next();
                    try {
                        next.mRcDisplay.setCurrentClientId(i, pendingIntent, z);
                    } catch (RemoteException e) {
                        Log.e(TAG, "Dead display in setNewRcClientOnDisplays_syncRcsCurrc()", e);
                        next.release();
                        it.remove();
                    }
                }
            }
        }
    }

    private void setNewRcClient_syncRcsCurrc(int i, PendingIntent pendingIntent, boolean z) {
        setNewRcClientOnDisplays_syncRcsCurrc(i, pendingIntent, z);
        setNewRcClientGenerationOnClients_syncRcsCurrc(i);
    }

    private void startVoiceBasedInteractions(boolean z) {
        Intent intent;
        boolean z2 = true;
        PowerManager powerManager = (PowerManager) this.mContext.getSystemService(Context.POWER_SERVICE);
        boolean z3 = this.mKeyguardManager != null && this.mKeyguardManager.isKeyguardLocked();
        if (z3 || !powerManager.isScreenOn()) {
            intent = new Intent(RecognizerIntent.ACTION_VOICE_SEARCH_HANDS_FREE);
            if (!z3 || !this.mKeyguardManager.isKeyguardSecure()) {
                z2 = false;
            }
            intent.putExtra(RecognizerIntent.EXTRA_SECURE, z2);
            Log.i(TAG, "voice-based interactions: about to use ACTION_VOICE_SEARCH_HANDS_FREE");
        } else {
            intent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
            Log.i(TAG, "voice-based interactions: about to use ACTION_WEB_SEARCH");
        }
        if (z) {
            this.mMediaEventWakeLock.acquire();
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            if (intent != null) {
                try {
                    intent.setFlags(276824064);
                    this.mContext.startActivityAsUser(intent, UserHandle.CURRENT);
                } catch (ActivityNotFoundException e) {
                    Log.w(TAG, "No activity for search: " + e);
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    if (z) {
                        this.mMediaEventWakeLock.release();
                        return;
                    }
                    return;
                }
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
            if (z) {
                this.mMediaEventWakeLock.release();
            }
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            if (z) {
                this.mMediaEventWakeLock.release();
            }
            throw th;
        }
    }

    private void updateRemoteControlDisplay_syncPrs(int i) {
        PlayerRecord peek = this.mPRStack.peek();
        if (peek.getRcc() == null) {
            clearRemoteControlDisplay_syncPrs();
            return;
        }
        synchronized (this.mCurrentRcLock) {
            if (!peek.getRcc().equals(this.mCurrentRcClient)) {
                i = 15;
            }
            this.mCurrentRcClient = peek.getRcc();
            this.mCurrentRcClientIntent = peek.getMediaButtonIntent();
        }
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(2, i, 0, peek));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int abandonAudioFocus(IAudioFocusDispatcher iAudioFocusDispatcher, String str, AudioAttributes audioAttributes) {
        Log.i(TAG, " AudioFocus  abandonAudioFocus() from " + str);
        try {
            synchronized (mAudioFocusLock) {
                removeFocusStackEntry(str, true, true);
            }
            return 1;
        } catch (ConcurrentModificationException e) {
            Log.e(TAG, "FATAL EXCEPTION AudioFocus  abandonAudioFocus() caused " + e);
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFocusFollower(IAudioPolicyCallback iAudioPolicyCallback) {
        boolean z;
        if (iAudioPolicyCallback == null) {
            return;
        }
        synchronized (mAudioFocusLock) {
            Iterator<IAudioPolicyCallback> it = this.mFocusFollowers.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                } else if (it.next().asBinder().equals(iAudioPolicyCallback.asBinder())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            this.mFocusFollowers.add(iAudioPolicyCallback);
        }
    }

    protected boolean checkUpdateRemoteStateIfActive(int i) {
        synchronized (this.mPRStack) {
            try {
                int size = this.mPRStack.size();
                while (true) {
                    int i2 = size - 1;
                    if (i2 < 0) {
                        break;
                    }
                    PlayerRecord elementAt = this.mPRStack.elementAt(i2);
                    if (elementAt.mPlaybackType == 1 && isPlaystateActive(elementAt.mPlaybackState.mState) && elementAt.mPlaybackStream == i) {
                        synchronized (this.mMainRemote) {
                            this.mMainRemote.mRccId = elementAt.getRccId();
                            this.mMainRemote.mVolume = elementAt.mPlaybackVolume;
                            this.mMainRemote.mVolumeMax = elementAt.mPlaybackVolumeMax;
                            this.mMainRemote.mVolumeHandling = elementAt.mPlaybackVolumeHandling;
                            this.mMainRemoteIsActive = true;
                        }
                        return true;
                    }
                    size = i2;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.e(TAG, "Wrong index accessing RC stack, lock error? ", e);
            }
        }
        synchronized (this.mMainRemote) {
            this.mMainRemoteIsActive = false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void discardAudioFocusOwner() {
        synchronized (mAudioFocusLock) {
            if (!this.mFocusStack.empty()) {
                FocusRequester pop = this.mFocusStack.pop();
                pop.handleFocusLoss(-1);
                pop.release();
            }
        }
    }

    protected void dispatchMediaKeyEvent(KeyEvent keyEvent) {
        filterMediaKeyEvent(keyEvent, false);
    }

    protected void dispatchMediaKeyEventUnderWakelock(KeyEvent keyEvent) {
        filterMediaKeyEvent(keyEvent, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dump(PrintWriter printWriter) {
        dumpFocusStack(printWriter);
        dumpRCStack(printWriter);
        dumpRCCStack(printWriter);
        dumpRCDList(printWriter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCurrentAudioFocus() {
        synchronized (mAudioFocusLock) {
            if (this.mFocusStack.empty()) {
                return 0;
            }
            return this.mFocusStack.peek().getGainRequest();
        }
    }

    public void getRemoteControlClientNowPlayingEntries() {
        sendMsg(this.mEventHandler, 14, 0, 0, 0, 0, 0);
    }

    protected int getRemoteStreamMaxVolume() {
        synchronized (this.mMainRemote) {
            if (this.mMainRemote.mRccId == -1) {
                return 0;
            }
            return this.mMainRemote.mVolumeMax;
        }
    }

    protected int getRemoteStreamVolume() {
        synchronized (this.mMainRemote) {
            if (this.mMainRemote.mRccId == -1) {
                return 0;
            }
            return this.mMainRemote.mVolume;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean mustNotifyFocusOwnerOnDuck() {
        return this.mNotifyFocusOwnerOnDuck;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyExtPolicyFocusGrant_syncAf(AudioFocusInfo audioFocusInfo, int i) {
        Iterator<IAudioPolicyCallback> it = this.mFocusFollowers.iterator();
        while (it.hasNext()) {
            IAudioPolicyCallback next = it.next();
            try {
                next.notifyAudioFocusGrant(audioFocusInfo, i);
            } catch (RemoteException e) {
                Log.e(TAG, "Can't call newAudioFocusLoser() on IAudioPolicyCallback " + next.asBinder(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyExtPolicyFocusLoss_syncAf(AudioFocusInfo audioFocusInfo, boolean z) {
        Iterator<IAudioPolicyCallback> it = this.mFocusFollowers.iterator();
        while (it.hasNext()) {
            IAudioPolicyCallback next = it.next();
            try {
                next.notifyAudioFocusLoss(audioFocusInfo, z);
            } catch (RemoteException e) {
                Log.e(TAG, "Can't call newAudioFocusLoser() on IAudioPolicyCallback " + next.asBinder(), e);
            }
        }
    }

    @Override // android.app.PendingIntent.OnFinished
    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
        if (i == WAKELOCK_RELEASE_ON_FINISHED) {
            this.mMediaEventWakeLock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postReevaluateRemote() {
        sendMsg(this.mEventHandler, 3, 2, 0, 0, null, 0);
    }

    protected void registerMediaButtonEventReceiverForCalls(ComponentName componentName) {
        if (this.mContext.checkCallingPermission(Manifest.permission.MODIFY_PHONE_STATE) != 0) {
            Log.e(TAG, "Invalid permissions to register media button receiver for calls");
            return;
        }
        synchronized (this.mPRStack) {
            this.mMediaReceiverForCalls = componentName;
        }
    }

    protected void registerMediaButtonIntent(PendingIntent pendingIntent, ComponentName componentName, IBinder iBinder) {
        Log.i(TAG, "  Remote Control   registerMediaButtonIntent() for " + pendingIntent);
        synchronized (this.mPRStack) {
            if (pushMediaButtonReceiver_syncPrs(pendingIntent, componentName, iBinder)) {
                checkUpdateRemoteControlDisplay_syncPrs(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        r0.resetControllerInfoForRcc(r7, r8, android.os.Binder.getCallingUid());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r7 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        r0 = r0.getRccId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
        if (r5.mRcDisplays.size() <= 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
        plugRemoteControlDisplaysIntoClient_syncPrs(r0.getRcc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0099, code lost:
        r10 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int registerRemoteControlClient(android.app.PendingIntent r6, android.media.IRemoteControlClient r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = -1
            r11 = r0
            r0 = r5
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack
            r13 = r0
            r0 = r13
            monitor-enter(r0)
            r0 = r11
            r9 = r0
            r0 = r5
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            int r0 = r0.size()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            r1 = 1
            int r0 = r0 - r1
            r12 = r0
        L1b:
            r0 = r11
            r10 = r0
            r0 = r12
            if (r0 < 0) goto L59
            r0 = r11
            r9 = r0
            r0 = r5
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            r1 = r12
            java.lang.Object r0 = r0.elementAt(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            android.media.PlayerRecord r0 = (android.media.PlayerRecord) r0     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            r14 = r0
            r0 = r11
            r9 = r0
            r0 = r14
            r1 = r6
            boolean r0 = r0.hasMatchingMediaButtonIntent(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            if (r0 == 0) goto Lb6
            r0 = r11
            r9 = r0
            r0 = r14
            r1 = r7
            r2 = r8
            int r3 = android.os.Binder.getCallingUid()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            r0.resetControllerInfoForRcc(r1, r2, r3)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            r0 = r7
            if (r0 != 0) goto L6d
            r0 = r11
            r10 = r0
        L59:
            r0 = r5
            r1 = r6
            boolean r0 = r0.isCurrentRcController(r1)     // Catch: java.lang.Throwable -> Lb0
            if (r0 == 0) goto L67
            r0 = r5
            r1 = 15
            r0.checkUpdateRemoteControlDisplay_syncPrs(r1)     // Catch: java.lang.Throwable -> Lb0
        L67:
            r0 = r13
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb0
            r0 = r10
            return r0
        L6d:
            r0 = r11
            r9 = r0
            r0 = r14
            int r0 = r0.getRccId()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            r9 = r0
            r0 = r5
            java.util.ArrayList<android.media.MediaFocusControl$DisplayInfoForServer> r0 = r0.mRcDisplays     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            int r0 = r0.size()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            if (r0 <= 0) goto L59
            r0 = r11
            r9 = r0
            r0 = r5
            r1 = r14
            android.media.IRemoteControlClient r1 = r1.getRcc()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            r0.plugRemoteControlDisplaysIntoClient_syncPrs(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L9e java.lang.Throwable -> Lb0
            r0 = r11
            r10 = r0
            goto L59
        L9e:
            r7 = move-exception
            java.lang.String r0 = "MediaFocusControl"
            java.lang.String r1 = "Wrong index accessing RC stack, lock error? "
            r2 = r7
            int r0 = android.util.Log.e(r0, r1, r2)     // Catch: java.lang.Throwable -> Lb0
            r0 = r9
            r10 = r0
            goto L59
        Lb0:
            r6 = move-exception
            r0 = r13
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb0
            r0 = r6
            throw r0
        Lb6:
            r0 = r12
            r1 = 1
            int r0 = r0 - r1
            r12 = r0
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.MediaFocusControl.registerRemoteControlClient(android.app.PendingIntent, android.media.IRemoteControlClient, java.lang.String):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean registerRemoteControlDisplay(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2) {
        if (checkRcdRegistrationAuthorization(null) != 0) {
            registerRemoteControlDisplay_int(iRemoteControlDisplay, i, i2, null);
            return true;
        }
        Slog.w(TAG, "Access denied to process: " + Binder.getCallingPid() + ", must have permission " + Manifest.permission.MEDIA_CONTENT_CONTROL + " to register IRemoteControlDisplay");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean registerRemoteController(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2, ComponentName componentName) {
        if (checkRcdRegistrationAuthorization(componentName) != 0) {
            registerRemoteControlDisplay_int(iRemoteControlDisplay, i, i2, componentName);
            return true;
        }
        Slog.w(TAG, "Access denied to process: " + Binder.getCallingPid() + ", must have permission " + Manifest.permission.MEDIA_CONTENT_CONTROL + " or be an enabled NotificationListenerService for registerRemoteController");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2) {
        synchronized (this.mPRStack) {
            Iterator<DisplayInfoForServer> it = this.mRcDisplays.iterator();
            boolean z = false;
            while (it.hasNext() && !z) {
                DisplayInfoForServer next = it.next();
                if (next.mRcDisplay.asBinder().equals(iRemoteControlDisplay.asBinder()) && (next.mArtworkExpectedWidth != i || next.mArtworkExpectedHeight != i2)) {
                    next.mArtworkExpectedWidth = i;
                    next.mArtworkExpectedHeight = i2;
                    z = true;
                }
            }
            if (z) {
                Iterator<PlayerRecord> it2 = this.mPRStack.iterator();
                while (it2.hasNext()) {
                    PlayerRecord next2 = it2.next();
                    if (next2.getRcc() != null) {
                        try {
                            next2.getRcc().setBitmapSizeForDisplay(iRemoteControlDisplay, i, i2);
                        } catch (RemoteException e) {
                            Log.e(TAG, "Error setting bitmap size for RCD on RCC: ", e);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void remoteControlDisplayWantsPlaybackPositionSync(IRemoteControlDisplay iRemoteControlDisplay, boolean z) {
        boolean z2;
        synchronized (this.mPRStack) {
            Iterator<DisplayInfoForServer> it = this.mRcDisplays.iterator();
            while (true) {
                z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                DisplayInfoForServer next = it.next();
                if (next.mRcDisplay.asBinder().equals(iRemoteControlDisplay.asBinder())) {
                    next.mWantsPositionSync = z;
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                Iterator<PlayerRecord> it2 = this.mPRStack.iterator();
                while (it2.hasNext()) {
                    PlayerRecord next2 = it2.next();
                    if (next2.getRcc() != null) {
                        try {
                            next2.getRcc().setWantsSyncForDisplay(iRemoteControlDisplay, z);
                        } catch (RemoteException e) {
                            Log.e(TAG, "Error setting position sync flag for RCD on RCC: ", e);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFocusFollower(IAudioPolicyCallback iAudioPolicyCallback) {
        if (iAudioPolicyCallback == null) {
            return;
        }
        synchronized (mAudioFocusLock) {
            Iterator<IAudioPolicyCallback> it = this.mFocusFollowers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IAudioPolicyCallback next = it.next();
                if (next.asBinder().equals(iAudioPolicyCallback.asBinder())) {
                    this.mFocusFollowers.remove(next);
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int requestAudioFocus(AudioAttributes audioAttributes, int i, IBinder iBinder, IAudioFocusDispatcher iAudioFocusDispatcher, String str, String str2, int i2) {
        Log.i(TAG, " AudioFocus  requestAudioFocus() from " + str + " req=" + i + "flags=0x" + Integer.toHexString(i2));
        if (!iBinder.pingBinder()) {
            Log.e(TAG, " AudioFocus DOA client for requestAudioFocus(), aborting.");
            return 0;
        } else if (this.mAppOps.noteOp(32, Binder.getCallingUid(), str2) != 0) {
            return 0;
        } else {
            synchronized (mAudioFocusLock) {
                boolean z = false;
                if (!canReassignAudioFocus()) {
                    if ((i2 & 1) == 0) {
                        return 0;
                    }
                    z = true;
                }
                AudioFocusDeathHandler audioFocusDeathHandler = new AudioFocusDeathHandler(iBinder);
                try {
                    iBinder.linkToDeath(audioFocusDeathHandler, 0);
                    if (!this.mFocusStack.empty() && this.mFocusStack.peek().hasSameClient(str)) {
                        FocusRequester peek = this.mFocusStack.peek();
                        if (peek.getGainRequest() == i && peek.getGrantFlags() == i2) {
                            iBinder.unlinkToDeath(audioFocusDeathHandler, 0);
                            notifyExtPolicyFocusGrant_syncAf(peek.toAudioFocusInfo(), 1);
                            return 1;
                        } else if (!z) {
                            this.mFocusStack.pop();
                            peek.release();
                        }
                    }
                    removeFocusStackEntry(str, false, false);
                    FocusRequester focusRequester = new FocusRequester(audioAttributes, i, i2, iAudioFocusDispatcher, iBinder, str, audioFocusDeathHandler, str2, Binder.getCallingUid(), this);
                    if (z) {
                        int pushBelowLockedFocusOwners = pushBelowLockedFocusOwners(focusRequester);
                        if (pushBelowLockedFocusOwners != 0) {
                            notifyExtPolicyFocusGrant_syncAf(focusRequester.toAudioFocusInfo(), pushBelowLockedFocusOwners);
                        }
                        return pushBelowLockedFocusOwners;
                    }
                    if (!this.mFocusStack.empty()) {
                        propagateFocusLossFromGain_syncAf(i);
                    }
                    this.mFocusStack.push(focusRequester);
                    notifyExtPolicyFocusGrant_syncAf(focusRequester.toAudioFocusInfo(), 1);
                    return 1;
                } catch (RemoteException e) {
                    Log.w(TAG, "AudioFocus  requestAudioFocus() could not link to " + iBinder + " binder death");
                    return 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDuckingInExtPolicyAvailable(boolean z) {
        this.mNotifyFocusOwnerOnDuck = !z;
    }

    public void setRemoteControlClientBrowsedPlayer() {
        Log.d(TAG, "setRemoteControlClientBrowsedPlayer: ");
        sendMsg(this.mEventHandler, 12, 0, 0, 0, 0, 0);
    }

    public void setRemoteControlClientPlayItem(long j, int i) {
        sendMsg(this.mEventHandler, 13, 0, 0, i, new Long(j), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        r8 = r0.mRemoteVolumeObs;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setRemoteStreamVolume(int r5) {
        /*
            r4 = this;
            r0 = r4
            android.media.PlayerRecord$RemotePlaybackState r0 = r0.mMainRemote
            r8 = r0
            r0 = r8
            monitor-enter(r0)
            r0 = r4
            android.media.PlayerRecord$RemotePlaybackState r0 = r0.mMainRemote     // Catch: java.lang.Throwable -> L7e
            int r0 = r0.mRccId     // Catch: java.lang.Throwable -> L7e
            r1 = -1
            if (r0 != r1) goto L18
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            return
        L18:
            r0 = r4
            android.media.PlayerRecord$RemotePlaybackState r0 = r0.mMainRemote     // Catch: java.lang.Throwable -> L7e
            int r0 = r0.mRccId     // Catch: java.lang.Throwable -> L7e
            r7 = r0
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r0 = 0
            r9 = r0
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8d java.lang.Throwable -> La1
            int r0 = r0.size()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8d java.lang.Throwable -> La1
            r1 = 1
            int r0 = r0 - r1
            r6 = r0
        L39:
            r0 = r9
            r8 = r0
            r0 = r6
            if (r0 < 0) goto L5e
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8d java.lang.Throwable -> La1
            r1 = r6
            java.lang.Object r0 = r0.elementAt(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8d java.lang.Throwable -> La1
            android.media.PlayerRecord r0 = (android.media.PlayerRecord) r0     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8d java.lang.Throwable -> La1
            r8 = r0
            r0 = r8
            int r0 = r0.getRccId()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8d java.lang.Throwable -> La1
            r1 = r7
            if (r0 != r1) goto L86
            r0 = r8
            android.media.IRemoteVolumeObserver r0 = r0.mRemoteVolumeObs     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L8d java.lang.Throwable -> La1
            r8 = r0
        L5e:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La1
            r0 = r8
            if (r0 == 0) goto La9
            r0 = r8
            r1 = 0
            r2 = r5
            r0.dispatchRemoteVolumeUpdate(r1, r2)     // Catch: android.os.RemoteException -> L70
            return
        L70:
            r8 = move-exception
            java.lang.String r0 = "MediaFocusControl"
            java.lang.String r1 = "Error dispatching absolute volume update"
            r2 = r8
            int r0 = android.util.Log.e(r0, r1, r2)
            return
        L7e:
            r9 = move-exception
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r0 = r9
            throw r0
        L86:
            r0 = r6
            r1 = 1
            int r0 = r0 - r1
            r6 = r0
            goto L39
        L8d:
            r8 = move-exception
            java.lang.String r0 = "MediaFocusControl"
            java.lang.String r1 = "Wrong index accessing media button stack, lock error? "
            r2 = r8
            int r0 = android.util.Log.e(r0, r1, r2)     // Catch: java.lang.Throwable -> La1
            r0 = r9
            r8 = r0
            goto L5e
        La1:
            r8 = move-exception
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La1
            r0 = r8
            throw r0
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.MediaFocusControl.setRemoteStreamVolume(int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterAudioFocusClient(String str) {
        synchronized (mAudioFocusLock) {
            removeFocusStackEntry(str, false, true);
        }
    }

    protected void unregisterMediaButtonEventReceiverForCalls() {
        if (this.mContext.checkCallingPermission(Manifest.permission.MODIFY_PHONE_STATE) != 0) {
            Log.e(TAG, "Invalid permissions to unregister media button receiver for calls");
            return;
        }
        synchronized (this.mPRStack) {
            this.mMediaReceiverForCalls = null;
        }
    }

    protected void unregisterMediaButtonIntent(PendingIntent pendingIntent) {
        Log.i(TAG, "  Remote Control   unregisterMediaButtonIntent() for " + pendingIntent);
        synchronized (this.mPRStack) {
            boolean isCurrentRcController = isCurrentRcController(pendingIntent);
            removeMediaButtonReceiver_syncPrs(pendingIntent);
            if (isCurrentRcController) {
                checkUpdateRemoteControlDisplay_syncPrs(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterMediaButtonIntentAsync(PendingIntent pendingIntent) {
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(11, 0, 0, pendingIntent));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        r0.resetControllerInfoForNoRcc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
        if (r0 != (r4.mPRStack.size() - 1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
        r7 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void unregisterRemoteControlClient(android.app.PendingIntent r5, android.media.IRemoteControlClient r6) {
        /*
            r4 = this;
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = 0
            r9 = r0
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            int r0 = r0.size()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
        L17:
            r0 = r9
            r7 = r0
            r0 = r8
            if (r0 < 0) goto L59
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            r1 = r8
            java.lang.Object r0 = r0.elementAt(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            android.media.PlayerRecord r0 = (android.media.PlayerRecord) r0     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            r11 = r0
            r0 = r11
            r1 = r5
            boolean r0 = r0.hasMatchingMediaButtonIntent(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            if (r0 == 0) goto L83
            r0 = r6
            r1 = r11
            android.media.IRemoteControlClient r1 = r1.getRcc()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            boolean r0 = r0.equals(r1)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            if (r0 == 0) goto L83
            r0 = r11
            r0.resetControllerInfoForNoRcc()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            r0 = r4
            java.util.Stack<android.media.PlayerRecord> r0 = r0.mPRStack     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            int r0 = r0.size()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L67 java.lang.Throwable -> L78
            r7 = r0
            r0 = r8
            r1 = r7
            r2 = 1
            int r1 = r1 - r2
            if (r0 != r1) goto L7e
            r0 = 1
            r7 = r0
        L59:
            r0 = r7
            if (r0 == 0) goto L63
            r0 = r4
            r1 = 15
            r0.checkUpdateRemoteControlDisplay_syncPrs(r1)     // Catch: java.lang.Throwable -> L78
        L63:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L78
            return
        L67:
            r5 = move-exception
            java.lang.String r0 = "MediaFocusControl"
            java.lang.String r1 = "Wrong index accessing RC stack, lock error? "
            r2 = r5
            int r0 = android.util.Log.e(r0, r1, r2)     // Catch: java.lang.Throwable -> L78
            r0 = r9
            r7 = r0
            goto L59
        L78:
            r5 = move-exception
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L78
            r0 = r5
            throw r0
        L7e:
            r0 = 0
            r7 = r0
            goto L59
        L83:
            r0 = r8
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.MediaFocusControl.unregisterRemoteControlClient(android.app.PendingIntent, android.media.IRemoteControlClient):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterRemoteControlDisplay(IRemoteControlDisplay iRemoteControlDisplay) {
        synchronized (this.mPRStack) {
            if (iRemoteControlDisplay == null) {
                return;
            }
            boolean z = false;
            Iterator<DisplayInfoForServer> it = this.mRcDisplays.iterator();
            while (it.hasNext() && !z) {
                DisplayInfoForServer next = it.next();
                if (next.mRcDisplay.asBinder().equals(iRemoteControlDisplay.asBinder())) {
                    z = true;
                    next.release();
                    it.remove();
                }
            }
            if (z) {
                Iterator<PlayerRecord> it2 = this.mPRStack.iterator();
                while (it2.hasNext()) {
                    PlayerRecord next2 = it2.next();
                    if (next2.getRcc() != null) {
                        try {
                            next2.getRcc().unplugRemoteControlDisplay(iRemoteControlDisplay);
                        } catch (RemoteException e) {
                            Log.e(TAG, "Error disconnecting remote control display to client: ", e);
                        }
                    }
                }
            }
        }
    }
}
