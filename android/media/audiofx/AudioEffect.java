package android.media.audiofx;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/AudioEffect.class */
public class AudioEffect {
    public static final String ACTION_CLOSE_AUDIO_EFFECT_CONTROL_SESSION = "android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION";
    public static final String ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL = "android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL";
    public static final String ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION = "android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION";
    public static final int ALREADY_EXISTS = -2;
    public static final int CONTENT_TYPE_GAME = 2;
    public static final int CONTENT_TYPE_MOVIE = 1;
    public static final int CONTENT_TYPE_MUSIC = 0;
    public static final int CONTENT_TYPE_VOICE = 3;
    public static final String EFFECT_AUXILIARY = "Auxiliary";
    public static final String EFFECT_INSERT = "Insert";
    public static final String EFFECT_PRE_PROCESSING = "Pre Processing";
    public static final UUID EFFECT_TYPE_AEC;
    public static final UUID EFFECT_TYPE_AGC;
    public static final UUID EFFECT_TYPE_BASS_BOOST;
    public static final UUID EFFECT_TYPE_ENV_REVERB;
    public static final UUID EFFECT_TYPE_EQUALIZER;
    public static final UUID EFFECT_TYPE_LOUDNESS_ENHANCER;
    public static final UUID EFFECT_TYPE_NS;
    public static final UUID EFFECT_TYPE_NULL;
    public static final UUID EFFECT_TYPE_PRESET_REVERB;
    public static final UUID EFFECT_TYPE_VIRTUALIZER;
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -4;
    public static final int ERROR_DEAD_OBJECT = -7;
    public static final int ERROR_INVALID_OPERATION = -5;
    public static final int ERROR_NO_INIT = -3;
    public static final int ERROR_NO_MEMORY = -6;
    public static final String EXTRA_AUDIO_SESSION = "android.media.extra.AUDIO_SESSION";
    public static final String EXTRA_CONTENT_TYPE = "android.media.extra.CONTENT_TYPE";
    public static final String EXTRA_PACKAGE_NAME = "android.media.extra.PACKAGE_NAME";
    public static final int NATIVE_EVENT_CONTROL_STATUS = 0;
    public static final int NATIVE_EVENT_ENABLED_STATUS = 1;
    public static final int NATIVE_EVENT_PARAMETER_CHANGED = 2;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_UNINITIALIZED = 0;
    public static final int SUCCESS = 0;
    private static final String TAG = "AudioEffect-JAVA";
    private Descriptor mDescriptor;
    private int mId;
    private long mJniData;
    private long mNativeAudioEffect;
    private int mState;
    private final Object mStateLock = new Object();
    private OnEnableStatusChangeListener mEnableStatusChangeListener = null;
    private OnControlStatusChangeListener mControlChangeStatusListener = null;
    private OnParameterChangeListener mParameterChangeListener = null;
    public final Object mListenerLock = new Object();
    public NativeEventHandler mNativeEventHandler = null;

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/AudioEffect$Descriptor.class */
    public static class Descriptor {
        public String connectMode;
        public String implementor;
        public String name;
        public UUID type;
        public UUID uuid;

        public Descriptor() {
        }

        public Descriptor(String str, String str2, String str3, String str4, String str5) {
            this.type = UUID.fromString(str);
            this.uuid = UUID.fromString(str2);
            this.connectMode = str3;
            this.name = str4;
            this.implementor = str5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/AudioEffect$NativeEventHandler.class */
    public class NativeEventHandler extends Handler {
        private AudioEffect mAudioEffect;

        public NativeEventHandler(AudioEffect audioEffect, Looper looper) {
            super(looper);
            this.mAudioEffect = audioEffect;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OnParameterChangeListener onParameterChangeListener;
            OnControlStatusChangeListener onControlStatusChangeListener;
            OnEnableStatusChangeListener onEnableStatusChangeListener;
            boolean z = true;
            if (this.mAudioEffect == null) {
                return;
            }
            switch (message.what) {
                case 0:
                    synchronized (AudioEffect.this.mListenerLock) {
                        onControlStatusChangeListener = this.mAudioEffect.mControlChangeStatusListener;
                    }
                    if (onControlStatusChangeListener != null) {
                        onControlStatusChangeListener.onControlStatusChange(this.mAudioEffect, message.arg1 != 0);
                        return;
                    }
                    return;
                case 1:
                    synchronized (AudioEffect.this.mListenerLock) {
                        onEnableStatusChangeListener = this.mAudioEffect.mEnableStatusChangeListener;
                    }
                    if (onEnableStatusChangeListener != null) {
                        AudioEffect audioEffect = this.mAudioEffect;
                        if (message.arg1 == 0) {
                            z = false;
                        }
                        onEnableStatusChangeListener.onEnableStatusChange(audioEffect, z);
                        return;
                    }
                    return;
                case 2:
                    synchronized (AudioEffect.this.mListenerLock) {
                        onParameterChangeListener = this.mAudioEffect.mParameterChangeListener;
                    }
                    if (onParameterChangeListener != null) {
                        int i = message.arg1;
                        byte[] bArr = (byte[]) message.obj;
                        int byteArrayToInt = AudioEffect.byteArrayToInt(bArr, 0);
                        int byteArrayToInt2 = AudioEffect.byteArrayToInt(bArr, 4);
                        int byteArrayToInt3 = AudioEffect.byteArrayToInt(bArr, 8);
                        byte[] bArr2 = new byte[byteArrayToInt2];
                        byte[] bArr3 = new byte[byteArrayToInt3];
                        System.arraycopy(bArr, 12, bArr2, 0, byteArrayToInt2);
                        System.arraycopy(bArr, i, bArr3, 0, byteArrayToInt3);
                        onParameterChangeListener.onParameterChange(this.mAudioEffect, byteArrayToInt, bArr2, bArr3);
                        return;
                    }
                    return;
                default:
                    Log.e(AudioEffect.TAG, "handleMessage() Unknown event type: " + message.what);
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/AudioEffect$OnControlStatusChangeListener.class */
    public interface OnControlStatusChangeListener {
        void onControlStatusChange(AudioEffect audioEffect, boolean z);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/AudioEffect$OnEnableStatusChangeListener.class */
    public interface OnEnableStatusChangeListener {
        void onEnableStatusChange(AudioEffect audioEffect, boolean z);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/AudioEffect$OnParameterChangeListener.class */
    public interface OnParameterChangeListener {
        void onParameterChange(AudioEffect audioEffect, int i, byte[] bArr, byte[] bArr2);
    }

    static {
        System.loadLibrary("audioeffect_jni");
        native_init();
        EFFECT_TYPE_ENV_REVERB = UUID.fromString("c2e5d5f0-94bd-4763-9cac-4e234d06839e");
        EFFECT_TYPE_PRESET_REVERB = UUID.fromString("47382d60-ddd8-11db-bf3a-0002a5d5c51b");
        EFFECT_TYPE_EQUALIZER = UUID.fromString("0bed4300-ddd6-11db-8f34-0002a5d5c51b");
        EFFECT_TYPE_BASS_BOOST = UUID.fromString("0634f220-ddd4-11db-a0fc-0002a5d5c51b");
        EFFECT_TYPE_VIRTUALIZER = UUID.fromString("37cc2c00-dddd-11db-8577-0002a5d5c51b");
        EFFECT_TYPE_AGC = UUID.fromString("0a8abfe0-654c-11e0-ba26-0002a5d5c51b");
        EFFECT_TYPE_AEC = UUID.fromString("7b491460-8d4d-11e0-bd61-0002a5d5c51b");
        EFFECT_TYPE_NS = UUID.fromString("58b4b260-8e06-11e0-aa8e-0002a5d5c51b");
        EFFECT_TYPE_LOUDNESS_ENHANCER = UUID.fromString("fe3199be-aed0-413f-87bb-11260eb63cf1");
        EFFECT_TYPE_NULL = UUID.fromString("ec7178ec-e5e1-4432-a3f4-4657e6795210");
    }

    public AudioEffect(UUID uuid, UUID uuid2, int i, int i2) throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        this.mState = 0;
        int[] iArr = new int[1];
        Object[] objArr = new Descriptor[1];
        int native_setup = native_setup(new WeakReference(this), uuid.toString(), uuid2.toString(), i, i2, iArr, objArr);
        if (native_setup != 0 && native_setup != -2) {
            Log.e(TAG, "Error code " + native_setup + " when initializing AudioEffect.");
            switch (native_setup) {
                case -5:
                    throw new UnsupportedOperationException("Effect library not loaded");
                case -4:
                    throw new IllegalArgumentException("Effect type: " + uuid + " not supported.");
                default:
                    throw new RuntimeException("Cannot initialize effect engine for type: " + uuid + " Error: " + native_setup);
            }
        }
        this.mId = iArr[0];
        this.mDescriptor = objArr[0];
        synchronized (this.mStateLock) {
            this.mState = 1;
        }
    }

    public static int byteArrayToInt(byte[] bArr) {
        return byteArrayToInt(bArr, 0);
    }

    public static int byteArrayToInt(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getInt(i);
    }

    public static short byteArrayToShort(byte[] bArr) {
        return byteArrayToShort(bArr, 0);
    }

    public static short byteArrayToShort(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getShort(i);
    }

    public static byte[] concatArrays(byte[]... bArr) {
        int i = 0;
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            i += bArr[i3].length;
            i2 = i3 + 1;
        }
        byte[] bArr2 = new byte[i];
        int i4 = 0;
        int length2 = bArr.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length2) {
                return bArr2;
            }
            byte[] bArr3 = bArr[i6];
            System.arraycopy(bArr3, 0, bArr2, i4, bArr3.length);
            i4 += bArr3.length;
            i5 = i6 + 1;
        }
    }

    private void createNativeEventHandler() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mNativeEventHandler = new NativeEventHandler(this, myLooper);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.mNativeEventHandler = new NativeEventHandler(this, mainLooper);
        } else {
            this.mNativeEventHandler = null;
        }
    }

    public static byte[] intToByteArray(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.nativeOrder());
        allocate.putInt(i);
        return allocate.array();
    }

    public static boolean isEffectTypeAvailable(UUID uuid) {
        Descriptor[] queryEffects = queryEffects();
        if (queryEffects == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= queryEffects.length) {
                return false;
            }
            if (queryEffects[i2].type.equals(uuid)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isError(int i) {
        return i < 0;
    }

    private final native int native_command(int i, int i2, byte[] bArr, int i3, byte[] bArr2);

    private final native void native_finalize();

    private final native boolean native_getEnabled();

    private final native int native_getParameter(int i, byte[] bArr, int i2, byte[] bArr2);

    private final native boolean native_hasControl();

    private static final native void native_init();

    private static native Object[] native_query_effects();

    private static native Object[] native_query_pre_processing(int i);

    private final native void native_release();

    private final native int native_setEnabled(boolean z);

    private final native int native_setParameter(int i, byte[] bArr, int i2, byte[] bArr2);

    private final native int native_setup(Object obj, String str, String str2, int i, int i2, int[] iArr, Object[] objArr);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        AudioEffect audioEffect = (AudioEffect) ((WeakReference) obj).get();
        if (audioEffect == null || audioEffect.mNativeEventHandler == null) {
            return;
        }
        audioEffect.mNativeEventHandler.sendMessage(audioEffect.mNativeEventHandler.obtainMessage(i, i2, i3, obj2));
    }

    public static Descriptor[] queryEffects() {
        return (Descriptor[]) native_query_effects();
    }

    public static Descriptor[] queryPreProcessings(int i) {
        return (Descriptor[]) native_query_pre_processing(i);
    }

    public static byte[] shortToByteArray(short s) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.nativeOrder());
        allocate.putShort(s);
        return allocate.array();
    }

    public void checkState(String str) throws IllegalStateException {
        synchronized (this.mStateLock) {
            if (this.mState != 1) {
                throw new IllegalStateException(str + " called on uninitialized AudioEffect.");
            }
        }
    }

    public void checkStatus(int i) {
        if (isError(i)) {
            switch (i) {
                case -5:
                    throw new UnsupportedOperationException("AudioEffect: invalid parameter operation");
                case -4:
                    throw new IllegalArgumentException("AudioEffect: bad parameter value");
                default:
                    throw new RuntimeException("AudioEffect: set/get parameter error");
            }
        }
    }

    public int command(int i, byte[] bArr, byte[] bArr2) throws IllegalStateException {
        checkState("command()");
        return native_command(i, bArr.length, bArr, bArr2.length, bArr2);
    }

    protected void finalize() {
        native_finalize();
    }

    public Descriptor getDescriptor() throws IllegalStateException {
        checkState("getDescriptor()");
        return this.mDescriptor;
    }

    public boolean getEnabled() throws IllegalStateException {
        checkState("getEnabled()");
        return native_getEnabled();
    }

    public int getId() throws IllegalStateException {
        checkState("getId()");
        return this.mId;
    }

    public int getParameter(int i, byte[] bArr) throws IllegalStateException {
        return getParameter(intToByteArray(i), bArr);
    }

    public int getParameter(int i, int[] iArr) throws IllegalStateException {
        if (iArr.length > 2) {
            return -4;
        }
        byte[] intToByteArray = intToByteArray(i);
        byte[] bArr = new byte[iArr.length * 4];
        int parameter = getParameter(intToByteArray, bArr);
        if (parameter == 4 || parameter == 8) {
            iArr[0] = byteArrayToInt(bArr);
            if (parameter == 8) {
                iArr[1] = byteArrayToInt(bArr, 4);
            }
            return parameter / 4;
        }
        return -1;
    }

    public int getParameter(int i, short[] sArr) throws IllegalStateException {
        if (sArr.length > 2) {
            return -4;
        }
        byte[] intToByteArray = intToByteArray(i);
        byte[] bArr = new byte[sArr.length * 2];
        int parameter = getParameter(intToByteArray, bArr);
        if (parameter == 2 || parameter == 4) {
            sArr[0] = byteArrayToShort(bArr);
            if (parameter == 4) {
                sArr[1] = byteArrayToShort(bArr, 2);
            }
            return parameter / 2;
        }
        return -1;
    }

    public int getParameter(byte[] bArr, byte[] bArr2) throws IllegalStateException {
        checkState("getParameter()");
        return native_getParameter(bArr.length, bArr, bArr2.length, bArr2);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [byte[], byte[][]] */
    public int getParameter(int[] iArr, byte[] bArr) throws IllegalStateException {
        if (iArr.length > 2) {
            return -4;
        }
        byte[] intToByteArray = intToByteArray(iArr[0]);
        byte[] bArr2 = intToByteArray;
        if (iArr.length > 1) {
            bArr2 = concatArrays(new byte[]{intToByteArray, intToByteArray(iArr[1])});
        }
        return getParameter(bArr2, bArr);
    }

    /* JADX WARN: Type inference failed for: r0v27, types: [byte[], byte[][]] */
    public int getParameter(int[] iArr, int[] iArr2) throws IllegalStateException {
        if (iArr.length > 2 || iArr2.length > 2) {
            return -4;
        }
        byte[] intToByteArray = intToByteArray(iArr[0]);
        byte[] bArr = intToByteArray;
        if (iArr.length > 1) {
            bArr = concatArrays(new byte[]{intToByteArray, intToByteArray(iArr[1])});
        }
        byte[] bArr2 = new byte[iArr2.length * 4];
        int parameter = getParameter(bArr, bArr2);
        if (parameter == 4 || parameter == 8) {
            iArr2[0] = byteArrayToInt(bArr2);
            if (parameter == 8) {
                iArr2[1] = byteArrayToInt(bArr2, 4);
            }
            return parameter / 4;
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r0v27, types: [byte[], byte[][]] */
    public int getParameter(int[] iArr, short[] sArr) throws IllegalStateException {
        if (iArr.length > 2 || sArr.length > 2) {
            return -4;
        }
        byte[] intToByteArray = intToByteArray(iArr[0]);
        byte[] bArr = intToByteArray;
        if (iArr.length > 1) {
            bArr = concatArrays(new byte[]{intToByteArray, intToByteArray(iArr[1])});
        }
        byte[] bArr2 = new byte[sArr.length * 2];
        int parameter = getParameter(bArr, bArr2);
        if (parameter == 2 || parameter == 4) {
            sArr[0] = byteArrayToShort(bArr2);
            if (parameter == 4) {
                sArr[1] = byteArrayToShort(bArr2, 2);
            }
            return parameter / 2;
        }
        return -1;
    }

    public boolean hasControl() throws IllegalStateException {
        checkState("hasControl()");
        return native_hasControl();
    }

    public void release() {
        synchronized (this.mStateLock) {
            native_release();
            this.mState = 0;
        }
    }

    public void setControlStatusListener(OnControlStatusChangeListener onControlStatusChangeListener) {
        synchronized (this.mListenerLock) {
            this.mControlChangeStatusListener = onControlStatusChangeListener;
        }
        if (onControlStatusChangeListener == null || this.mNativeEventHandler != null) {
            return;
        }
        createNativeEventHandler();
    }

    public void setEnableStatusListener(OnEnableStatusChangeListener onEnableStatusChangeListener) {
        synchronized (this.mListenerLock) {
            this.mEnableStatusChangeListener = onEnableStatusChangeListener;
        }
        if (onEnableStatusChangeListener == null || this.mNativeEventHandler != null) {
            return;
        }
        createNativeEventHandler();
    }

    public int setEnabled(boolean z) throws IllegalStateException {
        checkState("setEnabled()");
        return native_setEnabled(z);
    }

    public int setParameter(int i, int i2) throws IllegalStateException {
        return setParameter(intToByteArray(i), intToByteArray(i2));
    }

    public int setParameter(int i, short s) throws IllegalStateException {
        return setParameter(intToByteArray(i), shortToByteArray(s));
    }

    public int setParameter(int i, byte[] bArr) throws IllegalStateException {
        return setParameter(intToByteArray(i), bArr);
    }

    public int setParameter(byte[] bArr, byte[] bArr2) throws IllegalStateException {
        checkState("setParameter()");
        return native_setParameter(bArr.length, bArr, bArr2.length, bArr2);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [byte[], byte[][]] */
    public int setParameter(int[] iArr, byte[] bArr) throws IllegalStateException {
        if (iArr.length > 2) {
            return -4;
        }
        byte[] intToByteArray = intToByteArray(iArr[0]);
        byte[] bArr2 = intToByteArray;
        if (iArr.length > 1) {
            bArr2 = concatArrays(new byte[]{intToByteArray, intToByteArray(iArr[1])});
        }
        return setParameter(bArr2, bArr);
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v24, types: [byte[], byte[][]] */
    public int setParameter(int[] iArr, int[] iArr2) throws IllegalStateException {
        if (iArr.length > 2 || iArr2.length > 2) {
            return -4;
        }
        byte[] intToByteArray = intToByteArray(iArr[0]);
        byte[] bArr = intToByteArray;
        if (iArr.length > 1) {
            bArr = concatArrays(new byte[]{intToByteArray, intToByteArray(iArr[1])});
        }
        byte[] intToByteArray2 = intToByteArray(iArr2[0]);
        byte[] bArr2 = intToByteArray2;
        if (iArr2.length > 1) {
            bArr2 = concatArrays(new byte[]{intToByteArray2, intToByteArray(iArr2[1])});
        }
        return setParameter(bArr, bArr2);
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v24, types: [byte[], byte[][]] */
    public int setParameter(int[] iArr, short[] sArr) throws IllegalStateException {
        if (iArr.length > 2 || sArr.length > 2) {
            return -4;
        }
        byte[] intToByteArray = intToByteArray(iArr[0]);
        byte[] bArr = intToByteArray;
        if (iArr.length > 1) {
            bArr = concatArrays(new byte[]{intToByteArray, intToByteArray(iArr[1])});
        }
        byte[] shortToByteArray = shortToByteArray(sArr[0]);
        byte[] bArr2 = shortToByteArray;
        if (sArr.length > 1) {
            bArr2 = concatArrays(new byte[]{shortToByteArray, shortToByteArray(sArr[1])});
        }
        return setParameter(bArr, bArr2);
    }

    public void setParameterListener(OnParameterChangeListener onParameterChangeListener) {
        synchronized (this.mListenerLock) {
            this.mParameterChangeListener = onParameterChangeListener;
        }
        if (onParameterChangeListener == null || this.mNativeEventHandler != null) {
            return;
        }
        createNativeEventHandler();
    }
}
