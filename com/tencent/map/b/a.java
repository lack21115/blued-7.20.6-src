package com.tencent.map.b;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f37200a;

    /* renamed from: com.tencent.map.b.a$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/a$1.class */
    static /* synthetic */ class AnonymousClass1 {
        private AnonymousClass1() {
        }

        /* synthetic */ AnonymousClass1(a aVar, byte b) {
            this();
        }

        public boolean a(String str, String str2) {
            int a2 = a.a(a.this, str);
            if (str2.charAt(4) != i.f37238a.charAt(((((a2 * 9) + 10) / 3) + 36) & 31)) {
                return false;
            }
            if (str2.charAt(7) != i.f37238a.charAt((((a2 * 5) + 11) / 5) & 31)) {
                return false;
            }
            if (str2.charAt(12) != i.f37238a.charAt((((a2 + 10) / 3) << 3) & 31)) {
                return false;
            }
            int i = a2 * 3;
            if (str2.charAt(14) != i.f37238a.charAt(((i + 19) / 9) & 31)) {
                return false;
            }
            if (str2.charAt(19) != i.f37238a.charAt(((i + 39) / 8) & 31)) {
                return false;
            }
            if (str2.charAt(21) != i.f37238a.charAt((((a2 / 23) + 67) / 7) & 31)) {
                return false;
            }
            if (str2.charAt(26) != i.f37238a.charAt(((((a2 + 23) / 6) + 3) * 7) & 31)) {
                return false;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                i2 = i.b[(i2 ^ i.a(str.charAt(i3))) & 255] ^ ((i2 >> 8) & 255);
            }
            return str2.charAt(0) == i.f37238a.charAt(i2 & 31) && str2.charAt(1) == i.f37238a.charAt((i2 >> 5) & 31);
        }
    }

    private a() {
    }

    static /* synthetic */ int a(a aVar, String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += i.a(str.charAt(i2));
        }
        return (length + (length << 7)) ^ i;
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f37200a == null) {
                    f37200a = new a();
                }
                aVar = f37200a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final boolean a(String str, String str2) {
        if (i.a(str) && i.b(str2) && new AnonymousClass1(this, (byte) 0).a(str, str2)) {
            int i = 0;
            for (int i2 = 0; i2 < 27; i2++) {
                i = i.b[(i ^ i.a(str2.charAt(i2))) & 255] ^ ((i >> 8) & 255);
            }
            return str2.charAt(27) == i.f37238a.charAt(i & 31) && str2.charAt(28) == i.f37238a.charAt((i >> 5) & 31);
        }
        return false;
    }
}
