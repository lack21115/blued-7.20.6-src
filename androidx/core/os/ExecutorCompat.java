package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/ExecutorCompat.class */
public final class ExecutorCompat {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/os/ExecutorCompat$HandlerExecutor.class */
    public static class HandlerExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f2507a;

        HandlerExecutor(Handler handler) {
            this.f2507a = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f2507a.post((Runnable) Preconditions.checkNotNull(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f2507a + " is shutting down");
        }
    }

    private ExecutorCompat() {
    }

    public static Executor create(Handler handler) {
        return new HandlerExecutor(handler);
    }
}
