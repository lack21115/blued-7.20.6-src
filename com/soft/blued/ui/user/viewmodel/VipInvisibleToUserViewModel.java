package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.user.state.VipInvisibleToUserAction;
import com.soft.blued.ui.user.state.VipInvisibleToUserState;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VipInvisibleToUserViewModel.class */
public final class VipInvisibleToUserViewModel extends MVIBaseViewModel<VipInvisibleToUserState, VipInvisibleToUserAction> {
    public final void a(VipInvisibleToUserAction.cancelInvisibleUser cancelinvisibleuser) {
        Intrinsics.e(cancelinvisibleuser, "action");
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new VipInvisibleToUserViewModel$cancelInvisibleUser$1(cancelinvisibleuser, null), 3, (Object) null);
    }

    public final void a(VipInvisibleToUserAction.getInvisibleUserData getinvisibleuserdata) {
        Intrinsics.e(getinvisibleuserdata, "action");
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new VipInvisibleToUserViewModel$getUserInvisibleData$1(getinvisibleuserdata, this, null), 3, (Object) null);
    }

    /* renamed from: a */
    public void dispatchAction(VipInvisibleToUserAction vipInvisibleToUserAction) {
        Intrinsics.e(vipInvisibleToUserAction, "action");
        if (vipInvisibleToUserAction instanceof VipInvisibleToUserAction.getInvisibleUserData) {
            a((VipInvisibleToUserAction.getInvisibleUserData) vipInvisibleToUserAction);
        } else if (vipInvisibleToUserAction instanceof VipInvisibleToUserAction.cancelInvisibleUser) {
            a((VipInvisibleToUserAction.cancelInvisibleUser) vipInvisibleToUserAction);
        }
    }
}
