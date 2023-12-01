package mtopsdk.a.b;

import java.io.OutputStream;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/b/f.class */
final class f extends d {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f43664a;
    private /* synthetic */ int b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ byte[] f43665c;
    private /* synthetic */ int d;

    @Override // mtopsdk.a.b.d
    public final String a() {
        return this.f43664a;
    }

    @Override // mtopsdk.a.b.d
    public final void a(OutputStream outputStream) {
        outputStream.write(this.f43665c, this.d, this.b);
    }

    @Override // mtopsdk.a.b.d
    public final long b() {
        return this.b;
    }
}
