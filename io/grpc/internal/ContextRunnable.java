package io.grpc.internal;

import io.grpc.Context;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ContextRunnable.class */
abstract class ContextRunnable implements Runnable {
    private final Context context;

    /* JADX INFO: Access modifiers changed from: protected */
    public ContextRunnable(Context context) {
        this.context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context attach = this.context.attach();
        try {
            runInContext();
        } finally {
            this.context.detach(attach);
        }
    }

    public abstract void runInContext();
}
