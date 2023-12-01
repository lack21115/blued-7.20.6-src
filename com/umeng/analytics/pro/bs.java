package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bs.class */
public class bs extends ByteArrayOutputStream {
    public bs() {
    }

    public bs(int i) {
        super(i);
    }

    public byte[] a() {
        return this.buf;
    }

    public int b() {
        return this.count;
    }
}
