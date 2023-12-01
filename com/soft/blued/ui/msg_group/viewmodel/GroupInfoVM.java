package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupInfoVM.class */
public final class GroupInfoVM extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<String> f19158a = new MutableLiveData<>();
    private final MutableLiveData<GroupPrivilegeModel> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Integer> f19159c = new MutableLiveData<>();

    public final void a(String str) {
        Intrinsics.e(str, "gid");
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GroupInfoVM$upgradeGroup$1(str, this, null), 3, (Object) null);
    }

    public final void b(String str) {
        Intrinsics.e(str, "gid");
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GroupInfoVM$degradeGroup$1(str, this, null), 3, (Object) null);
    }

    public final MutableLiveData<String> d() {
        return this.f19158a;
    }

    public final MutableLiveData<GroupPrivilegeModel> e() {
        return this.b;
    }

    public final MutableLiveData<Integer> f() {
        return this.f19159c;
    }

    public final void g() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GroupInfoVM$getPrivilege$1(this, null), 3, (Object) null);
    }
}
