package com.sobot.chat.core.a.b;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final a f14530a = this;
    private final byte[] b;

    public a(byte[] bArr) {
        if (bArr == null) {
            throw null;
        }
        this.b = bArr;
    }

    public boolean a(byte[] bArr) {
        return Arrays.equals(a(), bArr);
    }

    public byte[] a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return a(((a) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(a());
    }
}
