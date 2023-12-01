package com.tencent.tmsqmsp.sdk.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/f/a.class */
public class a {
    private static a e = new a(102400);
    public static final Comparator<byte[]> f = new C1047a();

    /* renamed from: a  reason: collision with root package name */
    private List<byte[]> f39753a = new LinkedList();
    private List<byte[]> b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    private int f39754c = 0;
    private final int d;

    /* renamed from: com.tencent.tmsqmsp.sdk.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/f/a$a.class */
    public static final class C1047a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public a(int i) {
        this.d = i;
    }

    public static a a() {
        return e;
    }

    private void b() {
        synchronized (this) {
            while (this.f39754c > this.d) {
                byte[] remove = this.f39753a.remove(0);
                this.b.remove(remove);
                this.f39754c -= remove.length;
            }
        }
    }

    public void a(byte[] bArr) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length <= this.d) {
                    this.f39753a.add(bArr);
                    int binarySearch = Collections.binarySearch(this.b, bArr, f);
                    int i = binarySearch;
                    if (binarySearch < 0) {
                        i = (-binarySearch) - 1;
                    }
                    this.b.add(i, bArr);
                    this.f39754c += bArr.length;
                    b();
                }
            }
        }
    }

    public byte[] a(int i) {
        synchronized (this) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.b.size()) {
                    return new byte[i];
                }
                byte[] bArr = this.b.get(i3);
                if (bArr.length >= i) {
                    this.f39754c -= bArr.length;
                    this.b.remove(i3);
                    this.f39753a.remove(bArr);
                    return bArr;
                }
                i2 = i3 + 1;
            }
        }
    }
}
