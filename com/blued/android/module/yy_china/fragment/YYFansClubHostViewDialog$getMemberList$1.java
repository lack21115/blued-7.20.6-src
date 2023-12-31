package com.blued.android.module.yy_china.fragment;

import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.adapter.FansClubAdapter;
import com.blued.android.module.yy_china.databinding.DialogFansClubHostViewBinding;
import com.blued.android.module.yy_china.model.YYClubRankMemberModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYFansClubHostViewDialog$getMemberList$1.class */
public final class YYFansClubHostViewDialog$getMemberList$1 extends BluedUIHttpResponse<BluedEntityA<YYClubRankMemberModel>> {
    final /* synthetic */ YYFansClubHostViewDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYFansClubHostViewDialog$getMemberList$1(YYFansClubHostViewDialog yYFansClubHostViewDialog, ActivityFragmentActive activityFragmentActive) {
        super(activityFragmentActive);
        this.a = yYFansClubHostViewDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYFansClubHostViewDialog this$0) {
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding;
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.e(this$0, "this$0");
        dialogFansClubHostViewBinding = this$0.c;
        if (dialogFansClubHostViewBinding == null || (smartRefreshLayout = dialogFansClubHostViewBinding.e) == null) {
            return;
        }
        smartRefreshLayout.b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<YYClubRankMemberModel> bluedEntityA) {
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding;
        SmartRefreshLayout smartRefreshLayout;
        int i;
        FansClubAdapter fansClubAdapter;
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding2;
        SmartRefreshLayout smartRefreshLayout2;
        int i2;
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding3;
        SmartRefreshLayout smartRefreshLayout3;
        FansClubAdapter fansClubAdapter2;
        if (bluedEntityA == null || !bluedEntityA.hasData()) {
            dialogFansClubHostViewBinding = this.a.c;
            if (dialogFansClubHostViewBinding == null || (smartRefreshLayout = dialogFansClubHostViewBinding.e) == null) {
                return;
            }
            smartRefreshLayout.b(false);
            return;
        }
        i = this.a.e;
        if (i <= 1) {
            fansClubAdapter2 = this.a.d;
            if (fansClubAdapter2 != null) {
                fansClubAdapter2.setNewData(bluedEntityA.data);
            }
        } else {
            fansClubAdapter = this.a.d;
            if (fansClubAdapter != null) {
                fansClubAdapter.addData(bluedEntityA.data);
            }
        }
        if (!bluedEntityA.hasMore()) {
            dialogFansClubHostViewBinding2 = this.a.c;
            if (dialogFansClubHostViewBinding2 == null || (smartRefreshLayout2 = dialogFansClubHostViewBinding2.e) == null) {
                return;
            }
            smartRefreshLayout2.b(false);
            return;
        }
        YYFansClubHostViewDialog yYFansClubHostViewDialog = this.a;
        i2 = yYFansClubHostViewDialog.e;
        yYFansClubHostViewDialog.e = i2 + 1;
        dialogFansClubHostViewBinding3 = this.a.c;
        if (dialogFansClubHostViewBinding3 == null || (smartRefreshLayout3 = dialogFansClubHostViewBinding3.e) == null) {
            return;
        }
        smartRefreshLayout3.b(true);
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public boolean onUIFailure(int i, String str, String str2) {
        Handler n = AppInfo.n();
        final YYFansClubHostViewDialog yYFansClubHostViewDialog = this.a;
        n.post(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFansClubHostViewDialog$getMemberList$1$LoSL7L8AtA8c_vI-T-NIXe24iA8
            @Override // java.lang.Runnable
            public final void run() {
                YYFansClubHostViewDialog$getMemberList$1.a(YYFansClubHostViewDialog.this);
            }
        });
        return super.onUIFailure(i, str, str2);
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public void onUIFinish() {
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding;
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding2;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        super.onUIFinish();
        dialogFansClubHostViewBinding = this.a.c;
        if (dialogFansClubHostViewBinding != null && (smartRefreshLayout2 = dialogFansClubHostViewBinding.e) != null) {
            smartRefreshLayout2.h();
        }
        dialogFansClubHostViewBinding2 = this.a.c;
        if (dialogFansClubHostViewBinding2 == null || (smartRefreshLayout = dialogFansClubHostViewBinding2.e) == null) {
            return;
        }
        smartRefreshLayout.g();
    }
}
