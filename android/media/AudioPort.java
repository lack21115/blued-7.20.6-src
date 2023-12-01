package android.media;

import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioPort.class */
public class AudioPort {
    public static final int ROLE_NONE = 0;
    public static final int ROLE_SINK = 2;
    public static final int ROLE_SOURCE = 1;
    public static final int TYPE_DEVICE = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_SESSION = 3;
    public static final int TYPE_SUBMIX = 2;
    private AudioPortConfig mActiveConfig;
    private final int[] mChannelMasks;
    private final int[] mFormats;
    private final AudioGain[] mGains;
    AudioHandle mHandle;
    protected final int mRole;
    private final int[] mSamplingRates;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPort(AudioHandle audioHandle, int i, int[] iArr, int[] iArr2, int[] iArr3, AudioGain[] audioGainArr) {
        this.mHandle = audioHandle;
        this.mRole = i;
        this.mSamplingRates = iArr;
        this.mChannelMasks = iArr2;
        this.mFormats = iArr3;
        this.mGains = audioGainArr;
    }

    public AudioPortConfig activeConfig() {
        return this.mActiveConfig;
    }

    public AudioPortConfig buildConfig(int i, int i2, int i3, AudioGainConfig audioGainConfig) {
        return new AudioPortConfig(this, i, i2, i3, audioGainConfig);
    }

    public int[] channelMasks() {
        return this.mChannelMasks;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AudioPort)) {
            return false;
        }
        return this.mHandle.equals(((AudioPort) obj).handle());
    }

    public int[] formats() {
        return this.mFormats;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioGain gain(int i) {
        if (i < 0 || i >= this.mGains.length) {
            return null;
        }
        return this.mGains[i];
    }

    public AudioGain[] gains() {
        return this.mGains;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioHandle handle() {
        return this.mHandle;
    }

    public int hashCode() {
        return this.mHandle.hashCode();
    }

    public int role() {
        return this.mRole;
    }

    public int[] samplingRates() {
        return this.mSamplingRates;
    }

    public String toString() {
        String num = Integer.toString(this.mRole);
        switch (this.mRole) {
            case 0:
                num = "NONE";
                break;
            case 1:
                num = "SOURCE";
                break;
            case 2:
                num = "SINK";
                break;
        }
        return "{mHandle: " + this.mHandle + ", mRole: " + num + i.d;
    }
}
