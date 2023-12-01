package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/TaskApiCallWrapper.class */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f9058a;
    private final TaskCompletionSource<TResult> b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.f9058a = taskApiCall;
        this.b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f9058a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.b;
    }
}
