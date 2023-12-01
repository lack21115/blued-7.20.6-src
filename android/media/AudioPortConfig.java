package android.media;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioPortConfig.class */
public class AudioPortConfig {
    static final int CHANNEL_MASK = 2;
    static final int FORMAT = 4;
    static final int GAIN = 8;
    static final int SAMPLE_RATE = 1;
    private final int mChannelMask;
    int mConfigMask = 0;
    private final int mFormat;
    private final AudioGainConfig mGain;
    final AudioPort mPort;
    private final int mSamplingRate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPortConfig(AudioPort audioPort, int i, int i2, int i3, AudioGainConfig audioGainConfig) {
        this.mPort = audioPort;
        this.mSamplingRate = i;
        this.mChannelMask = i2;
        this.mFormat = i3;
        this.mGain = audioGainConfig;
    }

    public int channelMask() {
        return this.mChannelMask;
    }

    public int format() {
        return this.mFormat;
    }

    public AudioGainConfig gain() {
        return this.mGain;
    }

    public AudioPort port() {
        return this.mPort;
    }

    public int samplingRate() {
        return this.mSamplingRate;
    }

    public String toString() {
        return "{mPort:" + this.mPort + ", mSamplingRate:" + this.mSamplingRate + ", mChannelMask: " + this.mChannelMask + ", mFormat:" + this.mFormat + ", mGain:" + this.mGain + "}";
    }
}
