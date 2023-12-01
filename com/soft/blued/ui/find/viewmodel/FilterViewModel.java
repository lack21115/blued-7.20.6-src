package com.soft.blued.ui.find.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.find.state.FilterAction;
import com.soft.blued.ui.find.state.FilterState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/viewmodel/FilterViewModel.class */
public final class FilterViewModel extends MVIBaseViewModel<FilterState, FilterAction> {
    private final void a() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new FilterViewModel$getUserTagsAllData$1(this, null), 3, null);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(FilterAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof FilterAction.GetFilterData) {
            a();
        }
    }
}
