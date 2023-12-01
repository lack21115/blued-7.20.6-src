package android.media;

import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioDevicePort.class */
public class AudioDevicePort extends AudioPort {
    private final String mAddress;
    private final int mType;

    AudioDevicePort(AudioHandle audioHandle, int[] iArr, int[] iArr2, int[] iArr3, AudioGain[] audioGainArr, int i, String str) {
        super(audioHandle, !AudioManager.isInputDevice(i) ? 2 : 1, iArr, iArr2, iArr3, audioGainArr);
        this.mType = i;
        this.mAddress = str;
    }

    public String address() {
        return this.mAddress;
    }

    @Override // android.media.AudioPort
    public AudioDevicePortConfig buildConfig(int i, int i2, int i3, AudioGainConfig audioGainConfig) {
        return new AudioDevicePortConfig(this, i, i2, i3, audioGainConfig);
    }

    @Override // android.media.AudioPort
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AudioDevicePort)) {
            return false;
        }
        return super.equals(obj);
    }

    @Override // android.media.AudioPort
    public String toString() {
        return "{" + super.toString() + ", mType: " + (this.mRole == 1 ? AudioSystem.getInputDeviceName(this.mType) : AudioSystem.getOutputDeviceName(this.mType)) + ", mAddress: " + this.mAddress + i.d;
    }

    public int type() {
        return this.mType;
    }
}
