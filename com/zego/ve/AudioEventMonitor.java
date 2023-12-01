package com.zego.ve;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRouting;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.igexin.push.config.c;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/AudioEventMonitor.class */
public class AudioEventMonitor extends BroadcastReceiver {
    private static final String TAG = "device";
    protected Context _context = null;
    protected AudioManager _audioManager = null;
    protected int _mode = 0;
    public boolean duck_other_when_voip_ = false;
    public int duck_value_in_percent_ = 20;
    protected int volume_before_duck_ = -1;
    protected AudioRoutChange _audioRouteChange = null;
    protected boolean audio_route_change_valid_ = false;
    protected boolean on_receiver_first_arrive_ = true;
    protected boolean wait_check_sco_ = false;
    protected int audio_route_ = 0;
    protected int cap_original_route_ = 15;
    private int _bluetoothOpSeq = 0;
    protected Handler _handler = new Handler(Looper.getMainLooper());
    protected PhoneStateListener _phoneStateListener = null;
    protected AudioManager.OnAudioFocusChangeListener _audioFocusChangeListener = null;
    protected AudioManager.AudioPlaybackCallback _audioPlayListener = null;
    protected boolean play_active_in_voip_ = false;
    protected boolean _isCalling = false;
    protected boolean _once_call_come_in = false;
    protected boolean has_inited_ = false;
    protected IEventNotify event_notify_ = null;
    private Object event_lock_ = new Object();
    private Object duck_lock_ = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/AudioEventMonitor$AudioRoutChange.class */
    public class AudioRoutChange extends AudioDeviceCallback implements AudioRouting.OnRoutingChangedListener {
        int invoke_times = 0;
        private Method _getAddress = null;

        public AudioRoutChange() {
        }

        private String getDirection(AudioDeviceInfo audioDeviceInfo) {
            return audioDeviceInfo.isSource() ? "input" : audioDeviceInfo.isSink() ? MediaStore.EXTRA_OUTPUT : "";
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            try {
                if (this._getAddress == null) {
                    this._getAddress = AudioDeviceInfo.class.getDeclaredMethod("getAddress", new Class[0]);
                }
                if (this.invoke_times > 0) {
                    AudioEventMonitor.this.audio_route_change_valid_ = true;
                }
                int length = audioDeviceInfoArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        this.invoke_times++;
                        return;
                    }
                    AudioDeviceInfo audioDeviceInfo = audioDeviceInfoArr[i2];
                    Log.i("device", "add device:" + audioDeviceInfo.getId() + ", " + ((Object) audioDeviceInfo.getProductName()) + "|" + AudioDeviceHelper.getDeviceTypeStr(audioDeviceInfo.getType()) + "|" + getDirection(audioDeviceInfo) + "|" + ((String) this._getAddress.invoke(audioDeviceInfo, new Object[0])));
                    if (audioDeviceInfo.isSink() && this.invoke_times > 0) {
                        int routeType = AudioDeviceHelper.getRouteType(audioDeviceInfo.getType());
                        if (-1 != routeType) {
                            int i3 = routeType;
                            if (6 == routeType) {
                                if (AudioDeviceHelper.scoConnect(AudioEventMonitor.this._context)) {
                                    i3 = 2;
                                } else {
                                    i3 = routeType;
                                    if (3 == AudioEventMonitor.this._mode) {
                                        Log.i("device", "onAudioDevicesAdded ignore A2DP in VOIP");
                                    }
                                }
                            }
                            AudioEventMonitor.this.ChangeAudioRoute(i3);
                        }
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                Log.w("device", "onAudioDevicesAdded " + e.toString());
            }
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            try {
                AudioEventMonitor.this.audio_route_change_valid_ = true;
                int length = audioDeviceInfoArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return;
                    }
                    AudioDeviceInfo audioDeviceInfo = audioDeviceInfoArr[i2];
                    Log.i("device", "remove device:" + audioDeviceInfo.getId() + ", " + ((Object) audioDeviceInfo.getProductName()) + "|" + AudioDeviceHelper.getDeviceTypeStr(audioDeviceInfo.getType()) + "|" + getDirection(audioDeviceInfo));
                    if (audioDeviceInfo.isSink() && -1 != AudioDeviceHelper.getRouteType(audioDeviceInfo.getType())) {
                        AudioEventMonitor.this.RemoveAudioRoute();
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                Log.w("device", "onAudioDevicesRemoved " + e.toString());
            }
        }

        @Override // android.media.AudioRouting.OnRoutingChangedListener
        public void onRoutingChanged(AudioRouting audioRouting) {
            AudioDeviceInfo routedDevice;
            if (audioRouting == null || (routedDevice = audioRouting.getRoutedDevice()) == null) {
                return;
            }
            Log.i("device", audioRouting + " routing changed device:" + routedDevice.getId() + ", type:" + routedDevice.getType() + "(" + AudioDeviceHelper.getDeviceTypeStr(routedDevice.getType()) + ")");
            if (routedDevice.isSource()) {
                AudioEventMonitor.this.cap_original_route_ = routedDevice.getType();
                if (2 != AudioEventMonitor.this.audio_route_ || 7 == routedDevice.getType() || AudioEventMonitor.this.wait_check_sco_) {
                    return;
                }
                synchronized (AudioEventMonitor.this.event_lock_) {
                    if (AudioEventMonitor.this.event_notify_ != null) {
                        AudioEventMonitor.this.event_notify_.OnRoutingChange();
                    }
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/AudioEventMonitor$IEventNotify.class */
    public interface IEventNotify {
        void OnAudioFocusChange(int i);

        void OnAudioRouteChanged(int i);

        void OnInterruptionBegin();

        void OnInterruptionEnd();

        void OnRoutingChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DuckActivePlayWhenVoip() {
        int streamVolume = this._audioManager.getStreamVolume(0);
        int streamVolume2 = this._audioManager.getStreamVolume(3);
        float streamMaxVolume = this._audioManager.getStreamMaxVolume(0);
        int i = (int) ((this.duck_value_in_percent_ * streamMaxVolume) / 100.0d);
        int i2 = i;
        if (i == 0) {
            i2 = 1;
        }
        Log.i("device", "Duck other app play starting(api>=29), voip curr:" + streamVolume + " set:" + i2 + " max:" + streamMaxVolume);
        this._audioManager.setStreamVolume(0, i2, 0);
        this._audioManager.setStreamVolume(3, 0, 0);
        this._audioManager.setStreamVolume(3, streamVolume2, 0);
        this._audioManager.setStreamVolume(0, streamVolume, 0);
    }

    private void InitAudioFocusChangeListener() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.zego.ve.AudioEventMonitor.7
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i) {
                synchronized (AudioEventMonitor.this.event_lock_) {
                    if (AudioEventMonitor.this.event_notify_ != null) {
                        AudioEventMonitor.this.event_notify_.OnAudioFocusChange(i);
                    }
                }
            }
        };
        this._audioFocusChangeListener = onAudioFocusChangeListener;
        try {
            int requestAudioFocus = this._audioManager.requestAudioFocus(onAudioFocusChangeListener, 0, 1);
            String str = requestAudioFocus != 0 ? requestAudioFocus != 1 ? requestAudioFocus != 2 ? "UNKNOWN" : "DELAYED" : "GRANTED" : "FAILED";
            Log.i("device", "trace request audio focus status: " + requestAudioFocus + "(" + str + ")");
        } catch (Throwable th) {
            Log.e("device", "trace request audio focus failed, " + th.getMessage());
            this._audioManager.abandonAudioFocus(this._audioFocusChangeListener);
            this._audioFocusChangeListener = null;
        }
    }

    private void InitAudioPlaybackListener() {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        AudioManager.AudioPlaybackCallback audioPlaybackCallback = new AudioManager.AudioPlaybackCallback() { // from class: com.zego.ve.AudioEventMonitor.6
            @Override // android.media.AudioManager.AudioPlaybackCallback
            public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> list) {
                if (3 == AudioEventMonitor.this._mode && AudioEventMonitor.this.duck_other_when_voip_) {
                    boolean mediaActiveStatusInVOIP = AudioEventMonitor.this.getMediaActiveStatusInVOIP();
                    synchronized (AudioEventMonitor.this.duck_lock_) {
                        if (mediaActiveStatusInVOIP != AudioEventMonitor.this.play_active_in_voip_) {
                            AudioEventMonitor.this.play_active_in_voip_ = mediaActiveStatusInVOIP;
                            if (mediaActiveStatusInVOIP) {
                                AudioEventMonitor.this.DuckActivePlayWhenVoip();
                            }
                        }
                    }
                }
            }
        };
        this._audioPlayListener = audioPlaybackCallback;
        this._audioManager.registerAudioPlaybackCallback(audioPlaybackCallback, null);
    }

    private void InitPhoneStateListener() {
        this._handler.post(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.4
            @Override // java.lang.Runnable
            public void run() {
                AudioEventMonitor.this._isCalling = false;
                AudioEventMonitor.this._phoneStateListener = new PhoneStateListener() { // from class: com.zego.ve.AudioEventMonitor.4.1
                    @Override // android.telephony.PhoneStateListener
                    public void onCallStateChanged(int i, String str) {
                        super.onCallStateChanged(i, str);
                        synchronized (AudioEventMonitor.this.event_lock_) {
                            if (AudioEventMonitor.this.event_notify_ != null) {
                                if (i != 0) {
                                    if (i == 1) {
                                        AudioEventMonitor.this._isCalling = true;
                                        AudioEventMonitor.this.event_notify_.OnInterruptionBegin();
                                    } else if (i == 2) {
                                        AudioEventMonitor.this._isCalling = true;
                                        AudioEventMonitor.this.event_notify_.OnInterruptionBegin();
                                    }
                                } else if (AudioEventMonitor.this._isCalling) {
                                    AudioEventMonitor.this._once_call_come_in = true;
                                    AudioEventMonitor.this._isCalling = false;
                                    AudioEventMonitor.this.event_notify_.OnInterruptionEnd();
                                }
                            }
                        }
                    }
                };
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) AudioEventMonitor.this._context.getSystemService("phone");
                    int callState = telephonyManager.getCallState();
                    telephonyManager.listen(AudioEventMonitor.this._phoneStateListener, 32);
                    Log.i("device", "trace init call state: " + callState);
                } catch (Throwable th) {
                    Log.e("device", "InitPhoneStateListener failed, " + th);
                    AudioEventMonitor.this._phoneStateListener = null;
                }
            }
        });
    }

    private int RegisterAudioRouteListen() {
        this.on_receiver_first_arrive_ = true;
        this.audio_route_change_valid_ = false;
        if (Build.VERSION.SDK_INT >= 24) {
            AudioRoutChange audioRoutChange = new AudioRoutChange();
            this._audioRouteChange = audioRoutChange;
            this._audioManager.registerAudioDeviceCallback(audioRoutChange, null);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED);
        if (Build.VERSION.SDK_INT >= 21) {
            intentFilter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
            intentFilter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        }
        this._context.registerReceiver(this, intentFilter);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RemoveAudioRoute() {
        ChangeAudioRoute(AudioDeviceHelper.getCurrentRoute(this._context, this._mode));
    }

    private void SetModeWithDucking() {
        float f;
        if (3 != this._mode) {
            if (this.volume_before_duck_ > 0) {
                if (Build.VERSION.SDK_INT < 29) {
                    this._audioManager.setStreamVolume(3, this.volume_before_duck_, 0);
                } else {
                    this._audioManager.setStreamVolume(3, this._audioManager.getStreamVolume(3), 0);
                }
            }
            this.volume_before_duck_ = -1;
            this._audioManager.setMode(this._mode);
            return;
        }
        int streamVolume = this._audioManager.getStreamVolume(3);
        if (this.volume_before_duck_ < 0) {
            this.volume_before_duck_ = streamVolume;
        }
        if (Build.VERSION.SDK_INT < 29) {
            int i = (int) ((this.duck_value_in_percent_ * f) / 100.0d);
            Log.i("device", "Duck other app(api < 29), media curr:" + streamVolume + " set:" + i + " max:" + this._audioManager.getStreamMaxVolume(3));
            if (i < streamVolume) {
                this._audioManager.setStreamVolume(3, i, 0);
            }
            this._audioManager.setMode(this._mode);
            return;
        }
        int streamVolume2 = this._audioManager.getStreamVolume(0);
        float streamMaxVolume = this._audioManager.getStreamMaxVolume(0);
        int i2 = (int) ((this.duck_value_in_percent_ * streamMaxVolume) / 100.0d);
        int i3 = i2;
        if (i2 == 0) {
            i3 = 1;
        }
        Log.i("device", "Duck other app(api>= 29), voip curr:" + streamVolume2 + " set:" + i3 + " max:" + streamMaxVolume);
        if (i3 < streamVolume2) {
            this._audioManager.setStreamVolume(0, i3, 0);
        }
        this._audioManager.setMode(this._mode);
        if (i3 < streamVolume2) {
            this._audioManager.setStreamVolume(0, streamVolume2, 0);
        }
        synchronized (this.duck_lock_) {
            this.play_active_in_voip_ = getMediaActiveStatusInVOIP();
        }
    }

    private void UninitAudioFocusChangeListener() {
        try {
            if (this._audioFocusChangeListener != null) {
                this._audioManager.abandonAudioFocus(this._audioFocusChangeListener);
                this._audioFocusChangeListener = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void UninitAudioPlaybackListener() {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        this._audioManager.unregisterAudioPlaybackCallback(this._audioPlayListener);
        this._audioPlayListener = null;
    }

    private void UninitPhoneStateListener() {
        this._handler.post(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AudioEventMonitor.this._phoneStateListener != null) {
                        Log.i("device", "trace interruption stop call state listen");
                        ((TelephonyManager) AudioEventMonitor.this._context.getSystemService("phone")).listen(AudioEventMonitor.this._phoneStateListener, 0);
                        AudioEventMonitor.this._phoneStateListener = null;
                    }
                } catch (Throwable th) {
                    Log.e("device", "UninitPhoneStateListener failed, " + th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean getMediaActiveStatusInVOIP() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto La
            r0 = 0
            return r0
        La:
            r0 = r3
            android.media.AudioManager r0 = r0._audioManager
            java.util.List r0 = r0.getActivePlaybackConfigurations()
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L17:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L3d
            r0 = r5
            java.lang.Object r0 = r0.next()
            android.media.AudioPlaybackConfiguration r0 = (android.media.AudioPlaybackConfiguration) r0
            android.media.AudioAttributes r0 = r0.getAudioAttributes()
            int r0 = r0.getUsage()
            r4 = r0
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L3b
            r0 = r4
            r1 = 14
            if (r0 != r1) goto L17
        L3b:
            r0 = 1
            return r0
        L3d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.AudioEventMonitor.getMediaActiveStatusInVOIP():boolean");
    }

    public void ChangeAudioRoute(int i) {
        if (i != this.audio_route_) {
            if (2 == i) {
                this.wait_check_sco_ = true;
            }
            this.audio_route_ = i;
            synchronized (this.event_lock_) {
                if (this.event_notify_ != null) {
                    this.event_notify_.OnAudioRouteChanged(i);
                }
            }
        }
    }

    public void CheckAudioRoute(int i, boolean z) {
        if (6 != i && 2 != i) {
            if (this._audioManager.isBluetoothScoOn()) {
                SetBluetoothScoOn(false);
            }
            if (z) {
                boolean z2 = i == 0;
                if (z2 != this._audioManager.isSpeakerphoneOn()) {
                    this._audioManager.setSpeakerphoneOn(z2);
                    return;
                }
                return;
            }
            return;
        }
        boolean z3 = 2 == i && this._mode == 3;
        if (this._audioManager.isSpeakerphoneOn()) {
            this._audioManager.setSpeakerphoneOn(false);
        }
        if (!this._once_call_come_in) {
            SetBluetoothScoOn(z3);
            return;
        }
        this._once_call_come_in = false;
        SetBluetoothScoOn(false);
        if (z3) {
            SetBluetoothScoOn(true);
        }
    }

    public boolean CheckBluetoothSCO() {
        this.wait_check_sco_ = false;
        return this.audio_route_ != 2 || this.cap_original_route_ == 7;
    }

    public int CheckPhoneState() {
        this._handler.postDelayed(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (((TelephonyManager) AudioEventMonitor.this._context.getSystemService("phone")).getCallState() == 0 && AudioEventMonitor.this._isCalling) {
                        Log.w("device", "interruption check call state idle, resume it");
                        AudioEventMonitor.this._once_call_come_in = true;
                        AudioEventMonitor.this._isCalling = false;
                        synchronized (AudioEventMonitor.this.event_lock_) {
                            if (AudioEventMonitor.this.event_notify_ != null) {
                                AudioEventMonitor.this.event_notify_.OnInterruptionEnd();
                            }
                        }
                    }
                } catch (Throwable th) {
                    Log.e("device", "CheckPhoneState failed, " + th);
                }
            }
        }, 500L);
        return 0;
    }

    public void DuckUnpluginHeadsetWhenVoip() {
        float f;
        if (3 != this._mode) {
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            this._audioManager.setMode(0);
            int streamVolume = this._audioManager.getStreamVolume(3);
            int i = (int) ((this.duck_value_in_percent_ * f) / 100.0d);
            Log.i("device", "Duck reset at headset unplugin(api<29), music curr:" + streamVolume + " set:" + i + " max:" + this._audioManager.getStreamMaxVolume(3));
            if (i < streamVolume) {
                this._audioManager.setStreamVolume(3, i, 0);
            }
            this._audioManager.setMode(3);
            return;
        }
        int streamVolume2 = this._audioManager.getStreamVolume(0);
        float streamMaxVolume = this._audioManager.getStreamMaxVolume(0);
        int i2 = (int) ((this.duck_value_in_percent_ * streamMaxVolume) / 100.0d);
        int i3 = i2;
        if (i2 == 0) {
            i3 = 1;
        }
        Log.i("device", "Duck reset at headset unplugin(api >= 29), voip curr:" + streamVolume2 + " set:" + i3 + " max:" + streamMaxVolume);
        this._audioManager.setStreamVolume(0, i3, 0);
        this._audioManager.setStreamVolume(0, streamVolume2, 0);
    }

    public AudioManager GetAudioManager() {
        return this._audioManager;
    }

    public int GetAudioRoute() {
        return this.audio_route_;
    }

    public int GetCaptrueRoute() {
        return this.cap_original_route_;
    }

    public int GetMode() {
        return this._mode;
    }

    public AudioRoutChange GetRouteChangeHandle() {
        return this._audioRouteChange;
    }

    public void Init(Context context, boolean z) {
        synchronized (this.event_lock_) {
            if (!this.has_inited_) {
                this._context = context;
                this._audioManager = (AudioManager) context.getSystemService("audio");
                this.has_inited_ = true;
                RegisterAudioRouteListen();
                InitPhoneStateListener();
                if (z) {
                    InitAudioFocusChangeListener();
                }
                InitAudioPlaybackListener();
            }
        }
    }

    public boolean IsInited() {
        return this.has_inited_;
    }

    public int SetBluetoothScoOn(boolean z) {
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            return 0;
        }
        try {
            if (z) {
                audioManager.startBluetoothSco();
                this._audioManager.setBluetoothScoOn(z);
                return 0;
            }
            audioManager.setBluetoothScoOn(z);
            this._audioManager.stopBluetoothSco();
            return 0;
        } catch (Exception e) {
            Log.e("device", "setBluetoothScoOn failed, " + e.getMessage());
            return -1;
        }
    }

    public void SetEeventHandler(IEventNotify iEventNotify) {
        synchronized (this.event_lock_) {
            this.event_notify_ = iEventNotify;
        }
    }

    public int SetMode(int i) {
        this._mode = i;
        AudioManager audioManager = this._audioManager;
        if (audioManager != null) {
            if (this.duck_other_when_voip_) {
                SetModeWithDucking();
                return 0;
            }
            audioManager.setMode(i);
            return 0;
        }
        return 0;
    }

    public void SetRoutInfo(int i) {
        if (2 == i) {
            this.wait_check_sco_ = true;
        }
        synchronized (this.event_lock_) {
            this.audio_route_ = i;
        }
    }

    public void SetWaitSocFlag() {
        if (2 == this.audio_route_) {
            this.wait_check_sco_ = true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (this.audio_route_change_valid_ || this.on_receiver_first_arrive_) {
            this.on_receiver_first_arrive_ = false;
            return;
        }
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        StringBuilder sb = new StringBuilder();
        sb.append("action: ");
        sb.append(action);
        if (extras == null || extras.size() <= 0) {
            str = "";
        } else {
            str = ", " + extras.toString();
        }
        sb.append(str);
        Log.i("device", "onReceive " + sb.toString());
        if ("android.intent.action.HEADSET_PLUG".equals(action)) {
            if (intent.hasExtra("state")) {
                if (intent.getIntExtra("state", 0) == 1) {
                    ChangeAudioRoute(1);
                } else {
                    RemoveAudioRoute();
                }
            }
        } else if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
            int intExtra = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, Integer.MIN_VALUE);
            if (intExtra == 10) {
                this._bluetoothOpSeq++;
                RemoveAudioRoute();
            } else if (intExtra == 12) {
                final int i = this._bluetoothOpSeq + 1;
                this._bluetoothOpSeq = i;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BluetoothAdapter defaultAdapter;
                        if (AudioEventMonitor.this._bluetoothOpSeq == i && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null && 2 == defaultAdapter.getProfileConnectionState(2)) {
                            AudioEventMonitor.this.ChangeAudioRoute(6);
                        }
                    }
                }, c.j);
            }
        } else if (!BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED.equals(action)) {
            if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
                if (AudioDeviceHelper.HasUsbAudioDevice(intent)) {
                    ChangeAudioRoute(4);
                }
            } else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
                RemoveAudioRoute();
            }
        } else {
            int intExtra2 = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, Integer.MIN_VALUE);
            if (intExtra2 == 2) {
                final int i2 = this._bluetoothOpSeq + 1;
                this._bluetoothOpSeq = i2;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AudioEventMonitor.this._bluetoothOpSeq == i2) {
                            AudioEventMonitor.this.ChangeAudioRoute(2);
                        }
                    }
                }, c.j);
            } else if (intExtra2 == 0) {
                this._bluetoothOpSeq++;
                RemoveAudioRoute();
            }
        }
    }
}
