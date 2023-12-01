package com.kwad.sdk.utils.kwai;

import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/f.class */
public final class f implements Executor {
    private Runnable aCD;
    private Runnable aCE;

    private Runnable c(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.kwai.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleNext() {
        synchronized (this) {
            Runnable runnable = this.aCE;
            this.aCD = runnable;
            this.aCE = null;
            if (runnable != null) {
                d.getExecutor().execute(this.aCD);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this) {
            if (this.aCD == null) {
                this.aCD = c(runnable);
                d.getExecutor().execute(this.aCD);
                return;
            }
            if (this.aCE == null) {
                this.aCE = c(runnable);
            }
        }
    }
}
