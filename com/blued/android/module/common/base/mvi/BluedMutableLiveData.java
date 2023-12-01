package com.blued.android.module.common.base.mvi;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BluedMutableLiveData.class */
public class BluedMutableLiveData<T> extends BluedLiveData<T> {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BluedMutableLiveData$Builder.class */
    public static class Builder<T> {
    }

    public BluedMutableLiveData() {
    }

    public BluedMutableLiveData(T t) {
        super(t);
    }

    @Override // androidx.lifecycle.LiveData
    public void postValue(T t) {
        super.postValue(t);
    }

    @Override // com.blued.android.module.common.base.mvi.BluedLiveData, androidx.lifecycle.LiveData
    public void setValue(T t) {
        super.setValue(t);
    }
}
