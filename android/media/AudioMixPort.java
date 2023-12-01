package android.media;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioMixPort.class */
public class AudioMixPort extends AudioPort {
    AudioMixPort(AudioHandle audioHandle, int i, int[] iArr, int[] iArr2, int[] iArr3, AudioGain[] audioGainArr) {
        super(audioHandle, i, iArr, iArr2, iArr3, audioGainArr);
    }

    @Override // android.media.AudioPort
    public AudioMixPortConfig buildConfig(int i, int i2, int i3, AudioGainConfig audioGainConfig) {
        return new AudioMixPortConfig(this, i, i2, i3, audioGainConfig);
    }

    @Override // android.media.AudioPort
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AudioMixPort)) {
            return false;
        }
        return super.equals(obj);
    }
}
