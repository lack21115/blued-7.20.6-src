package com.blued.community.ui.event.vm;

import android.os.Bundle;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.ui.event.model.EventMemberModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/vm/EventMemberExamineViewModel.class */
public final class EventMemberExamineViewModel extends BaseListViewModel<EventMemberModel> {

    /* renamed from: a  reason: collision with root package name */
    private String f19586a = "";
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private int f19587c;
    private int d;

    public final String a() {
        return this.f19586a;
    }

    public final int b() {
        return this.f19587c;
    }

    public final int c() {
        return this.d;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    public void init(Bundle bundle) {
        super.init(bundle);
        if (bundle != null) {
            String string = bundle.getString("event_id", "");
            Intrinsics.c(string, "arguments.getString(Even…nts.DataKey.EVENT_ID, \"\")");
            this.f19586a = string;
            String string2 = bundle.getString("event_uid", "");
            Intrinsics.c(string2, "arguments.getString(Even…ts.DataKey.EVENT_UID, \"\")");
            this.b = string2;
            this.f19587c = bundle.getInt("event_quota_num", 0);
            this.d = bundle.getInt("verify_type", 0);
        }
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        if (this.d == 1) {
            EventHttpUtils.f19079a.b(new BluedUIHttpResponse<BluedEntityA<EventMemberModel>>() { // from class: com.blued.community.ui.event.vm.EventMemberExamineViewModel$requestData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(null);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<EventMemberModel> result) {
                    Intrinsics.e(result, "result");
                    EventMemberExamineViewModel.this.loadListSucceed(result.data, result.hasMore());
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish(boolean z) {
                    super.onUIFinish(z);
                    if (z) {
                        return;
                    }
                    EventMemberExamineViewModel.this.loadListFailed();
                }
            }, this.f19586a, getMPage(), (IRequestHost) null);
        } else {
            EventHttpUtils.f19079a.a(new BluedUIHttpResponse<BluedEntityA<EventMemberModel>>() { // from class: com.blued.community.ui.event.vm.EventMemberExamineViewModel$requestData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(null);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<EventMemberModel> result) {
                    Intrinsics.e(result, "result");
                    EventMemberExamineViewModel.this.loadListSucceed(result.data, result.hasMore());
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish(boolean z) {
                    super.onUIFinish(z);
                    if (z) {
                        return;
                    }
                    EventMemberExamineViewModel.this.loadListFailed();
                }
            }, this.f19586a, getMPage(), (IRequestHost) null);
        }
    }
}
