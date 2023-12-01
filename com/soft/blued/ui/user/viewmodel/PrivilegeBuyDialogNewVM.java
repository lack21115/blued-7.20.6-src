package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.user.state.PrivilegeBuyAction;
import com.soft.blued.ui.user.state.PrivilegeBuyState;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/PrivilegeBuyDialogNewVM.class */
public final class PrivilegeBuyDialogNewVM extends MVIBaseViewModel<PrivilegeBuyState, PrivilegeBuyAction> {
    private final void a(PrivilegeBuyAction.checUserPermission checuserpermission) {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new PrivilegeBuyDialogNewVM$checkUserPermission$1(checuserpermission, this, null), 3, (Object) null);
    }

    private final void a(PrivilegeBuyAction.getGoodsList getgoodslist) {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new PrivilegeBuyDialogNewVM$getGoodsData$1(getgoodslist, this, null), 3, (Object) null);
    }

    /* renamed from: a */
    public void dispatchAction(PrivilegeBuyAction privilegeBuyAction) {
        Intrinsics.e(privilegeBuyAction, "action");
        if (privilegeBuyAction instanceof PrivilegeBuyAction.getGoodsList) {
            a((PrivilegeBuyAction.getGoodsList) privilegeBuyAction);
        } else if (privilegeBuyAction instanceof PrivilegeBuyAction.checUserPermission) {
            a((PrivilegeBuyAction.checUserPermission) privilegeBuyAction);
        }
    }
}
