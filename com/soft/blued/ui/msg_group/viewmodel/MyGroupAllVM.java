package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.group.GroupInfoModel;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/MyGroupAllVM.class */
public final class MyGroupAllVM extends BaseListViewModel<GroupInfoModel> {
    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new MyGroupAllVM$requestData$1(this, null), 3, null);
    }
}
