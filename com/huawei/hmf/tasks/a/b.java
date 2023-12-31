package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/a/b.class */
public final class b<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private OnCanceledListener f8749a;
    private Executor b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f8750c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Executor executor, OnCanceledListener onCanceledListener) {
        this.f8749a = onCanceledListener;
        this.b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f8750c) {
            this.f8749a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this.f8750c) {
                        if (b.this.f8749a != null) {
                            b.this.f8749a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
