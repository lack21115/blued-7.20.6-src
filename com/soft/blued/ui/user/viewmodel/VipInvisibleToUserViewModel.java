package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.user.state.VipInvisibleToUserAction;
import com.soft.blued.ui.user.state.VipInvisibleToUserState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VipInvisibleToUserViewModel.class */
public final class VipInvisibleToUserViewModel extends MVIBaseViewModel<VipInvisibleToUserState, VipInvisibleToUserAction> {
    public final void a(VipInvisibleToUserAction.cancelInvisibleUser action) {
        Intrinsics.e(action, "action");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new VipInvisibleToUserViewModel$cancelInvisibleUser$1(action, null), 3, null);
    }

    public final void a(VipInvisibleToUserAction.getInvisibleUserData action) {
        Intrinsics.e(action, "action");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new VipInvisibleToUserViewModel$getUserInvisibleData$1(action, this, null), 3, null);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(VipInvisibleToUserAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof VipInvisibleToUserAction.getInvisibleUserData) {
            a((VipInvisibleToUserAction.getInvisibleUserData) action);
        } else if (action instanceof VipInvisibleToUserAction.cancelInvisibleUser) {
            a((VipInvisibleToUserAction.cancelInvisibleUser) action);
        }
    }
}
