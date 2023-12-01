package com.blued.android.module.base.shortvideo;

import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/shortvideo/StvResultModel.class */
public class StvResultModel implements Serializable {
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private long g;
    private long h;
    private String j;
    private int k;
    private boolean a = true;
    private boolean i = false;

    public void a(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.f = i;
    }

    public void b(long j) {
        this.h = j;
    }

    public void b(String str) {
        this.c = str;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public String c() {
        return this.c;
    }

    public void c(int i) {
        this.k = i;
    }

    public void c(String str) {
        this.d = str;
    }

    public long d() {
        return this.g;
    }

    public void d(String str) {
        this.j = str;
    }

    public long e() {
        return this.h;
    }

    public String f() {
        return this.d;
    }

    public int g() {
        return this.e;
    }

    public int h() {
        return this.f;
    }

    public boolean i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public String toString() {
        return "StvResultModel{isVideo=" + this.a + ", captureFramePath='" + this.b + "', firstFrameImgPath='" + this.c + "', videoPath='" + this.d + "', videoWidth=" + this.e + ", videoHeight=" + this.f + ", videoDuration=" + this.g + ", videoSize=" + this.h + ", isAutoDelete=" + this.i + '}';
    }
}
