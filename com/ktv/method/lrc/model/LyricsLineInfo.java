package com.ktv.method.lrc.model;

import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/model/LyricsLineInfo.class */
public class LyricsLineInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f10087a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f10088c;
    private String[] d;
    private int[] e;
    private List<LyricsLineInfo> f;

    public List<LyricsLineInfo> a() {
        return this.f;
    }

    public void a(int i) {
        this.f10087a = i;
    }

    public void a(LyricsLineInfo lyricsLineInfo, LyricsLineInfo lyricsLineInfo2) {
        if (lyricsLineInfo2.c() != null) {
            lyricsLineInfo.a(lyricsLineInfo2.c());
        }
        lyricsLineInfo.a(lyricsLineInfo2.d());
        lyricsLineInfo.b(lyricsLineInfo2.e());
        if (lyricsLineInfo2.b() != null) {
            lyricsLineInfo.a(lyricsLineInfo2.b());
        }
        lyricsLineInfo.a(lyricsLineInfo2.f());
    }

    public void a(String str) {
        this.f10088c = str.replaceAll("\r|\n", "");
    }

    public void a(List<LyricsLineInfo> list) {
        this.f = list;
    }

    public void a(int[] iArr) {
        this.e = iArr;
    }

    public void a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                this.d = strArr;
                return;
            } else {
                strArr[i2] = strArr[i2].replaceAll("\r|\n", "");
                i = i2 + 1;
            }
        }
    }

    public void b(int i) {
        this.b = i;
    }

    public String[] b() {
        return this.d;
    }

    public int[] c() {
        return this.e;
    }

    public int d() {
        return this.f10087a;
    }

    public int e() {
        return this.b;
    }

    public String f() {
        return this.f10088c;
    }
}
