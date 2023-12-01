package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/ResolveResult.class */
public class ResolveResult<T> extends Result {
    private T entity;

    public ResolveResult() {
        this.entity = null;
    }

    public ResolveResult(T t) {
        this.entity = t;
    }

    public T getValue() {
        return this.entity;
    }
}
