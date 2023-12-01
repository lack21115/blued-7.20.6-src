package com.soft.blued.ui.mine.vm;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.mine.state.TouristAction;
import com.soft.blued.ui.mine.state.TouristState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/vm/TouristVM.class */
public final class TouristVM extends MVIBaseViewModel<TouristState, TouristAction> {
    private final void a() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new TouristVM$getData$1(this, null), 3, null);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(TouristAction action) {
        Intrinsics.e(action, "action");
        if (Intrinsics.a(action, TouristAction.GetData.f31642a)) {
            a();
        }
    }
}
