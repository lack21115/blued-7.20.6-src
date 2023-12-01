package com.naman14.androidlame;

/* loaded from: source-8303388-dex2jar.jar:com/naman14/androidlame/LameBuilder.class */
public class LameBuilder {
    public String m = null;
    public String o = null;
    public String n = null;
    public String p = null;
    public String q = null;

    /* renamed from: a  reason: collision with root package name */
    public int f24274a = 44100;
    public int b = 0;
    public int d = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f24275c = 128;
    public float j = 1.0f;
    public int e = 5;
    public Mode k = Mode.DEFAULT;
    public VbrMode l = VbrMode.VBR_OFF;
    public int f = 5;
    public int g = 128;
    public int h = 0;
    public int i = 0;

    /* loaded from: source-8303388-dex2jar.jar:com/naman14/androidlame/LameBuilder$Mode.class */
    public enum Mode {
        STEREO,
        JSTEREO,
        MONO,
        DEFAULT
    }

    /* loaded from: source-8303388-dex2jar.jar:com/naman14/androidlame/LameBuilder$VbrMode.class */
    public enum VbrMode {
        VBR_OFF,
        VBR_RH,
        VBR_MTRH,
        VBR_ABR,
        VBR_DEFAUT
    }

    public AndroidLame a() {
        return new AndroidLame(this);
    }

    public LameBuilder a(int i) {
        this.f24274a = i;
        return this;
    }

    public LameBuilder b(int i) {
        this.b = i;
        return this;
    }

    public LameBuilder c(int i) {
        this.f24275c = i;
        return this;
    }

    public LameBuilder d(int i) {
        this.d = i;
        return this;
    }
}
