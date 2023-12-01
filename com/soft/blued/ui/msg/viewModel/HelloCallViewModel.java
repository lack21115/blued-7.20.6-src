package com.soft.blued.ui.msg.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.msg.state.HelloCallAction;
import com.soft.blued.ui.msg.state.HelloCallState;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/HelloCallViewModel.class */
public final class HelloCallViewModel extends MVIBaseViewModel<HelloCallState, HelloCallAction> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f18917a;

    public final void a(HelloCallAction.GetHelloCallData getHelloCallData) {
        Intrinsics.e(getHelloCallData, "action");
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new HelloCallViewModel$getCallData$1(getHelloCallData, this, null), 3, (Object) null);
    }

    /* renamed from: a */
    public void dispatchAction(HelloCallAction helloCallAction) {
        Intrinsics.e(helloCallAction, "action");
        if (helloCallAction instanceof HelloCallAction.GetHelloCallData) {
            a((HelloCallAction.GetHelloCallData) helloCallAction);
        }
    }
}
