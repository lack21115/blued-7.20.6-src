package androidx.media;

import android.os.Bundle;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/media/AudioAttributesImplBase.class */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    int f3106a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f3107c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioAttributesImplBase() {
        this.f3106a = 0;
        this.b = 0;
        this.f3107c = 0;
        this.d = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioAttributesImplBase(int i, int i2, int i3, int i4) {
        this.f3106a = 0;
        this.b = 0;
        this.f3107c = 0;
        this.d = -1;
        this.b = i;
        this.f3107c = i2;
        this.f3106a = i3;
        this.d = i4;
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new AudioAttributesImplBase(bundle.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), bundle.getInt("androidx.media.audio_attrs.FLAGS", 0), bundle.getInt("androidx.media.audio_attrs.USAGE", 0), bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplBase) {
            AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
            boolean z = false;
            if (this.b == audioAttributesImplBase.getContentType()) {
                z = false;
                if (this.f3107c == audioAttributesImplBase.getFlags()) {
                    z = false;
                    if (this.f3106a == audioAttributesImplBase.getUsage()) {
                        z = false;
                        if (this.d == audioAttributesImplBase.d) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return null;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.b;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        int i;
        int i2 = this.f3107c;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i = i2 | 4;
        } else {
            i = i2;
            if (legacyStreamType == 7) {
                i = i2 | 1;
            }
        }
        return i & 273;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int i = this.d;
        return i != -1 ? i : AudioAttributesCompat.a(false, this.f3107c, this.f3106a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.d;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.f3106a;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return AudioAttributesCompat.a(true, this.f3107c, this.f3106a);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.f3107c), Integer.valueOf(this.f3106a), Integer.valueOf(this.d)});
    }

    @Override // androidx.media.AudioAttributesImpl
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.media.audio_attrs.USAGE", this.f3106a);
        bundle.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.b);
        bundle.putInt("androidx.media.audio_attrs.FLAGS", this.f3107c);
        int i = this.d;
        if (i != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f3106a));
        sb.append(" content=");
        sb.append(this.b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3107c).toUpperCase());
        return sb.toString();
    }
}
