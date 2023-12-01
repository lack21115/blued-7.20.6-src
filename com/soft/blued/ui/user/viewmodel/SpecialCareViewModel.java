package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.user.state.SpecialCareAction;
import com.soft.blued.ui.user.state.SpecialCareState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/SpecialCareViewModel.class */
public final class SpecialCareViewModel extends MVIBaseViewModel<SpecialCareState, SpecialCareAction> {
    private final void a(SpecialCareAction.cancelSpecialCareUser cancelspecialcareuser) {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new SpecialCareViewModel$cancelSpecialCareUser$1(cancelspecialcareuser, null), 3, null);
    }

    private final void a(SpecialCareAction.getSpecialCareData getspecialcaredata) {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new SpecialCareViewModel$getSpecialCareListData$1(getspecialcaredata, this, null), 3, null);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(SpecialCareAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof SpecialCareAction.getSpecialCareData) {
            a((SpecialCareAction.getSpecialCareData) action);
        } else if (action instanceof SpecialCareAction.cancelSpecialCareUser) {
            a((SpecialCareAction.cancelSpecialCareUser) action);
        }
    }
}
