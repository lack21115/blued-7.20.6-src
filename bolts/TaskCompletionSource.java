package bolts;

/* loaded from: source-8756600-dex2jar.jar:bolts/TaskCompletionSource.class */
public class TaskCompletionSource<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Task<TResult> f3670a = new Task<>();

    public Task<TResult> a() {
        return this.f3670a;
    }

    public boolean a(Exception exc) {
        return this.f3670a.b(exc);
    }

    public boolean a(TResult tresult) {
        return this.f3670a.b((Task<TResult>) tresult);
    }

    public void b(Exception exc) {
        if (!a(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public boolean b() {
        return this.f3670a.i();
    }

    public void c() {
        if (!b()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void setResult(TResult tresult) {
        if (!a((TaskCompletionSource<TResult>) tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }
}
