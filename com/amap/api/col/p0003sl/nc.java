package com.amap.api.col.p0003sl;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* renamed from: com.amap.api.col.3sl.nc  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/nc.class */
public class nc {
    private static final ThreadLocal<CharsetDecoder> b = new ThreadLocal<CharsetDecoder>() { // from class: com.amap.api.col.3sl.nc.1
        private static CharsetDecoder a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ CharsetDecoder initialValue() {
            return a();
        }
    };
    public static final ThreadLocal<Charset> a = new ThreadLocal<Charset>() { // from class: com.amap.api.col.3sl.nc.2
        private static Charset a() {
            return Charset.forName("UTF-8");
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Charset initialValue() {
            return a();
        }
    };
    private static final ThreadLocal<CharBuffer> c = new ThreadLocal<>();
}
