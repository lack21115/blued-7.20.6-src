package com.sobot.chat.core.a.a;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/h.class */
public class h {
    private static final AtomicInteger b = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    private final h f28210a;

    /* renamed from: c  reason: collision with root package name */
    private final int f28211c;
    private byte[] d;
    private String e;
    private boolean f;
    private byte[] g;
    private byte[] h;
    private byte[] i;

    public h(String str) {
        this.f28210a = this;
        this.f28211c = b.getAndIncrement();
        this.e = str;
    }

    public h(byte[] bArr) {
        this(bArr, false);
    }

    public h(byte[] bArr, boolean z) {
        this.f28210a = this;
        this.f28211c = b.getAndIncrement();
        this.d = Arrays.copyOf(bArr, bArr.length);
        this.f = z;
    }

    public int a() {
        return this.f28211c;
    }

    public h a(byte[] bArr) {
        this.g = bArr;
        return this;
    }

    public void a(String str) {
        if (c() != null) {
            this.d = com.sobot.chat.core.a.b.b.a(c(), str);
        }
    }

    public h b(byte[] bArr) {
        this.h = bArr;
        return this;
    }

    public byte[] b() {
        return this.d;
    }

    public h c(byte[] bArr) {
        this.i = bArr;
        return this;
    }

    public String c() {
        return this.e;
    }

    public boolean d() {
        return this.f;
    }

    public byte[] e() {
        return this.g;
    }

    public byte[] f() {
        return this.h;
    }

    public byte[] g() {
        return this.i;
    }
}
