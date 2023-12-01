package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/ExecutorCompat.class */
public final class ExecutorCompat {

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/os/ExecutorCompat$HandlerExecutor.class */
    static class HandlerExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f2459a;

        HandlerExecutor(Handler handler) {
            this.f2459a = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f2459a.post((Runnable) Preconditions.checkNotNull(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f2459a + " is shutting down");
        }
    }

    private ExecutorCompat() {
    }

    public static Executor create(Handler handler) {
        return new HandlerExecutor(handler);
    }
}
