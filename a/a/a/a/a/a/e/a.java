package a.a.a.a.a.a.e;

import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.StreamingProfile;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/e/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f1221a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1222c;

    public a(int i, int i2, int i3) {
        this.f1221a = i;
        this.f1222c = i3;
        this.b = i2;
    }

    public static a a(StreamingProfile.AudioProfile audioProfile) {
        e eVar = e.f;
        eVar.c("AudioEncoderConfig", "sample:" + audioProfile.sampleRate + ", bitrate:" + audioProfile.reqBitrate);
        return new a(audioProfile.channelNumber, audioProfile.sampleRate, audioProfile.reqBitrate);
    }

    public int a() {
        return this.f1221a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f1222c;
    }

    public int d() {
        int i = this.f1221a;
        if (i == 1) {
            e.f.b("AudioEncoderConfig", "SETTING CHANNEL MONO");
            return 16;
        } else if (i == 2) {
            e.f.b("AudioEncoderConfig", "SETTING CHANNEL STEREO");
            return 12;
        } else {
            throw new IllegalArgumentException("Invalid channel count. Must be 1 or 2");
        }
    }

    public String toString() {
        return "AudioEncoderConfig: " + this.f1221a + " channels totaling " + this.f1222c + " bps @" + this.b + " Hz";
    }
}
