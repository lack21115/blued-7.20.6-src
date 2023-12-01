package com.blued.android.module.media.selector.model;

import com.blued.android.module.media.selector.contract.IBaseCallback;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/model/BaseModel.class */
public abstract class BaseModel<T extends IBaseCallback> {
    protected T a;

    public BaseModel(T t) {
        this.a = t;
    }

    public void d() {
        this.a = null;
    }
}
