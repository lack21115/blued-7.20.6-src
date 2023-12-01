package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/a/c.class */
public final class c extends CancellationToken {

    /* renamed from: a  reason: collision with root package name */
    public final List<Runnable> f22360a = new ArrayList();
    public final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public boolean f22361c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.f22361c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken register(Runnable runnable) {
        synchronized (this.b) {
            if (this.f22361c) {
                runnable.run();
            } else {
                this.f22360a.add(runnable);
            }
        }
        return this;
    }
}
