package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.group.GroupInfoModel;
import com.soft.blued.ui.msg_group.fragment.RecommendGroupFragment;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupRecommendViewModel.class */
public final class GroupRecommendViewModel extends BaseListViewModel<GroupInfoModel> {

    /* renamed from: a  reason: collision with root package name */
    private RecommendGroupFragment.RecommendType f19165a = RecommendGroupFragment.RecommendType.NEARBY;

    public final void a(RecommendGroupFragment.RecommendType recommendType) {
        Intrinsics.e(recommendType, "<set-?>");
        this.f19165a = recommendType;
    }

    public final RecommendGroupFragment.RecommendType getType() {
        return this.f19165a;
    }

    public void requestData() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GroupRecommendViewModel$requestData$1(this, null), 3, (Object) null);
    }
}
