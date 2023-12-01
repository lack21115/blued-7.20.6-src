package com.soft.blued.ui.msg.viewModel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.msg.state.HelloCallAction;
import com.soft.blued.ui.msg.state.HelloCallState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/HelloCallViewModel.class */
public final class HelloCallViewModel extends MVIBaseViewModel<HelloCallState, HelloCallAction> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f32608a;

    public final void a(HelloCallAction.GetHelloCallData action) {
        Intrinsics.e(action, "action");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new HelloCallViewModel$getCallData$1(action, this, null), 3, null);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(HelloCallAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof HelloCallAction.GetHelloCallData) {
            a((HelloCallAction.GetHelloCallData) action);
        }
    }
}
