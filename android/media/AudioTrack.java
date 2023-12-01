package android.media;

import android.app.ActivityThread;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.opengl.GLES30;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.android.internal.app.IAppOpsService;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.NioUtils;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioTrack.class */
public class AudioTrack {
    private static final int CHANNEL_COUNT_MAX = 8;
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -2;
    public static final int ERROR_INVALID_OPERATION = -3;
    private static final int ERROR_NATIVESETUP_AUDIOSYSTEM = -16;
    private static final int ERROR_NATIVESETUP_INVALIDCHANNELMASK = -17;
    private static final int ERROR_NATIVESETUP_INVALIDFORMAT = -18;
    private static final int ERROR_NATIVESETUP_INVALIDSTREAMTYPE = -19;
    private static final int ERROR_NATIVESETUP_NATIVEINITFAILED = -20;
    private static final float GAIN_MAX = 1.0f;
    private static final float GAIN_MIN = 0.0f;
    public static final int MODE_STATIC = 0;
    public static final int MODE_STREAM = 1;
    private static final int NATIVE_EVENT_MARKER = 3;
    private static final int NATIVE_EVENT_NEW_POS = 4;
    public static final int PLAYSTATE_PAUSED = 2;
    public static final int PLAYSTATE_PLAYING = 3;
    public static final int PLAYSTATE_STOPPED = 1;
    private static final int SAMPLE_RATE_HZ_MAX = 96000;
    private static final int SAMPLE_RATE_HZ_MIN = 4000;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_NO_STATIC_DATA = 2;
    public static final int STATE_UNINITIALIZED = 0;
    public static final int SUCCESS = 0;
    private static final int SUPPORTED_OUT_CHANNELS = 7420;
    private static final String TAG = "android.media.AudioTrack";
    public static final int WRITE_BLOCKING = 0;
    public static final int WRITE_NON_BLOCKING = 1;
    private final IAppOpsService mAppOps;
    private final AudioAttributes mAttributes;
    private int mAudioFormat;
    private int mChannelConfiguration;
    private int mChannelCount;
    private int mChannels;
    private int mDataLoadMode;
    private NativeEventHandlerDelegate mEventHandlerDelegate;
    private final Looper mInitializationLooper;
    private long mJniData;
    private int mNativeBufferSizeInBytes;
    private int mNativeBufferSizeInFrames;
    private long mNativeTrackInJavaObj;
    private int mPlayState;
    private final Object mPlayStateLock;
    private int mSampleRate;
    private int mSessionId;
    private int mState;
    private int mStreamType;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioTrack$NativeEventHandlerDelegate.class */
    public class NativeEventHandlerDelegate {
        private final Handler mHandler;

        NativeEventHandlerDelegate(final AudioTrack audioTrack, final OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener, Handler handler) {
            Looper looper = handler != null ? handler.getLooper() : AudioTrack.this.mInitializationLooper;
            if (looper != null) {
                this.mHandler = new Handler(looper) { // from class: android.media.AudioTrack.NativeEventHandlerDelegate.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        if (audioTrack == null) {
                            return;
                        }
                        switch (message.what) {
                            case 3:
                                if (onPlaybackPositionUpdateListener != null) {
                                    onPlaybackPositionUpdateListener.onMarkerReached(audioTrack);
                                    return;
                                }
                                return;
                            case 4:
                                if (onPlaybackPositionUpdateListener != null) {
                                    onPlaybackPositionUpdateListener.onPeriodicNotification(audioTrack);
                                    return;
                                }
                                return;
                            default:
                                AudioTrack.loge("Unknown native event type: " + message.what);
                                return;
                        }
                    }
                };
            } else {
                this.mHandler = null;
            }
        }

        Handler getHandler() {
            return this.mHandler;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioTrack$OnPlaybackPositionUpdateListener.class */
    public interface OnPlaybackPositionUpdateListener {
        void onMarkerReached(AudioTrack audioTrack);

        void onPeriodicNotification(AudioTrack audioTrack);
    }

    public AudioTrack(int i, int i2, int i3, int i4, int i5, int i6) throws IllegalArgumentException {
        this(i, i2, i3, i4, i5, i6, 0);
    }

    public AudioTrack(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        this(new AudioAttributes.Builder().setLegacyStreamType(i).build(), new AudioFormat.Builder().setChannelMask(i3).setEncoding(i4).setSampleRate(i2).build(), i5, i6, i7);
    }

    public AudioTrack(AudioAttributes audioAttributes, AudioFormat audioFormat, int i, int i2, int i3) throws IllegalArgumentException {
        int i4;
        this.mState = 0;
        this.mPlayState = 1;
        this.mPlayStateLock = new Object();
        this.mNativeBufferSizeInBytes = 0;
        this.mNativeBufferSizeInFrames = 0;
        this.mChannelCount = 1;
        this.mChannels = 4;
        this.mStreamType = 3;
        this.mDataLoadMode = 1;
        this.mChannelConfiguration = 4;
        this.mAudioFormat = 2;
        this.mSessionId = 0;
        if (audioAttributes == null) {
            throw new IllegalArgumentException("Illegal null AudioAttributes");
        }
        if (audioFormat == null) {
            throw new IllegalArgumentException("Illegal null AudioFormat");
        }
        Looper myLooper = Looper.myLooper();
        Looper mainLooper = myLooper == null ? Looper.getMainLooper() : myLooper;
        if ((audioFormat.getPropertySetMask() & 2) != 0) {
            i4 = audioFormat.getSampleRate();
        } else {
            int primaryOutputSamplingRate = AudioSystem.getPrimaryOutputSamplingRate();
            i4 = primaryOutputSamplingRate;
            if (primaryOutputSamplingRate <= 0) {
                i4 = 44100;
            }
        }
        audioParamCheck(i4, (audioFormat.getPropertySetMask() & 4) != 0 ? audioFormat.getChannelMask() : 12, (audioFormat.getPropertySetMask() & 1) != 0 ? audioFormat.getEncoding() : 1, i2);
        this.mStreamType = -1;
        audioBuffSizeCheck(i);
        this.mInitializationLooper = mainLooper;
        this.mAppOps = IAppOpsService.Stub.asInterface(ServiceManager.getService(Context.APP_OPS_SERVICE));
        this.mAttributes = new AudioAttributes.Builder(audioAttributes).build();
        if (i3 < 0) {
            throw new IllegalArgumentException("Invalid audio session ID: " + i3);
        }
        int[] iArr = {i3};
        int native_setup = native_setup(new WeakReference(this), this.mAttributes, this.mSampleRate, this.mChannels, this.mAudioFormat, this.mNativeBufferSizeInBytes, this.mDataLoadMode, iArr);
        if (native_setup != 0) {
            loge("Error code " + native_setup + " when initializing AudioTrack.");
            return;
        }
        this.mSessionId = iArr[0];
        if (this.mDataLoadMode == 0) {
            this.mState = 2;
        } else {
            this.mState = 1;
        }
    }

    private void audioBuffSizeCheck(int i) {
        int bytesPerSample = AudioFormat.isEncodingLinearPcm(this.mAudioFormat) ? this.mChannelCount * AudioFormat.getBytesPerSample(this.mAudioFormat) : 1;
        if (i % bytesPerSample != 0 || i < 1) {
            throw new IllegalArgumentException("Invalid audio buffer size.");
        }
        this.mNativeBufferSizeInBytes = i;
        this.mNativeBufferSizeInFrames = i / bytesPerSample;
    }

    private void audioParamCheck(int i, int i2, int i3, int i4) {
        if (i < 4000 || i > SAMPLE_RATE_HZ_MAX) {
            throw new IllegalArgumentException(i + "Hz is not a supported sample rate.");
        }
        this.mSampleRate = i;
        this.mChannelConfiguration = i2;
        switch (i2) {
            case 1:
            case 2:
            case 4:
                this.mChannelCount = 1;
                this.mChannels = 4;
                break;
            case 3:
            case 12:
                this.mChannelCount = 2;
                this.mChannels = 12;
                break;
            default:
                if (!isMultichannelConfigSupported(i2)) {
                    throw new IllegalArgumentException("Unsupported channel configuration.");
                }
                this.mChannels = i2;
                this.mChannelCount = Integer.bitCount(i2);
                break;
        }
        int i5 = i3;
        if (i3 == 1) {
            i5 = 2;
        }
        if (!AudioFormat.isValidEncoding(i5)) {
            throw new IllegalArgumentException("Unsupported audio encoding.");
        }
        this.mAudioFormat = i5;
        if ((i4 != 1 && i4 != 0) || (i4 != 1 && !AudioFormat.isEncodingLinearPcm(this.mAudioFormat))) {
            throw new IllegalArgumentException("Invalid mode.");
        }
        this.mDataLoadMode = i4;
    }

    private static float clampGainOrLevel(float f) {
        float f2;
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException();
        }
        if (f < 0.0f) {
            f2 = 0.0f;
        } else {
            f2 = f;
            if (f > 1.0f) {
                return 1.0f;
            }
        }
        return f2;
    }

    public static float getMaxVolume() {
        return 1.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getMinBufferSize(int r4, int r5, int r6) {
        /*
            r0 = -2
            r7 = r0
            r0 = r5
            switch(r0) {
                case 2: goto L43;
                case 3: goto L55;
                case 4: goto L43;
                case 12: goto L55;
                default: goto L30;
            }
        L30:
            r0 = r5
            r1 = 7420(0x1cfc, float:1.0398E-41)
            r0 = r0 & r1
            r1 = r5
            if (r0 == r1) goto L5a
            java.lang.String r0 = "getMinBufferSize(): Invalid channel configuration."
            loge(r0)
            r0 = r7
            r4 = r0
        L41:
            r0 = r4
            return r0
        L43:
            r0 = 1
            r5 = r0
        L45:
            r0 = r6
            boolean r0 = android.media.AudioFormat.isValidEncoding(r0)
            if (r0 != 0) goto L62
            java.lang.String r0 = "getMinBufferSize(): Invalid audio format."
            loge(r0)
            r0 = -2
            return r0
        L55:
            r0 = 2
            r5 = r0
            goto L45
        L5a:
            r0 = r5
            int r0 = java.lang.Integer.bitCount(r0)
            r5 = r0
            goto L45
        L62:
            r0 = r4
            r1 = 4000(0xfa0, float:5.605E-42)
            if (r0 < r1) goto L6f
            r0 = r4
            r1 = 96000(0x17700, float:1.34525E-40)
            if (r0 <= r1) goto L8f
        L6f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "getMinBufferSize(): "
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = " Hz is not a supported sample rate."
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            loge(r0)
            r0 = -2
            return r0
        L8f:
            r0 = r4
            r1 = r5
            r2 = r6
            int r0 = native_get_min_buff_size(r0, r1, r2)
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r5
            if (r0 > 0) goto L41
            java.lang.String r0 = "getMinBufferSize(): error querying hardware"
            loge(r0)
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.AudioTrack.getMinBufferSize(int, int, int):int");
    }

    public static float getMinVolume() {
        return 0.0f;
    }

    public static int getNativeOutputSampleRate(int i) {
        return native_get_output_sample_rate(i);
    }

    private static boolean isMultichannelConfigSupported(int i) {
        if ((i & SUPPORTED_OUT_CHANNELS) != i) {
            loge("Channel configuration features unsupported channels");
            return false;
        }
        int bitCount = Integer.bitCount(i);
        if (bitCount > 8) {
            loge("Channel configuration contains too many channels " + bitCount + SimpleComparison.GREATER_THAN_OPERATION + 8);
            return false;
        } else if ((i & 12) != 12) {
            loge("Front channels must be present in multichannel configurations");
            return false;
        } else if ((i & 192) != 0 && (i & 192) != 192) {
            loge("Rear channels can't be used independently");
            return false;
        } else if ((i & GLES30.GL_COLOR) == 0 || (i & GLES30.GL_COLOR) == 6144) {
            return true;
        } else {
            loge("Side channels can't be used independently");
            return false;
        }
    }

    private boolean isRestricted() {
        boolean z = false;
        try {
            if (this.mAppOps.checkAudioOperation(28, AudioAttributes.usageForLegacyStreamType(this.mStreamType), Process.myUid(), ActivityThread.currentPackageName()) != 0) {
                z = true;
            }
            return z;
        } catch (RemoteException e) {
            return false;
        }
    }

    private static void logd(String str) {
        Log.d(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loge(String str) {
        Log.e(TAG, str);
    }

    private final native int native_attachAuxEffect(int i);

    private final native void native_finalize();

    private final native void native_flush();

    private final native int native_get_latency();

    private final native int native_get_marker_pos();

    private static final native int native_get_min_buff_size(int i, int i2, int i3);

    private final native int native_get_native_frame_count();

    private static final native int native_get_output_sample_rate(int i);

    private final native int native_get_playback_rate();

    private final native int native_get_pos_update_period();

    private final native int native_get_position();

    private final native int native_get_timestamp(long[] jArr);

    private final native void native_pause();

    private final native void native_release();

    private final native int native_reload_static();

    private final native int native_setAuxEffectSendLevel(float f);

    private final native void native_setVolume(float f, float f2);

    private final native int native_set_loop(int i, int i2, int i3);

    private final native int native_set_marker_pos(int i);

    private final native int native_set_playback_rate(int i);

    private final native int native_set_pos_update_period(int i);

    private final native int native_set_position(int i);

    private final native int native_setup(Object obj, Object obj2, int i, int i2, int i3, int i4, int i5, int[] iArr);

    private final native void native_start();

    private final native void native_stop();

    private final native int native_write_byte(byte[] bArr, int i, int i2, int i3, boolean z);

    private final native int native_write_float(float[] fArr, int i, int i2, int i3, boolean z);

    private final native int native_write_native_bytes(Object obj, int i, int i2, int i3, boolean z);

    private final native int native_write_short(short[] sArr, int i, int i2, int i3);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        NativeEventHandlerDelegate nativeEventHandlerDelegate;
        Handler handler;
        AudioTrack audioTrack = (AudioTrack) ((WeakReference) obj).get();
        if (audioTrack == null || (nativeEventHandlerDelegate = audioTrack.mEventHandlerDelegate) == null || (handler = nativeEventHandlerDelegate.getHandler()) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(i, i2, i3, obj2));
    }

    public int attachAuxEffect(int i) {
        if (this.mState == 0) {
            return -3;
        }
        return native_attachAuxEffect(i);
    }

    protected void finalize() {
        native_finalize();
    }

    public void flush() {
        if (this.mState == 1) {
            native_flush();
        }
    }

    public int getAudioFormat() {
        return this.mAudioFormat;
    }

    public int getAudioSessionId() {
        return this.mSessionId;
    }

    public int getChannelConfiguration() {
        return this.mChannelConfiguration;
    }

    public int getChannelCount() {
        return this.mChannelCount;
    }

    public int getLatency() {
        return native_get_latency();
    }

    @Deprecated
    protected int getNativeFrameCount() {
        return native_get_native_frame_count();
    }

    public int getNotificationMarkerPosition() {
        return native_get_marker_pos();
    }

    public int getPlayState() {
        int i;
        synchronized (this.mPlayStateLock) {
            i = this.mPlayState;
        }
        return i;
    }

    public int getPlaybackHeadPosition() {
        return native_get_position();
    }

    public int getPlaybackRate() {
        return native_get_playback_rate();
    }

    public int getPositionNotificationPeriod() {
        return native_get_pos_update_period();
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int getState() {
        return this.mState;
    }

    public int getStreamType() {
        return this.mStreamType;
    }

    public boolean getTimestamp(AudioTimestamp audioTimestamp) {
        if (audioTimestamp == null) {
            throw new IllegalArgumentException();
        }
        long[] jArr = new long[2];
        if (native_get_timestamp(jArr) != 0) {
            return false;
        }
        audioTimestamp.framePosition = jArr[0];
        audioTimestamp.nanoTime = jArr[1];
        return true;
    }

    public void pause() throws IllegalStateException {
        if (this.mState != 1) {
            throw new IllegalStateException("pause() called on uninitialized AudioTrack.");
        }
        synchronized (this.mPlayStateLock) {
            native_pause();
            this.mPlayState = 2;
        }
    }

    public void play() throws IllegalStateException {
        if (this.mState != 1) {
            throw new IllegalStateException("play() called on uninitialized AudioTrack.");
        }
        if (isRestricted()) {
            setVolume(0.0f);
        }
        synchronized (this.mPlayStateLock) {
            native_start();
            this.mPlayState = 3;
        }
    }

    public void release() {
        try {
            stop();
        } catch (IllegalStateException e) {
        }
        native_release();
        this.mState = 0;
    }

    public int reloadStaticData() {
        if (this.mDataLoadMode == 1 || this.mState != 1) {
            return -3;
        }
        return native_reload_static();
    }

    public int setAuxEffectSendLevel(float f) {
        if (isRestricted()) {
            return 0;
        }
        if (this.mState == 0) {
            return -3;
        }
        return native_setAuxEffectSendLevel(clampGainOrLevel(f)) != 0 ? -1 : 0;
    }

    public int setLoopPoints(int i, int i2, int i3) {
        if (this.mDataLoadMode == 1 || this.mState == 0 || getPlayState() == 3) {
            return -3;
        }
        if (i3 != 0 && (i < 0 || i >= this.mNativeBufferSizeInFrames || i >= i2 || i2 > this.mNativeBufferSizeInFrames)) {
            return -2;
        }
        return native_set_loop(i, i2, i3);
    }

    public int setNotificationMarkerPosition(int i) {
        if (this.mState == 0) {
            return -3;
        }
        return native_set_marker_pos(i);
    }

    public int setPlaybackHeadPosition(int i) {
        if (this.mDataLoadMode == 1 || this.mState == 0 || getPlayState() == 3) {
            return -3;
        }
        if (i < 0 || i > this.mNativeBufferSizeInFrames) {
            return -2;
        }
        return native_set_position(i);
    }

    public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener) {
        setPlaybackPositionUpdateListener(onPlaybackPositionUpdateListener, null);
    }

    public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener, Handler handler) {
        if (onPlaybackPositionUpdateListener != null) {
            this.mEventHandlerDelegate = new NativeEventHandlerDelegate(this, onPlaybackPositionUpdateListener, handler);
        } else {
            this.mEventHandlerDelegate = null;
        }
    }

    public int setPlaybackRate(int i) {
        if (this.mState != 1) {
            return -3;
        }
        if (i <= 0) {
            return -2;
        }
        return native_set_playback_rate(i);
    }

    public int setPositionNotificationPeriod(int i) {
        if (this.mState == 0) {
            return -3;
        }
        return native_set_pos_update_period(i);
    }

    @Deprecated
    protected void setState(int i) {
        this.mState = i;
    }

    public int setStereoVolume(float f, float f2) {
        if (isRestricted()) {
            return 0;
        }
        if (this.mState == 0) {
            return -3;
        }
        native_setVolume(clampGainOrLevel(f), clampGainOrLevel(f2));
        return 0;
    }

    public int setVolume(float f) {
        return setStereoVolume(f, f);
    }

    public void stop() throws IllegalStateException {
        if (this.mState != 1) {
            throw new IllegalStateException("stop() called on uninitialized AudioTrack.");
        }
        synchronized (this.mPlayStateLock) {
            native_stop();
            this.mPlayState = 1;
        }
    }

    public int write(ByteBuffer byteBuffer, int i, int i2) {
        int native_write_byte;
        int i3;
        boolean z = false;
        if (this.mState == 0) {
            Log.e(TAG, "AudioTrack.write() called in invalid state STATE_UNINITIALIZED");
            i3 = -3;
        } else if (i2 != 0 && i2 != 1) {
            Log.e(TAG, "AudioTrack.write() called with invalid blocking mode");
            return -2;
        } else if (byteBuffer == null || i < 0 || i > byteBuffer.remaining()) {
            Log.e(TAG, "AudioTrack.write() called with invalid size (" + i + ") value");
            return -2;
        } else {
            if (byteBuffer.isDirect()) {
                int position = byteBuffer.position();
                int i4 = this.mAudioFormat;
                if (i2 == 0) {
                    z = true;
                }
                native_write_byte = native_write_native_bytes(byteBuffer, position, i, i4, z);
            } else {
                byte[] unsafeArray = NioUtils.unsafeArray(byteBuffer);
                int unsafeArrayOffset = NioUtils.unsafeArrayOffset(byteBuffer);
                int position2 = byteBuffer.position();
                int i5 = this.mAudioFormat;
                boolean z2 = false;
                if (i2 == 0) {
                    z2 = true;
                }
                native_write_byte = native_write_byte(unsafeArray, position2 + unsafeArrayOffset, i, i5, z2);
            }
            if (this.mDataLoadMode == 0 && this.mState == 2 && native_write_byte > 0) {
                this.mState = 1;
            }
            i3 = native_write_byte;
            if (native_write_byte > 0) {
                byteBuffer.position(byteBuffer.position() + native_write_byte);
                return native_write_byte;
            }
        }
        return i3;
    }

    public int write(byte[] bArr, int i, int i2) {
        int i3;
        if (this.mState == 0 || this.mAudioFormat == 4) {
            i3 = -3;
        } else if (bArr == null || i < 0 || i2 < 0 || i + i2 < 0 || i + i2 > bArr.length) {
            return -2;
        } else {
            int native_write_byte = native_write_byte(bArr, i, i2, this.mAudioFormat, true);
            i3 = native_write_byte;
            if (this.mDataLoadMode == 0) {
                i3 = native_write_byte;
                if (this.mState == 2) {
                    i3 = native_write_byte;
                    if (native_write_byte > 0) {
                        this.mState = 1;
                        return native_write_byte;
                    }
                }
            }
        }
        return i3;
    }

    public int write(float[] fArr, int i, int i2, int i3) {
        int i4;
        if (this.mState == 0) {
            Log.e(TAG, "AudioTrack.write() called in invalid state STATE_UNINITIALIZED");
            i4 = -3;
        } else if (this.mAudioFormat != 4) {
            Log.e(TAG, "AudioTrack.write(float[] ...) requires format ENCODING_PCM_FLOAT");
            return -3;
        } else if (i3 != 0 && i3 != 1) {
            Log.e(TAG, "AudioTrack.write() called with invalid blocking mode");
            return -2;
        } else if (fArr == null || i < 0 || i2 < 0 || i + i2 < 0 || i + i2 > fArr.length) {
            Log.e(TAG, "AudioTrack.write() called with invalid array, offset, or size");
            return -2;
        } else {
            int native_write_float = native_write_float(fArr, i, i2, this.mAudioFormat, i3 == 0);
            i4 = native_write_float;
            if (this.mDataLoadMode == 0) {
                i4 = native_write_float;
                if (this.mState == 2) {
                    i4 = native_write_float;
                    if (native_write_float > 0) {
                        this.mState = 1;
                        return native_write_float;
                    }
                }
            }
        }
        return i4;
    }

    public int write(short[] sArr, int i, int i2) {
        int i3;
        if (this.mState == 0 || this.mAudioFormat == 4) {
            i3 = -3;
        } else if (sArr == null || i < 0 || i2 < 0 || i + i2 < 0 || i + i2 > sArr.length) {
            return -2;
        } else {
            int native_write_short = native_write_short(sArr, i, i2, this.mAudioFormat);
            i3 = native_write_short;
            if (this.mDataLoadMode == 0) {
                i3 = native_write_short;
                if (this.mState == 2) {
                    i3 = native_write_short;
                    if (native_write_short > 0) {
                        this.mState = 1;
                        return native_write_short;
                    }
                }
            }
        }
        return i3;
    }
}
