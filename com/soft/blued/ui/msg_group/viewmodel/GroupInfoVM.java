package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupInfoVM.class */
public final class GroupInfoVM extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<String> f32849a = new MutableLiveData<>();
    private final MutableLiveData<GroupPrivilegeModel> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Integer> f32850c = new MutableLiveData<>();

    public final void a(String gid) {
        Intrinsics.e(gid, "gid");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new GroupInfoVM$upgradeGroup$1(gid, this, null), 3, null);
    }

    public final void b(String gid) {
        Intrinsics.e(gid, "gid");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new GroupInfoVM$degradeGroup$1(gid, this, null), 3, null);
    }

    public final MutableLiveData<String> d() {
        return this.f32849a;
    }

    public final MutableLiveData<GroupPrivilegeModel> e() {
        return this.b;
    }

    public final MutableLiveData<Integer> f() {
        return this.f32850c;
    }

    public final void g() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new GroupInfoVM$getPrivilege$1(this, null), 3, null);
    }
}
