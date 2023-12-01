package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.group.GroupInfoModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/SearchGroupVM.class */
public final class SearchGroupVM extends BaseListViewModel<GroupInfoModel> {

    /* renamed from: a  reason: collision with root package name */
    private String f19177a = "";

    public final void a(String str) {
        Intrinsics.e(str, "words");
        this.f19177a = str;
        refreshData();
    }

    public void requestData() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new SearchGroupVM$requestData$1(this, null), 3, (Object) null);
    }
}
