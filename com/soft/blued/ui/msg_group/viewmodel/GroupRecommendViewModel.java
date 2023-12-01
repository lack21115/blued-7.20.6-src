package com.soft.blued.ui.msg_group.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.group.GroupInfoModel;
import com.soft.blued.ui.msg_group.fragment.RecommendGroupFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupRecommendViewModel.class */
public final class GroupRecommendViewModel extends BaseListViewModel<GroupInfoModel> {

    /* renamed from: a  reason: collision with root package name */
    private RecommendGroupFragment.RecommendType f32856a = RecommendGroupFragment.RecommendType.NEARBY;

    public final void a(RecommendGroupFragment.RecommendType recommendType) {
        Intrinsics.e(recommendType, "<set-?>");
        this.f32856a = recommendType;
    }

    public final RecommendGroupFragment.RecommendType getType() {
        return this.f32856a;
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new GroupRecommendViewModel$requestData$1(this, null), 3, null);
    }
}
