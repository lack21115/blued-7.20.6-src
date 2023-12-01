package com.tramini.plugin.a.g.b;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/b/b.class */
public abstract class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private int f26851a = 0;

    public abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.f26851a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
