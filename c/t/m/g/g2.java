package c.t.m.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g2.class */
public class g2 {
    public static g2 e = new g2();
    public static final Comparator<byte[]> f = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f3817a = new ArrayList(32);
    public final List<byte[]> b = new ArrayList(32);

    /* renamed from: c  reason: collision with root package name */
    public int f3818c = 0;
    public int d = 10240;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g2$a.class */
    public static final class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public static g2 a() {
        return e;
    }

    public void a(byte[] bArr) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length <= this.d) {
                    Arrays.fill(bArr, (byte) 0);
                    this.f3817a.add(bArr);
                    int binarySearch = Collections.binarySearch(this.b, bArr, f);
                    int i = binarySearch;
                    if (binarySearch < 0) {
                        i = (-binarySearch) - 1;
                    }
                    this.b.add(i, bArr);
                    this.f3818c += bArr.length;
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
                if (bArr.length == i) {
                    this.f3818c -= bArr.length;
                    this.b.remove(i3);
                    this.f3817a.remove(bArr);
                    return bArr;
                }
                i2 = i3 + 1;
            }
        }
    }

    public final void b() {
        synchronized (this) {
            while (this.f3818c > this.d) {
                byte[] remove = this.f3817a.remove(0);
                this.b.remove(remove);
                this.f3818c -= remove.length;
            }
        }
    }
}
