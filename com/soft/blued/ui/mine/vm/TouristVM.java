package com.soft.blued.ui.mine.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.mine.state.TouristAction;
import com.soft.blued.ui.mine.state.TouristState;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/vm/TouristVM.class */
public final class TouristVM extends MVIBaseViewModel<TouristState, TouristAction> {
    private final void a() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new TouristVM$getData$1(this, null), 3, (Object) null);
    }

    /* renamed from: a */
    public void dispatchAction(TouristAction touristAction) {
        Intrinsics.e(touristAction, "action");
        if (Intrinsics.a(touristAction, TouristAction.GetData.f17952a)) {
            a();
        }
    }
}
