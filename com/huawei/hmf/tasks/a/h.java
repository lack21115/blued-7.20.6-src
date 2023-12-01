package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/a/h.class */
public final class h<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private OnSuccessListener<TResult> f22371a;
    private Executor b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f22372c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f22371a = onSuccessListener;
        this.b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f22372c) {
            this.f22371a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.h.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (h.this.f22372c) {
                    if (h.this.f22371a != null) {
                        h.this.f22371a.onSuccess(task.getResult());
                    }
                }
            }
        });
    }
}
