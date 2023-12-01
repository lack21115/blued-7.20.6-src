package com.blued.android.module.yy_china.fragment;

import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.adapter.FansClubAdapter;
import com.blued.android.module.yy_china.databinding.DialogFansClubAudienceViewBinding;
import com.blued.android.module.yy_china.model.YYClubRankMemberModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYFansClubAudienceViewDialog$getMemberList$1.class */
public final class YYFansClubAudienceViewDialog$getMemberList$1 extends BluedUIHttpResponse<BluedEntityA<YYClubRankMemberModel>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ YYFansClubAudienceViewDialog f17228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYFansClubAudienceViewDialog$getMemberList$1(YYFansClubAudienceViewDialog yYFansClubAudienceViewDialog, ActivityFragmentActive activityFragmentActive) {
        super(activityFragmentActive);
        this.f17228a = yYFansClubAudienceViewDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYFansClubAudienceViewDialog this$0) {
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding;
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.e(this$0, "this$0");
        dialogFansClubAudienceViewBinding = this$0.f17226c;
        if (dialogFansClubAudienceViewBinding == null || (smartRefreshLayout = dialogFansClubAudienceViewBinding.j) == null) {
            return;
        }
        smartRefreshLayout.l(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<YYClubRankMemberModel> bluedEntityA) {
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding;
        SmartRefreshLayout smartRefreshLayout;
        int i;
        FansClubAdapter fansClubAdapter;
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding2;
        SmartRefreshLayout smartRefreshLayout2;
        int i2;
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding3;
        SmartRefreshLayout smartRefreshLayout3;
        FansClubAdapter fansClubAdapter2;
        if (bluedEntityA == null || !bluedEntityA.hasData()) {
            dialogFansClubAudienceViewBinding = this.f17228a.f17226c;
            if (dialogFansClubAudienceViewBinding == null || (smartRefreshLayout = dialogFansClubAudienceViewBinding.j) == null) {
                return;
            }
            smartRefreshLayout.l(false);
            return;
        }
        i = this.f17228a.e;
        if (i <= 1) {
            fansClubAdapter2 = this.f17228a.d;
            if (fansClubAdapter2 != null) {
                fansClubAdapter2.setNewData(bluedEntityA.data);
            }
        } else {
            fansClubAdapter = this.f17228a.d;
            if (fansClubAdapter != null) {
                fansClubAdapter.addData((Collection) bluedEntityA.data);
            }
        }
        if (!bluedEntityA.hasMore()) {
            dialogFansClubAudienceViewBinding2 = this.f17228a.f17226c;
            if (dialogFansClubAudienceViewBinding2 == null || (smartRefreshLayout2 = dialogFansClubAudienceViewBinding2.j) == null) {
                return;
            }
            smartRefreshLayout2.l(false);
            return;
        }
        YYFansClubAudienceViewDialog yYFansClubAudienceViewDialog = this.f17228a;
        i2 = yYFansClubAudienceViewDialog.e;
        yYFansClubAudienceViewDialog.e = i2 + 1;
        dialogFansClubAudienceViewBinding3 = this.f17228a.f17226c;
        if (dialogFansClubAudienceViewBinding3 == null || (smartRefreshLayout3 = dialogFansClubAudienceViewBinding3.j) == null) {
            return;
        }
        smartRefreshLayout3.l(true);
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public boolean onUIFailure(int i, String str, String str2) {
        Handler n = AppInfo.n();
        final YYFansClubAudienceViewDialog yYFansClubAudienceViewDialog = this.f17228a;
        n.post(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFansClubAudienceViewDialog$getMemberList$1$tdXUKV0zdZVt0P9pBJdRFw9ykeQ
            @Override // java.lang.Runnable
            public final void run() {
                YYFansClubAudienceViewDialog$getMemberList$1.a(YYFansClubAudienceViewDialog.this);
            }
        });
        return super.onUIFailure(i, str, str2);
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public void onUIFinish() {
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding;
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding2;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        super.onUIFinish();
        dialogFansClubAudienceViewBinding = this.f17228a.f17226c;
        if (dialogFansClubAudienceViewBinding != null && (smartRefreshLayout2 = dialogFansClubAudienceViewBinding.j) != null) {
            smartRefreshLayout2.h();
        }
        dialogFansClubAudienceViewBinding2 = this.f17228a.f17226c;
        if (dialogFansClubAudienceViewBinding2 == null || (smartRefreshLayout = dialogFansClubAudienceViewBinding2.j) == null) {
            return;
        }
        smartRefreshLayout.j();
    }
}
