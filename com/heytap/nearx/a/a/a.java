package com.heytap.nearx.a.a;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/a.class */
public enum a {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.heytap.nearx.a.a.a$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/a$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22254a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            f22254a = iArr;
            try {
                iArr[a.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22254a[a.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22254a[a.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22254a[a.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    a(int i) {
        this.e = i;
    }

    public e<?> a() {
        int i = AnonymousClass1.f22254a[ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return e.q;
                    }
                    throw new AssertionError();
                }
                return e.l;
            }
            return e.g;
        }
        return e.j;
    }
}
