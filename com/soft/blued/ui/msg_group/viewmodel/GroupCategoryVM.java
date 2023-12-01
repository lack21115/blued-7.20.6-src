package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.group.GroupCategoryModel;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupCategoryVM.class */
public final class GroupCategoryVM extends BaseListViewModel<GroupCategoryModel> {

    /* renamed from: a  reason: collision with root package name */
    private GroupCategoryModel f32838a;

    public final GroupCategoryModel a() {
        return this.f32838a;
    }

    public final void a(GroupCategoryModel groupCategoryModel) {
        this.f32838a = groupCategoryModel;
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new GroupCategoryVM$requestData$1(this, null), 3, null);
    }
}
