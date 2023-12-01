package com.qiniu.pili.droid.shortvideo.f;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private String f13989a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f13990c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.pili.droid.shortvideo.f.h$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/h$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13991a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            f13991a = iArr;
            try {
                iArr[a.PL_SO_TYPE_MM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13991a[a.PL_SO_TYPE_AMIX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13991a[a.PL_SO_TYPE_DECODER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13991a[a.PL_SO_TYPE_ENCODER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/h$a.class */
    public enum a {
        PL_SO_TYPE_MM,
        PL_SO_TYPE_AMIX,
        PL_SO_TYPE_DECODER,
        PL_SO_TYPE_ENCODER
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/h$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final h f13994a = new h(null);
    }

    private h() {
        this.f13989a = "pldroid_beauty";
        this.b = "pldroid_amix";
        this.f13990c = "pldroid_decoder";
        this.d = "pldroid_encoder";
    }

    /* synthetic */ h(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static h a() {
        return b.f13994a;
    }

    private boolean a(String str) {
        if (str != null) {
            try {
                if (str.contains("/")) {
                    System.load(str);
                    return true;
                }
                System.loadLibrary(str);
                return true;
            } catch (UnsatisfiedLinkError e) {
                e eVar = e.f13984a;
                eVar.e("PLSONameHelper", "Load error:" + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean a(boolean z) {
        if (z && !com.qiniu.pili.droid.beauty.a.f13775a) {
            e.f13984a.e("PLSONameHelper", "MM Processing is not available");
        }
        return com.qiniu.pili.droid.beauty.a.f13775a;
    }

    public String a(a aVar) {
        int i = AnonymousClass1.f13991a[aVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return this.d;
                    }
                    throw new IllegalArgumentException("cannot support the so type:" + aVar);
                }
                return this.f13990c;
            }
            return this.b;
        }
        return this.f13989a;
    }

    public boolean b() {
        return a(a(a.PL_SO_TYPE_MM));
    }

    public boolean c() {
        return a(a(a.PL_SO_TYPE_AMIX));
    }

    public boolean d() {
        return a(a(a.PL_SO_TYPE_ENCODER));
    }
}
