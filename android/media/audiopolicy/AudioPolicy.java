package android.media.audiopolicy;

import android.Manifest;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusInfo;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.IAudioService;
import android.media.audiopolicy.IAudioPolicyCallback;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Slog;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioPolicy.class */
public class AudioPolicy {
    private static final boolean DEBUG = false;
    public static final int FOCUS_POLICY_DUCKING_DEFAULT = 0;
    public static final int FOCUS_POLICY_DUCKING_IN_APP = 0;
    public static final int FOCUS_POLICY_DUCKING_IN_POLICY = 1;
    private static final int MSG_FOCUS_GRANT = 1;
    private static final int MSG_FOCUS_LOSS = 2;
    private static final int MSG_POLICY_STATUS_CHANGE = 0;
    public static final int POLICY_STATUS_REGISTERED = 2;
    public static final int POLICY_STATUS_UNREGISTERED = 1;
    private static final String TAG = "AudioPolicy";
    private static IAudioService sService;
    private AudioPolicyConfig mConfig;
    private Context mContext;
    private final EventHandler mEventHandler;
    private AudioPolicyFocusListener mFocusListener;
    private final Object mLock;
    private final IAudioPolicyCallback mPolicyCb;
    private String mRegistrationId;
    private int mStatus;
    private AudioPolicyStatusListener mStatusListener;

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioPolicy$AudioPolicyFocusListener.class */
    public static abstract class AudioPolicyFocusListener {
        public void onAudioFocusGrant(AudioFocusInfo audioFocusInfo, int i) {
        }

        public void onAudioFocusLoss(AudioFocusInfo audioFocusInfo, boolean z) {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioPolicy$AudioPolicyStatusListener.class */
    public static abstract class AudioPolicyStatusListener {
        public void onMixStateUpdate(AudioMix audioMix) {
        }

        public void onStatusChange() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioPolicy$Builder.class */
    public static class Builder {
        private Context mContext;
        private AudioPolicyFocusListener mFocusListener;
        private Looper mLooper;
        private ArrayList<AudioMix> mMixes = new ArrayList<>();
        private AudioPolicyStatusListener mStatusListener;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder addMix(AudioMix audioMix) throws IllegalArgumentException {
            if (audioMix == null) {
                throw new IllegalArgumentException("Illegal null AudioMix argument");
            }
            this.mMixes.add(audioMix);
            return this;
        }

        public AudioPolicy build() {
            return new AudioPolicy(new AudioPolicyConfig(this.mMixes), this.mContext, this.mLooper, this.mFocusListener, this.mStatusListener);
        }

        public void setAudioPolicyFocusListener(AudioPolicyFocusListener audioPolicyFocusListener) {
            this.mFocusListener = audioPolicyFocusListener;
        }

        public void setAudioPolicyStatusListener(AudioPolicyStatusListener audioPolicyStatusListener) {
            this.mStatusListener = audioPolicyStatusListener;
        }

        public Builder setLooper(Looper looper) throws IllegalArgumentException {
            if (looper == null) {
                throw new IllegalArgumentException("Illegal null Looper argument");
            }
            this.mLooper = looper;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioPolicy$EventHandler.class */
    public class EventHandler extends Handler {
        public EventHandler(AudioPolicy audioPolicy, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    AudioPolicy.this.onPolicyStatusChange();
                    return;
                case 1:
                    if (AudioPolicy.this.mFocusListener != null) {
                        AudioPolicy.this.mFocusListener.onAudioFocusGrant((AudioFocusInfo) message.obj, message.arg1);
                        return;
                    }
                    return;
                case 2:
                    if (AudioPolicy.this.mFocusListener != null) {
                        AudioPolicy.this.mFocusListener.onAudioFocusLoss((AudioFocusInfo) message.obj, message.arg1 != 0);
                        return;
                    }
                    return;
                default:
                    Log.e(AudioPolicy.TAG, "Unknown event " + message.what);
                    return;
            }
        }
    }

    private AudioPolicy(AudioPolicyConfig audioPolicyConfig, Context context, Looper looper, AudioPolicyFocusListener audioPolicyFocusListener, AudioPolicyStatusListener audioPolicyStatusListener) {
        this.mLock = new Object();
        this.mPolicyCb = new IAudioPolicyCallback.Stub() { // from class: android.media.audiopolicy.AudioPolicy.1
            @Override // android.media.audiopolicy.IAudioPolicyCallback
            public void notifyAudioFocusGrant(AudioFocusInfo audioFocusInfo, int i) {
                AudioPolicy.this.sendMsg(1, audioFocusInfo, i);
            }

            @Override // android.media.audiopolicy.IAudioPolicyCallback
            public void notifyAudioFocusLoss(AudioFocusInfo audioFocusInfo, boolean z) {
                AudioPolicy.this.sendMsg(2, audioFocusInfo, z ? 1 : 0);
            }
        };
        this.mConfig = audioPolicyConfig;
        this.mStatus = 1;
        this.mContext = context;
        Looper mainLooper = looper == null ? Looper.getMainLooper() : looper;
        if (mainLooper != null) {
            this.mEventHandler = new EventHandler(this, mainLooper);
        } else {
            this.mEventHandler = null;
            Log.e(TAG, "No event handler due to looper without a thread");
        }
        this.mFocusListener = audioPolicyFocusListener;
        this.mStatusListener = audioPolicyStatusListener;
    }

    private static String addressForTag(AudioMix audioMix) {
        return "addr=" + audioMix.getRegistration();
    }

    private void checkMixReadyToUse(AudioMix audioMix, boolean z) throws IllegalArgumentException {
        if (audioMix == null) {
            throw new IllegalArgumentException(z ? "Invalid null AudioMix for AudioTrack creation" : "Invalid null AudioMix for AudioRecord creation");
        } else if (!this.mConfig.mMixes.contains(audioMix)) {
            throw new IllegalArgumentException("Invalid mix: not part of this policy");
        } else {
            if ((audioMix.getRouteFlags() & 2) != 2) {
                throw new IllegalArgumentException("Invalid AudioMix: not defined for loop back");
            }
            if (z && audioMix.getMixType() != 1) {
                throw new IllegalArgumentException("Invalid AudioMix: not defined for being a recording source");
            }
            if (!z && audioMix.getMixType() != 0) {
                throw new IllegalArgumentException("Invalid AudioMix: not defined for capturing playback");
            }
        }
    }

    private static IAudioService getService() {
        if (sService != null) {
            return sService;
        }
        sService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
        return sService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPolicyStatusChange() {
        synchronized (this.mLock) {
            if (this.mStatusListener == null) {
                return;
            }
            this.mStatusListener.onStatusChange();
        }
    }

    private boolean policyReadyToUse() {
        synchronized (this.mLock) {
            if (this.mStatus != 2) {
                Log.e(TAG, "Cannot use unregistered AudioPolicy");
                return false;
            } else if (this.mContext == null) {
                Log.e(TAG, "Cannot use AudioPolicy without context");
                return false;
            } else if (this.mRegistrationId == null) {
                Log.e(TAG, "Cannot use unregistered AudioPolicy");
                return false;
            } else if (this.mContext.checkCallingOrSelfPermission(Manifest.permission.MODIFY_AUDIO_ROUTING) != 0) {
                Slog.w(TAG, "Cannot use AudioPolicy for pid " + Binder.getCallingPid() + " / uid " + Binder.getCallingUid() + ", needs MODIFY_AUDIO_ROUTING");
                return false;
            } else {
                return true;
            }
        }
    }

    private void sendMsg(int i) {
        if (this.mEventHandler != null) {
            this.mEventHandler.sendEmptyMessage(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsg(int i, Object obj, int i2) {
        if (this.mEventHandler != null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(i, i2, 0, obj));
        }
    }

    public IAudioPolicyCallback cb() {
        return this.mPolicyCb;
    }

    public AudioRecord createAudioRecordSink(AudioMix audioMix) throws IllegalArgumentException {
        if (!policyReadyToUse()) {
            Log.e(TAG, "Cannot create AudioRecord sink for AudioMix");
            return null;
        }
        checkMixReadyToUse(audioMix, false);
        return new AudioRecord(new AudioAttributes.Builder().setInternalCapturePreset(8).addTag(addressForTag(audioMix)).build(), new AudioFormat.Builder(audioMix.getFormat()).setChannelMask(AudioFormat.inChannelMaskFromOutChannelMask(audioMix.getFormat().getChannelMask())).build(), AudioRecord.getMinBufferSize(audioMix.getFormat().getSampleRate(), 12, audioMix.getFormat().getEncoding()), 0);
    }

    public AudioTrack createAudioTrackSource(AudioMix audioMix) throws IllegalArgumentException {
        if (policyReadyToUse()) {
            checkMixReadyToUse(audioMix, true);
            return new AudioTrack(new AudioAttributes.Builder().setUsage(15).addTag(addressForTag(audioMix)).build(), audioMix.getFormat(), AudioTrack.getMinBufferSize(audioMix.getFormat().getSampleRate(), audioMix.getFormat().getChannelMask(), audioMix.getFormat().getEncoding()), 1, 0);
        }
        Log.e(TAG, "Cannot create AudioTrack source for AudioMix");
        return null;
    }

    public AudioPolicyConfig getConfig() {
        return this.mConfig;
    }

    public int getFocusDuckingBehavior() {
        return this.mConfig.mDuckingPolicy;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean hasFocusListener() {
        return this.mFocusListener != null;
    }

    public int setFocusDuckingBehavior(int i) throws IllegalArgumentException, IllegalStateException {
        int focusPropertiesForPolicy;
        if (i == 0 || i == 1) {
            synchronized (this.mLock) {
                if (this.mStatus != 2) {
                    throw new IllegalStateException("Cannot change ducking behavior for unregistered policy");
                }
                if (i == 1 && this.mFocusListener == null) {
                    throw new IllegalStateException("Cannot handle ducking without an audio focus listener");
                }
                try {
                    focusPropertiesForPolicy = getService().setFocusPropertiesForPolicy(i, cb());
                    if (focusPropertiesForPolicy == 0) {
                        this.mConfig.mDuckingPolicy = i;
                    }
                } catch (RemoteException e) {
                    Log.e(TAG, "Dead object in setFocusPropertiesForPolicy for behavior", e);
                    return -1;
                }
            }
            return focusPropertiesForPolicy;
        }
        throw new IllegalArgumentException("Invalid ducking behavior " + i);
    }

    public void setRegistration(String str) {
        synchronized (this.mLock) {
            this.mRegistrationId = str;
            this.mConfig.setRegistration(str);
            if (str != null) {
                this.mStatus = 2;
            } else {
                this.mStatus = 1;
            }
        }
        sendMsg(0);
    }

    public String toLogFriendlyString() {
        return new String("android.media.audiopolicy.AudioPolicy:\n") + "config=" + this.mConfig.toLogFriendlyString();
    }
}
