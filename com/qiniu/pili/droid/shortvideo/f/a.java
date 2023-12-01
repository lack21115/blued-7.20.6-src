package com.qiniu.pili.droid.shortvideo.f;

import android.os.Build;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f27661a = {"GT-I9260"};
    public static final String[] b = {"GT-I9260"};

    /* renamed from: c  reason: collision with root package name */
    private b f27662c;
    private b d;

    /* renamed from: com.qiniu.pili.droid.shortvideo.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/a$a.class */
    static class C0747a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f27663a = new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/a$b.class */
    public enum b {
        UNKNOWN,
        YES,
        NO
    }

    private a() {
        this.f27662c = b.UNKNOWN;
        this.d = b.UNKNOWN;
        e eVar = e.f27672a;
        eVar.c("CompatibleManager", "Build.MODEL:" + Build.MODEL);
    }

    public static a a() {
        return C0747a.f27663a;
    }

    private b d() {
        String[] strArr = f27661a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return b.NO;
            }
            if (strArr[i2].equalsIgnoreCase(Build.MODEL)) {
                return b.YES;
            }
            i = i2 + 1;
        }
    }

    private b e() {
        String[] strArr = b;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return b.YES;
            }
            if (strArr[i2].equalsIgnoreCase(Build.MODEL)) {
                return b.NO;
            }
            i = i2 + 1;
        }
    }

    public boolean b() {
        if (this.f27662c == b.UNKNOWN) {
            this.f27662c = d();
        }
        return this.f27662c == b.YES;
    }

    public boolean c() {
        if (this.d == b.UNKNOWN) {
            this.d = e();
        }
        return this.d == b.YES;
    }
}
