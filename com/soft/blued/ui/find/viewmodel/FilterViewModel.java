package com.soft.blued.ui.find.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.find.state.FilterAction;
import com.soft.blued.ui.find.state.FilterState;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/viewmodel/FilterViewModel.class */
public final class FilterViewModel extends MVIBaseViewModel<FilterState, FilterAction> {
    private final void a() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new FilterViewModel$getUserTagsAllData$1(this, null), 3, (Object) null);
    }

    /* renamed from: a */
    public void dispatchAction(FilterAction filterAction) {
        Intrinsics.e(filterAction, "action");
        if (filterAction instanceof FilterAction.GetFilterData) {
            a();
        }
    }
}
