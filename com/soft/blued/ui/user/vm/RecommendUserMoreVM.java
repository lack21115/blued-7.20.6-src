package com.soft.blued.ui.user.vm;

import android.net.wifi.WifiEnterpriseConfig;
import android.os.Bundle;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.model.UserFindResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/RecommendUserMoreVM.class */
public final class RecommendUserMoreVM extends BaseListViewModel<UserFindResult> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f20717a;
    private String b;

    public final void a(IRequestHost iRequestHost) {
        this.f20717a = iRequestHost;
    }

    public void init(Bundle bundle) {
        String string;
        super.init(bundle);
        if (bundle == null) {
            string = "";
        } else {
            string = bundle.getString(WifiEnterpriseConfig.PRIVATE_KEY_ID_KEY);
            if (string == null) {
                string = "";
            }
        }
        this.b = string;
    }

    public void requestData() {
        final IRequestHost iRequestHost = this.f20717a;
        BluedUIHttpResponse<BluedEntityA<UserFindResult>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<UserFindResult>>(iRequestHost) { // from class: com.soft.blued.ui.user.vm.RecommendUserMoreVM$requestData$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserFindResult> bluedEntityA) {
                Intrinsics.e(bluedEntityA, "result");
                RecommendUserMoreVM.this.loadListSucceed(bluedEntityA.data, bluedEntityA.hasMore());
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                RecommendUserMoreVM.this.loadListFailed();
            }
        };
        IRequestHost iRequestHost2 = this.f20717a;
        String str = this.b;
        String str2 = str;
        if (str == null) {
            Intrinsics.c("uid");
            str2 = null;
        }
        UserHttpUtils.a(bluedUIHttpResponse, iRequestHost2, str2, String.valueOf(getMPage()), String.valueOf(getMPageSize()));
    }
}
