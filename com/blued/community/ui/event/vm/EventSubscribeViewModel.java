package com.blued.community.ui.event.vm;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.ui.event.model.PersonalEventModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/vm/EventSubscribeViewModel.class */
public final class EventSubscribeViewModel extends BaseListViewModel<PersonalEventModel> {
    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        EventHttpUtils.f19079a.a(new BluedUIHttpResponse<BluedEntityA<PersonalEventModel>>() { // from class: com.blued.community.ui.event.vm.EventSubscribeViewModel$requestData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PersonalEventModel> result) {
                Intrinsics.e(result, "result");
                EventSubscribeViewModel.this.loadListSucceed(result.data, result.hasMore());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                EventSubscribeViewModel.this.loadListFailed();
            }
        }, getMPage(), getMPageSize(), (IRequestHost) null);
    }
}
