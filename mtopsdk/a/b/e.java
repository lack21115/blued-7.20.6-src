package mtopsdk.a.b;

import java.io.OutputStream;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/b/e.class */
final class e extends d {
    private /* synthetic */ String a;
    private /* synthetic */ byte[] b;

    @Override // mtopsdk.a.b.d
    public final String a() {
        return this.a;
    }

    @Override // mtopsdk.a.b.d
    public final void a(OutputStream outputStream) {
        outputStream.write(this.b);
    }

    @Override // mtopsdk.a.b.d
    public final long b() {
        return this.b.length;
    }
}
