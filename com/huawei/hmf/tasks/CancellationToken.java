package com.huawei.hmf.tasks;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/CancellationToken.class */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    public abstract CancellationToken register(Runnable runnable);
}
