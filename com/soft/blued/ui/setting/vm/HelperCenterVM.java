package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/HelperCenterVM.class */
public final class HelperCenterVM extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<Boolean> f33647a = new MutableLiveData<>();

    public final MutableLiveData<Boolean> d() {
        return this.f33647a;
    }

    public final void e() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new HelperCenterVM$getFinanceOpe$1(this, null), 3, null);
    }
}
