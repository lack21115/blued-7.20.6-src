package bolts;

import bolts.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:bolts/UnobservedErrorNotifier.class */
public class UnobservedErrorNotifier {

    /* renamed from: a  reason: collision with root package name */
    private Task<?> f3671a;

    public UnobservedErrorNotifier(Task<?> task) {
        this.f3671a = task;
    }

    public void a() {
        this.f3671a = null;
    }

    protected void finalize() throws Throwable {
        Task.UnobservedExceptionHandler a2;
        try {
            Task<?> task = this.f3671a;
            if (task != null && (a2 = Task.a()) != null) {
                a2.a(task, new UnobservedTaskException(task.f()));
            }
        } finally {
            super.finalize();
        }
    }
}
