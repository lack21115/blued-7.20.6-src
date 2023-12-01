package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/CancellationTokenSource.class */
public class CancellationTokenSource {
    private c impl = new c();

    public void cancel() {
        c cVar = this.impl;
        if (cVar.f8753c) {
            return;
        }
        synchronized (cVar.b) {
            cVar.f8753c = true;
            for (Runnable runnable : cVar.f8752a) {
                runnable.run();
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
