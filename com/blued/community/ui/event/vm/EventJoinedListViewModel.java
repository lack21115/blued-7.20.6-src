package com.blued.community.ui.event.vm;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.ui.event.model.EventDetailsModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/vm/EventJoinedListViewModel.class */
public final class EventJoinedListViewModel extends BaseListViewModel<EventDetailsModel> {
    public final void a() {
        EventHttpUtils.f19079a.a(new BluedUIHttpResponse<BluedEntityA<EventDetailsModel>>() { // from class: com.blued.community.ui.event.vm.EventJoinedListViewModel$getEventListData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventDetailsModel> result) {
                Intrinsics.e(result, "result");
                EventJoinedListViewModel.this.loadListSucceed(result.data, result.hasMore());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                EventJoinedListViewModel.this.loadListFailed();
            }
        }, getMPage(), "join", (IRequestHost) null);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        a();
    }
}
