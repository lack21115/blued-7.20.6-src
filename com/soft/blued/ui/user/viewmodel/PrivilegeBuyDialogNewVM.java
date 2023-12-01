package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.user.state.PrivilegeBuyAction;
import com.soft.blued.ui.user.state.PrivilegeBuyState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/PrivilegeBuyDialogNewVM.class */
public final class PrivilegeBuyDialogNewVM extends MVIBaseViewModel<PrivilegeBuyState, PrivilegeBuyAction> {
    private final void a(PrivilegeBuyAction.checUserPermission checuserpermission) {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new PrivilegeBuyDialogNewVM$checkUserPermission$1(checuserpermission, this, null), 3, null);
    }

    private final void a(PrivilegeBuyAction.getGoodsList getgoodslist) {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new PrivilegeBuyDialogNewVM$getGoodsData$1(getgoodslist, this, null), 3, null);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(PrivilegeBuyAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof PrivilegeBuyAction.getGoodsList) {
            a((PrivilegeBuyAction.getGoodsList) action);
        } else if (action instanceof PrivilegeBuyAction.checUserPermission) {
            a((PrivilegeBuyAction.checUserPermission) action);
        }
    }
}
