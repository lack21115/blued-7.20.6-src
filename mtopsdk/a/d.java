package mtopsdk.a;

import java.io.InputStream;
import mtopsdk.a.b.i;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/d.class */
final class d extends i {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f43673a;
    private /* synthetic */ InputStream b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, int i, InputStream inputStream) {
        this.f43673a = i;
        this.b = inputStream;
    }

    @Override // mtopsdk.a.b.i
    public final long a() {
        return this.f43673a;
    }

    @Override // mtopsdk.a.b.i
    public final InputStream b() {
        return this.b;
    }
}
