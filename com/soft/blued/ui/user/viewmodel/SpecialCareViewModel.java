package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.user.state.SpecialCareAction;
import com.soft.blued.ui.user.state.SpecialCareState;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/SpecialCareViewModel.class */
public final class SpecialCareViewModel extends MVIBaseViewModel<SpecialCareState, SpecialCareAction> {
    private final void a(SpecialCareAction.cancelSpecialCareUser cancelspecialcareuser) {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new SpecialCareViewModel$cancelSpecialCareUser$1(cancelspecialcareuser, null), 3, (Object) null);
    }

    private final void a(SpecialCareAction.getSpecialCareData getspecialcaredata) {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new SpecialCareViewModel$getSpecialCareListData$1(getspecialcaredata, this, null), 3, (Object) null);
    }

    /* renamed from: a */
    public void dispatchAction(SpecialCareAction specialCareAction) {
        Intrinsics.e(specialCareAction, "action");
        if (specialCareAction instanceof SpecialCareAction.getSpecialCareData) {
            a((SpecialCareAction.getSpecialCareData) specialCareAction);
        } else if (specialCareAction instanceof SpecialCareAction.cancelSpecialCareUser) {
            a((SpecialCareAction.cancelSpecialCareUser) specialCareAction);
        }
    }
}
