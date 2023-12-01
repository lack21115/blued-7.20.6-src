package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.group.GroupInfoModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/MyGroupAllVM.class */
public final class MyGroupAllVM extends BaseListViewModel<GroupInfoModel> {
    public void requestData() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new MyGroupAllVM$requestData$1(this, null), 3, (Object) null);
    }
}
