package com.blued.android.module.media.audio.audio_manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import com.alipay.sdk.util.e;
import com.android.internal.util.cm.PowerMenuConstants;
import com.blued.android.module.media.audio.audio_manager.BLBluetoothManager;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLAudioManager.class */
public class BLAudioManager {
    private static boolean i = false;
    private static BLAudioManager v;
    private final Context a;
    private AudioManager b;
    private AudioFocusRequest c;
    private PowerManager d;
    private PowerManager.WakeLock e;
    private AudioManagerEvents f;
    private AudioManagerState g;
    private boolean k;
    private boolean l;
    private boolean m;
    private AudioDevice n;
    private AudioDevice o;
    private AudioDevice p;
    private BLProximitySensor q;
    private final BLBluetoothManager r;
    private BroadcastReceiver t;
    private AudioManager.OnAudioFocusChangeListener u;
    private AudioSwitchMode h = AudioSwitchMode.SPEAKERPHONE_MODE;
    private int j = -2;
    private Set<AudioDevice> s = new HashSet();
    private final Handler w = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.blued.android.module.media.audio.audio_manager.-$$Lambda$BLAudioManager$1UVZwexKHqiTpvN_66T23A_Xl-Y
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean a;
            a = BLAudioManager.this.a(message);
            return a;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.media.audio.audio_manager.BLAudioManager$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLAudioManager$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[AudioDevice.values().length];
            a = iArr;
            try {
                iArr[AudioDevice.SPEAKER_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[AudioDevice.EARPIECE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[AudioDevice.WIRED_HEADSET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[AudioDevice.BLUETOOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLAudioManager$AudioDevice.class */
    public enum AudioDevice {
        SPEAKER_PHONE,
        WIRED_HEADSET,
        EARPIECE,
        BLUETOOTH,
        NONE
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLAudioManager$AudioManagerEvents.class */
    public interface AudioManagerEvents {
        void onAudioDeviceChanged(AudioDevice audioDevice, Set<AudioDevice> set);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLAudioManager$AudioManagerState.class */
    public enum AudioManagerState {
        UNINITIALIZED,
        PREINITIALIZED,
        RUNNING
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLAudioManager$AudioSwitchMode.class */
    public enum AudioSwitchMode {
        SPEAKERPHONE_MODE,
        EARPIECE_MODE
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/audio/audio_manager/BLAudioManager$WiredHeadsetReceiver.class */
    class WiredHeadsetReceiver extends BroadcastReceiver {
        private WiredHeadsetReceiver() {
        }

        /* synthetic */ WiredHeadsetReceiver(BLAudioManager bLAudioManager, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            int intExtra = intent.getIntExtra("state", 0);
            int intExtra2 = intent.getIntExtra("microphone", 0);
            String stringExtra = intent.getStringExtra("name");
            StringBuilder sb = new StringBuilder();
            sb.append("WiredHeadsetReceiver.onReceive");
            sb.append(BLUtils.a());
            sb.append(": a=");
            sb.append(intent.getAction());
            sb.append(", s=");
            sb.append(intExtra == 0 ? "unplugged" : "plugged");
            sb.append(", m=");
            sb.append(intExtra2 == 1 ? "mic" : "no mic");
            sb.append(", n=");
            sb.append(stringExtra);
            sb.append(", sb=");
            sb.append(isInitialStickyBroadcast());
            Log.d("BLAudioManager", sb.toString());
            BLAudioManager bLAudioManager = BLAudioManager.this;
            if (intExtra == 1) {
                z = true;
            }
            bLAudioManager.m = z;
            BLAudioManager.this.e();
        }
    }

    private BLAudioManager(Context context) {
        Log.d("BLAudioManager", "ctor");
        ThreadUtils.a();
        this.a = context.getApplicationContext();
        this.b = (AudioManager) context.getSystemService("audio");
        this.r = BLBluetoothManager.a(context, this);
        this.t = new WiredHeadsetReceiver(this, null);
        this.g = AudioManagerState.UNINITIALIZED;
        j();
        this.q = BLProximitySensor.a(context, new Runnable() { // from class: com.blued.android.module.media.audio.audio_manager.-$$Lambda$BLAudioManager$mSN69PyYjqvVqK7Sg3P4jjksSpU
            @Override // java.lang.Runnable
            public final void run() {
                BLAudioManager.this.f();
            }
        });
        Log.d("BLAudioManager", "defaultAudioDevice: " + this.n);
        s();
        BLUtils.a("BLAudioManager");
        if (i) {
            this.d = (PowerManager) context.getSystemService(PowerMenuConstants.GLOBAL_ACTION_KEY_POWER);
        }
    }

    public static BLAudioManager a(Context context) {
        if (v == null) {
            synchronized (BLAudioManager.class) {
                try {
                    if (v == null) {
                        v = new BLAudioManager(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return v;
    }

    private void a(AudioDevice audioDevice) {
        if (audioDevice == this.o) {
            return;
        }
        Set<AudioDevice> set = this.s;
        if (set == null || set.isEmpty() || !this.s.contains(audioDevice)) {
            Log.e("BLAudioManager", "no audio device found! device = " + audioDevice);
            return;
        }
        Log.d("BLAudioManager", "setAudioDeviceInternal(device=" + audioDevice + ")");
        a(audioDevice == AudioDevice.EARPIECE ? 3 : 0);
        int i2 = AnonymousClass1.a[audioDevice.ordinal()];
        if (i2 == 1) {
            a(true);
        } else if (i2 == 2) {
            a(false);
        } else if (i2 == 3) {
            a(false);
        } else if (i2 != 4) {
            Log.e("BLAudioManager", "Invalid audio device selection");
        } else {
            a(false);
        }
        this.o = audioDevice;
        AudioManagerEvents audioManagerEvents = this.f;
        if (audioManagerEvents != null) {
            audioManagerEvents.onAudioDeviceChanged(audioDevice, this.s);
        }
    }

    private void a(boolean z) {
        if (this.b.isSpeakerphoneOn() == z) {
            return;
        }
        this.b.setSpeakerphoneOn(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            p();
            return false;
        } else if (i2 == 2) {
            m();
            return false;
        } else if (i2 != 3) {
            return false;
        } else {
            n();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(int i2) {
        String str = i2 != -3 ? i2 != -2 ? i2 != -1 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "AUDIOFOCUS_INVALID" : "AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE" : "AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK" : "AUDIOFOCUS_GAIN_TRANSIENT" : "AUDIOFOCUS_GAIN" : "AUDIOFOCUS_LOSS" : "AUDIOFOCUS_LOSS_TRANSIENT" : "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK";
        Log.d("BLAudioManager", "onAudioFocusChange: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.h == AudioSwitchMode.SPEAKERPHONE_MODE && i()) {
            o();
        }
    }

    private void g() {
        PowerManager powerManager = this.d;
        if (powerManager == null) {
            return;
        }
        if (this.e == null) {
            this.e = powerManager.newWakeLock(32, this.a.getPackageName() + ";manager_proximity_sensor");
        }
        if (this.e.isHeld()) {
            return;
        }
        this.e.acquire();
    }

    private void h() {
        PowerManager.WakeLock wakeLock = this.e;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        this.e.setReferenceCounted(false);
        this.e.release();
    }

    private boolean i() {
        return this.s.size() == 2 && this.s.contains(AudioDevice.EARPIECE) && this.s.contains(AudioDevice.SPEAKER_PHONE);
    }

    private void j() {
        this.n = this.h == AudioSwitchMode.EARPIECE_MODE ? AudioDevice.EARPIECE : AudioDevice.SPEAKER_PHONE;
    }

    private boolean k() {
        return Build.VERSION.SDK_INT >= 26;
    }

    private void l() {
        if (this.c != null) {
            return;
        }
        this.c = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setOnAudioFocusChangeListener(this.u).setAcceptsDelayedFocusGain(true).build();
    }

    private int m() {
        int requestAudioFocus;
        if (k()) {
            l();
            requestAudioFocus = this.b.requestAudioFocus(this.c);
        } else {
            requestAudioFocus = this.b.requestAudioFocus(this.u, 3, 2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("requestAudioFocus: SDK_INT ");
        sb.append(k() ? ">= 26, " : "< 26, ");
        sb.append("result = ");
        sb.append(requestAudioFocus);
        Log.d("BLAudioManager", sb.toString());
        return requestAudioFocus;
    }

    private int n() {
        int abandonAudioFocus;
        if (k()) {
            l();
            abandonAudioFocus = this.b.abandonAudioFocusRequest(this.c);
        } else {
            abandonAudioFocus = this.b.abandonAudioFocus(this.u);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("abandonAudioFocus: SDK_INT ");
        sb.append(k() ? ">= 26, " : "< 26, ");
        sb.append("result = ");
        sb.append(abandonAudioFocus);
        Log.d("BLAudioManager", sb.toString());
        return abandonAudioFocus;
    }

    private void o() {
        this.w.removeMessages(1);
        this.w.sendEmptyMessage(1);
    }

    private void p() {
        BLProximitySensor bLProximitySensor = this.q;
        if (bLProximitySensor == null) {
            return;
        }
        if (bLProximitySensor.c()) {
            r();
            if (i) {
                g();
                return;
            }
            return;
        }
        q();
        if (i) {
            h();
        }
    }

    private void q() {
        a(AudioDevice.SPEAKER_PHONE);
    }

    private void r() {
        a(AudioDevice.EARPIECE);
    }

    private void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.a.registerReceiver(broadcastReceiver, intentFilter);
    }

    private void s() {
        if (this.u != null) {
            return;
        }
        this.u = new AudioManager.OnAudioFocusChangeListener() { // from class: com.blued.android.module.media.audio.audio_manager.-$$Lambda$BLAudioManager$X5wShwudrSSyvs4eYJX2fb28tCA
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i2) {
                BLAudioManager.b(i2);
            }
        };
    }

    private boolean t() {
        return this.a.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    @Deprecated
    private boolean u() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.b.isWiredHeadsetOn();
        }
        AudioDeviceInfo[] devices = this.b.getDevices(3);
        int length = devices.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            int type = devices[i3].getType();
            if (type == 3) {
                Log.d("BLAudioManager", "hasWiredHeadset: found wired headset");
                return true;
            } else if (type == 11) {
                Log.d("BLAudioManager", "hasWiredHeadset: found USB audio device");
                return true;
            } else {
                i2 = i3 + 1;
            }
        }
    }

    private void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.a.unregisterReceiver(broadcastReceiver);
    }

    public void a() {
        Log.d("BLAudioManager", "start");
        ThreadUtils.a();
        if (this.g == AudioManagerState.RUNNING) {
            Log.e("BLAudioManager", "AudioManager is already active");
            return;
        }
        Log.d("BLAudioManager", "AudioManager starts...");
        this.g = AudioManagerState.RUNNING;
        j();
        this.j = this.b.getMode();
        this.k = this.b.isSpeakerphoneOn();
        this.l = this.b.isMicrophoneMute();
        this.m = u();
        int m = m();
        StringBuilder sb = new StringBuilder();
        sb.append("Audio focus request ");
        sb.append(m == 1 ? "granted" : e.a);
        Log.d("BLAudioManager", sb.toString());
        this.p = AudioDevice.NONE;
        this.o = AudioDevice.NONE;
        this.s.clear();
        this.r.b();
        this.q.a();
        e();
        registerReceiver(this.t, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        Log.d("BLAudioManager", "AudioManager started");
    }

    public void a(int i2) {
        this.b.setMode(i2);
    }

    public void a(AudioManagerEvents audioManagerEvents) {
        this.f = audioManagerEvents;
    }

    public void a(AudioSwitchMode audioSwitchMode) {
        Log.i("BLAudioManager", "setAudioSwitchMode: " + audioSwitchMode.name());
        this.h = audioSwitchMode;
        j();
    }

    public void b() {
        Log.d("BLAudioManager", "stop");
        ThreadUtils.a();
        this.w.removeCallbacksAndMessages(null);
        if (this.g != AudioManagerState.RUNNING) {
            Log.e("BLAudioManager", "Trying to stop AudioManager in incorrect state: " + this.g);
            return;
        }
        this.g = AudioManagerState.UNINITIALIZED;
        unregisterReceiver(this.t);
        this.r.c();
        a(this.k);
        a(this.j);
        n();
        Log.d("BLAudioManager", "Abandoned audio focus for VOICE_CALL streams");
        BLProximitySensor bLProximitySensor = this.q;
        if (bLProximitySensor != null) {
            bLProximitySensor.b();
        }
        Log.d("BLAudioManager", "AudioManager stopped");
    }

    public void c() {
        this.w.removeMessages(2);
        this.w.sendEmptyMessage(2);
    }

    public void d() {
        this.w.removeMessages(3);
        this.w.sendEmptyMessage(3);
    }

    public void e() {
        ThreadUtils.a();
        Log.d("BLAudioManager", "--- updateAudioDeviceState: wired headset=" + this.m + ", BT state=" + this.r.a());
        Log.d("BLAudioManager", "Device status: available=" + this.s + ", selected=" + this.o + ", user selected=" + this.p);
        if (this.r.a() == BLBluetoothManager.State.HEADSET_AVAILABLE || this.r.a() == BLBluetoothManager.State.HEADSET_UNAVAILABLE || this.r.a() == BLBluetoothManager.State.SCO_DISCONNECTING) {
            this.r.e();
        }
        HashSet hashSet = new HashSet();
        if (this.r.a() == BLBluetoothManager.State.SCO_CONNECTED || this.r.a() == BLBluetoothManager.State.SCO_CONNECTING || this.r.a() == BLBluetoothManager.State.HEADSET_AVAILABLE) {
            hashSet.add(AudioDevice.BLUETOOTH);
        }
        if (this.m) {
            hashSet.add(AudioDevice.WIRED_HEADSET);
        } else {
            hashSet.add(AudioDevice.SPEAKER_PHONE);
            if (t()) {
                hashSet.add(AudioDevice.EARPIECE);
            }
        }
        boolean equals = this.s.equals(hashSet);
        boolean z = true;
        this.s = hashSet;
        if (this.r.a() == BLBluetoothManager.State.HEADSET_UNAVAILABLE && this.p == AudioDevice.BLUETOOTH) {
            this.p = AudioDevice.NONE;
        }
        if (this.m && this.p == AudioDevice.SPEAKER_PHONE) {
            this.p = AudioDevice.WIRED_HEADSET;
        }
        if (!this.m && this.p == AudioDevice.WIRED_HEADSET) {
            this.p = AudioDevice.SPEAKER_PHONE;
        }
        boolean z2 = this.r.a() == BLBluetoothManager.State.HEADSET_AVAILABLE && (this.p == AudioDevice.NONE || this.p == AudioDevice.BLUETOOTH);
        if ((this.r.a() != BLBluetoothManager.State.SCO_CONNECTED && this.r.a() != BLBluetoothManager.State.SCO_CONNECTING) || this.p == AudioDevice.NONE || this.p == AudioDevice.BLUETOOTH) {
            z = false;
        }
        if (this.r.a() == BLBluetoothManager.State.HEADSET_AVAILABLE || this.r.a() == BLBluetoothManager.State.SCO_CONNECTING || this.r.a() == BLBluetoothManager.State.SCO_CONNECTED) {
            Log.d("BLAudioManager", "Need BT audio: start=" + z2 + ", stop=" + z + ", BT state=" + this.r.a());
        }
        AudioDevice audioDevice = (this.r.a() == BLBluetoothManager.State.SCO_CONNECTED || this.r.a() == BLBluetoothManager.State.HEADSET_AVAILABLE || this.r.a() == BLBluetoothManager.State.SCO_CONNECTING) ? AudioDevice.BLUETOOTH : this.m ? AudioDevice.WIRED_HEADSET : this.n;
        if (audioDevice != this.o || (!equals)) {
            a(audioDevice);
            Log.d("BLAudioManager", "New device status: available=" + this.s + ", selected=" + audioDevice);
        }
        Log.d("BLAudioManager", "--- updateAudioDeviceState done");
    }
}
