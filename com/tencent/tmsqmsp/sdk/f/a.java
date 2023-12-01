package com.tencent.tmsqmsp.sdk.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/f/a.class */
public class a {
    private static a e = new a(102400);
    public static final Comparator<byte[]> f = new C0877a();

    /* renamed from: a  reason: collision with root package name */
    private List<byte[]> f26062a = new LinkedList();
    private List<byte[]> b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    private int f26063c = 0;
    private final int d;

    /* renamed from: com.tencent.tmsqmsp.sdk.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/f/a$a.class */
    public static final class C0877a implements Comparator<byte[]> {
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
            while (this.f26063c > this.d) {
                byte[] remove = this.f26062a.remove(0);
                this.b.remove(remove);
                this.f26063c -= remove.length;
            }
        }
    }

    public void a(byte[] bArr) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length <= this.d) {
                    this.f26062a.add(bArr);
                    int binarySearch = Collections.binarySearch(this.b, bArr, f);
                    int i = binarySearch;
                    if (binarySearch < 0) {
                        i = (-binarySearch) - 1;
                    }
                    this.b.add(i, bArr);
                    this.f26063c += bArr.length;
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
                    this.f26063c -= bArr.length;
                    this.b.remove(i3);
                    this.f26062a.remove(bArr);
                    return bArr;
                }
                i2 = i3 + 1;
            }
        }
    }
}
