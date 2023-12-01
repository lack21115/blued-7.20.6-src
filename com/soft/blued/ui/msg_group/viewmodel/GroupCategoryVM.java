package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.group.GroupCategoryModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupCategoryVM.class */
public final class GroupCategoryVM extends BaseListViewModel<GroupCategoryModel> {

    /* renamed from: a  reason: collision with root package name */
    private GroupCategoryModel f19147a;

    public final GroupCategoryModel a() {
        return this.f19147a;
    }

    public final void a(GroupCategoryModel groupCategoryModel) {
        this.f19147a = groupCategoryModel;
    }

    public void requestData() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GroupCategoryVM$requestData$1(this, null), 3, (Object) null);
    }
}
