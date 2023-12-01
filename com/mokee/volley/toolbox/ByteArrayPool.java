package com.mokee.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ByteArrayPool.class */
public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = new a();
    private final int a;
    private List<byte[]> d = new LinkedList();
    private List<byte[]> c = new ArrayList(64);
    private int b = 0;

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ByteArrayPool$a.class */
    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public ByteArrayPool(int i) {
        this.a = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (r4.b > r4.a) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        if (com.mokee.volley.toolbox.ImageLoader.h != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0009, code lost:
        r0 = r4.d.remove(0);
        r4.c.remove(r0);
        r4.b -= r0.length;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0038 -> B:6:0x0008). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            r4 = this;
            r0 = r4
            monitor-enter(r0)
            boolean r0 = com.mokee.volley.toolbox.ImageLoader.h     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L2c
        L8:
            r0 = r4
            java.util.List<byte[]> r0 = r0.d     // Catch: java.lang.Throwable -> L3e
            r1 = 0
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L3e
            byte[] r0 = (byte[]) r0     // Catch: java.lang.Throwable -> L3e
            r7 = r0
            r0 = r4
            java.util.List<byte[]> r0 = r0.c     // Catch: java.lang.Throwable -> L3e
            r1 = r7
            boolean r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L3e
            r0 = r4
            r1 = r4
            int r1 = r1.b     // Catch: java.lang.Throwable -> L3e
            r2 = r7
            int r2 = r2.length     // Catch: java.lang.Throwable -> L3e
            int r1 = r1 - r2
            r0.b = r1     // Catch: java.lang.Throwable -> L3e
        L2c:
            r0 = r4
            int r0 = r0.b     // Catch: java.lang.Throwable -> L3e
            r5 = r0
            r0 = r4
            int r0 = r0.a     // Catch: java.lang.Throwable -> L3e
            r6 = r0
            r0 = r5
            r1 = r6
            if (r0 > r1) goto L8
            r0 = r4
            monitor-exit(r0)
            return
        L3e:
            r7 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.ByteArrayPool.a():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        r6 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
        if (r6 < r4.c.size()) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r9 = new byte[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (com.mokee.volley.toolbox.ImageLoader.h != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        r9 = r4.c.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (r9.length < r5) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        r4.b -= r9.length;
        r4.c.remove(r7);
        r4.d.remove(r9);
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005e -> B:7:0x0010). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] getBuf(int r5) {
        /*
            r4 = this;
            r0 = r4
            monitor-enter(r0)
            boolean r0 = com.mokee.volley.toolbox.ImageLoader.h     // Catch: java.lang.Throwable -> L69
            r8 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L52
        L10:
            r0 = r4
            java.util.List<byte[]> r0 = r0.c     // Catch: java.lang.Throwable -> L69
            r1 = r7
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L69
            byte[] r0 = (byte[]) r0     // Catch: java.lang.Throwable -> L69
            r9 = r0
            r0 = r9
            int r0 = r0.length     // Catch: java.lang.Throwable -> L69
            r1 = r5
            if (r0 < r1) goto L4e
            r0 = r4
            r1 = r4
            int r1 = r1.b     // Catch: java.lang.Throwable -> L69
            r2 = r9
            int r2 = r2.length     // Catch: java.lang.Throwable -> L69
            int r1 = r1 - r2
            r0.b = r1     // Catch: java.lang.Throwable -> L69
            r0 = r4
            java.util.List<byte[]> r0 = r0.c     // Catch: java.lang.Throwable -> L69
            r1 = r7
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L69
            r0 = r4
            java.util.List<byte[]> r0 = r0.d     // Catch: java.lang.Throwable -> L69
            r1 = r9
            boolean r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L69
        L49:
            r0 = r4
            monitor-exit(r0)
            r0 = r9
            return r0
        L4e:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
        L52:
            r0 = r6
            r7 = r0
            r0 = r6
            r1 = r4
            java.util.List<byte[]> r1 = r1.c     // Catch: java.lang.Throwable -> L69
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L69
            if (r0 < r1) goto L10
            r0 = r5
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L69
            r9 = r0
            goto L49
        L69:
            r9 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.ByteArrayPool.getBuf(int):byte[]");
    }

    public void returnBuf(byte[] bArr) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length <= this.a) {
                    this.d.add(bArr);
                    int binarySearch = Collections.binarySearch(this.c, bArr, BUF_COMPARATOR);
                    int i = binarySearch;
                    if (binarySearch < 0) {
                        i = (-binarySearch) - 1;
                    }
                    this.c.add(i, bArr);
                    this.b += bArr.length;
                    a();
                }
            }
        }
    }
}
