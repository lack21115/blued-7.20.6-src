package com.zego.ve;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import com.cdo.oaps.ad.p;
import com.igexin.assist.util.AssistUtils;
import com.tencent.tendinsv.utils.r;
import java.util.StringTokenizer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/KaraokeHelper.class */
public class KaraokeHelper {
    public static final int MODE_CUSTOM_3DDRAEMY = 6;
    public static final int MODE_CUSTOM_AIRY = 4;
    public static final int MODE_CUSTOM_ATTRACTIVE = 3;
    public static final int MODE_CUSTOM_DISTANT = 5;
    public static final int MODE_CUSTOM_GRAMOPHONE = 7;
    public static final int MODE_CUSTOM_KTV = 1;
    public static final int MODE_CUSTOM_NOEFFECT = 8;
    public static final int MODE_CUSTOM_RECSTUDIO = 0;
    public static final int MODE_CUSTOM_WARM = 2;
    private static final String TAG = "device";
    private static final String TAG_ECHO_ENABLE = "vivo_ktv_echo_enable";
    private static final String TAG_MEQ_BAND_1 = "vivo_ktv_miceq_band1";
    private static final String TAG_MEQ_BAND_2 = "vivo_ktv_miceq_band2";
    private static final String TAG_MEQ_BAND_3 = "vivo_ktv_miceq_band3";
    private static final String TAG_MEQ_BAND_4 = "vivo_ktv_miceq_band4";
    private static final String TAG_MEQ_BAND_5 = "vivo_ktv_miceq_band5";
    private static final String TAG_RB_DAMP = "vivo_ktv_rb_damp";
    private static final String TAG_RB_DRY = "vivo_ktv_rb_dry";
    private static final String TAG_RB_GAIN = "vivo_ktv_rb_gain";
    private static final String TAG_RB_ROOMSIZE = "vivo_ktv_rb_roomsize";
    private static final String TAG_RB_WET = "vivo_ktv_rb_wet";
    private static final String TAG_RB_WIDTH = "vivo_ktv_rb_width";
    protected AudioManager _audioManager;
    protected Context _context;
    protected int _deviceHardware;
    protected int _deviceManufacturer;
    private static final int[][] ReverbCustomParams = {new int[]{200, 1000, 500, 4500, 1000, 1500}, new int[]{5000, 4500, 1200, 4500, p.f, 1200}, new int[]{4500, 8000, 1000, 4000, p.f, 1500}, new int[]{2500, 3000, 1500, 4000, 5000, 1500}, new int[]{3500, 5500, 1500, 5000, 5500, 1500}, new int[]{4000, 3000, 1000, 2500, 5500, 1200}, new int[]{500, 5000, 800, 4500, 3000, 1200}, new int[]{20, 500, 60, 4500, 5000, 1500}, new int[]{0, 0, 0, 4000, 0, 1200}};
    private static final int[][] EQCustomGain = {new int[]{0, 0, 0, 2, 2}, new int[]{0, 0, 0, 0, 0}, new int[]{3, 4, 2, 0, -3}, new int[]{3, 2, 0, 0, 2}, new int[]{3, 2, 0, -1, -3}, new int[]{2, 2, 2, 0, 0}, new int[]{5, 2, -2, 1, 3}, new int[]{-2, 0, 1, 2, 1}, new int[]{0, 0, 0, 0, 0}};
    protected HwAudioKit _hwAudioKit = null;
    protected SilentPlayer _silentPlayer = null;
    protected boolean _initVivoKtv = false;
    protected boolean _initXiaomiKtv = false;
    protected int _volume = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/KaraokeHelper$SilentPlayer.class */
    public class SilentPlayer {
        private PlaybackThread mPlaybackThread;
        private int mSampleRate;
        private int mChannelConfig = 12;
        private int mAudioFormat = 2;
        private boolean mIsPlaying = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/KaraokeHelper$SilentPlayer$PlaybackThread.class */
        public class PlaybackThread extends Thread {
            private boolean isStop = false;

            PlaybackThread() {
            }

            public void closeThread() {
                synchronized (this) {
                    this.isStop = true;
                }
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int minBufferSize = AudioTrack.getMinBufferSize(SilentPlayer.this.mSampleRate, SilentPlayer.this.mChannelConfig, SilentPlayer.this.mAudioFormat);
                AudioTrack audioTrack = new AudioTrack(3, SilentPlayer.this.mSampleRate, SilentPlayer.this.mChannelConfig, SilentPlayer.this.mAudioFormat, minBufferSize, 1);
                if (audioTrack.getState() == 1) {
                    audioTrack.play();
                    byte[] bArr = new byte[minBufferSize];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= minBufferSize) {
                            break;
                        }
                        bArr[i2] = 0;
                        i = i2 + 1;
                    }
                    while (!this.isStop && !isInterrupted()) {
                        try {
                            audioTrack.write(bArr, 0, minBufferSize);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    audioTrack.stop();
                    audioTrack.flush();
                }
                audioTrack.release();
            }
        }

        public SilentPlayer(int i) {
            this.mSampleRate = i;
        }

        public boolean isPlaying() {
            return this.mIsPlaying;
        }

        public void play() {
            if (!this.mIsPlaying && this.mPlaybackThread == null) {
                this.mIsPlaying = true;
                PlaybackThread playbackThread = new PlaybackThread();
                this.mPlaybackThread = playbackThread;
                playbackThread.start();
            }
        }

        public void stop() {
            PlaybackThread playbackThread = this.mPlaybackThread;
            if (playbackThread != null) {
                this.mIsPlaying = false;
                playbackThread.closeThread();
                try {
                    this.mPlaybackThread.join(200L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mPlaybackThread = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KaraokeHelper(Context context, AudioManager audioManager) {
        this._deviceManufacturer = 0;
        this._deviceHardware = 0;
        this._context = null;
        this._audioManager = null;
        this._context = context;
        this._audioManager = audioManager;
        String str = Build.MANUFACTURER;
        if ("HUAWEI".equals(str)) {
            this._deviceManufacturer = 1;
        } else if (str.trim().contains(AssistUtils.BRAND_VIVO)) {
            this._deviceManufacturer = 2;
        } else if (str.trim().contains(r.d)) {
            this._deviceManufacturer = 3;
        } else if (str.trim().contains("Xiaomi")) {
            this._deviceManufacturer = 4;
        } else if (str.trim().contains("Google")) {
            this._deviceManufacturer = 5;
        }
        String str2 = Build.HARDWARE;
        if (str2.trim().contains("qcom")) {
            this._deviceHardware = 1;
        } else if (str2.trim().contains("mt")) {
            this._deviceHardware = 2;
        } else if (str2.trim().contains("kirin")) {
            this._deviceHardware = 3;
        } else if (str2.trim().contains("exynos")) {
            this._deviceHardware = 4;
        }
    }

    public int EnableHWKaraoke(int i) {
        HwAudioKit hwAudioKit = this._hwAudioKit;
        if (hwAudioKit != null) {
            if (!hwAudioKit.isFeatureKaraokeOn()) {
                this._hwAudioKit.destroy();
                this._hwAudioKit = null;
                HwAudioKit hwAudioKit2 = new HwAudioKit(this._context);
                this._hwAudioKit = hwAudioKit2;
                hwAudioKit2.initialize();
                this._hwAudioKit.createFeatureKaraoke();
            }
            HwAudioKit hwAudioKit3 = this._hwAudioKit;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            int enableKaraokeFeature = hwAudioKit3.enableKaraokeFeature(z);
            Log.i("device", "EnableHWKaraoke:" + i + " result:" + enableKaraokeFeature);
            return enableKaraokeFeature;
        }
        return -1;
    }

    public int EnableVivoKaraoke(int i) {
        if (this._initVivoKtv) {
            AudioManager audioManager = this._audioManager;
            StringBuilder sb = new StringBuilder();
            sb.append("vivo_ktv_play_source=");
            sb.append(i == 0 ? "0" : "1");
            audioManager.setParameters(sb.toString());
            return 0;
        }
        return -1;
    }

    public int EnableXiaomiKaraoke(int i) {
        if (this._initXiaomiKtv) {
            AudioManager audioManager = this._audioManager;
            audioManager.setParameters("audio_karaoke_enable=" + i);
            if (i == 1) {
                AudioManager audioManager2 = this._audioManager;
                audioManager2.setParameters("audio_karaoke_volume=" + this._volume);
                this._audioManager.setParameters("audio_karaoke_EQ=0");
                this._audioManager.setParameters("audio_karaoke_Reverb=0");
                return 0;
            }
            return 0;
        }
        return -1;
    }

    public int GetDeviceHardware() {
        return this._deviceHardware;
    }

    public int GetDeviceManufacturer() {
        return this._deviceManufacturer;
    }

    public int InitVivoKtvEnv(int i) {
        this._audioManager.setParameters("vivo_ktv_play_source=1");
        this._audioManager.setParameters("vivo_ktv_mode=1");
        this._audioManager.setParameters("vivo_ktv_rec_source=0");
        if (this._silentPlayer == null) {
            this._silentPlayer = new SilentPlayer(i);
        }
        SilentPlayer silentPlayer = this._silentPlayer;
        if (silentPlayer != null && !silentPlayer.isPlaying()) {
            this._silentPlayer.play();
        }
        this._initVivoKtv = true;
        return 0;
    }

    public int InitXiaomiKtvEnv() {
        this._audioManager.setParameters("audio_karaoke_ktvmode=enable");
        this._audioManager.setParameters("audio_karaoke_volume=8");
        this._audioManager.setParameters("audio_karaoke_EQ=0");
        this._audioManager.setParameters("audio_karaoke_Reverb=0");
        this._audioManager.setParameters("audio_karaoke_enable=1");
        this._initXiaomiKtv = true;
        this._volume = 8;
        return 0;
    }

    public int SetCustomMode(int i) {
        setReverbParams(i);
        setEQParams(i);
        return 0;
    }

    public int SetHWKaraokeReverbMode(int i) {
        HwAudioKit hwAudioKit = this._hwAudioKit;
        if (hwAudioKit != null) {
            hwAudioKit.setKaraokeReverbMode(i);
            return 0;
        }
        return 0;
    }

    public int SetHWKaraokeVolume(int i) {
        HwAudioKit hwAudioKit = this._hwAudioKit;
        if (hwAudioKit != null) {
            hwAudioKit.setKaraokeVolume(i);
            return 0;
        }
        return 0;
    }

    public int SetVivoKaraokeVolume(int i) {
        if (this._initVivoKtv) {
            int i2 = i / 6;
            int i3 = i2;
            if (i2 > 15) {
                i3 = 15;
            }
            this._audioManager.setParameters("vivo_ktv_volume_mic=" + i3);
            return 0;
        }
        return 0;
    }

    public int SetXiaomiKaraokeVolume(int i) {
        if (this._initXiaomiKtv) {
            int i2 = i / 6;
            int i3 = i2;
            if (i2 > 15) {
                i3 = 15;
            }
            this._audioManager.setParameters("audio_karaoke_volume=" + i3);
            this._volume = i3;
            return 0;
        }
        return 0;
    }

    public int SupportHWKaraokeLowlatency() {
        if (Build.VERSION.SDK_INT < 17) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            HwAudioKit hwAudioKit = new HwAudioKit(this._context);
            this._hwAudioKit = hwAudioKit;
            if (!hwAudioKit.initialize()) {
                this._hwAudioKit.destroy();
                this._hwAudioKit = null;
                return -1;
            }
            this._hwAudioKit.createFeatureKaraoke();
        }
        HwAudioKit hwAudioKit2 = this._hwAudioKit;
        if (hwAudioKit2 == null || !hwAudioKit2.isFeatureKaraokeOn()) {
            return ("true".equals(this._audioManager.getProperty("android.media.property.SUPPORT_HWKARAOKE_EFFECT")) && this._context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_AUDIO_LOW_LATENCY)) ? 0 : -1;
        }
        return 1;
    }

    public int SupportVivoKaraokeLowlatency() {
        StringTokenizer stringTokenizer = new StringTokenizer(this._audioManager.getParameters("vivo_ktv_mic_type"), "=");
        if (stringTokenizer.countTokens() == 2 && stringTokenizer.nextToken().equals("vivo_ktv_mic_type")) {
            int parseInt = Integer.parseInt(stringTokenizer.nextToken());
            if (parseInt == 1 || parseInt == 0) {
                return Build.VERSION.SDK_INT >= 27 ? 0 : 1;
            }
            return -1;
        }
        return -1;
    }

    public int SupportXiaomiKaraokeLowlatency() {
        return this._audioManager.getParameters("audio_karaoke_support").contains("true") ? 0 : -1;
    }

    public int UninitHWKtvEnv() {
        HwAudioKit hwAudioKit;
        if (this._deviceManufacturer != 1 || (hwAudioKit = this._hwAudioKit) == null) {
            return 0;
        }
        hwAudioKit.enableKaraokeFeature(false);
        this._hwAudioKit.destroy();
        this._hwAudioKit = null;
        return 0;
    }

    public int UninitVivoKtvEnv() {
        if (this._initVivoKtv) {
            SilentPlayer silentPlayer = this._silentPlayer;
            if (silentPlayer != null) {
                silentPlayer.stop();
                this._silentPlayer = null;
            }
            this._initVivoKtv = false;
            this._audioManager.setParameters("vivo_ktv_mode=0");
            return 0;
        }
        return 0;
    }

    public int UninitXiaomiKtvEnv() {
        if (this._initXiaomiKtv) {
            this._initXiaomiKtv = false;
            this._audioManager.setParameters("audio_karaoke_ktvmode=disable");
            return 0;
        }
        return 0;
    }

    public void setEQParams(int i) {
        AudioManager audioManager = this._audioManager;
        audioManager.setParameters("vivo_ktv_miceq_band1=" + (EQCustomGain[i][0] + 8));
        AudioManager audioManager2 = this._audioManager;
        audioManager2.setParameters("vivo_ktv_miceq_band2=" + (EQCustomGain[i][1] + 8));
        AudioManager audioManager3 = this._audioManager;
        audioManager3.setParameters("vivo_ktv_miceq_band3=" + (EQCustomGain[i][2] + 8));
        AudioManager audioManager4 = this._audioManager;
        audioManager4.setParameters("vivo_ktv_miceq_band4=" + (EQCustomGain[i][3] + 8));
        AudioManager audioManager5 = this._audioManager;
        audioManager5.setParameters("vivo_ktv_miceq_band5=" + (EQCustomGain[i][4] + 8));
    }

    public void setReverbParams(int i) {
        AudioManager audioManager = this._audioManager;
        audioManager.setParameters("vivo_ktv_rb_roomsize=" + ReverbCustomParams[i][0]);
        AudioManager audioManager2 = this._audioManager;
        audioManager2.setParameters("vivo_ktv_rb_damp=" + ReverbCustomParams[i][1]);
        AudioManager audioManager3 = this._audioManager;
        audioManager3.setParameters("vivo_ktv_rb_wet=" + ReverbCustomParams[i][2]);
        AudioManager audioManager4 = this._audioManager;
        audioManager4.setParameters("vivo_ktv_rb_dry=" + ReverbCustomParams[i][3]);
        AudioManager audioManager5 = this._audioManager;
        audioManager5.setParameters("vivo_ktv_rb_width=" + ReverbCustomParams[i][4]);
        AudioManager audioManager6 = this._audioManager;
        audioManager6.setParameters("vivo_ktv_rb_gain=" + ReverbCustomParams[i][5]);
        this._audioManager.setParameters("vivo_ktv_echo_enable=0");
    }
}
