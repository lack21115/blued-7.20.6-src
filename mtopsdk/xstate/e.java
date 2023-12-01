package mtopsdk.xstate;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/xstate/e.class */
final class e extends mtopsdk.xstate.a.b {
    private /* synthetic */ d a;

    public e(d dVar) {
        this.a = dVar;
    }

    @Override // mtopsdk.xstate.a.a
    public final String a(String str) {
        return c.a(str);
    }

    @Override // mtopsdk.xstate.a.a
    public final void a() {
        c.a(this.a.getBaseContext());
    }

    @Override // mtopsdk.xstate.a.a
    public final void a(String str, String str2) {
        c.a(str, str2);
    }

    @Override // mtopsdk.xstate.a.a
    public final String b(String str) {
        return c.b(str);
    }

    @Override // mtopsdk.xstate.a.a
    public final void b() {
        c.a();
    }
}
