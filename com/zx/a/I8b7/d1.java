package com.zx.a.I8b7;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/d1.class */
public abstract class d1 {
    public static d1 a(n0 n0Var, String str) {
        Charset.forName("UTF-8");
        n0 n0Var2 = n0Var;
        if (n0Var != null) {
            n0Var2 = n0Var;
            if (n0Var.a() == null) {
                Charset.forName("UTF-8");
                n0Var2 = n0.b(n0Var + "; charset=utf-8");
            }
        }
        return a(n0Var2, str.getBytes(StandardCharsets.UTF_8));
    }

    public static d1 a(n0 n0Var, byte[] bArr) {
        int length = bArr.length;
        long length2 = bArr.length;
        long j = 0;
        long j2 = length;
        if ((j | j2) < 0 || j > length2 || length2 - j < j2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return new c1(n0Var, length, bArr, 0);
    }
}
