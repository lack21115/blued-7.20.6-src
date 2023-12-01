package com.blued.android.module.media.selector.model;

import com.blued.android.module.media.selector.contract.IBaseCallback;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/model/BaseModel.class */
public abstract class BaseModel<T extends IBaseCallback> {

    /* renamed from: a  reason: collision with root package name */
    protected T f15566a;

    public BaseModel(T t) {
        this.f15566a = t;
    }

    public void d() {
        this.f15566a = null;
    }
}
