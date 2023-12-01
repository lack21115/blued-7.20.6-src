package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.group.GroupInfoModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupCreateViewModel.class */
public final class GroupCreateViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<GroupInfoModel> f19149a = new MutableLiveData<>();
    private final MutableLiveData<String> b = new MutableLiveData<>();

    public final void a(Map<String, String> map) {
        Intrinsics.e(map, "params");
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GroupCreateViewModel$createGroup$1(map, this, null), 3, (Object) null);
    }

    public final MutableLiveData<GroupInfoModel> d() {
        return this.f19149a;
    }

    public final MutableLiveData<String> e() {
        return this.b;
    }

    public final void f() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GroupCreateViewModel$getCityCode$1(this, null), 3, (Object) null);
    }
}
