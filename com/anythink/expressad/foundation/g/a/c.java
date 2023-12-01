package com.anythink.expressad.foundation.g.a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/a/c.class */
public final class c implements e<String, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, Bitmap> f7828a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f7829c;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.f7828a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private static int a(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.foundation.g.a.e
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Bitmap b(String str) {
        if (str != null) {
            synchronized (this) {
                Bitmap bitmap = this.f7828a.get(str);
                if (bitmap == null || bitmap.isRecycled()) {
                    return null;
                }
                return bitmap;
            }
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r5) {
        /*
            r4 = this;
        L0:
            r0 = r4
            monitor-enter(r0)
            r0 = r4
            int r0 = r0.f7829c     // Catch: java.lang.Throwable -> Lb1
            if (r0 < 0) goto L8a
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r0.f7828a     // Catch: java.lang.Throwable -> Lb1
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lb1
            if (r0 == 0) goto L1a
            r0 = r4
            int r0 = r0.f7829c     // Catch: java.lang.Throwable -> Lb1
            if (r0 != 0) goto L8a
        L1a:
            r0 = r4
            int r0 = r0.f7829c     // Catch: java.lang.Throwable -> Lb1
            r1 = r5
            if (r0 <= r1) goto L87
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r0.f7828a     // Catch: java.lang.Throwable -> Lb1
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lb1
            if (r0 == 0) goto L2f
            goto L87
        L2f:
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r0.f7828a     // Catch: java.lang.Throwable -> Lb1
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> Lb1
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lb1
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> Lb1
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> Lb1
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L4d
            r0 = r4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb1
            return
        L4d:
            r0 = r8
            java.lang.Object r0 = r0.getKey()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Lb1
            r7 = r0
            r0 = r8
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> Lb1
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> Lb1
            r8 = r0
            r0 = r8
            int r0 = a(r0)     // Catch: java.lang.Throwable -> Lb6
            r6 = r0
            r0 = r4
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r0.f7828a     // Catch: java.lang.Throwable -> Lb6
            r1 = r7
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> Lb6
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> Lb6
            r0.recycle()     // Catch: java.lang.Throwable -> Lb6
            r0 = r4
            r1 = r4
            int r1 = r1.f7829c     // Catch: java.lang.Throwable -> Lb6
            r2 = r6
            int r1 = r1 - r2
            r0.f7829c = r1     // Catch: java.lang.Throwable -> Lb6
        L82:
            r0 = r4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb1
            goto L0
        L87:
            r0 = r4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb1
            return
        L8a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb1
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lb1
            r7 = r0
            r0 = r7
            r1 = r4
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> Lb1
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lb1
            r0 = r7
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lb1
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lb1
            r1 = r0
            r2 = r7
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb1
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb1
            throw r0     // Catch: java.lang.Throwable -> Lb1
        Lb1:
            r7 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r7
            throw r0
        Lb6:
            r7 = move-exception
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.a.c.a(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.foundation.g.a.e
    public boolean a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f7829c += a(bitmap);
            Bitmap put = this.f7828a.put(str, bitmap);
            if (put != null) {
                this.f7829c -= a(put);
            }
        }
        a(this.b);
        return true;
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private void b2(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap remove = this.f7828a.remove(str);
            if (remove != null) {
                this.f7829c -= a(remove);
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f7828a.keySet());
        }
        return hashSet;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        if (str2 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap remove = this.f7828a.remove(str2);
            if (remove != null) {
                this.f7829c -= a(remove);
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final void b() {
        a(-1);
    }

    public final String toString() {
        String format;
        synchronized (this) {
            format = String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
        }
        return format;
    }
}
