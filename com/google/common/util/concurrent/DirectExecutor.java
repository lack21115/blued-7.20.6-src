package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/DirectExecutor.class */
enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
