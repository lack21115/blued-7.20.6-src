package com.qiniu.pili.droid.shortvideo.f;

import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f27672a = new e("");
    public static final e b = new e("Pili-System");

    /* renamed from: c  reason: collision with root package name */
    public static final e f27673c = new e("Pili-SCREEN");
    public static final e d = new e("Pili-Record");
    public static final e e = new e("Pili-Editor");
    public static final e f = new e("Pili-Capture");
    public static final e g = new e("Pili-Processing");
    public static final e h = new e("Pili-Encode");
    public static final e i = new e("Pili-Decode");
    public static final e j = new e("Pili-OpenGL");
    public static final e k = new e("Pili-Player");
    public static final e l = new e("Pili-Stat");
    public static final e m = new e("Pili-Network");
    public static final e n = new e("Pili-Muxer");
    public static final e o = new e("Pili-Upload");
    public static final e p = new e("Pili-Trim");
    public static final e q = new e("Pili-AudioMix");
    public static final e r = new e("Pili-Resampler");
    public static final e s = new e("Pili-Transcode");
    public static final e t = new e("Pili-Composer");
    public static final e u = new e("Pili-Parser");
    public static final e v = new e("Pili-Transition");
    public static final e w = new e("Pili-Utils");
    public static final e x = new e("Pili-VideoMix");
    private static String y = "PLDroidShortVideo";
    private static int z = 4;
    private final String A;

    private e(String str) {
        this.A = str;
    }

    public static void a(int i2) {
        z = i2;
    }

    private String e(String str) {
        String str2;
        String str3 = this.A;
        if (str3 == null || "".equals(str3)) {
            str2 = "";
        } else {
            str2 = "" + this.A + ":";
        }
        String str4 = str2;
        if (str != null) {
            str4 = str2;
            if (!"".equals(str)) {
                str4 = str2 + str + ":";
            }
        }
        return str4;
    }

    public void a(String str) {
        a(null, str);
    }

    public void a(String str, String str2) {
        if (z > 2) {
            return;
        }
        String str3 = y;
        Log.v(str3, e(str) + str2);
    }

    public void b(String str) {
        c(null, str);
    }

    public void b(String str, String str2) {
        if (z > 3) {
            return;
        }
        String str3 = y;
        Log.d(str3, e(str) + str2);
    }

    public void c(String str) {
        d(null, str);
    }

    public void c(String str, String str2) {
        if (z > 4) {
            return;
        }
        String str3 = y;
        Log.i(str3, e(str) + str2);
    }

    public void d(String str) {
        e(null, str);
    }

    public void d(String str, String str2) {
        if (z > 5) {
            return;
        }
        String str3 = y;
        Log.w(str3, e(str) + str2);
    }

    public void e(String str, String str2) {
        if (z > 6) {
            return;
        }
        String str3 = y;
        Log.e(str3, e(str) + str2);
    }
}
