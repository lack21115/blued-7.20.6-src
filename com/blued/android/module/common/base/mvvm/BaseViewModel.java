package com.blued.android.module.common.base.mvvm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.blued.android.framework.utils.Logger;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvvm/BaseViewModel.class */
public abstract class BaseViewModel extends ViewModel {
    private final MutableLiveData<LoadState> a = new MutableLiveData<>();
    private final MutableLiveData<HasMoreState> b = new MutableLiveData<>();
    private final MutableLiveData<Void> c = new MutableLiveData<>();

    public final MutableLiveData<LoadState> a() {
        return this.a;
    }

    public void a(Bundle bundle) {
    }

    public final void a(boolean z) {
        if (z) {
            this.a.postValue(LoadState.LoadSuccess);
        } else {
            this.a.postValue(LoadState.LoadFail);
        }
    }

    public final MutableLiveData<HasMoreState> b() {
        return this.b;
    }

    public final void b(boolean z) {
        Logger.c("baseList", getClass().getName() + "hasMore: " + z);
        if (z) {
            this.b.postValue(HasMoreState.HasMore);
        } else {
            this.b.postValue(HasMoreState.NoMore);
        }
    }

    public final MutableLiveData<Void> c() {
        return this.c;
    }

    public void onCleared() {
        Logger.c("BaseViewModel", getClass().getName() + this + " onCleared()");
        super.onCleared();
    }
}
