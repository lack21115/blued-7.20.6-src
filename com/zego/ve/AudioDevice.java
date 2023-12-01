package com.zego.ve;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import android.os.Process;
import com.sina.weibo.sdk.constant.WBConstants;
import com.zego.ve.AudioEventMonitor;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/AudioDevice.class */
public class AudioDevice implements AudioEventMonitor.IEventNotify {
    private static final int ApiAAudio = 4;
    private static final int ApiAudioRecord = 1;
    private static final int ApiAudioRecordLatency = 2;
    private static final int ApiAudioTrack = 1;
    private static final int ApiAudioTrackLatency = 2;
    private static final int ApiOpensles = 3;
    private static final int CAP_SR_16000 = 2;
    private static final int CAP_SR_32000 = 1;
    private static final int CAP_SR_48000 = 0;
    private static final int CAP_SR_8000 = 3;
    private static final String TAG = "device";
    public static AudioEventMonitor event_monitor_stc_ = new AudioEventMonitor();
    protected int _audio_source;
    protected ByteBuffer _capBuf;
    protected ByteBuffer _rndBuf;
    protected byte[] _rndBufArray;
    protected int _rndSampleRate;
    protected int _stream_type;
    protected Context _context = null;
    protected AudioTrack _rndDev = null;
    protected AudioTrack _devRoute = null;
    protected AudioRecord _capDev = null;
    protected AudioManager _audioManager = null;
    protected int _NativeOutputSampleRate = 44100;
    protected final int _frameSizeMs = 20;
    protected int _capSampleRate = 32000;
    protected int[] _capSampleRateTable = {48000, 32000, 16000, 8000};
    protected int _framesPerBuffer = 256;
    protected int _capProfile = 1;
    protected volatile long _pthis = 0;
    protected KaraokeHelper _Karaoke = null;
    protected AudioEventMonitor.AudioRoutChange _audioRouteChange = null;

    public AudioDevice() {
        this._rndBuf = null;
        this._capBuf = null;
        this._rndBufArray = null;
        this._stream_type = 3;
        this._audio_source = 1;
        this._rndBuf = ByteBuffer.allocateDirect(3840);
        this._rndBufArray = new byte[3840];
        this._capBuf = ByteBuffer.allocateDirect(WBConstants.SDK_NEW_PAY_VERSION);
        if (Build.VERSION.SDK_INT >= 11) {
            this._audio_source = 7;
            this._stream_type = 0;
            return;
        }
        this._audio_source = 0;
        this._stream_type = 0;
    }

    static void LogDeviceInfo() {
        Log.i("device", "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
        StringBuilder sb = new StringBuilder();
        sb.append("Android AudioEffect AEC: ");
        sb.append(AcousticEchoCanceler.isAvailable());
        sb.append(", AGC: ");
        sb.append(AutomaticGainControl.isAvailable());
        sb.append(", NS: ");
        sb.append(NoiseSuppressor.isAvailable());
        Log.i("device", sb.toString());
    }

    private static native void OnAudioDeviceInited(long j, int i, boolean z);

    private static native void OnAudioFocusChange(long j, int i);

    private static native void OnAudioRouteChanged(long j, int i);

    private static native void OnInterruptionBegin(long j);

    private static native void OnInterruptionEnd(long j);

    protected int AlertRouteForBluetooth(int i) {
        int i2;
        if (Build.VERSION.SDK_INT < 23) {
            Log.i("device", "set route to SPEAKER by route changing(api < 23).");
            event_monitor_stc_.ChangeAudioRoute(0);
            return 0;
        }
        AudioDeviceInfo[] devices = ((AudioManager) this._context.getSystemService("audio")).getDevices(2);
        int length = devices.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                i2 = 0;
                break;
            }
            AudioDeviceInfo audioDeviceInfo = devices[i4];
            if (8 == audioDeviceInfo.getType()) {
                int id = audioDeviceInfo.getId();
                AudioTrack audioTrack = this._rndDev;
                i2 = id;
                if (audioTrack != null) {
                    audioTrack.setPreferredDevice(audioDeviceInfo);
                    i2 = id;
                }
            } else {
                i3 = i4 + 1;
            }
        }
        if (4 == i) {
            Log.i("device", "Ignore route changing for AAudio.");
        } else if (i2 > 0) {
            Log.i("device", "set route to A2DP by route changing.");
            event_monitor_stc_.ChangeAudioRoute(6);
        } else {
            Log.i("device", "set route to SPEAKER by route changing.");
            event_monitor_stc_.ChangeAudioRoute(0);
        }
        return i2;
    }

    public int CheckAudioRoute(int i, boolean z) {
        event_monitor_stc_.CheckAudioRoute(i, z);
        return 0;
    }

    public int CheckBluetoothSCO(int i) {
        if (event_monitor_stc_.CheckBluetoothSCO()) {
            return 0;
        }
        return AlertRouteForBluetooth(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int CheckPermission() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public int CheckPhoneState() {
        return event_monitor_stc_.CheckPhoneState();
    }

    public int DoCap(int i) {
        try {
            return this._capDev.read(this._capBuf, i);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int DoRnd(int i) {
        try {
            this._rndBuf.rewind();
            int i2 = 0;
            this._rndBuf.get(this._rndBufArray, 0, this._rndBuf.capacity());
            if (this._rndDev != null) {
                i2 = this._rndDev.write(this._rndBufArray, 0, i);
            }
            return i2;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int DuckUnpluginHeadsetWhenVoip() {
        event_monitor_stc_.DuckUnpluginHeadsetWhenVoip();
        return 0;
    }

    public int EnableHWKaraoke(int i) {
        return this._Karaoke.EnableHWKaraoke(i);
    }

    public int EnableVivoKaraoke(int i) {
        return this._Karaoke.EnableVivoKaraoke(i);
    }

    public int EnableXiaomiKaraoke(int i) {
        return this._Karaoke.EnableXiaomiKaraoke(i);
    }

    public int GetApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public int GetBluetoothInput() {
        return AudioDeviceHelper.getBluetoothInput(this._context);
    }

    public int GetBluetoothOutput() {
        return AudioDeviceHelper.getBluetoothOutput(this._context, event_monitor_stc_.GetMode());
    }

    public int GetDeviceHardware() {
        return this._Karaoke.GetDeviceHardware();
    }

    public int GetDeviceManufacturer() {
        return this._Karaoke.GetDeviceManufacturer();
    }

    public int GetOutputFramePerBuffer() {
        return this._framesPerBuffer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
        if (6 == com.zego.ve.AudioDevice.event_monitor_stc_.audio_route_) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int GetPlayoutSampleRate() {
        /*
            r3 = this;
            r0 = r3
            int r0 = r0._NativeOutputSampleRate
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = 3
            com.zego.ve.AudioEventMonitor r1 = com.zego.ve.AudioDevice.event_monitor_stc_
            int r1 = r1._mode
            if (r0 != r1) goto L2c
            r0 = 2
            com.zego.ve.AudioEventMonitor r1 = com.zego.ve.AudioDevice.event_monitor_stc_
            int r1 = r1.audio_route_
            if (r0 == r1) goto L28
            r0 = r5
            r4 = r0
            r0 = 6
            com.zego.ve.AudioEventMonitor r1 = com.zego.ve.AudioDevice.event_monitor_stc_
            int r1 = r1.audio_route_
            if (r0 != r1) goto L2c
        L28:
            r0 = 16000(0x3e80, float:2.2421E-41)
            r4 = r0
        L2c:
            r0 = r3
            r1 = r4
            r0._rndSampleRate = r1
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.AudioDevice.GetPlayoutSampleRate():int");
    }

    public int GetRecordingSampleRate() {
        return this._capSampleRate;
    }

    public int GetStreamVolume() {
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            return -2;
        }
        return (int) (((audioManager.getStreamVolume(this._stream_type) / this._audioManager.getStreamMaxVolume(this._stream_type)) + 0.005f) * 100.0f);
    }

    public int Init(long j, boolean z, boolean z2) {
        if (this._context == null) {
            return -1;
        }
        this._pthis = j;
        int currentRoute = AudioDeviceHelper.getCurrentRoute(this._context, z2 ? 3 : 0);
        event_monitor_stc_.SetRoutInfo(currentRoute);
        OnAudioDeviceInited(this._pthis, currentRoute, false);
        event_monitor_stc_.SetEeventHandler(this);
        event_monitor_stc_.Init(this._context, z);
        if (event_monitor_stc_.IsInited()) {
            this._audioManager = event_monitor_stc_.GetAudioManager();
            this._audioRouteChange = event_monitor_stc_.GetRouteChangeHandle();
            if (Build.VERSION.SDK_INT >= 17) {
                String property = this._audioManager.getProperty(AudioManager.PROPERTY_OUTPUT_SAMPLE_RATE);
                if (property != null) {
                    this._NativeOutputSampleRate = Integer.parseInt(property);
                    if ("HUAWEI".equals(Build.MANUFACTURER) && IsHarmonyOS()) {
                        this._NativeOutputSampleRate = 44100;
                    }
                }
                String property2 = this._audioManager.getProperty(AudioManager.PROPERTY_OUTPUT_FRAMES_PER_BUFFER);
                if (property2 != null) {
                    this._framesPerBuffer = Integer.parseInt(property2);
                }
            }
            this._capSampleRate = 32000;
            this._rndSampleRate = this._NativeOutputSampleRate;
            if (z2 && 2 == currentRoute) {
                this._rndSampleRate = 16000;
            }
            this._Karaoke = new KaraokeHelper(this._context, this._audioManager);
            boolean hasSystemFeature = this._context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_AUDIO_LOW_LATENCY);
            boolean hasSystemFeature2 = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.pro");
            LogDeviceInfo();
            Log.i("device", "hasLowLatencyFeature:" + hasSystemFeature + ", hasProFeature:" + hasSystemFeature2 + ", OUTPUT_SAMPLE_RATE:" + this._NativeOutputSampleRate + ", OUTPUT_FRAMES_PER_BUFFER:" + this._framesPerBuffer);
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0155 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int InitCapDev(int r10, int r11) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.AudioDevice.InitCapDev(int, int):int");
    }

    public int InitRndDev(int i, int i2) {
        if (this._rndDev != null) {
            return 0;
        }
        int i3 = 16;
        if (i == 2) {
            i3 = 12;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(this._rndSampleRate, i3, 2) * 2;
        AudioTrack createAudioTrack = createAudioTrack(minBufferSize, i3, i2);
        this._rndDev = createAudioTrack;
        if (createAudioTrack == null) {
            this._rndDev = createAudioTrack(minBufferSize, i3, i2);
        }
        AudioTrack audioTrack = this._rndDev;
        if (audioTrack != null) {
            AudioEventMonitor.AudioRoutChange audioRoutChange = this._audioRouteChange;
            if (audioRoutChange != null) {
                audioTrack.addOnRoutingChangedListener(audioRoutChange, null);
                return 0;
            }
            return 0;
        }
        return -1;
    }

    public int InitVivoKtvEnv() {
        return this._Karaoke.InitVivoKtvEnv(this._rndSampleRate);
    }

    public int InitXiaomiKtvEnv() {
        return this._Karaoke.InitXiaomiKtvEnv();
    }

    public boolean IsHarmonyOS() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int LogRecordAudioEffect(int i) {
        return 0;
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnAudioFocusChange(int i) {
        if (this._pthis != 0) {
            OnAudioFocusChange(this._pthis, i);
        }
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnAudioRouteChanged(int i) {
        if (this._pthis != 0) {
            OnAudioRouteChanged(this._pthis, i);
        }
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnInterruptionBegin() {
        if (this._pthis != 0) {
            OnInterruptionBegin(this._pthis);
        }
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnInterruptionEnd() {
        if (this._pthis != 0) {
            OnInterruptionEnd(this._pthis);
        }
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnRoutingChange() {
        if (this._pthis != 0) {
            OnAudioRouteChanged(this._pthis, -100);
        }
    }

    public int SetAudioSource(int i) {
        this._audio_source = i;
        return 0;
    }

    public int SetCapProfile(int i) {
        this._capProfile = i;
        return 0;
    }

    public int SetCaptureDevId(int i) {
        int i2;
        int i3;
        int i4;
        if (Build.VERSION.SDK_INT < 23) {
            return 100;
        }
        AudioDeviceInfo[] devices = this._audioManager.getDevices(1);
        int i5 = 0;
        while (true) {
            i2 = i5;
            if (i2 >= devices.length) {
                i2 = -1;
                break;
            } else if (i == devices[i2].getId()) {
                break;
            } else {
                i5 = i2 + 1;
            }
        }
        if (-1 != i2) {
            int type = devices[i2].getType();
            if (type != 7) {
                this._capDev.stop();
                this._capDev.setPreferredDevice(devices[i2]);
                this._capDev.startRecording();
            } else if (this._audioManager.isBluetoothScoOn()) {
                this._capDev.stop();
                this._capDev.setPreferredDevice(devices[i2]);
                this._capDev.startRecording();
            } else {
                i3 = type;
                i4 = 2;
            }
            i3 = type;
            i4 = 0;
        } else {
            this._capDev.stop();
            this._capDev.setPreferredDevice(null);
            this._capDev.startRecording();
            i3 = 0;
            i4 = 1;
        }
        return (i3 << 16) | i4;
    }

    public int SetCustomMode(int i) {
        return this._Karaoke.SetCustomMode(i);
    }

    public int SetDuckConfig(boolean z, int i) {
        event_monitor_stc_.duck_value_in_percent_ = i;
        event_monitor_stc_.duck_other_when_voip_ = z;
        Log.i("device", "SetDuckConfig duck_others:" + z + " duck_percent:" + i);
        return 0;
    }

    public int SetHWKaraokeReverbMode(int i) {
        return this._Karaoke.SetHWKaraokeReverbMode(i);
    }

    public int SetHWKaraokeVolume(int i) {
        return this._Karaoke.SetHWKaraokeVolume(i);
    }

    public int SetMode(int i) {
        return event_monitor_stc_.SetMode(i);
    }

    public int SetRenderDevId(int i) {
        int i2;
        int i3;
        int i4;
        if (Build.VERSION.SDK_INT < 23) {
            return 100;
        }
        AudioDeviceInfo[] devices = this._audioManager.getDevices(2);
        int i5 = 0;
        while (true) {
            i2 = i5;
            if (i2 >= devices.length) {
                i2 = -1;
                break;
            } else if (i == devices[i2].getId()) {
                break;
            } else {
                i5 = i2 + 1;
            }
        }
        if (-1 != i2) {
            int type = devices[i2].getType();
            if (type == 7) {
                i3 = 2;
                if (this._audioManager.isBluetoothScoOn()) {
                    this._rndDev.stop();
                    this._rndDev.setPreferredDevice(devices[i2]);
                    this._rndDev.play();
                    i4 = type;
                    i3 = 0;
                }
                i4 = type;
            } else {
                if (type != 8) {
                    this._rndDev.stop();
                    this._rndDev.setPreferredDevice(devices[i2]);
                    this._rndDev.play();
                } else if (this._audioManager.isBluetoothScoOn()) {
                    i3 = 3;
                    i4 = type;
                } else {
                    this._rndDev.stop();
                    this._rndDev.setPreferredDevice(devices[i2]);
                    this._rndDev.play();
                }
                i4 = type;
                i3 = 0;
            }
        } else {
            this._rndDev.stop();
            this._rndDev.setPreferredDevice(null);
            this._rndDev.play();
            i3 = 1;
            i4 = 0;
        }
        return (i4 << 16) | i3;
    }

    public int SetStreamType(int i) {
        this._stream_type = i;
        return 0;
    }

    public int SetThreadUrgentPriority() {
        try {
            Process.setThreadPriority(-19);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int SetVivoKaraokeVolume(int i) {
        return this._Karaoke.SetVivoKaraokeVolume(i);
    }

    public int SetXiaomiKaraokeVolume(int i) {
        return this._Karaoke.SetXiaomiKaraokeVolume(i);
    }

    public int StartCapDev() {
        AudioRecord audioRecord = this._capDev;
        if (audioRecord == null) {
            return -1;
        }
        try {
            audioRecord.startRecording();
            if (this._capDev.getRecordingState() != 3) {
                return -3;
            }
            LogRecordAudioEffect(this._capDev.getAudioSessionId());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        }
    }

    public int StartRndDev() {
        AudioTrack audioTrack = this._rndDev;
        if (audioTrack == null) {
            return -1;
        }
        try {
            audioTrack.play();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int StopCapDev() {
        try {
            this._capDev.stop();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int StopModule() {
        this._pthis = 0L;
        event_monitor_stc_.SetEeventHandler(null);
        try {
            event_monitor_stc_.SetMode(0);
            event_monitor_stc_.SetBluetoothScoOn(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this._audioRouteChange = null;
        this._Karaoke = null;
        this._audioManager = null;
        return 0;
    }

    public int StopRndDev() {
        try {
            this._rndDev.stop();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int SupportHWKaraokeLowlatency() {
        return this._Karaoke.SupportHWKaraokeLowlatency();
    }

    public int SupportVivoKaraokeLowlatency() {
        return this._Karaoke.SupportVivoKaraokeLowlatency();
    }

    public int SupportXiaomiKaraokeLowlatency() {
        return this._Karaoke.SupportXiaomiKaraokeLowlatency();
    }

    public int UninitCapDev() {
        AudioRecord audioRecord = this._capDev;
        if (audioRecord != null) {
            try {
                if (this._audioRouteChange != null) {
                    audioRecord.removeOnRoutingChangedListener(this._audioRouteChange);
                }
                this._capDev.release();
                this._capDev = null;
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public int UninitHWKtvEnv() {
        return this._Karaoke.UninitHWKtvEnv();
    }

    public int UninitRndDev() {
        AudioTrack audioTrack = this._rndDev;
        if (audioTrack != null) {
            try {
                if (this._audioRouteChange != null) {
                    audioTrack.removeOnRoutingChangedListener(this._audioRouteChange);
                }
                this._rndDev.release();
                this._rndDev = null;
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public int UninitVivoKtvEnv() {
        return this._Karaoke.UninitVivoKtvEnv();
    }

    public int UninitXiaomiKtvEnv() {
        return this._Karaoke.UninitXiaomiKtvEnv();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.media.AudioTrack createAudioTrack(int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.AudioDevice.createAudioTrack(int, int, int):android.media.AudioTrack");
    }

    public void setEQParams(int i) {
        this._Karaoke.setEQParams(i);
    }

    public void setReverbParams(int i) {
        this._Karaoke.setReverbParams(i);
    }
}
