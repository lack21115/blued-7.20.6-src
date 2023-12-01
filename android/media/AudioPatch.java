package android.media;

import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioPatch.class */
public class AudioPatch {
    private final AudioHandle mHandle;
    private final AudioPortConfig[] mSinks;
    private final AudioPortConfig[] mSources;

    AudioPatch(AudioHandle audioHandle, AudioPortConfig[] audioPortConfigArr, AudioPortConfig[] audioPortConfigArr2) {
        this.mHandle = audioHandle;
        this.mSources = audioPortConfigArr;
        this.mSinks = audioPortConfigArr2;
    }

    public AudioPortConfig[] sinks() {
        return this.mSinks;
    }

    public AudioPortConfig[] sources() {
        return this.mSources;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mHandle: ");
        sb.append(this.mHandle.toString());
        sb.append(" mSources: {");
        AudioPortConfig[] audioPortConfigArr = this.mSources;
        int length = audioPortConfigArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            sb.append(audioPortConfigArr[i2].toString());
            sb.append(", ");
            i = i2 + 1;
        }
        sb.append("} mSinks: {");
        AudioPortConfig[] audioPortConfigArr2 = this.mSinks;
        int length2 = audioPortConfigArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                sb.append(i.d);
                return sb.toString();
            }
            sb.append(audioPortConfigArr2[i4].toString());
            sb.append(", ");
            i3 = i4 + 1;
        }
    }
}
