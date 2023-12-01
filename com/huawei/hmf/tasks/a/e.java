package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/a/e.class */
final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f8757a = new Object();
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final i<Void> f8758c;
    private int d;
    private Exception e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, i<Void> iVar) {
        this.b = i;
        this.f8758c = iVar;
    }

    private void a() {
        if (this.d >= this.b) {
            if (this.e != null) {
                this.f8758c.a(new ExecutionException("a task failed", this.e));
            } else if (this.f) {
                this.f8758c.a();
            } else {
                this.f8758c.a((i<Void>) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.f8757a) {
            this.d++;
            this.f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f8757a) {
            this.d++;
            this.e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.f8757a) {
            this.d++;
            a();
        }
    }
}
