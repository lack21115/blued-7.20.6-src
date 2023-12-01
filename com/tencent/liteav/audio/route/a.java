package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/a.class */
public enum a {
    STOPPED(1),
    VOICE_PLAY_AND_RECORD(2),
    MEDIA_PLAY_AND_RECORD(3),
    MEDIA_PLAYBACK(4),
    VOICE_PLAYBACK(5);
    
    int mValue;

    /* renamed from: com.tencent.liteav.audio.route.a$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/a$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22559a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            f22559a = iArr;
            try {
                iArr[a.VOICE_PLAY_AND_RECORD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22559a[a.VOICE_PLAYBACK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22559a[a.MEDIA_PLAY_AND_RECORD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22559a[a.MEDIA_PLAYBACK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    a(int i) {
        this.mValue = i;
    }

    public static int a(a aVar) {
        int i = AnonymousClass1.f22559a[aVar.ordinal()];
        return (i == 1 || i == 2) ? 3 : 0;
    }

    public static a a(int i) {
        a[] values = values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return STOPPED;
            }
            a aVar = values[i3];
            if (aVar.mValue == i) {
                return aVar;
            }
            i2 = i3 + 1;
        }
    }

    public final boolean a() {
        return this == VOICE_PLAY_AND_RECORD || this == VOICE_PLAYBACK;
    }
}
