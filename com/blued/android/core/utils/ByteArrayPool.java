package com.blued.android.core.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/ByteArrayPool.class */
public class ByteArrayPool {

    /* renamed from: a  reason: collision with root package name */
    public static ByteArrayPool f9730a = new ByteArrayPool(8192);
    protected static final Comparator<byte[]> b = new Comparator<byte[]>() { // from class: com.blued.android.core.utils.ByteArrayPool.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final List<byte[]> f9731c = new ArrayList();
    private final List<byte[]> d = new ArrayList(64);
    private int e = 0;
    private final int f;

    public ByteArrayPool(int i) {
        this.f = i;
    }

    private void a() {
        synchronized (this) {
            while (this.e > this.f) {
                byte[] remove = this.f9731c.remove(0);
                this.d.remove(remove);
                this.e -= remove.length;
            }
        }
    }

    public void a(byte[] bArr) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length <= this.f) {
                    this.f9731c.add(bArr);
                    int binarySearch = Collections.binarySearch(this.d, bArr, b);
                    int i = binarySearch;
                    if (binarySearch < 0) {
                        i = (-binarySearch) - 1;
                    }
                    this.d.add(i, bArr);
                    this.e += bArr.length;
                    a();
                }
            }
        }
    }

    public byte[] a(int i) {
        synchronized (this) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.d.size()) {
                    return new byte[i];
                }
                byte[] bArr = this.d.get(i3);
                if (bArr.length >= i) {
                    this.e -= bArr.length;
                    this.d.remove(i3);
                    this.f9731c.remove(bArr);
                    return bArr;
                }
                i2 = i3 + 1;
            }
        }
    }
}
