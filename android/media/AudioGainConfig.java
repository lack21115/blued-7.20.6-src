package android.media;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioGainConfig.class */
public class AudioGainConfig {
    private final int mChannelMask;
    AudioGain mGain;
    private final int mIndex;
    private final int mMode;
    private final int mRampDurationMs;
    private final int[] mValues;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioGainConfig(int i, AudioGain audioGain, int i2, int i3, int[] iArr, int i4) {
        this.mIndex = i;
        this.mGain = audioGain;
        this.mMode = i2;
        this.mChannelMask = i3;
        this.mValues = iArr;
        this.mRampDurationMs = i4;
    }

    public int channelMask() {
        return this.mChannelMask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int index() {
        return this.mIndex;
    }

    public int mode() {
        return this.mMode;
    }

    public int rampDurationMs() {
        return this.mRampDurationMs;
    }

    public int[] values() {
        return this.mValues;
    }
}
