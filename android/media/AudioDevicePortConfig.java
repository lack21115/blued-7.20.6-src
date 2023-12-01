package android.media;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioDevicePortConfig.class */
public class AudioDevicePortConfig extends AudioPortConfig {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioDevicePortConfig(AudioDevicePort audioDevicePort, int i, int i2, int i3, AudioGainConfig audioGainConfig) {
        super(audioDevicePort, i, i2, i3, audioGainConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioDevicePortConfig(AudioDevicePortConfig audioDevicePortConfig) {
        this(audioDevicePortConfig.port(), audioDevicePortConfig.samplingRate(), audioDevicePortConfig.channelMask(), audioDevicePortConfig.format(), audioDevicePortConfig.gain());
    }

    @Override // android.media.AudioPortConfig
    public AudioDevicePort port() {
        return (AudioDevicePort) this.mPort;
    }
}
