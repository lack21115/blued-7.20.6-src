package com.igexin.push.c.c;

import org.apache.commons.codec.CharEncoding;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/c.class */
public abstract class c extends com.igexin.c.a.d.b {
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 25;
    public static final int s = 26;
    public static final int t = 27;
    public static final int u = 16;
    public static final int v = 17;
    public static final int w = 33;
    public static final int x = 192;
    public int m;
    public byte n;
    public byte o = 11;

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(String str) {
        if (str.equals("UTF-8")) {
            return 1;
        }
        if (str.equals("UTF-16")) {
            return 2;
        }
        if (str.equals(CharEncoding.UTF_16BE)) {
            return 16;
        }
        if (str.equals(CharEncoding.UTF_16LE)) {
            return 17;
        }
        if (str.equals("GBK")) {
            return 25;
        }
        if (str.equals("GB2312")) {
            return 26;
        }
        if (str.equals("GB18030")) {
            return 27;
        }
        return str.equals("ISO-8859-1") ? 33 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(byte b) {
        int i = b & 63;
        String str = "UTF-8";
        if (i != 1) {
            if (i != 2) {
                if (i != 16) {
                    if (i != 17) {
                        if (i != 33) {
                            switch (i) {
                                case 25:
                                    return "GBK";
                                case 26:
                                    return "GB2312";
                                case 27:
                                    return "GB18030";
                                default:
                                    return "UTF-8";
                            }
                        }
                        return "ISO-8859-1";
                    }
                    return CharEncoding.UTF_16LE;
                }
                return CharEncoding.UTF_16BE;
            }
            str = "UTF-16";
        }
        return str;
    }

    @Override // com.igexin.c.a.d.a.a
    public void a() {
    }

    public abstract void a(byte[] bArr);

    public abstract byte[] b();

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return this.m;
    }
}
