package ar.com.hjg.pngj;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/RowInfo.class */
class RowInfo {

    /* renamed from: a  reason: collision with root package name */
    public final ImageInfo f3650a;
    public final Deinterlacer b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3651c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;
    int m;
    int n;
    byte[] o;
    int p;

    public RowInfo(ImageInfo imageInfo, Deinterlacer deinterlacer) {
        this.f3650a = imageInfo;
        this.b = deinterlacer;
        this.f3651c = deinterlacer != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i) {
        this.o = bArr;
        this.p = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(int i) {
        this.h = i;
        if (this.f3651c) {
            this.n = this.b.d();
            this.e = this.b.f3632c;
            this.d = this.b.b;
            this.g = this.b.e;
            this.f = this.b.d;
            this.i = this.b.c();
            this.j = this.b.b();
            this.k = this.b.e();
            this.l = this.b.f();
            this.m = ((this.f3650a.i * this.l) + 7) / 8;
            return;
        }
        this.n = 1;
        this.d = 1;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.j = i;
        this.i = i;
        this.k = this.f3650a.b;
        this.l = this.f3650a.f3638a;
        this.m = this.f3650a.k;
    }
}
