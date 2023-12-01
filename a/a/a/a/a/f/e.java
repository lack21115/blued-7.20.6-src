package a.a.a.a.a.f;

import com.qiniu.pili.droid.streaming.AVCodecType;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/f/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1372a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public AVCodecType f1373c;
    public boolean d;
    public boolean e;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/f/e$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final e f1374a = new e();
    }

    public e() {
    }

    public static e a() {
        return b.f1374a;
    }

    public e a(AVCodecType aVCodecType) {
        this.f1373c = aVCodecType;
        return this;
    }

    public e a(boolean z) {
        this.e = z;
        return this;
    }

    public e b(boolean z) {
        this.d = z;
        return this;
    }

    public boolean b() {
        return (!this.d || this.e) && this.f1372a;
    }

    public e c(boolean z) {
        this.f1372a = z;
        return this;
    }

    public boolean c() {
        return !this.f1372a && this.b && f();
    }

    public e d(boolean z) {
        this.b = z;
        return this;
    }

    public boolean d() {
        return this.d && !this.e && this.f1372a;
    }

    public boolean e() {
        return (c() || b() || d()) ? false : true;
    }

    public final boolean f() {
        AVCodecType aVCodecType = this.f1373c;
        return aVCodecType == AVCodecType.SW_VIDEO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_WITH_HW_AUDIO_CODEC || aVCodecType == AVCodecType.SW_VIDEO_WITH_SW_AUDIO_CODEC || aVCodecType == AVCodecType.HW_VIDEO_YUV_AS_INPUT_WITH_HW_AUDIO_CODEC;
    }
}
