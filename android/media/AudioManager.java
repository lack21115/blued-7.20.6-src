package android.media;

import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.IAudioFocusDispatcher;
import android.media.IAudioService;
import android.media.audiopolicy.AudioPolicy;
import android.media.session.MediaSessionLegacyHelper;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioManager.class */
public class AudioManager {
    public static final String ACTION_ANALOG_AUDIO_DOCK_PLUG = "android.media.action.ANALOG_AUDIO_DOCK_PLUG";
    public static final String ACTION_AUDIO_BECOMING_NOISY = "android.media.AUDIO_BECOMING_NOISY";
    public static final String ACTION_DIGITAL_AUDIO_DOCK_PLUG = "android.media.action.DIGITAL_AUDIO_DOCK_PLUG";
    public static final String ACTION_HDMI_AUDIO_PLUG = "android.media.action.HDMI_AUDIO_PLUG";
    public static final String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";
    @Deprecated
    public static final String ACTION_SCO_AUDIO_STATE_CHANGED = "android.media.SCO_AUDIO_STATE_CHANGED";
    public static final String ACTION_SCO_AUDIO_STATE_UPDATED = "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
    public static final String ACTION_USB_AUDIO_ACCESSORY_PLUG = "android.media.action.USB_AUDIO_ACCESSORY_PLUG";
    public static final String ACTION_USB_AUDIO_DEVICE_PLUG = "android.media.action.USB_AUDIO_DEVICE_PLUG";
    public static final int ADJUST_LOWER = -1;
    public static final int ADJUST_RAISE = 1;
    public static final int ADJUST_SAME = 0;
    public static final int AUDIOFOCUS_FLAGS_APPS = 3;
    public static final int AUDIOFOCUS_FLAGS_SYSTEM = 7;
    public static final int AUDIOFOCUS_FLAG_DELAY_OK = 1;
    public static final int AUDIOFOCUS_FLAG_LOCK = 4;
    public static final int AUDIOFOCUS_FLAG_PAUSES_ON_DUCKABLE_LOSS = 2;
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    public static final int AUDIOFOCUS_LOSS = -1;
    public static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;
    public static final int AUDIOFOCUS_NONE = 0;
    public static final int AUDIOFOCUS_REQUEST_DELAYED = 2;
    public static final int AUDIOFOCUS_REQUEST_FAILED = 0;
    public static final int AUDIOFOCUS_REQUEST_GRANTED = 1;
    static final int AUDIOPORT_GENERATION_INIT = 0;
    public static final int AUDIO_SESSION_ID_GENERATE = 0;
    public static final int DEVICE_IN_ANLG_DOCK_HEADSET = -2147483136;
    public static final int DEVICE_IN_BACK_MIC = -2147483520;
    public static final int DEVICE_IN_BLUETOOTH_SCO_HEADSET = -2147483640;
    public static final int DEVICE_IN_BUILTIN_MIC = -2147483644;
    public static final int DEVICE_IN_DGTL_DOCK_HEADSET = -2147482624;
    public static final int DEVICE_IN_FM_TUNER = -2147475456;
    public static final int DEVICE_IN_HDMI = -2147483616;
    public static final int DEVICE_IN_LINE = -2147450880;
    public static final int DEVICE_IN_LOOPBACK = -2147221504;
    public static final int DEVICE_IN_SPDIF = -2147418112;
    public static final int DEVICE_IN_TELEPHONY_RX = -2147483584;
    public static final int DEVICE_IN_TV_TUNER = -2147467264;
    public static final int DEVICE_IN_USB_ACCESSORY = -2147481600;
    public static final int DEVICE_IN_USB_DEVICE = -2147479552;
    public static final int DEVICE_IN_WIRED_HEADSET = -2147483632;
    public static final int DEVICE_NONE = 0;
    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = 2048;
    public static final int DEVICE_OUT_AUX_DIGITAL = 1024;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP = 128;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    public static final int DEVICE_OUT_BLUETOOTH_SCO = 16;
    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
    public static final int DEVICE_OUT_DEFAULT = 1073741824;
    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = 4096;
    public static final int DEVICE_OUT_EARPIECE = 1;
    public static final int DEVICE_OUT_FM = 1048576;
    public static final int DEVICE_OUT_HDMI = 1024;
    public static final int DEVICE_OUT_HDMI_ARC = 262144;
    public static final int DEVICE_OUT_LINE = 131072;
    public static final int DEVICE_OUT_REMOTE_SUBMIX = 32768;
    public static final int DEVICE_OUT_SPDIF = 524288;
    public static final int DEVICE_OUT_SPEAKER = 2;
    public static final int DEVICE_OUT_TELEPHONY_TX = 65536;
    public static final int DEVICE_OUT_USB_ACCESSORY = 8192;
    public static final int DEVICE_OUT_USB_DEVICE = 16384;
    public static final int DEVICE_OUT_WIRED_HEADPHONE = 8;
    public static final int DEVICE_OUT_WIRED_HEADSET = 4;
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -2;
    public static final int ERROR_DEAD_OBJECT = -6;
    public static final int ERROR_INVALID_OPERATION = -3;
    public static final int ERROR_NO_INIT = -5;
    public static final int ERROR_PERMISSION_DENIED = -4;
    public static final String EXTRA_AUDIO_PLUG_STATE = "android.media.extra.AUDIO_PLUG_STATE";
    public static final String EXTRA_AVAILABLITY_CHANGED_VALUE = "org.codeaurora.bluetooth.EXTRA_AVAILABLITY_CHANGED_VALUE";
    public static final String EXTRA_CALLING_PACKAGE_NAME = "org.codeaurora.bluetooth.EXTRA_CALLING_PACKAGE_NAME";
    public static final String EXTRA_ENCODINGS = "android.media.extra.ENCODINGS";
    public static final String EXTRA_FOCUS_CHANGED_VALUE = "org.codeaurora.bluetooth.EXTRA_FOCUS_CHANGED_VALUE";
    public static final String EXTRA_MASTER_VOLUME_MUTED = "android.media.EXTRA_MASTER_VOLUME_MUTED";
    public static final String EXTRA_MASTER_VOLUME_VALUE = "android.media.EXTRA_MASTER_VOLUME_VALUE";
    public static final String EXTRA_MAX_CHANNEL_COUNT = "android.media.extra.MAX_CHANNEL_COUNT";
    public static final String EXTRA_PREV_MASTER_VOLUME_VALUE = "android.media.EXTRA_PREV_MASTER_VOLUME_VALUE";
    public static final String EXTRA_PREV_VOLUME_STREAM_VALUE = "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";
    public static final String EXTRA_RINGER_MODE = "android.media.EXTRA_RINGER_MODE";
    public static final String EXTRA_SCO_AUDIO_PREVIOUS_STATE = "android.media.extra.SCO_AUDIO_PREVIOUS_STATE";
    public static final String EXTRA_SCO_AUDIO_STATE = "android.media.extra.SCO_AUDIO_STATE";
    public static final String EXTRA_STREAM_VOLUME_MUTED = "android.media.EXTRA_STREAM_VOLUME_MUTED";
    public static final String EXTRA_VIBRATE_SETTING = "android.media.EXTRA_VIBRATE_SETTING";
    public static final String EXTRA_VIBRATE_TYPE = "android.media.EXTRA_VIBRATE_TYPE";
    public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    public static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    public static final int FLAG_ACTIVE_MEDIA_ONLY = 512;
    public static final int FLAG_ALLOW_RINGER_MODES = 2;
    public static final int FLAG_BLUETOOTH_ABS_VOLUME = 64;
    public static final int FLAG_FIXED_VOLUME = 32;
    public static final int FLAG_HDMI_SYSTEM_AUDIO_VOLUME = 256;
    public static final int FLAG_PLAY_SOUND = 4;
    public static final int FLAG_REMOVE_SOUND_AND_VIBRATE = 8;
    public static final int FLAG_SHOW_SILENT_HINT = 128;
    public static final int FLAG_SHOW_UI = 1;
    public static final int FLAG_SHOW_UI_WARNINGS = 1024;
    public static final int FLAG_SHOW_VIBRATE_HINT = 2048;
    public static final int FLAG_VIBRATE = 16;
    public static final int FX_FOCUS_NAVIGATION_DOWN = 2;
    public static final int FX_FOCUS_NAVIGATION_LEFT = 3;
    public static final int FX_FOCUS_NAVIGATION_RIGHT = 4;
    public static final int FX_FOCUS_NAVIGATION_UP = 1;
    public static final int FX_KEYPRESS_DELETE = 7;
    public static final int FX_KEYPRESS_INVALID = 9;
    public static final int FX_KEYPRESS_RETURN = 8;
    public static final int FX_KEYPRESS_SPACEBAR = 6;
    public static final int FX_KEYPRESS_STANDARD = 5;
    public static final int FX_KEY_CLICK = 0;
    public static final String INTERNAL_RINGER_MODE_CHANGED_ACTION = "android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION";
    public static final String MASTER_MUTE_CHANGED_ACTION = "android.media.MASTER_MUTE_CHANGED_ACTION";
    public static final String MASTER_VOLUME_CHANGED_ACTION = "android.media.MASTER_VOLUME_CHANGED_ACTION";
    public static final int MODE_CURRENT = -1;
    public static final int MODE_INVALID = -2;
    public static final int MODE_IN_CALL = 2;
    public static final int MODE_IN_COMMUNICATION = 3;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_RINGTONE = 1;
    public static final int NUM_SOUND_EFFECTS = 10;
    @Deprecated
    public static final int NUM_STREAMS = 5;
    public static final String PROPERTY_OUTPUT_FRAMES_PER_BUFFER = "android.media.property.OUTPUT_FRAMES_PER_BUFFER";
    public static final String PROPERTY_OUTPUT_SAMPLE_RATE = "android.media.property.OUTPUT_SAMPLE_RATE";
    public static final String RCC_CHANGED_ACTION = "org.codeaurora.bluetooth.RCC_CHANGED_ACTION";
    public static final String RINGER_MODE_CHANGED_ACTION = "android.media.RINGER_MODE_CHANGED";
    public static final int RINGER_MODE_MAX = 2;
    public static final int RINGER_MODE_NORMAL = 2;
    public static final int RINGER_MODE_SILENT = 0;
    public static final int RINGER_MODE_VIBRATE = 1;
    @Deprecated
    public static final int ROUTE_ALL = -1;
    @Deprecated
    public static final int ROUTE_BLUETOOTH = 4;
    @Deprecated
    public static final int ROUTE_BLUETOOTH_A2DP = 16;
    @Deprecated
    public static final int ROUTE_BLUETOOTH_SCO = 4;
    @Deprecated
    public static final int ROUTE_EARPIECE = 1;
    @Deprecated
    public static final int ROUTE_HEADSET = 8;
    @Deprecated
    public static final int ROUTE_SPEAKER = 2;
    public static final int SCO_AUDIO_STATE_CONNECTED = 1;
    public static final int SCO_AUDIO_STATE_CONNECTING = 2;
    public static final int SCO_AUDIO_STATE_DISCONNECTED = 0;
    public static final int SCO_AUDIO_STATE_ERROR = -1;
    public static final int STREAM_ALARM = 4;
    public static final int STREAM_BLUETOOTH_SCO = 6;
    public static final int STREAM_DTMF = 8;
    public static final int STREAM_INCALL_MUSIC = 10;
    public static final int STREAM_MUSIC = 3;
    public static final String STREAM_MUTE_CHANGED_ACTION = "android.media.STREAM_MUTE_CHANGED_ACTION";
    public static final int STREAM_NOTIFICATION = 5;
    public static final int STREAM_RING = 2;
    public static final int STREAM_SYSTEM = 1;
    public static final int STREAM_SYSTEM_ENFORCED = 7;
    public static final int STREAM_TTS = 9;
    public static final int STREAM_VOICE_CALL = 0;
    public static final int SUCCESS = 0;
    public static final int USE_DEFAULT_STREAM_TYPE = Integer.MIN_VALUE;
    public static final String VIBRATE_SETTING_CHANGED_ACTION = "android.media.VIBRATE_SETTING_CHANGED";
    public static final int VIBRATE_SETTING_OFF = 0;
    public static final int VIBRATE_SETTING_ON = 1;
    public static final int VIBRATE_SETTING_ONLY_SILENT = 2;
    public static final int VIBRATE_TYPE_NOTIFICATION = 1;
    public static final int VIBRATE_TYPE_RINGER = 0;
    public static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static IAudioService sService;
    private Context mApplicationContext;
    private Context mOriginalContext;
    private final boolean mUseFixedVolume;
    private final boolean mUseMasterVolume;
    private final boolean mUseVolumeKeySounds;
    private long mVolumeKeyUpTime;
    private static String TAG = "AudioManager";
    private static final AudioPortEventHandler sAudioPortEventHandler = new AudioPortEventHandler();
    public static final int[] DEFAULT_STREAM_VOLUME = {4, 7, 5, 11, 6, 5, 7, 7, 11, 11, 4};
    private static final String[] FLAG_NAMES = {"FLAG_SHOW_UI", "FLAG_ALLOW_RINGER_MODES", "FLAG_PLAY_SOUND", "FLAG_REMOVE_SOUND_AND_VIBRATE", "FLAG_VIBRATE", "FLAG_FIXED_VOLUME", "FLAG_BLUETOOTH_ABS_VOLUME", "FLAG_SHOW_SILENT_HINT", "FLAG_HDMI_SYSTEM_AUDIO_VOLUME", "FLAG_ACTIVE_MEDIA_ONLY", "FLAG_SHOW_UI_WARNINGS", "FLAG_SHOW_VIBRATE_HINT"};
    static Integer sAudioPortGeneration = new Integer(0);
    static ArrayList<AudioPort> sAudioPortsCached = new ArrayList<>();
    static ArrayList<AudioPatch> sAudioPatchesCached = new ArrayList<>();
    private final Binder mToken = new Binder();
    private final HashMap<String, OnAudioFocusChangeListener> mAudioFocusIdListenerMap = new HashMap<>();
    private final Object mFocusListenerLock = new Object();
    private final FocusEventHandlerDelegate mAudioFocusEventHandlerDelegate = new FocusEventHandlerDelegate();
    private final IAudioFocusDispatcher mAudioFocusDispatcher = new IAudioFocusDispatcher.Stub() { // from class: android.media.AudioManager.1
        @Override // android.media.IAudioFocusDispatcher
        public void dispatchAudioFocusChange(int i, String str) {
            AudioManager.this.mAudioFocusEventHandlerDelegate.getHandler().sendMessage(AudioManager.this.mAudioFocusEventHandlerDelegate.getHandler().obtainMessage(i, str));
        }
    };
    private final IBinder mICallBack = new Binder();

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioManager$FocusEventHandlerDelegate.class */
    private class FocusEventHandlerDelegate {
        private final Handler mHandler;

        FocusEventHandlerDelegate() {
            Looper myLooper = Looper.myLooper();
            Looper mainLooper = myLooper == null ? Looper.getMainLooper() : myLooper;
            if (mainLooper != null) {
                this.mHandler = new Handler(mainLooper) { // from class: android.media.AudioManager.FocusEventHandlerDelegate.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        OnAudioFocusChangeListener findFocusListener;
                        synchronized (AudioManager.this.mFocusListenerLock) {
                            findFocusListener = AudioManager.this.findFocusListener((String) message.obj);
                        }
                        if (findFocusListener != null) {
                            Log.d(AudioManager.TAG, "AudioManager dispatching onAudioFocusChange(" + message.what + ") for " + message.obj);
                            findFocusListener.onAudioFocusChange(message.what);
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

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioManager$OnAudioFocusChangeListener.class */
    public interface OnAudioFocusChangeListener {
        void onAudioFocusChange(int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioManager$OnAudioPortUpdateListener.class */
    public interface OnAudioPortUpdateListener {
        void onAudioPatchListUpdate(AudioPatch[] audioPatchArr);

        void onAudioPortListUpdate(AudioPort[] audioPortArr);

        void onServiceDied();
    }

    public AudioManager(Context context) {
        setContext(context);
        this.mUseMasterVolume = getContext().getResources().getBoolean(17956883);
        this.mUseVolumeKeySounds = getContext().getResources().getBoolean(17956884);
        this.mUseFixedVolume = getContext().getResources().getBoolean(17956998);
        sAudioPortEventHandler.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OnAudioFocusChangeListener findFocusListener(String str) {
        return this.mAudioFocusIdListenerMap.get(str);
    }

    public static String flagsToString(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i;
        int i3 = 0;
        while (i3 < FLAG_NAMES.length) {
            int i4 = 1 << i3;
            int i5 = i2;
            if ((i2 & i4) != 0) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(FLAG_NAMES[i3]);
                i5 = i2 & (i4 ^ (-1));
            }
            i3++;
            i2 = i5;
        }
        if (i2 != 0) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(i2);
        }
        return sb.toString();
    }

    private Context getContext() {
        if (this.mApplicationContext == null) {
            setContext(this.mOriginalContext);
        }
        return this.mApplicationContext != null ? this.mApplicationContext : this.mOriginalContext;
    }

    private String getIdForAudioFocusListener(OnAudioFocusChangeListener onAudioFocusChangeListener) {
        return onAudioFocusChangeListener == null ? new String(toString()) : new String(toString() + onAudioFocusChangeListener.toString());
    }

    private static IAudioService getService() {
        if (sService != null) {
            return sService;
        }
        sService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
        return sService;
    }

    public static boolean isInputDevice(int i) {
        return (i & Integer.MIN_VALUE) == Integer.MIN_VALUE;
    }

    public static boolean isOutputDevice(int i) {
        return (Integer.MIN_VALUE & i) == 0;
    }

    public static boolean isValidRingerMode(int i) {
        if (i < 0 || i > 2) {
            return false;
        }
        try {
            return getService().isValidRingerMode(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in isValidRingerMode", e);
            return false;
        }
    }

    private boolean querySoundEffectsEnabled(int i) {
        boolean z = false;
        if (Settings.System.getIntForUser(getContext().getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 0, i) != 0) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int resetAudioPortGeneration() {
        int intValue;
        synchronized (sAudioPortGeneration) {
            intValue = sAudioPortGeneration.intValue();
            sAudioPortGeneration = 0;
        }
        return intValue;
    }

    private void setContext(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        if (this.mApplicationContext != null) {
            this.mOriginalContext = null;
        } else {
            this.mOriginalContext = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int updateAudioPortCache(ArrayList<AudioPort> arrayList, ArrayList<AudioPatch> arrayList2) {
        boolean z;
        boolean z2;
        synchronized (sAudioPortGeneration) {
            if (sAudioPortGeneration.intValue() == 0) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                ArrayList<AudioPort> arrayList3 = new ArrayList<>();
                ArrayList<AudioPatch> arrayList4 = new ArrayList<>();
                do {
                    arrayList3.clear();
                    int listAudioPorts = AudioSystem.listAudioPorts(arrayList3, iArr2);
                    if (listAudioPorts != 0) {
                        Log.w(TAG, "updateAudioPortCache: listAudioPorts failed");
                        return listAudioPorts;
                    }
                    arrayList4.clear();
                    int listAudioPatches = AudioSystem.listAudioPatches(arrayList4, iArr);
                    if (listAudioPatches != 0) {
                        Log.w(TAG, "updateAudioPortCache: listAudioPatches failed");
                        return listAudioPatches;
                    }
                } while (iArr[0] != iArr2[0]);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList4.size()) {
                        break;
                    }
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= arrayList4.get(i2).sources().length) {
                            break;
                        }
                        arrayList4.get(i2).sources()[i4] = updatePortConfig(arrayList4.get(i2).sources()[i4], arrayList3);
                        i3 = i4 + 1;
                    }
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < arrayList4.get(i2).sinks().length) {
                            arrayList4.get(i2).sinks()[i6] = updatePortConfig(arrayList4.get(i2).sinks()[i6], arrayList3);
                            i5 = i6 + 1;
                        }
                    }
                    i = i2 + 1;
                }
                Iterator<AudioPatch> it = arrayList4.iterator();
                while (it.hasNext()) {
                    AudioPatch next = it.next();
                    AudioPortConfig[] sources = next.sources();
                    int length = sources.length;
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        z = false;
                        if (i8 >= length) {
                            break;
                        } else if (sources[i8] == null) {
                            z = true;
                            break;
                        } else {
                            i7 = i8 + 1;
                        }
                    }
                    AudioPortConfig[] sinks = next.sinks();
                    int length2 = sinks.length;
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        z2 = z;
                        if (i10 >= length2) {
                            break;
                        } else if (sinks[i10] == null) {
                            z2 = true;
                            break;
                        } else {
                            i9 = i10 + 1;
                        }
                    }
                    if (z2) {
                        it.remove();
                    }
                }
                sAudioPortsCached = arrayList3;
                sAudioPatchesCached = arrayList4;
                sAudioPortGeneration = Integer.valueOf(iArr2[0]);
            }
            if (arrayList != null) {
                arrayList.clear();
                arrayList.addAll(sAudioPortsCached);
            }
            if (arrayList2 != null) {
                arrayList2.clear();
                arrayList2.addAll(sAudioPatchesCached);
            }
            return 0;
        }
    }

    static AudioPortConfig updatePortConfig(AudioPortConfig audioPortConfig, ArrayList<AudioPort> arrayList) {
        int i;
        AudioPort audioPort;
        AudioPort port = audioPortConfig.port();
        int i2 = 0;
        while (true) {
            i = i2;
            audioPort = port;
            if (i >= arrayList.size()) {
                break;
            } else if (arrayList.get(i).handle().equals(port.handle())) {
                audioPort = arrayList.get(i);
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == arrayList.size()) {
            Log.e(TAG, "updatePortConfig port not found for handle: " + audioPort.handle().id());
            return null;
        }
        AudioGainConfig gain = audioPortConfig.gain();
        AudioGainConfig audioGainConfig = gain;
        if (gain != null) {
            audioGainConfig = audioPort.gain(gain.index()).buildConfig(gain.mode(), gain.channelMask(), gain.values(), gain.rampDurationMs());
        }
        return audioPort.buildConfig(audioPortConfig.samplingRate(), audioPortConfig.channelMask(), audioPortConfig.format(), audioGainConfig);
    }

    public int abandonAudioFocus(OnAudioFocusChangeListener onAudioFocusChangeListener) {
        return abandonAudioFocus(onAudioFocusChangeListener, null);
    }

    public int abandonAudioFocus(OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes) {
        unregisterAudioFocusListener(onAudioFocusChangeListener);
        try {
            return getService().abandonAudioFocus(this.mAudioFocusDispatcher, getIdForAudioFocusListener(onAudioFocusChangeListener), audioAttributes);
        } catch (RemoteException e) {
            Log.e(TAG, "Can't call abandonAudioFocus() on AudioService:", e);
            return 0;
        }
    }

    public void abandonAudioFocusForCall() {
        try {
            getService().abandonAudioFocus(null, "AudioFocus_For_Phone_Ring_And_Calls", null);
        } catch (RemoteException e) {
            Log.e(TAG, "Can't call abandonAudioFocusForCall() on AudioService:", e);
        }
    }

    public void adjustMasterVolume(int i, int i2) {
        try {
            getService().adjustMasterVolume(i, i2, getContext().getOpPackageName());
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in adjustMasterVolume", e);
        }
    }

    public void adjustStreamVolume(int i, int i2, int i3) {
        IAudioService service = getService();
        try {
            if (this.mUseMasterVolume) {
                service.adjustMasterVolume(i2, i3, getContext().getOpPackageName());
            } else {
                service.adjustStreamVolume(i, i2, i3, getContext().getOpPackageName());
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in adjustStreamVolume", e);
        }
    }

    public void adjustSuggestedStreamVolume(int i, int i2, int i3) {
        IAudioService service = getService();
        try {
            if (this.mUseMasterVolume) {
                service.adjustMasterVolume(i, i3, getContext().getOpPackageName());
            } else {
                MediaSessionLegacyHelper.getHelper(getContext()).sendAdjustVolumeBy(i2, i, i3);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in adjustSuggestedStreamVolume", e);
        }
    }

    public void adjustVolume(int i, int i2) {
        IAudioService service = getService();
        try {
            if (this.mUseMasterVolume) {
                service.adjustMasterVolume(i, i2, getContext().getOpPackageName());
            } else {
                MediaSessionLegacyHelper.getHelper(getContext()).sendAdjustVolumeBy(Integer.MIN_VALUE, i, i2);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in adjustVolume", e);
        }
    }

    public void avrcpSupportsAbsoluteVolume(String str, boolean z) {
        try {
            getService().avrcpSupportsAbsoluteVolume(str, z);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in avrcpSupportsAbsoluteVolume", e);
        }
    }

    public int createAudioPatch(AudioPatch[] audioPatchArr, AudioPortConfig[] audioPortConfigArr, AudioPortConfig[] audioPortConfigArr2) {
        return AudioSystem.createAudioPatch(audioPatchArr, audioPortConfigArr, audioPortConfigArr2);
    }

    public void disableSafeMediaVolume() {
        try {
            getService().disableSafeMediaVolume();
        } catch (RemoteException e) {
            Log.w(TAG, "Error disabling safe media volume", e);
        }
    }

    public void dispatchMediaKeyEvent(KeyEvent keyEvent) {
        MediaSessionLegacyHelper.getHelper(getContext()).sendMediaButtonEvent(keyEvent, false);
    }

    public void forceVolumeControlStream(int i) {
        if (this.mUseMasterVolume) {
            return;
        }
        try {
            getService().forceVolumeControlStream(i, this.mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in forceVolumeControlStream", e);
        }
    }

    public int generateAudioSessionId() {
        int newAudioSessionId = AudioSystem.newAudioSessionId();
        if (newAudioSessionId > 0) {
            return newAudioSessionId;
        }
        Log.e(TAG, "Failure to generate a new audio session ID");
        return -1;
    }

    public int getDevicesForStream(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
                return AudioSystem.getDevicesForStream(i);
            case 6:
            case 7:
            default:
                return 0;
        }
    }

    public int getLastAudibleMasterVolume() {
        try {
            return getService().getLastAudibleMasterVolume();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getLastAudibleMasterVolume", e);
            return 0;
        }
    }

    public int getLastAudibleStreamVolume(int i) {
        IAudioService service = getService();
        try {
            return this.mUseMasterVolume ? service.getLastAudibleMasterVolume() : service.getLastAudibleStreamVolume(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getLastAudibleStreamVolume", e);
            return 0;
        }
    }

    public int getMasterMaxVolume() {
        try {
            return getService().getMasterMaxVolume();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getMasterMaxVolume", e);
            return 0;
        }
    }

    public int getMasterStreamType() {
        try {
            return getService().getMasterStreamType();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getMasterStreamType", e);
            return 2;
        }
    }

    public int getMasterVolume() {
        try {
            return getService().getMasterVolume();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getMasterVolume", e);
            return 0;
        }
    }

    public int getMode() {
        try {
            return getService().getMode();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getMode", e);
            return -2;
        }
    }

    public int getOutputLatency(int i) {
        return AudioSystem.getOutputLatency(i);
    }

    public String getParameters(String str) {
        return AudioSystem.getParameters(str);
    }

    public String getProperty(String str) {
        String str2;
        if (PROPERTY_OUTPUT_SAMPLE_RATE.equals(str)) {
            int primaryOutputSamplingRate = AudioSystem.getPrimaryOutputSamplingRate();
            str2 = null;
            if (primaryOutputSamplingRate > 0) {
                str2 = Integer.toString(primaryOutputSamplingRate);
            }
        } else {
            str2 = null;
            if (PROPERTY_OUTPUT_FRAMES_PER_BUFFER.equals(str)) {
                int primaryOutputFrameCount = AudioSystem.getPrimaryOutputFrameCount();
                str2 = null;
                if (primaryOutputFrameCount > 0) {
                    return Integer.toString(primaryOutputFrameCount);
                }
            }
        }
        return str2;
    }

    public void getRemoteControlClientNowPlayingEntries() {
        try {
            getService().getRemoteControlClientNowPlayingEntries();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getRemoteControlClientNowPlayingEntries()", e);
        }
    }

    public int getRingerMode() {
        try {
            return getService().getRingerModeExternal();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getRingerMode", e);
            return 2;
        }
    }

    public int getRingerModeInternal() {
        try {
            return getService().getRingerModeInternal();
        } catch (RemoteException e) {
            Log.w(TAG, "Error calling getRingerModeInternal", e);
            return 2;
        }
    }

    public IRingtonePlayer getRingtonePlayer() {
        try {
            return getService().getRingtonePlayer();
        } catch (RemoteException e) {
            return null;
        }
    }

    @Deprecated
    public int getRouting(int i) {
        return -1;
    }

    public int getStreamMaxVolume(int i) {
        IAudioService service = getService();
        try {
            return this.mUseMasterVolume ? service.getMasterMaxVolume() : service.getStreamMaxVolume(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getStreamMaxVolume", e);
            return 0;
        }
    }

    public int getStreamVolume(int i) {
        IAudioService service = getService();
        try {
            return this.mUseMasterVolume ? service.getMasterVolume() : service.getStreamVolume(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getStreamVolume", e);
            return 0;
        }
    }

    public int getVibrateSetting(int i) {
        try {
            return getService().getVibrateSetting(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getVibrateSetting", e);
            return 0;
        }
    }

    public void handleKeyDown(KeyEvent keyEvent, int i) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case 24:
            case 25:
                if (this.mUseMasterVolume) {
                    adjustMasterVolume(keyCode == 24 ? 1 : -1, 17);
                    return;
                } else {
                    adjustSuggestedStreamVolume(keyCode == 24 ? 1 : -1, i, 17);
                    return;
                }
            case 164:
                if (keyEvent.getRepeatCount() == 0) {
                    MediaSessionLegacyHelper.getHelper(getContext()).sendVolumeKeyEvent(keyEvent, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void handleKeyUp(KeyEvent keyEvent, int i) {
        switch (keyEvent.getKeyCode()) {
            case 24:
            case 25:
                if (this.mUseVolumeKeySounds) {
                    if (this.mUseMasterVolume) {
                        adjustMasterVolume(0, 4);
                    } else {
                        adjustSuggestedStreamVolume(0, i, 4);
                    }
                }
                this.mVolumeKeyUpTime = SystemClock.uptimeMillis();
                return;
            case 164:
                MediaSessionLegacyHelper.getHelper(getContext()).sendVolumeKeyEvent(keyEvent, false);
                return;
            default:
                return;
        }
    }

    public boolean isAudioFocusExclusive() {
        boolean z = false;
        try {
            if (getService().getCurrentAudioFocus() == 4) {
                z = true;
            }
            return z;
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in isAudioFocusExclusive()", e);
            return false;
        }
    }

    public boolean isBluetoothA2dpOn() {
        return AudioSystem.getDeviceConnectionState(128, "") != 0;
    }

    public boolean isBluetoothScoAvailableOffCall() {
        return getContext().getResources().getBoolean(17956954);
    }

    public boolean isBluetoothScoOn() {
        try {
            return getService().isBluetoothScoOn();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in isBluetoothScoOn", e);
            return false;
        }
    }

    public boolean isHdmiSystemAudioSupported() {
        try {
            return getService().isHdmiSystemAudioSupported();
        } catch (RemoteException e) {
            Log.w(TAG, "Error querying system audio mode", e);
            return false;
        }
    }

    public boolean isMasterMute() {
        try {
            return getService().isMasterMute();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in isMasterMute", e);
            return false;
        }
    }

    public boolean isMicrophoneMute() {
        return AudioSystem.isMicrophoneMuted();
    }

    public boolean isMusicActive() {
        return AudioSystem.isStreamActive(3, 0);
    }

    public boolean isMusicActiveRemotely() {
        return AudioSystem.isStreamActiveRemotely(3, 0);
    }

    public boolean isSilentMode() {
        int ringerMode = getRingerMode();
        return ringerMode == 0 || ringerMode == 1;
    }

    public boolean isSpeakerphoneOn() {
        try {
            return getService().isSpeakerphoneOn();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in isSpeakerphoneOn", e);
            return false;
        }
    }

    public boolean isStreamAffectedByRingerMode(int i) {
        try {
            return getService().isStreamAffectedByRingerMode(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Error calling isStreamAffectedByRingerMode", e);
            return false;
        }
    }

    public boolean isStreamMute(int i) {
        try {
            return getService().isStreamMute(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in isStreamMute", e);
            return false;
        }
    }

    public boolean isVolumeFixed() {
        return this.mUseFixedVolume;
    }

    public boolean isWiredHeadsetOn() {
        return (AudioSystem.getDeviceConnectionState(4, "") == 0 && AudioSystem.getDeviceConnectionState(8, "") == 0) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int listAudioDevicePorts(ArrayList<AudioPort> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int updateAudioPortCache = updateAudioPortCache(arrayList2, null);
        if (updateAudioPortCache == 0) {
            arrayList.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList2.size()) {
                    break;
                }
                if (arrayList2.get(i2) instanceof AudioDevicePort) {
                    arrayList.add(arrayList2.get(i2));
                }
                i = i2 + 1;
            }
        }
        return updateAudioPortCache;
    }

    public int listAudioPatches(ArrayList<AudioPatch> arrayList) {
        return updateAudioPortCache(null, arrayList);
    }

    public int listAudioPorts(ArrayList<AudioPort> arrayList) {
        return updateAudioPortCache(arrayList, null);
    }

    public void loadSoundEffects() {
        try {
            getService().loadSoundEffects();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in loadSoundEffects" + e);
        }
    }

    public void notifyVolumeControllerVisible(IVolumeController iVolumeController, boolean z) {
        try {
            getService().notifyVolumeControllerVisible(iVolumeController, z);
        } catch (RemoteException e) {
            Log.w(TAG, "Error notifying about volume controller visibility", e);
        }
    }

    public void playSoundEffect(int i) {
        if (i < 0 || i >= 10 || !querySoundEffectsEnabled(Process.myUserHandle().getIdentifier())) {
            return;
        }
        try {
            getService().playSoundEffect(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in playSoundEffect" + e);
        }
    }

    public void playSoundEffect(int i, float f) {
        if (i < 0 || i >= 10) {
            return;
        }
        try {
            getService().playSoundEffectVolume(i, f);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in playSoundEffect" + e);
        }
    }

    public void playSoundEffect(int i, int i2) {
        if (i < 0 || i >= 10 || !querySoundEffectsEnabled(i2)) {
            return;
        }
        try {
            getService().playSoundEffect(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in playSoundEffect" + e);
        }
    }

    public void preDispatchKeyEvent(KeyEvent keyEvent, int i) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 25 || keyCode == 24 || keyCode == 164 || this.mVolumeKeyUpTime + 300 <= SystemClock.uptimeMillis()) {
            return;
        }
        if (this.mUseMasterVolume) {
            adjustMasterVolume(0, 8);
        } else {
            adjustSuggestedStreamVolume(0, i, 8);
        }
    }

    public void registerAudioFocusListener(OnAudioFocusChangeListener onAudioFocusChangeListener) {
        synchronized (this.mFocusListenerLock) {
            if (this.mAudioFocusIdListenerMap.containsKey(getIdForAudioFocusListener(onAudioFocusChangeListener))) {
                return;
            }
            this.mAudioFocusIdListenerMap.put(getIdForAudioFocusListener(onAudioFocusChangeListener), onAudioFocusChangeListener);
        }
    }

    public int registerAudioPolicy(AudioPolicy audioPolicy) {
        if (audioPolicy == null) {
            throw new IllegalArgumentException("Illegal null AudioPolicy argument");
        }
        try {
            String registerAudioPolicy = getService().registerAudioPolicy(audioPolicy.getConfig(), audioPolicy.cb(), audioPolicy.hasFocusListener());
            if (registerAudioPolicy == null) {
                return -1;
            }
            audioPolicy.setRegistration(registerAudioPolicy);
            return 0;
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in registerAudioPolicyAsync()", e);
            return -1;
        }
    }

    public void registerAudioPortUpdateListener(OnAudioPortUpdateListener onAudioPortUpdateListener) {
        sAudioPortEventHandler.registerListener(onAudioPortUpdateListener);
    }

    @Deprecated
    public void registerMediaButtonEventReceiver(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            return;
        }
        registerMediaButtonIntent(pendingIntent, null);
    }

    @Deprecated
    public void registerMediaButtonEventReceiver(ComponentName componentName) {
        if (componentName == null) {
            return;
        }
        if (!componentName.getPackageName().equals(getContext().getPackageName())) {
            Log.e(TAG, "registerMediaButtonEventReceiver() error: receiver and context package names don't match");
            return;
        }
        Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        intent.addFlags(268435456);
        intent.setComponent(componentName);
        registerMediaButtonIntent(PendingIntent.getBroadcast(getContext(), 0, intent, 0), componentName);
    }

    public void registerMediaButtonIntent(PendingIntent pendingIntent, ComponentName componentName) {
        if (pendingIntent == null) {
            Log.e(TAG, "Cannot call registerMediaButtonIntent() with a null parameter");
        } else {
            MediaSessionLegacyHelper.getHelper(getContext()).addMediaButtonListener(pendingIntent, componentName, getContext());
        }
    }

    @Deprecated
    public void registerRemoteControlClient(RemoteControlClient remoteControlClient) {
        if (remoteControlClient == null || remoteControlClient.getRcMediaIntent() == null) {
            return;
        }
        remoteControlClient.registerWithSession(MediaSessionLegacyHelper.getHelper(getContext()));
    }

    public void registerRemoteControlDisplay(IRemoteControlDisplay iRemoteControlDisplay) {
        registerRemoteControlDisplay(iRemoteControlDisplay, -1, -1);
    }

    public void registerRemoteControlDisplay(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2) {
        if (iRemoteControlDisplay == null) {
            return;
        }
        try {
            getService().registerRemoteControlDisplay(iRemoteControlDisplay, i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in registerRemoteControlDisplay " + e);
        }
    }

    @Deprecated
    public boolean registerRemoteController(RemoteController remoteController) {
        if (remoteController == null) {
            return false;
        }
        remoteController.startListeningToSessions();
        try {
            getService().updateRemoteControllerOnExistingMediaPlayers();
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Error in calling Audio service interfaceupdateRemoteControllerOnExistingMediaPlayers() due to " + e);
            return true;
        }
    }

    public int releaseAudioPatch(AudioPatch audioPatch) {
        return AudioSystem.releaseAudioPatch(audioPatch);
    }

    public void reloadAudioSettings() {
        try {
            getService().reloadAudioSettings();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in reloadAudioSettings" + e);
        }
    }

    public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2) {
        if (iRemoteControlDisplay == null) {
            return;
        }
        try {
            getService().remoteControlDisplayUsesBitmapSize(iRemoteControlDisplay, i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in remoteControlDisplayUsesBitmapSize " + e);
        }
    }

    public void remoteControlDisplayWantsPlaybackPositionSync(IRemoteControlDisplay iRemoteControlDisplay, boolean z) {
        if (iRemoteControlDisplay == null) {
            return;
        }
        try {
            getService().remoteControlDisplayWantsPlaybackPositionSync(iRemoteControlDisplay, z);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in remoteControlDisplayWantsPlaybackPositionSync " + e);
        }
    }

    public int requestAudioFocus(OnAudioFocusChangeListener onAudioFocusChangeListener, int i, int i2) {
        try {
            return requestAudioFocus(onAudioFocusChangeListener, new AudioAttributes.Builder().setInternalLegacyStreamType(i).build(), i2, 0);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Audio focus request denied due to ", e);
            return 0;
        }
    }

    public int requestAudioFocus(OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes, int i, int i2) throws IllegalArgumentException {
        if (i2 != (i2 & 3)) {
            throw new IllegalArgumentException("Invalid flags 0x" + Integer.toHexString(i2).toUpperCase());
        }
        return requestAudioFocus(onAudioFocusChangeListener, audioAttributes, i, i2 & 3, null);
    }

    public int requestAudioFocus(OnAudioFocusChangeListener onAudioFocusChangeListener, AudioAttributes audioAttributes, int i, int i2, AudioPolicy audioPolicy) throws IllegalArgumentException {
        if (audioAttributes == null) {
            throw new IllegalArgumentException("Illegal null AudioAttributes argument");
        }
        if (i < 1 || i > 4) {
            throw new IllegalArgumentException("Invalid duration hint");
        }
        if (i2 != (i2 & 7)) {
            throw new IllegalArgumentException("Illegal flags 0x" + Integer.toHexString(i2).toUpperCase());
        }
        if ((i2 & 1) == 1 && onAudioFocusChangeListener == null) {
            throw new IllegalArgumentException("Illegal null focus listener when flagged as accepting delayed focus grant");
        }
        if ((i2 & 4) == 4 && audioPolicy == null) {
            throw new IllegalArgumentException("Illegal null audio policy when locking audio focus");
        }
        registerAudioFocusListener(onAudioFocusChangeListener);
        try {
            return getService().requestAudioFocus(audioAttributes, i, this.mICallBack, this.mAudioFocusDispatcher, getIdForAudioFocusListener(onAudioFocusChangeListener), getContext().getOpPackageName(), i2, audioPolicy != null ? audioPolicy.cb() : null);
        } catch (RemoteException e) {
            Log.e(TAG, "Can't call requestAudioFocus() on AudioService:", e);
            return 0;
        }
    }

    public void requestAudioFocusForCall(int i, int i2) {
        try {
            getService().requestAudioFocus(new AudioAttributes.Builder().setInternalLegacyStreamType(i).build(), i2, this.mICallBack, null, "AudioFocus_For_Phone_Ring_And_Calls", getContext().getOpPackageName(), 4, null);
        } catch (RemoteException e) {
            Log.e(TAG, "Can't call requestAudioFocusForCall() on AudioService:", e);
        }
    }

    public int setAudioPortGain(AudioPort audioPort, AudioGainConfig audioGainConfig) {
        if (audioPort == null || audioGainConfig == null) {
            return -2;
        }
        AudioPortConfig activeConfig = audioPort.activeConfig();
        AudioPortConfig audioPortConfig = new AudioPortConfig(audioPort, activeConfig.samplingRate(), activeConfig.channelMask(), activeConfig.format(), audioGainConfig);
        audioPortConfig.mConfigMask = 8;
        return AudioSystem.setAudioPortConfig(audioPortConfig);
    }

    public int setBluetoothA2dpDeviceConnectionState(BluetoothDevice bluetoothDevice, int i, int i2) {
        try {
            try {
                return getService().setBluetoothA2dpDeviceConnectionState(bluetoothDevice, i, i2);
            } catch (RemoteException e) {
                Log.e(TAG, "Dead object in setBluetoothA2dpDeviceConnectionState " + e);
                return 0;
            }
        } catch (Throwable th) {
            return 0;
        }
    }

    @Deprecated
    public void setBluetoothA2dpOn(boolean z) {
    }

    public void setBluetoothScoOn(boolean z) {
        try {
            getService().setBluetoothScoOn(z);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setBluetoothScoOn", e);
        }
    }

    public int setHdmiSystemAudioSupported(boolean z) {
        try {
            return getService().setHdmiSystemAudioSupported(z);
        } catch (RemoteException e) {
            Log.w(TAG, "Error setting system audio mode", e);
            return 0;
        }
    }

    public void setMasterMute(boolean z) {
        setMasterMute(z, 1);
    }

    public void setMasterMute(boolean z, int i) {
        try {
            getService().setMasterMute(z, i, getContext().getOpPackageName(), this.mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setMasterMute", e);
        }
    }

    public void setMasterVolume(int i, int i2) {
        try {
            getService().setMasterVolume(i, i2, getContext().getOpPackageName());
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setMasterVolume", e);
        }
    }

    public void setMicrophoneMute(boolean z) {
        try {
            getService().setMicrophoneMute(z, getContext().getOpPackageName());
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setMicrophoneMute", e);
        }
    }

    public void setMode(int i) {
        try {
            getService().setMode(i, this.mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setMode", e);
        }
    }

    @Deprecated
    public void setParameter(String str, String str2) {
        setParameters(str + "=" + str2);
    }

    public void setParameters(String str) {
        AudioSystem.setParameters(str);
    }

    public void setRemoteControlClientBrowsedPlayer() {
        Log.d(TAG, "setRemoteControlClientBrowsedPlayer: ");
        try {
            getService().setRemoteControlClientBrowsedPlayer();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setRemoteControlClientBrowsedPlayer()", e);
        }
    }

    public void setRemoteControlClientPlayItem(long j, int i) {
        try {
            getService().setRemoteControlClientPlayItem(j, i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setRemoteControlClientPlayItem(" + j + ", " + i + ")", e);
        }
    }

    public void setRingerMode(int i) {
        if (isValidRingerMode(i)) {
            try {
                getService().setRingerModeExternal(i, getContext().getOpPackageName());
            } catch (RemoteException e) {
                Log.e(TAG, "Dead object in setRingerMode", e);
            }
        }
    }

    public void setRingerModeInternal(int i) {
        try {
            getService().setRingerModeInternal(i, getContext().getOpPackageName());
        } catch (RemoteException e) {
            Log.w(TAG, "Error calling setRingerModeInternal", e);
        }
    }

    @Deprecated
    public void setRouting(int i, int i2, int i3) {
    }

    public void setSpeakerphoneOn(boolean z) {
        try {
            getService().setSpeakerphoneOn(z);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setSpeakerphoneOn", e);
        }
    }

    public void setStreamMute(int i, boolean z) {
        try {
            getService().setStreamMute(i, z, this.mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setStreamMute", e);
        }
    }

    public void setStreamSolo(int i, boolean z) {
        try {
            getService().setStreamSolo(i, z, this.mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setStreamSolo", e);
        }
    }

    public void setStreamVolume(int i, int i2, int i3) {
        IAudioService service = getService();
        try {
            if (this.mUseMasterVolume) {
                service.setMasterVolume(i2, i3, getContext().getOpPackageName());
            } else {
                service.setStreamVolume(i, i2, i3, getContext().getOpPackageName());
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setStreamVolume", e);
        }
    }

    public void setVibrateSetting(int i, int i2) {
        try {
            getService().setVibrateSetting(i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setVibrateSetting", e);
        }
    }

    public void setVolumeController(IVolumeController iVolumeController) {
        try {
            getService().setVolumeController(iVolumeController);
        } catch (RemoteException e) {
            Log.w(TAG, "Error setting volume controller", e);
        }
    }

    public void setWiredDeviceConnectionState(int i, int i2, String str) {
        try {
            getService().setWiredDeviceConnectionState(i, i2, str);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setWiredDeviceConnectionState " + e);
        }
    }

    @Deprecated
    public void setWiredHeadsetOn(boolean z) {
    }

    public boolean shouldVibrate(int i) {
        try {
            return getService().shouldVibrate(i);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in shouldVibrate", e);
            return false;
        }
    }

    public void startBluetoothSco() {
        try {
            getService().startBluetoothSco(this.mICallBack, getContext().getApplicationInfo().targetSdkVersion);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in startBluetoothSco", e);
        }
    }

    public void startBluetoothScoVirtualCall() {
        try {
            getService().startBluetoothScoVirtualCall(this.mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in startBluetoothScoVirtualCall", e);
        }
    }

    public void stopBluetoothSco() {
        try {
            getService().stopBluetoothSco(this.mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in stopBluetoothSco", e);
        }
    }

    public void unloadSoundEffects() {
        try {
            getService().unloadSoundEffects();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in unloadSoundEffects" + e);
        }
    }

    public void unregisterAudioFocusListener(OnAudioFocusChangeListener onAudioFocusChangeListener) {
        synchronized (this.mFocusListenerLock) {
            this.mAudioFocusIdListenerMap.remove(getIdForAudioFocusListener(onAudioFocusChangeListener));
        }
    }

    public void unregisterAudioPolicyAsync(AudioPolicy audioPolicy) {
        if (audioPolicy == null) {
            throw new IllegalArgumentException("Illegal null AudioPolicy argument");
        }
        try {
            getService().unregisterAudioPolicyAsync(audioPolicy.cb());
            audioPolicy.setRegistration(null);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in unregisterAudioPolicyAsync()", e);
        }
    }

    public void unregisterAudioPortUpdateListener(OnAudioPortUpdateListener onAudioPortUpdateListener) {
        sAudioPortEventHandler.unregisterListener(onAudioPortUpdateListener);
    }

    @Deprecated
    public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            return;
        }
        unregisterMediaButtonIntent(pendingIntent);
    }

    @Deprecated
    public void unregisterMediaButtonEventReceiver(ComponentName componentName) {
        if (componentName == null) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        intent.setComponent(componentName);
        unregisterMediaButtonIntent(PendingIntent.getBroadcast(getContext(), 0, intent, 0));
    }

    public void unregisterMediaButtonIntent(PendingIntent pendingIntent) {
        MediaSessionLegacyHelper.getHelper(getContext()).removeMediaButtonListener(pendingIntent);
    }

    @Deprecated
    public void unregisterRemoteControlClient(RemoteControlClient remoteControlClient) {
        if (remoteControlClient == null || remoteControlClient.getRcMediaIntent() == null) {
            return;
        }
        remoteControlClient.unregisterWithSession(MediaSessionLegacyHelper.getHelper(getContext()));
    }

    public void unregisterRemoteControlDisplay(IRemoteControlDisplay iRemoteControlDisplay) {
        if (iRemoteControlDisplay == null) {
            return;
        }
        try {
            getService().unregisterRemoteControlDisplay(iRemoteControlDisplay);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in unregisterRemoteControlDisplay " + e);
        }
    }

    @Deprecated
    public void unregisterRemoteController(RemoteController remoteController) {
        if (remoteController == null) {
            return;
        }
        remoteController.stopListeningToSessions();
    }

    public void updateMediaPlayerList(String str, boolean z) {
        IAudioService service = getService();
        try {
            if (z) {
                Log.d(TAG, "updateMediaPlayerList: Add RCC " + str + " to List");
                service.addMediaPlayerAndUpdateRemoteController(str);
                return;
            }
            Log.d(TAG, "updateMediaPlayerList: Remove RCC " + str + " from List");
            service.removeMediaPlayerAndUpdateRemoteController(str);
        } catch (RemoteException e) {
            Log.e(TAG, "Exception while executing updateMediaPlayerList: " + e);
        }
    }
}
