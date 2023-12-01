package com.blued.android.module.common.base.mvi;

import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BaseListViewModel.class */
public abstract class BaseListViewModel<M> extends MVIBaseViewModel<BaseListState<M>, UiAction> {
    private int mPage;
    private int mPageSize = 20;

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    public void dispatchAction(UiAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof BaseListAction.RefreshData) {
            refreshData();
        } else if (action instanceof BaseListAction.LoadMoreData) {
            loadMoreData();
        }
    }

    public final int getMPage() {
        return this.mPage;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    public final void loadListFailed() {
        BluedStructureExtKt.a(this, new MviEvent.LoadFinished(false, false));
    }

    public final void loadListSucceed(List<? extends M> list, boolean z) {
        BaseListViewModel<M> baseListViewModel = this;
        BluedStructureExtKt.a(baseListViewModel, new MviEvent.LoadData(list));
        BluedStructureExtKt.a(baseListViewModel, new MviEvent.LoadFinished(true, z));
    }

    protected void loadMoreData() {
        this.mPage++;
        requestData();
    }

    public void refreshData() {
        BluedStructureExtKt.a(this, MviEvent.LoadStarted.f10685a);
        this.mPage = 1;
        requestData();
    }

    protected abstract void requestData();

    public final void setMPage(int i) {
        this.mPage = i;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }
}
