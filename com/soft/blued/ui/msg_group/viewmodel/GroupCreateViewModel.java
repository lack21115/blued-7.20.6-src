package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.group.GroupInfoModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupCreateViewModel.class */
public final class GroupCreateViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<GroupInfoModel> f32840a = new MutableLiveData<>();
    private final MutableLiveData<String> b = new MutableLiveData<>();

    public final void a(Map<String, String> params) {
        Intrinsics.e(params, "params");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new GroupCreateViewModel$createGroup$1(params, this, null), 3, null);
    }

    public final MutableLiveData<GroupInfoModel> d() {
        return this.f32840a;
    }

    public final MutableLiveData<String> e() {
        return this.b;
    }

    public final void f() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new GroupCreateViewModel$getCityCode$1(this, null), 3, null);
    }
}
