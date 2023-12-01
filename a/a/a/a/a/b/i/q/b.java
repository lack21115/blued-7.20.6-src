package a.a.a.a.a.b.i.q;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/q/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Thread f1339a = Thread.currentThread();

    public void a() {
        if (this.f1339a == null) {
            this.f1339a = Thread.currentThread();
        }
        if (Thread.currentThread() != this.f1339a) {
            throw new IllegalStateException("Wrong thread");
        }
    }
}
