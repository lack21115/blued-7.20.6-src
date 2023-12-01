package android.media;

import android.app.ActivityThread;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.IAudioService;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioRecord.class */
public class AudioRecord {
    private static final int AUDIORECORD_ERROR_SETUP_INVALIDCHANNELMASK = -17;
    private static final int AUDIORECORD_ERROR_SETUP_INVALIDFORMAT = -18;
    private static final int AUDIORECORD_ERROR_SETUP_INVALIDSOURCE = -19;
    private static final int AUDIORECORD_ERROR_SETUP_NATIVEINITFAILED = -20;
    private static final int AUDIORECORD_ERROR_SETUP_ZEROFRAMECOUNT = -16;
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -2;
    public static final int ERROR_INVALID_OPERATION = -3;
    private static final int NATIVE_EVENT_MARKER = 2;
    private static final int NATIVE_EVENT_NEW_POS = 3;
    public static final int RECORDSTATE_RECORDING = 3;
    public static final int RECORDSTATE_STOPPED = 1;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_UNINITIALIZED = 0;
    public static final String SUBMIX_FIXED_VOLUME = "fixedVolume";
    public static final int SUCCESS = 0;
    private static final String TAG = "android.media.AudioRecord";
    private AudioAttributes mAudioAttributes;
    private int mAudioFormat;
    private int mChannelCount;
    private int mChannelMask;
    private NativeEventHandler mEventHandler;
    private final IBinder mICallBack;
    private Looper mInitializationLooper;
    private boolean mIsSubmixFullVolume;
    private int mNativeBufferSizeInBytes;
    private long mNativeCallbackCookie;
    private long mNativeRecorderInJavaObj;
    private OnRecordPositionUpdateListener mPositionListener;
    private final Object mPositionListenerLock;
    private int mRecordSource;
    private int mRecordingState;
    private final Object mRecordingStateLock;
    private int mSampleRate;
    private int mSessionId;
    private int mState;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioRecord$NativeEventHandler.class */
    public class NativeEventHandler extends Handler {
        private final AudioRecord mAudioRecord;

        NativeEventHandler(AudioRecord audioRecord, Looper looper) {
            super(looper);
            this.mAudioRecord = audioRecord;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OnRecordPositionUpdateListener onRecordPositionUpdateListener;
            synchronized (AudioRecord.this.mPositionListenerLock) {
                onRecordPositionUpdateListener = this.mAudioRecord.mPositionListener;
            }
            switch (message.what) {
                case 2:
                    if (onRecordPositionUpdateListener != null) {
                        onRecordPositionUpdateListener.onMarkerReached(this.mAudioRecord);
                        return;
                    }
                    return;
                case 3:
                    if (onRecordPositionUpdateListener != null) {
                        onRecordPositionUpdateListener.onPeriodicNotification(this.mAudioRecord);
                        return;
                    }
                    return;
                default:
                    AudioRecord.loge("Unknown native event type: " + message.what);
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioRecord$OnRecordPositionUpdateListener.class */
    public interface OnRecordPositionUpdateListener {
        void onMarkerReached(AudioRecord audioRecord);

        void onPeriodicNotification(AudioRecord audioRecord);
    }

    public AudioRecord(int i, int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this(new AudioAttributes.Builder().setInternalCapturePreset(i).build(), new AudioFormat.Builder().setChannelMask(getChannelMaskFromLegacyConfig(i3, true)).setEncoding(i4).setSampleRate(i2).build(), i5, 0);
    }

    public AudioRecord(AudioAttributes audioAttributes, AudioFormat audioFormat, int i, int i2) throws IllegalArgumentException {
        int i3;
        this.mState = 0;
        this.mRecordingState = 1;
        this.mRecordingStateLock = new Object();
        this.mPositionListener = null;
        this.mPositionListenerLock = new Object();
        this.mEventHandler = null;
        this.mInitializationLooper = null;
        this.mNativeBufferSizeInBytes = 0;
        this.mSessionId = 0;
        this.mIsSubmixFullVolume = false;
        this.mICallBack = new Binder();
        this.mRecordingState = 1;
        if (audioAttributes == null) {
            throw new IllegalArgumentException("Illegal null AudioAttributes");
        }
        if (audioFormat == null) {
            throw new IllegalArgumentException("Illegal null AudioFormat");
        }
        Looper myLooper = Looper.myLooper();
        this.mInitializationLooper = myLooper;
        if (myLooper == null) {
            this.mInitializationLooper = Looper.getMainLooper();
        }
        if (audioAttributes.getCapturePreset() == 8) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            for (String str : audioAttributes.getTags()) {
                if (str.equalsIgnoreCase(SUBMIX_FIXED_VOLUME)) {
                    this.mIsSubmixFullVolume = true;
                    Log.v(TAG, "Will record from REMOTE_SUBMIX at full fixed volume");
                } else {
                    builder.addTag(str);
                }
            }
            builder.setInternalCapturePreset(audioAttributes.getCapturePreset());
            this.mAudioAttributes = builder.build();
        } else {
            this.mAudioAttributes = audioAttributes;
        }
        if ((audioFormat.getPropertySetMask() & 2) != 0) {
            i3 = audioFormat.getSampleRate();
        } else {
            int primaryOutputSamplingRate = AudioSystem.getPrimaryOutputSamplingRate();
            i3 = primaryOutputSamplingRate;
            if (primaryOutputSamplingRate <= 0) {
                i3 = 44100;
            }
        }
        audioParamCheck(audioAttributes.getCapturePreset(), i3, (audioFormat.getPropertySetMask() & 1) != 0 ? audioFormat.getEncoding() : 1);
        this.mChannelCount = AudioFormat.channelCountFromInChannelMask(audioFormat.getChannelMask());
        this.mChannelMask = getChannelMaskFromLegacyConfig(audioFormat.getChannelMask(), false);
        audioBuffSizeCheck(i);
        int[] iArr = {i2};
        int native_setup = native_setup(new WeakReference(this), this.mAudioAttributes, this.mSampleRate, this.mChannelMask, this.mAudioFormat, this.mNativeBufferSizeInBytes, iArr);
        if (native_setup != 0) {
            loge("Error code " + native_setup + " when initializing native AudioRecord object.");
            return;
        }
        this.mSessionId = iArr[0];
        this.mState = 1;
    }

    private void audioBuffSizeCheck(int i) throws IllegalArgumentException {
        int bytesPerSample = this.mChannelCount * AudioFormat.getBytesPerSample(this.mAudioFormat);
        int i2 = bytesPerSample;
        if (this.mRecordSource == 7) {
            i2 = bytesPerSample;
            if (this.mAudioFormat != 2) {
                i2 = this.mChannelCount * 1;
            }
        }
        if (i % i2 != 0 || i < 1) {
            throw new IllegalArgumentException("Invalid audio buffer size.");
        }
        this.mNativeBufferSizeInBytes = i;
    }

    private void audioParamCheck(int i, int i2, int i3) throws IllegalArgumentException {
        if (i < 0 || !(i <= MediaRecorder.getAudioSourceMax() || i == 1998 || i == 1999)) {
            throw new IllegalArgumentException("Invalid audio source.");
        }
        this.mRecordSource = i;
        if (i2 < 4000 || i2 > 48000) {
            throw new IllegalArgumentException(i2 + "Hz is not a supported sample rate.");
        }
        this.mSampleRate = i2;
        switch (i3) {
            case 1:
                this.mAudioFormat = 2;
                return;
            case 2:
            case 3:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
                this.mAudioFormat = i3;
                return;
            default:
                throw new IllegalArgumentException("Unsupported sample encoding. Should be ENCODING_PCM_8BIT or ENCODING_PCM_16BIT.");
        }
    }

    private static int getChannelMaskFromLegacyConfig(int i, boolean z) {
        int i2;
        switch (i) {
            case 1:
            case 2:
            case 16:
                i2 = 16;
                break;
            case 3:
            case 12:
                i2 = 12;
                break;
            case 48:
                i2 = i;
                break;
            default:
                throw new IllegalArgumentException("Unsupported channel configuration.");
        }
        if (z || !(i == 2 || i == 3)) {
            return i2;
        }
        throw new IllegalArgumentException("Unsupported deprecated configuration.");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getMinBufferSize(int r4, int r5, int r6) {
        /*
            r0 = r5
            switch(r0) {
                case 1: goto L4f;
                case 2: goto L4f;
                case 3: goto L83;
                case 12: goto L83;
                case 16: goto L4f;
                case 48: goto L83;
                case 252: goto L88;
                default: goto L44;
            }
        L44:
            java.lang.String r0 = "getMinBufferSize(): Invalid channel configuration."
            loge(r0)
            r0 = -2
            r4 = r0
        L4d:
            r0 = r4
            return r0
        L4f:
            r0 = 1
            r5 = r0
        L51:
            r0 = r6
            r1 = 2
            if (r0 == r1) goto L8e
            r0 = r6
            r1 = 100
            if (r0 == r1) goto L8e
            r0 = r6
            r1 = 101(0x65, float:1.42E-43)
            if (r0 == r1) goto L8e
            r0 = r6
            r1 = 102(0x66, float:1.43E-43)
            if (r0 == r1) goto L8e
            r0 = r6
            r1 = 103(0x67, float:1.44E-43)
            if (r0 == r1) goto L8e
            r0 = r6
            r1 = 104(0x68, float:1.46E-43)
            if (r0 == r1) goto L8e
            r0 = r6
            r1 = 105(0x69, float:1.47E-43)
            if (r0 == r1) goto L8e
            java.lang.String r0 = "getMinBufferSize(): Invalid audio format."
            loge(r0)
            r0 = -2
            return r0
        L83:
            r0 = 2
            r5 = r0
            goto L51
        L88:
            r0 = 6
            r5 = r0
            goto L51
        L8e:
            r0 = r4
            r1 = r5
            r2 = r6
            int r0 = native_get_min_buff_size(r0, r1, r2)
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L9c
            r0 = -2
            return r0
        L9c:
            r0 = r5
            r4 = r0
            r0 = r5
            r1 = -1
            if (r0 != r1) goto L4d
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.AudioRecord.getMinBufferSize(int, int, int):int");
    }

    private void handleFullVolumeRec(boolean z) {
        if (this.mIsSubmixFullVolume) {
            try {
                IAudioService.Stub.asInterface(ServiceManager.getService("audio")).forceRemoteSubmixFullVolume(z, this.mICallBack);
            } catch (RemoteException e) {
                Log.e(TAG, "Error talking to AudioService when handling full submix volume", e);
            }
        }
    }

    private void handleHotwordInput(boolean z) {
        try {
            IAudioService.Stub.asInterface(ServiceManager.getService("audio")).handleHotwordInput(z);
        } catch (RemoteException e) {
            Log.e(TAG, "Error talking to AudioService when handling hotword input.", e);
        }
    }

    private boolean isAudioRecordAllowed() {
        return native_check_permission(ActivityThread.currentPackageName()) == 0;
    }

    private static void logd(String str) {
        Log.d(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loge(String str) {
        Log.e(TAG, str);
    }

    private final native int native_check_permission(String str);

    private final native void native_finalize();

    private final native int native_get_marker_pos();

    private static final native int native_get_min_buff_size(int i, int i2, int i3);

    private final native int native_get_pos_update_period();

    private final native int native_read_in_byte_array(byte[] bArr, int i, int i2);

    private final native int native_read_in_direct_buffer(Object obj, int i);

    private final native int native_read_in_short_array(short[] sArr, int i, int i2);

    private final native void native_release();

    private final native int native_set_marker_pos(int i);

    private final native int native_set_pos_update_period(int i);

    private final native int native_setup(Object obj, Object obj2, int i, int i2, int i3, int i4, int[] iArr);

    private final native int native_start(int i, int i2);

    private final native void native_stop();

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        AudioRecord audioRecord = (AudioRecord) ((WeakReference) obj).get();
        if (audioRecord == null || audioRecord.mEventHandler == null) {
            return;
        }
        audioRecord.mEventHandler.sendMessage(audioRecord.mEventHandler.obtainMessage(i, i2, i3, obj2));
    }

    protected void finalize() {
        release();
    }

    public int getAudioFormat() {
        return this.mAudioFormat;
    }

    public int getAudioSessionId() {
        return this.mSessionId;
    }

    public int getAudioSource() {
        return this.mRecordSource;
    }

    public int getChannelConfiguration() {
        return this.mChannelMask;
    }

    public int getChannelCount() {
        return this.mChannelCount;
    }

    public int getNotificationMarkerPosition() {
        return native_get_marker_pos();
    }

    public int getPositionNotificationPeriod() {
        return native_get_pos_update_period();
    }

    public int getRecordingState() {
        int i;
        synchronized (this.mRecordingStateLock) {
            i = this.mRecordingState;
        }
        return i;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int getState() {
        return this.mState;
    }

    public int read(ByteBuffer byteBuffer, int i) {
        if (this.mState != 1) {
            return -3;
        }
        if (byteBuffer == null || i < 0) {
            return -2;
        }
        return native_read_in_direct_buffer(byteBuffer, i);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.mState != 1) {
            return -3;
        }
        if (bArr == null || i < 0 || i2 < 0 || i + i2 < 0 || i + i2 > bArr.length) {
            return -2;
        }
        return native_read_in_byte_array(bArr, i, i2);
    }

    public int read(short[] sArr, int i, int i2) {
        if (this.mState != 1) {
            return -3;
        }
        if (sArr == null || i < 0 || i2 < 0 || i + i2 < 0 || i + i2 > sArr.length) {
            return -2;
        }
        return native_read_in_short_array(sArr, i, i2);
    }

    public void release() {
        try {
            stop();
        } catch (IllegalStateException e) {
        }
        native_release();
        this.mState = 0;
    }

    public int setNotificationMarkerPosition(int i) {
        if (this.mState == 0) {
            return -3;
        }
        return native_set_marker_pos(i);
    }

    public int setPositionNotificationPeriod(int i) {
        if (this.mState == 0) {
            return -3;
        }
        return native_set_pos_update_period(i);
    }

    public void setRecordPositionUpdateListener(OnRecordPositionUpdateListener onRecordPositionUpdateListener) {
        setRecordPositionUpdateListener(onRecordPositionUpdateListener, null);
    }

    public void setRecordPositionUpdateListener(OnRecordPositionUpdateListener onRecordPositionUpdateListener, Handler handler) {
        synchronized (this.mPositionListenerLock) {
            this.mPositionListener = onRecordPositionUpdateListener;
            if (onRecordPositionUpdateListener == null) {
                this.mEventHandler = null;
            } else if (handler != null) {
                this.mEventHandler = new NativeEventHandler(this, handler.getLooper());
            } else {
                this.mEventHandler = new NativeEventHandler(this, this.mInitializationLooper);
            }
        }
    }

    public void startRecording() throws IllegalStateException {
        if (!isAudioRecordAllowed()) {
            Log.e(TAG, "User permission denied!");
        } else if (this.mState != 1) {
            throw new IllegalStateException("startRecording() called on an uninitialized AudioRecord.");
        } else {
            synchronized (this.mRecordingStateLock) {
                if (native_start(0, 0) == 0) {
                    handleFullVolumeRec(true);
                    this.mRecordingState = 3;
                }
            }
            if (getRecordingState() == 3 && getAudioSource() == 1999) {
                handleHotwordInput(true);
            }
        }
    }

    public void startRecording(MediaSyncEvent mediaSyncEvent) throws IllegalStateException {
        if (!isAudioRecordAllowed()) {
            Log.e(TAG, "User permission denied!");
        } else if (this.mState != 1) {
            throw new IllegalStateException("startRecording() called on an uninitialized AudioRecord.");
        } else {
            synchronized (this.mRecordingStateLock) {
                if (native_start(mediaSyncEvent.getType(), mediaSyncEvent.getAudioSessionId()) == 0) {
                    handleFullVolumeRec(true);
                    this.mRecordingState = 3;
                }
            }
        }
    }

    public void stop() throws IllegalStateException {
        if (this.mState != 1) {
            throw new IllegalStateException("stop() called on an uninitialized AudioRecord.");
        }
        synchronized (this.mRecordingStateLock) {
            handleFullVolumeRec(false);
            native_stop();
            this.mRecordingState = 1;
        }
        if (getAudioSource() == 1999) {
            handleHotwordInput(false);
        }
    }
}
