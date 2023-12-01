package ar.com.hjg.pngj;

import java.util.Arrays;
import java.util.zip.Inflater;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/IdatSet.class */
public class IdatSet extends DeflatedChunksSet {
    protected byte[] f;
    protected byte[] g;
    protected final ImageInfo h;
    protected final Deinterlacer i;
    final RowInfo j;
    protected int[] k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ar.com.hjg.pngj.IdatSet$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/IdatSet$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3637a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[FilterType.values().length];
            f3637a = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3637a[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3637a[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3637a[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3637a[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public IdatSet(String str, ImageInfo imageInfo, Deinterlacer deinterlacer) {
        this(str, imageInfo, deinterlacer, null, null);
    }

    public IdatSet(String str, ImageInfo imageInfo, Deinterlacer deinterlacer, Inflater inflater, byte[] bArr) {
        super(str, (deinterlacer != null ? deinterlacer.h() : imageInfo.k) + 1, imageInfo.k + 1, inflater, bArr);
        this.k = new int[5];
        this.h = imageInfo;
        this.i = deinterlacer;
        this.j = new RowInfo(imageInfo, deinterlacer);
    }

    private void c(int i) {
        int i2 = 1;
        int i3 = 1 - this.h.j;
        while (true) {
            int i4 = i3;
            if (i2 > i) {
                return;
            }
            this.f[i2] = (byte) (this.f3627a[i2] + (((i4 > 0 ? this.f[i4] & 255 : 0) + (this.g[i2] & 255)) / 2));
            i2++;
            i3 = i4 + 1;
        }
    }

    private void d(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > i) {
                return;
            }
            this.f[i3] = this.f3627a[i3];
            i2 = i3 + 1;
        }
    }

    private void e(int i) {
        int i2 = 1;
        int i3 = 1 - this.h.j;
        while (true) {
            int i4 = i3;
            if (i2 > i) {
                return;
            }
            int i5 = 0;
            int i6 = i4 > 0 ? this.f[i4] & 255 : 0;
            if (i4 > 0) {
                i5 = this.g[i4] & 255;
            }
            this.f[i2] = (byte) (this.f3627a[i2] + PngHelperInternal.a(i6, this.g[i2] & 255, i5));
            i2++;
            i3 = i4 + 1;
        }
    }

    private void f(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > this.h.j) {
                break;
            }
            this.f[i3] = this.f3627a[i3];
            i2 = i3 + 1;
        }
        int i4 = this.h.j + 1;
        int i5 = 1;
        while (true) {
            int i6 = i5;
            if (i4 > i) {
                return;
            }
            this.f[i4] = (byte) (this.f3627a[i4] + this.f[i6]);
            i4++;
            i5 = i6 + 1;
        }
    }

    private void g(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > i) {
                return;
            }
            this.f[i3] = (byte) (this.f3627a[i3] + this.g[i3]);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ar.com.hjg.pngj.DeflatedChunksSet
    public void a() {
        super.a();
        this.j.update(i());
        k();
        RowInfo rowInfo = this.j;
        rowInfo.a(this.f, rowInfo.m + 1);
    }

    @Override // ar.com.hjg.pngj.DeflatedChunksSet
    protected int b() {
        return l();
    }

    protected void b(int i) {
        byte[] bArr = this.f;
        if (bArr == null || bArr.length < this.f3627a.length) {
            this.f = new byte[this.f3627a.length];
            this.g = new byte[this.f3627a.length];
        }
        if (this.j.j == 0) {
            Arrays.fill(this.f, (byte) 0);
        }
        byte[] bArr2 = this.f;
        this.f = this.g;
        this.g = bArr2;
        byte b = this.f3627a[0];
        if (!FilterType.b(b)) {
            throw new PngjInputException("Filter type " + ((int) b) + " invalid");
        }
        FilterType a2 = FilterType.a(b);
        int[] iArr = this.k;
        iArr[b] = iArr[b] + 1;
        this.f[0] = this.f3627a[0];
        int i2 = AnonymousClass1.f3637a[a2.ordinal()];
        if (i2 == 1) {
            d(i);
        } else if (i2 == 2) {
            f(i);
        } else if (i2 == 3) {
            g(i);
        } else if (i2 == 4) {
            c(i);
        } else if (i2 == 5) {
            e(i);
        } else {
            throw new PngjInputException("Filter type " + ((int) b) + " not implemented");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ar.com.hjg.pngj.DeflatedChunksSet
    public void c() {
        super.c();
    }

    @Override // ar.com.hjg.pngj.DeflatedChunksSet
    public void g() {
        super.g();
        this.f = null;
        this.g = null;
    }

    public void k() {
        b(this.j.m);
    }

    public int l() {
        int h;
        Deinterlacer deinterlacer = this.i;
        int i = 0;
        if (deinterlacer == null) {
            if (i() < this.h.b - 1) {
                h = this.h.k;
                i = h + 1;
            }
        } else if (deinterlacer.a()) {
            h = this.i.h();
            i = h + 1;
        }
        if (!j()) {
            a(i);
        }
        return i;
    }
}
