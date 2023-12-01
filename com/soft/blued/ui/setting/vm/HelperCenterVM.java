package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/HelperCenterVM.class */
public final class HelperCenterVM extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<Boolean> f19956a = new MutableLiveData<>();

    public final MutableLiveData<Boolean> d() {
        return this.f19956a;
    }

    public final void e() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new HelperCenterVM$getFinanceOpe$1(this, null), 3, (Object) null);
    }
}
