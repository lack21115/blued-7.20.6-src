package android.media;

import android.Manifest;
import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.ContentObserver;
import android.hardware.hdmi.HdmiControlManager;
import android.hardware.hdmi.HdmiPlaybackClient;
import android.hardware.hdmi.HdmiTvClient;
import android.hardware.usb.UsbManager;
import android.media.AudioAttributes;
import android.media.AudioManagerInternal;
import android.media.AudioSystem;
import android.media.IAudioService;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.audiopolicy.AudioPolicyConfig;
import android.media.audiopolicy.IAudioPolicyCallback;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.Vibrator;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.MathUtils;
import android.util.Slog;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.R;
import com.android.internal.util.XmlUtils;
import com.android.server.LocalServices;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.zego.zegoliveroom.constants.ZegoConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioService.class */
public class AudioService extends IAudioService.Stub {
    private static final String ASSET_FILE_VERSION = "1.0";
    private static final String ATTR_ASSET_FILE = "file";
    private static final String ATTR_ASSET_ID = "id";
    private static final String ATTR_GROUP_NAME = "name";
    private static final String ATTR_VERSION = "version";
    private static final int BTA2DP_DOCK_TIMEOUT_MILLIS = 8000;
    private static final int BT_HEADSET_CNCT_TIMEOUT_MS = 3000;
    private static final int FLAG_ADJUST_VOLUME = 1;
    private static final String GROUP_TOUCH_SOUNDS = "touch_sounds";
    private static final int MAX_BATCH_VOLUME_ADJUST_STEPS = 4;
    private static final int MAX_MASTER_VOLUME = 100;
    private static final int MSG_BROADCAST_AUDIO_BECOMING_NOISY = 15;
    private static final int MSG_BROADCAST_BT_CONNECTION_STATE = 19;
    private static final int MSG_BTA2DP_DOCK_TIMEOUT = 6;
    private static final int MSG_BT_HEADSET_CNCT_FAILED = 9;
    private static final int MSG_CHECK_MUSIC_ACTIVE = 14;
    private static final int MSG_CONFIGURE_SAFE_MEDIA_VOLUME = 16;
    private static final int MSG_CONFIGURE_SAFE_MEDIA_VOLUME_FORCED = 17;
    private static final int MSG_LOAD_SOUND_EFFECTS = 7;
    private static final int MSG_MEDIA_SERVER_DIED = 4;
    private static final int MSG_PERSIST_MASTER_VOLUME = 2;
    private static final int MSG_PERSIST_MASTER_VOLUME_MUTE = 11;
    private static final int MSG_PERSIST_MICROPHONE_MUTE = 23;
    private static final int MSG_PERSIST_MUSIC_ACTIVE_MS = 22;
    private static final int MSG_PERSIST_RINGER_MODE = 3;
    private static final int MSG_PERSIST_SAFE_VOLUME_STATE = 18;
    private static final int MSG_PERSIST_VOLUME = 1;
    private static final int MSG_PLAY_SOUND_EFFECT = 5;
    private static final int MSG_REPORT_NEW_ROUTES = 12;
    private static final int MSG_SET_A2DP_SINK_CONNECTION_STATE = 102;
    private static final int MSG_SET_A2DP_SRC_CONNECTION_STATE = 101;
    private static final int MSG_SET_ALL_VOLUMES = 10;
    private static final int MSG_SET_DEVICE_VOLUME = 0;
    private static final int MSG_SET_FORCE_BT_A2DP_USE = 13;
    private static final int MSG_SET_FORCE_USE = 8;
    private static final int MSG_SET_WIRED_DEVICE_CONNECTION_STATE = 100;
    private static final int MSG_SYSTEM_READY = 21;
    private static final int MSG_UNLOAD_SOUND_EFFECTS = 20;
    private static final int MUSIC_ACTIVE_POLL_PERIOD_MS = 60000;
    private static final int NUM_SOUNDPOOL_CHANNELS = 4;
    private static final int PERSIST_DELAY = 500;
    private static final int PLATFORM_DEFAULT = 0;
    private static final int PLATFORM_TELEVISION = 2;
    private static final int PLATFORM_VOICE = 1;
    public static final int PLAY_SOUND_DELAY = 300;
    private static final boolean PREVENT_VOLUME_ADJUSTMENT_IF_SILENT = false;
    private static final int SAFE_MEDIA_VOLUME_ACTIVE = 3;
    private static final int SAFE_MEDIA_VOLUME_DISABLED = 1;
    private static final int SAFE_MEDIA_VOLUME_INACTIVE = 2;
    private static final int SAFE_MEDIA_VOLUME_NOT_CONFIGURED = 0;
    private static final int SAFE_VOLUME_CONFIGURE_TIMEOUT_MS = 30000;
    private static final int SCO_MODE_MAX = 2;
    private static final int SCO_MODE_RAW = 1;
    private static final int SCO_MODE_UNDEFINED = -1;
    private static final int SCO_MODE_VIRTUAL_CALL = 0;
    private static final int SCO_MODE_VR = 2;
    private static final int SCO_STATE_ACTIVATE_REQ = 1;
    private static final int SCO_STATE_ACTIVE_EXTERNAL = 2;
    private static final int SCO_STATE_ACTIVE_INTERNAL = 3;
    private static final int SCO_STATE_DEACTIVATE_EXT_REQ = 4;
    private static final int SCO_STATE_DEACTIVATE_REQ = 5;
    private static final int SCO_STATE_INACTIVE = 0;
    private static final int SENDMSG_NOOP = 1;
    private static final int SENDMSG_QUEUE = 2;
    private static final int SENDMSG_REPLACE = 0;
    private static final int SOUND_EFFECTS_LOAD_TIMEOUT_MS = 5000;
    private static final String SOUND_EFFECTS_PATH = "/media/audio/ui/";
    private static final String TAG = "AudioService";
    private static final String TAG_ASSET = "asset";
    private static final String TAG_AUDIO_ASSETS = "audio_assets";
    private static final String TAG_GROUP = "group";
    private static final int UNSAFE_VOLUME_MUSIC_ACTIVE_MS_MAX = 72000000;
    private static final boolean VOLUME_SETS_RINGER_MODE_SILENT = true;
    private static int sSoundEffectVolumeDb;
    private BluetoothA2dp mA2dp;
    private final AppOpsManager mAppOps;
    private PowerManager.WakeLock mAudioEventWakeLock;
    private AudioHandler mAudioHandler;
    private AudioSystemThread mAudioSystemThread;
    private boolean mBluetoothA2dpEnabled;
    private BluetoothHeadset mBluetoothHeadset;
    private BluetoothDevice mBluetoothHeadsetDevice;
    private Boolean mCameraSoundForced;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private int mDeviceRotation;
    private String mDockAddress;
    private boolean mForceAnalogCarDock;
    private boolean mForceAnalogDeskDock;
    private int mForcedUseForComm;
    private final boolean mHasVibrator;
    private boolean mHdmiCecSink;
    private HdmiControlManager mHdmiManager;
    private HdmiPlaybackClient mHdmiPlaybackClient;
    private HdmiTvClient mHdmiTvClient;
    private String mHotwordAudioInputPackage;
    private KeyguardManager mKeyguardManager;
    private boolean mLinkNotificationWithVolume;
    private final int[] mMasterVolumeRamp;
    private final MediaFocusControl mMediaFocusControl;
    private final boolean mMonitorOrientation;
    private final boolean mMonitorRotation;
    private int mMusicActiveMs;
    private int mMuteAffectedStreams;
    private AudioOrientationEventListener mOrientationListener;
    private StreamVolumeCommand mPendingVolumeCommand;
    private final int mPlatformType;
    private int mRingerMode;
    private AudioManagerInternal.RingerModeDelegate mRingerModeDelegate;
    private int mRingerModeMutedStreams;
    private volatile IRingtonePlayer mRingtonePlayer;
    private int mSafeMediaVolumeIndex;
    private Integer mSafeMediaVolumeState;
    private int mScoAudioMode;
    private int mScoAudioState;
    private int mScoConnectionState;
    private SettingsObserver mSettingsObserver;
    private SoundPool mSoundPool;
    private SoundPoolCallback mSoundPoolCallBack;
    private SoundPoolListenerThread mSoundPoolListenerThread;
    private VolumeStreamState[] mStreamStates;
    private int[] mStreamVolumeAlias;
    private boolean mSystemReady;
    private final boolean mUseFixedVolume;
    private final boolean mUseMasterVolume;
    private int mVibrateSetting;
    private final boolean mVoiceCapable;
    private boolean mVolumeKeysControlRingStream;
    protected static final boolean DEBUG_MODE = Log.isLoggable("AudioService.MOD", 3);
    protected static final boolean DEBUG_AP = Log.isLoggable("AudioService.AP", 3);
    protected static final boolean DEBUG_VOL = Log.isLoggable("AudioService.VOL", 3);
    private static final boolean DEBUG_SESSIONS = Log.isLoggable("AudioService.SESSIONS", 3);
    private static final ArrayList<MediaPlayerInfo> mMediaPlayers = new ArrayList<>();
    private static final List<String> SOUND_EFFECT_FILES = new ArrayList();
    private static int[] MAX_STREAM_VOLUME = {5, 7, 7, 15, 7, 7, 15, 7, 15, 15};
    private static int[] DEFAULT_STREAM_VOLUME = {4, 7, 5, 11, 6, 5, 7, 7, 11, 11};
    private static final int[] STEAM_VOLUME_OPS = {34, 36, 35, 36, 37, 38, 39, 36, 36, 36};
    private static final String[] STREAM_NAMES = {"STREAM_VOICE_CALL", "STREAM_SYSTEM", "STREAM_RING", "STREAM_MUSIC", "STREAM_ALARM", "STREAM_NOTIFICATION", "STREAM_BLUETOOTH_SCO", "STREAM_SYSTEM_ENFORCED", "STREAM_DTMF", "STREAM_TTS"};
    private static Long mLastDeviceConnectMsgTime = new Long(0);
    private static final String[] RINGER_MODE_NAMES = {"SILENT", "VIBRATE", "NORMAL"};
    private final VolumeController mVolumeController = new VolumeController();
    private int mMode = 0;
    private final Object mSettingsLock = new Object();
    private final Object mSoundEffectsLock = new Object();
    private final int[][] SOUND_EFFECT_FILES_MAP = (int[][]) Array.newInstance(Integer.TYPE, 10, 2);
    private final int[] STREAM_VOLUME_ALIAS_VOICE = {0, 2, 2, 3, 4, 2, 6, 2, 2, 3};
    private final int[] STREAM_VOLUME_ALIAS_TELEVISION = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
    private final int[] STREAM_VOLUME_ALIAS_DEFAULT = {0, 2, 2, 3, 4, 2, 6, 2, 2, 3};
    private final AudioSystem.ErrorCallback mAudioSystemCallback = new AudioSystem.ErrorCallback() { // from class: android.media.AudioService.1
        @Override // android.media.AudioSystem.ErrorCallback
        public void onError(int i) {
            switch (i) {
                case 100:
                    AudioService.sendMsg(AudioService.this.mAudioHandler, 4, 1, 0, 0, null, 0);
                    return;
                default:
                    return;
            }
        }
    };
    private int mRingerModeExternal = -1;
    private int mRingerModeAffectedStreams = 0;
    private Object mHotwordInputLock = new Object();
    private final BroadcastReceiver mReceiver = new AudioServiceBroadcastReceiver();
    private final HashMap<Integer, String> mConnectedDevices = new HashMap<>();
    private final ArrayList<SetModeDeathHandler> mSetModeDeathHandlers = new ArrayList<>();
    private final ArrayList<ScoClient> mScoClients = new ArrayList<>();
    private Looper mSoundPoolLooper = null;
    private int mPrevVolDirection = 0;
    private int mVolumeControlStream = -1;
    private final Object mForceControlStreamLock = new Object();
    private ForceControlStreamClient mForceControlStreamClient = null;
    private int mDeviceOrientation = 0;
    private final Object mBluetoothA2dpEnabledLock = new Object();
    final AudioRoutesInfo mCurAudioRoutes = new AudioRoutesInfo();
    final RemoteCallbackList<IAudioRoutesObserver> mRoutesObservers = new RemoteCallbackList<>();
    int mFixedVolumeDevices = 36443136;
    int mFullVolumeDevices = 0;
    private boolean mDockAudioMediaEnabled = true;
    private int mDockState = 0;
    private final Object mA2dpAvrcpLock = new Object();
    private boolean mAvrcpAbsVolSupported = false;
    private int mRmtSbmxFullVolRefCount = 0;
    private ArrayList<RmtSbmxFullVolDeathHandler> mRmtSbmxFullVolDeathHandlers = new ArrayList<>();
    private BluetoothProfile.ServiceListener mBluetoothProfileServiceListener = new BluetoothProfile.ServiceListener() { // from class: android.media.AudioService.2
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            switch (i) {
                case 1:
                    synchronized (AudioService.this.mScoClients) {
                        AudioService.this.mAudioHandler.removeMessages(9);
                        AudioService.this.mBluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
                        List<BluetoothDevice> connectedDevices = AudioService.this.mBluetoothHeadset.getConnectedDevices();
                        if (connectedDevices.size() > 0) {
                            AudioService.this.mBluetoothHeadsetDevice = connectedDevices.get(0);
                        } else {
                            AudioService.this.mBluetoothHeadsetDevice = null;
                        }
                        AudioService.this.checkScoAudioState();
                        if (AudioService.this.mScoAudioState == 1 || AudioService.this.mScoAudioState == 5 || AudioService.this.mScoAudioState == 4) {
                            boolean z = false;
                            if (AudioService.this.mBluetoothHeadsetDevice != null) {
                                z = false;
                                switch (AudioService.this.mScoAudioState) {
                                    case 1:
                                        AudioService.this.mScoAudioState = 3;
                                        if (AudioService.this.mScoAudioMode != 2) {
                                            z = AudioService.this.mBluetoothHeadset.startScoUsingVirtualVoiceCall(AudioService.this.mBluetoothHeadsetDevice);
                                            break;
                                        } else {
                                            z = AudioService.this.mBluetoothHeadset.startVoiceRecognition(AudioService.this.mBluetoothHeadsetDevice);
                                            break;
                                        }
                                    case 2:
                                    case 3:
                                        break;
                                    case 4:
                                        z = AudioService.this.mBluetoothHeadset.stopVoiceRecognition(AudioService.this.mBluetoothHeadsetDevice);
                                        break;
                                    case 5:
                                        if (AudioService.this.mScoAudioMode != 2) {
                                            z = AudioService.this.mBluetoothHeadset.stopScoUsingVirtualVoiceCall(AudioService.this.mBluetoothHeadsetDevice);
                                            break;
                                        } else {
                                            z = AudioService.this.mBluetoothHeadset.stopVoiceRecognition(AudioService.this.mBluetoothHeadsetDevice);
                                            break;
                                        }
                                    default:
                                        z = false;
                                        break;
                                }
                            }
                            if (!z) {
                                AudioService.sendMsg(AudioService.this.mAudioHandler, 9, 0, 0, 0, null, 0);
                            }
                        }
                    }
                    return;
                case 2:
                    synchronized (AudioService.this.mA2dpAvrcpLock) {
                        AudioService.this.mA2dp = (BluetoothA2dp) bluetoothProfile;
                        List<BluetoothDevice> connectedDevices2 = AudioService.this.mA2dp.getConnectedDevices();
                        if (connectedDevices2.size() > 0) {
                            BluetoothDevice bluetoothDevice = connectedDevices2.get(0);
                            synchronized (AudioService.this.mConnectedDevices) {
                                int connectionState = AudioService.this.mA2dp.getConnectionState(bluetoothDevice);
                                AudioService.this.queueMsgUnderWakeLock(AudioService.this.mAudioHandler, 102, connectionState, 0, bluetoothDevice, AudioService.this.checkSendBecomingNoisyIntent(128, connectionState == 2 ? 1 : 0));
                            }
                        }
                    }
                    return;
                case 10:
                    List<BluetoothDevice> connectedDevices3 = bluetoothProfile.getConnectedDevices();
                    if (connectedDevices3.size() > 0) {
                        BluetoothDevice bluetoothDevice2 = connectedDevices3.get(0);
                        synchronized (AudioService.this.mConnectedDevices) {
                            AudioService.this.queueMsgUnderWakeLock(AudioService.this.mAudioHandler, 101, bluetoothProfile.getConnectionState(bluetoothDevice2), 0, bluetoothDevice2, 0);
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            Log.d(AudioService.TAG, "onServiceDisconnected: Bluetooth profile: " + i);
            switch (i) {
                case 1:
                    synchronized (AudioService.this.mScoClients) {
                        AudioService.this.mBluetoothHeadset = null;
                        synchronized (AudioService.this.mConnectedDevices) {
                            if (AudioService.this.mForcedUseForComm == 3) {
                                Log.d(AudioService.TAG, "Hfp service disconnects, update device to NONE");
                                AudioService.this.mForcedUseForComm = 0;
                                AudioService.sendMsg(AudioService.this.mAudioHandler, 8, 2, 0, AudioService.this.mForcedUseForComm, null, 0);
                                AudioService.sendMsg(AudioService.this.mAudioHandler, 8, 2, 2, AudioService.this.mForcedUseForComm, null, 0);
                            }
                        }
                    }
                    return;
                case 2:
                    synchronized (AudioService.this.mA2dpAvrcpLock) {
                        AudioService.this.mA2dp = null;
                        synchronized (AudioService.this.mConnectedDevices) {
                            if (AudioService.this.mConnectedDevices.containsKey(128)) {
                                Log.d(AudioService.TAG, "A2dp service disconnects, pause music player");
                                AudioService.this.queueMsgUnderWakeLock(AudioService.this.mAudioHandler, 101, 0, 0, BluetoothAdapter.getDefaultAdapter().getRemoteDevice((String) AudioService.this.mConnectedDevices.get(128)), AudioService.this.checkSendBecomingNoisyIntent(128, 0));
                            }
                        }
                    }
                    return;
                case 10:
                    synchronized (AudioService.this.mConnectedDevices) {
                        if (AudioService.this.mConnectedDevices.containsKey(Integer.valueOf((int) AudioSystem.DEVICE_IN_BLUETOOTH_A2DP))) {
                            AudioService.this.makeA2dpSrcUnavailable((String) AudioService.this.mConnectedDevices.get(Integer.valueOf((int) AudioSystem.DEVICE_IN_BLUETOOTH_A2DP)));
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    int mBecomingNoisyIntentDevices = 163724;
    private int mMcc = 0;
    private final int mSafeMediaVolumeDevices = 12;
    private boolean mHdmiSystemAudioSupported = false;
    private MyDisplayStatusCallback mHdmiDisplayStatusCallback = new MyDisplayStatusCallback();
    private HashMap<IBinder, AudioPolicyProxy> mAudioPolicies = new HashMap<>();
    private int mAudioPolicyCounter = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$AudioHandler.class */
    public class AudioHandler extends Handler {
        private AudioHandler() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanupPlayer(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                } catch (IllegalStateException e) {
                    Log.w(AudioService.TAG, "MediaPlayer IllegalStateException: " + e);
                }
            }
        }

        private boolean onLoadSoundEffects() {
            int i;
            synchronized (AudioService.this.mSoundEffectsLock) {
                if (!AudioService.this.mSystemReady) {
                    Log.w(AudioService.TAG, "onLoadSoundEffects() called before boot complete");
                    return false;
                } else if (AudioService.this.mSoundPool != null) {
                    return true;
                } else {
                    AudioService.this.loadTouchSoundAssets();
                    AudioService.this.mSoundPool = new SoundPool.Builder().setMaxStreams(4).setAudioAttributes(new AudioAttributes.Builder().setUsage(13).setContentType(4).build()).build();
                    AudioService.this.mSoundPoolCallBack = null;
                    AudioService.this.mSoundPoolListenerThread = new SoundPoolListenerThread();
                    AudioService.this.mSoundPoolListenerThread.start();
                    int i2 = 3;
                    while (true) {
                        int i3 = i2;
                        if (AudioService.this.mSoundPoolCallBack != null) {
                            break;
                        }
                        int i4 = i3 - 1;
                        if (i3 <= 0) {
                            break;
                        }
                        try {
                            AudioService.this.mSoundEffectsLock.wait(5000L);
                            i2 = i4;
                        } catch (InterruptedException e) {
                            Log.w(AudioService.TAG, "Interrupted while waiting sound pool listener thread.");
                            i2 = i4;
                        }
                    }
                    if (AudioService.this.mSoundPoolCallBack == null) {
                        Log.w(AudioService.TAG, "onLoadSoundEffects() SoundPool listener or thread creation error");
                        if (AudioService.this.mSoundPoolLooper != null) {
                            AudioService.this.mSoundPoolLooper.quit();
                            AudioService.this.mSoundPoolLooper = null;
                        }
                        AudioService.this.mSoundPoolListenerThread = null;
                        AudioService.this.mSoundPool.release();
                        AudioService.this.mSoundPool = null;
                        return false;
                    }
                    int[] iArr = new int[AudioService.SOUND_EFFECT_FILES.size()];
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= AudioService.SOUND_EFFECT_FILES.size()) {
                            break;
                        }
                        iArr[i6] = -1;
                        i5 = i6 + 1;
                    }
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        int i9 = i8;
                        if (i9 >= 10) {
                            break;
                        }
                        if (AudioService.this.SOUND_EFFECT_FILES_MAP[i9][1] != 0) {
                            if (iArr[AudioService.this.SOUND_EFFECT_FILES_MAP[i9][0]] == -1) {
                                String str = Environment.getRootDirectory() + AudioService.SOUND_EFFECTS_PATH + ((String) AudioService.SOUND_EFFECT_FILES.get(AudioService.this.SOUND_EFFECT_FILES_MAP[i9][0]));
                                int load = AudioService.this.mSoundPool.load(str, 0);
                                if (load <= 0) {
                                    Log.w(AudioService.TAG, "Soundpool could not load file: " + str);
                                } else {
                                    AudioService.this.SOUND_EFFECT_FILES_MAP[i9][1] = load;
                                    iArr[AudioService.this.SOUND_EFFECT_FILES_MAP[i9][0]] = load;
                                    i7++;
                                }
                            } else {
                                AudioService.this.SOUND_EFFECT_FILES_MAP[i9][1] = iArr[AudioService.this.SOUND_EFFECT_FILES_MAP[i9][0]];
                            }
                        }
                        i8 = i9 + 1;
                    }
                    if (i7 > 0) {
                        AudioService.this.mSoundPoolCallBack.setSamples(iArr);
                        int i10 = 1;
                        int i11 = 3;
                        while (true) {
                            int i12 = i11;
                            if (i10 != 1) {
                                i = i10;
                                break;
                            }
                            int i13 = i12 - 1;
                            i = i10;
                            if (i12 <= 0) {
                                break;
                            }
                            try {
                                AudioService.this.mSoundEffectsLock.wait(5000L);
                                i10 = AudioService.this.mSoundPoolCallBack.status();
                                i11 = i13;
                            } catch (InterruptedException e2) {
                                Log.w(AudioService.TAG, "Interrupted while waiting sound pool callback.");
                                i11 = i13;
                            }
                        }
                    } else {
                        i = -1;
                    }
                    if (AudioService.this.mSoundPoolLooper != null) {
                        AudioService.this.mSoundPoolLooper.quit();
                        AudioService.this.mSoundPoolLooper = null;
                    }
                    AudioService.this.mSoundPoolListenerThread = null;
                    if (i != 0) {
                        Log.w(AudioService.TAG, "onLoadSoundEffects(), Error " + i + " while loading samples");
                        int i14 = 0;
                        while (true) {
                            int i15 = i14;
                            if (i15 >= 10) {
                                break;
                            }
                            if (AudioService.this.SOUND_EFFECT_FILES_MAP[i15][1] > 0) {
                                AudioService.this.SOUND_EFFECT_FILES_MAP[i15][1] = -1;
                            }
                            i14 = i15 + 1;
                        }
                        AudioService.this.mSoundPool.release();
                        AudioService.this.mSoundPool = null;
                    }
                    return i == 0;
                }
            }
        }

        private void onPersistSafeVolumeState(int i) {
            Settings.Global.putInt(AudioService.this.mContentResolver, Settings.Global.AUDIO_SAFE_VOLUME_STATE, i);
        }

        private void onPlaySoundEffect(int i, int i2) {
            synchronized (AudioService.this.mSoundEffectsLock) {
                onLoadSoundEffects();
                if (AudioService.this.mSoundPool == null) {
                    return;
                }
                float pow = i2 < 0 ? (float) Math.pow(10.0d, AudioService.sSoundEffectVolumeDb / 20.0f) : i2 / 1000.0f;
                if (AudioService.this.SOUND_EFFECT_FILES_MAP[i][1] > 0) {
                    AudioService.this.mSoundPool.play(AudioService.this.SOUND_EFFECT_FILES_MAP[i][1], pow, pow, 0, 0, 1.0f);
                } else {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    try {
                        try {
                            try {
                                mediaPlayer.setDataSource(Environment.getRootDirectory() + AudioService.SOUND_EFFECTS_PATH + ((String) AudioService.SOUND_EFFECT_FILES.get(AudioService.this.SOUND_EFFECT_FILES_MAP[i][0])));
                                mediaPlayer.setAudioStreamType(1);
                                mediaPlayer.prepare();
                                mediaPlayer.setVolume(pow);
                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: android.media.AudioService.AudioHandler.1
                                    @Override // android.media.MediaPlayer.OnCompletionListener
                                    public void onCompletion(MediaPlayer mediaPlayer2) {
                                        AudioHandler.this.cleanupPlayer(mediaPlayer2);
                                    }
                                });
                                mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: android.media.AudioService.AudioHandler.2
                                    @Override // android.media.MediaPlayer.OnErrorListener
                                    public boolean onError(MediaPlayer mediaPlayer2, int i3, int i4) {
                                        AudioHandler.this.cleanupPlayer(mediaPlayer2);
                                        return true;
                                    }
                                });
                                mediaPlayer.start();
                            } catch (IOException e) {
                                Log.w(AudioService.TAG, "MediaPlayer IOException: " + e);
                            }
                        } catch (IllegalArgumentException e2) {
                            Log.w(AudioService.TAG, "MediaPlayer IllegalArgumentException: " + e2);
                        }
                    } catch (IllegalStateException e3) {
                        Log.w(AudioService.TAG, "MediaPlayer IllegalStateException: " + e3);
                    }
                }
            }
        }

        private void onUnloadSoundEffects() {
            synchronized (AudioService.this.mSoundEffectsLock) {
                if (AudioService.this.mSoundPool == null) {
                    return;
                }
                int[] iArr = new int[AudioService.SOUND_EFFECT_FILES.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= AudioService.SOUND_EFFECT_FILES.size()) {
                        break;
                    }
                    iArr[i2] = 0;
                    i = i2 + 1;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= 10) {
                        AudioService.this.mSoundPool.release();
                        AudioService.this.mSoundPool = null;
                        return;
                    }
                    if (AudioService.this.SOUND_EFFECT_FILES_MAP[i4][1] > 0 && iArr[AudioService.this.SOUND_EFFECT_FILES_MAP[i4][0]] == 0) {
                        AudioService.this.mSoundPool.unload(AudioService.this.SOUND_EFFECT_FILES_MAP[i4][1]);
                        AudioService.this.SOUND_EFFECT_FILES_MAP[i4][1] = -1;
                        iArr[AudioService.this.SOUND_EFFECT_FILES_MAP[i4][0]] = -1;
                    }
                    i3 = i4 + 1;
                }
            }
        }

        private void persistRingerMode(int i) {
            if (AudioService.this.mUseFixedVolume) {
                return;
            }
            Settings.Global.putInt(AudioService.this.mContentResolver, "mode_ringer", i);
        }

        private void persistVolume(VolumeStreamState volumeStreamState, int i) {
            if (AudioService.this.mUseFixedVolume) {
                return;
            }
            if (!AudioService.this.isPlatformTelevision() || volumeStreamState.mStreamType == 3) {
                Settings.System.putIntForUser(AudioService.this.mContentResolver, volumeStreamState.getSettingNameForDevice(i), (volumeStreamState.getIndex(i) + 5) / 10, -2);
            }
        }

        private void setAllVolumes(VolumeStreamState volumeStreamState) {
            volumeStreamState.applyAllVolumes();
            int numStreamTypes = AudioSystem.getNumStreamTypes();
            while (true) {
                int i = numStreamTypes - 1;
                if (i < 0) {
                    return;
                }
                if (i != volumeStreamState.mStreamType && AudioService.this.mStreamVolumeAlias[i] == volumeStreamState.mStreamType) {
                    AudioService.this.mStreamStates[i].applyAllVolumes();
                }
                numStreamTypes = i;
            }
        }

        private void setDeviceVolume(VolumeStreamState volumeStreamState, int i) {
            synchronized (VolumeStreamState.class) {
                try {
                    volumeStreamState.applyDeviceVolume_syncVSS(i);
                    int numStreamTypes = AudioSystem.getNumStreamTypes();
                    while (true) {
                        int i2 = numStreamTypes - 1;
                        if (i2 >= 0) {
                            if (i2 != volumeStreamState.mStreamType && AudioService.this.mStreamVolumeAlias[i2] == volumeStreamState.mStreamType) {
                                int deviceForStream = AudioService.this.getDeviceForStream(i2);
                                if (i != deviceForStream && AudioService.this.mAvrcpAbsVolSupported && (i & AudioSystem.DEVICE_OUT_ALL_A2DP) != 0) {
                                    AudioService.this.mStreamStates[i2].applyDeviceVolume_syncVSS(i);
                                }
                                AudioService.this.mStreamStates[i2].applyDeviceVolume_syncVSS(deviceForStream);
                            }
                            numStreamTypes = i2;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            AudioService.sendMsg(AudioService.this.mAudioHandler, 1, 2, i, 0, volumeStreamState, 500);
        }

        private void setForceUse(int i, int i2) {
            AudioSystem.setForceUse(i, i2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AudioRoutesInfo audioRoutesInfo;
            switch (message.what) {
                case 0:
                    setDeviceVolume((VolumeStreamState) message.obj, message.arg1);
                    return;
                case 1:
                    persistVolume((VolumeStreamState) message.obj, message.arg1);
                    return;
                case 2:
                    if (AudioService.this.mUseFixedVolume) {
                        return;
                    }
                    Settings.System.putFloatForUser(AudioService.this.mContentResolver, Settings.System.VOLUME_MASTER, message.arg1 / 1000.0f, -2);
                    return;
                case 3:
                    persistRingerMode(AudioService.this.getRingerModeInternal());
                    return;
                case 4:
                    if (!AudioService.this.mSystemReady || AudioSystem.checkAudioFlinger() != 0) {
                        Log.e(AudioService.TAG, "Media server died.");
                        AudioService.sendMsg(AudioService.this.mAudioHandler, 4, 1, 0, 0, null, 500);
                        return;
                    }
                    Log.e(AudioService.TAG, "Media server started.");
                    AudioSystem.setParameters("restarting=true");
                    AudioService.readAndSetLowRamDevice();
                    synchronized (AudioService.this.mConnectedDevices) {
                        for (Map.Entry entry : AudioService.this.mConnectedDevices.entrySet()) {
                            AudioSystem.setDeviceConnectionState(((Integer) entry.getKey()).intValue(), 1, (String) entry.getValue());
                        }
                    }
                    AudioSystem.setPhoneState(AudioService.this.mMode);
                    AudioSystem.setForceUse(0, AudioService.this.mForcedUseForComm);
                    AudioSystem.setForceUse(2, AudioService.this.mForcedUseForComm);
                    AudioSystem.setForceUse(4, AudioService.this.mCameraSoundForced.booleanValue() ? 11 : 0);
                    int numStreamTypes = AudioSystem.getNumStreamTypes();
                    while (true) {
                        int i = numStreamTypes - 1;
                        if (i < 0) {
                            AudioService.this.setRingerModeInt(AudioService.this.getRingerModeInternal(), false);
                            AudioService.this.restoreMasterVolume();
                            if (AudioService.this.mMonitorOrientation) {
                                AudioService.this.setOrientationForAudioSystem();
                            }
                            if (AudioService.this.mMonitorRotation) {
                                AudioService.this.setRotationForAudioSystem();
                            }
                            synchronized (AudioService.this.mBluetoothA2dpEnabledLock) {
                                AudioSystem.setForceUse(1, AudioService.this.mBluetoothA2dpEnabled ? 0 : 10);
                            }
                            synchronized (AudioService.this.mSettingsLock) {
                                AudioSystem.setForceUse(3, AudioService.this.mDockAudioMediaEnabled ? 8 : 0);
                            }
                            if (AudioService.this.mHdmiManager != null) {
                                synchronized (AudioService.this.mHdmiManager) {
                                    if (AudioService.this.mHdmiTvClient != null) {
                                        AudioService.this.setHdmiSystemAudioSupported(AudioService.this.mHdmiSystemAudioSupported);
                                    }
                                }
                            }
                            synchronized (AudioService.this.mAudioPolicies) {
                                for (AudioPolicyProxy audioPolicyProxy : AudioService.this.mAudioPolicies.values()) {
                                    audioPolicyProxy.connectMixes();
                                }
                            }
                            AudioSystem.setParameters("restarting=false");
                            return;
                        }
                        VolumeStreamState volumeStreamState = AudioService.this.mStreamStates[i];
                        AudioSystem.initStreamVolume(i, 0, (volumeStreamState.mIndexMax + 5) / 10);
                        volumeStreamState.applyAllVolumes();
                        numStreamTypes = i;
                    }
                    break;
                case 5:
                    onPlaySoundEffect(message.arg1, message.arg2);
                    return;
                case 6:
                    synchronized (AudioService.this.mConnectedDevices) {
                        AudioService.this.makeA2dpDeviceUnavailableNow((String) message.obj);
                    }
                    return;
                case 7:
                    boolean onLoadSoundEffects = onLoadSoundEffects();
                    if (message.obj != null) {
                        LoadSoundEffectReply loadSoundEffectReply = (LoadSoundEffectReply) message.obj;
                        synchronized (loadSoundEffectReply) {
                            loadSoundEffectReply.mStatus = onLoadSoundEffects ? 0 : -1;
                            loadSoundEffectReply.notify();
                        }
                        return;
                    }
                    return;
                case 8:
                case 13:
                    setForceUse(message.arg1, message.arg2);
                    return;
                case 9:
                    AudioService.this.resetBluetoothSco();
                    return;
                case 10:
                    setAllVolumes((VolumeStreamState) message.obj);
                    return;
                case 11:
                    if (AudioService.this.mUseFixedVolume) {
                        return;
                    }
                    Settings.System.putIntForUser(AudioService.this.mContentResolver, Settings.System.VOLUME_MASTER_MUTE, message.arg1, message.arg2);
                    return;
                case 12:
                    int beginBroadcast = AudioService.this.mRoutesObservers.beginBroadcast();
                    if (beginBroadcast > 0) {
                        synchronized (AudioService.this.mCurAudioRoutes) {
                            audioRoutesInfo = new AudioRoutesInfo(AudioService.this.mCurAudioRoutes);
                        }
                        while (beginBroadcast > 0) {
                            beginBroadcast--;
                            try {
                                AudioService.this.mRoutesObservers.getBroadcastItem(beginBroadcast).dispatchAudioRoutesChanged(audioRoutesInfo);
                            } catch (RemoteException e) {
                            }
                        }
                    }
                    AudioService.this.mRoutesObservers.finishBroadcast();
                    return;
                case 14:
                    AudioService.this.onCheckMusicActive();
                    return;
                case 15:
                    AudioService.this.onSendBecomingNoisyIntent();
                    return;
                case 16:
                case 17:
                    AudioService.this.onConfigureSafeVolume(message.what == 17);
                    return;
                case 18:
                    onPersistSafeVolumeState(message.arg1);
                    return;
                case 19:
                    AudioService.this.onBroadcastScoConnectionState(message.arg1);
                    return;
                case 20:
                    onUnloadSoundEffects();
                    return;
                case 21:
                    AudioService.this.onSystemReady();
                    return;
                case 22:
                    Settings.Secure.putIntForUser(AudioService.this.mContentResolver, Settings.Secure.UNSAFE_VOLUME_MUSIC_ACTIVE_MS, message.arg1, -2);
                    return;
                case 23:
                    Settings.System.putIntForUser(AudioService.this.mContentResolver, Settings.System.MICROPHONE_MUTE, message.arg1, message.arg2);
                    return;
                case 100:
                    AudioService.this.onSetWiredDeviceConnectionState(message.arg1, message.arg2, (String) message.obj);
                    AudioService.this.mAudioEventWakeLock.release();
                    return;
                case 101:
                    AudioService.this.onSetA2dpSourceConnectionState((BluetoothDevice) message.obj, message.arg1);
                    AudioService.this.mAudioEventWakeLock.release();
                    return;
                case 102:
                    AudioService.this.onSetA2dpSinkConnectionState((BluetoothDevice) message.obj, message.arg1);
                    AudioService.this.mAudioEventWakeLock.release();
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$AudioOrientationEventListener.class */
    private class AudioOrientationEventListener extends OrientationEventListener {
        public AudioOrientationEventListener(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int rotation = ((WindowManager) AudioService.this.mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
            if (rotation != AudioService.this.mDeviceRotation) {
                AudioService.this.mDeviceRotation = rotation;
                AudioService.this.setRotationForAudioSystem();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$AudioPolicyProxy.class */
    public class AudioPolicyProxy extends AudioPolicyConfig implements IBinder.DeathRecipient {
        private static final String TAG = "AudioPolicyProxy";
        AudioPolicyConfig mConfig;
        int mFocusDuckBehavior;
        boolean mHasFocusListener;
        IAudioPolicyCallback mPolicyToken;

        AudioPolicyProxy(AudioPolicyConfig audioPolicyConfig, IAudioPolicyCallback iAudioPolicyCallback, boolean z) {
            super(audioPolicyConfig);
            this.mFocusDuckBehavior = 0;
            setRegistration(new String(audioPolicyConfig.hashCode() + ":ap:" + AudioService.access$11008(AudioService.this)));
            this.mPolicyToken = iAudioPolicyCallback;
            this.mHasFocusListener = z;
            if (this.mHasFocusListener) {
                AudioService.this.mMediaFocusControl.addFocusFollower(this.mPolicyToken);
            }
            connectMixes();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (AudioService.this.mAudioPolicies) {
                Log.i(TAG, "audio policy " + this.mPolicyToken + " died");
                release();
                AudioService.this.mAudioPolicies.remove(this.mPolicyToken.asBinder());
            }
        }

        void connectMixes() {
            AudioSystem.registerPolicyMixes(this.mMixes, true);
        }

        String getRegistrationId() {
            return getRegistration();
        }

        void release() {
            if (this.mFocusDuckBehavior == 1) {
                AudioService.this.mMediaFocusControl.setDuckingInExtPolicyAvailable(false);
            }
            if (this.mHasFocusListener) {
                AudioService.this.mMediaFocusControl.removeFocusFollower(this.mPolicyToken);
            }
            AudioSystem.registerPolicyMixes(this.mMixes, false);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$AudioServiceBroadcastReceiver.class */
    private class AudioServiceBroadcastReceiver extends BroadcastReceiver {
        private AudioServiceBroadcastReceiver() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            int i;
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_DOCK_EVENT)) {
                int intExtra = intent.getIntExtra(Intent.EXTRA_DOCK_STATE, 0);
                switch (intExtra) {
                    case 1:
                        if (!AudioService.this.mForceAnalogDeskDock) {
                            i = 7;
                            break;
                        } else {
                            i = 8;
                            break;
                        }
                    case 2:
                        if (!AudioService.this.mForceAnalogCarDock) {
                            i = 6;
                            break;
                        } else {
                            i = 8;
                            break;
                        }
                    case 3:
                        i = 8;
                        break;
                    case 4:
                        i = 9;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (intExtra != 3 && (intExtra != 0 || AudioService.this.mDockState != 3)) {
                    AudioSystem.setForceUse(3, i);
                }
                AudioService.this.mDockState = intExtra;
            } else if (action.equals(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED)) {
                int intExtra2 = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, 0);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (bluetoothDevice != null) {
                    String address = bluetoothDevice.getAddress();
                    BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
                    int i2 = 16;
                    if (bluetoothClass != null) {
                        switch (bluetoothClass.getDeviceClass()) {
                            case 1028:
                            case 1032:
                                i2 = 32;
                                break;
                            case 1056:
                                i2 = 64;
                                break;
                            default:
                                i2 = 16;
                                break;
                        }
                    }
                    String str = address;
                    if (!BluetoothAdapter.checkBluetoothAddress(address)) {
                        str = "";
                    }
                    boolean z2 = intExtra2 == 2;
                    if (AudioService.this.handleDeviceConnection(z2, i2, str) && AudioService.this.handleDeviceConnection(z2, -2147483640, str)) {
                        synchronized (AudioService.this.mScoClients) {
                            if (z2) {
                                AudioService.this.mBluetoothHeadsetDevice = bluetoothDevice;
                            } else {
                                AudioService.this.mBluetoothHeadsetDevice = null;
                                AudioService.this.resetBluetoothSco();
                            }
                        }
                    }
                }
            } else if (action.equals(AudioManager.ACTION_USB_AUDIO_ACCESSORY_PLUG)) {
                int intExtra3 = intent.getIntExtra("state", 0);
                int intExtra4 = intent.getIntExtra("card", -1);
                int intExtra5 = intent.getIntExtra("device", -1);
                AudioService.this.setWiredDeviceConnectionState(8192, intExtra3, (intExtra4 == -1 && intExtra5 == -1) ? "" : "card=" + intExtra4 + ";device=" + intExtra5);
            } else if (action.equals(AudioManager.ACTION_USB_AUDIO_DEVICE_PLUG)) {
                if (Settings.Secure.getInt(AudioService.this.mContentResolver, Settings.Secure.USB_AUDIO_AUTOMATIC_ROUTING_DISABLED, 0) == 0) {
                    int intExtra6 = intent.getIntExtra("state", 0);
                    int intExtra7 = intent.getIntExtra("card", -1);
                    int intExtra8 = intent.getIntExtra("device", -1);
                    boolean booleanExtra = intent.getBooleanExtra("hasPlayback", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("hasCapture", false);
                    intent.getBooleanExtra("hasMIDI", false);
                    String str2 = (intExtra7 == -1 && intExtra8 == -1) ? "" : "card=" + intExtra7 + ";device=" + intExtra8;
                    if (booleanExtra) {
                        AudioService.this.setWiredDeviceConnectionState(16384, intExtra6, str2);
                    }
                    if (booleanExtra2) {
                        AudioService.this.setWiredDeviceConnectionState(-2147479552, intExtra6, str2);
                    }
                }
            } else if (!action.equals(BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED)) {
                if (action.equals(Intent.ACTION_SCREEN_ON)) {
                    if (AudioService.this.mMonitorRotation) {
                        AudioService.this.mOrientationListener.onOrientationChanged(0);
                        AudioService.this.mOrientationListener.enable();
                    }
                    AudioSystem.setParameters("screen_state=on");
                } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {
                    if (AudioService.this.mMonitorRotation) {
                        AudioService.this.mOrientationListener.disable();
                    }
                    AudioSystem.setParameters("screen_state=off");
                } else if (action.equals(Intent.ACTION_CONFIGURATION_CHANGED)) {
                    AudioService.this.handleConfigurationChanged(context);
                } else if (action.equals(Intent.ACTION_USER_SWITCHED)) {
                    AudioService.sendMsg(AudioService.this.mAudioHandler, 15, 0, 0, 0, null, 0);
                    AudioService.this.mMediaFocusControl.discardAudioFocusOwner();
                    AudioService.this.readAudioSettings(true);
                    AudioService.sendMsg(AudioService.this.mAudioHandler, 10, 2, 0, 0, AudioService.this.mStreamStates[3], 0);
                }
            } else {
                int i3 = -1;
                synchronized (AudioService.this.mScoClients) {
                    int intExtra9 = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, -1);
                    boolean z3 = false;
                    if (!AudioService.this.mScoClients.isEmpty()) {
                        if (AudioService.this.mScoAudioState != 3 && AudioService.this.mScoAudioState != 1) {
                            z3 = false;
                            if (AudioService.this.mScoAudioState == 5) {
                            }
                        }
                        z3 = true;
                    }
                    switch (intExtra9) {
                        case 10:
                            i3 = 0;
                            AudioService.this.mScoAudioState = 0;
                            AudioService.this.clearAllScoClients(0, false);
                            z = z3;
                            break;
                        case 11:
                            if (AudioService.this.mScoAudioState != 3 && AudioService.this.mScoAudioState != 5 && AudioService.this.mScoAudioState != 4) {
                                AudioService.this.mScoAudioState = 2;
                            }
                            z = false;
                            break;
                        case 12:
                            z = z3;
                            i3 = 1;
                            if (AudioService.this.mScoAudioState != 3) {
                                z = z3;
                                i3 = 1;
                                if (AudioService.this.mScoAudioState != 5) {
                                    z = z3;
                                    i3 = 1;
                                    if (AudioService.this.mScoAudioState != 4) {
                                        AudioService.this.mScoAudioState = 2;
                                        z = z3;
                                        i3 = 1;
                                        break;
                                    }
                                }
                            }
                            break;
                        default:
                            z = false;
                            break;
                    }
                }
                if (z) {
                    AudioService.this.broadcastScoConnectionState(i3);
                    Intent intent2 = new Intent(AudioManager.ACTION_SCO_AUDIO_STATE_CHANGED);
                    intent2.putExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, i3);
                    AudioService.this.sendStickyBroadcastToAll(intent2);
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$AudioServiceInternal.class */
    final class AudioServiceInternal extends AudioManagerInternal {
        AudioServiceInternal() {
        }

        @Override // android.media.AudioManagerInternal
        public void adjustMasterVolumeForUid(int i, int i2, String str, int i3) {
            AudioService.this.adjustMasterVolume(i, i2, str, i3);
        }

        @Override // android.media.AudioManagerInternal
        public void adjustStreamVolumeForUid(int i, int i2, int i3, String str, int i4) {
            AudioService.this.adjustStreamVolume(i, i2, i3, str, i4);
        }

        @Override // android.media.AudioManagerInternal
        public void adjustSuggestedStreamVolumeForUid(int i, int i2, int i3, String str, int i4) {
            AudioService.this.adjustSuggestedStreamVolume(i2, i, i3, str, i4);
        }

        @Override // android.media.AudioManagerInternal
        public int getRingerModeInternal() {
            return AudioService.this.getRingerModeInternal();
        }

        @Override // android.media.AudioManagerInternal
        public void setMasterMuteForUid(boolean z, int i, String str, IBinder iBinder, int i2) {
            AudioService.this.setMasterMuteInternal(z, i, str, iBinder, i2);
        }

        @Override // android.media.AudioManagerInternal
        public void setRingerModeDelegate(AudioManagerInternal.RingerModeDelegate ringerModeDelegate) {
            AudioService.this.mRingerModeDelegate = ringerModeDelegate;
            if (AudioService.this.mRingerModeDelegate != null) {
                setRingerModeInternal(getRingerModeInternal(), "AudioService.setRingerModeDelegate");
            }
        }

        @Override // android.media.AudioManagerInternal
        public void setRingerModeInternal(int i, String str) {
            AudioService.this.setRingerModeInternal(i, str);
        }

        @Override // android.media.AudioManagerInternal
        public void setStreamVolumeForUid(int i, int i2, int i3, String str, int i4) {
            AudioService.this.setStreamVolume(i, i2, i3, str, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$AudioSystemThread.class */
    public class AudioSystemThread extends Thread {
        AudioSystemThread() {
            super(AudioService.TAG);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (AudioService.this) {
                AudioService.this.mAudioHandler = new AudioHandler();
                AudioService.this.notify();
            }
            Looper.loop();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$ForceControlStreamClient.class */
    private class ForceControlStreamClient implements IBinder.DeathRecipient {
        private IBinder mCb;

        ForceControlStreamClient(IBinder iBinder) {
            IBinder iBinder2 = iBinder;
            if (iBinder != null) {
                try {
                    iBinder.linkToDeath(this, 0);
                    iBinder2 = iBinder;
                } catch (RemoteException e) {
                    Log.w(AudioService.TAG, "ForceControlStreamClient() could not link to " + iBinder + " binder death");
                    iBinder2 = null;
                }
            }
            this.mCb = iBinder2;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (AudioService.this.mForceControlStreamLock) {
                Log.w(AudioService.TAG, "SCO client died");
                if (AudioService.this.mForceControlStreamClient != this) {
                    Log.w(AudioService.TAG, "unregistered control stream client died");
                } else {
                    AudioService.this.mForceControlStreamClient = null;
                    AudioService.this.mVolumeControlStream = -1;
                }
            }
        }

        public void release() {
            if (this.mCb != null) {
                this.mCb.unlinkToDeath(this, 0);
                this.mCb = null;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$LoadSoundEffectReply.class */
    class LoadSoundEffectReply {
        public int mStatus = 1;

        LoadSoundEffectReply() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$MediaPlayerInfo.class */
    private class MediaPlayerInfo {
        private boolean mIsfocussed;
        private String mPackageName;

        public MediaPlayerInfo(String str, boolean z) {
            this.mPackageName = str;
            this.mIsfocussed = z;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public boolean isFocussed() {
            return this.mIsfocussed;
        }

        public void setFocus(boolean z) {
            this.mIsfocussed = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$MyDisplayStatusCallback.class */
    public class MyDisplayStatusCallback implements HdmiPlaybackClient.DisplayStatusCallback {
        private MyDisplayStatusCallback() {
        }

        @Override // android.hardware.hdmi.HdmiPlaybackClient.DisplayStatusCallback
        public void onComplete(int i) {
            if (AudioService.this.mHdmiManager != null) {
                synchronized (AudioService.this.mHdmiManager) {
                    AudioService.this.mHdmiCecSink = i != -1;
                    if (AudioService.this.isPlatformTelevision() && !AudioService.this.mHdmiCecSink) {
                        AudioService.this.mFixedVolumeDevices &= -1025;
                    }
                    AudioService.this.checkAllFixedVolumeDevices();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$RmtSbmxFullVolDeathHandler.class */
    public class RmtSbmxFullVolDeathHandler implements IBinder.DeathRecipient {
        private IBinder mICallback;

        RmtSbmxFullVolDeathHandler(IBinder iBinder) {
            this.mICallback = iBinder;
            try {
                iBinder.linkToDeath(this, 0);
            } catch (RemoteException e) {
                Log.e(AudioService.TAG, "can't link to death", e);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.w(AudioService.TAG, "Recorder with remote submix at full volume died " + this.mICallback);
            AudioService.this.forceRemoteSubmixFullVolume(false, this.mICallback);
        }

        void forget() {
            try {
                this.mICallback.unlinkToDeath(this, 0);
            } catch (NoSuchElementException e) {
                Log.e(AudioService.TAG, "error unlinking to death", e);
            }
        }

        boolean isHandlerFor(IBinder iBinder) {
            return this.mICallback.equals(iBinder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$ScoClient.class */
    public class ScoClient implements IBinder.DeathRecipient {
        private IBinder mCb;
        private int mCreatorPid = Binder.getCallingPid();
        private int mStartcount = 0;

        ScoClient(IBinder iBinder) {
            this.mCb = iBinder;
        }

        private void requestScoState(int i, int i2) {
            AudioService.this.checkScoAudioState();
            if (totalCount() == 0) {
                if (i != 12) {
                    if (i == 10) {
                        if (AudioService.this.mScoAudioState == 3 || AudioService.this.mScoAudioState == 1) {
                            if (AudioService.this.mScoAudioState != 3) {
                                AudioService.this.mScoAudioState = 0;
                                AudioService.this.broadcastScoConnectionState(0);
                                return;
                            } else if (AudioService.this.mBluetoothHeadset == null || AudioService.this.mBluetoothHeadsetDevice == null) {
                                if (AudioService.this.getBluetoothHeadset()) {
                                    AudioService.this.mScoAudioState = 5;
                                    return;
                                }
                                return;
                            } else {
                                if (AudioService.this.mScoAudioMode == 2 ? AudioService.this.mBluetoothHeadset.stopVoiceRecognition(AudioService.this.mBluetoothHeadsetDevice) : AudioService.this.mBluetoothHeadset.stopScoUsingVirtualVoiceCall(AudioService.this.mBluetoothHeadsetDevice)) {
                                    return;
                                }
                                AudioService.this.mScoAudioState = 0;
                                AudioService.this.broadcastScoConnectionState(0);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                AudioService.this.broadcastScoConnectionState(2);
                synchronized (AudioService.this.mSetModeDeathHandlers) {
                    if ((!AudioService.this.mSetModeDeathHandlers.isEmpty() && ((SetModeDeathHandler) AudioService.this.mSetModeDeathHandlers.get(0)).getPid() != this.mCreatorPid) || (AudioService.this.mScoAudioState != 0 && AudioService.this.mScoAudioState != 5)) {
                        AudioService.this.broadcastScoConnectionState(0);
                    } else if (AudioService.this.mScoAudioState == 0) {
                        AudioService.this.mScoAudioMode = i2;
                        if (i2 == -1) {
                            if (AudioService.this.mBluetoothHeadsetDevice != null) {
                                AudioService.this.mScoAudioMode = new Integer(Settings.Global.getInt(AudioService.this.mContentResolver, "bluetooth_sco_channel_" + AudioService.this.mBluetoothHeadsetDevice.getAddress(), 0)).intValue();
                                if (AudioService.this.mScoAudioMode > 2 || AudioService.this.mScoAudioMode < 0) {
                                    AudioService.this.mScoAudioMode = 0;
                                }
                            } else {
                                AudioService.this.mScoAudioMode = 1;
                            }
                        }
                        if (AudioService.this.mBluetoothHeadset != null && AudioService.this.mBluetoothHeadsetDevice != null) {
                            if (AudioService.this.mScoAudioMode == 2 ? AudioService.this.mBluetoothHeadset.startVoiceRecognition(AudioService.this.mBluetoothHeadsetDevice) : AudioService.this.mBluetoothHeadset.startScoUsingVirtualVoiceCall(AudioService.this.mBluetoothHeadsetDevice)) {
                                AudioService.this.mScoAudioState = 3;
                            } else {
                                AudioService.this.broadcastScoConnectionState(0);
                            }
                        } else if (AudioService.this.getBluetoothHeadset()) {
                            AudioService.this.mScoAudioState = 1;
                        }
                    } else {
                        AudioService.this.mScoAudioState = 3;
                        AudioService.this.broadcastScoConnectionState(1);
                    }
                }
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (AudioService.this.mScoClients) {
                Log.w(AudioService.TAG, "SCO client died");
                if (AudioService.this.mScoClients.indexOf(this) < 0) {
                    Log.w(AudioService.TAG, "unregistered SCO client died");
                } else {
                    clearCount(true);
                    AudioService.this.mScoClients.remove(this);
                }
            }
        }

        public void clearCount(boolean z) {
            synchronized (AudioService.this.mScoClients) {
                if (this.mStartcount != 0) {
                    try {
                        this.mCb.unlinkToDeath(this, 0);
                    } catch (NoSuchElementException e) {
                        Log.w(AudioService.TAG, "clearCount() mStartcount: " + this.mStartcount + " != 0 but not registered to binder");
                    }
                }
                this.mStartcount = 0;
                if (z) {
                    requestScoState(10, 0);
                }
            }
        }

        public void decCount() {
            synchronized (AudioService.this.mScoClients) {
                if (this.mStartcount == 0) {
                    Log.w(AudioService.TAG, "ScoClient.decCount() already 0");
                } else {
                    this.mStartcount--;
                    if (this.mStartcount == 0) {
                        try {
                            this.mCb.unlinkToDeath(this, 0);
                        } catch (NoSuchElementException e) {
                            Log.w(AudioService.TAG, "decCount() going to 0 but not registered to binder");
                        }
                    }
                    requestScoState(10, 0);
                }
            }
        }

        public IBinder getBinder() {
            return this.mCb;
        }

        public int getCount() {
            return this.mStartcount;
        }

        public int getPid() {
            return this.mCreatorPid;
        }

        public void incCount(int i) {
            synchronized (AudioService.this.mScoClients) {
                requestScoState(12, i);
                if (this.mStartcount == 0) {
                    try {
                        this.mCb.linkToDeath(this, 0);
                    } catch (RemoteException e) {
                        Log.w(AudioService.TAG, "ScoClient  incCount() could not link to " + this.mCb + " binder death");
                    }
                }
                this.mStartcount++;
            }
        }

        public int totalCount() {
            int i;
            synchronized (AudioService.this.mScoClients) {
                i = 0;
                int size = AudioService.this.mScoClients.size();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < size) {
                        i += ((ScoClient) AudioService.this.mScoClients.get(i3)).getCount();
                        i2 = i3 + 1;
                    }
                }
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$SetModeDeathHandler.class */
    public class SetModeDeathHandler implements IBinder.DeathRecipient {
        private IBinder mCb;
        private int mMode = 0;
        private int mPid;

        SetModeDeathHandler(IBinder iBinder, int i) {
            this.mCb = iBinder;
            this.mPid = i;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            int i = 0;
            synchronized (AudioService.this.mSetModeDeathHandlers) {
                Log.w(AudioService.TAG, "setMode() client died");
                if (AudioService.this.mSetModeDeathHandlers.indexOf(this) < 0) {
                    Log.w(AudioService.TAG, "unregistered setMode() client died");
                } else {
                    i = AudioService.this.setModeInt(0, this.mCb, this.mPid);
                }
            }
            if (i != 0) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                AudioService.this.disconnectBluetoothSco(i);
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public IBinder getBinder() {
            return this.mCb;
        }

        public int getMode() {
            return this.mMode;
        }

        public int getPid() {
            return this.mPid;
        }

        public void setMode(int i) {
            this.mMode = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$SettingsObserver.class */
    private class SettingsObserver extends ContentObserver {
        SettingsObserver() {
            super(new Handler());
            AudioService.this.mContentResolver.registerContentObserver(Settings.System.getUriFor(Settings.System.MODE_RINGER_STREAMS_AFFECTED), false, this);
            AudioService.this.mContentResolver.registerContentObserver(Settings.Secure.getUriFor(Settings.Secure.VOLUME_LINK_NOTIFICATION), false, this);
            AudioService.this.mContentResolver.registerContentObserver(Settings.Global.getUriFor(Settings.Global.DOCK_AUDIO_MEDIA_ENABLED), false, this);
            AudioService.this.mContentResolver.registerContentObserver(Settings.System.getUriFor(Settings.System.VOLUME_KEYS_CONTROL_RING_STREAM), false, this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            synchronized (AudioService.this.mSettingsLock) {
                if (AudioService.this.updateRingerModeAffectedStreams()) {
                    AudioService.this.setRingerModeInt(AudioService.this.getRingerModeInternal(), false);
                }
                AudioService.this.readDockAudioSettings(AudioService.this.mContentResolver);
                boolean z2 = Settings.Secure.getInt(AudioService.this.mContentResolver, Settings.Secure.VOLUME_LINK_NOTIFICATION, 1) == 1;
                if (z2 != AudioService.this.mLinkNotificationWithVolume) {
                    AudioService.this.mLinkNotificationWithVolume = z2;
                    AudioService.this.createStreamStates();
                    AudioService.this.updateStreamVolumeAlias(true);
                }
                AudioService.this.mVolumeKeysControlRingStream = Settings.System.getIntForUser(AudioService.this.mContentResolver, Settings.System.VOLUME_KEYS_CONTROL_RING_STREAM, 1, -2) == 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$SoundPoolCallback.class */
    public final class SoundPoolCallback implements SoundPool.OnLoadCompleteListener {
        List<Integer> mSamples;
        int mStatus;

        private SoundPoolCallback() {
            this.mStatus = 1;
            this.mSamples = new ArrayList();
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i, int i2) {
            synchronized (AudioService.this.mSoundEffectsLock) {
                int indexOf = this.mSamples.indexOf(Integer.valueOf(i));
                if (indexOf >= 0) {
                    this.mSamples.remove(indexOf);
                }
                if (i2 != 0 || this.mSamples.isEmpty()) {
                    this.mStatus = i2;
                    AudioService.this.mSoundEffectsLock.notify();
                }
            }
        }

        public void setSamples(int[] iArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iArr.length) {
                    return;
                }
                if (iArr[i2] > 0) {
                    this.mSamples.add(Integer.valueOf(iArr[i2]));
                }
                i = i2 + 1;
            }
        }

        public int status() {
            return this.mStatus;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$SoundPoolListenerThread.class */
    public class SoundPoolListenerThread extends Thread {
        public SoundPoolListenerThread() {
            super("SoundPoolListenerThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            AudioService.this.mSoundPoolLooper = Looper.myLooper();
            synchronized (AudioService.this.mSoundEffectsLock) {
                if (AudioService.this.mSoundPool != null) {
                    AudioService.this.mSoundPoolCallBack = new SoundPoolCallback();
                    AudioService.this.mSoundPool.setOnLoadCompleteListener(AudioService.this.mSoundPoolCallBack);
                }
                AudioService.this.mSoundEffectsLock.notify();
            }
            Looper.loop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$StreamOverride.class */
    public static class StreamOverride implements AccessibilityManager.TouchExplorationStateChangeListener {
        private static final int DEFAULT_STREAM_TYPE_OVERRIDE_DELAY_MS = 5000;
        private static final int TOUCH_EXPLORE_STREAM_TYPE_OVERRIDE_DELAY_MS = 1000;
        static int sDelayMs;

        private StreamOverride() {
        }

        static void init(Context context) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
            updateDefaultStreamOverrideDelay(accessibilityManager.isTouchExplorationEnabled());
            accessibilityManager.addTouchExplorationStateChangeListener(new StreamOverride());
        }

        private static void updateDefaultStreamOverrideDelay(boolean z) {
            if (z) {
                sDelayMs = 1000;
            } else {
                sDelayMs = 5000;
            }
            if (AudioService.DEBUG_VOL) {
                Log.d(AudioService.TAG, "Touch exploration enabled=" + z + " stream override delay is now " + sDelayMs + " ms");
            }
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            updateDefaultStreamOverrideDelay(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$StreamVolumeCommand.class */
    public class StreamVolumeCommand {
        public final int mDevice;
        public final int mFlags;
        public final int mIndex;
        public final int mStreamType;

        StreamVolumeCommand(int i, int i2, int i3, int i4) {
            this.mStreamType = i;
            this.mIndex = i2;
            this.mFlags = i3;
            this.mDevice = i4;
        }

        public String toString() {
            return "{streamType=" + this.mStreamType + ",index=" + this.mIndex + ",flags=" + this.mFlags + ",device=" + this.mDevice + '}';
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$VolumeController.class */
    public static class VolumeController {
        private static final String TAG = "VolumeController";
        private IVolumeController mController;
        private int mLongPressTimeout;
        private long mNextLongPress;
        private boolean mVisible;

        private static IBinder binder(IVolumeController iVolumeController) {
            if (iVolumeController == null) {
                return null;
            }
            return iVolumeController.asBinder();
        }

        public IBinder asBinder() {
            return binder(this.mController);
        }

        public boolean isSameBinder(IVolumeController iVolumeController) {
            return Objects.equals(asBinder(), binder(iVolumeController));
        }

        public void loadSettings(ContentResolver contentResolver) {
            this.mLongPressTimeout = Settings.Secure.getIntForUser(contentResolver, Settings.Secure.LONG_PRESS_TIMEOUT, 500, -2);
        }

        public void postDismiss() {
            if (this.mController == null) {
                return;
            }
            try {
                this.mController.dismiss();
            } catch (RemoteException e) {
                Log.w(TAG, "Error calling dismiss", e);
            }
        }

        public void postDisplaySafeVolumeWarning(int i) {
            if (this.mController == null) {
                return;
            }
            try {
                this.mController.displaySafeVolumeWarning(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Error calling displaySafeVolumeWarning", e);
            }
        }

        public void postMasterMuteChanged(int i) {
            if (this.mController == null) {
                return;
            }
            try {
                this.mController.masterMuteChanged(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Error calling masterMuteChanged", e);
            }
        }

        public void postMasterVolumeChanged(int i) {
            if (this.mController == null) {
                return;
            }
            try {
                this.mController.masterVolumeChanged(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Error calling masterVolumeChanged", e);
            }
        }

        public void postVolumeChanged(int i, int i2) {
            if (this.mController == null) {
                return;
            }
            try {
                this.mController.volumeChanged(i, i2);
            } catch (RemoteException e) {
                Log.w(TAG, "Error calling volumeChanged", e);
            }
        }

        public void setController(IVolumeController iVolumeController) {
            this.mController = iVolumeController;
            this.mVisible = false;
        }

        public void setLayoutDirection(int i) {
            if (this.mController == null) {
                return;
            }
            try {
                this.mController.setLayoutDirection(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Error calling setLayoutDirection", e);
            }
        }

        public void setVisible(boolean z) {
            this.mVisible = z;
        }

        public boolean suppressAdjustment(int i, int i2) {
            boolean z = false;
            if (i == 2) {
                z = false;
                if (this.mController != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if ((i2 & 1) == 0 || this.mVisible) {
                        z = false;
                        if (this.mNextLongPress > 0) {
                            if (uptimeMillis > this.mNextLongPress) {
                                this.mNextLongPress = 0L;
                                return false;
                            }
                            return true;
                        }
                    } else {
                        if (this.mNextLongPress < uptimeMillis) {
                            this.mNextLongPress = this.mLongPressTimeout + uptimeMillis;
                        }
                        z = true;
                    }
                }
            }
            return z;
        }

        public String toString() {
            return "VolumeController(" + asBinder() + ",mVisible=" + this.mVisible + ")";
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$VolumeStreamState.class */
    public class VolumeStreamState {
        private ArrayList<VolumeDeathHandler> mDeathHandlers;
        private final ConcurrentHashMap<Integer, Integer> mIndex;
        private int mIndexMax;
        private final int mStreamType;
        private String mVolumeIndexSettingName;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/AudioService$VolumeStreamState$VolumeDeathHandler.class */
        public class VolumeDeathHandler implements IBinder.DeathRecipient {
            private IBinder mICallback;
            private int mMuteCount;

            VolumeDeathHandler(IBinder iBinder) {
                this.mICallback = iBinder;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.w(AudioService.TAG, "Volume service client died for stream: " + VolumeStreamState.this.mStreamType);
                synchronized (VolumeStreamState.class) {
                    try {
                        if (this.mMuteCount != 0) {
                            this.mMuteCount = 1;
                            mute_syncVSS(false);
                        }
                    } finally {
                    }
                }
            }

            public void mute_syncVSS(boolean z) {
                boolean z2 = false;
                if (z) {
                    if (this.mMuteCount == 0) {
                        try {
                            if (this.mICallback != null) {
                                this.mICallback.linkToDeath(this, 0);
                            }
                            VolumeStreamState.this.mDeathHandlers.add(this);
                            if (!VolumeStreamState.this.isMuted_syncVSS()) {
                                z2 = true;
                            }
                        } catch (RemoteException e) {
                            binderDied();
                            return;
                        }
                    } else {
                        Log.w(AudioService.TAG, "stream: " + VolumeStreamState.this.mStreamType + " was already muted by this client");
                    }
                    this.mMuteCount++;
                } else if (this.mMuteCount == 0) {
                    Log.e(AudioService.TAG, "unexpected unmute for stream: " + VolumeStreamState.this.mStreamType);
                    z2 = false;
                } else {
                    this.mMuteCount--;
                    z2 = false;
                    if (this.mMuteCount == 0) {
                        VolumeStreamState.this.mDeathHandlers.remove(this);
                        if (this.mICallback != null) {
                            this.mICallback.unlinkToDeath(this, 0);
                        }
                        z2 = false;
                        if (!VolumeStreamState.this.isMuted_syncVSS()) {
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    AudioService.sendMsg(AudioService.this.mAudioHandler, 10, 2, 0, 0, VolumeStreamState.this, 0);
                }
            }
        }

        private VolumeStreamState(String str, int i) {
            this.mIndex = new ConcurrentHashMap<>(8, 0.75f, 4);
            this.mVolumeIndexSettingName = str;
            this.mStreamType = i;
            this.mIndexMax = AudioService.MAX_STREAM_VOLUME[i];
            AudioSystem.initStreamVolume(i, 0, this.mIndexMax);
            this.mIndexMax *= 10;
            this.mDeathHandlers = new ArrayList<>();
            readSettings();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dump(PrintWriter printWriter) {
            printWriter.print("   Mute count: ");
            printWriter.println(muteCount());
            printWriter.print("   Max: ");
            printWriter.println((this.mIndexMax + 5) / 10);
            printWriter.print("   Current: ");
            Iterator<Map.Entry<Integer, Integer>> it = this.mIndex.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                int intValue = next.getKey().intValue();
                printWriter.print(Integer.toHexString(intValue));
                String outputDeviceName = intValue == 1073741824 ? "default" : AudioSystem.getOutputDeviceName(intValue);
                if (!outputDeviceName.isEmpty()) {
                    printWriter.print(" (");
                    printWriter.print(outputDeviceName);
                    printWriter.print(")");
                }
                printWriter.print(": ");
                printWriter.print((next.getValue().intValue() + 5) / 10);
                if (it.hasNext()) {
                    printWriter.print(", ");
                }
            }
        }

        private VolumeDeathHandler getDeathHandler_syncVSS(IBinder iBinder, boolean z) {
            VolumeDeathHandler volumeDeathHandler;
            int size = this.mDeathHandlers.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    if (z) {
                        volumeDeathHandler = new VolumeDeathHandler(iBinder);
                    } else {
                        Log.w(AudioService.TAG, "stream was not muted by this client");
                        volumeDeathHandler = null;
                    }
                    return volumeDeathHandler;
                }
                VolumeDeathHandler volumeDeathHandler2 = this.mDeathHandlers.get(i2);
                if (iBinder == volumeDeathHandler2.mICallback) {
                    return volumeDeathHandler2;
                }
                i = i2 + 1;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
            if (r4 > r3.mIndexMax) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int getValidIndex(int r4) {
            /*
                r3 = this;
                r0 = r4
                if (r0 >= 0) goto L8
                r0 = 0
                r5 = r0
            L6:
                r0 = r5
                return r0
            L8:
                r0 = r3
                android.media.AudioService r0 = android.media.AudioService.this
                boolean r0 = android.media.AudioService.access$4100(r0)
                if (r0 != 0) goto L26
                r0 = r3
                android.media.AudioService r0 = android.media.AudioService.this
                boolean r0 = android.media.AudioService.access$4200(r0)
                if (r0 != 0) goto L26
                r0 = r4
                r5 = r0
                r0 = r4
                r1 = r3
                int r1 = r1.mIndexMax
                if (r0 <= r1) goto L6
            L26:
                r0 = r3
                int r0 = r0.mIndexMax
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.media.AudioService.VolumeStreamState.getValidIndex(int):int");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isMuted_syncVSS() {
            return muteCount() != 0;
        }

        private int muteCount() {
            int i = 0;
            int size = this.mDeathHandlers.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return i;
                }
                i += this.mDeathHandlers.get(i3).mMuteCount;
                i2 = i3 + 1;
            }
        }

        public boolean adjustIndex(int i, int i2) {
            return setIndex(getIndex(i2) + i, i2);
        }

        public void applyAllVolumes() {
            synchronized (VolumeStreamState.class) {
                try {
                    AudioSystem.setStreamVolumeIndex(this.mStreamType, isMuted_syncVSS() ? 0 : (getIndex(1073741824) + 5) / 10, 1073741824);
                    for (Map.Entry<Integer, Integer> entry : this.mIndex.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        if (intValue != 1073741824) {
                            AudioSystem.setStreamVolumeIndex(this.mStreamType, isMuted_syncVSS() ? 0 : (((intValue & AudioSystem.DEVICE_OUT_ALL_A2DP) == 0 || !AudioService.this.mAvrcpAbsVolSupported) && (AudioService.this.mFullVolumeDevices & intValue) == 0) ? (entry.getValue().intValue() + 5) / 10 : (this.mIndexMax + 5) / 10, intValue);
                        }
                    }
                } finally {
                }
            }
        }

        public void applyDeviceVolume_syncVSS(int i) {
            AudioSystem.setStreamVolumeIndex(this.mStreamType, isMuted_syncVSS() ? 0 : (((i & AudioSystem.DEVICE_OUT_ALL_A2DP) == 0 || !AudioService.this.mAvrcpAbsVolSupported) && (AudioService.this.mFullVolumeDevices & i) == 0) ? (getIndex(i) + 5) / 10 : (this.mIndexMax + 5) / 10, i);
        }

        public void checkFixedVolumeDevices() {
            synchronized (VolumeStreamState.class) {
                try {
                    if (AudioService.this.mStreamVolumeAlias[this.mStreamType] == 3) {
                        for (Map.Entry<Integer, Integer> entry : this.mIndex.entrySet()) {
                            int intValue = entry.getKey().intValue();
                            int intValue2 = entry.getValue().intValue();
                            if ((AudioService.this.mFullVolumeDevices & intValue) != 0 || ((AudioService.this.mFixedVolumeDevices & intValue) != 0 && intValue2 != 0)) {
                                entry.setValue(Integer.valueOf(this.mIndexMax));
                            }
                            applyDeviceVolume_syncVSS(intValue);
                        }
                    }
                } finally {
                }
            }
        }

        public int getIndex(int i) {
            int intValue;
            synchronized (VolumeStreamState.class) {
                try {
                    Integer num = this.mIndex.get(Integer.valueOf(i));
                    Integer num2 = num;
                    if (num == null) {
                        num2 = this.mIndex.get(1073741824);
                    }
                    intValue = num2.intValue();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return intValue;
        }

        public int getMaxIndex() {
            return this.mIndexMax;
        }

        public String getSettingNameForDevice(int i) {
            String str = this.mVolumeIndexSettingName;
            String outputDeviceName = AudioSystem.getOutputDeviceName(i);
            return outputDeviceName.isEmpty() ? str : str + BridgeUtil.UNDERLINE_STR + outputDeviceName;
        }

        public int getStreamType() {
            return this.mStreamType;
        }

        public void mute(IBinder iBinder, boolean z) {
            synchronized (VolumeStreamState.class) {
                try {
                    VolumeDeathHandler deathHandler_syncVSS = getDeathHandler_syncVSS(iBinder, z);
                    if (deathHandler_syncVSS == null) {
                        Log.e(AudioService.TAG, "Could not get client death handler for stream: " + this.mStreamType);
                    } else {
                        deathHandler_syncVSS.mute_syncVSS(z);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void readSettings() {
            synchronized (VolumeStreamState.class) {
                try {
                    if (AudioService.this.mUseFixedVolume || AudioService.this.mUseMasterVolume) {
                        this.mIndex.put(1073741824, Integer.valueOf(this.mIndexMax));
                    } else if (this.mStreamType == 1 || this.mStreamType == 7) {
                        int i = AudioService.DEFAULT_STREAM_VOLUME[this.mStreamType] * 10;
                        synchronized (AudioService.this.mCameraSoundForced) {
                            if (AudioService.this.mCameraSoundForced.booleanValue()) {
                                i = this.mIndexMax;
                            }
                        }
                        this.mIndex.put(1073741824, Integer.valueOf(i));
                    } else {
                        int i2 = 1132462079;
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i2 == 0) {
                                return;
                            }
                            int i5 = 1 << i4;
                            if ((i5 & i2) != 0) {
                                int i6 = i2 & (i5 ^ (-1));
                                int intForUser = Settings.System.getIntForUser(AudioService.this.mContentResolver, getSettingNameForDevice(i5), i5 == 1073741824 ? AudioService.DEFAULT_STREAM_VOLUME[this.mStreamType] : -1, -2);
                                i2 = i6;
                                if (intForUser != -1) {
                                    this.mIndex.put(Integer.valueOf(i5), Integer.valueOf(getValidIndex(intForUser * 10)));
                                    i2 = i6;
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                } finally {
                }
            }
        }

        public void setAllIndexes(VolumeStreamState volumeStreamState) {
            synchronized (VolumeStreamState.class) {
                try {
                    int streamType = volumeStreamState.getStreamType();
                    int rescaleIndex = AudioService.this.rescaleIndex(volumeStreamState.getIndex(1073741824), streamType, this.mStreamType);
                    for (Map.Entry<Integer, Integer> entry : this.mIndex.entrySet()) {
                        entry.setValue(Integer.valueOf(rescaleIndex));
                    }
                    for (Map.Entry<Integer, Integer> entry2 : volumeStreamState.mIndex.entrySet()) {
                        setIndex(AudioService.this.rescaleIndex(entry2.getValue().intValue(), streamType, this.mStreamType), entry2.getKey().intValue());
                    }
                } finally {
                }
            }
        }

        public void setAllIndexesToMax() {
            synchronized (VolumeStreamState.class) {
                try {
                    for (Map.Entry<Integer, Integer> entry : this.mIndex.entrySet()) {
                        entry.setValue(Integer.valueOf(this.mIndexMax));
                    }
                } finally {
                }
            }
        }

        public boolean setIndex(int i, int i2) {
            int i3;
            synchronized (VolumeStreamState.class) {
                try {
                    int index = getIndex(i2);
                    int validIndex = getValidIndex(i);
                    synchronized (AudioService.this.mCameraSoundForced) {
                        i3 = validIndex;
                        if (this.mStreamType == 7) {
                            i3 = validIndex;
                            if (AudioService.this.mCameraSoundForced.booleanValue()) {
                                i3 = this.mIndexMax;
                            }
                        }
                    }
                    synchronized (this) {
                        this.mIndex.put(Integer.valueOf(i2), Integer.valueOf(i3));
                    }
                    if (index == i3) {
                        return false;
                    }
                    boolean z = i2 == AudioService.this.getDeviceForStream(this.mStreamType);
                    int numStreamTypes = AudioSystem.getNumStreamTypes();
                    while (true) {
                        int i4 = numStreamTypes - 1;
                        if (i4 < 0) {
                            return true;
                        }
                        if (i4 != this.mStreamType && AudioService.this.mStreamVolumeAlias[i4] == this.mStreamType) {
                            int rescaleIndex = AudioService.this.rescaleIndex(i3, this.mStreamType, i4);
                            AudioService.this.mStreamStates[i4].setIndex(rescaleIndex, i2);
                            if (z) {
                                AudioService.this.mStreamStates[i4].setIndex(rescaleIndex, AudioService.this.getDeviceForStream(i4));
                            }
                        }
                        numStreamTypes = i4;
                    }
                } finally {
                }
            }
        }
    }

    public AudioService(Context context) {
        this.mDeviceRotation = 0;
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
        this.mAppOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        this.mVoiceCapable = context.getResources().getBoolean(R.bool.config_voice_capable);
        if (this.mVoiceCapable) {
            this.mPlatformType = 1;
        } else if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_LEANBACK)) {
            this.mPlatformType = 2;
        } else {
            this.mPlatformType = 0;
        }
        this.mAudioEventWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "handleAudioEvent");
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        this.mHasVibrator = vibrator == null ? false : vibrator.hasVibrator();
        int i = SystemProperties.getInt("ro.config.vc_call_vol_steps", MAX_STREAM_VOLUME[0]);
        if (i != MAX_STREAM_VOLUME[0]) {
            MAX_STREAM_VOLUME[0] = i;
            DEFAULT_STREAM_VOLUME[0] = (i * 3) / 4;
        }
        int i2 = SystemProperties.getInt("ro.config.media_vol_steps", MAX_STREAM_VOLUME[3]);
        if (i2 != MAX_STREAM_VOLUME[3]) {
            MAX_STREAM_VOLUME[3] = i2;
            DEFAULT_STREAM_VOLUME[3] = (i2 * 3) / 4;
        }
        sSoundEffectVolumeDb = context.getResources().getInteger(R.integer.config_soundEffectVolumeDb);
        this.mForcedUseForComm = 0;
        createAudioSystemThread();
        this.mMediaFocusControl = new MediaFocusControl(this.mAudioHandler.getLooper(), this.mContext, this.mVolumeController, this);
        AudioSystem.setErrorCallback(this.mAudioSystemCallback);
        boolean z = this.mContext.getResources().getBoolean(R.bool.config_camera_sound_forced);
        this.mCameraSoundForced = new Boolean(z);
        sendMsg(this.mAudioHandler, 8, 2, 4, z ? 11 : 0, null, 0);
        this.mSafeMediaVolumeState = new Integer(Settings.Global.getInt(this.mContentResolver, Settings.Global.AUDIO_SAFE_VOLUME_STATE, 0));
        this.mSafeMediaVolumeIndex = this.mContext.getResources().getInteger(R.integer.config_safe_media_volume_index) * 10;
        this.mUseFixedVolume = this.mContext.getResources().getBoolean(R.bool.config_useFixedVolume);
        this.mUseMasterVolume = context.getResources().getBoolean(R.bool.config_useMasterVolume);
        this.mMasterVolumeRamp = context.getResources().getIntArray(R.array.config_masterVolumeRamp);
        this.mForceAnalogDeskDock = this.mContext.getResources().getBoolean(R.bool.config_forceAnalogDeskDock);
        this.mForceAnalogCarDock = this.mContext.getResources().getBoolean(R.bool.config_forceAnalogCarDock);
        this.mLinkNotificationWithVolume = Settings.Secure.getInt(this.mContext.getContentResolver(), Settings.Secure.VOLUME_LINK_NOTIFICATION, 1) == 1;
        updateStreamVolumeAlias(false);
        readPersistedSettings();
        this.mSettingsObserver = new SettingsObserver();
        createStreamStates();
        readAndSetLowRamDevice();
        this.mRingerModeMutedStreams = 0;
        setRingerModeInt(getRingerModeInternal(), false);
        IntentFilter intentFilter = new IntentFilter(BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED);
        intentFilter.addAction(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED);
        intentFilter.addAction(Intent.ACTION_DOCK_EVENT);
        intentFilter.addAction(AudioManager.ACTION_USB_AUDIO_ACCESSORY_PLUG);
        intentFilter.addAction(AudioManager.ACTION_USB_AUDIO_DEVICE_PLUG);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_USER_SWITCHED);
        intentFilter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        intentFilter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        this.mMonitorOrientation = SystemProperties.getBoolean("ro.audio.monitorOrientation", false);
        if (this.mMonitorOrientation) {
            Log.v(TAG, "monitoring device orientation");
            setOrientationForAudioSystem();
        }
        this.mMonitorRotation = SystemProperties.getBoolean("ro.audio.monitorRotation", false);
        if (this.mMonitorRotation) {
            this.mDeviceRotation = ((WindowManager) this.mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
            Log.v(TAG, "monitoring device rotation, initial=" + this.mDeviceRotation);
            this.mOrientationListener = new AudioOrientationEventListener(this.mContext);
            this.mOrientationListener.enable();
            setRotationForAudioSystem();
        }
        context.registerReceiver(this.mReceiver, intentFilter);
        restoreMasterVolume();
        LocalServices.addService(AudioManagerInternal.class, new AudioServiceInternal());
    }

    static /* synthetic */ int access$11008(AudioService audioService) {
        int i = audioService.mAudioPolicyCounter;
        audioService.mAudioPolicyCounter = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fe, code lost:
        if (r0 == getMasterStreamType()) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void adjustStreamVolume(int r9, int r10, int r11, java.lang.String r12, int r13) {
        /*
            Method dump skipped, instructions count: 708
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.AudioService.adjustStreamVolume(int, int, int, java.lang.String, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustSuggestedStreamVolume(int i, int i2, int i3, String str, int i4) {
        if (DEBUG_VOL) {
            Log.d(TAG, "adjustSuggestedStreamVolume() stream=" + i2 + ", flags=" + i3);
        }
        int activeStreamType = this.mVolumeControlStream != -1 ? this.mVolumeControlStream : getActiveStreamType(i2);
        int i5 = this.mStreamVolumeAlias[activeStreamType];
        int i6 = i3;
        if ((i3 & 4) != 0) {
            i6 = i3;
            if (i5 != 2) {
                i6 = i3 & (-5);
            }
        }
        int i7 = i6;
        if (this.mVolumeController.suppressAdjustment(i5, i6)) {
            int i8 = i6 & (-5) & (-17);
            i = 0;
            i7 = i8;
            if (DEBUG_VOL) {
                Log.d(TAG, "Volume controller suppressed adjustment");
                i7 = i8;
                i = 0;
            }
        }
        adjustStreamVolume(activeStreamType, i, i7, str, i4);
    }

    private void broadcastMasterMuteStatus(boolean z) {
        Intent intent = new Intent(AudioManager.MASTER_MUTE_CHANGED_ACTION);
        intent.putExtra(AudioManager.EXTRA_MASTER_VOLUME_MUTED, z);
        intent.addFlags(603979776);
        sendStickyBroadcastToAll(intent);
    }

    private void broadcastRingerMode(String str, int i) {
        Intent intent = new Intent(str);
        intent.putExtra(AudioManager.EXTRA_RINGER_MODE, i);
        intent.addFlags(603979776);
        sendStickyBroadcastToAll(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastScoConnectionState(int i) {
        sendMsg(this.mAudioHandler, 19, 2, i, 0, null, 0);
    }

    private void broadcastVibrateSetting(int i) {
        if (ActivityManagerNative.isSystemReady()) {
            Intent intent = new Intent(AudioManager.VIBRATE_SETTING_CHANGED_ACTION);
            intent.putExtra(AudioManager.EXTRA_VIBRATE_TYPE, i);
            intent.putExtra(AudioManager.EXTRA_VIBRATE_SETTING, getVibrateSetting(i));
            sendBroadcastToAll(intent);
        }
    }

    private void cancelA2dpDeviceTimeout() {
        this.mAudioHandler.removeMessages(6);
    }

    private void checkAllAliasStreamVolumes() {
        synchronized (VolumeStreamState.class) {
            try {
                int numStreamTypes = AudioSystem.getNumStreamTypes();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < numStreamTypes) {
                        if (i2 != this.mStreamVolumeAlias[i2]) {
                            this.mStreamStates[i2].setAllIndexes(this.mStreamStates[this.mStreamVolumeAlias[i2]]);
                        }
                        if (!this.mStreamStates[i2].isMuted_syncVSS()) {
                            this.mStreamStates[i2].applyAllVolumes();
                        }
                        i = i2 + 1;
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAllFixedVolumeDevices() {
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= numStreamTypes) {
                return;
            }
            this.mStreamStates[i2].checkFixedVolumeDevices();
            i = i2 + 1;
        }
    }

    private void checkAllFixedVolumeDevices(int i) {
        this.mStreamStates[i].checkFixedVolumeDevices();
    }

    private int checkForRingerModeChange(int i, int i2, int i3) {
        int i4;
        int i5;
        int ringerModeInternal = getRingerModeInternal();
        switch (ringerModeInternal) {
            case 0:
                i4 = ringerModeInternal;
                if (i2 == 1) {
                    i4 = this.mHasVibrator ? 1 : 2;
                }
                i5 = 1 & (-2);
                break;
            case 1:
                if (!this.mHasVibrator) {
                    Log.e(TAG, "checkForRingerModeChange() current ringer mode is vibratebut no vibrator is present");
                    i5 = 1;
                    i4 = ringerModeInternal;
                    break;
                } else {
                    if (i2 == -1) {
                        i4 = ringerModeInternal;
                        if (this.mPrevVolDirection != -1) {
                            i4 = 0;
                        }
                    } else {
                        i4 = ringerModeInternal;
                        if (i2 == 1) {
                            i4 = 2;
                        }
                    }
                    i5 = 1 & (-2);
                    break;
                }
            case 2:
                i5 = 1;
                i4 = ringerModeInternal;
                if (i2 == -1) {
                    if (!this.mHasVibrator) {
                        i5 = 1;
                        i4 = ringerModeInternal;
                        if (i < i3) {
                            i5 = 1;
                            i4 = ringerModeInternal;
                            if (this.mPrevVolDirection != -1) {
                                i4 = 0;
                                i5 = 1;
                                break;
                            }
                        }
                    } else {
                        i5 = 1;
                        i4 = ringerModeInternal;
                        if (i3 <= i) {
                            i5 = 1;
                            i4 = ringerModeInternal;
                            if (i < i3 * 2) {
                                i4 = 1;
                                i5 = 1;
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                Log.e(TAG, "checkForRingerModeChange() wrong ringer mode: " + ringerModeInternal);
                i4 = ringerModeInternal;
                i5 = 1;
                break;
        }
        setRingerMode(i4, "AudioService.checkForRingerModeChange", false);
        this.mPrevVolDirection = i2;
        return i5;
    }

    private boolean checkSafeMediaVolume(int i, int i2, int i3) {
        synchronized (this.mSafeMediaVolumeState) {
            return this.mSafeMediaVolumeState.intValue() != 3 || this.mStreamVolumeAlias[i] != 3 || (i3 & 12) == 0 || i2 <= this.mSafeMediaVolumeIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScoAudioState() {
        if (this.mBluetoothHeadset == null || this.mBluetoothHeadsetDevice == null || this.mScoAudioState != 0 || this.mBluetoothHeadset.getAudioState(this.mBluetoothHeadsetDevice) == 10) {
            return;
        }
        this.mScoAudioState = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int checkSendBecomingNoisyIntent(int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            i3 = 0;
            if ((this.mBecomingNoisyIntentDevices & i) != 0) {
                int i4 = 0;
                for (Integer num : this.mConnectedDevices.keySet()) {
                    int intValue = num.intValue();
                    if ((Integer.MIN_VALUE & intValue) == 0 && (this.mBecomingNoisyIntentDevices & intValue) != 0) {
                        i4 |= intValue;
                    }
                }
                i3 = 0;
                if (i4 == i) {
                    sendMsg(this.mAudioHandler, 15, 0, 0, 0, null, 0);
                    i3 = 1000;
                }
            }
        }
        if (this.mAudioHandler.hasMessages(101) || this.mAudioHandler.hasMessages(102) || this.mAudioHandler.hasMessages(100)) {
            synchronized (mLastDeviceConnectMsgTime) {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (mLastDeviceConnectMsgTime.longValue() > uptimeMillis) {
                    i3 = ((int) (mLastDeviceConnectMsgTime.longValue() - uptimeMillis)) + 30;
                }
            }
            return i3;
        }
        return i3;
    }

    private void configureHdmiPlugIntent(Intent intent, int i) {
        intent.setAction(AudioManager.ACTION_HDMI_AUDIO_PLUG);
        intent.putExtra(AudioManager.EXTRA_AUDIO_PLUG_STATE, i);
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            if (AudioSystem.listAudioPorts(arrayList, new int[1]) == 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    AudioPort audioPort = (AudioPort) it.next();
                    if (audioPort instanceof AudioDevicePort) {
                        AudioDevicePort audioDevicePort = (AudioDevicePort) audioPort;
                        if (audioDevicePort.type() == 1024 || audioDevicePort.type() == 262144) {
                            int[] formats = audioDevicePort.formats();
                            if (formats.length > 0) {
                                ArrayList arrayList2 = new ArrayList(1);
                                int length = formats.length;
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 >= length) {
                                        break;
                                    }
                                    int i4 = formats[i3];
                                    if (i4 != 0) {
                                        arrayList2.add(Integer.valueOf(i4));
                                    }
                                    i2 = i3 + 1;
                                }
                                int[] iArr = new int[arrayList2.size()];
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 >= iArr.length) {
                                        break;
                                    }
                                    iArr[i6] = ((Integer) arrayList2.get(i6)).intValue();
                                    i5 = i6 + 1;
                                }
                                intent.putExtra(AudioManager.EXTRA_ENCODINGS, iArr);
                            }
                            int i7 = 0;
                            int[] channelMasks = audioDevicePort.channelMasks();
                            int length2 = channelMasks.length;
                            int i8 = 0;
                            while (i8 < length2) {
                                int channelCountFromOutChannelMask = AudioFormat.channelCountFromOutChannelMask(channelMasks[i8]);
                                int i9 = i7;
                                if (channelCountFromOutChannelMask > i7) {
                                    i9 = channelCountFromOutChannelMask;
                                }
                                i8++;
                                i7 = i9;
                            }
                            intent.putExtra(AudioManager.EXTRA_MAX_CHANNEL_COUNT, i7);
                        }
                    }
                }
            }
        }
    }

    private void createAudioSystemThread() {
        this.mAudioSystemThread = new AudioSystemThread();
        this.mAudioSystemThread.start();
        waitForAudioHandlerCreation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createStreamStates() {
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        VolumeStreamState[] volumeStreamStateArr = new VolumeStreamState[numStreamTypes];
        this.mStreamStates = volumeStreamStateArr;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= numStreamTypes) {
                checkAllFixedVolumeDevices();
                checkAllAliasStreamVolumes();
                return;
            }
            volumeStreamStateArr[i2] = new VolumeStreamState(Settings.System.VOLUME_SETTINGS[this.mStreamVolumeAlias[i2]], i2);
            i = i2 + 1;
        }
    }

    private boolean discardRmtSbmxFullVolDeathHandlerFor(IBinder iBinder) {
        Iterator<RmtSbmxFullVolDeathHandler> it = this.mRmtSbmxFullVolDeathHandlers.iterator();
        while (it.hasNext()) {
            RmtSbmxFullVolDeathHandler next = it.next();
            if (next.isHandlerFor(iBinder)) {
                next.forget();
                this.mRmtSbmxFullVolDeathHandlers.remove(next);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectBluetoothSco(int i) {
        synchronized (this.mScoClients) {
            checkScoAudioState();
            if (this.mScoAudioState != 2 && this.mScoAudioState != 4) {
                clearAllScoClients(i, true);
            } else if (this.mBluetoothHeadsetDevice != null) {
                if (this.mBluetoothHeadset != null) {
                    if (!this.mBluetoothHeadset.stopVoiceRecognition(this.mBluetoothHeadsetDevice)) {
                        sendMsg(this.mAudioHandler, 9, 0, 0, 0, null, 0);
                    }
                } else if (this.mScoAudioState == 2 && getBluetoothHeadset()) {
                    this.mScoAudioState = 4;
                }
            }
        }
    }

    private void doSetMasterVolume(float f, int i) {
        if (AudioSystem.getMasterMute()) {
            return;
        }
        int masterVolume = getMasterVolume();
        AudioSystem.setMasterVolume(f);
        int masterVolume2 = getMasterVolume();
        if (masterVolume2 != masterVolume) {
            sendMsg(this.mAudioHandler, 2, 0, Math.round(1000.0f * f), 0, null, 500);
            setSystemAudioVolume(masterVolume, masterVolume2, getMasterMaxVolume(), i);
        }
        sendMasterVolumeUpdate(i, masterVolume, masterVolume2);
    }

    private void dumpAudioPolicies(PrintWriter printWriter) {
        printWriter.println("\nAudio policies:");
        synchronized (this.mAudioPolicies) {
            for (AudioPolicyProxy audioPolicyProxy : this.mAudioPolicies.values()) {
                printWriter.println(audioPolicyProxy.toLogFriendlyString());
            }
        }
    }

    private void dumpRingerMode(PrintWriter printWriter) {
        printWriter.println("\nRinger mode: ");
        printWriter.println("- mode (internal) = " + RINGER_MODE_NAMES[this.mRingerMode]);
        printWriter.println("- mode (external) = " + RINGER_MODE_NAMES[this.mRingerModeExternal]);
        printWriter.print("- ringer mode affected streams = 0x");
        printWriter.println(Integer.toHexString(this.mRingerModeAffectedStreams));
        printWriter.print("- ringer mode muted streams = 0x");
        printWriter.println(Integer.toHexString(this.mRingerModeMutedStreams));
        printWriter.print("- delegate = ");
        printWriter.println(this.mRingerModeDelegate);
    }

    private void dumpStreamStates(PrintWriter printWriter) {
        printWriter.println("\nStream volumes (device: index)");
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= numStreamTypes) {
                printWriter.print("\n- mute affected streams = 0x");
                printWriter.println(Integer.toHexString(this.mMuteAffectedStreams));
                return;
            }
            printWriter.println("- " + STREAM_NAMES[i2] + ":");
            this.mStreamStates[i2].dump(printWriter);
            printWriter.println("");
            i = i2 + 1;
        }
    }

    private void enforceSafeMediaVolume() {
        VolumeStreamState volumeStreamState = this.mStreamStates[3];
        int i = 12;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i == 0) {
                return;
            }
            int i4 = i3 + 1;
            int i5 = 1 << i3;
            if ((i5 & i) == 0) {
                i2 = i4;
            } else {
                if (volumeStreamState.getIndex(i5) > this.mSafeMediaVolumeIndex) {
                    volumeStreamState.setIndex(this.mSafeMediaVolumeIndex, i5);
                    sendMsg(this.mAudioHandler, 0, 2, i5, 0, volumeStreamState, 0);
                }
                i &= i5 ^ (-1);
                i2 = i4;
            }
        }
    }

    private void enforceSelfOrSystemUI(String str) {
        this.mContext.enforceCallingOrSelfPermission(Manifest.permission.STATUS_BAR_SERVICE, "Only SystemUI can " + str);
    }

    private void ensureValidDirection(int i) {
        if (i < -1 || i > 1) {
            throw new IllegalArgumentException("Bad direction " + i);
        }
    }

    private void ensureValidRingerMode(int i) {
        if (!isValidRingerMode(i)) {
            throw new IllegalArgumentException("Bad ringer mode " + i);
        }
    }

    private void ensureValidSteps(int i) {
        if (Math.abs(i) > 4) {
            throw new IllegalArgumentException("Bad volume adjust steps " + i);
        }
    }

    private void ensureValidStreamType(int i) {
        if (i < 0 || i >= this.mStreamStates.length) {
            throw new IllegalArgumentException("Bad stream type " + i);
        }
    }

    private int findVolumeDelta(int i, int i2) {
        int i3 = 0;
        if (i == 1) {
            if (i2 == 100) {
                return 0;
            }
            int i4 = this.mMasterVolumeRamp[1];
            int length = this.mMasterVolumeRamp.length;
            int i5 = 1;
            while (true) {
                int i6 = length - i5;
                i3 = i4;
                if (i6 <= 1) {
                    break;
                } else if (i2 >= this.mMasterVolumeRamp[i6 - 1]) {
                    i3 = this.mMasterVolumeRamp[i6];
                    break;
                } else {
                    length = i6;
                    i5 = 2;
                }
            }
        } else if (i == -1) {
            if (i2 == 0) {
                return 0;
            }
            int length2 = this.mMasterVolumeRamp.length;
            int i7 = -this.mMasterVolumeRamp[length2 - 1];
            int i8 = 2;
            while (true) {
                int i9 = i8;
                i3 = i7;
                if (i9 >= length2) {
                    break;
                } else if (i2 <= this.mMasterVolumeRamp[i9]) {
                    i3 = -this.mMasterVolumeRamp[i9 - 1];
                    break;
                } else {
                    i8 = i9 + 2;
                }
            }
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getActiveStreamType(int r5) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.AudioService.getActiveStreamType(int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getBluetoothHeadset() {
        boolean z = false;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            z = defaultAdapter.getProfileProxy(this.mContext, this.mBluetoothProfileServiceListener, 1);
        }
        sendMsg(this.mAudioHandler, 9, 0, 0, 0, null, z ? 3000 : 0);
        return z;
    }

    public static int getDefaultStreamVolume(int i) {
        return DEFAULT_STREAM_VOLUME[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDeviceForStream(int i) {
        int devicesForStream = AudioSystem.getDevicesForStream(i);
        int i2 = devicesForStream;
        if (((devicesForStream - 1) & devicesForStream) != 0) {
            if ((devicesForStream & 2) == 0) {
                if ((262144 & devicesForStream) != 0) {
                    return 262144;
                }
                if ((524288 & devicesForStream) != 0) {
                    return 524288;
                }
                if ((2097152 & devicesForStream) != 0) {
                    return 2097152;
                }
                return devicesForStream & AudioSystem.DEVICE_OUT_ALL_A2DP;
            }
            i2 = 2;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getMaxStreamVolume(int i) {
        return MAX_STREAM_VOLUME[i];
    }

    private ScoClient getScoClient(IBinder iBinder, boolean z) {
        ScoClient scoClient;
        synchronized (this.mScoClients) {
            try {
                int size = this.mScoClients.size();
                ScoClient scoClient2 = null;
                for (int i = 0; i < size; i++) {
                    try {
                        scoClient2 = this.mScoClients.get(i);
                        if (scoClient2.getBinder() == iBinder) {
                            return scoClient2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
                if (z) {
                    scoClient = new ScoClient(iBinder);
                    this.mScoClients.add(scoClient);
                } else {
                    scoClient = scoClient2;
                }
                return scoClient;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static int getValueForVibrateSetting(int i, int i2, int i3) {
        return (i & ((3 << (i2 * 2)) ^ (-1))) | ((i3 & 3) << (i2 * 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConfigurationChanged(Context context) {
        int i;
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (this.mMonitorOrientation && (i = configuration.orientation) != this.mDeviceOrientation) {
                this.mDeviceOrientation = i;
                setOrientationForAudioSystem();
            }
            sendMsg(this.mAudioHandler, 16, 0, 0, 0, null, 0);
            boolean z = this.mContext.getResources().getBoolean(R.bool.config_camera_sound_forced);
            synchronized (this.mSettingsLock) {
                boolean z2 = false;
                synchronized (this.mCameraSoundForced) {
                    if (z != this.mCameraSoundForced.booleanValue()) {
                        this.mCameraSoundForced = Boolean.valueOf(z);
                        z2 = true;
                    }
                }
                if (z2) {
                    if (!isPlatformTelevision()) {
                        VolumeStreamState volumeStreamState = this.mStreamStates[7];
                        if (z) {
                            volumeStreamState.setAllIndexesToMax();
                            this.mRingerModeAffectedStreams &= -129;
                        } else {
                            volumeStreamState.setAllIndexes(this.mStreamStates[1]);
                            this.mRingerModeAffectedStreams |= 128;
                        }
                        setRingerModeInt(getRingerModeInternal(), false);
                    }
                    sendMsg(this.mAudioHandler, 8, 2, 4, z ? 11 : 0, null, 0);
                    sendMsg(this.mAudioHandler, 10, 2, 0, 0, this.mStreamStates[7], 0);
                }
            }
            this.mVolumeController.setLayoutDirection(configuration.getLayoutDirection());
        } catch (Exception e) {
            Log.e(TAG, "Error handling configuration change: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleDeviceConnection(boolean z, int i, String str) {
        boolean z2;
        synchronized (this.mConnectedDevices) {
            if (!this.mConnectedDevices.containsKey(Integer.valueOf(i)) || (!str.isEmpty() && !this.mConnectedDevices.get(Integer.valueOf(i)).equals(str))) {
                z2 = false;
                if (!z2 && !z) {
                    AudioSystem.setDeviceConnectionState(i, 0, this.mConnectedDevices.get(Integer.valueOf(i)));
                    this.mConnectedDevices.remove(Integer.valueOf(i));
                    return true;
                } else if (z2 && z) {
                    AudioSystem.setDeviceConnectionState(i, 1, str);
                    this.mConnectedDevices.put(new Integer(i), str);
                    return true;
                } else {
                    return false;
                }
            }
            z2 = true;
            if (!z2) {
            }
            if (z2) {
            }
            return false;
        }
    }

    private boolean hasRmtSbmxFullVolDeathHandlerFor(IBinder iBinder) {
        Iterator<RmtSbmxFullVolDeathHandler> it = this.mRmtSbmxFullVolDeathHandlers.iterator();
        while (it.hasNext()) {
            if (it.next().isHandlerFor(iBinder)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasScheduledA2dpDockTimeout() {
        return this.mAudioHandler.hasMessages(6);
    }

    private boolean isAfMusicActiveRecently(int i) {
        return AudioSystem.isStreamActive(3, i) || AudioSystem.isStreamActiveRemotely(3, i);
    }

    private boolean isInCommunication() {
        TelecomManager telecomManager = (TelecomManager) this.mContext.getSystemService("telecom");
        long clearCallingIdentity = Binder.clearCallingIdentity();
        boolean isInCall = telecomManager.isInCall();
        Binder.restoreCallingIdentity(clearCallingIdentity);
        return isInCall || getMode() == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlatformTelevision() {
        return this.mPlatformType == 2;
    }

    private boolean isPlatformVoice() {
        return this.mPlatformType == 1;
    }

    private boolean isStreamMutedByRingerMode(int i) {
        return (this.mRingerModeMutedStreams & (1 << i)) != 0;
    }

    private void loadTouchSoundAssetDefaults() {
        SOUND_EFFECT_FILES.add("Effect_Tick.ogg");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return;
            }
            this.SOUND_EFFECT_FILES_MAP[i2][0] = 0;
            this.SOUND_EFFECT_FILES_MAP[i2][1] = -1;
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadTouchSoundAssets() {
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        XmlResourceParser xmlResourceParser4 = null;
        if (SOUND_EFFECT_FILES.isEmpty()) {
            loadTouchSoundAssetDefaults();
            try {
                try {
                    XmlResourceParser xml = this.mContext.getResources().getXml(R.xml.audio_assets);
                    XmlUtils.beginDocument(xml, TAG_AUDIO_ASSETS);
                    boolean z = false;
                    if ("1.0".equals(xml.getAttributeValue(null, "version"))) {
                        while (true) {
                            XmlUtils.nextElement(xml);
                            String name = xml.getName();
                            if (name == null) {
                                break;
                            } else if (name.equals("group") && GROUP_TOUCH_SOUNDS.equals(xml.getAttributeValue(null, "name"))) {
                                z = true;
                                break;
                            }
                        }
                        while (z) {
                            xmlResourceParser4 = xml;
                            xmlResourceParser = xml;
                            xmlResourceParser2 = xml;
                            xmlResourceParser3 = xml;
                            XmlUtils.nextElement(xml);
                            String name2 = xml.getName();
                            if (name2 == null || !name2.equals(TAG_ASSET)) {
                                break;
                            }
                            String attributeValue = xml.getAttributeValue(null, "id");
                            String attributeValue2 = xml.getAttributeValue(null, "file");
                            try {
                                int i = AudioManager.class.getField(attributeValue).getInt(null);
                                int indexOf = SOUND_EFFECT_FILES.indexOf(attributeValue2);
                                int i2 = indexOf;
                                if (indexOf == -1) {
                                    i2 = SOUND_EFFECT_FILES.size();
                                    SOUND_EFFECT_FILES.add(attributeValue2);
                                }
                                this.SOUND_EFFECT_FILES_MAP[i][0] = i2;
                            } catch (Exception e) {
                                Log.w(TAG, "Invalid touch sound ID: " + attributeValue);
                            }
                        }
                    }
                    if (xml != null) {
                        xml.close();
                    }
                } catch (Resources.NotFoundException e2) {
                    Log.w(TAG, "audio assets file not found", e2);
                    if (xmlResourceParser4 != null) {
                        xmlResourceParser4.close();
                    }
                } catch (IOException e3) {
                    Log.w(TAG, "I/O exception reading touch sound assets", e3);
                    if (xmlResourceParser2 != null) {
                        xmlResourceParser2.close();
                    }
                } catch (XmlPullParserException e4) {
                    Log.w(TAG, "XML parser exception reading touch sound assets", e4);
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                }
            } catch (Throwable th) {
                if (xmlResourceParser3 != null) {
                    xmlResourceParser3.close();
                }
                throw th;
            }
        }
    }

    private void makeA2dpDeviceAvailable(String str) {
        sendMsg(this.mAudioHandler, 0, 2, 128, 0, this.mStreamStates[3], 0);
        setBluetoothA2dpOnInt(true);
        AudioSystem.setDeviceConnectionState(128, 1, str);
        AudioSystem.setParameters("A2dpSuspended=false");
        this.mConnectedDevices.put(new Integer(128), str);
    }

    private void makeA2dpDeviceUnavailableLater(String str) {
        AudioSystem.setParameters("A2dpSuspended=true");
        this.mConnectedDevices.remove(128);
        this.mAudioHandler.sendMessageDelayed(this.mAudioHandler.obtainMessage(6, str), 8000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeA2dpDeviceUnavailableNow(String str) {
        synchronized (this.mA2dpAvrcpLock) {
            this.mAvrcpAbsVolSupported = false;
        }
        AudioSystem.setDeviceConnectionState(128, 0, str);
        this.mConnectedDevices.remove(128);
        synchronized (this.mCurAudioRoutes) {
            if (this.mCurAudioRoutes.mBluetoothName != null) {
                this.mCurAudioRoutes.mBluetoothName = null;
                sendMsg(this.mAudioHandler, 12, 1, 0, 0, null, 0);
            }
        }
    }

    private void makeA2dpSrcAvailable(String str) {
        AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_IN_BLUETOOTH_A2DP, 1, str);
        this.mConnectedDevices.put(new Integer((int) AudioSystem.DEVICE_IN_BLUETOOTH_A2DP), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeA2dpSrcUnavailable(String str) {
        AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_IN_BLUETOOTH_A2DP, 0, str);
        this.mConnectedDevices.remove(Integer.valueOf((int) AudioSystem.DEVICE_IN_BLUETOOTH_A2DP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBroadcastScoConnectionState(int i) {
        if (i != this.mScoConnectionState) {
            Intent intent = new Intent(AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED);
            intent.putExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, i);
            intent.putExtra(AudioManager.EXTRA_SCO_AUDIO_PREVIOUS_STATE, this.mScoConnectionState);
            sendStickyBroadcastToAll(intent);
            this.mScoConnectionState = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCheckMusicActive() {
        synchronized (this.mSafeMediaVolumeState) {
            if (this.mSafeMediaVolumeState.intValue() == 2) {
                int deviceForStream = getDeviceForStream(3);
                if ((deviceForStream & 12) != 0) {
                    sendMsg(this.mAudioHandler, 14, 0, 0, 0, null, 60000);
                    int index = this.mStreamStates[3].getIndex(deviceForStream);
                    if (AudioSystem.isStreamActive(3, 0) && index > this.mSafeMediaVolumeIndex) {
                        this.mMusicActiveMs += 60000;
                        if (this.mMusicActiveMs > UNSAFE_VOLUME_MUSIC_ACTIVE_MS_MAX) {
                            setSafeMediaVolumeEnabled(true);
                            this.mMusicActiveMs = 0;
                        }
                        saveMusicActiveMs();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onConfigureSafeVolume(boolean r9) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.AudioService.onConfigureSafeVolume(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendBecomingNoisyIntent() {
        Intent intent = new Intent(AudioManager.ACTION_AUDIO_BECOMING_NOISY);
        intent.addFlags(268435456);
        sendBroadcastToAll(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetA2dpSinkConnectionState(BluetoothDevice bluetoothDevice, int i) {
        boolean z = true;
        if (DEBUG_VOL) {
            Log.d(TAG, "onSetA2dpSinkConnectionState btDevice=" + bluetoothDevice + "state=" + i);
        }
        if (bluetoothDevice == null) {
            return;
        }
        String address = bluetoothDevice.getAddress();
        String str = address;
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            str = "";
        }
        synchronized (this.mConnectedDevices) {
            if (!this.mConnectedDevices.containsKey(128) || !this.mConnectedDevices.get(128).equals(str)) {
                z = false;
            }
            if (z && i != 2) {
                if (!bluetoothDevice.isBluetoothDock()) {
                    makeA2dpDeviceUnavailableNow(str);
                } else if (i == 0) {
                    makeA2dpDeviceUnavailableLater(str);
                }
                synchronized (this.mCurAudioRoutes) {
                    if (this.mCurAudioRoutes.mBluetoothName != null) {
                        this.mCurAudioRoutes.mBluetoothName = null;
                        sendMsg(this.mAudioHandler, 12, 1, 0, 0, null, 0);
                    }
                }
            } else if (!z && i == 2) {
                if (bluetoothDevice.isBluetoothDock()) {
                    cancelA2dpDeviceTimeout();
                    this.mDockAddress = str;
                } else if (hasScheduledA2dpDockTimeout()) {
                    cancelA2dpDeviceTimeout();
                    makeA2dpDeviceUnavailableNow(this.mDockAddress);
                }
                makeA2dpDeviceAvailable(str);
                synchronized (this.mCurAudioRoutes) {
                    String aliasName = bluetoothDevice.getAliasName();
                    if (!TextUtils.equals(this.mCurAudioRoutes.mBluetoothName, aliasName)) {
                        this.mCurAudioRoutes.mBluetoothName = aliasName;
                        sendMsg(this.mAudioHandler, 12, 1, 0, 0, null, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetA2dpSourceConnectionState(BluetoothDevice bluetoothDevice, int i) {
        if (DEBUG_VOL) {
            Log.d(TAG, "onSetA2dpSourceConnectionState btDevice=" + bluetoothDevice + " state=" + i);
        }
        if (bluetoothDevice == null) {
            return;
        }
        String address = bluetoothDevice.getAddress();
        String str = address;
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            str = "";
        }
        synchronized (this.mConnectedDevices) {
            boolean z = this.mConnectedDevices.containsKey(Integer.valueOf((int) AudioSystem.DEVICE_IN_BLUETOOTH_A2DP)) && this.mConnectedDevices.get(Integer.valueOf((int) AudioSystem.DEVICE_IN_BLUETOOTH_A2DP)).equals(str);
            if (z && i != 2) {
                makeA2dpSrcUnavailable(str);
            } else if (!z && i == 2) {
                makeA2dpSrcAvailable(str);
            }
        }
    }

    private void onSetStreamVolume(int i, int i2, int i3, int i4) {
        setStreamVolumeInt(this.mStreamVolumeAlias[i], i2, i4, false);
        if ((i3 & 2) != 0 || this.mStreamVolumeAlias[i] == getMasterStreamType()) {
            setRingerMode(i2 == 0 ? this.mHasVibrator ? 1 : 0 : 2, "AudioService.onSetStreamVolume", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetWiredDeviceConnectionState(int i, int i2, String str) {
        boolean z = false;
        synchronized (this.mConnectedDevices) {
            if (i2 == 0 && (i == 4 || i == 8 || i == 131072)) {
                setBluetoothA2dpOnInt(true);
            }
            boolean z2 = (i & (-24577)) == 0 || ((Integer.MIN_VALUE & i) != 0 && (2147477503 & i) == 0);
            if (i2 == 1) {
                z = true;
            }
            handleDeviceConnection(z, i, z2 ? str : "");
            if (i2 != 0) {
                if (i == 4 || i == 8 || i == 131072) {
                    setBluetoothA2dpOnInt(false);
                }
                if ((i & 12) != 0) {
                    sendMsg(this.mAudioHandler, 14, 0, 0, 0, null, 60000);
                }
                if (isPlatformTelevision() && (i & 1024) != 0) {
                    this.mFixedVolumeDevices |= 1024;
                    checkAllFixedVolumeDevices();
                    if (this.mHdmiManager != null) {
                        synchronized (this.mHdmiManager) {
                            if (this.mHdmiPlaybackClient != null) {
                                this.mHdmiCecSink = false;
                                this.mHdmiPlaybackClient.queryDisplayStatus(this.mHdmiDisplayStatusCallback);
                            }
                        }
                    }
                }
            } else if (isPlatformTelevision() && (i & 1024) != 0 && this.mHdmiManager != null) {
                synchronized (this.mHdmiManager) {
                    this.mHdmiCecSink = false;
                }
            }
            if (!z2 && i != -2147483632) {
                sendDeviceConnectionIntent(i, i2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queueMsgUnderWakeLock(Handler handler, int i, int i2, int i3, Object obj, int i4) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        this.mAudioEventWakeLock.acquire();
        Binder.restoreCallingIdentity(clearCallingIdentity);
        sendMsg(handler, i, 2, i2, i3, obj, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readAndSetLowRamDevice() {
        int lowRamDevice = AudioSystem.setLowRamDevice(ActivityManager.isLowRamDeviceStatic());
        if (lowRamDevice != 0) {
            Log.w(TAG, "AudioFlinger informed of device's low RAM attribute; status " + lowRamDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readAudioSettings(boolean z) {
        readPersistedSettings();
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= numStreamTypes) {
                break;
            }
            VolumeStreamState volumeStreamState = this.mStreamStates[i2];
            if (!z || this.mStreamVolumeAlias[i2] != 3) {
                volumeStreamState.readSettings();
                synchronized (VolumeStreamState.class) {
                    try {
                        if (volumeStreamState.isMuted_syncVSS() && ((!isStreamAffectedByMute(i2) && !isStreamMutedByRingerMode(i2)) || this.mUseFixedVolume)) {
                            int size = volumeStreamState.mDeathHandlers.size();
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= size) {
                                    break;
                                }
                                ((VolumeStreamState.VolumeDeathHandler) volumeStreamState.mDeathHandlers.get(i4)).mMuteCount = 1;
                                ((VolumeStreamState.VolumeDeathHandler) volumeStreamState.mDeathHandlers.get(i4)).mute_syncVSS(false);
                                i3 = i4 + 1;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            i = i2 + 1;
        }
        setRingerModeInt(getRingerModeInternal(), false);
        checkAllFixedVolumeDevices();
        checkAllAliasStreamVolumes();
        synchronized (this.mSafeMediaVolumeState) {
            this.mMusicActiveMs = MathUtils.constrain(Settings.Secure.getIntForUser(this.mContentResolver, Settings.Secure.UNSAFE_VOLUME_MUSIC_ACTIVE_MS, 0, -2), 0, (int) UNSAFE_VOLUME_MUSIC_ACTIVE_MS_MAX);
            if (this.mSafeMediaVolumeState.intValue() == 3) {
                enforceSafeMediaVolume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readDockAudioSettings(ContentResolver contentResolver) {
        boolean z = true;
        if (Settings.Global.getInt(contentResolver, Settings.Global.DOCK_AUDIO_MEDIA_ENABLED, 0) != 1) {
            z = false;
        }
        this.mDockAudioMediaEnabled = z;
        if (this.mDockAudioMediaEnabled) {
            this.mBecomingNoisyIntentDevices |= 2048;
        } else {
            this.mBecomingNoisyIntentDevices &= -2049;
        }
        sendMsg(this.mAudioHandler, 8, 2, 3, this.mDockAudioMediaEnabled ? 8 : 0, null, 0);
    }

    private void readPersistedSettings() {
        ContentResolver contentResolver = this.mContentResolver;
        int i = Settings.Global.getInt(contentResolver, "mode_ringer", 2);
        int i2 = i;
        if (!isValidRingerMode(i)) {
            i2 = 2;
        }
        int i3 = i2;
        if (i2 == 1) {
            i3 = i2;
            if (!this.mHasVibrator) {
                i3 = 0;
            }
        }
        if (i3 != i) {
            Settings.Global.putInt(contentResolver, "mode_ringer", i3);
        }
        if (this.mUseFixedVolume || isPlatformTelevision()) {
            i3 = 2;
        }
        synchronized (this.mSettingsLock) {
            this.mRingerMode = i3;
            if (this.mRingerModeExternal == -1) {
                this.mRingerModeExternal = this.mRingerMode;
            }
            this.mVibrateSetting = getValueForVibrateSetting(0, 1, this.mHasVibrator ? 2 : 0);
            this.mVibrateSetting = getValueForVibrateSetting(this.mVibrateSetting, 0, this.mHasVibrator ? 2 : 0);
            updateRingerModeAffectedStreams();
            readDockAudioSettings(contentResolver);
            this.mVolumeKeysControlRingStream = Settings.System.getIntForUser(contentResolver, Settings.System.VOLUME_KEYS_CONTROL_RING_STREAM, 1, -2) == 1;
        }
        this.mLinkNotificationWithVolume = Settings.Secure.getInt(contentResolver, Settings.Secure.VOLUME_LINK_NOTIFICATION, 1) == 1;
        this.mMuteAffectedStreams = Settings.System.getIntForUser(contentResolver, Settings.System.MUTE_STREAMS_AFFECTED, 14, -2);
        boolean z = Settings.System.getIntForUser(contentResolver, Settings.System.VOLUME_MASTER_MUTE, 0, -2) == 1;
        if (this.mUseFixedVolume) {
            z = false;
            AudioSystem.setMasterVolume(1.0f);
        }
        AudioSystem.setMasterMute(z);
        broadcastMasterMuteStatus(z);
        AudioSystem.muteMicrophone(Settings.System.getIntForUser(contentResolver, Settings.System.MICROPHONE_MUTE, 0, -2) == 1);
        broadcastRingerMode(AudioManager.RINGER_MODE_CHANGED_ACTION, this.mRingerModeExternal);
        broadcastRingerMode(AudioManager.INTERNAL_RINGER_MODE_CHANGED_ACTION, this.mRingerMode);
        broadcastVibrateSetting(0);
        broadcastVibrateSetting(1);
        this.mVolumeController.loadSettings(contentResolver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rescaleIndex(int i, int i2, int i3) {
        return ((this.mStreamStates[i3].getMaxIndex() * i) + (this.mStreamStates[i2].getMaxIndex() / 2)) / this.mStreamStates[i2].getMaxIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetBluetoothSco() {
        synchronized (this.mScoClients) {
            clearAllScoClients(0, false);
            this.mScoAudioState = 0;
            broadcastScoConnectionState(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreMasterVolume() {
        if (this.mUseFixedVolume) {
            AudioSystem.setMasterVolume(1.0f);
        } else if (this.mUseMasterVolume) {
            float floatForUser = Settings.System.getFloatForUser(this.mContentResolver, Settings.System.VOLUME_MASTER, -1.0f, -2);
            if (floatForUser >= 0.0f) {
                AudioSystem.setMasterVolume(floatForUser);
            }
        }
    }

    private static String safeMediaVolumeStateToString(Integer num) {
        switch (num.intValue()) {
            case 0:
                return "SAFE_MEDIA_VOLUME_NOT_CONFIGURED";
            case 1:
                return "SAFE_MEDIA_VOLUME_DISABLED";
            case 2:
                return "SAFE_MEDIA_VOLUME_INACTIVE";
            case 3:
                return "SAFE_MEDIA_VOLUME_ACTIVE";
            default:
                return null;
        }
    }

    private void saveMusicActiveMs() {
        this.mAudioHandler.obtainMessage(22, this.mMusicActiveMs, 0).sendToTarget();
    }

    private void sendBroadcastToAll(Intent intent) {
        sendBroadcastToAll(intent, null);
    }

    private void sendBroadcastToAll(Intent intent, String str) {
        intent.addFlags(67108864);
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL, str);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    private void sendDeviceConnectionIntent(int i, int i2, String str) {
        Intent intent = new Intent();
        intent.putExtra("state", i2);
        intent.putExtra("name", str);
        intent.addFlags(1073741824);
        int i3 = 0;
        if (i == 4) {
            intent.setAction("android.intent.action.HEADSET_PLUG");
            intent.putExtra(ZegoConstants.DeviceNameType.DeviceNameMicrophone, 1);
            i3 = 1;
            if (i2 == 1) {
                startMusicPlayer();
                i3 = 1;
            }
        } else if (i == 8 || i == 131072) {
            intent.setAction("android.intent.action.HEADSET_PLUG");
            intent.putExtra(ZegoConstants.DeviceNameType.DeviceNameMicrophone, 0);
            i3 = 2;
            if (i2 == 1) {
                startMusicPlayer();
                i3 = 2;
            }
        } else if (i == 2048) {
            i3 = 4;
            intent.setAction(AudioManager.ACTION_ANALOG_AUDIO_DOCK_PLUG);
        } else if (i == 4096) {
            i3 = 4;
            intent.setAction(AudioManager.ACTION_DIGITAL_AUDIO_DOCK_PLUG);
        } else if (i == 1024 || i == 262144) {
            i3 = 8;
            configureHdmiPlugIntent(intent, i2);
        }
        synchronized (this.mCurAudioRoutes) {
            if (i3 != 0) {
                int i4 = this.mCurAudioRoutes.mMainType;
                int i5 = i2 != 0 ? i4 | i3 : i4 & (i3 ^ (-1));
                if (i5 != this.mCurAudioRoutes.mMainType) {
                    this.mCurAudioRoutes.mMainType = i5;
                    sendMsg(this.mAudioHandler, 12, 1, 0, 0, null, 0);
                }
            }
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            ActivityManagerNative.broadcastStickyIntent(intent, null, -1);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    private void sendMasterMuteUpdate(boolean z, int i) {
        this.mVolumeController.postMasterMuteChanged(updateFlagsForSystemAudio(i));
        broadcastMasterMuteStatus(z);
    }

    private void sendMasterVolumeUpdate(int i, int i2, int i3) {
        this.mVolumeController.postMasterVolumeChanged(updateFlagsForSystemAudio(i));
        Intent intent = new Intent(AudioManager.MASTER_VOLUME_CHANGED_ACTION);
        intent.putExtra(AudioManager.EXTRA_PREV_MASTER_VOLUME_VALUE, i2);
        intent.putExtra(AudioManager.EXTRA_MASTER_VOLUME_VALUE, i3);
        sendBroadcastToAll(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendMsg(Handler handler, int i, int i2, int i3, int i4, Object obj, int i5) {
        if (i2 == 0) {
            handler.removeMessages(i);
        } else if (i2 == 1 && handler.hasMessages(i)) {
            return;
        }
        synchronized (mLastDeviceConnectMsgTime) {
            long uptimeMillis = SystemClock.uptimeMillis() + i5;
            handler.sendMessageAtTime(handler.obtainMessage(i, i3, i4, obj), uptimeMillis);
            if (i == 100 || i == 101 || i == 102) {
                mLastDeviceConnectMsgTime = Long.valueOf(uptimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStickyBroadcastToAll(Intent intent) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            this.mContext.sendStickyBroadcastAsUser(intent, UserHandle.ALL);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    private void sendVolumeUpdate(int i, int i2, int i3, int i4) {
        int i5 = i;
        if (!isPlatformVoice()) {
            i5 = i;
            if (i == 2) {
                i5 = 5;
            }
        }
        int i6 = i4;
        if (i5 == 3) {
            i6 = updateFlagsForSystemAudio(i4);
        }
        this.mVolumeController.postVolumeChanged(i5, i6);
        if ((i6 & 32) == 0) {
            Intent intent = new Intent("android.media.VOLUME_CHANGED_ACTION");
            intent.putExtra(AudioManager.EXTRA_VOLUME_STREAM_TYPE, i5);
            intent.putExtra(AudioManager.EXTRA_VOLUME_STREAM_VALUE, (i3 + 5) / 10);
            intent.putExtra(AudioManager.EXTRA_PREV_VOLUME_STREAM_VALUE, (i2 + 5) / 10);
            sendBroadcastToAll(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMasterMuteInternal(boolean z, int i, String str, IBinder iBinder, int i2) {
        if (this.mUseFixedVolume || this.mAppOps.noteOp(33, i2, str) != 0 || z == AudioSystem.getMasterMute()) {
            return;
        }
        setSystemAudioMute(z);
        AudioSystem.setMasterMute(z);
        sendMsg(this.mAudioHandler, 11, 0, z ? 1 : 0, UserHandle.getCallingUserId(), null, 500);
        sendMasterMuteUpdate(z, i);
        Intent intent = new Intent(AudioManager.MASTER_MUTE_CHANGED_ACTION);
        intent.putExtra(AudioManager.EXTRA_MASTER_VOLUME_MUTED, z);
        sendBroadcastToAll(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setModeInt(int i, IBinder iBinder, int i2) {
        SetModeDeathHandler setModeDeathHandler;
        int i3;
        int i4;
        if (DEBUG_MODE) {
            Log.v(TAG, "setModeInt(mode=" + i + ", pid=" + i2 + ")");
        }
        if (iBinder == null) {
            Log.e(TAG, "setModeInt() called with null binder");
            return 0;
        }
        Iterator<SetModeDeathHandler> it = this.mSetModeDeathHandlers.iterator();
        while (true) {
            setModeDeathHandler = null;
            if (!it.hasNext()) {
                break;
            }
            setModeDeathHandler = it.next();
            if (setModeDeathHandler.getPid() == i2) {
                it.remove();
                setModeDeathHandler.getBinder().unlinkToDeath(setModeDeathHandler, 0);
                break;
            }
        }
        IBinder iBinder2 = iBinder;
        int i5 = i;
        SetModeDeathHandler setModeDeathHandler2 = setModeDeathHandler;
        do {
            if (i5 == 0) {
                i3 = i5;
                if (!this.mSetModeDeathHandlers.isEmpty()) {
                    SetModeDeathHandler setModeDeathHandler3 = this.mSetModeDeathHandlers.get(0);
                    IBinder binder = setModeDeathHandler3.getBinder();
                    int mode = setModeDeathHandler3.getMode();
                    setModeDeathHandler2 = setModeDeathHandler3;
                    i3 = mode;
                    iBinder2 = binder;
                    if (DEBUG_MODE) {
                        Log.w(TAG, " using mode=" + mode + " instead due to death hdlr at pid=" + setModeDeathHandler3.mPid);
                        iBinder2 = binder;
                        i3 = mode;
                        setModeDeathHandler2 = setModeDeathHandler3;
                    }
                }
            } else {
                SetModeDeathHandler setModeDeathHandler4 = setModeDeathHandler2;
                if (setModeDeathHandler2 == null) {
                    setModeDeathHandler4 = new SetModeDeathHandler(iBinder2, i2);
                }
                try {
                    iBinder2.linkToDeath(setModeDeathHandler4, 0);
                } catch (RemoteException e) {
                    Log.w(TAG, "setMode() could not link to " + iBinder2 + " binder death");
                }
                this.mSetModeDeathHandlers.add(0, setModeDeathHandler4);
                setModeDeathHandler4.setMode(i5);
                setModeDeathHandler2 = setModeDeathHandler4;
                i3 = i5;
            }
            if (i3 != this.mMode) {
                i4 = AudioSystem.setPhoneState(i3);
                if (i4 == 0) {
                    if (DEBUG_MODE) {
                        Log.v(TAG, " mode successfully set to " + i3);
                    }
                    this.mMode = i3;
                } else {
                    if (setModeDeathHandler2 != null) {
                        this.mSetModeDeathHandlers.remove(setModeDeathHandler2);
                        iBinder2.unlinkToDeath(setModeDeathHandler2, 0);
                    }
                    if (DEBUG_MODE) {
                        Log.w(TAG, " mode set to MODE_NORMAL after phoneState pb");
                    }
                    i3 = 0;
                }
            } else {
                i4 = 0;
            }
            if (i4 == 0) {
                break;
            }
            i5 = i3;
        } while (!this.mSetModeDeathHandlers.isEmpty());
        int i6 = 0;
        if (i4 == 0) {
            i6 = 0;
            if (i3 != 0) {
                if (this.mSetModeDeathHandlers.isEmpty()) {
                    Log.e(TAG, "setMode() different from MODE_NORMAL with empty mode client stack");
                    i6 = 0;
                } else {
                    i6 = this.mSetModeDeathHandlers.get(0).getPid();
                }
            }
            int activeStreamType = getActiveStreamType(Integer.MIN_VALUE);
            int deviceForStream = getDeviceForStream(activeStreamType);
            setStreamVolumeInt(this.mStreamVolumeAlias[activeStreamType], this.mStreamStates[this.mStreamVolumeAlias[activeStreamType]].getIndex(deviceForStream), deviceForStream, true);
            updateStreamVolumeAlias(true);
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrientationForAudioSystem() {
        switch (this.mDeviceOrientation) {
            case 0:
                AudioSystem.setParameters("orientation=undefined");
                return;
            case 1:
                AudioSystem.setParameters("orientation=portrait");
                return;
            case 2:
                AudioSystem.setParameters("orientation=landscape");
                return;
            case 3:
                AudioSystem.setParameters("orientation=square");
                return;
            default:
                Log.e(TAG, "Unknown orientation");
                return;
        }
    }

    private void setRingerMode(int i, String str, boolean z) {
        if (this.mUseFixedVolume || isPlatformTelevision()) {
            return;
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Bad caller: " + str);
        }
        ensureValidRingerMode(i);
        int i2 = i;
        if (i == 1) {
            i2 = i;
            if (!this.mHasVibrator) {
                i2 = 0;
            }
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            synchronized (this.mSettingsLock) {
                int ringerModeInternal = getRingerModeInternal();
                int ringerModeExternal = getRingerModeExternal();
                if (z) {
                    setRingerModeExt(i2);
                    int i3 = i2;
                    if (this.mRingerModeDelegate != null) {
                        i3 = this.mRingerModeDelegate.onSetRingerModeExternal(ringerModeExternal, i2, str, ringerModeInternal);
                    }
                    if (i3 != ringerModeInternal) {
                        setRingerModeInt(i3, true);
                    }
                } else {
                    if (i2 != ringerModeInternal) {
                        setRingerModeInt(i2, true);
                    }
                    int i4 = i2;
                    if (this.mRingerModeDelegate != null) {
                        i4 = this.mRingerModeDelegate.onSetRingerModeInternal(ringerModeInternal, i2, str, ringerModeExternal);
                    }
                    setRingerModeExt(i4);
                }
            }
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    private void setRingerModeExt(int i) {
        synchronized (this.mSettingsLock) {
            if (i == this.mRingerModeExternal) {
                return;
            }
            this.mRingerModeExternal = i;
            broadcastRingerMode(AudioManager.RINGER_MODE_CHANGED_ACTION, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRingerModeInt(int i, boolean z) {
        boolean z2;
        synchronized (this.mSettingsLock) {
            z2 = this.mRingerMode != i;
            this.mRingerMode = i;
        }
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        boolean z3 = i == 1 || i == 0;
        while (true) {
            numStreamTypes--;
            if (numStreamTypes < 0) {
                break;
            }
            boolean isStreamMutedByRingerMode = isStreamMutedByRingerMode(numStreamTypes);
            boolean z4 = z3 && isStreamAffectedByRingerMode(numStreamTypes);
            if (isStreamMutedByRingerMode != z4) {
                if (z4) {
                    this.mStreamStates[numStreamTypes].mute(null, true);
                    this.mRingerModeMutedStreams |= 1 << numStreamTypes;
                } else {
                    if ((isPlatformVoice() || this.mHasVibrator) && this.mStreamVolumeAlias[numStreamTypes] == 2) {
                        synchronized (VolumeStreamState.class) {
                            try {
                                for (Map.Entry entry : this.mStreamStates[numStreamTypes].mIndex.entrySet()) {
                                    if (((Integer) entry.getValue()).intValue() == 0) {
                                        entry.setValue(10);
                                    }
                                }
                                sendMsg(this.mAudioHandler, 1, 2, getDeviceForStream(numStreamTypes), 0, this.mStreamStates[numStreamTypes], 500);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    this.mStreamStates[numStreamTypes].mute(null, false);
                    this.mRingerModeMutedStreams &= (1 << numStreamTypes) ^ (-1);
                }
            }
        }
        if (z) {
            sendMsg(this.mAudioHandler, 3, 0, 0, 0, null, 500);
        }
        if (z2) {
            broadcastRingerMode(AudioManager.INTERNAL_RINGER_MODE_CHANGED_ACTION, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRotationForAudioSystem() {
        switch (this.mDeviceRotation) {
            case 0:
                AudioSystem.setParameters("rotation=0");
                return;
            case 1:
                AudioSystem.setParameters("rotation=90");
                return;
            case 2:
                AudioSystem.setParameters("rotation=180");
                return;
            case 3:
                AudioSystem.setParameters("rotation=270");
                return;
            default:
                Log.e(TAG, "Unknown device rotation");
                return;
        }
    }

    private void setSafeMediaVolumeEnabled(boolean z) {
        synchronized (this.mSafeMediaVolumeState) {
            if (this.mSafeMediaVolumeState.intValue() != 0 && this.mSafeMediaVolumeState.intValue() != 1) {
                if (z && this.mSafeMediaVolumeState.intValue() == 2) {
                    this.mSafeMediaVolumeState = 3;
                    enforceSafeMediaVolume();
                } else if (!z && this.mSafeMediaVolumeState.intValue() == 3) {
                    this.mSafeMediaVolumeState = 2;
                    this.mMusicActiveMs = 1;
                    saveMusicActiveMs();
                    sendMsg(this.mAudioHandler, 14, 0, 0, 0, null, 60000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamVolume(int i, int i2, int i3, String str, int i4) {
        int index;
        int i5;
        int i6;
        if (this.mUseFixedVolume) {
            return;
        }
        ensureValidStreamType(i);
        int i7 = this.mStreamVolumeAlias[i];
        VolumeStreamState volumeStreamState = this.mStreamStates[i7];
        int deviceForStream = getDeviceForStream(i);
        if (((deviceForStream & AudioSystem.DEVICE_OUT_ALL_A2DP) != 0 || (i3 & 64) == 0) && this.mAppOps.noteOp(STEAM_VOLUME_OPS[i7], i4, str) == 0) {
            synchronized (this.mSafeMediaVolumeState) {
                this.mPendingVolumeCommand = null;
                index = volumeStreamState.getIndex(deviceForStream);
                int rescaleIndex = rescaleIndex(i2 * 10, i, i7);
                if (i7 == 3 && (deviceForStream & AudioSystem.DEVICE_OUT_ALL_A2DP) != 0 && (i3 & 64) == 0) {
                    synchronized (this.mA2dpAvrcpLock) {
                        if (this.mA2dp != null && this.mAvrcpAbsVolSupported) {
                            this.mA2dp.setAvrcpAbsoluteVolume(rescaleIndex / 10);
                        }
                    }
                }
                if (i7 == 3) {
                    setSystemAudioVolume(index, rescaleIndex, getStreamMaxVolume(i), i3);
                }
                int i8 = i3 & (-33);
                i5 = rescaleIndex;
                i6 = i8;
                if (i7 == 3) {
                    i5 = rescaleIndex;
                    i6 = i8;
                    if ((this.mFixedVolumeDevices & deviceForStream) != 0) {
                        int i9 = i8 | 32;
                        i5 = rescaleIndex;
                        i6 = i9;
                        if (rescaleIndex != 0) {
                            if (this.mSafeMediaVolumeState.intValue() != 3 || (deviceForStream & 12) == 0) {
                                i5 = volumeStreamState.getMaxIndex();
                                i6 = i9;
                            } else {
                                i5 = this.mSafeMediaVolumeIndex;
                                i6 = i9;
                            }
                        }
                    }
                }
                if (checkSafeMediaVolume(i7, i5, deviceForStream)) {
                    onSetStreamVolume(i, i5, i6, deviceForStream);
                    i5 = this.mStreamStates[i].getIndex(deviceForStream);
                } else {
                    this.mVolumeController.postDisplaySafeVolumeWarning(i6);
                    this.mPendingVolumeCommand = new StreamVolumeCommand(i, i5, i6, deviceForStream);
                }
            }
            sendVolumeUpdate(i, index, i5, i6);
        }
    }

    private void setStreamVolumeInt(int i, int i2, int i3, boolean z) {
        VolumeStreamState volumeStreamState = this.mStreamStates[i];
        if (volumeStreamState.setIndex(i2, i3) || z) {
            sendMsg(this.mAudioHandler, 0, 2, i3, 0, volumeStreamState, 0);
        }
    }

    private void setSystemAudioMute(boolean z) {
        if (this.mHdmiManager == null || this.mHdmiTvClient == null) {
            return;
        }
        synchronized (this.mHdmiManager) {
            if (this.mHdmiSystemAudioSupported) {
                synchronized (this.mHdmiTvClient) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        this.mHdmiTvClient.setSystemAudioMute(z);
                    } finally {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                }
            }
        }
    }

    private void setSystemAudioVolume(int i, int i2, int i3, int i4) {
        if (this.mHdmiManager == null || this.mHdmiTvClient == null || i == i2 || (i4 & 256) != 0) {
            return;
        }
        synchronized (this.mHdmiManager) {
            if (this.mHdmiSystemAudioSupported) {
                synchronized (this.mHdmiTvClient) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    this.mHdmiTvClient.setSystemAudioVolume((i + 5) / 10, (i2 + 5) / 10, i3);
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
        }
    }

    private void startMusicPlayer() {
        boolean z = false;
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), Settings.System.HEADSET_CONNECT_PLAYER, 0, -2) != 0) {
            z = true;
        }
        TelecomManager telecomManager = (TelecomManager) this.mContext.getSystemService("telecom");
        if (!z || telecomManager.isInCall()) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MUSIC);
        intent.setFlags(268435456);
        try {
            this.mContext.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "error launching music player", e);
        }
    }

    public static String streamToString(int i) {
        return (i < 0 || i >= STREAM_NAMES.length) ? i == Integer.MIN_VALUE ? "USE_DEFAULT_STREAM_TYPE" : "UNKNOWN_STREAM_" + i : STREAM_NAMES[i];
    }

    private int updateFlagsForSystemAudio(int i) {
        int i2;
        if (this.mHdmiTvClient != null) {
            synchronized (this.mHdmiTvClient) {
                i2 = i;
                if (this.mHdmiSystemAudioSupported) {
                    i2 = i;
                    if ((i & 256) == 0) {
                        i2 = i & (-2);
                    }
                }
            }
            return i2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStreamVolumeAlias(boolean z) {
        int i;
        switch (this.mPlatformType) {
            case 1:
                this.mStreamVolumeAlias = this.STREAM_VOLUME_ALIAS_VOICE;
                i = 2;
                break;
            case 2:
                this.mStreamVolumeAlias = this.STREAM_VOLUME_ALIAS_TELEVISION;
                i = 3;
                break;
            default:
                this.mStreamVolumeAlias = this.STREAM_VOLUME_ALIAS_DEFAULT;
                i = 3;
                break;
        }
        if (isPlatformTelevision()) {
            this.mRingerModeAffectedStreams = 0;
        } else if (isInCommunication()) {
            i = 0;
            this.mRingerModeAffectedStreams &= -257;
        } else {
            this.mRingerModeAffectedStreams |= 256;
        }
        this.mStreamVolumeAlias[8] = i;
        if (this.mLinkNotificationWithVolume && this.mVoiceCapable) {
            this.mStreamVolumeAlias[5] = 2;
        } else {
            this.mStreamVolumeAlias[5] = 5;
        }
        if (z) {
            this.mStreamStates[8].setAllIndexes(this.mStreamStates[i]);
            setRingerModeInt(getRingerModeInternal(), false);
            sendMsg(this.mAudioHandler, 10, 2, 0, 0, this.mStreamStates[8], 0);
        }
    }

    private void waitForAudioHandlerCreation() {
        synchronized (this) {
            while (this.mAudioHandler == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Log.e(TAG, "Interrupted while waiting on volume handler.");
                }
            }
        }
    }

    @Override // android.media.IAudioService
    public int abandonAudioFocus(IAudioFocusDispatcher iAudioFocusDispatcher, String str, AudioAttributes audioAttributes) {
        return this.mMediaFocusControl.abandonAudioFocus(iAudioFocusDispatcher, str, audioAttributes);
    }

    @Override // android.media.IAudioService
    public void addMediaPlayerAndUpdateRemoteController(String str) {
        Log.v(TAG, "addMediaPlayerAndUpdateRemoteController: size of existing list: " + mMediaPlayers.size());
        boolean z = true;
        boolean z2 = true;
        if (mMediaPlayers.size() > 0) {
            Iterator<MediaPlayerInfo> it = mMediaPlayers.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                MediaPlayerInfo next = it.next();
                if (str.equals(next.getPackageName())) {
                    Log.e(TAG, "Player entry present, no need to add");
                    z2 = false;
                    next.setFocus(true);
                } else {
                    Log.e(TAG, "Player: " + next.getPackageName() + "Lost Focus");
                    next.setFocus(false);
                }
            }
        }
        if (z) {
            Log.e(TAG, "Adding Player: " + str + " to available player list");
            mMediaPlayers.add(new MediaPlayerInfo(str, true));
        }
        Intent intent = new Intent(AudioManager.RCC_CHANGED_ACTION);
        intent.putExtra(AudioManager.EXTRA_CALLING_PACKAGE_NAME, str);
        intent.putExtra(AudioManager.EXTRA_FOCUS_CHANGED_VALUE, true);
        intent.putExtra(AudioManager.EXTRA_AVAILABLITY_CHANGED_VALUE, true);
        sendBroadcastToAll(intent);
        Log.v(TAG, "updating focussed RCC change to RCD: CallingPackageName:" + str);
    }

    @Override // android.media.IAudioService
    public void adjustMasterVolume(int i, int i2, String str) {
        adjustMasterVolume(i, i2, str, Binder.getCallingUid());
    }

    public void adjustMasterVolume(int i, int i2, String str, int i3) {
        if (this.mUseFixedVolume) {
            return;
        }
        ensureValidSteps(i);
        int round = Math.round(AudioSystem.getMasterVolume() * 100.0f);
        int abs = Math.abs(i);
        int i4 = i > 0 ? 1 : -1;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= abs) {
                setMasterVolume(round, i2, str, i3);
                return;
            } else {
                round += findVolumeDelta(i4, round);
                i5 = i6 + 1;
            }
        }
    }

    @Override // android.media.IAudioService
    public void adjustStreamVolume(int i, int i2, int i3, String str) {
        adjustStreamVolume(i, i2, i3, str, Binder.getCallingUid());
    }

    @Override // android.media.IAudioService
    public void adjustSuggestedStreamVolume(int i, int i2, int i3, String str) {
        adjustSuggestedStreamVolume(i, i2, i3, str, Binder.getCallingUid());
    }

    @Override // android.media.IAudioService
    public void avrcpSupportsAbsoluteVolume(String str, boolean z) {
        synchronized (this.mA2dpAvrcpLock) {
            this.mAvrcpAbsVolSupported = z;
            sendMsg(this.mAudioHandler, 0, 2, 128, 0, this.mStreamStates[3], 0);
            sendMsg(this.mAudioHandler, 0, 2, 128, 0, this.mStreamStates[2], 0);
        }
    }

    boolean checkAudioSettingsPermission(String str) {
        if (this.mContext.checkCallingOrSelfPermission(Manifest.permission.MODIFY_AUDIO_SETTINGS) == 0) {
            return true;
        }
        Log.w(TAG, "Audio Settings Permission Denial: " + str + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
        return false;
    }

    public void clearAllScoClients(int i, boolean z) {
        synchronized (this.mScoClients) {
            ScoClient scoClient = null;
            int size = this.mScoClients.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                ScoClient scoClient2 = this.mScoClients.get(i3);
                if (scoClient2.getPid() != i) {
                    scoClient2.clearCount(z);
                } else {
                    scoClient = scoClient2;
                }
                i2 = i3 + 1;
            }
            this.mScoClients.clear();
            if (scoClient != null) {
                this.mScoClients.add(scoClient);
            }
        }
    }

    @Override // android.media.IAudioService
    public void disableSafeMediaVolume() {
        enforceSelfOrSystemUI("disable the safe media volume");
        synchronized (this.mSafeMediaVolumeState) {
            setSafeMediaVolumeEnabled(false);
            if (this.mPendingVolumeCommand != null) {
                onSetStreamVolume(this.mPendingVolumeCommand.mStreamType, this.mPendingVolumeCommand.mIndex, this.mPendingVolumeCommand.mFlags, this.mPendingVolumeCommand.mDevice);
                this.mPendingVolumeCommand = null;
            }
        }
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mContext.enforceCallingOrSelfPermission(Manifest.permission.DUMP, TAG);
        this.mMediaFocusControl.dump(printWriter);
        dumpStreamStates(printWriter);
        dumpRingerMode(printWriter);
        printWriter.println("\nAudio routes:");
        printWriter.print("  mMainType=0x");
        printWriter.println(Integer.toHexString(this.mCurAudioRoutes.mMainType));
        printWriter.print("  mBluetoothName=");
        printWriter.println(this.mCurAudioRoutes.mBluetoothName);
        printWriter.println("\nOther state:");
        printWriter.print("  mVolumeController=");
        printWriter.println(this.mVolumeController);
        printWriter.print("  mSafeMediaVolumeState=");
        printWriter.println(safeMediaVolumeStateToString(this.mSafeMediaVolumeState));
        printWriter.print("  mSafeMediaVolumeIndex=");
        printWriter.println(this.mSafeMediaVolumeIndex);
        printWriter.print("  mPendingVolumeCommand=");
        printWriter.println(this.mPendingVolumeCommand);
        printWriter.print("  mMusicActiveMs=");
        printWriter.println(this.mMusicActiveMs);
        printWriter.print("  mMcc=");
        printWriter.println(this.mMcc);
        printWriter.print("  mHasVibrator=");
        printWriter.println(this.mHasVibrator);
        dumpAudioPolicies(printWriter);
    }

    @Override // android.media.IAudioService
    public void forceRemoteSubmixFullVolume(boolean z, IBinder iBinder) {
        boolean z2;
        if (iBinder == null) {
            return;
        }
        if (this.mContext.checkCallingOrSelfPermission(Manifest.permission.CAPTURE_AUDIO_OUTPUT) != 0) {
            Log.w(TAG, "Trying to call forceRemoteSubmixFullVolume() without CAPTURE_AUDIO_OUTPUT");
            return;
        }
        synchronized (this.mRmtSbmxFullVolDeathHandlers) {
            if (z) {
                z2 = false;
                if (!hasRmtSbmxFullVolDeathHandlerFor(iBinder)) {
                    this.mRmtSbmxFullVolDeathHandlers.add(new RmtSbmxFullVolDeathHandler(iBinder));
                    z2 = false;
                    if (this.mRmtSbmxFullVolRefCount == 0) {
                        this.mFullVolumeDevices |= 32768;
                        this.mFixedVolumeDevices |= 32768;
                        z2 = true;
                    }
                    this.mRmtSbmxFullVolRefCount++;
                }
            } else {
                z2 = false;
                if (discardRmtSbmxFullVolDeathHandlerFor(iBinder)) {
                    z2 = false;
                    if (this.mRmtSbmxFullVolRefCount > 0) {
                        this.mRmtSbmxFullVolRefCount--;
                        z2 = false;
                        if (this.mRmtSbmxFullVolRefCount == 0) {
                            this.mFullVolumeDevices &= -32769;
                            this.mFixedVolumeDevices &= -32769;
                            z2 = true;
                        }
                    }
                }
            }
            if (z2) {
                checkAllFixedVolumeDevices(3);
                this.mStreamStates[3].applyAllVolumes();
            }
        }
    }

    @Override // android.media.IAudioService
    public void forceVolumeControlStream(int i, IBinder iBinder) {
        synchronized (this.mForceControlStreamLock) {
            this.mVolumeControlStream = i;
            if (this.mVolumeControlStream != -1) {
                this.mForceControlStreamClient = new ForceControlStreamClient(iBinder);
            } else if (this.mForceControlStreamClient != null) {
                this.mForceControlStreamClient.release();
                this.mForceControlStreamClient = null;
            }
        }
    }

    @Override // android.media.IAudioService
    public int getCurrentAudioFocus() {
        return this.mMediaFocusControl.getCurrentAudioFocus();
    }

    @Override // android.media.IAudioService
    public String getCurrentHotwordInputPackageName() {
        return this.mHotwordAudioInputPackage;
    }

    @Override // android.media.IAudioService
    public int getLastAudibleMasterVolume() {
        return Math.round(AudioSystem.getMasterVolume() * 100.0f);
    }

    @Override // android.media.IAudioService
    public int getLastAudibleStreamVolume(int i) {
        ensureValidStreamType(i);
        return (this.mStreamStates[i].getIndex(getDeviceForStream(i)) + 5) / 10;
    }

    @Override // android.media.IAudioService
    public int getMasterMaxVolume() {
        return 100;
    }

    @Override // android.media.IAudioService
    public int getMasterStreamType() {
        return this.mStreamVolumeAlias[1];
    }

    @Override // android.media.IAudioService
    public int getMasterVolume() {
        if (isMasterMute()) {
            return 0;
        }
        return getLastAudibleMasterVolume();
    }

    @Override // android.media.IAudioService
    public int getMode() {
        return this.mMode;
    }

    @Override // android.media.IAudioService
    public void getRemoteControlClientNowPlayingEntries() {
        this.mMediaFocusControl.getRemoteControlClientNowPlayingEntries();
    }

    @Override // android.media.IAudioService
    public int getRingerModeExternal() {
        int i;
        synchronized (this.mSettingsLock) {
            i = this.mRingerModeExternal;
        }
        return i;
    }

    @Override // android.media.IAudioService
    public int getRingerModeInternal() {
        int i;
        synchronized (this.mSettingsLock) {
            i = this.mRingerMode;
        }
        return i;
    }

    @Override // android.media.IAudioService
    public IRingtonePlayer getRingtonePlayer() {
        return this.mRingtonePlayer;
    }

    @Override // android.media.IAudioService
    public int getStreamMaxVolume(int i) {
        ensureValidStreamType(i);
        return (this.mStreamStates[i].getMaxIndex() + 5) / 10;
    }

    @Override // android.media.IAudioService
    public int getStreamVolume(int i) {
        int i2;
        ensureValidStreamType(i);
        int deviceForStream = getDeviceForStream(i);
        synchronized (VolumeStreamState.class) {
            try {
                int index = this.mStreamStates[i].getIndex(deviceForStream);
                if (this.mStreamStates[i].isMuted_syncVSS()) {
                    index = 0;
                }
                int i3 = index;
                if (index != 0) {
                    i3 = index;
                    if (this.mStreamVolumeAlias[i] == 3) {
                        i3 = index;
                        if ((this.mFixedVolumeDevices & deviceForStream) != 0) {
                            i3 = this.mStreamStates[i].getMaxIndex();
                        }
                    }
                }
                i2 = (i3 + 5) / 10;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    @Override // android.media.IAudioService
    public int getVibrateSetting(int i) {
        if (this.mHasVibrator) {
            return (this.mVibrateSetting >> (i * 2)) & 3;
        }
        return 0;
    }

    @Override // android.media.IAudioService
    public void handleHotwordInput(boolean z) {
        synchronized (this.mHotwordInputLock) {
            Intent intent = new Intent(Intent.ACTION_HOTWORD_INPUT_CHANGED);
            String[] packagesForUid = this.mContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid.length > 0) {
                if (z) {
                    this.mHotwordAudioInputPackage = packagesForUid[0];
                }
                intent.putExtra(Intent.EXTRA_CURRENT_PACKAGE_NAME, packagesForUid[0]);
            }
            intent.putExtra(Intent.EXTRA_HOTWORD_INPUT_STATE, z ? 3 : 1);
            if (!z) {
                this.mHotwordAudioInputPackage = null;
            }
            sendBroadcastToAll(intent, Manifest.permission.CAPTURE_AUDIO_HOTWORD);
        }
    }

    @Override // android.media.IAudioService
    public boolean isBluetoothA2dpOn() {
        boolean z;
        synchronized (this.mBluetoothA2dpEnabledLock) {
            z = this.mBluetoothA2dpEnabled;
        }
        return z;
    }

    @Override // android.media.IAudioService
    public boolean isBluetoothScoOn() {
        return this.mForcedUseForComm == 3;
    }

    @Override // android.media.IAudioService
    public boolean isCameraSoundForced() {
        boolean booleanValue;
        synchronized (this.mCameraSoundForced) {
            booleanValue = this.mCameraSoundForced.booleanValue();
        }
        return booleanValue;
    }

    @Override // android.media.IAudioService
    public boolean isHdmiSystemAudioSupported() {
        return this.mHdmiSystemAudioSupported;
    }

    @Override // android.media.IAudioService
    public boolean isMasterMute() {
        return AudioSystem.getMasterMute();
    }

    @Override // android.media.IAudioService
    public boolean isSpeakerphoneOn() {
        return this.mForcedUseForComm == 1;
    }

    public boolean isStreamAffectedByMute(int i) {
        return (this.mMuteAffectedStreams & (1 << i)) != 0;
    }

    @Override // android.media.IAudioService
    public boolean isStreamAffectedByRingerMode(int i) {
        return (this.mRingerModeAffectedStreams & (1 << i)) != 0;
    }

    @Override // android.media.IAudioService
    public boolean isStreamMute(int i) {
        boolean isMuted_syncVSS;
        int i2 = i;
        if (i == Integer.MIN_VALUE) {
            i2 = getActiveStreamType(i);
        }
        synchronized (VolumeStreamState.class) {
            try {
                isMuted_syncVSS = this.mStreamStates[i2].isMuted_syncVSS();
            } catch (Throwable th) {
                throw th;
            }
        }
        return isMuted_syncVSS;
    }

    @Override // android.media.IAudioService
    public boolean isValidRingerMode(int i) {
        return i >= 0 && i <= 2;
    }

    @Override // android.media.IAudioService
    public boolean loadSoundEffects() {
        LoadSoundEffectReply loadSoundEffectReply = new LoadSoundEffectReply();
        synchronized (loadSoundEffectReply) {
            try {
                sendMsg(this.mAudioHandler, 7, 2, 0, 0, loadSoundEffectReply, 0);
                int i = 3;
                while (true) {
                    try {
                        int i2 = i;
                        if (loadSoundEffectReply.mStatus != 1) {
                            break;
                        }
                        int i3 = i2 - 1;
                        if (i2 <= 0) {
                            break;
                        }
                        try {
                            loadSoundEffectReply.wait(5000L);
                            i = i3;
                        } catch (InterruptedException e) {
                            Log.w(TAG, "loadSoundEffects Interrupted while waiting sound pool loaded.");
                            i = i3;
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
                return loadSoundEffectReply.mStatus == 0;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // android.media.IAudioService
    public void notifyVolumeControllerVisible(IVolumeController iVolumeController, boolean z) {
        enforceSelfOrSystemUI("notify about volume controller visibility");
        if (this.mVolumeController.isSameBinder(iVolumeController)) {
            this.mVolumeController.setVisible(z);
            if (DEBUG_VOL) {
                Log.d(TAG, "Volume controller visible: " + z);
            }
        }
    }

    public void onSystemReady() {
        this.mSystemReady = true;
        sendMsg(this.mAudioHandler, 7, 2, 0, 0, null, 0);
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService(Context.KEYGUARD_SERVICE);
        this.mScoConnectionState = -1;
        resetBluetoothSco();
        getBluetoothHeadset();
        Intent intent = new Intent(AudioManager.ACTION_SCO_AUDIO_STATE_CHANGED);
        intent.putExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, 0);
        sendStickyBroadcastToAll(intent);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            defaultAdapter.getProfileProxy(this.mContext, this.mBluetoothProfileServiceListener, 2);
        }
        this.mHdmiManager = (HdmiControlManager) this.mContext.getSystemService(Context.HDMI_CONTROL_SERVICE);
        if (this.mHdmiManager != null) {
            synchronized (this.mHdmiManager) {
                this.mHdmiTvClient = this.mHdmiManager.getTvClient();
                if (this.mHdmiTvClient != null) {
                    this.mFixedVolumeDevices &= -2883587;
                }
                this.mHdmiPlaybackClient = this.mHdmiManager.getPlaybackClient();
                this.mHdmiCecSink = false;
            }
        }
        sendMsg(this.mAudioHandler, 17, 0, 0, 0, null, 30000);
        StreamOverride.init(this.mContext);
    }

    @Override // android.media.IAudioService
    public void playSoundEffect(int i) {
        playSoundEffectVolume(i, -1.0f);
    }

    @Override // android.media.IAudioService
    public void playSoundEffectVolume(int i, float f) {
        if (i >= 10 || i < 0) {
            Log.w(TAG, "AudioService effectType value " + i + " out of range");
        } else {
            sendMsg(this.mAudioHandler, 5, 2, i, (int) (1000.0f * f), null, 0);
        }
    }

    @Override // android.media.IAudioService
    public String registerAudioPolicy(AudioPolicyConfig audioPolicyConfig, IAudioPolicyCallback iAudioPolicyCallback, boolean z) {
        boolean z2 = false;
        if (DEBUG_AP) {
            Log.d(TAG, "registerAudioPolicy for " + iAudioPolicyCallback.asBinder() + " with config:" + audioPolicyConfig);
        }
        if (this.mContext.checkCallingPermission(Manifest.permission.MODIFY_AUDIO_ROUTING) == 0) {
            z2 = true;
        }
        if (!z2) {
            Slog.w(TAG, "Can't register audio policy for pid " + Binder.getCallingPid() + " / uid " + Binder.getCallingUid() + ", need MODIFY_AUDIO_ROUTING");
            return null;
        }
        synchronized (this.mAudioPolicies) {
            try {
                if (this.mAudioPolicies.containsKey(iAudioPolicyCallback.asBinder())) {
                    Slog.e(TAG, "Cannot re-register policy");
                    return null;
                }
                AudioPolicyProxy audioPolicyProxy = new AudioPolicyProxy(audioPolicyConfig, iAudioPolicyCallback, z);
                iAudioPolicyCallback.asBinder().linkToDeath(audioPolicyProxy, 0);
                String registrationId = audioPolicyProxy.getRegistrationId();
                this.mAudioPolicies.put(iAudioPolicyCallback.asBinder(), audioPolicyProxy);
                return registrationId;
            } catch (RemoteException e) {
                Slog.w(TAG, "Audio policy registration failed, could not link to " + iAudioPolicyCallback + " binder death", e);
                return null;
            }
        }
    }

    @Override // android.media.IAudioService
    public boolean registerRemoteControlDisplay(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2) {
        return this.mMediaFocusControl.registerRemoteControlDisplay(iRemoteControlDisplay, i, i2);
    }

    @Override // android.media.IAudioService
    public boolean registerRemoteController(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2, ComponentName componentName) {
        return this.mMediaFocusControl.registerRemoteController(iRemoteControlDisplay, i, i2, componentName);
    }

    @Override // android.media.IAudioService
    public void reloadAudioSettings() {
        readAudioSettings(false);
    }

    @Override // android.media.IAudioService
    public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay iRemoteControlDisplay, int i, int i2) {
        this.mMediaFocusControl.remoteControlDisplayUsesBitmapSize(iRemoteControlDisplay, i, i2);
    }

    @Override // android.media.IAudioService
    public void remoteControlDisplayWantsPlaybackPositionSync(IRemoteControlDisplay iRemoteControlDisplay, boolean z) {
        this.mMediaFocusControl.remoteControlDisplayWantsPlaybackPositionSync(iRemoteControlDisplay, z);
    }

    @Override // android.media.IAudioService
    public void removeMediaPlayerAndUpdateRemoteController(String str) {
        MediaPlayerInfo next;
        Log.v(TAG, "removeMediaPlayerAndUpdateRemoteController: size of existing list: " + mMediaPlayers.size());
        int i = -1;
        int i2 = -1;
        boolean z = false;
        if (mMediaPlayers.size() > 0) {
            Iterator<MediaPlayerInfo> it = mMediaPlayers.iterator();
            while (true) {
                i2 = i;
                z = false;
                if (!it.hasNext()) {
                    break;
                }
                i2 = i + 1;
                if (str.equals(it.next().getPackageName())) {
                    Log.v(TAG, "Player entry present remove and update RemoteController");
                    z = true;
                    break;
                }
                Log.v(TAG, "Player entry for " + next.getPackageName() + " is not present");
                i = i2;
            }
        }
        if (z) {
            Log.e(TAG, "Removing Player: " + str + " from index" + i2);
            mMediaPlayers.remove(i2);
        }
        Intent intent = new Intent(AudioManager.RCC_CHANGED_ACTION);
        intent.putExtra(AudioManager.EXTRA_CALLING_PACKAGE_NAME, str);
        intent.putExtra(AudioManager.EXTRA_FOCUS_CHANGED_VALUE, false);
        intent.putExtra(AudioManager.EXTRA_AVAILABLITY_CHANGED_VALUE, false);
        sendBroadcastToAll(intent);
        Log.v(TAG, "Updated List size: " + mMediaPlayers.size());
    }

    @Override // android.media.IAudioService
    public int requestAudioFocus(AudioAttributes audioAttributes, int i, IBinder iBinder, IAudioFocusDispatcher iAudioFocusDispatcher, String str, String str2, int i2, IAudioPolicyCallback iAudioPolicyCallback) {
        if ((i2 & 4) == 4) {
            MediaFocusControl mediaFocusControl = this.mMediaFocusControl;
            if (!"AudioFocus_For_Phone_Ring_And_Calls".equals(str)) {
                synchronized (this.mAudioPolicies) {
                    if (!this.mAudioPolicies.containsKey(iAudioPolicyCallback.asBinder())) {
                        Log.e(TAG, "Invalid unregistered AudioPolicy to (un)lock audio focus");
                        return 0;
                    }
                }
            } else if (this.mContext.checkCallingOrSelfPermission(Manifest.permission.MODIFY_PHONE_STATE) != 0) {
                Log.e(TAG, "Invalid permission to (un)lock audio focus", new Exception());
                return 0;
            }
        }
        return this.mMediaFocusControl.requestAudioFocus(audioAttributes, i, iBinder, iAudioFocusDispatcher, str, str2, i2);
    }

    @Override // android.media.IAudioService
    public int setBluetoothA2dpDeviceConnectionState(BluetoothDevice bluetoothDevice, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 2 || i2 == 10) {
            synchronized (this.mConnectedDevices) {
                if (i2 == 2) {
                    if (i == 2) {
                        i4 = 1;
                    }
                    i3 = checkSendBecomingNoisyIntent(128, i4);
                } else {
                    i3 = 0;
                }
                queueMsgUnderWakeLock(this.mAudioHandler, i2 == 2 ? 102 : 101, i, 0, bluetoothDevice, i3);
            }
            return i3;
        }
        throw new IllegalArgumentException("invalid profile " + i2);
    }

    @Override // android.media.IAudioService
    public void setBluetoothA2dpOn(boolean z) {
        int i = 0;
        synchronized (this.mBluetoothA2dpEnabledLock) {
            this.mBluetoothA2dpEnabled = z;
            AudioHandler audioHandler = this.mAudioHandler;
            if (!this.mBluetoothA2dpEnabled) {
                i = 10;
            }
            sendMsg(audioHandler, 13, 2, 1, i, null, 0);
        }
    }

    public void setBluetoothA2dpOnInt(boolean z) {
        synchronized (this.mBluetoothA2dpEnabledLock) {
            this.mBluetoothA2dpEnabled = z;
            this.mAudioHandler.removeMessages(13);
            AudioSystem.setForceUse(1, this.mBluetoothA2dpEnabled ? 0 : 10);
        }
    }

    @Override // android.media.IAudioService
    public void setBluetoothScoOn(boolean z) {
        if (checkAudioSettingsPermission("setBluetoothScoOn()")) {
            if (z) {
                this.mForcedUseForComm = 3;
            } else if (this.mForcedUseForComm == 3) {
                this.mForcedUseForComm = 0;
            }
            sendMsg(this.mAudioHandler, 8, 2, 0, this.mForcedUseForComm, null, 0);
            sendMsg(this.mAudioHandler, 8, 2, 2, this.mForcedUseForComm, null, 0);
        }
    }

    @Override // android.media.IAudioService
    public int setFocusPropertiesForPolicy(int i, IAudioPolicyCallback iAudioPolicyCallback) {
        if (DEBUG_AP) {
            Log.d(TAG, "setFocusPropertiesForPolicy() duck behavior=" + i + " policy " + iAudioPolicyCallback.asBinder());
        }
        if (!(this.mContext.checkCallingPermission(Manifest.permission.MODIFY_AUDIO_ROUTING) == 0)) {
            Slog.w(TAG, "Cannot change audio policy ducking handling for pid " + Binder.getCallingPid() + " / uid " + Binder.getCallingUid() + ", need MODIFY_AUDIO_ROUTING");
            return -1;
        }
        synchronized (this.mAudioPolicies) {
            if (!this.mAudioPolicies.containsKey(iAudioPolicyCallback.asBinder())) {
                Slog.e(TAG, "Cannot change audio policy focus properties, unregistered policy");
                return -1;
            }
            AudioPolicyProxy audioPolicyProxy = this.mAudioPolicies.get(iAudioPolicyCallback.asBinder());
            if (i == 1) {
                Iterator<AudioPolicyProxy> it = this.mAudioPolicies.values().iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (it.next().mFocusDuckBehavior != 1);
                Slog.e(TAG, "Cannot change audio policy ducking behavior, already handled");
                return -1;
            }
            audioPolicyProxy.mFocusDuckBehavior = i;
            this.mMediaFocusControl.setDuckingInExtPolicyAvailable(i == 1);
            return 0;
        }
    }

    @Override // android.media.IAudioService
    public int setHdmiSystemAudioSupported(boolean z) {
        int i = 0;
        if (this.mHdmiManager != null) {
            synchronized (this.mHdmiManager) {
                if (this.mHdmiTvClient == null) {
                    Log.w(TAG, "Only Hdmi-Cec enabled TV device supports system audio mode.");
                    return 0;
                }
                synchronized (this.mHdmiTvClient) {
                    if (this.mHdmiSystemAudioSupported != z) {
                        this.mHdmiSystemAudioSupported = z;
                        AudioSystem.setForceUse(5, z ? 12 : 0);
                    }
                    i = AudioSystem.getDevicesForStream(3);
                }
            }
        }
        return i;
    }

    @Override // android.media.IAudioService
    public void setMasterMute(boolean z, int i, String str, IBinder iBinder) {
        setMasterMuteInternal(z, i, str, iBinder, Binder.getCallingUid());
    }

    @Override // android.media.IAudioService
    public void setMasterVolume(int i, int i2, String str) {
        setMasterVolume(i, i2, str, Binder.getCallingUid());
    }

    public void setMasterVolume(int i, int i2, String str, int i3) {
        int i4;
        if (!this.mUseFixedVolume && this.mAppOps.noteOp(33, i3, str) == 0) {
            if (i < 0) {
                i4 = 0;
            } else {
                i4 = i;
                if (i > 100) {
                    i4 = 100;
                }
            }
            doSetMasterVolume(i4 / 100.0f, i2);
        }
    }

    @Override // android.media.IAudioService
    public void setMicrophoneMute(boolean z, String str) {
        if (this.mAppOps.noteOp(44, Binder.getCallingUid(), str) == 0 && checkAudioSettingsPermission("setMicrophoneMute()")) {
            AudioSystem.muteMicrophone(z);
            sendMsg(this.mAudioHandler, 23, 0, z ? 1 : 0, UserHandle.getCallingUserId(), null, 500);
        }
    }

    @Override // android.media.IAudioService
    public void setMode(int i, IBinder iBinder) {
        int modeInt;
        if (DEBUG_MODE) {
            Log.v(TAG, "setMode(mode=" + i + ")");
        }
        if (checkAudioSettingsPermission("setMode()")) {
            if (i == 2 && this.mContext.checkCallingOrSelfPermission(Manifest.permission.MODIFY_PHONE_STATE) != 0) {
                Log.w(TAG, "MODIFY_PHONE_STATE Permission Denial: setMode(MODE_IN_CALL) from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
            } else if (i < -1 || i >= 4) {
            } else {
                synchronized (this.mSetModeDeathHandlers) {
                    int i2 = i;
                    if (i == -1) {
                        i2 = this.mMode;
                    }
                    if (i2 == 2 && isInCommunication()) {
                        AudioSystem.setParameters("in_call=true");
                    }
                    modeInt = setModeInt(i2, iBinder, Binder.getCallingPid());
                }
                if (modeInt != 0) {
                    disconnectBluetoothSco(modeInt);
                }
            }
        }
    }

    @Override // android.media.IAudioService
    public void setRemoteControlClientBrowsedPlayer() {
        this.mMediaFocusControl.setRemoteControlClientBrowsedPlayer();
    }

    @Override // android.media.IAudioService
    public void setRemoteControlClientPlayItem(long j, int i) {
        this.mMediaFocusControl.setRemoteControlClientPlayItem(j, i);
    }

    @Override // android.media.IAudioService
    public void setRemoteStreamVolume(int i) {
        enforceSelfOrSystemUI("set the remote stream volume");
        this.mMediaFocusControl.setRemoteStreamVolume(i);
    }

    @Override // android.media.IAudioService
    public void setRingerModeExternal(int i, String str) {
        setRingerMode(i, str, true);
    }

    @Override // android.media.IAudioService
    public void setRingerModeInternal(int i, String str) {
        enforceSelfOrSystemUI("setRingerModeInternal");
        setRingerMode(i, str, false);
    }

    @Override // android.media.IAudioService
    public void setRingtonePlayer(IRingtonePlayer iRingtonePlayer) {
        this.mContext.enforceCallingOrSelfPermission(Manifest.permission.REMOTE_AUDIO_PLAYBACK, null);
        this.mRingtonePlayer = iRingtonePlayer;
    }

    @Override // android.media.IAudioService
    public void setSpeakerphoneOn(boolean z) {
        if (checkAudioSettingsPermission("setSpeakerphoneOn()")) {
            if (z) {
                if (this.mForcedUseForComm == 3) {
                    sendMsg(this.mAudioHandler, 8, 2, 2, 0, null, 0);
                }
                this.mForcedUseForComm = 1;
            } else if (this.mForcedUseForComm == 1) {
                this.mForcedUseForComm = 0;
            }
            sendMsg(this.mAudioHandler, 8, 2, 0, this.mForcedUseForComm, null, 0);
        }
    }

    @Override // android.media.IAudioService
    public void setStreamMute(int i, boolean z, IBinder iBinder) {
        if (this.mUseFixedVolume) {
            return;
        }
        int i2 = i;
        if (i == Integer.MIN_VALUE) {
            i2 = getActiveStreamType(i);
        }
        int i3 = this.mStreamVolumeAlias[i2];
        if (!isStreamAffectedByMute(i3)) {
            return;
        }
        if (i3 == 3) {
            setSystemAudioMute(z);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.mStreamStates.length) {
                return;
            }
            if (i3 == this.mStreamVolumeAlias[i5]) {
                this.mStreamStates[i5].mute(iBinder, z);
                Intent intent = new Intent(AudioManager.STREAM_MUTE_CHANGED_ACTION);
                intent.putExtra(AudioManager.EXTRA_VOLUME_STREAM_TYPE, i5);
                intent.putExtra(AudioManager.EXTRA_STREAM_VOLUME_MUTED, z);
                sendBroadcastToAll(intent);
            }
            i4 = i5 + 1;
        }
    }

    @Override // android.media.IAudioService
    public void setStreamSolo(int i, boolean z, IBinder iBinder) {
        if (this.mUseFixedVolume) {
            return;
        }
        int i2 = this.mStreamVolumeAlias[i];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mStreamStates.length) {
                return;
            }
            if (isStreamAffectedByMute(i2) && i2 != this.mStreamVolumeAlias[i4]) {
                this.mStreamStates[i4].mute(iBinder, z);
            }
            i3 = i4 + 1;
        }
    }

    @Override // android.media.IAudioService
    public void setStreamVolume(int i, int i2, int i3, String str) {
        setStreamVolume(i, i2, i3, str, Binder.getCallingUid());
    }

    @Override // android.media.IAudioService
    public void setVibrateSetting(int i, int i2) {
        if (this.mHasVibrator) {
            this.mVibrateSetting = getValueForVibrateSetting(this.mVibrateSetting, i, i2);
            broadcastVibrateSetting(i);
        }
    }

    @Override // android.media.IAudioService
    public void setVolumeController(final IVolumeController iVolumeController) {
        enforceSelfOrSystemUI("set the volume controller");
        if (this.mVolumeController.isSameBinder(iVolumeController)) {
            return;
        }
        this.mVolumeController.postDismiss();
        if (iVolumeController != null) {
            try {
                iVolumeController.asBinder().linkToDeath(new IBinder.DeathRecipient() { // from class: android.media.AudioService.3
                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        if (AudioService.this.mVolumeController.isSameBinder(iVolumeController)) {
                            Log.w(AudioService.TAG, "Current remote volume controller died, unregistering");
                            AudioService.this.setVolumeController(null);
                        }
                    }
                }, 0);
            } catch (RemoteException e) {
            }
        }
        this.mVolumeController.setController(iVolumeController);
        if (DEBUG_VOL) {
            Log.d(TAG, "Volume controller: " + this.mVolumeController);
        }
    }

    @Override // android.media.IAudioService
    public void setWiredDeviceConnectionState(int i, int i2, String str) {
        synchronized (this.mConnectedDevices) {
            queueMsgUnderWakeLock(this.mAudioHandler, 100, i, i2, str, checkSendBecomingNoisyIntent(i, i2));
        }
    }

    @Override // android.media.IAudioService
    public boolean shouldVibrate(int i) {
        boolean z = true;
        if (this.mHasVibrator) {
            switch (getVibrateSetting(i)) {
                case 0:
                    return false;
                case 1:
                    if (getRingerModeExternal() == 0) {
                        z = false;
                    }
                    return z;
                case 2:
                    return getRingerModeExternal() == 1;
                default:
                    return false;
            }
        }
        return false;
    }

    @Override // android.media.IAudioService
    public void startBluetoothSco(IBinder iBinder, int i) {
        startBluetoothScoInt(iBinder, i < 18 ? 0 : -1);
    }

    void startBluetoothScoInt(IBinder iBinder, int i) {
        if (checkAudioSettingsPermission("startBluetoothSco()") && this.mSystemReady) {
            ScoClient scoClient = getScoClient(iBinder, true);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            scoClient.incCount(i);
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    @Override // android.media.IAudioService
    public void startBluetoothScoVirtualCall(IBinder iBinder) {
        startBluetoothScoInt(iBinder, 0);
    }

    @Override // android.media.IAudioService
    public AudioRoutesInfo startWatchingRoutes(IAudioRoutesObserver iAudioRoutesObserver) {
        AudioRoutesInfo audioRoutesInfo;
        synchronized (this.mCurAudioRoutes) {
            audioRoutesInfo = new AudioRoutesInfo(this.mCurAudioRoutes);
            this.mRoutesObservers.register(iAudioRoutesObserver);
        }
        return audioRoutesInfo;
    }

    @Override // android.media.IAudioService
    public void stopBluetoothSco(IBinder iBinder) {
        if (checkAudioSettingsPermission("stopBluetoothSco()") && this.mSystemReady) {
            ScoClient scoClient = getScoClient(iBinder, false);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            if (scoClient != null) {
                scoClient.decCount();
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void systemReady() {
        sendMsg(this.mAudioHandler, 21, 2, 0, 0, null, 0);
    }

    @Override // android.media.IAudioService
    public void unloadSoundEffects() {
        sendMsg(this.mAudioHandler, 20, 2, 0, 0, null, 0);
    }

    @Override // android.media.IAudioService
    public void unregisterAudioFocusClient(String str) {
        this.mMediaFocusControl.unregisterAudioFocusClient(str);
    }

    @Override // android.media.IAudioService
    public void unregisterAudioPolicyAsync(IAudioPolicyCallback iAudioPolicyCallback) {
        if (DEBUG_AP) {
            Log.d(TAG, "unregisterAudioPolicyAsync for " + iAudioPolicyCallback.asBinder());
        }
        synchronized (this.mAudioPolicies) {
            AudioPolicyProxy remove = this.mAudioPolicies.remove(iAudioPolicyCallback.asBinder());
            if (remove == null) {
                Slog.w(TAG, "Trying to unregister unknown audio policy for pid " + Binder.getCallingPid() + " / uid " + Binder.getCallingUid());
                return;
            }
            iAudioPolicyCallback.asBinder().unlinkToDeath(remove, 0);
            remove.release();
        }
    }

    @Override // android.media.IAudioService
    public void unregisterRemoteControlDisplay(IRemoteControlDisplay iRemoteControlDisplay) {
        this.mMediaFocusControl.unregisterRemoteControlDisplay(iRemoteControlDisplay);
    }

    @Override // android.media.IAudioService
    public void updateRemoteControllerOnExistingMediaPlayers() {
        Log.v(TAG, "updateRemoteControllerOnExistingMediaPlayers: size of Player list: " + mMediaPlayers.size());
        if (mMediaPlayers.size() <= 0) {
            Log.e(TAG, "No RCC entry present to update");
            return;
        }
        Log.v(TAG, "Inform RemoteController regarding existing RCC entry");
        Iterator<MediaPlayerInfo> it = mMediaPlayers.iterator();
        while (it.hasNext()) {
            MediaPlayerInfo next = it.next();
            Intent intent = new Intent(AudioManager.RCC_CHANGED_ACTION);
            intent.putExtra(AudioManager.EXTRA_CALLING_PACKAGE_NAME, next.getPackageName());
            intent.putExtra(AudioManager.EXTRA_FOCUS_CHANGED_VALUE, next.isFocussed());
            intent.putExtra(AudioManager.EXTRA_AVAILABLITY_CHANGED_VALUE, true);
            sendBroadcastToAll(intent);
            Log.v(TAG, "updating RCC change: CallingPackageName:" + next.getPackageName());
        }
    }

    boolean updateRingerModeAffectedStreams() {
        int i;
        int i2;
        int intForUser = Settings.System.getIntForUser(this.mContentResolver, Settings.System.MODE_RINGER_STREAMS_AFFECTED, 166, -2);
        switch (this.mPlatformType) {
            case 2:
                i = 0;
                break;
            default:
                i = (intForUser | 294) & (-9);
                break;
        }
        synchronized (this.mCameraSoundForced) {
            i2 = this.mCameraSoundForced.booleanValue() ? i & (-129) : i | 128;
        }
        int i3 = this.mStreamVolumeAlias[8] == 2 ? i2 | 256 : i2 & (-257);
        if (i3 != this.mRingerModeAffectedStreams) {
            Settings.System.putIntForUser(this.mContentResolver, Settings.System.MODE_RINGER_STREAMS_AFFECTED, i3, -2);
            this.mRingerModeAffectedStreams = i3;
            return true;
        }
        return false;
    }
}
