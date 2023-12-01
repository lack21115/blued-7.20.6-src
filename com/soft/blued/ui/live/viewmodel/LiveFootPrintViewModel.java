package com.soft.blued.ui.live.viewmodel;

import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.live_china.model.LiveFootPrintModel;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/viewmodel/LiveFootPrintViewModel.class */
public final class LiveFootPrintViewModel extends BaseListViewModel<LiveFootPrintModel> {
    public final void a(boolean z) {
        if (z) {
            setMPage(1);
        }
    }

    public void requestData() {
        a(true);
    }
}
