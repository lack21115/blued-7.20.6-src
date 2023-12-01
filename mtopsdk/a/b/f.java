package mtopsdk.a.b;

import java.io.OutputStream;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/b/f.class */
final class f extends d {
    private /* synthetic */ String a;
    private /* synthetic */ int b;
    private /* synthetic */ byte[] c;
    private /* synthetic */ int d;

    @Override // mtopsdk.a.b.d
    public final String a() {
        return this.a;
    }

    @Override // mtopsdk.a.b.d
    public final void a(OutputStream outputStream) {
        outputStream.write(this.c, this.d, this.b);
    }

    @Override // mtopsdk.a.b.d
    public final long b() {
        return this.b;
    }
}
