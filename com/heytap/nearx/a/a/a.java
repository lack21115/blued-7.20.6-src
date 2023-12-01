package com.heytap.nearx.a.a;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/a.class */
public enum a {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    final int e;

    /* renamed from: com.heytap.nearx.a.a.a$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/a$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8646a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            f8646a = iArr;
            try {
                iArr[a.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8646a[a.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8646a[a.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8646a[a.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    a(int i) {
        this.e = i;
    }

    public e<?> a() {
        int i = AnonymousClass1.f8646a[ordinal()];
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
