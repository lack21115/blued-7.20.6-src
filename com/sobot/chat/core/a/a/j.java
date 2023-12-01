package com.sobot.chat.core.a.a;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    final j f28217a = this;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private String f28218c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private boolean g;
    private int h;
    private int i;

    public j a(boolean z) {
        this.g = z;
        return this;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(String str) {
        if (a() != null) {
            b(com.sobot.chat.core.a.b.b.a(a(), str));
            a(a()[0]);
            b(a()[1]);
        }
    }

    public boolean a(byte[] bArr) {
        return Arrays.equals(a(), bArr);
    }

    public byte[] a() {
        return this.b;
    }

    public j b(String str) {
        this.f28218c = str;
        return this;
    }

    public j b(byte[] bArr) {
        this.b = bArr;
        return this;
    }

    public String b() {
        return this.f28218c;
    }

    public void b(int i) {
        this.i = i;
    }

    public j c(byte[] bArr) {
        this.d = bArr;
        return this;
    }

    public byte[] c() {
        return this.d;
    }

    public j d(byte[] bArr) {
        this.e = bArr;
        return this;
    }

    public byte[] d() {
        return this.e;
    }

    public j e(byte[] bArr) {
        this.f = bArr;
        return this;
    }

    public byte[] e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }
}
