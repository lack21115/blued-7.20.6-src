package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/a/f.class */
public final class f<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private OnFailureListener f8759a;
    private Executor b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f8760c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Executor executor, OnFailureListener onFailureListener) {
        this.f8759a = onFailureListener;
        this.b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f8760c) {
            this.f8759a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (f.this.f8760c) {
                    if (f.this.f8759a != null) {
                        f.this.f8759a.onFailure(task.getException());
                    }
                }
            }
        });
    }
}
