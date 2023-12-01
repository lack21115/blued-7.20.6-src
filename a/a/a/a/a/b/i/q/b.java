package a.a.a.a.a.b.i.q;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/q/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Thread f1291a = Thread.currentThread();

    public void a() {
        if (this.f1291a == null) {
            this.f1291a = Thread.currentThread();
        }
        if (Thread.currentThread() != this.f1291a) {
            throw new IllegalStateException("Wrong thread");
        }
    }
}
