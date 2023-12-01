package ar.com.hjg.pngj;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/Deinterlacer.class */
public class Deinterlacer {

    /* renamed from: a  reason: collision with root package name */
    final ImageInfo f3583a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f3584c;
    int d;
    int e;
    int f;
    int g;
    private int j;
    private int k;
    private boolean o;
    private int i = 0;
    private int l = -1;
    private int m = -1;
    private int n = 0;
    int h = 0;

    public Deinterlacer(ImageInfo imageInfo) {
        this.o = false;
        this.f3583a = imageInfo;
        this.o = false;
        a(1);
        c(0);
    }

    static byte[] b(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjExceptionInternal("bad interlace pass" + i);
        }
    }

    private void c(int i) {
        this.l = i;
        int i2 = (i * this.b) + this.d;
        this.m = i2;
        if (i2 < 0 || i2 >= this.f3583a.b) {
            throw new PngjExceptionInternal("bad row - this should not happen");
        }
    }

    void a(int i) {
        int i2;
        int i3;
        if (this.i == i) {
            return;
        }
        this.i = i;
        byte[] b = b(i);
        this.f3584c = b[0];
        this.b = b[1];
        this.e = b[2];
        this.d = b[3];
        if (this.f3583a.b > this.d) {
            int i4 = this.f3583a.b;
            int i5 = this.b;
            i2 = (((i4 + i5) - 1) - this.d) / i5;
        } else {
            i2 = 0;
        }
        this.j = i2;
        if (this.f3583a.f3590a > this.e) {
            int i6 = this.f3583a.f3590a;
            int i7 = this.f3584c;
            i3 = (((i6 + i7) - 1) - this.e) / i7;
        } else {
            i3 = 0;
        }
        this.k = i3;
        if (i3 == 0) {
            this.j = 0;
        }
        this.g = this.f3584c * this.f3583a.d;
        this.f = this.e * this.f3583a.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        int i;
        this.n++;
        int i2 = this.j;
        if (i2 != 0 && (i = this.l) < i2 - 1) {
            c(i + 1);
            return true;
        }
        int i3 = this.i;
        if (i3 == 7) {
            this.o = true;
            return false;
        }
        a(i3 + 1);
        if (this.j == 0) {
            this.n--;
            return a();
        }
        c(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.k;
    }

    public int g() {
        return f();
    }

    public int h() {
        return ((this.f3583a.i * g()) + 7) / 8;
    }
}
