package com.tencent.thumbplayer.g.h;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/h/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f39358a = 2;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static a f39359c = new a() { // from class: com.tencent.thumbplayer.g.h.b.1
        @Override // com.tencent.thumbplayer.g.h.a
        public final void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.tencent.thumbplayer.g.h.a
        public final void e(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }

        @Override // com.tencent.thumbplayer.g.h.a
        public final void i(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // com.tencent.thumbplayer.g.h.a
        public final void v(String str, String str2) {
            Log.v(str, str2);
        }

        @Override // com.tencent.thumbplayer.g.h.a
        public final void w(String str, String str2, Throwable th) {
            Log.w(str, str2, th);
        }
    };

    public static void a(a aVar) {
        f39359c = aVar;
    }

    public static void a(String str, String str2) {
        if (a(2)) {
            f39359c.v("TMediaCodec.".concat(String.valueOf(str)), str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a(5)) {
            f39359c.w("TMediaCodec.".concat(String.valueOf(str)), str2, th);
        }
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean a() {
        return b;
    }

    public static boolean a(int i) {
        return b && i >= f39358a;
    }

    public static void b(String str, String str2) {
        if (a(3)) {
            f39359c.d("TMediaCodec.".concat(String.valueOf(str)), str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (a(6)) {
            f39359c.e("TMediaCodec.".concat(String.valueOf(str)), str2, th);
        }
    }

    public static void c(String str, String str2) {
        if (a(4)) {
            f39359c.i("TMediaCodec.".concat(String.valueOf(str)), str2);
        }
    }

    public static void d(String str, String str2) {
        if (a(5)) {
            f39359c.w("TMediaCodec.".concat(String.valueOf(str)), str2, null);
        }
    }

    public static void e(String str, String str2) {
        if (a(6)) {
            f39359c.e("TMediaCodec.".concat(String.valueOf(str)), str2, null);
        }
    }
}
