package ar.com.hjg.pngj;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ImageInfo.class */
public class ImageInfo {

    /* renamed from: a  reason: collision with root package name */
    public final int f3638a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3639c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    private long n = -1;
    private long o = -1;

    public ImageInfo(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.f3638a = i;
        this.b = i2;
        this.e = z;
        this.g = z3;
        this.f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f3639c = i3;
        boolean z4 = i3 < 8;
        this.h = z4;
        int i4 = this.d;
        int i5 = this.f3639c * i4;
        this.i = i5;
        this.j = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.k = i6;
        int i7 = i4 * this.f3638a;
        this.l = i7;
        this.m = z4 ? i6 : i7;
        int i8 = this.f3639c;
        if (i8 == 1 || i8 == 2 || i8 == 4) {
            if (!this.g && !this.f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f3639c);
            }
        } else if (i8 != 8) {
            if (i8 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f3639c);
            } else if (this.g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f3639c);
            }
        }
        if (i < 1 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        } else if (i2 >= 1 && i2 <= 16777216) {
            if (this.l < 1) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ImageInfo imageInfo = (ImageInfo) obj;
            return this.e == imageInfo.e && this.f3639c == imageInfo.f3639c && this.f3638a == imageInfo.f3638a && this.f == imageInfo.f && this.g == imageInfo.g && this.b == imageInfo.b;
        }
        return false;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = this.e ? 1231 : 1237;
        int i3 = this.f3639c;
        int i4 = this.f3638a;
        int i5 = this.f ? 1231 : 1237;
        if (!this.g) {
            i = 1237;
        }
        return ((((((((((i2 + 31) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i) * 31) + this.b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f3638a + ", rows=" + this.b + ", bitDepth=" + this.f3639c + ", channels=" + this.d + ", alpha=" + this.e + ", greyscale=" + this.f + ", indexed=" + this.g + "]";
    }
}
