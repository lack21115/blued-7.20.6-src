package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/a/d.class */
public final class d<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a  reason: collision with root package name */
    Executor f22362a;
    private OnCompleteListener<TResult> b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f22363c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.b = onCompleteListener;
        this.f22362a = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f22363c) {
            this.b = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        this.f22362a.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (d.this.f22363c) {
                    if (d.this.b != null) {
                        d.this.b.onComplete(task);
                    }
                }
            }
        });
    }
}
