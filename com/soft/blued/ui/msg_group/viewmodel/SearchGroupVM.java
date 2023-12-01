package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.group.GroupInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/SearchGroupVM.class */
public final class SearchGroupVM extends BaseListViewModel<GroupInfoModel> {

    /* renamed from: a  reason: collision with root package name */
    private String f32868a = "";

    public final void a(String words) {
        Intrinsics.e(words, "words");
        this.f32868a = words;
        refreshData();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new SearchGroupVM$requestData$1(this, null), 3, null);
    }
}
